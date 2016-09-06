package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import java.util.List;

public interface IOrderService extends IBaseService<Order> {

    List<OrderDetail> findAllForPage(int page, int rows, String searchKey);

    Order selectByPrimaryKey(String id);

    OrderDetail selectByOrderId(String id);
}
