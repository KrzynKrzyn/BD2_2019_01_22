package com.bd2.app;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface PackageStatusRepository extends JpaRepository<PackageStatus, Long>{
	@Query(value="SELECT * FROM \"Zmiana statusu paczki\" WHERE \"Paczka\"=?1", nativeQuery=true)
	List<PackageStatus> findByPackageId(long package_id);
}
