package com.webservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.service.DonorService;
import com.webservice.vo.Donor;

@RestController
@RequestMapping("/donors")
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Hello World";
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Donor> listAllDonors(){
		return donorService.getDonorData();
	}
	
	@GetMapping("/getByCity")
	public @ResponseBody List<Donor> listByCity(@RequestParam(name = "city") String city){
		return donorService.getDonorDataByCity(city);
	}
	
	@GetMapping("/getByBloodType")
	public @ResponseBody List<Donor> listByBloodType(@RequestParam(name = "bloodType") String bloodType){
		return donorService.getDonorDataByBloodType(bloodType);
	}
	
	@PostMapping("/addDonor")
	public @ResponseBody List<Donor> saveDonor(@RequestBody Donor donor){
		return donorService.addDonorData(donor);
	}
	
	@PutMapping("/updateDonor")
	public @ResponseBody List<Donor> updateDonor(@RequestBody Donor donor){
		return donorService.updateDonorData(donor);
	}
	
	@DeleteMapping("/deleteDonor")
	public @ResponseBody List<Donor> deleteDonor(@RequestParam(name = "id") Long id){
		return donorService.deleteDonorData(id);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
	    return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
