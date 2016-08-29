package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExpenceRatio 
{
   @Id	
   long id;
   long amc_code;
   long scheme_code;
   java.util.Date day;
   double ex_ratio;
   
   
   
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getAmc_code() {
	return amc_code;
}
public void setAmc_code(long amc_code) {
	this.amc_code = amc_code;
}
public long getScheme_code() {
	return scheme_code;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public java.util.Date getDay() {
	return day;
}
public void setDay(java.util.Date day) {
	this.day = day;
}
public double getEx_ratio() {
	return ex_ratio;
}
public void setEx_ratio(double ex_ratio) {
	this.ex_ratio = ex_ratio;
}
   
   
   
	
	
}
