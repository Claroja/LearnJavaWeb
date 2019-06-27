package web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import web.model.Permission;

public interface PermissionMapper {

	@Select(" select * from rabc_permission ")
	List<Permission> findAllPermission();

}
