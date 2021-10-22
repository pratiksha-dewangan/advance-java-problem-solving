package com.app.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageController {

	public HomePageController() {
		System.out.println("in HPC...");
	}
	
	@PostConstruct
	public void initname() {
		System.out.println("in init.......");
	}
	
	@RequestMapping(value = "/")
	public String indexPage() {
		System.out.println("in index page..");
		return "/index";
	}
	
	
}
