package com.example1.ctrl1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController 
{
	
	 @GetMapping("/")
	 public String OpenForAll()
	 {
		return "index.html";
	 }
	
	 @GetMapping("/user")
	 public String OpenForUser()
	 {
		return "user.html";
	 }
	 
	 @GetMapping("/mgr")
	 public String OpenForManager()
	 {
		return "mgr.html";
	 }
	 
	 @GetMapping("/admin")
	 public String OpenForAdmin()
	 {
		return "admin.html";
	 }
		
}