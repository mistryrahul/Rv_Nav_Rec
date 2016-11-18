package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class composite_pk implements Serializable
{
	   java.util.Date date_ori;
	   long scheme_code;
	   String Fund_Type;
	   	
	public java.util.Date getDate_ori() {
		return date_ori;
	}
	public void setDate_ori(java.util.Date date_ori) {
		this.date_ori = date_ori;
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
