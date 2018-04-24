package com.example.demo.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ImageService {
	public void uploadImage(MultipartHttpServletRequest request) throws IllegalStateException, IOException;

}
