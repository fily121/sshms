package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.GzzdMapper;
import cn.com.sinoi.zyqyh.service.IGzzdService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Gzzd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service("gzzdService")
public class GzzdServiceImpl extends BaseServiceImpl<Gzzd> implements IGzzdService {

    @Autowired
    private GzzdMapper gzzdMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return this.gzzdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Gzzd record) {
        return this.gzzdMapper.insert(record);
    }

    @Override
    public int insertSelective(Gzzd record) {
        return this.gzzdMapper.insertSelective(record);
    }

    @Override
    public Gzzd selectByPrimaryKey(String id) {
        return this.gzzdMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Gzzd record) {
        return this.gzzdMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Gzzd record) {
        return this.gzzdMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Gzzd> findAllForPage(int page, int rows, String searchKey) {
        Map<String, Object> param = new HashMap<>();
        param.put("limit1", (page - 1) * rows);
        param.put("limit2", rows);
        param.put("searchKey", searchKey);
        return gzzdMapper.findAllForPage(param);
    }

    @Override
    public List<Gzzd> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gzzd> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Gzzd> findAllForLimit(String keywords, String userId) {
        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);
        param.put("keywords", keywords);
        return gzzdMapper.findAllForLimit(param);
    }
}
