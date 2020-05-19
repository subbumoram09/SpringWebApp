package com.spring.mvc.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.example.dao.CustomerDAO;
import com.spring.mvc.example.model.Customers;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerDAO customerDAOImpl;
	
	public boolean customerAdded(String id,String name,String add)
	{
		Customers c = new Customers();
		c.setCustId(id);
		c.setCustName(name);
		c.setCustAdd(add);
		int i = customerDAOImpl.addCustomer(c);
		if(i==1)
			return true;
		else
			return false;
	}
	public boolean customerUpdated(String id,String name,String add)
	{
		Customers c = new Customers();
		c.setCustId(id);
		c.setCustName(name);
		c.setCustAdd(add);
		int i = customerDAOImpl.updateCustomer(c);
		if(i==1)
			return true;
		else
			return false;
	}
	public boolean customerDeleted(String id)
	{
		Customers c = new Customers();
		c.setCustId(id);
		int i = customerDAOImpl.deleteCustomer(c);
		if(i==1)
			return true;
		else
			return false;
	}
	
	public List<Customers> customerViewed()
	{
		
		List<Customers> custViewList = customerDAOImpl.viewCustomer();
		if(custViewList!=null && custViewList.size()>0)
			return custViewList;
		else
			return null;
	}
}
