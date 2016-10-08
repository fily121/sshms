package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.vo.Gzzd;
import java.util.List;
import java.util.Map;

public interface GzzdMapper {

    int deleteByPrimaryKey(String id);

    int insert(Gzzd record);

    int insertSelective(Gzzd record);

    Gzzd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Gzzd record);

    int updateByPrimaryKey(Gzzd record);

    List<Gzzd> findAllForPage(Map<String, Object> param);

    List<Gzzd> findAllForLimit(Map<String, String> param);
}
