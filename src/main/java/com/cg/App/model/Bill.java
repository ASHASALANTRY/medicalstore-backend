package com.cg.App.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.cg.App.model.*;

@Entity
@Table(name = "bill_details")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long invoiceNo;
	
	@Column
	private double discount;
	@Column
	private double totalPrice;
	
	@OneToOne(targetEntity=Client.class,cascade=CascadeType.ALL)
	@JoinColumn(name="inId_fk",referencedColumnName="clientId")
	private Client client;
	
//	@OneToMany(targetEntity=Product.class,cascade=CascadeType.ALL)
//	@JoinColumn(name="inId_fk",referencedColumnName="invoiceNo")
	@ManyToMany
	private List<Product> product;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Long invoiceNo, double discount, double totalPrice, Client client, List<Product> product) {
		super();
		this.invoiceNo = invoiceNo;
		this.discount = discount;
		this.totalPrice = totalPrice;
		this.client = client;
		this.product = product;
	}

	public Long getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(Long invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Bill [invoiceNo=" + invoiceNo + ", discount=" + discount + ", totalPrice=" + totalPrice + ", client="
				+ client + ", product=" + product + "]";
	}
	
	
	
	
	

}
