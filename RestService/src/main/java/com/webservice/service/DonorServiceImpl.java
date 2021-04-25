package com.webservice.service;

import java.util.List;

import com.webservice.vo.Donor;

public class DonorServiceImpl implements DonorService {

	@Override
	public List<Donor> getDonorData() {
		return donorDao.findAll();
	}

	@Override
	public List<Donor> getDonorDataByCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Donor> getDonorDataByBloodType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Donor> addDonorData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Donor> updateDonorData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Donor> deleteDonorData() {
		// TODO Auto-generated method stub
		return null;
	}

}
