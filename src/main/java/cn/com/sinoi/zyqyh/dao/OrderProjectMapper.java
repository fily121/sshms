package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.OrderProjectKey;
import java.util.List;

public interface OrderProjectMapper {

    int deleteByPrimaryKey(OrderProjectKey key);

    int insert(OrderProjectKey record);

    int insertSelective(OrderProjectKey record);

    void deleteByOrderId(String orderId);

    List<String> selectProjectIdByOrderId(String id);
}
