package com.fleet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.backend.entity.Car;
import com.fleet.backend.repository.CarRepository;


@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<Car> findAllCars(int hubbid) {

		return carRepository.findAllCars(hubbid);

	}

	public Car findCarByHubId(int hubbid) {

		return carRepository.findCarByHubId(hubbid);

	}

	public void decreaseCount(int carid) {
		carRepository.decreaseCount(carid);
	}

	public void increaseCount(int carid) {
		carRepository.increaseCount(carid);
	}

	public Car findByCarid(int carid) {
		return carRepository.findByCarid(carid);
	}

	public Car findByCaridHubid(int carid, int hubid) {
		return carRepository.findByCaridHubid(carid, hubid);

	}
}
