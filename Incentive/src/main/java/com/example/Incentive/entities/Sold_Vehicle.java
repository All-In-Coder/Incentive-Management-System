package com.example.Incentive.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sold_Vehicle {

	@Id
	@GeneratedValue
	private long id;
	private long VId;
	private long SID;
	private long VType;
	private String VName;
	private long Sell_Price;
	private double Commission;
	private Boolean isQuota;

	
	public Sold_Vehicle() {
	}



	public Sold_Vehicle(long vId,long SID, long vType, String VName, long sell_Price, double commission,
			Boolean isQuota) {
		VId = vId;
		this.SID = SID;
		Sell_Price = sell_Price;
		Commission = commission;
		this.isQuota = isQuota;
		VType = vType;
		this.VName = VName;
	}

	

	public long getVId() {
		return VId;
	}

	public void setVId(long vId) {
		VId = vId;
	}

	public long getSell_Price() {
		return Sell_Price;
	}

	public void setSell_Price(long sell_Price) {
		Sell_Price = sell_Price;
	}

	public double getCommission() {
		return Commission;
	}

	public void setCommission(double commission) {
		Commission = commission;
	}

	public Boolean getIsQuota() {
		return isQuota;
	}

	public void setIsQuota(Boolean isQuota) {
		this.isQuota = isQuota;
	}

	public long getVType() {
		return VType;
	}

	public void setVType(long vType) {
		VType = vType;
	}

	public String getVName() {
		return VName;
	}

	public void setVName(String vName) {
		VName = vName;
	}



	public long getSID() {
		return SID;
	}



	public void setSID(long sID) {
		SID = sID;
	}

}
