package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scheme_Aum
{
   @Id	
   long id;	
   long scheme_code;
   java.util.Date day;
   double exfof;
   double fof;
   double total;
   
   
   
public long getId() {
	return id;
}
public long getScheme_code() {
	return scheme_code;
}
public java.util.Date getDay() {
	return day;
}
public double getExfof() {
	return exfof;
}
public double getFof() {
	return fof;
}
public double getTotal() {
	return total;
}
public void setId(long id) {
	this.id = id;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public void setDay(java.util.Date day) {
	this.day = day;
}
public void setExfof(double exfof) {
	this.exfof = exfof;
}
public void setFof(double fof) {
	this.fof = fof;
}
public void setTotal(double total) {
	this.total = total;
}
   
   
}
