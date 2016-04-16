package com.demo.bean;

import java.util.Collection;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zxj 2015-5-7 上午11:58:06
 *	
 * easyui分页工具
 * 
 */
public class Pagination {

	/**
	 * 一页几条数据
	 */
//	@JsonIgnore
	private Long rows;
	
	/**
	 * 当前第几页
	 */
//	@JsonIgnore
	private Long page;
	
	private Long total;
	
//	@JsonProperty("rows")
	private Collection<?> collection;
	
	public Long getFirstResult() {
		return (page - 1) * rows;
	}
	
	public Long getMaxResults() {
		return rows;
	}

	public Long getRows() {
		return rows;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	public Long getPage() {
		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Collection<?> getCollection() {
		return collection;
	}

	public void setCollection(Collection<?> collection) {
		this.collection = collection;
	}
	
}
