package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_Merged_5_6_8_Model 
{ 
   @EmbeddedId	
   Report_6_pk key;

   // Quarter 
   String quarter;
   
   // nav_report_final;
   double forwar_9_mnths;
   double forwar_12_mnths;
   double forwar_18_mnths;
   double forwar_36_mnths;
   // nav_report_final;
   double backward_3;
   double backward_6;
   double backward_12;
   double backward_18;
   double backward_24;
   double backward_30;
   double backward_36;
   double backward_42;
   double backward_48;
   double backward_54;
   double backward_60;
   
   // Report 5;
   double year_1;
   double year_1_1;
   double year_1_2;
   double year_1_3;
   double year_1_4;
   
   // Report 6;
   double last_4_neg_avg_cat_ret_otb;
   double last_8_neg_avg_cat_ret_otb;
   double last_12_neg_avg_cat_ret_otb;
   double last_16_neg_avg_cat_ret_otb;
   double last_20_neg_avg_cat_ret_otb;
   
   double last_4_pos_avg_cat_ret_otb;
   double last_8_pos_avg_cat_ret_otb;
   double last_12_pos_avg_cat_ret_otb;
   double last_16_pos_avg_cat_ret_otb;
   double last_20_pos_avg_cat_ret_otb;
   
   //Report 8 
   
   double cri;
   
   long no_of_stock;
  
   
   // calmar Ratio
   
   double max_Drawdown_year_1;
   double max_Drawdown_year_2;
   double max_Drawdown_year_3;
   double max_Drawdown_year_4;
   double max_Drawdown_year_5;
   
   
   //Report 10
   
   double avg_return_50_minus_200;
   double last_200_day_return;
   
// new addition
   
   double ex_ratio;
   double sc_aum;
   
   
   
public double getAvg_return_50_minus_200() {
	return avg_return_50_minus_200;
}

public double getLast_200_day_return() {
	return last_200_day_return;
}

public void setAvg_return_50_minus_200(double avg_return_50_minus_200) {
	this.avg_return_50_minus_200 = avg_return_50_minus_200;
}

public void setLast_200_day_return(double last_200_day_return) {
	this.last_200_day_return = last_200_day_return;
}

public double getForwar_9_mnths() {
	return forwar_9_mnths;
}

public void setForwar_9_mnths(double forwar_9_mnths) {
	this.forwar_9_mnths = forwar_9_mnths;
}

public String getQuarter() {
	return quarter;
}

public void setQuarter(String quarter) {
	this.quarter = quarter;
}

public Report_6_pk getKey() {
	return key;
}

public double getForwar_12_mnths() {
	return forwar_12_mnths;
}

public double getForwar_18_mnths() {
	return forwar_18_mnths;
}

public double getBackward_6() {
	return backward_6;
}

public double getBackward_12() {
	return backward_12;
}

public double getBackward_18() {
	return backward_18;
}

public double getBackward_24() {
	return backward_24;
}

public double getBackward_30() {
	return backward_30;
}

public double getBackward_36() {
	return backward_36;
}

public double getBackward_42() {
	return backward_42;
}

public double getBackward_48() {
	return backward_48;
}

public double getBackward_54() {
	return backward_54;
}

public double getBackward_60() {
	return backward_60;
}

public double getYear_1() {
	return year_1;
}

public double getYear_1_1() {
	return year_1_1;
}

public double getYear_1_2() {
	return year_1_2;
}

public double getYear_1_3() {
	return year_1_3;
}

public double getYear_1_4() {
	return year_1_4;
}

public double getLast_4_neg_avg_cat_ret_otb() {
	return last_4_neg_avg_cat_ret_otb;
}

public double getLast_8_neg_avg_cat_ret_otb() {
	return last_8_neg_avg_cat_ret_otb;
}

public double getLast_12_neg_avg_cat_ret_otb() {
	return last_12_neg_avg_cat_ret_otb;
}

public double getLast_16_neg_avg_cat_ret_otb() {
	return last_16_neg_avg_cat_ret_otb;
}

public double getLast_20_neg_avg_cat_ret_otb() {
	return last_20_neg_avg_cat_ret_otb;
}

public double getLast_4_pos_avg_cat_ret_otb() {
	return last_4_pos_avg_cat_ret_otb;
}

public double getLast_8_pos_avg_cat_ret_otb() {
	return last_8_pos_avg_cat_ret_otb;
}

public double getLast_12_pos_avg_cat_ret_otb() {
	return last_12_pos_avg_cat_ret_otb;
}

public double getLast_16_pos_avg_cat_ret_otb() {
	return last_16_pos_avg_cat_ret_otb;
}

public double getLast_20_pos_avg_cat_ret_otb() {
	return last_20_pos_avg_cat_ret_otb;
}

public double getCri() {
	return cri;
}

public long getNo_of_stock() {
	return no_of_stock;
}

public void setKey(Report_6_pk key) {
	this.key = key;
}

public void setForwar_12_mnths(double forwar_12_mnths) {
	this.forwar_12_mnths = forwar_12_mnths;
}

public void setForwar_18_mnths(double forwar_18_mnths) {
	this.forwar_18_mnths = forwar_18_mnths;
}

public void setBackward_6(double backward_6) {
	this.backward_6 = backward_6;
}

public void setBackward_12(double backward_12) {
	this.backward_12 = backward_12;
}

public void setBackward_18(double backward_18) {
	this.backward_18 = backward_18;
}

public void setBackward_24(double backward_24) {
	this.backward_24 = backward_24;
}

public void setBackward_30(double backward_30) {
	this.backward_30 = backward_30;
}

public void setBackward_36(double backward_36) {
	this.backward_36 = backward_36;
}

public void setBackward_42(double backward_42) {
	this.backward_42 = backward_42;
}

public void setBackward_48(double backward_48) {
	this.backward_48 = backward_48;
}

public void setBackward_54(double backward_54) {
	this.backward_54 = backward_54;
}

public void setBackward_60(double backward_60) {
	this.backward_60 = backward_60;
}

public void setYear_1(double year_1) {
	this.year_1 = year_1;
}

public void setYear_1_1(double year_1_1) {
	this.year_1_1 = year_1_1;
}

public void setYear_1_2(double year_1_2) {
	this.year_1_2 = year_1_2;
}

public void setYear_1_3(double year_1_3) {
	this.year_1_3 = year_1_3;
}

public void setYear_1_4(double year_1_4) {
	this.year_1_4 = year_1_4;
}

public void setLast_4_neg_avg_cat_ret_otb(double last_4_neg_avg_cat_ret_otb) {
	this.last_4_neg_avg_cat_ret_otb = last_4_neg_avg_cat_ret_otb;
}

public void setLast_8_neg_avg_cat_ret_otb(double last_8_neg_avg_cat_ret_otb) {
	this.last_8_neg_avg_cat_ret_otb = last_8_neg_avg_cat_ret_otb;
}

public void setLast_12_neg_avg_cat_ret_otb(double last_12_neg_avg_cat_ret_otb) {
	this.last_12_neg_avg_cat_ret_otb = last_12_neg_avg_cat_ret_otb;
}

public void setLast_16_neg_avg_cat_ret_otb(double last_16_neg_avg_cat_ret_otb) {
	this.last_16_neg_avg_cat_ret_otb = last_16_neg_avg_cat_ret_otb;
}

public void setLast_20_neg_avg_cat_ret_otb(double last_20_neg_avg_cat_ret_otb) {
	this.last_20_neg_avg_cat_ret_otb = last_20_neg_avg_cat_ret_otb;
}

public void setLast_4_pos_avg_cat_ret_otb(double last_4_pos_avg_cat_ret_otb) {
	this.last_4_pos_avg_cat_ret_otb = last_4_pos_avg_cat_ret_otb;
}

public void setLast_8_pos_avg_cat_ret_otb(double last_8_pos_avg_cat_ret_otb) {
	this.last_8_pos_avg_cat_ret_otb = last_8_pos_avg_cat_ret_otb;
}

public void setLast_12_pos_avg_cat_ret_otb(double last_12_pos_avg_cat_ret_otb) {
	this.last_12_pos_avg_cat_ret_otb = last_12_pos_avg_cat_ret_otb;
}

public void setLast_16_pos_avg_cat_ret_otb(double last_16_pos_avg_cat_ret_otb) {
	this.last_16_pos_avg_cat_ret_otb = last_16_pos_avg_cat_ret_otb;
}

public void setLast_20_pos_avg_cat_ret_otb(double last_20_pos_avg_cat_ret_otb) {
	this.last_20_pos_avg_cat_ret_otb = last_20_pos_avg_cat_ret_otb;
}

public void setCri(double cri) {
	this.cri = cri;
}

public void setNo_of_stock(long no_of_stock) {
	this.no_of_stock = no_of_stock;
}

public double getMax_Drawdown_year_1() {
	return max_Drawdown_year_1;
}

public double getMax_Drawdown_year_2() {
	return max_Drawdown_year_2;
}

public double getMax_Drawdown_year_3() {
	return max_Drawdown_year_3;
}

public double getMax_Drawdown_year_4() {
	return max_Drawdown_year_4;
}

public double getMax_Drawdown_year_5() {
	return max_Drawdown_year_5;
}

public void setMax_Drawdown_year_1(double max_Drawdown_year_1) {
	this.max_Drawdown_year_1 = max_Drawdown_year_1;
}

public void setMax_Drawdown_year_2(double max_Drawdown_year_2) {
	this.max_Drawdown_year_2 = max_Drawdown_year_2;
}

public void setMax_Drawdown_year_3(double max_Drawdown_year_3) {
	this.max_Drawdown_year_3 = max_Drawdown_year_3;
}

public void setMax_Drawdown_year_4(double max_Drawdown_year_4) {
	this.max_Drawdown_year_4 = max_Drawdown_year_4;
}

public void setMax_Drawdown_year_5(double max_Drawdown_year_5) {
	this.max_Drawdown_year_5 = max_Drawdown_year_5;
}

public double getBackward_3() {
	return backward_3;
}

public void setBackward_3(double backward_3) {
	this.backward_3 = backward_3;
}

public double getEx_ratio() {
	return ex_ratio;
}

public void setEx_ratio(double ex_ratio) {
	this.ex_ratio = ex_ratio;
}

public double getSc_aum() {
	return sc_aum;
}

public void setSc_aum(double sc_aum) {
	this.sc_aum = sc_aum;
}

public double getForwar_36_mnths() {
	return forwar_36_mnths;
}

public void setForwar_36_mnths(double forwar_36_mnths) {
	this.forwar_36_mnths = forwar_36_mnths;
}

 



   
   
   
   
   
}
