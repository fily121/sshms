package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.RolePersKey;

public interface IRolePersService extends IBaseService<RolePersKey> {

    void deleteByRoleId(String roleId);

    void insert(RolePersKey persKey);

}
