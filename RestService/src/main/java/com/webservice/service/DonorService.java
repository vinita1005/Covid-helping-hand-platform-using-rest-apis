package com.webservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.vo.Donor;

@Service
public interface DonorService {

	public List<Donor> getDonorData();
	public List<Donor> getDonorDataByCity();
	public List<Donor> getDonorDataByBloodType();
	public List<Donor> addDonorData();
	public List<Donor> updateDonorData();
	public List<Donor> deleteDonorData();
}
