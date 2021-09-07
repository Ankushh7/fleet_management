package com.fleet.backend.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carid;
	private String carname;
	//private String carnoplate;
	private int capacity;
	private String fueltype;
	private Double mileage;
	private String color;
	private int availability;
	private int hubidc;
	private int categoryidc;
	private int countinhub;
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "hubidc", referencedColumnName = "hubid", insertable = false, updatable = false)
	private Hub hub;

	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "categoryidc", referencedColumnName = "categoryid", insertable = false, updatable = false)
	private CarCategories carcat;
     public Car(){}
	public Car(int carid, String carname, int capacity, String fueltype, Double mileage, String color, int availability,
			int hubidc, int categoryidc, int countinhub, Hub hub, CarCategories carcat) {
		super();
		this.carid = carid;
		this.carname = carname;
		this.capacity = capacity;
		this.fueltype = fueltype;
		this.mileage = mileage;
		this.color = color;
		this.availability = availability;
		this.hubidc = hubidc;
		this.categoryidc = categoryidc;
		this.countinhub = countinhub;
		this.hub = hub;
		this.carcat = carcat;
	}
	public int getCarid() {
		return carid;
	}
	public void setCarid(int carid) {
		this.carid = carid;
	}
	public String getCarname() {
		return carname;
	}
	public void setCarname(String carname) {
		this.carname = carname;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getFueltype() {
		return fueltype;
	}
	public void setFueltype(String fueltype) {
		this.fueltype = fueltype;
	}
	public Double getMileage() {
		return mileage;
	}
	public void setMileage(Double mileage) {
		this.mileage = mileage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAvailability() {
		return availability;
	}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
	public int getHubidc() {
		return hubidc;
	}
	public void setHubidc(int hubidc) {
		this.hubidc = hubidc;
	}
	public int getCategoryidc() {
		return categoryidc;
	}
	public void setCategoryidc(int categoryidc) {
		this.categoryidc = categoryidc;
	}
	public int getCountinhub() {
		return countinhub;
	}
	public void setCountinhub(int countinhub) {
		this.countinhub = countinhub;
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
	
}
