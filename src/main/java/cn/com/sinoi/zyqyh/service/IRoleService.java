package cn.com.sinoi.zyqyh.service;

import java.util.List;

import cn.com.sinoi.zyqyh.vo.Role;

public interface IRoleService extends IBaseService<Role> {

	List<Role> selectRolesByRoleId(String roleId) throws Exception;
}
