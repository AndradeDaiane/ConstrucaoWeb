package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/hello")
public class HelloController {
   	@GetMapping
	public String hello(){
		return "Hello World";
	}

	@GetMapping("/name")
	public String helloname (@PathParam("name") String name) {
		return "Hello" + name;
	} 
    
}
