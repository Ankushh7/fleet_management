package com.fleet.backend.entity;

import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Billing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int billingid;
	private String customerbname;
	private double billamount;
	private LocalDate startdate;
	private LocalDate enddate;
	private String usermail;
	private String customermobno;
    private String carname;
	private int hubidbill;
	private int categoryidbill;
	private int caridbill;
	private int bookingidbill;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "hubidbill", referencedColumnName = "hubid", insertable = false, updatable = false)
	private Hub hub;
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "categoryidbill", referencedColumnName = "categoryid", insertable = false, updatable = false)
	private CarCategories carcat;
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "caridbill", referencedColumnName = "carid", insertable = false, updatable = false)
	private Car car;

	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "bookingidbill", referencedColumnName = "bookingid", insertable = false, updatable = false)
	private Booking booking;

	public Billing() {

	}

	public Billing(int billingid, String customerbname, double billamount, LocalDate startdate, LocalDate enddate,
			String usermail, String customermobno, String carname, int hubidbill, int categoryidbill, int caridbill,
			int bookingidbill, Hub hub, CarCategories carcat, Car car, Booking booking) {
		super();
		this.billingid = billingid;
		this.customerbname = customerbname;
		this.billamount = billamount;
		this.startdate = startdate;
		this.enddate = enddate;
		this.usermail = usermail;
		this.customermobno = customermobno;
		this.carname = carname;
		this.hubidbill = hubidbill;
		this.categoryidbill = categoryidbill;
		this.caridbill = caridbill;
		this.bookingidbill = bookingidbill;
		this.hub = hub;
		this.carcat = carcat;
		this.car = car;
		this.booking = booking;
	}

	public int getBillingid() {
		return billingid;
	}

	public void setBillingid(int billingid) {
		this.billingid = billingid;
	}

	public String getCustomerbname() {
		return customerbname;
	}

	public void setCustomerbname(String customerbname) {
		this.customerbname = customerbname;
	}

	public double getBillamount() {
		return billamount;
	}

	public void setBillamount(double billamount) {
		this.billamount = billamount;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public String getCustomermobno() {
		return customermobno;
	}

	public void setCustomermobno(String customermobno) {
		this.customermobno = customermobno;
	}

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public int getHubidbill() {
		return hubidbill;
	}

	public void setHubidbill(int hubidbill) {
		this.hubidbill = hubidbill;
	}

	public int getCategoryidbill() {
		return categoryidbill;
	}

	public void setCategoryidbill(int categoryidbill) {
		this.categoryidbill = categoryidbill;
	}

	public int getCaridbill() {
		return caridbill;
	}

	public void setCaridbill(int caridbill) {
		this.caridbill = caridbill;
	}

	public int getBookingidbill() {
		return bookingidbill;
	}

	public void setBookingidbill(int bookingidbill) {
		this.bookingidbill = bookingidbill;
	}

	public Hub getHub() {
		return hub;
	}

	public void setHub(Hub hub) {
		this.hub = hub;
	}

	public CarCategories getCarcat() {
		return carcat;
	}

	public void setCarcat(CarCategories carcat) {
		this.carcat = carcat;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
}
