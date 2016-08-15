package cn.com.sinoi.zyqyh.dao;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.vo.CollectionInfo;

@Repository
public interface CollectionMapper {
	
    int deleteByPrimaryKey(String cId);

    int insert(CollectionInfo record);

    int insertSelective(CollectionInfo record);

    CollectionInfo selectByPrimaryKey(String cId);
    
    CollectionInfo selectByIdCardNo(String idCardNo);

    int updateByPrimaryKeySelective(CollectionInfo record);

    int updateByPrimaryKey(CollectionInfo record);
    
    CollectionInfo selectByUserId(String userId);
}