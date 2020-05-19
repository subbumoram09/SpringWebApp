package com.spring.mvc.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="customers")
public class Customers 
{
	@NotEmpty
	@Id
	@Column(name="custid")
	@GenericGenerator(strategy="assigned",name="g2")
	@GeneratedValue(generator="g2")
	private String custId;
	@NotEmpty
	@Column(name="custname")
	private String custName;
	@NotEmpty
	@Column(name="custadd")
	private String custAdd;
	/*@OneToMany(targetEntity=com.spring.mvc.example.model.Items.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="custid_fk",referencedColumnName="custid")
	private Set items;
	public Set getItems() {
		return items;
	}
	public void setItems(Set items) {
		this.items = items;
	}*/
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustAdd() {
		return custAdd;
	}
	public void setCustAdd(String custAdd) {
		this.custAdd = custAdd;
	}
	@Override
	public String toString() {
		return "Customers [custId=" + custId + ", custName=" + custName + ", custAdd=" + custAdd + "]";
	}
	
	
}
