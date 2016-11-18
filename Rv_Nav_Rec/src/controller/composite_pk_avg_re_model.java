package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class composite_pk_avg_re_model implements Serializable
{
   long scheme_code;
   java.util.Date start_dt;
   String Fund_Type;
	   
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public java.util.Date getStart_dt() {
		return start_dt;
	}
	public void setStart_dt(java.util.Date start_dt) {
		this.start_dt = start_dt;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	  
	   
	   
	   
}
