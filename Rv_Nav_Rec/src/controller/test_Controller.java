package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class test_Controller 
{
	@Id
	long id; 
	java.util.Date from_date;
    String quarter;
    long scheme_code;
    
    
	public long getId() {
		return id;
	}
	public java.util.Date getFrom_date() {
		return from_date;
	}
	public String getQuarter() {
		return quarter;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setFrom_date(java.util.Date from_date) {
		this.from_date = from_date;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
    
    
    
    
}
