package com.spring.mvc.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.example.dao.LoginDAO;

@Service
public class LoginService 
{
	@Autowired
	private LoginDAO loginDAOImpl;
	
	public boolean checkDetails(String s1,String s2)
	{
		int i = 0;
		i = loginDAOImpl.checkUserDetails(s1, s2);
		if(i == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean signUpDetails(String s1,String s2)
	{
		int i = 0;
		i = loginDAOImpl.signupUserDetails(s1, s2);
		if(i == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
