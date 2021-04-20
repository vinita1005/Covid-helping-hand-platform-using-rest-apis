package com.webservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.vo.Donor;

public interface DonorDao extends JpaRepository<Donor, Long>{

	public List<Donor> findByCity(String city);
	public List<Donor> findByCityAndState(String city, String state);
	public List<Donor> findByCityAndStateAndCountry(String city, String state, String country);
	public List<Donor> findByIsActive(boolean isActive);
	public List<Donor> findByFullAddressLike(String fullAddress);
	public List<Donor> findByBloodType(String bloodType);
}
