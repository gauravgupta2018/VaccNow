package com.xebia.VaccNow.datasource.Repo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HosipltalVaccinationDetals")
public class HosipltalVaccinationDetals {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TransID")
	private int TransID;
	
	@OneToOne
	@JoinColumn(name = "vaccineId")
	private VaccineMaster vaccine;
	
	@Column(name="BranchCode")
	private String BranchCode;
	
	@Column(name="VaccinationDate")
	@Temporal(TemporalType.DATE)
	private Date VaccinationDate;
	
	@Column(name="PaitentName")
	private String PaitentName;
	
	@Column(name="PaitentAddress")
	private String PaitentAddress;
	
	@Column(name="PaitentEmail")
	private String PaitentEmail;
	
	@Column(name="PayModeid")
	private int PayModeid;
	
	@Column(name="PayModeDetails")
	private String PayModeDetails;
	
	@Column(name="Amount")
	private int Amount;
	
	@OneToOne
	@JoinColumn(name = "TimeSlotId")
	private TimeSlotMaster TimeSlotId;
	
	@Column(name="ConfirmMailSent")
	private String ConfirmMailSent;
	
	@Column(name="IsVaccineApplied")
	private String IsVaccineApplied;
	
	@Column(name="BookingBy")
	private String BookingBy;
	
	@Column(name="BookingTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date BookingTime;

	public int getTransID() {
		return TransID;
	}

	public void setTransID(int transID) {
		TransID = transID;
	}

	public VaccineMaster getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineMaster vaccine) {
		this.vaccine = vaccine;
	}

	public String getBranchCode() {
		return BranchCode;
	}

	public void setBranchCode(String branchCode) {
		BranchCode = branchCode;
	}

	public Date getVaccinationDate() {
		return VaccinationDate;
	}

	public void setVaccinationDate(Date vaccinationDate) {
		VaccinationDate = vaccinationDate;
	}

	public String getPaitentName() {
		return PaitentName;
	}

	public void setPaitentName(String paitentName) {
		PaitentName = paitentName;
	}

	public String getPaitentAddress() {
		return PaitentAddress;
	}

	public void setPaitentAddress(String paitentAddress) {
		PaitentAddress = paitentAddress;
	}

	public String getPaitentEmail() {
		return PaitentEmail;
	}

	public void setPaitentEmail(String paitentEmail) {
		PaitentEmail = paitentEmail;
	}

	public int getPayModeid() {
		return PayModeid;
	}

	public void setPayModeid(int payModeid) {
		PayModeid = payModeid;
	}

	public String getPayModeDetails() {
		return PayModeDetails;
	}

	public void setPayModeDetails(String payModeDetails) {
		PayModeDetails = payModeDetails;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public TimeSlotMaster getTimeSlotId() {
		return TimeSlotId;
	}

	public void setTimeSlotId(TimeSlotMaster timeSlotId) {
		TimeSlotId = timeSlotId;
	}

	public String getConfirmMailSent() {
		return ConfirmMailSent;
	}

	public void setConfirmMailSent(String confirmMailSent) {
		ConfirmMailSent = confirmMailSent;
	}

	public String getIsVaccineApplied() {
		return IsVaccineApplied;
	}

	public void setIsVaccineApplied(String isVaccineApplied) {
		IsVaccineApplied = isVaccineApplied;
	}

	public String getBookingBy() {
		return BookingBy;
	}

	public void setBookingBy(String bookingBy) {
		BookingBy = bookingBy;
	}

	public Date getBookingTime() {
		return BookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		BookingTime = bookingTime;
	}
	
	
}

