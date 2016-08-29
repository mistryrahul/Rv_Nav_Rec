package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="avg_return")
public class Avg_ret_Model 
{
   
   @EmbeddedId
   private composite_pk_avg_re_model key;
   
   java.util.Date end_dt;
   double nav_val;
   String comment;
   int return_value;
   int rank;
   
   
      
public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
public composite_pk_avg_re_model getKey() {
	return key;
}
public void setKey(composite_pk_avg_re_model key) {
	this.key = key;
}
public java.util.Date getEnd_dt() {
	return end_dt;
}
public void setEnd_dt(java.util.Date end_dt) {
	this.end_dt = end_dt;
}
public double getNav_val() {
	return nav_val;
}
public void setNav_val(double nav_val) {
	this.nav_val = nav_val;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getReturn_value() {
	return return_value;
}
public void setReturn_value(int return_value) {
	this.return_value = return_value;
}	
}
