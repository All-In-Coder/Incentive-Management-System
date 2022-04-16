package com.example.Incentive.services.ShowRoom;

import java.util.Map;

public interface ShowRoomService {
	public Map<String, Double> calculate();
	public Map<String, Double> myEarning();
	public double salesPersonEarning(long sid);
	public Boolean quotaComplete(long sid);
}
