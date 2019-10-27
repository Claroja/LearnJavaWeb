package web.security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import web.model.User;

@Component
public class MyUserDetailService implements UserDetailsService {

	// 查询用户信息
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1.根据用户查询用户信息
		User user = new User();
		user.setId(1);
		user.setUsername("wang");
		user.setRealname("xiaowang");
		user.setPassword("b791263f2068dce7b82f844058931cf5");
		user.setCreateDate(new Date());
		user.setLastLoginTime(new Date());
		user.setEnabled(true);
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);

		// 2.security框架会自动判断用户密码是否正确,早SecurityConfig里配置
		// 3.根据用户查询用户对应权限
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();//在用户模型里
		authorities.add(new SimpleGrantedAuthority("showOrder"));
		user.setAuthorities(authorities);
		return user;
	}

}
