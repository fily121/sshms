package com.skynet.collection.service;

import java.util.List;
import com.skynet.collection.utils.Pagination;
import com.skynet.collection.utils.SearchParams;

public interface IBaseService<T> {

	public Pagination<T> findPageByCondition(SearchParams params) throws Exception;
	    
	public List<T> findByCondition(SearchParams params) throws Exception;
	    
	public List<T> findAll() throws Exception;

}
