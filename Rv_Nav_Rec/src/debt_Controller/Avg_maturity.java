package debt_Controller;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Avg_maturity 
{
   long amc_code;
   
   @EmbeddedId
   Pk_generic key;
   
   java.util.Date inv_end_date;
   double avg_mat_num;
   String avg_mat_days;
   double mod_dur_num;
   String mod_dur_days;
   double ytm;
   double turnover_ratio;
   String tr_mode;
   
      
public long getAmc_code() {
	return amc_code;
}
public void setAmc_code(long amc_code) {
	this.amc_code = amc_code;
}
public Pk_generic getKey() {
	return key;
}
public void setKey(Pk_generic key) {
	this.key = key;
}
public java.util.Date getInv_end_date() {
	return inv_end_date;
}
public void setInv_end_date(java.util.Date inv_end_date) {
	this.inv_end_date = inv_end_date;
}
public double getAvg_mat_num() {
	return avg_mat_num;
}
public void setAvg_mat_num(double avg_mat_num) {
	this.avg_mat_num = avg_mat_num;
}
public String getAvg_mat_days() {
	return avg_mat_days;
}
public void setAvg_mat_days(String avg_mat_days) {
	this.avg_mat_days = avg_mat_days;
}
public double getMod_dur_num() {
	return mod_dur_num;
}
public void setMod_dur_num(double mod_dur_num) {
	this.mod_dur_num = mod_dur_num;
}
public String getMod_dur_days() {
	return mod_dur_days;
}
public void setMod_dur_days(String mod_dur_days) {
	this.mod_dur_days = mod_dur_days;
}
public double getYtm() {
	return ytm;
}
public void setYtm(double ytm) {
	this.ytm = ytm;
}
public double getTurnover_ratio() {
	return turnover_ratio;
}
public void setTurnover_ratio(double turnover_ratio) {
	this.turnover_ratio = turnover_ratio;
}
public String getTr_mode() {
	return tr_mode;
}
public void setTr_mode(String tr_mode) {
	this.tr_mode = tr_mode;
}
   
   
   
		   
}
