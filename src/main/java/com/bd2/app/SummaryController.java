package com.bd2.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("summary")
public class SummaryController {
		
	@Autowired
	private SummaryService service;
	
	@GetMapping("drivers/{from}/{to}")
	List<Summary.Driver> driversSummary(@PathVariable Date from, @PathVariable Date to) {

		return service.driversSummary(from, to);
	}
	
	@GetMapping("drivers/min_package/{from}/{to}")
	Summary.Pair<Long> driversMinPackage(@PathVariable Date from, @PathVariable Date to) {

		return service.minPackage(from, to);
	}
	
	@GetMapping("drivers/max_package/{from}/{to}")
	Summary.Pair<Long> driversMaxPackage(@PathVariable Date from, @PathVariable Date to) {

		return service.maxPackage(from, to);
	}
	
	@GetMapping("drivers/min_course/{from}/{to}")
	Summary.Pair<Long> driversMinCourse(@PathVariable Date from, @PathVariable Date to) {

		return service.minCourse(from, to);
	}
	
	@GetMapping("drivers/max_course/{from}/{to}")
	Summary.Pair<Long> driversMaxCourse(@PathVariable Date from, @PathVariable Date to) {

		return service.maxCourse(from, to);
	}
	
	//TODO road summary
}
