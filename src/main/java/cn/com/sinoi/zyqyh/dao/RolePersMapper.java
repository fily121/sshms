package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.RolePersKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePersMapper {

    int deleteByPrimaryKey(RolePersKey key);

    int insert(RolePersKey record);

    int insertSelective(RolePersKey record);

    void deleteByRoleId(String roleId);

}
