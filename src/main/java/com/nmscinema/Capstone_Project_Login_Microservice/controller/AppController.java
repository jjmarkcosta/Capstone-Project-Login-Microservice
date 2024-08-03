package com.nmscinema.Capstone_Project_Login_Microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nmscinema.Capstone_Project_Login_Microservice.model.User;
import com.nmscinema.Capstone_Project_Login_Microservice.repository.UserRepository;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	UserRepository repository;

	@GetMapping("/checkUser")
	public Boolean validateUser(@RequestParam String username, @RequestParam String password) {
			Iterable<User> user = repository.findAll();
			for (User person : user) {
				if (username.equals(person.getUsername()) && password.equals(person.getPassword())) {
					return true;
				}
			}
		return false;
	}
	
	@GetMapping("/checkAdmin")
	public Boolean validateAdmin(@RequestParam String username, @RequestParam String password) {
		if (username.equals("admin") && password.equals("admin")) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("/createUser")
	public Boolean createUser(@RequestParam String username, @RequestParam String password) {

		User user = new User(null, username, password);

		try {
			repository.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
