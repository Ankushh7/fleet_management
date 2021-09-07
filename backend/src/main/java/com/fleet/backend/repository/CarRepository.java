package com.fleet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fleet.backend.entity.Car;


public interface CarRepository extends JpaRepository<Car, Integer> {

	@Query("From Car where hubidc=?1 AND countinhub > 0")
	public List<Car> findAllCars(int hubbid);

	@Modifying
	@Query("Update Car set countinhub=countinhub-1 where carid=?1")
	public void decreaseCount(int carid);

	@Modifying
	@Query("Update Car set countinhub=countinhub+1 where carid=?1")
	public void increaseCount(int carid);
	
	@Query("from Car where countinhub=?1 ")
	public Car findCarByHubId(int hubbid);
	
	@Query("from Car where carid = ?1 ")
	public Car findByCarid(int carid);
	
	@Query("from Car where carid = ?1 AND hubidc=?2")
	public Car findByCaridHubid(int carid, int hubid);
	

}
