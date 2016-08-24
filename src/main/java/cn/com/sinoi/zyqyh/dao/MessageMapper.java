package cn.com.sinoi.zyqyh.dao;

import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.Message;
import java.util.List;

public interface MessageMapper {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKeyWithBLOBs(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> findByCondition(SearchParams params);
}
