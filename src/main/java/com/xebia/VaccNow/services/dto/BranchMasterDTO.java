package com.xebia.VaccNow.services.dto;

import java.util.List;

import com.xebia.VaccNow.datasource.Repo.BranchMaster;


public class BranchMasterDTO {

	String fetchMessage;
	private List<BranchMaster> list;
	ErrorDto error;
	
	public String getFetchMessage() {
		return fetchMessage;
	}
	public void setFetchMessage(String fetchMessage) {
		this.fetchMessage = fetchMessage;
	}
	public List<BranchMaster> getList() {
		return list;
	}
	public void setList(List<BranchMaster> list) {
		this.list = list;
	}
	public ErrorDto getError() {
		return error;
	}
	public void setError(ErrorDto error) {
		this.error = error;
	}
	
}
