package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_6_Model
{
    @EmbeddedId
	Report_6_pk key;
    double forward_12_mnth_ret; // forward 12 months return
	String comment; // Quarter of year
   
	
    
	double last_4_qtr_val; // total return of last 4 quarter
	int last_4_qtr_ret; // total category average indicator score sum  
	double last_4_pos_act_ret_sum; // (return -category average)
	double last_4_neg_act_ret_sum; // (category average - return)  
	double last_4_pos_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_4_neg_avg_cat_ret_obt; // sum of -1 in each quarters
	double last_4_pos_nav_ret_value_sum; // sum of all positive value nav return in this quarter 
	double last_4_neg_nav_ret_value_sum; // sum of all negetive value nav return in this quarter
	
	
	
	double last_8_qtr_val;
	int last_8_qtr_ret;
	double last_8_pos_act_ret_sum;
	double last_8_neg_act_ret_sum;
	double last_8_pos_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_8_neg_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_8_pos_nav_ret_value_sum; // sum of all positive value nav return in this quarter 
	double last_8_neg_nav_ret_value_sum; // sum of all negetive value nav return in this quarter
	
	
	
	double last_12_qtr_val;
	int last_12_qtr_ret;
	double last_12_pos_act_ret_sum;
	double last_12_neg_act_ret_sum;
	double last_12_pos_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_12_neg_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_12_pos_nav_ret_value_sum; // sum of all positive value nav return in this quarter 
	double last_12_neg_nav_ret_value_sum; // sum of all negetive value nav return in this quarter
	
	
	
	
	double last_16_qtr_val;
	int last_16_qtr_ret;
	double last_16_pos_act_ret_sum;
	double last_16_neg_act_ret_sum;
	double last_16_pos_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_16_neg_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_16_pos_nav_ret_value_sum; // sum of all positive value nav return in this quarter 
	double last_16_neg_nav_ret_value_sum; // sum of all negetive value nav return in this quarter
	
	
	
	double last_20_qtr_val;
	int last_20_qtr_ret;
	double last_20_pos_act_ret_sum;
	double last_20_neg_act_ret_sum;
	double last_20_pos_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_20_neg_avg_cat_ret_obt; // sum of +1 in each quarters
	double last_20_pos_nav_ret_value_sum; // sum of all positive value nav return in this quarter 
	double last_20_neg_nav_ret_value_sum; // sum of all negetive value nav return in this quarter
	
	
	
	
	public void setLast_4_qtr_val(double last_4_qtr_val) {
		this.last_4_qtr_val = last_4_qtr_val;
	}
	public int getLast_4_qtr_ret() {
		return last_4_qtr_ret;
	}
	public void setLast_4_qtr_ret(int last_4_qtr_ret) {
		this.last_4_qtr_ret = last_4_qtr_ret;
	}
	public double getLast_4_pos_act_ret_sum() {
		return last_4_pos_act_ret_sum;
	}
	public void setLast_4_pos_act_ret_sum(double last_4_pos_act_ret_sum) {
		this.last_4_pos_act_ret_sum = last_4_pos_act_ret_sum;
	}
	public double getLast_4_neg_act_ret_sum() {
		return last_4_neg_act_ret_sum;
	}
	public void setLast_4_neg_act_ret_sum(double last_4_neg_act_ret_sum) {
		this.last_4_neg_act_ret_sum = last_4_neg_act_ret_sum;
	}
	public double getLast_8_qtr_val() {
		return last_8_qtr_val;
	}
	public void setLast_8_qtr_val(double last_8_qtr_val) {
		this.last_8_qtr_val = last_8_qtr_val;
	}
	public int getLast_8_qtr_ret() {
		return last_8_qtr_ret;
	}
	public void setLast_8_qtr_ret(int last_8_qtr_ret) {
		this.last_8_qtr_ret = last_8_qtr_ret;
	}
	public double getLast_8_pos_act_ret_sum() {
		return last_8_pos_act_ret_sum;
	}
	public void setLast_8_pos_act_ret_sum(double last_8_pos_act_ret_sum) {
		this.last_8_pos_act_ret_sum = last_8_pos_act_ret_sum;
	}
	public double getLast_8_neg_act_ret_sum() {
		return last_8_neg_act_ret_sum;
	}
	public void setLast_8_neg_act_ret_sum(double last_8_neg_act_ret_sum) {
		this.last_8_neg_act_ret_sum = last_8_neg_act_ret_sum;
	}
	public double getLast_12_qtr_val() {
		return last_12_qtr_val;
	}
	public void setLast_12_qtr_val(double last_12_qtr_val) {
		this.last_12_qtr_val = last_12_qtr_val;
	}
	public int getLast_12_qtr_ret() {
		return last_12_qtr_ret;
	}
	public void setLast_12_qtr_ret(int last_12_qtr_ret) {
		this.last_12_qtr_ret = last_12_qtr_ret;
	}
	public double getLast_12_pos_act_ret_sum() {
		return last_12_pos_act_ret_sum;
	}
	public void setLast_12_pos_act_ret_sum(double last_12_pos_act_ret_sum) {
		this.last_12_pos_act_ret_sum = last_12_pos_act_ret_sum;
	}
	public double getLast_12_neg_act_ret_sum() {
		return last_12_neg_act_ret_sum;
	}
	public void setLast_12_neg_act_ret_sum(double last_12_neg_act_ret_sum) {
		this.last_12_neg_act_ret_sum = last_12_neg_act_ret_sum;
	}
	public double getLast_16_qtr_val() {
		return last_16_qtr_val;
	}
	public void setLast_16_qtr_val(double last_16_qtr_val) {
		this.last_16_qtr_val = last_16_qtr_val;
	}
	public int getLast_16_qtr_ret() {
		return last_16_qtr_ret;
	}
	public void setLast_16_qtr_ret(int last_16_qtr_ret) {
		this.last_16_qtr_ret = last_16_qtr_ret;
	}
	public double getLast_16_pos_act_ret_sum() {
		return last_16_pos_act_ret_sum;
	}
	public void setLast_16_pos_act_ret_sum(double last_16_pos_act_ret_sum) {
		this.last_16_pos_act_ret_sum = last_16_pos_act_ret_sum;
	}
	public double getLast_16_neg_act_ret_sum() {
		return last_16_neg_act_ret_sum;
	}
	public void setLast_16_neg_act_ret_sum(double last_16_neg_act_ret_sum) {
		this.last_16_neg_act_ret_sum = last_16_neg_act_ret_sum;
	}
	public double getLast_20_qtr_val() {
		return last_20_qtr_val;
	}
	public void setLast_20_qtr_val(double last_20_qtr_val) {
		this.last_20_qtr_val = last_20_qtr_val;
	}
	public int getLast_20_qtr_ret() {
		return last_20_qtr_ret;
	}
	public void setLast_20_qtr_ret(int last_20_qtr_ret) {
		this.last_20_qtr_ret = last_20_qtr_ret;
	}
	public double getLast_20_pos_act_ret_sum() {
		return last_20_pos_act_ret_sum;
	}
	public void setLast_20_pos_act_ret_sum(double last_20_pos_act_ret_sum) {
		this.last_20_pos_act_ret_sum = last_20_pos_act_ret_sum;
	}
	public double getLast_20_neg_act_ret_sum() {
		return last_20_neg_act_ret_sum;
	}
	public void setLast_20_neg_act_ret_sum(double last_20_neg_act_ret_sum) {
		this.last_20_neg_act_ret_sum = last_20_neg_act_ret_sum;
	}
	public Report_6_pk getKey() {
		return key;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public double getLast_4_qtr_val() {
		return last_4_qtr_val;
	}
	public double getLast_4_pos_avg_cat_ret_obt() {
		return last_4_pos_avg_cat_ret_obt;
	}
	public void setLast_4_pos_avg_cat_ret_obt(double last_4_pos_avg_cat_ret_obt) {
		this.last_4_pos_avg_cat_ret_obt = last_4_pos_avg_cat_ret_obt;
	}
	public double getLast_4_neg_avg_cat_ret_obt() {
		return last_4_neg_avg_cat_ret_obt;
	}
	public void setLast_4_neg_avg_cat_ret_obt(double last_4_neg_avg_cat_ret_obt) {
		this.last_4_neg_avg_cat_ret_obt = last_4_neg_avg_cat_ret_obt;
	}
	public double getLast_4_pos_nav_ret_value_sum() {
		return last_4_pos_nav_ret_value_sum;
	}
	public void setLast_4_pos_nav_ret_value_sum(double last_4_pos_nav_ret_value_sum) {
		this.last_4_pos_nav_ret_value_sum = last_4_pos_nav_ret_value_sum;
	}
	public double getLast_4_neg_nav_ret_value_sum() {
		return last_4_neg_nav_ret_value_sum;
	}
	public void setLast_4_neg_nav_ret_value_sum(double last_4_neg_nav_ret_value_sum) {
		this.last_4_neg_nav_ret_value_sum = last_4_neg_nav_ret_value_sum;
	}
	public double getLast_8_pos_avg_cat_ret_obt() {
		return last_8_pos_avg_cat_ret_obt;
	}
	public void setLast_8_pos_avg_cat_ret_obt(double last_8_pos_avg_cat_ret_obt) {
		this.last_8_pos_avg_cat_ret_obt = last_8_pos_avg_cat_ret_obt;
	}
	public double getLast_8_neg_avg_cat_ret_obt() {
		return last_8_neg_avg_cat_ret_obt;
	}
	public void setLast_8_neg_avg_cat_ret_obt(double last_8_neg_avg_cat_ret_obt) {
		this.last_8_neg_avg_cat_ret_obt = last_8_neg_avg_cat_ret_obt;
	}
	public double getLast_8_pos_nav_ret_value_sum() {
		return last_8_pos_nav_ret_value_sum;
	}
	public void setLast_8_pos_nav_ret_value_sum(double last_8_pos_nav_ret_value_sum) {
		this.last_8_pos_nav_ret_value_sum = last_8_pos_nav_ret_value_sum;
	}
	public double getLast_8_neg_nav_ret_value_sum() {
		return last_8_neg_nav_ret_value_sum;
	}
	public void setLast_8_neg_nav_ret_value_sum(double last_8_neg_nav_ret_value_sum) {
		this.last_8_neg_nav_ret_value_sum = last_8_neg_nav_ret_value_sum;
	}
	public double getLast_12_pos_avg_cat_ret_obt() {
		return last_12_pos_avg_cat_ret_obt;
	}
	public void setLast_12_pos_avg_cat_ret_obt(double last_12_pos_avg_cat_ret_obt) {
		this.last_12_pos_avg_cat_ret_obt = last_12_pos_avg_cat_ret_obt;
	}
	public double getLast_12_neg_avg_cat_ret_obt() {
		return last_12_neg_avg_cat_ret_obt;
	}
	public void setLast_12_neg_avg_cat_ret_obt(double last_12_neg_avg_cat_ret_obt) {
		this.last_12_neg_avg_cat_ret_obt = last_12_neg_avg_cat_ret_obt;
	}
	public double getLast_12_pos_nav_ret_value_sum() {
		return last_12_pos_nav_ret_value_sum;
	}
	public void setLast_12_pos_nav_ret_value_sum(
			double last_12_pos_nav_ret_value_sum) {
		this.last_12_pos_nav_ret_value_sum = last_12_pos_nav_ret_value_sum;
	}
	public double getLast_12_neg_nav_ret_value_sum() {
		return last_12_neg_nav_ret_value_sum;
	}
	public void setLast_12_neg_nav_ret_value_sum(
			double last_12_neg_nav_ret_value_sum) {
		this.last_12_neg_nav_ret_value_sum = last_12_neg_nav_ret_value_sum;
	}
	public double getLast_16_pos_avg_cat_ret_obt() {
		return last_16_pos_avg_cat_ret_obt;
	}
	public void setLast_16_pos_avg_cat_ret_obt(double last_16_pos_avg_cat_ret_obt) {
		this.last_16_pos_avg_cat_ret_obt = last_16_pos_avg_cat_ret_obt;
	}
	public double getLast_16_neg_avg_cat_ret_obt() {
		return last_16_neg_avg_cat_ret_obt;
	}
	public void setLast_16_neg_avg_cat_ret_obt(double last_16_neg_avg_cat_ret_obt) {
		this.last_16_neg_avg_cat_ret_obt = last_16_neg_avg_cat_ret_obt;
	}
	public double getLast_16_pos_nav_ret_value_sum() {
		return last_16_pos_nav_ret_value_sum;
	}
	public void setLast_16_pos_nav_ret_value_sum(
			double last_16_pos_nav_ret_value_sum) {
		this.last_16_pos_nav_ret_value_sum = last_16_pos_nav_ret_value_sum;
	}
	public double getLast_16_neg_nav_ret_value_sum() {
		return last_16_neg_nav_ret_value_sum;
	}
	public void setLast_16_neg_nav_ret_value_sum(
			double last_16_neg_nav_ret_value_sum) {
		this.last_16_neg_nav_ret_value_sum = last_16_neg_nav_ret_value_sum;
	}
	public double getLast_20_pos_avg_cat_ret_obt() {
		return last_20_pos_avg_cat_ret_obt;
	}
	public void setLast_20_pos_avg_cat_ret_obt(double last_20_pos_avg_cat_ret_obt) {
		this.last_20_pos_avg_cat_ret_obt = last_20_pos_avg_cat_ret_obt;
	}
	public double getLast_20_neg_avg_cat_ret_obt() {
		return last_20_neg_avg_cat_ret_obt;
	}
	public void setLast_20_neg_avg_cat_ret_obt(double last_20_neg_avg_cat_ret_obt) {
		this.last_20_neg_avg_cat_ret_obt = last_20_neg_avg_cat_ret_obt;
	}
	public double getLast_20_pos_nav_ret_value_sum() {
		return last_20_pos_nav_ret_value_sum;
	}
	public void setLast_20_pos_nav_ret_value_sum(
			double last_20_pos_nav_ret_value_sum) {
		this.last_20_pos_nav_ret_value_sum = last_20_pos_nav_ret_value_sum;
	}
	public double getLast_20_neg_nav_ret_value_sum() {
		return last_20_neg_nav_ret_value_sum;
	}
	public void setLast_20_neg_nav_ret_value_sum(
			double last_20_neg_nav_ret_value_sum) {
		this.last_20_neg_nav_ret_value_sum = last_20_neg_nav_ret_value_sum;
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
