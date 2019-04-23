package com.bd2.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vehicle")
public class VehicleController {
	
	@Autowired
	private VehicleRepository repository;
	
	@PostMapping("")
	Vehicle addVehicle(@RequestBody Vehicle newVehicle)
	{
		return repository.save(newVehicle);
	}
}
