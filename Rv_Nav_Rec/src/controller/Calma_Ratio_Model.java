package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Calma_Ratio_Model 
{
//     long scheme_code;
//     java.util.Date date;
	
	 @EmbeddedId
	 Report_6_pk key;
	
	 
	 double forward_12_mnth_ret; // forward 12 months return
	 String comment; // Quarter of year
	 
     double max_Drawdown_year_1;
     double cagr_year_1;
     double calma_ratio_year_1;
     
     double max_Drawdown_year_2;
     double cagr_year_2;
     double calma_ratio_year_2;
     
     double max_Drawdown_year_3;
     double cagr_year_3;
     double calma_ratio_year_3;
     
     double max_Drawdown_year_4;
     double cagr_year_4;
     double calma_ratio_year_4;
      
     double max_Drawdown_year_5;
     double cagr_year_5;
     double calma_ratio_year_5;
     
     
	public Report_6_pk getKey() {
		return key;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public double getMax_Drawdown_year_1() {
		return max_Drawdown_year_1;
	}
	public void setMax_Drawdown_year_1(double max_Drawdown_year_1) {
		this.max_Drawdown_year_1 = max_Drawdown_year_1;
	}
	public double getCagr_year_1() {
		return cagr_year_1;
	}
	public void setCagr_year_1(double cagr_year_1) {
		this.cagr_year_1 = cagr_year_1;
	}
	public double getCalma_ratio_year_1() {
		return calma_ratio_year_1;
	}
	public void setCalma_ratio_year_1(double calma_ratio_year_1) {
		this.calma_ratio_year_1 = calma_ratio_year_1;
	}
	public double getMax_Drawdown_year_2() {
		return max_Drawdown_year_2;
	}
	public void setMax_Drawdown_year_2(double max_Drawdown_year_2) {
		this.max_Drawdown_year_2 = max_Drawdown_year_2;
	}
	public double getCagr_year_2() {
		return cagr_year_2;
	}
	public void setCagr_year_2(double cagr_year_2) {
		this.cagr_year_2 = cagr_year_2;
	}
	public double getCalma_ratio_year_2() {
		return calma_ratio_year_2;
	}
	public void setCalma_ratio_year_2(double calma_ratio_year_2) {
		this.calma_ratio_year_2 = calma_ratio_year_2;
	}
	public double getMax_Drawdown_year_3() {
		return max_Drawdown_year_3;
	}
	public void setMax_Drawdown_year_3(double max_Drawdown_year_3) {
		this.max_Drawdown_year_3 = max_Drawdown_year_3;
	}
	public double getCagr_year_3() {
		return cagr_year_3;
	}
	public void setCagr_year_3(double cagr_year_3) {
		this.cagr_year_3 = cagr_year_3;
	}
	public double getCalma_ratio_year_3() {
		return calma_ratio_year_3;
	}
	public void setCalma_ratio_year_3(double calma_ratio_year_3) {
		this.calma_ratio_year_3 = calma_ratio_year_3;
	}
	public double getMax_Drawdown_year_4() {
		return max_Drawdown_year_4;
	}
	public void setMax_Drawdown_year_4(double max_Drawdown_year_4) {
		this.max_Drawdown_year_4 = max_Drawdown_year_4;
	}
	public double getCagr_year_4() {
		return cagr_year_4;
	}
	public void setCagr_year_4(double cagr_year_4) {
		this.cagr_year_4 = cagr_year_4;
	}
	public double getCalma_ratio_year_4() {
		return calma_ratio_year_4;
	}
	public void setCalma_ratio_year_4(double calma_ratio_year_4) {
		this.calma_ratio_year_4 = calma_ratio_year_4;
	}
	public double getMax_Drawdown_year_5() {
		return max_Drawdown_year_5;
	}
	public void setMax_Drawdown_year_5(double max_Drawdown_year_5) {
		this.max_Drawdown_year_5 = max_Drawdown_year_5;
	}
	public double getCagr_year_5() {
		return cagr_year_5;
	}
	public void setCagr_year_5(double cagr_year_5) {
		this.cagr_year_5 = cagr_year_5;
	}
	public double getCalma_ratio_year_5() {
		return calma_ratio_year_5;
	}
	public void setCalma_ratio_year_5(double calma_ratio_year_5) {
		this.calma_ratio_year_5 = calma_ratio_year_5;
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
