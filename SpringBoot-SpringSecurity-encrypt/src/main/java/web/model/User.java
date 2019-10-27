package web.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

// 用户信息表
@Data
public class User implements UserDetails {
	//UserDetails接口里定义了security框架里需要用到的字段,比如enable,accountNonExpired等,必须要写,框架直接会用到这些

	private Integer id;
	private String username;
	private String realname;
	private String password;
	private Date createDate;
	private Date lastLoginTime;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	// 用户所有权限
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

}
