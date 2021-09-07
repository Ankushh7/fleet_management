package com.fleet.backend.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fleet.backend.entity.LogUser;
import com.fleet.backend.entity.User;
import com.fleet.backend.service.UserService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	@Autowired
	private UserService userService;

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/save-user")
	@Transactional
	@ResponseBody
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		// check if already registered

		return new ResponseEntity<>(userService.saveMyUser(user), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/login")
	@Transactional
	public ResponseEntity<User> login(@RequestBody LogUser loguser) {
		// logic for invalid user
		// todo : isAdmin boolean
		User user = userService.login(loguser.getUsermail(), loguser.getPassword());
	/*	if (user != null) {
			if (user.getIsadmin() == 1)
				return new ResponseEntity<>(1, HttpStatus.OK);
			else
				return new ResponseEntity<>(2, HttpStatus.OK);
		} else
			return null;
			*/
		if (user != null) {
			
				return new ResponseEntity<>(user, HttpStatus.OK);
					}
		else
			return null;
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/allusers")
	public ResponseEntity<List<User>> showAllUsers() {
		List<User> users = userService.showAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/search/{username}")
	public User searchUser(@PathVariable String username) {
		return userService.findByUserName(username);

	}

	@GetMapping("/searchbystate/{stateid}")
	public List<User> searchbystate(@PathVariable int stateid) {
		return userService.findByState(stateid);

	}
}
