package controller;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Mf_portfolio_Model
{
   @Id	
   long id;	 
   long scheme_code;
   java.util.Date inv_date;
   String comp_name;
   double holding_prcnt;
   long fin_code;
   String classification;
   String rv_sect_name;
   
  
   


public long getScheme_code() {
	return scheme_code;
}
public java.util.Date getInv_date() {
	return inv_date;
}
public String getComp_name() {
	return comp_name;
}
public double getHolding_prcnt() {
	return holding_prcnt;
}
public long getFin_code() {
	return fin_code;
}
public String getClassification() {
	return classification;
}
public String getRv_sect_name() {
	return rv_sect_name;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public void setInv_date(java.util.Date inv_date) {
	this.inv_date = inv_date;
}
public void setComp_name(String comp_name) {
	this.comp_name = comp_name;
}
public void setHolding_prcnt(double holding_prcnt) {
	this.holding_prcnt = holding_prcnt;
}
public void setFin_code(long fin_code) {
	this.fin_code = fin_code;
}
public void setClassification(String classification) {
	this.classification = classification;
}
public void setRv_sect_name(String rv_sect_name) {
	this.rv_sect_name = rv_sect_name;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}



   	
}
