package com.example.Incentive.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShowRoom_Manager {

	@Id
	@GeneratedValue
	private long id;
	private long SID;
	private long Total_sum;

	public ShowRoom_Manager(long sID, long total_sum) {
		SID = sID;
		Total_sum = total_sum;
	}

	public long getSID() {
		return SID;
	}

	public void setSID(long sID) {
		SID = sID;
	}

	public long getTotal_sum() {
		return Total_sum;
	}

	public void setTotal_sum(long total_sum) {
		Total_sum = total_sum;
	}

}
