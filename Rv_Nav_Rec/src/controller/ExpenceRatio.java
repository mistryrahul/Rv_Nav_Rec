package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import debt_Controller.Pk_generic;

@Entity
public class ExpenceRatio 
{
   @EmbeddedId
   Pk_generic key;
   long amc_code;
   double ex_ratio;
   

public Pk_generic getKey() {
	return key;
}
public void setKey(Pk_generic key) {
	this.key = key;
}
public long getAmc_code() {
	return amc_code;
}
public void setAmc_code(long amc_code) {
	this.amc_code = amc_code;
}
public double getEx_ratio() {
	return ex_ratio;
}
public void setEx_ratio(double ex_ratio) {
	this.ex_ratio = ex_ratio;
}
   
   
   
	
	
}
