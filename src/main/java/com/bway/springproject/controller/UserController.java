package com.bway.springproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bway.springproject.model.User;
import com.bway.springproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService  userService;
	
	@GetMapping("/login")
	public String getLogin() {
		
		return "LoginForm";
	}
	
	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user, Model model, HttpSession session) {
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User usr = userService.login(user.getUsername(), user.getPassword());
		
		if(usr != null) {
			
			session.setAttribute("validuser", usr);
			session.setMaxInactiveInterval(200);
			
			//model.addAttribute("user",usr);
			return "Home";
		}
		
		model.addAttribute("message","user not found !!");
		return "LoginForm";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		
		return "SignupForm";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute User user, Model model) {
		
		if(user.getUsername().isBlank()) {
			
			model.addAttribute("error","user name is required");
			return "SignupForm";
		}
		
		
		  //check user is already exist
		User u = userService.isUserExist(user.getUsername());
		
		  if( u != null) {
			  
			  model.addAttribute("message","user already exist !!");
			  
			  return "SignupForm";
		  }
		
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userService.signup(user);
		
		return "LoginForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();//session kill
		
		return "LoginForm";
	}
	
	@GetMapping("/profile")
	public String getProfile() {
		
		return "ProfileForm";
	}

}
