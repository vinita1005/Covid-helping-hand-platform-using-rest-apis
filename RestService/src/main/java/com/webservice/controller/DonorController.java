package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Hello World";
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Donor> listAllDonors(){
		return donorDao.findAll();
	}
	
	@GetMapping("/getByCity")
	public @ResponseBody List<Donor> listByCity(@RequestParam String city){
		return donorDao.findByCity(city);
	}
	
	@GetMapping("/getByBloodType")
	public @ResponseBody List<Donor> listByBloodType(){
		return null;
	}
	
	@PostMapping("/addDonor")
	public @ResponseBody List<Donor> saveDonor(@RequestBody Donor donor){
		donorDao.save(donor);
		return donorDao.findAll();
	}
	
	@PutMapping("/updateDonor")
	public @ResponseBody List<Donor> updateDonor(@RequestBody Donor donor){
		donorDao.save(donor);
		return donorDao.findAll();
	}
	
	@DeleteMapping("/deleteDonor")
	public @ResponseBody List<Donor> deleteDonor(@RequestAttribute Long id){
		donorDao.deleteById(id);
		return donorDao.findAll();
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
