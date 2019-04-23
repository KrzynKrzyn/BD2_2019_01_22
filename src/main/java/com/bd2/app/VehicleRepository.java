package com.bd2.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface VehicleRepository extends JpaRepository<Vehicle, String> {

}
