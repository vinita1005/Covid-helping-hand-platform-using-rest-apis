package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.repo.DonorDao;
import com.webservice.vo.Donor;

@RestController
@RequestMapping("/donors")
public class DonorController {
	
	@Autowired
	private DonorDao donorDao;
	
	@GetMapping("/getAll")
	public @ResponseBody List<Donor> listAllDonors(){
		return null;
	}
	
	@GetMapping("/getByCity")
	public @ResponseBody List<Donor> listByCity(){
		return null;
	}
	
	@GetMapping("/getByBloodType")
	public @ResponseBody List<Donor> listByBloodType(){
		return null;
	}
	
	@PostMapping("/addDonor")
	public @ResponseBody List<Donor> saveDonor(){
		return null;
	}
	
	@PutMapping("/updateDonor")
	public @ResponseBody List<Donor> updateDonor(){
		return null;
	}
	
	@DeleteMapping("/deleteDonor")
	public @ResponseBody List<Donor> deleteDonor(@RequestParam Long id){
		return null;
	}
}
