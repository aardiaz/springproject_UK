package com.bway.springproject.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bway.springproject.repository.GalleryRepository;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryRepository  galleryRepo;
	
	@GetMapping("/gallery")
	public String getGallery(Model model) {
		
		//String[]  imgNames = new File("src/main/resources/static/image").list();
		model.addAttribute("imgPhotoList",galleryRepo.findAll());
		
		return "GalleryForm";
	}

}
