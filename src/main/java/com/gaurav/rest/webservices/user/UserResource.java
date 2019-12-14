package com.gaurav.rest.webservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveOneUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}
}
