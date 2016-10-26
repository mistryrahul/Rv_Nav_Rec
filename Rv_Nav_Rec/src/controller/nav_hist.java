package controller;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="nav_hist_full_test" )
//@Entity(name="nav_hist_full" )
public class nav_hist implements Serializable
{
	
	
//	@GenericGenerator(
//	        name = "sequence", 
//	        strategy = "sequence", 
//	        parameters = {
//	            @org.hibernate.annotations.Parameter(
//	                name = "sequence", 
//	                value = "sequence"
//	            )
//	         
//	    })
//	    @GeneratedValue(generator = "sequence")
	
	@Id
	long id;
	
	int scheme_code;
	
	java.util.Date nav_date;
	
	double navrs;
	double adjnavrs;
	double repurprice;
	double saleprice;
		   
  
	public double getAdjnavrs() {
		return adjnavrs;
	}
	public void setAdjnavrs(double adjnavrs) {
		this.adjnavrs = adjnavrs;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(int scheme_code) {
		this.scheme_code = scheme_code;
	}
	public java.util.Date getNav_date() {
		return nav_date;
	}
	public void setNav_date(java.util.Date nav_date) {
		this.nav_date = nav_date;
	}
	public double getNavrs() {
		return navrs;
	}
	public void setNavrs(double navrs) {
		this.navrs = navrs;
	}
	public double getRepurprice() {
		return repurprice;
	}
	public void setRepurprice(double repurprice) {
		this.repurprice = repurprice;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	
	   

}
