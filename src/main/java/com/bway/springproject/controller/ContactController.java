package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.springproject.utils.MyEmailUtil;

@Controller
public class ContactController {
	
	@Autowired
	private MyEmailUtil emailUtil;
	
	@GetMapping("/contact")
	public String getContact() {
		
		return "ContactForm";
	}

	@PostMapping("/contact")
	public String postContact(@RequestParam String toEmail,@RequestParam String subject,@RequestParam String message) {
		
		emailUtil.sendEmail(toEmail,subject,message);
		
		return "ContactForm";
	}
}
