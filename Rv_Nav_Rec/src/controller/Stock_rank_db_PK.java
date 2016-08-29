package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Stock_rank_db_PK implements Serializable
{
	long accord_code;
	java.util.Date day;
	
	
	public long getAccord_code() {
		return accord_code;
	}
	public java.util.Date getDay() {
		return day;
	}
	public void setAccord_code(long accord_code) {
		this.accord_code = accord_code;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	
	
	
}
