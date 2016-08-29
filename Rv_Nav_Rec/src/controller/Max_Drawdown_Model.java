package controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Max_Drawdown_Model 
{
   @Id	
   @GeneratedValue(strategy=GenerationType.AUTO)	
   int id;	
   long scheme_code;
   java.util.Date start_date;
   java.util.Date end_date;
   double max_drawdown;
   
      
public long getScheme_code() {
	return scheme_code;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public java.util.Date getStart_date() {
	return start_date;
}
public void setStart_date(java.util.Date start_date) {
	this.start_date = start_date;
}
public java.util.Date getEnd_date() {
	return end_date;
}
public void setEnd_date(java.util.Date end_date) {
	this.end_date = end_date;
}
public double getMax_drawdown() {
	return max_drawdown;
}
public void setMax_drawdown(double max_drawdown) {
	this.max_drawdown = max_drawdown;
}
   
   
}
