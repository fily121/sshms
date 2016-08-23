package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Sgdxx;
import java.util.List;

public interface SgdxxMapper {

    int deleteByPrimaryKey(String id);

    int insert(Sgdxx record);

    int insertSelective(Sgdxx record);

    Sgdxx selectByPrimaryKey(String id);

    List<Sgdxx> findAll();

    int updateByPrimaryKeySelective(Sgdxx record);

    int updateByPrimaryKey(Sgdxx record);

    List<String> findUserIdByGcdId();
}
