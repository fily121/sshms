package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import java.util.List;

public interface ISgdxxService extends IBaseService<Sgdxx> {

    int deleteByPrimaryKey(String id);

    int insert(Sgdxx record);

    int insertSelective(Sgdxx record);

    Sgdxx selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sgdxx record);

    int updateByPrimaryKey(Sgdxx record);

    List<String> findOpenIdByGcdId(String id);

    List<SgdxxDetail> findAllForPage(int page, int rows, String searchKey);

    Sgdxx selectBySgdmc(String sgdmc);

    SgdxxDetail selectByCph(String cph);
}
