package com.webservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.repo.DonorDao;
import com.webservice.service.DonorService;
import com.webservice.service.DonorServiceImpl;
import com.webservice.vo.Donor;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = DonorServiceImpl.class)
public class DonorServiceTests {

	@MockBean
	DonorDao donorDao;
	
	@Autowired
    MockMvc mockMvc;
	
	@Autowired
	DonorService donorService;
	
	ObjectMapper objectMapper;
	List<Donor> donorList;
	
	@BeforeEach
	public void init() {
		objectMapper = new ObjectMapper();
		donorList = new ArrayList<Donor>();
		donorList.add(new Donor(1L, "Bilbo Baggins","Buffalo","New York","USA","2243221831","", true,"A+"));
		donorList.add(new Donor(2L, "Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
	}
	
	@Test
	public void getAllDonorsListShouldReturnListTest() throws Exception{
		
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		List<Donor> result = donorService.getDonorData();
		assertEquals(objectMapper.writeValueAsString(donorList), objectMapper.writeValueAsString(result));
	}
	
	@Test
	public void addDonorsToListTest() throws Exception{
		Donor donor = new Donor(3L, "Samwise","Dallas","Texas","USA","7163432321","", true,"O+");
		donorList.add(donor);
		Mockito.when(donorDao.save(Mockito.any(Donor.class))).thenReturn(donor);
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		List<Donor> result =  donorService.addDonorData(donor);
		
		assertEquals(objectMapper.writeValueAsString(donorList), objectMapper.writeValueAsString(result));
	}
	
	@Test
	public void getDonorListByCityFilterTest() throws Exception{
		String city = "Buffalo";
		
		List<Donor> donorList2 = new ArrayList<>();
		donorList2.add(new Donor(1L,"Bilbo Baggins","Buffalo","New York","USA","2243221831","", true,"A+"));
		donorList2.add(new Donor(2L,"Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
		
		Mockito.when(donorDao.findByCity(Mockito.anyString())).thenReturn(donorList2);
		
		List<Donor> result =  donorService.getDonorDataByCity(city);
		assertEquals(objectMapper.writeValueAsString(donorList), objectMapper.writeValueAsString(result));
		
	}
	
	@Test
	public void deleteDonorListShouldReturnAllListTest() throws Exception{
		Long id = 1L;
		donorList.remove(1);
		Mockito.doNothing().when(donorDao).deleteById(Mockito.anyLong());
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		List<Donor> result =  donorService.deleteDonorData(id);
		assertEquals(objectMapper.writeValueAsString(donorList), objectMapper.writeValueAsString(result));
	}
	
	@Test
	public void updateDonorShouldReturnNewListTest() throws Exception{
		List<Donor> donorList2 = new ArrayList<>();
		donorList2.add(new Donor(1L, "Bilbo Baggins","Buffalo","New York","USA","2243221831","", false,"A+"));
		donorList2.add(new Donor(2L, "Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
		
		Donor donor = new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", false,"A+");
		Mockito.when(donorDao.save(Mockito.any(Donor.class))).thenReturn(donor);
		Mockito.when(donorDao.findAll()).thenReturn(donorList2);
		List<Donor> result =  donorService.updateDonorData(donor);
		assertEquals(objectMapper.writeValueAsString(donorList2), objectMapper.writeValueAsString(result));
	}
}
