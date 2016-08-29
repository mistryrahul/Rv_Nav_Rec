package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Average_Maturity 
{
	@Id 
	long id; 
	
	long amc_code;
	long schem_code;
	java.util.Date day;
	java.util.Date inv_end_dt;
	double avg_mat_num;
	String avg_mat_days;
	double mod_dur_num;
	String mod_dur_days;
	double ytm;
	double turnover_ratio;
	String tr_mode;
		
	
	
	public long getId() {
		return id;
	}
	public long getAmc_code() {
		return amc_code;
	}
	public long getSchem_code() {
		return schem_code;
	}
	public java.util.Date getDay() {
		return day;
	}
	public java.util.Date getInv_end_dt() {
		return inv_end_dt;
	}
	public double getAvg_mat_num() {
		return avg_mat_num;
	}
	public String getAvg_mat_days() {
		return avg_mat_days;
	}
	public double getMod_dur_num() {
		return mod_dur_num;
	}
	public String getMod_dur_days() {
		return mod_dur_days;
	}
	public double getYtm() {
		return ytm;
	}
	public double getTurnover_ratio() {
		return turnover_ratio;
	}
	public String getTr_mode() {
		return tr_mode;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAmc_code(long amc_code) {
		this.amc_code = amc_code;
	}
	public void setSchem_code(long schem_code) {
		this.schem_code = schem_code;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	public void setInv_end_dt(java.util.Date inv_end_dt) {
		this.inv_end_dt = inv_end_dt;
	}
	public void setAvg_mat_num(double avg_mat_num) {
		this.avg_mat_num = avg_mat_num;
	}
	public void setAvg_mat_days(String avg_mat_days) {
		this.avg_mat_days = avg_mat_days;
	}
	public void setMod_dur_num(double mod_dur_num) {
		this.mod_dur_num = mod_dur_num;
	}
	public void setMod_dur_days(String mod_dur_days) {
		this.mod_dur_days = mod_dur_days;
	}
	public void setYtm(double ytm) {
		this.ytm = ytm;
	}
	public void setTurnover_ratio(double turnover_ratio) {
		this.turnover_ratio = turnover_ratio;
	}
	public void setTr_mode(String tr_mode) {
		this.tr_mode = tr_mode;
	}
	
	
	
	
	

}
