package com.spring.mvc.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="items")
public class Items 
{
	@Id
	@Column(name="itemid",length=5)
	@GenericGenerator(name="g1",strategy="increment")
	@GeneratedValue(generator="g1")
	private Integer itemId;
	@Column(name="itemname",length=30)
	private String itemName;
	@Column(name="itemprice",length=20)
	private Double itemPrice;
	@Column(name="quantity",length=10)
	private Integer Quantity;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	
	

}
