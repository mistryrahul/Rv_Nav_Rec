package controller;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Mf_portfolio_New 
{
   
   @EmbeddedId	
   MF_portfolio_pk key;	
	
   Date inv_end_date;
   long fincode;
   long asect_code;
   long sect_code;
   double noshares;
   double mktval;
   double aum;
   double holdpercentage;
   String compname;
   String sect_name;
   String asect_name;
   String rating;
   
   
   
public MF_portfolio_pk getKey() {
	return key;
}
public void setKey(MF_portfolio_pk key) {
	this.key = key;
}
public Date getInv_end_date() {
	return inv_end_date;
}
public void setInv_end_date(Date inv_end_date) {
	this.inv_end_date = inv_end_date;
}
public long getFincode() {
	return fincode;
}
public void setFincode(long fincode) {
	this.fincode = fincode;
}
public long getAsect_code() {
	return asect_code;
}
public void setAsect_code(long asect_code) {
	this.asect_code = asect_code;
}
public long getSect_code() {
	return sect_code;
}
public void setSect_code(long sect_code) {
	this.sect_code = sect_code;
}
public double getNoshares() {
	return noshares;
}
public void setNoshares(double noshares) {
	this.noshares = noshares;
}
public double getMktval() {
	return mktval;
}
public void setMktval(double mktval) {
	this.mktval = mktval;
}
public double getAum() {
	return aum;
}
public void setAum(double aum) {
	this.aum = aum;
}
public double getHoldpercentage() {
	return holdpercentage;
}
public void setHoldpercentage(double holdpercentage) {
	this.holdpercentage = holdpercentage;
}
public String getCompname() {
	return compname;
}
public void setCompname(String compname) {
	this.compname = compname;
}
public String getSect_name() {
	return sect_name;
}
public void setSect_name(String sect_name) {
	this.sect_name = sect_name;
}
public String getAsect_name() {
	return asect_name;
}
public void setAsect_name(String asect_name) {
	this.asect_name = asect_name;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
   
   
   
   
}
