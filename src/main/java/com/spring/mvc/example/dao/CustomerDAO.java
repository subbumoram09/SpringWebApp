package com.spring.mvc.example.dao;

import java.util.List;

import com.spring.mvc.example.model.Customers;

public interface CustomerDAO 
{
	public int addCustomer(Customers c);
	public int updateCustomer(Customers c);
	public int deleteCustomer(Customers c);
	public List<Customers> viewCustomer();
}
