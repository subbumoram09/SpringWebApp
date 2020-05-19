package com.spring.mvc.example.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.example.model.SignUp;
import com.spring.mvc.example.service.LoginService;

@Controller
public class LoginController 
{
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/welcome",method=RequestMethod.GET)
	public ModelAndView welcome()
	{
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/check",method=RequestMethod.POST)
	public ModelAndView checkLogin(@RequestParam("t1")String s1,@RequestParam("t2")String s2)
	{
		boolean b = loginService.checkDetails(s1, s2);
		if(b)
		{
			return new ModelAndView("indexpage");
		}
		else
		{
			return new ModelAndView("failure");
		}
	}
	
	@GetMapping(value = "/signin")
	public ModelAndView signIn()
	{
		return new ModelAndView("signin","loginFormBackingObject",new SignUp());
	}
	
	@PostMapping(value = "/userdetails")
	public ModelAndView userInput(@Valid @ModelAttribute("loginFormBackingObject") SignUp signUp, BindingResult result)
	{
		boolean b = false;
		if(result.hasErrors())
		{
			return new ModelAndView("signin");
		}
		else
		{
			String username = signUp.getUname();
			String password = signUp.getPwd();
			if(username != null && password !=null)
			{
				b = loginService.signUpDetails(username, password);
			}
			if(b)
			{
				return new ModelAndView("success");
			}
			else
			{
				return new ModelAndView("failure");
			}
		}
	}
	
	
	@GetMapping("/fileupload")
	public ModelAndView fileUploadPage()
	{
		return new ModelAndView("uploadfile");
	}
	@PostMapping("/upload")
	public ModelAndView fileUpload(@RequestParam ("files1") MultipartFile file)
	{
		String fail="";
		String success = "";
		if(file.getSize()!=0)
		{
			if(file.getContentType().equals("text/xml"))
			{
				try
				{
					FileOutputStream fos = new FileOutputStream("E:/"+file.getOriginalFilename());
					fos.write(file.getBytes());
					success = "Your File"+file.getOriginalFilename()+" uploaded Successfully";
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				fail = "The file should be XML only";
				
			}
		}
		else
		{
			fail = "The file should not be empty";
		}
		if(success.length()>1)
		{
			return new ModelAndView("uploadfile","message",success);
		}
		else
		{
			return new ModelAndView("uploadfile","message",fail);
		}
	}
	
	@GetMapping("/pdf")
	public ModelAndView pdfDownloadPage()
	{
		return new ModelAndView("pdf");
	}
	@GetMapping("/excel")
	public ModelAndView DownloadPage()
	{
		return new ModelAndView(new MyExcelView());
	}
	
	@GetMapping("/indexpage")
	public ModelAndView IndexPage()
	{
		return new ModelAndView("indexpage");
	}
}
