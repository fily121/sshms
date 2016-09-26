package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.relate.OrderDetail;
import java.util.List;
import java.util.Map;

public interface OrderMapper {

    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderDetail> findAllForPage(Map<String, Object> param);

    OrderDetail selectByOrderId(String orderId);

    public List<OrderDetail> findAllForLimit(Map<String, String> params);
}
