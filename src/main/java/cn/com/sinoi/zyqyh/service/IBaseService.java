package cn.com.sinoi.zyqyh.service;

import java.util.List;

import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;

public interface IBaseService<T> {

	public Pagination<T> findPageByCondition(SearchParams params) throws Exception;
	    
	public List<T> findByCondition(SearchParams params) throws Exception;
	    
	public List<T> findAll() throws Exception;

}
