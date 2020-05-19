package com.spring.mvc.example.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class SignUp 
{
	private String fname;
	private String lname;
	@Size(min=4,max=8)
	@Pattern(regexp="^[A-Z][a-z]*")
	@javax.validation.constraints.NotEmpty
	private String uname;
	@javax.validation.constraints.NotEmpty
	private String pwd;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "SignUp [fname=" + fname + ", lname=" + lname + ", uname=" + uname + ", pwd=" + pwd + "]";
	}
	
}
