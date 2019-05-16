package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id @GeneratedValue
	private int studId;
	
	private String studName;
	private String studAddr;
	
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	
	public String getStudAddr() {
		return studAddr;
	}
	public void setStudAddr(String studAddr) {
		this.studAddr = studAddr;
	}
}
