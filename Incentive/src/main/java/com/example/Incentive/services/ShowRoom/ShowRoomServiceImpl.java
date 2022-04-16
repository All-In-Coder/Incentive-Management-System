package com.example.Incentive.services.ShowRoom;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Incentive.dao.ShowRoom_Manager_DAO;
import com.example.Incentive.dao.Vehicle_Sold_DAO;
import com.example.Incentive.entities.Sold_Vehicle;

@Service
public class ShowRoomServiceImpl implements ShowRoomService {

	private long quota = 10000000;

	@Autowired
	private ShowRoom_Manager_DAO srDOA;

	@Autowired
	private Vehicle_Sold_DAO vSold;

	public Boolean getQuota(long sid) {
		long total = 0;
		try {
			List<Sold_Vehicle> res = vSold.getId(sid);

			for (int i = 0; i < res.size(); i++) {
				total += res.get(i).getSell_Price();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return total >= quota;
	}

	public double total_earning(long sid) {
		double total = 0;
		try {
			List<Sold_Vehicle> res = vSold.getId(sid);
			for (int i = 0; i < res.size(); i++) {
				long sell_price = res.get(i).getSell_Price();
				double sell_price_with_commission = sell_price * (res.get(i).getCommission() / 100.0);
				double sell_price_with_commission_with_extra = sell_price_with_commission;

				if (res.get(i).getIsQuota() == true) {
					sell_price_with_commission = sell_price_with_commission
							+ sell_price_with_commission * (1.2 / 100.0);
				}

				total += sell_price_with_commission_with_extra;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return total;
	}

	public double my_earning(long sid) {
		double total = 0;
		try {
			List<Sold_Vehicle> res = vSold.getId(sid);
			for (int i = 0; i < res.size(); i++) {
				long sell_price = res.get(i).getSell_Price();
				double sell_price_with_commission = sell_price * (res.get(i).getCommission() / 100.0);
				double sell_price_with_commission_with_extra = sell_price_with_commission;

				if (res.get(i).getIsQuota() == true) {
					sell_price_with_commission = sell_price_with_commission
							+ sell_price_with_commission * (1.2 / 100.0);
				}

				total += sell_price_with_commission_with_extra * (1.0 / 10.0);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return total;
	}

	@Override
	public Map<String, Double> calculate() {

		Map<String, Double> response = new HashMap<>();

		List<Long> ID = srDOA.getId();
		for (int i = 0; i < ID.size(); i++) {
			double total_earning_of_sp = total_earning(ID.get(i));
			response.put(ID.get(i).toString(), total_earning_of_sp);
		}
		return response;
	}

	@Override
	public Map<String, Double> myEarning() {
		Map<String, Double> response = new HashMap<>();

		List<Long> ID = srDOA.getId();
		double total = 0;
		for (int i = 0; i < ID.size(); i++) {
			double total_earning_of_sp = my_earning(ID.get(i));
			total += total_earning_of_sp;

		}
		response.put("My Earning", total);
		return response;

	}

	@Override
	public double salesPersonEarning(long sid) {

		double total = total_earning(sid);
		return total;
	}

	@Override
	public Boolean quotaComplete(long sid) {

		return getQuota(sid);

	}

}
