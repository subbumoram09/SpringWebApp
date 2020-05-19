package com.spring.mvc.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.example.dao.ItemDAO;
import com.spring.mvc.example.model.Items;
@Service
public class ItemService 
{
	@Autowired
	private ItemDAO itemDAOImpl;
	
	public boolean addedItem(Items item)
	{
		itemDAOImpl.save(item);
		if(item != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
