package com.fleet.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fleet.backend.service.CarService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CarController {

	@Autowired
	private CarService carservice;

	/*@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/all-cars")
	public Iterable<Car> showAllUsers() {
		return carservice.showAllUsers();
	}*/

}
