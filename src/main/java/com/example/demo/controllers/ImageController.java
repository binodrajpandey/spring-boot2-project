package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.services.ImageService;

@RestController
@RequestMapping("/images")
public class ImageController {
	@Autowired
	private ImageService imageService;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(MultipartHttpServletRequest request) throws IllegalStateException, IOException{
		imageService.uploadImage(request);
		return ResponseEntity.ok("Successfully uploaded images");
		
	}

}
