/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.CllqGlMapper;
import cn.com.sinoi.zyqyh.dao.ClxxMapper;
import cn.com.sinoi.zyqyh.service.IClglService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.CllqGl;
import cn.com.sinoi.zyqyh.vo.Clxx;
import cn.com.sinoi.zyqyh.vo.relate.ClglDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LDNS 杜保軍
 */
@Service("clglService")
public class ClglServiceImpl extends BaseServiceImpl<CllqGl> implements IClglService {

    @Autowired
    private CllqGlMapper cllqglMapper;
    @Autowired
    private ClxxMapper clxxMapper;

    @Override
    public List<CllqGl> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CllqGl> findAll() throws Exception {
        return cllqglMapper.findAll();
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.cllqglMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CllqGl record) {
        return this.cllqglMapper.insert(record);
    }

    @Override
    public int insertSelective(CllqGl record) {
        return this.cllqglMapper.insertSelective(record);
    }

    @Override
    public CllqGl selectByPrimaryKey(String id) {
        return this.cllqglMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CllqGl record) {
        return this.cllqglMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CllqGl record) {
        return this.cllqglMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ClglDetail> getClglDetailList(Integer page, Integer rows) {
        Map<String, Integer> param = new HashMap<>();
        param.put("limit1", (page - 1) * rows);
        param.put("limit2", rows);
        return this.cllqglMapper.findAllForPage(param);
    }

    @Override
    public List<Clxx> findAllClxx() {
        return this.clxxMapper.findAll();
    }

    @Override
    public Clxx selectClxxByPrimaryKey(String id) {
        return this.clxxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteClxxByPrimaryKey(String id) {
        return this.clxxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertClxx(Clxx clxx) {
        return this.clxxMapper.insert(clxx);
    }

    @Override
    public int updateClxxByPrimaryKeySelective(Clxx clxx) {
        return this.clxxMapper.updateByPrimaryKeySelective(clxx);
    }

}
