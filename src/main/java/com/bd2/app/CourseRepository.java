package com.bd2.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface CourseRepository extends JpaRepository<Course, Long> {
	@Query(value="SELECT * FROM \"Kurs\" WHERE \"Pojazd\"=?1", nativeQuery=true)
	List<Course> findByVehicle(String vehicle_id);
}
