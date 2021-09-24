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
public class Hub {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hubid;

	private String hubname;

	private String contactno;
	private String address;
	private String cityHub;
	private String state;
	private String airportid;

	public String getAirportid() {
		return airportid;
	}

	public void setAirportid(String airportid) {
		this.airportid = airportid;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@Transient
//	@JoinColumn(name = "stateidh", referencedColumnName = "stateid", insertable = false, updatable = false)
//	private State state;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@Transient
//	@JoinColumn(name = "cityidh", referencedColumnName = "cityid", insertable = false, updatable = false)
//	private City city;

	public Hub() {
	}

	public Hub(int hubid, String hubname, String contactno, String address, String cityHub, String state,/* State state,
			City city,*/ String airportid ) {
		super();
		this.hubid = hubid;
		this.hubname = hubname;
		this.contactno = contactno;
		this.address = address;
		this.cityHub = cityHub;
		this.state = state;
//		this.state = state;
//		this.city = city;
		this.airportid = airportid;
	}

	public int getHubid() {
		return hubid;
	}

	public void setHubid(int hubid) {
		this.hubid = hubid;
	}

	public String getHubname() {
		return hubname;
	}

	public void setHubname(String hubname) {
		this.hubname = hubname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCityHub() {
		return cityHub;
	}

	public void setCityHub(String cityHub) {
		this.cityHub = cityHub;
	}

	public String getStateidh() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

//	public State getState() {
//		return state;
//	}
//
//	public void setState(State state) {
//		this.state = state;
//	}
//
//	public City getCity() {
//		return city;
//	}
//
//	public void setCity(City city) {
//		this.city = city;
//	}

}
