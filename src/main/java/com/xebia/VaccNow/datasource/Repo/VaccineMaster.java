package com.xebia.VaccNow.datasource.Repo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="VaccineMaster")
public class VaccineMaster {

	@Id
	@Column(name="VaccineId")
	private int VaccineId;
	
	@Column(name="VaccineCode")
	private String VaccineCode;
	
	@Column(name="VaccineName")
	private String VaccineName;
	
/*	@OneToMany(mappedBy="vaccineMaster")
    private List<BranchMaster> branches;

	public List<BranchMaster> getBranches() {
		return branches;
	}

	public void setBranches(List<BranchMaster> branches) {
		this.branches = branches;
	}*/

	public int getVaccineId() {
		return VaccineId;
	}

	public void setVaccineId(int vaccineId) {
		VaccineId = vaccineId;
	}

	public String getVaccineCode() {
		return VaccineCode;
	}

	public void setVaccineCode(String vaccineCode) {
		VaccineCode = vaccineCode;
	}

	public String getVaccineName() {
		return VaccineName;
	}

	public void setVaccineName(String vaccineName) {
		VaccineName = vaccineName;
	}
	
	
}
