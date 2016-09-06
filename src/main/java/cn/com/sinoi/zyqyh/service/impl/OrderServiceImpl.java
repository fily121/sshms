package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.dao.OrderMapper;
import cn.com.sinoi.zyqyh.service.IOrderService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import com.alibaba.druid.util.StringUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl extends BaseServiceImpl<Order> implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findByCondition(SearchParams params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetail> findAllForPage(int page, int rows, String searchKey) {
        Map<String, Object> param = new HashMap<>();
        param.put("limit1", (page - 1) * rows);
        param.put("limit2", rows);
        param.put("searchKey", StringUtils.isEmpty(searchKey) ? null : searchKey);
        return orderMapper.findAllForPage(param);
    }

    @Override
    public Order selectByPrimaryKey(String id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public OrderDetail selectByOrderId(String id) {
        return orderMapper.selectByOrderId(id);
    }
}
