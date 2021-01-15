package com.xebia.VaccNow.services.dto;

import java.util.Date;

public class HospitalVaccinationDetailRequest {

	
	private int  vaccineId;
	
	private String branchCode;

	private Date vaccinationDate;
	
	private String paitentName;
	
	private String paitentAddress;
	
	private String paitentEmail;
	
	private int payModeid;
	
	private String payModeDetails;
	
	private int amount;
	
	private int timeSlotId;
	
	private String confirmMailSent;
	
	private String isVaccineApplied;
	
	private String bookingBy;
	
	private String bookingTime;


	public int getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(int vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public Date getVaccinationDate() {
		return vaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		this.vaccinationDate = vaccinationDate;
	}

	public String getPaitentName() {
		return paitentName;
	}

	public void setPaitentName(String paitentName) {
		this.paitentName = paitentName;
	}

	public String getPaitentAddress() {
		return paitentAddress;
	}

	public void setPaitentAddress(String paitentAddress) {
		this.paitentAddress = paitentAddress;
	}

	public String getPaitentEmail() {
		return paitentEmail;
	}

	public void setPaitentEmail(String paitentEmail) {
		this.paitentEmail = paitentEmail;
	}

	public int getPayModeid() {
		return payModeid;
	}

	public void setPayModeid(int payModeid) {
		this.payModeid = payModeid;
	}

	public String getPayModeDetails() {
		return payModeDetails;
	}

	public void setPayModeDetails(String payModeDetails) {
		this.payModeDetails = payModeDetails;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTimeSlotId() {
		return timeSlotId;
	}

	public void setTimeSlotId(int timeSlotId) {
		this.timeSlotId = timeSlotId;
	}

	public String getConfirmMailSent() {
		return confirmMailSent;
	}

	public void setConfirmMailSent(String confirmMailSent) {
		this.confirmMailSent = confirmMailSent;
	}

	public String getIsVaccineApplied() {
		return isVaccineApplied;
	}

	public void setIsVaccineApplied(String isVaccineApplied) {
		this.isVaccineApplied = isVaccineApplied;
	}

	public String getBookingBy() {
		return bookingBy;
	}

	public void setBookingBy(String bookingBy) {
		this.bookingBy = bookingBy;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	
}
