package com.xebia.VaccNow.services.dto;

import java.util.List;

public class VaccineInfoDto {

	private String fetchMessage;
	private List<VaccineInfo> vaccineInfo;
	private ErrorDto error;
	public String getFetchMessage() {
		return fetchMessage;
	}
	public void setFetchMessage(String fetchMessage) {
		this.fetchMessage = fetchMessage;
	}
	public List<VaccineInfo> getVaccineInfo() {
		return vaccineInfo;
	}
	public void setVaccineInfo(List<VaccineInfo> vaccineInfo) {
		this.vaccineInfo = vaccineInfo;
	}
	public ErrorDto getError() {
		return error;
	}
	public void setError(ErrorDto error) {
		this.error = error;
	}
	
}
