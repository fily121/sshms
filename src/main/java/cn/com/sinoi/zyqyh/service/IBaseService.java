package cn.com.sinoi.zyqyh.service;

import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import java.util.List;

public interface IBaseService<T> {

    Pagination<T> findPageByCondition(SearchParams params) throws Exception;

    List<T> findByCondition(SearchParams params) throws Exception;

    List<T> findAll() throws Exception;

}
