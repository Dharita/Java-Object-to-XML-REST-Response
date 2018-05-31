package com.stackoverflow.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackoverflow.demo.bean.VisaResponse;
import com.stackoverflow.demo.service.ApiService;
import com.stackoverflow.demo.wrapper.JavaToXmlWrapper;

@RestController
public class HelloWorldRestController {

	@Autowired
	private ApiService apiService;

	@Autowired
	private JavaToXmlWrapper javaToXmlWrapper;

	@RequestMapping(value = "/api")
	public ResponseEntity<String> listAllUsers() {
		// get data from database
		VisaResponse visaResponse = apiService.visaResponse();
		if (null != visaResponse) {
			// convert bean to XML
			String xmlResponse = javaToXmlWrapper.javaObjectToXML(visaResponse);
			return new ResponseEntity<>(xmlResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}