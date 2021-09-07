package com.fleet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.backend.entity.User;
import com.fleet.backend.repository.UserRepository;


@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public User saveMyUser(User user) {
		if (this.userRepository.findByUserMail(user.getUsermail()) == null)
			return userRepository.save(user);
		else
			return null;
	}

	public List<User> showAllUsers() {
		return userRepository.findAll();
	}

	public User findByUserName(String username) {
		return userRepository.findByUsermail(username);
	}

	public List<User> findByState(int stateidu) {
		return userRepository.findByState(stateidu);
	}

	public User login(String usermail, String password) {

		return userRepository.login(usermail, password);

	}
}
