package com.fleet.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fleet.backend.entity.Hub;
import com.fleet.backend.service.HubService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HubController {
	
	@Autowired
	private HubService hubService;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/listhub/{cityHub}")
	public List<Hub> searchbyCity(@PathVariable String cityHub) {
		return hubService.findByCity(cityHub);

	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/listhubair/{airportid}")
	public List<Hub> searchbyAirId(@PathVariable String airportid) {
		return hubService.findByAirId(airportid);

	}
}
