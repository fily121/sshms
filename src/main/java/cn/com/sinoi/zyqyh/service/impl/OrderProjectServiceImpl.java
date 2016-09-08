package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.OrderProjectMapper;
import cn.com.sinoi.zyqyh.service.IOrderProjectService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.OrderProjectKey;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderProjectService")
public class OrderProjectServiceImpl extends BaseServiceImpl<OrderProjectKey> implements IOrderProjectService {

    @Autowired
    private OrderProjectMapper orderProjectMapper;

    @Override
    public List<OrderProjectKey> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderProjectKey> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByOrderId(String orderId) {
        orderProjectMapper.deleteByOrderId(orderId);
    }

    @Override
    public void save(OrderProjectKey key) {
        orderProjectMapper.insert(key);
    }

    @Override
    public List<String> selectProjectIdByOrderId(String id) {
        return orderProjectMapper.selectProjectIdByOrderId(id);
    }

}
