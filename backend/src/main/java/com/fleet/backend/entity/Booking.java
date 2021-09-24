package com.fleet.backend.entity;

import java.sql.Date;
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
public class Booking {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingid;
	private Date pickup_date;
	private Date drop_date;
	private String customerfname;
	private String customerlname;
	private String customermobno;
	private String usermailid;
	private Double customerdlno;
	private int carcategorybid;
	private int carbid;
	private int userbid;
	private int hubbid;
	private String carname;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "carcategorybid", referencedColumnName = "categoryid", insertable = false, updatable = false)
    private CarCategories caracat;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "carcategorybid", referencedColumnName = "carid", insertable = false, updatable = false)
    private Car car;
	
	
    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
	@JoinColumn(name = "userbid", referencedColumnName = "userid", insertable = false, updatable = false)
    private User user;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @Transient
	@JoinColumn(name = "hubbid", referencedColumnName = "hubid", insertable = false, updatable = false)
    private Hub hub;

    public Booking() {}

	
	public Booking(int bookingid, Date pickup_date, Date drop_date, String customerfname, String customerlname,
			String customermobno, String usermailid, Double customerdlno, int carcategorybid, int carbid, int userbid,
			int hubbid, String carname, CarCategories caracat, Car car, User user, Hub hub) {
		super();
		this.bookingid = bookingid;
		this.pickup_date = pickup_date;
		this.drop_date = drop_date;
		this.customerfname = customerfname;
		this.customerlname = customerlname;
		this.customermobno = customermobno;
		this.usermailid = usermailid;
		this.customerdlno = customerdlno;
		this.carcategorybid = carcategorybid;
		this.carbid = carbid;
		this.userbid = userbid;
		this.hubbid = hubbid;
		this.carname = carname;
		this.caracat = caracat;
		this.car = car;
		this.user = user;
		this.hub = hub;
	}


	public Date getPickup_date() {
		return pickup_date;
	}


	public void setPickup_date(Date pickup_date) {
		this.pickup_date = pickup_date;
	}


	public Date getDrop_date() {
		return drop_date;
	}


	public void setDrop_date(Date drop_date) {
		this.drop_date = drop_date;
	}


	public String getCarname() {
		return carname;
	}


	public void setCarname(String carname) {
		this.carname = carname;
	}


	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	public String getCustomerfname() {
		return customerfname;
	}

	public void setCustomerfname(String customerfname) {
		this.customerfname = customerfname;
	}

	public String getCustomerlname() {
		return customerlname;
	}

	public void setCustomerlname(String customerlname) {
		this.customerlname = customerlname;
	}

	public String getCustomermobno() {
		return customermobno;
	}

	public void setCustomermobno(String customermobno) {
		this.customermobno = customermobno;
	}

	public String getUsermailid() {
		return usermailid;
	}

	public void setUsermailid(String usermailid) {
		this.usermailid = usermailid;
	}

	public Double getCustomerdlno() {
		return customerdlno;
	}

	public void setCustomerdlno(Double customerdlno) {
		this.customerdlno = customerdlno;
	}

	public int getCarcategorybid() {
		return carcategorybid;
	}

	public void setCarcategorybid(int carcategorybid) {
		this.carcategorybid = carcategorybid;
	}

	public int getCarbid() {
		return carbid;
	}

	public void setCarbid(int carbid) {
		this.carbid = carbid;
	}

	public int getUserbid() {
		return userbid;
	}

	public void setUserbid(int userbid) {
		this.userbid = userbid;
	}

	public int getHubbid() {
		return hubbid;
	}

	public void setHubbid(int hubbid) {
		this.hubbid = hubbid;
	}

	public CarCategories getCaracat() {
		return caracat;
	}

	public void setCaracat(CarCategories caracat) {
		this.caracat = caracat;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Hub getHub() {
		return hub;
	}

	public void setHub(Hub hub) {
		this.hub = hub;
	}
	
}
