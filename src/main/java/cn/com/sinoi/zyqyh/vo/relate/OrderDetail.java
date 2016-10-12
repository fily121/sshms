package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.Sgdxx;

public class OrderDetail {

    private Order order;
    private Sgdxx sgdxx;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Sgdxx getSgdxx() {
        return sgdxx;
    }

    public void setSgdxx(Sgdxx sgdxx) {
        this.sgdxx = sgdxx;
    }

}
