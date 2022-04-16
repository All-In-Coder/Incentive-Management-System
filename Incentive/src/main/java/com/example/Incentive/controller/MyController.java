package com.example.Incentive.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Incentive.services.SalesPerson.SalesPersonService;
import com.example.Incentive.services.ShowRoom.ShowRoomService;
import com.example.Incentive.services.SoldVehicle.soldVehicleService;
import com.example.Incentive.services.Vehicle.VehilceService;

@RestController
public class MyController {

	@Autowired
	private SalesPersonService salesPersonService;

	@Autowired
	private VehilceService vService;

	@Autowired
	private soldVehicleService svService;

	@Autowired
	private ShowRoomService srService;

	// this will be used to add the person by Showroom Manager
	@PostMapping("/addSalesPerson")
	public Map<String, Map<String, String>> addSalesPerson(@RequestBody Map<String, String> req) {
		Map<String, Map<String, String>> response = this.salesPersonService.addSalesPerson(req);
		return response;
	}

	// this will be used to add the vehilce by showroom manager
	@PostMapping("/addVehicle")
	public Map<String, Map<String, String>> addVehicle(@RequestBody Map<String, String> req) {
		Map<String, Map<String, String>> response = this.vService.addVehicle(req);
		return response;
	}

	// this will be used to add the sold vehilce by SalesPerson
	@PostMapping("/addSoldVehicle")
	public String soldVehicle(@RequestBody Map<String, String> req) {
		String response = this.svService.soldVehicle(req);
		return response;
	}

	// this will be used to calculate the total earning of the SalesPersons by admin
	@GetMapping("/calculate")
	public Map<String, Double> calculate() {
		Map<String, Double> res = this.srService.calculate();
		return res;
	}

	// this will be used to calculate the total earning of the admin including the
	// commission of the salesperson
	@GetMapping("/myEarning")
	public Map<String, Double> myEarning() {
		Map<String, Double> res = this.srService.myEarning();
		return res;
	}

	// this will be used to calculate the earning of the particular user
	@PostMapping("/salesPersonEarning")
	public double salesPersonEarning(@RequestBody Map<String, Long> req) {
		long sid = req.get("sid");
		double res = this.srService.salesPersonEarning(sid);
		return res;
	}

	// this will be used to calculate whether the quota of particular salesperson is
	// achieved or not
	@PostMapping("/quotaComplete")
	public Boolean quotaComplete(@RequestBody Map<String, Long> req) {
		long sid = req.get("sid");
		Boolean res = this.srService.quotaComplete(sid);
		return res;
	}

}
