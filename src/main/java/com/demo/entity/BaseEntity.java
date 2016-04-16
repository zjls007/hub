package com.demo.entity;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {

	@Id
	private Integer id;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 最后修改时间
	 */
	private String lastUpd;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getLastUpd() {
		return lastUpd;
	}

	public void setLastUpd(String lastUpd) {
		this.lastUpd = lastUpd;
	}
	 
}
