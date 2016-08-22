package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.vo.Sgdxx;

public interface ISgdxxService extends IBaseService<Sgdxx> {

    int deleteByPrimaryKey(String id);

    int insert(Sgdxx record);

    int insertSelective(Sgdxx record);

    Sgdxx selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sgdxx record);

    int updateByPrimaryKey(Sgdxx record);
}
