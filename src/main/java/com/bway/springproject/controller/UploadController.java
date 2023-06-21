package com.bway.springproject.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bway.springproject.model.Gallery;
import com.bway.springproject.repository.GalleryRepository;

@Controller
public class UploadController {
	
	@Autowired
	private GalleryRepository  galleryRepo;
	
	@GetMapping("/upload")
	public String getUpload() {
		
		return "UploadForm";
	}

	@PostMapping("/upload")
	public String postUpload(@RequestParam MultipartFile  image, Model model) {
		
		if(!image.isEmpty()) {
			
			try {
				
				Files.copy(image.getInputStream(), Path.of("src/main/resources/static/image/"+image.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			  
				//send image name in db
				 Gallery  photo = new Gallery();
				 photo.setImg_name(image.getOriginalFilename());
				 photo.setImg_size(image.getSize());
				 
				 galleryRepo.save(photo);
				
				model.addAttribute("message","upload success");
			    return "UploadForm";
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("message","upload failed");
		return "UploadForm";
	}
	
}
