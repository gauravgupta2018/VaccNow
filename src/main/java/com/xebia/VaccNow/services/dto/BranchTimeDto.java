package com.xebia.VaccNow.services.dto;

import java.util.List;

public class BranchTimeDto {

	private String fetchStatus;
	private List<BranchTime> branchTimeList;
	private ErrorDto error;
	
	public String getFetchStatus() {
		return fetchStatus;
	}
	public void setFetchStatus(String fetchStatus) {
		this.fetchStatus = fetchStatus;
	}
	public List<BranchTime> getBranchTimeList() {
		return branchTimeList;
	}
	public void setBranchTimeList(List<BranchTime> branchTimeList) {
		this.branchTimeList = branchTimeList;
	}
	public ErrorDto getError() {
		return error;
	}
	public void setError(ErrorDto error) {
		this.error = error;
	}
}


