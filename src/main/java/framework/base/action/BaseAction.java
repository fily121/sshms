package framework.base.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import framework.base.model.GridModel;
/*
 * @ParentPackage("basePackage")
@Namespace("/")
 */
public class BaseAction extends ActionSupport {

	public static final Logger logger=Logger.getLogger(BaseAction.class); 
	
	// datagrid的属性
	private int page;
	private int rows;
	private String sort;
	private String order;
		
	protected GridModel gridModel =new GridModel();

	protected Map<String,String> param =new HashMap<String,String>();
	
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		gridModel.setPage(page);
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		gridModel.setRows(rows);
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		gridModel.setSort(sort);
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {		
		gridModel.setOrder(order);
		this.order = order;
	}

	public Map<String, String> getParam() {
		return param;
	}

	public void setParam(Map<String, String> param) {
		this.param = param;
	}

	
    
}
