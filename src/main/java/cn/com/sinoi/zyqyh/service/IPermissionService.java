package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Permission;
import java.util.List;

public interface IPermissionService extends IBaseService<Permission> {

    List<Permission> selectPermissionsByRoleId(String roleId) throws Exception;
}
