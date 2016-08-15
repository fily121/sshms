package cn.com.sinoi.zyqyh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.sinoi.zyqyh.dao.CollectionMapper;
import cn.com.sinoi.zyqyh.service.ICollectionInfoService;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import cn.com.sinoi.zyqyh.vo.CollectionInfo;

@Service("collectionInfoService")
public class CollectionInfoServiceImpl extends BaseServiceImpl<CollectionInfo> implements ICollectionInfoService {

	@Autowired
	private CollectionMapper collectionMapper;
	
	@Override
	public List<CollectionInfo> findByCondition(SearchParams params) throws Exception {
		return null;
	}

	@Override
	public List<CollectionInfo> findAll() throws Exception {
		return null;
	}

	@Override
	public CollectionInfo selectByIdCardNo(String idCardNo) {
		return this.collectionMapper.selectByIdCardNo(idCardNo);
	}

	@Override
	public CollectionInfo selectByUserId(String userId) throws Exception {
		return this.collectionMapper.selectByUserId(userId);
	}

}
