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
@RequestMapping("course")
public class CourseController {
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("{vehicle}")
	List<Course> courseList(@PathVariable String vehicle)
	{
		return repository.findByVehicle(vehicle);
	}
	
	@PostMapping("")
	Course insertCourse(@RequestBody Course course) {
		return repository.save(course);
	}
}
