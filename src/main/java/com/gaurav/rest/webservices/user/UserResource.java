package com.gaurav.rest.webservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
		User retrievedUser = userDaoService.findOne(id);
		
		if (retrievedUser == null) {
			throw new UserNotFoundException("User with Id " + id + " does not exists.");
		}
		
		return retrievedUser;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);
		
		// Create the URL of new resource so that it can be returned back
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequestUri() // Gets the Current Request URI. Now, we can modify it to get resource URI
			.path("/{id}") // Append the given path to the existing path of this builder.
			.buildAndExpand(savedUser.getId()) // Build a UriComponents instance and replaces URI template variables with the value
			.toUri();
		
		return ResponseEntity.created(location)
				.build(); // Create a new builder with a CREATED http status and a location header set to the given URI.

	}
	
	@DeleteMapping("/users/{id}")
	public void deleteOneUser(@PathVariable int id) {
		User deletedUser = userDaoService.deleteById(id);
		
		if (deletedUser == null) {
			throw new UserNotFoundException("User with Id " + id + " does not exists.");
		}
	}
}
