package com.fleet.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fleet.backend.entity.Billing;
import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.CarCategories;
import com.fleet.backend.repository.BillingRepository;


@Service
public class BillingService {

	private BillingRepository billRepository;

	@Autowired
	public BillingService(BillingRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	public void saveMyBill(Billing bill) {
		billRepository.save(bill);
	}

	public BillingRepository getBillRepository() {
		return billRepository;
	}

	public void setBillRepository(BillingRepository billRepository) {
		this.billRepository = billRepository;
	}

	public Booking getByCus(String cusmailid) {
		return this.billRepository.getByCus(cusmailid);
	}

	
	public Billing getBillByMail(String usermailid) {
		return this.billRepository.getBillByMail(usermailid);
	}

	public CarCategories getCardailyRate(int carcat) {
		return this.billRepository.getCardailyRate(carcat);
	}

	public Booking getByBookId(int bookid) {

		return this.billRepository.getByBookId(bookid);
	}

	public Billing getByillId(int billid) {

		return this.billRepository.getByBillId(billid);
	}
	public void updateMyBill(int billingid , double amt)
	{
	 billRepository.updateMyBill(billingid, amt);
	}
	
	public List<Billing> findAllBills()
	{
		return billRepository.findAllBills();
	}
}
