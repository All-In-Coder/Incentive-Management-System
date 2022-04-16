package com.example.Incentive.services.Vehicle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Incentive.dao.VehicleDao;
import com.example.Incentive.entities.Vehicle;

@Service
public class VehilceSeviceImpl implements VehilceService {

	@Autowired
	private VehicleDao veh;
	
	@Override
	  public Map<String, Map<String, String>> addVehicle(Map<String, String> req) {
	    
	    String Name = req.get("name");
	    long price = Long.parseLong(req.get("price"));
	    long type = Long.parseLong(req.get("type"));
	    
	    Vehicle vehicle = new Vehicle(Name, price, type);
	    veh.save(vehicle);
	    
	    Map<String, Map<String, String>> response = new HashMap<>();
	    
	    Map<String, String> res = new HashMap<>();
	    
	    res.put("VID", veh.getId(Name));
	    res.put("Name", Name);
	    res.put("Price", Long.toString(price));
	    res.put("Type", Long.toString(type));
	    
	    response.put("Vehicle Added", res);
	    
	    return response;
	  }

}
