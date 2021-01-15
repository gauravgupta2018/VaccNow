package com.xebia.VaccNow.datasource.Repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TimeSlotMaster")
public class TimeSlotMaster {

	@Id
	@Column(name="TimeSlotId")
	private int TimeSlotId;
	
	public int getTimeSlotId() {
		return TimeSlotId;
	}

	public void setTimeSlotId(int timeSlotId) {
		TimeSlotId = timeSlotId;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	@Column(name="StartTime")
	private String StartTime;
	
	@Column(name="EndTime")
	private String EndTime;
	
}
