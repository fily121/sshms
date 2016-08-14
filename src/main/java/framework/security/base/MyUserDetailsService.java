package framework.security.base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.memory.UserMap;


import com.user.dao.UserDaoI;
import com.user.dao.impl.UserDaoImpl;
import com.user.model.PubUsers;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.authority.GrantedAuthorityImpl;

public class MyUserDetailsService implements UserDetailsService{

	private UserDaoImpl userDao;
	

	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		    Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();  

		    PubUsers users=userDao.userInfo(username);
		/*    if(users.getAccount()==null){
		    	throw new AccessDeniedException("账号或密码错误！");         
		    }*/
	 		
		    /*不要使用GrantedAuthorityImpl，官网说这个已过期了，
		     * SimpleGrantedAuthority代替GrantedAuthorityImpl，赋予一个角色（即权限）
		     * 
		     * */
		    List<String> list =  userDao.findAuthByUsername(username); 
	        for (int i = 0; i < list.size(); i++) {  
        
	        	auths.add(new SimpleGrantedAuthority(list.get(i)));
	        	//auths.add(new GrantedAuthorityImpl(list.get(i)));  
	            
	        }  
		    		    		   		    
			boolean enables = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
				
			//System.out.println(users.getUserName());
			//System.out.println(users.getUserPassword());
			
			//封装成spring security的User
			User userdetail = new User(users.getUserAccount(), users.getUserPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, auths);
						
			return userdetail;
	}

	public UserDaoImpl getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
		
}
