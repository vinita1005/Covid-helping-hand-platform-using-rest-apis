package com.webservice.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class Donor implements Serializable {

	private static final long serialVersionUID = 6589578974377908874L;

	public Donor() {
		super();
	}

	public Donor(String fullName, String city, String state, String country, String contactNo,
			String fullAddress, boolean isActive, String bloodType) {
		super();
		this.fullName = fullName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNo = contactNo;
		this.fullAddress = fullAddress;
		this.isActive = isActive;
		this.bloodType = bloodType;
	}

	public Donor(Long id, String fullName, String city, String state, String country, String contactNo,
			String fullAddress, boolean isActive, String bloodType) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNo = contactNo;
		this.fullAddress = fullAddress;
		this.isActive = isActive;
		this.bloodType = bloodType;
	}
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String fullName;

	@NotNull
	private String city;

	@NotNull
	private String state;

	@NotNull
	private String country;

	@NotNull
	private String contactNo;

	@NotNull
	private String fullAddress;
	
	private boolean isActive=true;

	@NotNull
	private String bloodType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

}
