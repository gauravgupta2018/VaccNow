package com.xebia.VaccNow.datasource.Repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PaymentDetails")
public class PaymentDetails {

	@Id
	@Column(name="ModeID")
	private int ModeID;
	
	@Column(name="ModeName")
	private String ModeName;
	
	@Column(name="ModeDetails")
	private String ModeDetails;

	public int getModeID() {
		return ModeID;
	}

	public void setModeID(int modeID) {
		ModeID = modeID;
	}

	public String getModeName() {
		return ModeName;
	}

	public void setModeName(String modeName) {
		ModeName = modeName;
	}

	public String getModeDetails() {
		return ModeDetails;
	}

	public void setModeDetails(String modeDetails) {
		ModeDetails = modeDetails;
	}
	
}
