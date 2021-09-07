package com.fleet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.Car;


public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("From Booking Where usermailid=?1")
	public Booking getByBookMail(String usermail);

	@Query("From Car where hubidc=?1 AND countinhub > 0")
	public List<Car> findAllCars(int hubbid);

	@Query("From Booking where bookingid=?1 ")
	public Booking getBookingByBId(int bookid);

	@Query("From Car where carid=?1")
	public Car findById(int carid);
	
	@Query("From Booking")
	public List<Booking> findAllBookings();
	
	@Modifying
	@Query("Delete from Booking where bookingid=?1")
	public void deleteByBookId(int bookid);
	
	@Query("From Booking where userbid=?1")
	List<Booking> viewMyBooking(int userid);
	
	
	
}
