package com.bd2.app;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ContentRepository contentRepository;
	@Autowired
	private PackageRepository packageRepository;

	@GetMapping("customer/{customerId}")
	List<Order> orders(@PathVariable Long customerId) {
		return orderRepository.findOrdersForCustomer(customerId);
	}
	
	@GetMapping("{from}/{to}")
	List<Order> orderList(@PathVariable Date from, @PathVariable Date to) {
		return orderRepository.findByDates(from, to);
	}
	
	@GetMapping("{orderId}")
	Order order(@PathVariable Long orderId) {
		return orderRepository.findById(orderId).orElseThrow();
	}
	
	@GetMapping("list/{orderId}")
	List<Long> packagesInOrder(@PathVariable Long orderId) {
		return packageRepository.findAllByOrderId(orderId).stream().map(obj -> obj.getId()).collect(Collectors.toList());
	}
	
	@GetMapping("package/{packageId}")
	Package pack(@PathVariable Long packageId) {
		return packageRepository.findById(packageId).orElseThrow();
	}
	
	@GetMapping("package/content/{contentId}")
	Content content(@PathVariable Long contentId) {
		return contentRepository.findById(contentId).orElseThrow();
	}
	
	@PostMapping
	Order order(@RequestBody OrderRequest orderRequest) {
		Order order = new Order();
		Address sourceAddress = addressRepository.save(orderRequest.getSourceAddress());
		Address destinationAddress = addressRepository.save(orderRequest.getDestinationAddress());		
		order.setCustomerId(orderRequest.getCustomerId());
		order.setDate(new java.sql.Date(new Date().getTime())); //ugly
		order.setDestinationAddressId(destinationAddress.getId());
		order.setSourceAddressId(sourceAddress.getId());
		order.setRepresentativeName(orderRequest.getName());
		order.setRepresentativeSurname(orderRequest.getSurname());
		order.setRepresentativePhoneNumber(orderRequest.getPhoneNumber());
		Order result = orderRepository.save(order);
		for(OrderRequest.PackageRequest packageRequest : orderRequest.getPackageList()) {
			Package pack = new Package();
			Content content = new Content();
			content.setDescription(packageRequest.getDescription());
			content.setType(packageRequest.getType());
			content = contentRepository.save(content);
			pack.setDimensionX(packageRequest.getDimensionX());
			pack.setDimensionY(packageRequest.getDimensionY());
			pack.setDimensionZ(packageRequest.getDimensionZ());
			pack.setContentId(content.getId());
			pack.setOrderId(result.getId());
			pack.setStatus("Zarejestrowana");
			pack.setWeight(packageRequest.getWeight());
			packageRepository.save(pack);
		}
		return result;
	}
}
