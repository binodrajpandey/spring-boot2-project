package com.example.demo.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
@Service
public class ImageServiceImpl implements ImageService{

	@Override
	public void uploadImage(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
	MultipartFile file=	request.getFile("upload");
	file.transferTo(new File("C:\\dev\\project\\spring_example_project\\spring-boot-crud-oauth2-cors\\"+file.getOriginalFilename()));
		
	}

}
