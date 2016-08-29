package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Qtr_Avg
{
   
	@Id
	String quarter;
	double average;
	
	
	
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
	
	
	
	
	
}
