package com.app.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class Customer implements Serializable {
	
	@Id
	@GeneratedValue
	private Integer custId;
	private String custCode;
	private String custName;
	private String custType;
	private String note;
	public Customer() {
		super();
	}
	public Customer(String custCode, String custName, String custType, String note) {
		super();
		this.custCode = custCode;
		this.custName = custName;
		this.custType = custType;
		this.note = note;
	}
	public Customer(Integer custId) {
		super();
		this.custId = custId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustType() {
		return custType;
	}
	public void setCustType(String custType) {
		this.custType = custType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custCode=" + custCode + ", custName=" + custName + ", custType="
				+ custType + ", note=" + note + "]";
	}
	
		
}
