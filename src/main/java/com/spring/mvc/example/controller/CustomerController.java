package com.spring.mvc.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.example.model.Customers;
import com.spring.mvc.example.service.CustomerService;

@Controller
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/add")
	public ModelAndView addCustomerPage()
	{
		return new ModelAndView("addcust","customerObject",new Customers());
	}
	
	@GetMapping("/update")
	public ModelAndView updateCustomerPage()
	{
		return new ModelAndView("updatecust","customerObject",new Customers());
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteCustomerPage()
	{
		return new ModelAndView("deletecust","customerObject",new Customers());
	}
	
	/*@GetMapping("/view")
	public ModelAndView viewCustomerPage()
	{
		return new ModelAndView("viewcust");
	}*/
	
	@PostMapping("/added")
	public ModelAndView addCustomer(@Valid @ModelAttribute("customerObject") Customers cust, BindingResult result)
	{
		boolean b = false;
		if(result.hasErrors())
		{
			return new ModelAndView("addcust");
		}
		else
		{
			String id = cust.getCustId();
			String name = cust.getCustName();
			String add = cust.getCustAdd();
			if(id != null && name !=null && add !=null)
			{
				b = customerService.customerAdded(id, name, add);
			}
			if(b)
			{
				return new ModelAndView("custsuccess","message","Added");
			}
			else
			{
				return new ModelAndView("custfailure","message","Added");
			}
		}
		
	}
	
	@PostMapping("/updated")
	public ModelAndView updateCustomer(@Valid @ModelAttribute("customerObject") Customers cust, BindingResult result)
	{
		boolean b = false;
		if(result.hasErrors())
		{
			return new ModelAndView("updatecust");
		}
		else
		{
			String id = cust.getCustId();
			String name = cust.getCustName();
			String add = cust.getCustAdd();
			if(id != null && name !=null && add !=null)
			{
				b = customerService.customerUpdated(id, name, add);
			}
			if(b)
			{
				return new ModelAndView("custsuccess","message","Update");
			}
			else
			{
				return new ModelAndView("custfailure","message","Update");
			}
		}
		
	}
	
	@PostMapping("/deleted")
	public ModelAndView deleteCustomer(@RequestParam ("custId") String custid)
	{
		boolean b = false;
		if(custid != null)
			{
				b = customerService.customerDeleted(custid);
			}
			if(b)
			{
				return new ModelAndView("custsuccess","message","Delete");
			}
			else
			{
				return new ModelAndView("custfailure","message","Delete");
			}
		
		
	}
	
	@GetMapping("/view")
	public ModelAndView viewCustomer()
	{
		List<Customers> viewList = customerService.customerViewed();
		if(viewList != null)
		{
			return new ModelAndView("viewcust","custList",viewList);
		}
		else
		{
			return new ModelAndView("custfailure","message","View");
		}
		
	}
}
