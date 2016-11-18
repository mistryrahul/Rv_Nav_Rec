package controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="nav_report_final")
public class nav_report_3_stable 
{
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  long id;	
	  long scheme_Code;
	  java.util.Date nav_from_date;
	  java.util.Date nav_date;
	  double nav_value;
	  String comment;
	  String Fund_Type;
	  
	  
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getScheme_Code() {
		return scheme_Code;
	}
	public void setScheme_Code(long scheme_Code) {
		this.scheme_Code = scheme_Code;
	}
	public java.util.Date getNav_from_date() {
		return nav_from_date;
	}
	public void setNav_from_date(java.util.Date nav_from_date) {
		this.nav_from_date = nav_from_date;
	}
	public java.util.Date getNav_date() {
		return nav_date;
	}
	public void setNav_date(java.util.Date nav_date) {
		this.nav_date = nav_date;
	}
	public double getNav_value() {
		return nav_value;
	}
	public void setNav_value(double nav_value) {
		this.nav_value = nav_value;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	  
	  
	
}
