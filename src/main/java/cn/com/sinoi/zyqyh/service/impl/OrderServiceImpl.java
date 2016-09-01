package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.service.IOrderService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements IOrderService {

    @Override
    public List<Order> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
