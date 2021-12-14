package com.maduranga.posbackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

	@Id
	private String pid;
	private String pname;
	private String pdesc;
	private double pprice;
	private String pimgurl;

	@ManyToOne
	private Category category;

	public Product() {

	}

	public Product(String pid, String pname, String pdesc, double pprice, String pimgurl) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pdesc = pdesc;
		this.pprice = pprice;
		this.pimgurl = pimgurl;
		
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public double getPprice() {
		return pprice;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public String getPimgurl() {
		return pimgurl;
	}

	public void setPimgurl(String pimgurl) {
		this.pimgurl = pimgurl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
