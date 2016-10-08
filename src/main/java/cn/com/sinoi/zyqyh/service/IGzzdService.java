package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Gzzd;
import java.util.List;

public interface IGzzdService extends IBaseService<Gzzd> {

    int deleteByPrimaryKey(String id);

    int insert(Gzzd record);

    int insertSelective(Gzzd record);

    Gzzd selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Gzzd record);

    int updateByPrimaryKey(Gzzd record);

    List<Gzzd> findAllForPage(int page, int rows, String searchKey);

    public List<Gzzd> findAllForLimit(String keywords, String userId);
}
