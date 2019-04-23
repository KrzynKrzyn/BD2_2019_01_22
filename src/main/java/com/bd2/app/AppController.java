package com.bd2.app;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

	@GetMapping("/")
	public String mainPage(Model model) {
		return "main";
	}
	
	@GetMapping("/packages")
	public String showPackages(Model model) {
		return "packages";
	}
	
	@GetMapping("/showOrders")
	public String showOrders(Model model) {
		return "showOrders";
	}
	
	@GetMapping("/requestOrder")
	public String requestOrder(Model model) {
		return "requestOrder";
	}

	@GetMapping("/course")
	public String course(Model model) {
		return "course";
	}
	
	@GetMapping("/packagestatus")
	public String packageStatus(Model model) {
		return "packagestatus";
	}

	@GetMapping("/report")
	public String registration(Model model) {
		return "report";
	}

}
