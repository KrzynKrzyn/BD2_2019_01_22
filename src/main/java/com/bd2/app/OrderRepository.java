package com.bd2.app;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value="SELECT * FROM \"Zlecenie\" WHERE \"Klient\"=?1", nativeQuery=true)
	List<Order> findOrdersForCustomer(Long customerId);
	
	@Query(value="SELECT * FROM \"Zlecenie\" WHERE \"Data złożenia\">=?1 AND \"Data złożenia\"<=?2", nativeQuery=true)
	List<Order> findByDates(Date from, Date to);
}
