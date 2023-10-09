package com.prajwal.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.prajwal.demo.beans.User;
import com.prajwal.demo.service.UserService;
import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public EntityModel<User> getUsers(@PathVariable int id) {
		User user = userService.findUser(id);
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUsers(@Valid @RequestBody User user) {
		User createdUser = userService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdUser.getId()).toUri();
		ResponseEntity<User> response = ResponseEntity.created(location).build();
		return response;
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}
}
