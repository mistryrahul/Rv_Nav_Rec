package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class Report_6_pk implements Serializable
{
	java.util.Date from_date;
	long scheme_code;	
	String Fund_Type;
	
	
	public java.util.Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(java.util.Date from_date) {
		this.from_date = from_date;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	
	
	
	
}
