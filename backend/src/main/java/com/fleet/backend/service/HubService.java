package com.fleet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.backend.entity.Hub;

import com.fleet.backend.repository.HubRepository;

@Service
public class HubService {
	
	private HubRepository hubRepository;

	@Autowired
	public HubService(HubRepository hubRepository) {

		this.hubRepository = hubRepository;
	}
	
	public List<Hub> findByCity(String cityHub) {
		return hubRepository.findByCity(cityHub);
	}
	
	public List<Hub> findByAirId(String airportid) {
		return hubRepository.findByAirId(airportid);
	}
}
