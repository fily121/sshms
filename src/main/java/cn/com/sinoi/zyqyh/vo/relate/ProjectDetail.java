package cn.com.sinoi.zyqyh.vo.relate;

import cn.com.sinoi.zyqyh.vo.Order;
import cn.com.sinoi.zyqyh.vo.Project;
import java.util.List;

@lombok.Getter
@lombok.Setter
public class ProjectDetail {

    private Project project;
    private List<Order> orderList;
}
