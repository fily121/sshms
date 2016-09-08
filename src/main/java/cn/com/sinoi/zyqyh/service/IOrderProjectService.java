package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.OrderProjectKey;
import java.util.List;

public interface IOrderProjectService extends IBaseService<OrderProjectKey> {

    void deleteByOrderId(String orderId);

    void save(OrderProjectKey key);

    List<String> selectProjectIdByOrderId(String id);

}
