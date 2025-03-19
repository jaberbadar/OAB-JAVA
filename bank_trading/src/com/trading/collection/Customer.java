package com.trading.collection;

import java.util.Objects;

public class Customer {
	
	private int custId;
	private String custNmae;
	private String nationality;
	
	
	
	public Customer(int custId,String custNmae, String nationality) {
		this.custId=custId;
		this.custNmae=custNmae;
		this.nationality=nationality;
		
	}



	public int getCustId() {
		return custId;
	}



	public void setCustId(int custId) {
		this.custId = custId;
	}



	public String getCustNmae() {
		return custNmae;
	}



	public void setCustNmae(String custNmae) {
		this.custNmae = custNmae;
	}



	public String getnationality() {
		return nationality;
	}



	public void setnationality(String nationality) {
		this.nationality = nationality;
	}



	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custNmae=" + custNmae + ", nationality=" + nationality + "]";
	}



	@Override
	public int hashCode() {
		return  this.custId;
	}



	@Override
	public boolean equals(Object obj) {
		
		Customer other = (Customer) obj;
		return custId == other.custId && Objects.equals(custNmae, other.custNmae)
				&& Objects.equals(nationality, other.nationality);
	}
	
	
	
	
	
	
	
	}



