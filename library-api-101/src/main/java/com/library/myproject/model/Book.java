package com.library.myproject.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "books")
@SuppressWarnings("serial")
@NamedStoredProcedureQuery(name = "test2" , procedureName = "annualReport")
public class Book implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	private Integer id;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "price")
	private String price;

	@Column(name = "sold_status")
	private Boolean soldStatus;

	@Column(name = "in_out")
	private Boolean avaibility;

	@Column(name = "added_date")
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	@Column(name = "rented_date")
	@Temporal(TemporalType.DATE)
	private Date rentedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	@JoinColumn(name = "book_category_id")
	private BookCategory bookCategory;

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Boolean getSold() {
		return soldStatus;
	}

	public void setSold(Boolean soldStatus) {
		this.soldStatus = soldStatus;
	}

	public Boolean getAvaibility() {
		return avaibility;
	}

	public void setAvaibility(Boolean avaibility) {
		this.avaibility = avaibility;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Date getRentedDate() {
		return rentedDate;
	}

	public void setRentedDate(Date rentedDate) {
		this.rentedDate = rentedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getbookName() {
		return bookName;
	}

	public void setbookName(String bookName) {
		this.bookName = bookName;
	}

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bookName, int bookCategoryId, String price, Boolean soldStatus, Boolean avaibility) {
		this.id = id;
		this.bookName = bookName;
		this.price = price;
		this.soldStatus = soldStatus;
		this.avaibility = avaibility;
		this.bookCategory = new BookCategory(bookCategoryId, "");
	}

}
