package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.SgdxxMapper;
import cn.com.sinoi.zyqyh.service.ISgdxxService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        return this.sgdxxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sgdxx record) {
        return this.sgdxxMapper.insert(record);
    }

    @Override
    public int insertSelective(Sgdxx record) {
        return this.sgdxxMapper.insertSelective(record);
    }

    @Override
    public Sgdxx selectByPrimaryKey(String id) {
        return this.sgdxxMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sgdxx record) {
        return this.sgdxxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sgdxx record) {
        return this.sgdxxMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> findUserIdByGcdId(String id) {
        return sgdxxMapper.findUserIdByGcdId();
    }

    @Override
    public List<SgdxxDetail> findAllForPage(int page, int rows) {
        Map<String, Integer> param = new HashMap<>();
        param.put("limit1", (page - 1) * rows);
        param.put("limit2", rows);
        return sgdxxMapper.findAllForPage(param);
    }

    @Override
    public Sgdxx selectBySgdmc(String sgdmc) {
        return this.sgdxxMapper.selectBySgdmc(sgdmc);
    }

    @Override
    public Sgdxx selectByCph(String cph) {
        return this.sgdxxMapper.selectByCph(cph);
    }

}
