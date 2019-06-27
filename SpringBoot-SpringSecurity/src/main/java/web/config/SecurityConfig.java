package web.config;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	// 设置用户账号密码与权限
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// claroja只有showOrder权限
		// solace有addOrder,updateOrder,deleteOrder权限
		auth.inMemoryAuthentication().withUser("claroja").password("123456").authorities("showOrder");
		auth.inMemoryAuthentication().withUser("solace").password("123456").authorities("addOrder","updateOrder","deleteOrder");
	}
	// 配置权限
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//将路由和权限进行映射
				.antMatchers("/showOrder").hasAnyAuthority("showOrder")
				.antMatchers("/addOrder").hasAnyAuthority("addOrder")
				.antMatchers("/updateOrder").hasAnyAuthority("updateOrder")
				.antMatchers("/deleteOrder").hasAnyAuthority("deleteOrder")
				//所有的路由都需要登录
				.antMatchers("/**").fullyAuthenticated().and().formLogin();// httpBasic是alert弹窗的方式，formLogin是表单方式
	}
	@Bean//做测试用,springsecurity默认是要加密的,这里配置不加密
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}


