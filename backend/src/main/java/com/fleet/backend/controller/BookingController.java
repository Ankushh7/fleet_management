package com.fleet.backend.controller;


import java.time.LocalDate;
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

import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.Car;
import com.fleet.backend.service.BookingService;
import com.fleet.backend.service.CarService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookingController {
	@Autowired
	private BookingService bookservice;

	@Autowired
	private CarService carService;

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/book")
	@Transactional
	@ResponseBody
	public ResponseEntity<Booking> bookUser(@RequestBody Booking book) {

		Car car = carService.findByCaridHubid(book.getCarbid(), book.getHubbid());
		// Car car =carService.findByCarid(1);
		if (car != null) {
			book.setCarname(car.getCarname());
			if (car.getCountinhub() > 1) {
				bookservice.saveMyBook(book);
				return new ResponseEntity<>(book, HttpStatus.OK);
			} else
				return null;
		} else {
			return null;
		}
		// Car car= carService.findCarByHubId(book.getCarbid());
		// car.setCountinhub(car.getCountinhub()-1);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/viewmybook/{userId}")
	@Transactional
	public List<Booking> viewMyBooking(@PathVariable int userId) {

		return bookservice.viewMyBooking(userId);

	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/showcars/{hubId}")
	@Transactional
	public List<Car> viewCars(@PathVariable int hubId) {

		return carService.findAllCars(hubId);
		// return "Hello" + book.getCustomerfname() + "your Booking is succesfull";
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/cancemybooking/{bookid}")
	@Transactional
	public int cancelMyBooking(@PathVariable int bookid) {

			bookservice.deleteByBookId(bookid);
			return 1;
		        
		        
	}
	/*
	 * @CrossOrigin(origins="http://localhost:8080")
	 * 
	 * @PostMapping("/bookfinal/")
	 * 
	 * @Transactional public String saveCar(@RequestBody Booking) { car=
	 * bookservice.findById(car.getCarid());
	 * 
	 * 
	 * 
	 * //bookservice.saveMyBookFinal(car.getCarid()); // mail pwd and bking Id
	 * 
	 * // return "Hello" + book.getCustomerfname() +
	 * "your Car Booking is successful"; }
	 */

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/allbookings")
	public List<Booking> findAllBookings() {
		return bookservice.findAllBookings();
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/showbook/{bookingId}")
	@Transactional
	public Booking viewBook(@PathVariable Integer bookingId) {
		return bookservice.getBookingByBId(bookingId);
		// return "Hello" + book.getCustomerfname() + "your Booking is succesfull";
	}
}