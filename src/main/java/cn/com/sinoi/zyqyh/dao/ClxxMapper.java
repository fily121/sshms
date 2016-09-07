package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Clxx;
import java.util.List;

public interface ClxxMapper {

    int deleteByPrimaryKey(String id);

    int insert(Clxx record);

    int insertSelective(Clxx record);

    Clxx selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Clxx record);

    int updateByPrimaryKey(Clxx record);

    public List<Clxx> findAll();
}
