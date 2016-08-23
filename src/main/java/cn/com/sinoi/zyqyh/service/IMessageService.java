package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Message;
import cn.com.sinoi.zyqyh.vo.Sgdxx;

public interface IMessageService extends IBaseService<Message> {

    int deleteByPrimaryKey(String id);

    int insert(Sgdxx record);

    int insertSelective(Sgdxx record);

    Message selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);
}
