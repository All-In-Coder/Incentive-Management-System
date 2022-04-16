package com.example.Incentive.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long VId;
	private String Vname;
	private long Act_Price;
	private long VType;
	
	public Vehicle(String vname, long act_Price, long vType) {
		Vname = vname;
		Act_Price = act_Price;
		VType = vType;
	}
	
	public long getVId() {
		return VId;
	}

	public void setVId(long vId) {
		VId = vId;
	}

	public String getVname() {
		return Vname;
	}

	public void setVname(String vname) {
		Vname = vname;
	}

	public long getAct_Price() {
		return Act_Price;
	}

	public void setAct_Price(Integer act_Price) {
		Act_Price = act_Price;
	}

	public long getVType() {
		return VType;
	}

	public void setVType(long vType) {
		VType = vType;
	}

	

}
