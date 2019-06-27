package web.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import web.model.Permission;
import web.model.User;
import web.mapper.UserMapper;

@Component
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;

	// 查询用户信息
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 1.根据用户查询用户信息
		User user = userMapper.findByUsername(username);
		// 2.security框架会自动判断用户密码是否正确,早SecurityConfig里配置
		// 3.根据用户查询用户对应权限
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();//在用户模型里
		List<Permission> listPermission = userMapper.findPermissionByUsername(username);
		for (Permission permission : listPermission) {
			authorities.add(new SimpleGrantedAuthority(permission.getPermTag()));
		}
		user.setAuthorities(authorities);
		return user;
	}

}
