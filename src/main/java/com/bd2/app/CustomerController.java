package com.bd2.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;

	@GetMapping
	List<Customer> all() {
		return customerRepository.findAll();
	}

	@PostMapping("person")
	Customer person(@RequestBody CustomerRequest.PersonRequest creationRequest) {
		Address address = addressRepository.save(creationRequest.getAddress());
		Customer customer = new Customer();
		customer.setCustomerType("Osoba");
		customer.setName(creationRequest.getName());
		customer.setSurename(creationRequest.getSurename());
		customer.setEmail(creationRequest.getEmailAddress());
		customer.setAddressId(address.getId());
		customer.setPhoneNumber(creationRequest.getPhoneNumber());
		customer.setStartDate(new java.sql.Date(new Date().getTime())); // ugly
		return customerRepository.save(customer);
	}

	@PostMapping("company")
	Customer company(@RequestBody CustomerRequest.CompanyRequest creationRequest) {
		Address address = addressRepository.save(creationRequest.getAddress());
		Customer customer = new Customer();
		customer.setCustomerType("Firma");
		customer.setCompanyName(creationRequest.getName());
		customer.setEmail(creationRequest.getEmailAddress());
		customer.setAddressId(address.getId());
		customer.setPhoneNumber(creationRequest.getPhoneNumber());
		customer.setStartDate(new java.sql.Date(new Date().getTime())); // ugly
		return customerRepository.save(customer);
	}

}
