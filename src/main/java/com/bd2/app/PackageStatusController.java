package com.bd2.app;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("packagestatus")
public class PackageStatusController {

	@Autowired
	private PackageStatusRepository repository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping("/{package_id}")
	List<PackageStatus> courseList(@PathVariable long package_id)
	{
		return repository.findByPackageId(package_id);
	}
	
	
	@PostMapping("one")
	PackageStatus addStatus(@RequestBody PackageStatus newStatus)
	{
		newStatus.setDate(new java.sql.Date(new Date().getTime()));
		return repository.save(newStatus);
	}
	
	@PostMapping("")
	PackageStatus addManyStatuses(@RequestBody PackagesStatusRequest newStatuses)
	{
		Address address = addressRepository.save(newStatuses.getAddress());
		PackageStatus ret = null;
		for (Long id : newStatuses.getPackages_id())
		{
			PackageStatus status = new PackageStatus();
			status.setAddress_id(address.getId());
			status.setCourse_id(newStatuses.getCourse_id());
			status.setDate(new java.sql.Date(new Date().getTime()));
			status.setNew_status(newStatuses.getNew_status());
			status.setPackage_id(id);
			ret = repository.save(status);
		}
		return ret;
	}
}
