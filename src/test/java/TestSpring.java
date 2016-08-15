import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.user.service.UserService;



public class TestSpring {

	/*
	 * 用junit测试spring配置是否成功
	 */
	
	@Test
	public void TestSpring(){
		/*ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
		UserService us=(UserService) ac.getBean("userService");
		us.test();*/
		
	}

}
