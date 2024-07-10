package com.example.ctrl;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class LoginController 
{
	
	 @GetMapping("/")
	 public String OpenForAll()
	 {
		return "For Everyone";
	 }
	
	 @GetMapping("/user")
	 public String OpenForUser()
	 {
		return "ForEveryauthenticatedser ";
	 }
	 
	 @GetMapping("/mgr")
	 public String OpenForManager()
	 {
		return "ForManager";
	 }
	 
	 @GetMapping("/admin")
	 public String OpenForAdmin()
	 {
		return "ForAdmin";
	 }
		
}