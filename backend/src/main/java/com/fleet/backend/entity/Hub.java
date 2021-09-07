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

	private double contactno;
	private String address;
	private int cityidh;
	private int stateidh;

	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "stateidh", referencedColumnName = "stateid", insertable = false, updatable = false)
	private State state;
	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "cityidh", referencedColumnName = "cityid", insertable = false, updatable = false)
	private City city;

	public Hub() {
	}

	public Hub(int hubid, String hubname, double contactno, String address, int cityidh, int stateidh, State state,
			City city) {
		super();
		this.hubid = hubid;
		this.hubname = hubname;
		this.contactno = contactno;
		this.address = address;
		this.cityidh = cityidh;
		this.stateidh = stateidh;
		this.state = state;
		this.city = city;
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

	public double getContactno() {
		return contactno;
	}

	public void setContactno(double contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityidh() {
		return cityidh;
	}

	public void setCityidh(int cityidh) {
		this.cityidh = cityidh;
	}

	public int getStateidh() {
		return stateidh;
	}

	public void setStateidh(int stateidh) {
		this.stateidh = stateidh;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
