package com.maduranga.posbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category {

	@Id
	private String cid;
	private String cname;

	public Category() {
	}

	public Category(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}
