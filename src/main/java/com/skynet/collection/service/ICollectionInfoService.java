package com.skynet.collection.service;

import com.skynet.collection.vo.CollectionInfo;

public interface ICollectionInfoService extends IBaseService<CollectionInfo> {

	CollectionInfo selectByIdCardNo(String idCardNo) throws Exception; // 根据身份证号查询采集数据
	
	CollectionInfo selectByUserId(String userId) throws Exception; // 根据UserId查询采集数据
}
