package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Items{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer itemId;
	@Size(min=3, max=50)
	@Column(name="Name")
	private String itemName;
	@Column(name="Price")
	private Integer itemPrice;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	/*
	 * public String toString() { return "Item Name :: "+ itemName +
	 * " & Price is :: " +itemPrice; }
	 */
}
