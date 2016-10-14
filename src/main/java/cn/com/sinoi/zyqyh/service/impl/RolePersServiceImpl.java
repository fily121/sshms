package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.RolePersMapper;
import cn.com.sinoi.zyqyh.service.IRolePersService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.RolePersKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rolePersService")
public class RolePersServiceImpl extends BaseServiceImpl<RolePersKey> implements IRolePersService {

    @Autowired
    private RolePersMapper rolePersMapper;

    @Override
    public List<RolePersKey> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RolePersKey> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByRoleId(String roleId) {
        rolePersMapper.deleteByRoleId(roleId);
    }

    @Override
    public void insert(RolePersKey persKey) {
        rolePersMapper.insert(persKey);
    }

}
