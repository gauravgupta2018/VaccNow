package com.xebia.VaccNow.services.dto;

import java.util.List;

public class VaccinationDetailDTO {

	String fetchMessage;
	List<VaccineDetails> vaccineDetailsList;

	ErrorDto error;

	public List<VaccineDetails> getVaccineDetailsList() {
		return vaccineDetailsList;
	}

	public void setVaccineDetailsList(List<VaccineDetails> vaccineDetailsList) {
		this.vaccineDetailsList = vaccineDetailsList;
	}

	public ErrorDto getError() {
		return error;
	}

	public void setError(ErrorDto error) {
		this.error = error;
	}

	public String getFetchMessage() {
		return fetchMessage;
	}

	public void setFetchMessage(String fetchMessage) {
		this.fetchMessage = fetchMessage;
	}
}
