package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class nav_hist_updator_PK implements Serializable 
{
	java.util.Date nav_date;
	
	long scheme_code;
	
	
	public java.util.Date getNav_date() {
		return nav_date;
	}
	public void setNav_date(java.util.Date nav_date) {
		this.nav_date = nav_date;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	
	
}
