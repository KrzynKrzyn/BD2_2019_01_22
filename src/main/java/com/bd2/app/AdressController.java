package com.bd2.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("address")
public class AdressController {
	
	@Autowired
	private AddressRepository repository;
	
	@GetMapping("{id}")
	Address one(@PathVariable Long id) {
		return repository.findById(id).orElseThrow();
	}
	
	@GetMapping("example")
	Address example() {
		Address adr =  new Address();
		adr.setCity("Szczecin");
		return adr;
	}
	
	@PostMapping("")
	Address insertAddress(@RequestBody Address new_address) {
		return repository.save(new_address);
//		return new_address;
	}
	
	

}
