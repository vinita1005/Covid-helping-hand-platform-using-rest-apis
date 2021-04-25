package com.webservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.repo.DonorDao;
import com.webservice.vo.Donor;

@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorDao donorDao;
	@Override
	public List<Donor> getDonorData() {
		return donorDao.findAll();
	}

	@Override
	public List<Donor> getDonorDataByCity(String city) {
		return donorDao.findByCity(city);
	}

	@Override
	public List<Donor> getDonorDataByBloodType(String bloodType) {
		return donorDao.findByBloodType(bloodType);
	}

	@Override
	public List<Donor> addDonorData(Donor donor) {
		donorDao.save(donor);
		return donorDao.findAll();
	}

	@Override
	public List<Donor> updateDonorData(Donor donor) {
		donorDao.save(donor);
		return donorDao.findAll();
	}

	@Override
	public List<Donor> deleteDonorData(Long id) {
		donorDao.deleteById(id);
		return donorDao.findAll();
	}


}
