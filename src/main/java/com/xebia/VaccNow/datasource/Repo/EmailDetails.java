package com.xebia.VaccNow.datasource.Repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EmailDetails")
public class EmailDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@OneToOne
	@JoinColumn(name = "TransID")
	private HosipltalVaccinationDetals detail;  
	
	@JoinColumn(name = "emailAddess")
	private String emailAddess; 
	
	@JoinColumn(name = "MailSubject")
	private String MailSubject; 
	
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public HosipltalVaccinationDetals getDetail() {
		return detail;
	}

	public void setDetail(HosipltalVaccinationDetals detail) {
		this.detail = detail;
	}

	public String getEmailAddess() {
		return emailAddess;
	}

	public void setEmailAddess(String emailAddess) {
		this.emailAddess = emailAddess;
	}

	public String getMailSubject() {
		return MailSubject;
	}

	public void setMailSubject(String mailSubject) {
		MailSubject = mailSubject;
	}

	public String getMailContent() {
		return MailContent;
	}

	public void setMailContent(String mailContent) {
		MailContent = mailContent;
	}

	@JoinColumn(name = "MailContent")
	private String MailContent; 
	
}
