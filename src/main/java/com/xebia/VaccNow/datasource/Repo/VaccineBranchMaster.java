package com.xebia.VaccNow.datasource.Repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="VaccineBranchMaster")
public class VaccineBranchMaster {

	@Id
	@Column(name="MappingId")
	private int MappingId;

	@OneToOne
	@JoinColumn(name = "BranchCode")
	private BranchMaster BranchCode;
	
	@OneToOne
	@JoinColumn(name = "TimeSlotId")
	private TimeSlotMaster TimeSlotId ;
	

	@OneToOne
	@JoinColumn(name = "vaccineId")
	private VaccineMaster Vaccine;
	
	@Column(name="AvailabiltyCount")
	private int AvailabiltyCount;
	
	

	public int getMappingId() {
		return MappingId;
	}

	public void setMappingId(int mappingId) {
		MappingId = mappingId;
	}


	public int getAvailabiltyCount() {
		return AvailabiltyCount;
	}

	public void setAvailabiltyCount(int availabiltyCount) {
		AvailabiltyCount = availabiltyCount;
	}

	public TimeSlotMaster getTimeSlotId() {
		return TimeSlotId;
	}

	public void setTimeSlotId(TimeSlotMaster timeSlotId) {
		TimeSlotId = timeSlotId;
	}	
	
	public VaccineMaster getVaccine() {
		return Vaccine;
	}

	public BranchMaster getBranchCode() {
		return BranchCode;
	}

	public void setVaccine(VaccineMaster vaccine) {
		Vaccine = vaccine;
	}

	public void setBranchCode(BranchMaster branchCode) {
		BranchCode = branchCode;
	}
}
