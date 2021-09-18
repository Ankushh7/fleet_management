package com.fleet.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.fleet.backend.entity.Billing;
import com.fleet.backend.entity.Booking;
import com.fleet.backend.entity.CarCategories;

public interface BillingRepository extends JpaRepository<Billing, Integer> {

	@Query("From Booking Where usermailid=?1")
	public Booking getByCus(String cusmailid);

	@Query("From Billing Where usermail=?1")
	public Billing getBillByMail(String cusmailid);

	@Query("From CarCategories where categoryid=?1")
	public CarCategories getCardailyRate(int carcat);

	@Query("from Booking where bookingid=?1")
	public Booking getByBookId(int bookid);

	@Query("from Billing where billingid=?1")
	public Billing getByBillId(int bookid);
	
	@Modifying
	@Query("Update Billing set billamount= ?2 where billingid= ?1 ")
    public void updateMyBill(int billingid , double amt);
	
	@Query("from Billing where enddate=null")
	public List<Billing> findAllBills();

}
