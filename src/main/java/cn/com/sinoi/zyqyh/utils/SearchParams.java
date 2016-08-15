package cn.com.sinoi.zyqyh.utils;

import java.util.HashMap;
import java.util.Map;

public class SearchParams implements java.io.Serializable {

	private int page = 1;// 当前页
	
	private int rows = 10;// 每页显示记录数
	
	private String sort;// 排序字段
	
	private String order;// asc/desc
	
	private Map<String, Object> searchParams = new HashMap<String, Object>(); // 查询参数

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page != 0) {
			this.page = page;
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		if (rows != 0)  {
			this.rows = rows;
		}
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Map<String, Object> getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(Map<String, Object> searchParams) {
		this.searchParams = searchParams;
	}
	
}
