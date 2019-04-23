package com.bd2.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("driver")
public class DriverController {
	@Autowired
	private DriverRepository repository;
	
	
	@GetMapping("/{driver_id}")
	List<Driver> orderList(@PathVariable long driver_id) {
		return repository.findByDriverId(driver_id);
	}
	@PostMapping("")
	Driver insertDriver(@RequestBody Driver new_driver)
	{
		return repository.save(new_driver);
	}
	
}
