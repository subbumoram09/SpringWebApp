package com.spring.mvc.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.example.model.Items;
import com.spring.mvc.example.service.ItemService;

@Controller
public class ItemController 
{
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/additem")
	public ModelAndView getIndexPage()
	{
		return new ModelAndView("additem","itemsbackingobject",new Items());
	}
	
	@PostMapping("/addeditem")
	public ModelAndView addItemPage(@Valid @ModelAttribute("itemsbackingobject") Items item,BindingResult result)
	{
		boolean b = false;
		if(result.hasErrors())
		{
			return new ModelAndView("additem");
		}
		else
		{
			if(item !=null)
			{
				b = itemService.addedItem(item);
			}
			if(b)
			{
				return new ModelAndView("itemsuccess","message","Added");
			}
			else
			{
				return new ModelAndView("itemfailure","message","Added");
			}
		}
	}

}
