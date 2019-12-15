package com.gaurav.rest.webservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static int userCounter = 4;
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Baggins", "Frodo", new Date()));
		users.add(new User(2, "Gamgee", "Samwise", new Date()));
		users.add(new User(3, "Brandybuck", "Meriadoc", new Date()));
		users.add(new User(4, "Took", "Peregrin", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User save(User user) {
		if (user.getId() == 0) {
			user.setId(++userCounter);
		}
		users.add(user);
		return user;
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}
