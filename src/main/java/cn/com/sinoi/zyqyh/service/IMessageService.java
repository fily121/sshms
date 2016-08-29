package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.relate.MessageExt;
import java.util.List;
import java.util.Map;

public interface IMessageService extends IBaseService<Message> {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<MessageExt> findRelateByCondition(Map<String, Object> map);
}
