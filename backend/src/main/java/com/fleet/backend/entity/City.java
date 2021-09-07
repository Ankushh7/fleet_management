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
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityid;

	private String cityname;

	private int stateidd;

	@ManyToOne(fetch = FetchType.LAZY)
	@Transient
	@JoinColumn(name = "stateidd", referencedColumnName = "stateid", insertable = false, updatable = false)
	private State state;

	public City() {
	}

	public City(int cityid, String cityname, int stateidd, State state) {
		super();
		this.cityid = cityid;
		this.cityname = cityname;
		this.stateidd = stateidd;
		this.state = state;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public int getStateidd() {
		return stateidd;
	}

	public void setStateidd(int stateidd) {
		this.stateidd = stateidd;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
