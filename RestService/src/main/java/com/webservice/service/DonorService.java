package com.webservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.vo.Donor;

@Service
public interface DonorService {

	public List<Donor> getDonorData();
	public List<Donor> getDonorDataByCity(String city);
	public List<Donor> getDonorDataByBloodType(String bloodType);
	public List<Donor> addDonorData(Donor donor);
	public List<Donor> updateDonorData(Donor donor);
	public List<Donor> deleteDonorData(Long id);
}
