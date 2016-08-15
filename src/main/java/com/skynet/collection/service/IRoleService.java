package com.skynet.collection.service;

import java.util.List;
import com.skynet.collection.vo.Role;

public interface IRoleService extends IBaseService<Role> {

	List<Role> selectRolesByRoleId(String roleId) throws Exception;
}
