package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Qtr_Avg
{
   
	@Id
	String quarter;
	double average;
	String Fund_Type; //fund type also should be primary key but do it from database
	
	
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	
	
	
	
	
}
