package com.example.Incentive.services.SalesPerson;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Incentive.dao.SalesPersonDoa;
import com.example.Incentive.dao.ShowRoom_Manager_DAO;
import com.example.Incentive.entities.SalesPerson;
import com.example.Incentive.entities.ShowRoom_Manager;

@Service
public class SalesPersonServiceImpl implements SalesPersonService {

	@Autowired
	private SalesPersonDoa sp;

	@Autowired
	private ShowRoom_Manager_DAO smd;
	
	@Override

	public Map<String,Map<String,String>> addSalesPerson(Map<String,String> req) {
		
		String Name = req.get("name");
		String PhoneNumber = req.get("phone");
		String Password = req.get("password");
		
		System.out.println(Name);
		System.out.println("Name");
		
		Map<String,Map<String,String>> response = new HashMap<>();
		
		int isUserPresent = sp.getUserPresentOrNot(PhoneNumber);
		if(isUserPresent == 0)
		{
			SalesPerson user = new SalesPerson(Name,PhoneNumber, Password);
			sp.save(user);
			
			ShowRoom_Manager SRM = new ShowRoom_Manager(Long.parseLong(sp.getId(PhoneNumber)), 0);
			smd.save(SRM);
			
			
			Map<String, String> res = new HashMap<>();
			res.put("ID", sp.getId(PhoneNumber));
			res.put("Name", Name);
			res.put("PhoneNumber", PhoneNumber);
			
			response.put("User Saved", res);
		}
		else
		{
			Map<String, String> temp = new HashMap<>();
			response.put("User Already Present", temp);
		}
		
		return response;
	}


	
	

}
