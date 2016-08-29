package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_7_Model {
	
	@EmbeddedId 
	Report_6_pk key;
	 double ex_ratio;
	 double turnover_ratio;
	 double total;
	 double forward_12_mnth_ret; // forward 12 months return
	 String comment; // Quarter of year

	public Report_6_pk getKey() {
		return key;
	}
	public double getEx_ratio() {
		return ex_ratio;
	}
	public double getTurnover_ratio() {
		return turnover_ratio;
	}
	public double getTotal() {
		return total;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public void setEx_ratio(double ex_ratio) {
		this.ex_ratio = ex_ratio;
	}
	public void setTurnover_ratio(double turnover_ratio) {
		this.turnover_ratio = turnover_ratio;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getForward_12_mnth_ret() {
		return forward_12_mnth_ret;
	}
	public void setForward_12_mnth_ret(double forward_12_mnth_ret) {
		this.forward_12_mnth_ret = forward_12_mnth_ret;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	 
	 

}
