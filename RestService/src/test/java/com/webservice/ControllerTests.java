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
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.controller.DonorController;
import com.webservice.repo.DonorDao;
import com.webservice.vo.Donor;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = DonorController.class)
public class ControllerTests {

	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	DonorDao donorDao;
	
	ObjectMapper objectMapper;
	List<Donor> donorList;
	
	@BeforeEach
	public void init() {
		objectMapper = new ObjectMapper();
		donorList = new ArrayList<Donor>();
		donorList.add(new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", true,"A+"));
		donorList.add(new Donor("Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
	}
	
	@Test
	public void getAllDonorsListShouldReturnListTest() throws Exception{
		
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/donors/getAll").contentType(MediaType.APPLICATION_JSON_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(objectMapper.writeValueAsString(donorList), result.getResponse().getContentAsString());
	}
	
	@Test
	public void addDonorsToListTest() throws Exception{
		Donor donor = new Donor("Samwise","Dallas","Texas","USA","7163432321","", true,"O+");
		donorList.add(donor);
		Mockito.when(donorDao.save(Mockito.any(Donor.class))).thenReturn(donor);
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/donors/addDonor").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(donor)).accept(MediaType.APPLICATION_JSON_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(objectMapper.writeValueAsString(donorList), result.getResponse().getContentAsString());
	}
	
	@Test
	public void getDonorListByCityFilterTest() throws Exception{
		String city = "Buffalo";
		
		List<Donor> donorList2 = new ArrayList<>();
		donorList2.add(new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", true,"A+"));
		donorList2.add(new Donor("Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
		
		Mockito.when(donorDao.findByCity(Mockito.anyString())).thenReturn(donorList2);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/donors/getByCity").param("city", city).contentType(MediaType.APPLICATION_JSON_VALUE);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		assertEquals(objectMapper.writeValueAsString(donorList2), result.getResponse().getContentAsString());
	}
	
	@Test
	public void deleteDonorListShouldReturnAllListTest() throws Exception{
		Long id = 1L;
		donorList.remove(1);
		Mockito.doNothing().when(donorDao).deleteById(Mockito.anyLong());
		Mockito.when(donorDao.findAll()).thenReturn(donorList);
		
		RequestBuilder request = MockMvcRequestBuilders.delete("/donors/deleteDonor?id="+id).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		assertEquals(objectMapper.writeValueAsString(donorList), result.getResponse().getContentAsString());
	}
	
	@Test
	public void updateDonorShouldReturnNewListTest() throws Exception{
		List<Donor> donorList2 = new ArrayList<>();
		donorList2.add(new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", false,"A+"));
		donorList2.add(new Donor("Frodo Baggins","Buffalo","New York","USA","2243222222","", true,"A+"));
		
		Donor donor = new Donor("Bilbo Baggins","Buffalo","New York","USA","2243221831","", false,"A+");
		Mockito.when(donorDao.save(Mockito.any(Donor.class))).thenReturn(donor);
		Mockito.when(donorDao.findAll()).thenReturn(donorList2);
		
		RequestBuilder request = MockMvcRequestBuilders.put("/donors/updateDonor").contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(donor));
		
		MvcResult result = mockMvc.perform(request).andReturn();
		
		assertEquals(objectMapper.writeValueAsString(donorList2), result.getResponse().getContentAsString());
	}
	
}
