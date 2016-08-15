package cn.com.sinoi.zyqyh.dao;

import org.springframework.stereotype.Repository;

import cn.com.sinoi.zyqyh.vo.Org;

@Repository
public interface OrgMapper {
	
    int deleteByPrimaryKey(String orgId);

    int insert(Org record);

    int insertSelective(Org record);

    Org selectByPrimaryKey(String orgId);

    int updateByPrimaryKeySelective(Org record);

    int updateByPrimaryKey(Org record);
}