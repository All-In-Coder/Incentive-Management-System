package com.example.Incentive.services.SoldVehicle;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Incentive.dao.Vehicle_Sold_DAO;
import com.example.Incentive.entities.Sold_Vehicle;

@Service
public class soldVehilceServiceImpl implements soldVehicleService {

	@Autowired
	private Vehicle_Sold_DAO vSold;
	
	private long quota = 10000000;
//	private long quota = 100;
	
	public double getCommission(double price, long vtype)
	{
		// 1 => 2 wheeler
		// 2 => 3 wheeler
		// 3 => 4 wheeler
		// 4 => Commercial vehicle
		
		if(vtype==1)
		{
			if(price<30000)
				return 3.0;
			
			if(price>=30000 && price<50000)
				return 5.0;
			
			if(price>=50000)
				return 8.0;
		}
		
		if(vtype==2)
		{
			if(price<50000)
				return 3.0;
			
			if(price>=50000)
				return 5.0;
		}
		
		if(vtype==3)
		{
			if(price<100000)
				return 4.0;
			
			if(price>=100000 && price<500000)
				return 6.0;
			
			if(price>=500000)
				return 10.0;
		}
		
		if(vtype == 4)
		{
			if(price<500000)
				return 6.0;
			
			if(price>=500000)
				return 11.0;
		}
		
		return 0.0;
	}
	
	public Boolean getQuota(long sid)
	{
		long total = 0;
		try {
			List<Sold_Vehicle> res = vSold.getId(sid);
			System.out.println(res.size());
			
			for(int i=0;i<res.size();i++)
			{
				total += res.get(i).getSell_Price();
				System.out.println(res.get(i).getVName());
			}
		}
		catch(Exception e){
			System.out.println("comes here");
			System.out.println(e);
		}
		return total>=quota;
	}
	
	@Override
	public String soldVehicle(Map<String, String> req) {
		
		long vid = Long.parseLong(req.get("vid"));
		long sid = Long.parseLong(req.get("sid"));
		long vtype = Long.parseLong(req.get("type"));
		String name = req.get("name");
		long price = Long.parseLong(req.get("price"));
		double commission = getCommission(price,vtype);
		Boolean Quota = getQuota(sid);
		
		
		Sold_Vehicle sVehicle = new Sold_Vehicle(vid, sid, vtype, name, price, commission, Quota);
		vSold.save(sVehicle);
		
		return "Added";
	}

}
