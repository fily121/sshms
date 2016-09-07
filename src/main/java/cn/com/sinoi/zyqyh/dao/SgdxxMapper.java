package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Sgdxx;
import cn.com.sinoi.zyqyh.vo.relate.SgdxxDetail;
import java.util.List;
import java.util.Map;

public interface SgdxxMapper {

    int deleteByPrimaryKey(String id);

    int insert(Sgdxx record);

    int insertSelective(Sgdxx record);

    Sgdxx selectByPrimaryKey(String id);

    List<Sgdxx> findAll();

    int updateByPrimaryKeySelective(Sgdxx record);

    int updateByPrimaryKey(Sgdxx record);

    List<String> findOpenIdByGcdId();

    List<SgdxxDetail> findAllForPage(Map<String, Integer> param);

    Sgdxx selectBySgdmc(String sgdmc);

    SgdxxDetail selectByCph(String cph);
}
