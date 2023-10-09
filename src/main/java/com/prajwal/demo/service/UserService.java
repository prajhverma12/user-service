package com.prajwal.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.prajwal.demo.beans.User;
import com.prajwal.demo.exception.UserNotFoundException;

@Component
public class UserService {

	private static List<User> users = new ArrayList<User>();
	private static Integer count = 0; 
	
	static {
		users.add(new User(++count, "Praj", LocalDate.now().minusYears(26)));
		users.add(new User(++count, "Himaja", LocalDate.now().minusYears(25)));
		users.add(new User(++count, "Arnav", LocalDate.now().minusYears(21)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findUser(int id) {
		return users.stream().filter(user -> user.getId().equals(id) )
				.findFirst().orElseThrow(() -> new UserNotFoundException("id" + id)); // () -> UserNotFoundException()
	}
	
	public User createUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	public void deleteUser(int id) {
		users.removeIf(user -> user.getId().equals(id));
	}
}
