package com.example.Incentive.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SalesPerson {

	@Id
	@GeneratedValue
	private long SId;

	private String Sname;

	@Column(unique = true)
	private String SPhone;

	private String Password;

	public SalesPerson(String sname, String sPhone, String password) {
		Sname = sname;
		SPhone = sPhone;
		Password = password;
	}

	public long getSId() {
		return SId;
	}

	public void setSId(long sId) {
		SId = sId;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSPhone() {
		return SPhone;
	}

	public void setSPhone(String sPhone) {
		SPhone = sPhone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

}
