package com.xebia.VaccNow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.VaccNow.services.VaccinationService;
import com.xebia.VaccNow.services.dto.BranchMasterDTO;
import com.xebia.VaccNow.services.dto.BranchTimeDto;
import com.xebia.VaccNow.services.dto.HospitalVaccinationDetailRequest;
import com.xebia.VaccNow.services.dto.SavePatientDetailDTO;
import com.xebia.VaccNow.services.dto.VaccinationDetailDTO;
import com.xebia.VaccNow.services.dto.VaccineInfoDto;

@RestController
public class VacinationContoller {

	
	@RequestMapping(method = RequestMethod.GET, path="/healthCheck")
	public String healthCheck() {
		return "VaccNow App is running";
	}
	
	@Autowired
	VaccinationService vaccService;
	
	@RequestMapping(method = RequestMethod.GET, path="/api/getAllBranches")
		public ResponseEntity<BranchMasterDTO> branches(){
		
		BranchMasterDTO response = vaccService.getAllBranches();
		
		if(response.getError() == null)
			return new ResponseEntity<BranchMasterDTO>(response, HttpStatus.OK);
			
			else return new ResponseEntity<BranchMasterDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
	@RequestMapping(method = RequestMethod.GET, path="/api/vaccineAllBranches")
	public ResponseEntity<VaccineInfoDto> getAllVaccineInfo(){
		
		VaccineInfoDto response  = vaccService.getAllVaccineInfo();
		if(response.getError() == null)
		return new ResponseEntity<VaccineInfoDto>(response, HttpStatus.OK);
		
		else return new ResponseEntity<VaccineInfoDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/api/vaccineInfoBranch")
	public ResponseEntity<VaccineInfoDto> getVaccineInfoPerBranch(@RequestParam(name="branch") String branchCode){
		
		VaccineInfoDto response  = vaccService.getAllVaccineInfoAllParticularBranch(branchCode);
		if(response.getError() == null)
		return new ResponseEntity<VaccineInfoDto>(response, HttpStatus.OK);
		
		else return new ResponseEntity<VaccineInfoDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/api/vaccTimeBranch")
	public ResponseEntity<BranchTimeDto> getVaccineTimePerBranch(@RequestParam(name="branch") String branchCode){
		
		BranchTimeDto response  = vaccService.getTimeForBanch(branchCode);
		if(response.getError() == null)
		return new ResponseEntity<BranchTimeDto>(response, HttpStatus.OK);
		
		else return new ResponseEntity<BranchTimeDto>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path="/api/vaccine")
	public ResponseEntity<VaccinationDetailDTO> getVaccinePerBranch(@RequestParam(name="branch") String branchCode){
		
		VaccinationDetailDTO response  = vaccService.getVaccinationPerBranch(branchCode);
		if(response.getError() == null)
		return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.OK);
		
		else return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/api/vaccinePerDay")
	public ResponseEntity<VaccinationDetailDTO> getVaccinePerDay(@RequestParam(name="date") String date){
		
		VaccinationDetailDTO response  = vaccService.getVaccinationPerDay(date);
		if(response.getError() == null)
		return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.OK);
		
		else return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/api/confirmedVaccine")
	public ResponseEntity<VaccinationDetailDTO> getAllConfirmedVacineForTimePeriod(@RequestParam(name="inputDate") String inputDate, @RequestParam(name="outputDate") String outputDate){
		
		VaccinationDetailDTO response  = vaccService.getVaccinationForTimePeriod(inputDate, outputDate);
		if(response.getError() == null)
		return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.OK);
		
		else return new ResponseEntity<VaccinationDetailDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, path="/api/savePatientDetails")
	public ResponseEntity<SavePatientDetailDTO> savePatientDetails(@RequestBody HospitalVaccinationDetailRequest request){
		
		SavePatientDetailDTO response = vaccService.savePatientDetails(request);
		if(response.getError() == null)
		return new ResponseEntity<SavePatientDetailDTO>(response, HttpStatus.OK);
		else return new ResponseEntity<SavePatientDetailDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
