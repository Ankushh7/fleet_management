package com.fleet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fleet.backend.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUsermail(String username);

	@Query("From User Where stateidu= ?1")
	List<User> findByState(int stateidu);

	@Query("From User Where usermail=?1 AND password=?2")
	User login(String Usermail, String password);

	@Query("From User Where usermail=?1 ")
	User findByUserMail(String Usermail);

}
