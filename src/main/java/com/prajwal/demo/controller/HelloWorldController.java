package com.prajwal.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.demo.beans.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldName(@PathVariable String name) {
		return new HelloWorldBean("Hello World " + name.toUpperCase());
	}


}
