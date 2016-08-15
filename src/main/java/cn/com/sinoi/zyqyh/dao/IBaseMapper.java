package cn.com.sinoi.zyqyh.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseMapper<T, ID extends Serializable> {

	int deleteByPrimaryKey(ID id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(ID id);
    
    List<T> findAll();

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);
}
