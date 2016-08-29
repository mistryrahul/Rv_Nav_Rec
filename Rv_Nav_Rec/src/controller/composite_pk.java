package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class composite_pk implements Serializable
{
	   java.util.Date date_ori;
	   long scheme_code;
	  
	   	
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
	   
	   
	   
}
