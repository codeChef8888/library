package com.library.myproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;


@Entity
@Table(name="report")
@SuppressWarnings("serial")
@NamedStoredProcedureQueries({@NamedStoredProcedureQuery(name="reportProcedure",procedureName = "annualReport")})
public class Report implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_report")
	private Integer id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name="sold_copies")
	private String soldCopies;
	
	@Column(name = "revenue")
	private String revenue;
	
	@Column(name = "total_revenue")
	private String totalRevenue;
	
	public Report() {
		// TODO Auto-generated constructor stub
	}
	
	public Report(String category,String soldCopies,String revenue) {
		
		this.category=category;
		this.soldCopies=soldCopies;
		this.revenue=revenue;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSoldCopies() {
		return soldCopies;
	}

	public void setSoldCopies(String soldCopies) {
		this.soldCopies = soldCopies;
	}

	public String getRevenue() {
		return revenue;
	}

	public void setRevenue(String revenue) {
		this.revenue = revenue;
	}

	public String getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(String totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	

}
