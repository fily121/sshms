package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import java.util.List;

public interface IOrderService extends IBaseService<Order> {

    List<OrderDetail> findAllForPage(int page, int rows, String searchKey);

    Order selectByPrimaryKey(String id);

    OrderDetail selectByOrderId(String id);

    void updateByPrimaryKeySelective(Order order);

    void insert(Order order);

    public List<OrderDetail> findAllForLimit(String keywords, String userId);
}
