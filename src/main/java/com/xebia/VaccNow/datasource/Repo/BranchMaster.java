package com.xebia.VaccNow.datasource.Repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BranchMaster")
public class BranchMaster {


	@Id
	@Column(name="BranchId")
	private int BranchId;
	
	@Column(name="BranchCode")
	private String BranchCode;
	
	@Column(name="BranchName")
	private String BranchName;
	
	@Column(name="BranchAddress")
	private String BranchAddress;
	
	@Column(name="BranchCity")
	private String BranchCity;
	
	@Column(name="BranchStateCode")
	private String BranchStateCode;

/*	@ManyToOne
    @JoinColumn(name="VaccineId")
    private VaccineMaster vaccineMaster;
*/
	
	public int getBranchId() {
		return BranchId;
	}

	public void setBranchId(int branchId) {
		BranchId = branchId;
	}

	public String getBranchCode() {
		return BranchCode;
	}

	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}

/*	public VaccineMaster getVaccineMaster() {
		return vaccineMaster;
	}

	public void setVaccineMaster(VaccineMaster vaccineMaster) {
		this.vaccineMaster = vaccineMaster;
	}*/

	public String getBranchName() {
		return BranchName;
	}

	public void setBranchName(String branchName) {
		BranchName = branchName;
	}

	public String getBranchAddress() {
		return BranchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		BranchAddress = branchAddress;
	}

	public String getBranchCity() {
		return BranchCity;
	}

	public void setBranchCity(String branchCity) {
		BranchCity = branchCity;
	}

	public String getBranchStateCode() {
		return BranchStateCode;
	}

	public void setBranchStateCode(String branchStateCode) {
		BranchStateCode = branchStateCode;
	}


}
