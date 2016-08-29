package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Message;

public interface IMessageService extends IBaseService<Message> {

    int deleteByPrimaryKey(String id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}
