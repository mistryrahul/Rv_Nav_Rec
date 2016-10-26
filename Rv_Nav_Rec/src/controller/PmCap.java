package controller;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PmCap 
{
	  @EmbeddedId
	  PmCap_Pk key;
	  
     
      double MCAP_of_the_Company;
      
     
    public void set_PmCap( PmCap ob)
    {
    	MCAP_of_the_Company =  ob.MCAP_of_the_Company;
    }
      
   
	public double getMCAP_of_the_Company() {
		return MCAP_of_the_Company;
	}


	public void setMCAP_of_the_Company(double mCAP_of_the_Company) {
		MCAP_of_the_Company = mCAP_of_the_Company;
	}


	public PmCap_Pk getKey() {
		return key;
	}


	public void setKey(PmCap_Pk key) {
		this.key = key;
	}



      
}
