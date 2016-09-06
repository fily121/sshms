package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.Sgdxx;

@lombok.Getter
@lombok.Setter
public class OrderDetail {

    private Order order;
    private Sgdxx sgdxx;
}
