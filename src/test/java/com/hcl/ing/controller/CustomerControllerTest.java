package com.hcl.ing.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hcl.ing.dto.CustomerResponseDto;
import com.hcl.ing.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerService customerService;
	
	
	@Before
	public void setup() {
		CustomerResponseDto customerResponseDto=new CustomerResponseDto();
		customerResponseDto.setMessage("Customer Response");
		customerResponseDto.setStatusCode(201);
	}
	
	@Test
	public void testGetCustomersAccounts()
	{
		/*CustomerRequestDto customerRequestDto=new CustomerRequestDto();
		Mockito.when(customerService.addCustomer(requestDto)getLoans(customerId)).thenReturn(loansResponse);
		ResponseEntity<LoansResponse> actual=customerController.getLoans(customerId);
		ResponseEntity<LoansResponse> expected=new ResponseEntity<>(loansResponse,HttpStatus.OK);
		
		assertEquals(expected.getStatusCode().value(), actual.getStatusCodeValue());*/

	}
	
	}


