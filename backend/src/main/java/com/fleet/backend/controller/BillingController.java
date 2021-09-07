package com.fleet.backend.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fleet.backend.entity.Billing;
import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.CarCategories;
import com.fleet.backend.service.BillingService;
import com.fleet.backend.service.BookingService;
import com.fleet.backend.service.CarService;


@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BillingController {

	@Autowired
	public BillingService billService;

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CarService carService;
	/**
	 *  car ava = -1
	 *  
	 * @param bookid
	 * @return
	 */
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/handover/{bookid}")
	@Transactional
	public Billing handoverCar(@PathVariable int bookid) {

		Booking booking = this.billService.getByBookId(bookid);
		Billing bill = new Billing();

		// Booking booking =this.billService.getByBook(bill.getBookingidbill());
		bill.setBookingidbill(booking.getBookingid());
		bill.setCaridbill(booking.getCarbid());
		bill.setCategoryidbill(booking.getCarcategorybid());
		bill.setCustomerbname(booking.getCustomerfname());
		bill.setCustomermobno(booking.getCustomermobno());
		bill.setHubidbill(booking.getHubbid());
		bill.setStartdate(LocalDate.now());
		bill.setUsermail(booking.getUsermailid());
		bill.setCarname(booking.getCarname());
		carService.decreaseCount(booking.getCarbid());
		bookingService.deleteByBookId(booking.getBookingid());
		billService.saveMyBill(bill);
		return bill;
	}

	// get API to get bill by billing ID
	// new obje => PDF and then send this pdf to user via mail
	// vratePDF(bill)->sendEmail()

	/**
	 * 
	 * @param bookid
	 * @return
	 */
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/return/{billid}")
	@Transactional
	public Billing returnCar(@PathVariable int billid) {

		Billing billing = this.billService.getByillId(billid);
		CarCategories cc = this.billService.getCardailyRate(billing.getCategoryidbill());
		int noOfDays = LocalDate.now().getDayOfYear() - billing.getStartdate().getDayOfYear();
		billing.setBillamount(noOfDays * cc.getDailyrates());
		billing.setEnddate(LocalDate.now());
		carService.increaseCount(billing.getCaridbill());
		//update instead of save
		this.billService.updateMyBill(billing.getBillingid(),billing.getBillamount());
		return billing;
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/findallbills")
	@Transactional
	public List<Billing> findAllBills()
	{
		return this.billService.findAllBills();
	}
	
}