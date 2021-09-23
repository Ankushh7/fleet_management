package com.fleet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.Car;
import com.fleet.backend.entity.Hub;
import com.fleet.backend.repository.BookingRepository;


@Service
public class BookingService {

	private BookingRepository bookRepository;

	@Autowired
	public BookingService(BookingRepository bookRepository) {

		this.bookRepository = bookRepository;
	}

	public BookingRepository getBookRepository() {
		return bookRepository;
	}

	public void setBookRepository(BookingRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Booking getByBookMail(String usermail) {
		return bookRepository.getByBookMail(usermail);
	}

	public void saveMyBook(Booking book) {
		bookRepository.save(book);
	}

	public List<Car> showCars(int hubbid) {
		return bookRepository.findAllCars(hubbid);
	}

	public Booking getBookingByBId(int bookid) {
		return bookRepository.getBookingByBId(bookid);
	}
	
	public void deleteByBookId(int bookid) {
		this.bookRepository.deleteByBookId(bookid);
	}


	public void saveMyBookFinal(int carid) {
		Car car = bookRepository.findById(carid);

	}

	public Car findById(int carid) {
		return this.bookRepository.findById(carid);
	}
	
	public Hub findByAirportId(int airportid) {
		return this.bookRepository.findByAirportId(airportid);
	}
	
     public List<Booking> findAllBookings()
     {
    	 return this.bookRepository.findAllBookings();
     }
     
     public List<Booking> viewMyBooking(int userid)
     {
    	return this.bookRepository.viewMyBooking(userid);
     }
}
