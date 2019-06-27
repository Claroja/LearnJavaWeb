package web.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.mapper.PermissionMapper;
import web.model.Permission;
import web.security.MyUserDetailService;
import web.utils.MD5Util;

import java.util.List;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PermissionMapper permissionMapper;
	@Autowired
	private MyUserDetailService myUserDetailService;

	// 设置用户账号密码与权限
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// claroja只有showOrder权限
		// solace有addOrder,updateOrder,deleteOrder权限
//		auth.inMemoryAuthentication().withUser("claroja").password("123456").authorities("showOrder");
//		auth.inMemoryAuthentication().withUser("solace").password("123456").authorities("addOrder","updateOrder","deleteOrder");
		auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {
			//加密的密码与数据库的密码进行比对,encodedPassword是数据库里的密码,rawPassword是表单里的密码
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				String encode = MD5Util.encode((String) rawPassword);//先对表单的密码进行加密
				encodedPassword=encodedPassword.replace("\r\n", "");
				boolean result = encodedPassword.equals(encode);
				return result;
			}
			//对表单密码进行加密
			public String encode(CharSequence rawPassword) {
				return MD5Util.encode((String) rawPassword);
			}
		});
	}
	// 配置权限
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				//将路由和权限进行映射
//				.antMatchers("/showOrder").hasAnyAuthority("showOrder")
//				.antMatchers("/addOrder").hasAnyAuthority("addOrder")
//				.antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
//				.antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
//				//所有的路由都需要登录
//				.antMatchers("/**").fullyAuthenticated().and().formLogin();// httpBasic是alert弹窗的方式，formLogin是表单方式
		List<Permission> listPermission = permissionMapper.findAllPermission();
		for (Permission permission : listPermission) {
			http.authorizeRequests().antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermTag());
		}
		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().formLogin();
	}
}


