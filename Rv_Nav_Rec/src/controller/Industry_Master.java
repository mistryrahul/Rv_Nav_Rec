package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Industry_Master 
{
   @Id	
   long Ind_code;
   
   String Industry;
   String Ind_ShortName;
   String Sector;
   
   
public long getInd_code() {
	return Ind_code;
}
public void setInd_code(long ind_code) {
	Ind_code = ind_code;
}
public String getIndustry() {
	return Industry;
}
public void setIndustry(String industry) {
	Industry = industry;
}
public String getInd_ShortName() {
	return Ind_ShortName;
}
public void setInd_ShortName(String ind_ShortName) {
	Ind_ShortName = ind_ShortName;
}
public String getSector() {
	return Sector;
}
public void setSector(String sector) {
	Sector = sector;
}
         
   
}
