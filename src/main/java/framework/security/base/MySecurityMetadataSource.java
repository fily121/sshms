package framework.security.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;


import com.user.dao.UserDaoI;

import framework.security.util.UrlPathMatcher;

//1、2、3、4是服务器启动时调用的顺序
public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	/*
	*resourceMap用static声明了，为了避免用户每请求一次都要去数据库读取资源、权限，这里只读取一次，将它保存起来
	*/
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null; 
	
	private UrlPathMatcher urlMatcher = new UrlPathMatcher();
	
	private UserDaoI userDao;

	// 1
	//构造函数，因为服务器启动时会调用这个类，利用构造函数读取所有的url、角色
	public MySecurityMetadataSource() {   
	
		   //初始化，读取数据库所有的url、角色
	       loadResourceDefine();  
	}
	
	//2
	//这个方法应该是要从数据库读取数据的，这里只用来测试
	/*private void loadResourceDefine() {  
		
		System.out.println("metadata : loadResourceDefine");
	      resourceMap = new HashMap<String, Collection<ConfigAttribute>>();           
		  Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();           
		
		*//**
		 * 将这里的new SecurityConfig("ROLE_ADMIN")值改为ROLE_USER，登录成功也不允许访问index.jsp了,
		 * 因为在applicationContext-security.xml设置了只允许角色为ROLE_ADMIN的访问。
		 *  <intercept-url pattern="/**" access="ROLE_ADMIN" />
		 *//*
		  ConfigAttribute ca = new SecurityConfig("ROLE_ADMIN");           
		  atts.add(ca);           
		 
		  //ca为访问的权限，下面为url地址赋予ca中的权限
		  resourceMap.put("/i.jsp", atts);   
		  resourceMap.put("/index.jsp", atts);          
	
    }*/
	
	//这个方法在url请求时才会调用，服务器启动时不会执行这个方法，前提是需要在<http>标签内设置  <custom-filter>标签
	//getAttributes这个方法会根据你的请求路径去获取这个路径应该是有哪些权限才可以去访问。
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
	
		//object getRequestUrl 是获取用户请求的url地址		
		String url = ((FilterInvocation) object).getRequestUrl();   
		
		//resourceMap保存了loadResourceDefine方法加载进来的数据
		Iterator<String> ite = resourceMap.keySet().iterator();   
		
		while (ite.hasNext()) {     
		     
			 //取出resourceMap中读取数据库的url地址
			 String resURL = ite.next();   
		
			 //如果两个 url地址相同，那么将返回resourceMap中对应的权限集合，然后跳转到MyAccessDecisionManager类里的decide方法，再判断权限
			if (urlMatcher.pathMatchesUrl(url, resURL)) {     
			     return resourceMap.get(resURL);   //返回对应的url地址的权限 ，resourceMap是一个主键为地址，值为权限的集合对象
		    }  
		}
		
		//如果上面的两个url地址没有匹配，返回return null，不再调用MyAccessDecisionManager类里的decide方法进行权限验证，代表允许访问页面
		return null;				
	}

	// 4
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
	
		return null;
	}
	
	// 3
	@Override 
	public boolean supports(Class<?> clazz) {
	
		return true;
		
	}
	
	private void loadResourceDefine() {

		//请注意这里读取了spring的xml配置文件，如果改变了spring的xml文件名称，这里也要改变的
		ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml","classpath:spring-hibernate.xml"});
		
		SessionFactory sessionFactory = (SessionFactory) context
                .getBean("sessionFactory");
		
		Session session=(Session) sessionFactory.openSession();
	
	 // 提取系统中的所有权限。
		List<String> auNames =session.createQuery("select roleName from PubRoles").list();
	
		session.close();//取数后将session关闭
		
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		
          for (String auth : auNames) {
            ConfigAttribute ca = new SecurityConfig(auth);
             
            //查出对应的角色的资源
            Query query1=sessionFactory.openSession().createSQLQuery("SELECT resource_string FROM pub_resources WHERE resource_id IN (SELECT resource_id FROM pub_authorities_resources WHERE authority_id IN (SELECT authority_id FROM  pub_roles_authorities WHERE role_id =( SELECT role_id FROM pub_roles  WHERE role_name='"+auth+"')))");
            
    		List<String> list = query1.list();
    		
    		
                       
            for (String res : list) {
                String url = res;
                
                // * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，则要通过该url为key提取出权限集合，将权限增加到权限集合中。                           
                if (resourceMap.containsKey(url)) {

                    Collection<ConfigAttribute> value = resourceMap.get(url); //取出这个url的权限集合
                    value.add(ca);
                    resourceMap.put(url, value);
                } else {
                    Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
                    atts.add(ca);
                    resourceMap.put(url, atts);
                }
            }
        }
	}

	public UserDaoI getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}
	
}
