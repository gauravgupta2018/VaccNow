package com.xebia.VaccNow.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.VaccNow.datasource.Repo.BranchMasterRepo;
import com.xebia.VaccNow.datasource.Repo.HosipltalVaccinationDetals;
import com.xebia.VaccNow.datasource.Repo.TimeSlotMaster;
import com.xebia.VaccNow.services.dto.BranchMasterDTO;
import com.xebia.VaccNow.services.dto.BranchTime;
import com.xebia.VaccNow.services.dto.BranchTimeDto;
import com.xebia.VaccNow.services.dto.ErrorDto;
import com.xebia.VaccNow.services.dto.HospitalVaccinationDetailRequest;
import com.xebia.VaccNow.services.dto.SavePatientDetailDTO;
import com.xebia.VaccNow.services.dto.VaccinationDetailDTO;
import com.xebia.VaccNow.services.dto.VaccineDetails;
import com.xebia.VaccNow.services.dto.VaccineInfo;
import com.xebia.VaccNow.services.dto.VaccineInfoDto;
import com.xebia.VaccNow.util.VaccNowUtil;

@Service
public class VaccinationService {

	@Autowired
	BranchMasterRepo branchRepo;
	
    Logger logger = LoggerFactory.getLogger(VaccinationService.class);

	
	public BranchMasterDTO getAllBranches() {
		logger.info("**********Started executing the vaccination service****************");

		BranchMasterDTO dto = new BranchMasterDTO();
		try {

			dto.setList(branchRepo.getAllBranches());
			dto.setFetchMessage("Records fetched from server sucessfully.");
			
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}
		return dto;
	}
	
	public VaccineInfoDto getAllVaccineInfo() {

		logger.info("**********Started executing the vaccination service****************");

		VaccineInfoDto dto = new VaccineInfoDto();
		try {
			List<Object[]> resultList = branchRepo.getAllVaccineInfoAllBranch();
			List<VaccineInfo> vaccineInfoList = new ArrayList<VaccineInfo>();

			if (resultList.size() > 0) {
				for (Object[] o : resultList) {
					VaccineInfo b = new VaccineInfo();

					b.setAvailabiltyCount(o[3].toString());
					b.setBranchCode((String) o[0]);
					b.setVaccineCode((String) o[2]);
					b.setVaccineName((String) o[1]);
					vaccineInfoList.add(b);
				}
				dto.setVaccineInfo(vaccineInfoList);
				dto.setFetchMessage("Records fetched from server sucessfully.");
			} else {

				dto.setFetchMessage("No Records return from server.");
			}

		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}
		return dto;
	
	}
	
	
	public VaccineInfoDto getAllVaccineInfoAllParticularBranch(String branchCode) {

		logger.info("**********Started executing the vaccination service****************");

		VaccineInfoDto dto = new VaccineInfoDto();
		try {
			List<Object[]> resultList = branchRepo.getAllVaccineInfoAllParticularBranch(branchCode);
			List<VaccineInfo> vaccineInfoList = new ArrayList<VaccineInfo>();

			if (resultList.size() > 0) {
				for (Object[] o : resultList) {
					VaccineInfo b = new VaccineInfo();

					b.setAvailabiltyCount(o[3].toString());
					b.setBranchCode((String) o[0]);
					b.setVaccineCode((String) o[2]);
					b.setVaccineName((String) o[1]);
					vaccineInfoList.add(b);
				}
				dto.setVaccineInfo(vaccineInfoList);
				dto.setFetchMessage("Records fetched from server sucessfully.");
			} else {

				dto.setFetchMessage("No Records return from server.");
			}

		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}
		return dto;
	}

	public BranchTimeDto getTimeForBanch(String branchCode) {

		logger.info("**********Started executing the vaccination service****************");
		BranchTimeDto dto = new BranchTimeDto();

		try {
			List<TimeSlotMaster> resultList = branchRepo.getTimeForBanch(branchCode);

			List<BranchTime> branchTimeList = new ArrayList<BranchTime>();

			if (resultList.size() > 0) {
				for (TimeSlotMaster details : resultList) {
					BranchTime b = new BranchTime();

					b.setAvailableTime(details.getStartTime() + " - " + details.getEndTime());
					b.setBranchCode(branchCode);

					branchTimeList.add(b);
				}
				dto.setBranchTimeList(branchTimeList);
				dto.setFetchStatus("Records fetched from server sucessfully.");
			} else {

				dto.setFetchStatus("No Records return from server.");
			}
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}

		return dto;

	}
	
