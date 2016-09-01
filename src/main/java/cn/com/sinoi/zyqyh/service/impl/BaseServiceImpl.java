package cn.com.sinoi.zyqyh.service.impl;

import cn.com.sinoi.zyqyh.service.IBaseService;
import cn.com.sinoi.zyqyh.utils.Pagination;
import cn.com.sinoi.zyqyh.utils.SearchParams;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    /**
     * 根据传入的 查询分页 参数进行分页查询
     *
     * @param params
     * @return
     * @throws Exception
     */
    public Pagination<T> findPageByCondition(SearchParams params)
            throws Exception {
        if (params == null) {
            throw new Exception("cn.com.sinoi.zyqyh.utils.SearchParams 查询分页参数不能为空!");
        }
        Page<T> page = PageHelper.startPage(params.getPage(), params.getRows());
        if (params.getSearchParams() != null || (params.getSort() != null && params.getOrder() != null)) {
            findByCondition(params);
        } else {
            findAll();
        }
        Pagination<T> pi = new Pagination<T>(page);
        return pi;
    }

}
