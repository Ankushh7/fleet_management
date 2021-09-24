package com.fleet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fleet.backend.entity.Hub;


public interface HubRepository extends JpaRepository<Hub, Integer> {
	@Query("From Hub Where cityHub= ?1")
	List<Hub> findByCity(String cityHub);
	
	@Query("From Hub Where airportid= ?1")
	List<Hub> findByAirId(String airportid);	
}