	public VaccinationDetailDTO getVaccinationPerBranch(String branchCode) {

		logger.info("**********Started executing the vaccination service****************");
		VaccinationDetailDTO dto = new VaccinationDetailDTO();

		try {
			List<HosipltalVaccinationDetals> resultList = branchRepo.getAllAppliedVaccines(branchCode);

			List<VaccineDetails> vaccineList = new ArrayList<VaccineDetails>();

			if (resultList.size() > 0) {
				for (HosipltalVaccinationDetals details : resultList) {
					VaccineDetails v = new VaccineDetails();

					v.setAmount(String.valueOf(details.getAmount()));
					v.setBranchCode(details.getBranchCode());
					v.setPatientAddress(details.getPaitentAddress());
					v.setPatientEmail(details.getPaitentEmail());
					v.setPatientName(details.getPaitentName());
					v.setTimeSlot(
							details.getTimeSlotId().getStartTime() + " - " + details.getTimeSlotId().getEndTime());
					v.setVaccineDate(details.getVaccinationDate().toString());
					v.setVaccineName(details.getVaccine().getVaccineName());
					vaccineList.add(v);
				}
				dto.setVaccineDetailsList(vaccineList);
				dto.setFetchMessage("Records fetched from server sucessfully.");
			} else {

				dto.setFetchMessage("No Records return from server.");
			}
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}

		return dto;
	}
	
	public VaccinationDetailDTO getVaccinationPerDay(String date) {

		logger.info("**********Started executing the vaccination service****************");
		VaccinationDetailDTO dto = new VaccinationDetailDTO();

		try {

			Date inputDate = VaccNowUtil.formatdate(date);
			List<HosipltalVaccinationDetals> resultList = branchRepo.getAllAppliedVaccinesPerDay(inputDate);
			List<VaccineDetails> vaccineList = new ArrayList<VaccineDetails>();

			if (resultList.size() > 0) {
				for (HosipltalVaccinationDetals details : resultList) {
					VaccineDetails v = new VaccineDetails();

					v.setAmount(String.valueOf(details.getAmount()));
					v.setBranchCode(details.getBranchCode());
					v.setPatientAddress(details.getPaitentAddress());
					v.setPatientEmail(details.getPaitentEmail());
					v.setPatientName(details.getPaitentName());
					v.setTimeSlot(
							details.getTimeSlotId().getStartTime() + " - " + details.getTimeSlotId().getEndTime());
					v.setVaccineDate(details.getVaccinationDate().toString());
					v.setVaccineName(details.getVaccine().getVaccineName());
					vaccineList.add(v);
				}
				dto.setVaccineDetailsList(vaccineList);
				dto.setFetchMessage("Records fetched from server sucessfully.");
			} else {

				dto.setFetchMessage("No Records return from server.");
			}
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}

		return dto;
	}
	
	public VaccinationDetailDTO getVaccinationForTimePeriod(String inputDate, String outputDate) {

		logger.info("**********Started executing the vaccination service****************");
		VaccinationDetailDTO dto = new VaccinationDetailDTO();

		try {

			Date parsedInputDate = VaccNowUtil.formatdate(inputDate);
			Date parsedOutputDate =  VaccNowUtil.formatdate(outputDate);
			List<HosipltalVaccinationDetals> resultList = branchRepo.getAllConfirmedVaccinationsOveraTimePerid(parsedInputDate, parsedOutputDate);
			List<VaccineDetails> vaccineList = new ArrayList<VaccineDetails>();

			if (resultList.size() > 0) {
				for (HosipltalVaccinationDetals details : resultList) {
					VaccineDetails v = new VaccineDetails();

					v.setAmount(String.valueOf(details.getAmount()));
					v.setBranchCode(details.getBranchCode());
					v.setPatientAddress(details.getPaitentAddress());
					v.setPatientEmail(details.getPaitentEmail());
					v.setPatientName(details.getPaitentName());
					v.setTimeSlot(
							details.getTimeSlotId().getStartTime() + " - " + details.getTimeSlotId().getEndTime());
					v.setVaccineDate(details.getVaccinationDate().toString());
					v.setVaccineName(details.getVaccine().getVaccineName());
					vaccineList.add(v);
				}
				dto.setVaccineDetailsList(vaccineList);
				dto.setFetchMessage("Records fetched from server sucessfully.");
			} else {

				dto.setFetchMessage("No Records return from server.");
			}
		} catch (Exception e) {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}

		return dto;
	}

	public SavePatientDetailDTO savePatientDetails(HospitalVaccinationDetailRequest request) {	
		
		SavePatientDetailDTO dto = new SavePatientDetailDTO();
		String message =  branchRepo.savePatientDetails(request);
		
		if("SUCCESS".equals(message)) {
			dto.setMessage("Details saved to DB");
		}
		else {
			ErrorDto error = new ErrorDto();
			error.setErrorCode("500");
			error.setErrorMessage("An internal error has occured while fetching records");
			dto.setError(error);
		}
		return dto;
	}
	
}
