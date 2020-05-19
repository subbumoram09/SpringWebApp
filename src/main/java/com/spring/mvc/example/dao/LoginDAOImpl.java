package com.spring.mvc.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAOImpl implements LoginDAO
{
	@Autowired
	private JdbcTemplate jdbcTamplate;
	
	private static final String LOGIN = "select count(*) from users where username = ? and password = ?";
	
	private static final String SIGN_UP = "insert into users (username,password) values (?,?)";
	
	public int checkUserDetails(String s1, String s2) 
	{
		int i = 0;
		Object[] args = {s1,s2};
		i = jdbcTamplate.queryForObject(LOGIN, args, Integer.class);
		return i;
	}
	
	public int signupUserDetails(String s1, String s2) 
	{
		int i = 0;
		Object[] args = {s1,s2};
		i = jdbcTamplate.update(SIGN_UP, args);
		return i;
	}
}
