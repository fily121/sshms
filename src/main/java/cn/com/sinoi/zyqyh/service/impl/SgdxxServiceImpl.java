package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.SgdxxMapper;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service("sgdxxService")
public class SgdxxServiceImpl extends BaseServiceImpl<Sgdxx> implements ISgdxxService {

    @Autowired
    private SgdxxMapper sgdxxMapper;

    @Override
    public List<Sgdxx> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Sgdxx> findAll() throws Exception {
        return sgdxxMapper.findAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insert(Sgdxx record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertSelective(Sgdxx record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sgdxx selectByPrimaryKey(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateByPrimaryKeySelective(Sgdxx record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateByPrimaryKey(Sgdxx record) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
