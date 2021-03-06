package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Custom_Merged_report_quarterwise {

	@EmbeddedId	
	   Report_6_pk key;

	   // Quarter 
	   String quarter;
	   
	  // nav_report_final;
	   	   
	   double forwar_9_mnths;
	   int R_forwar_9_mnths;
	   double forwar_12_mnths;
	   int R_forwar_12_mnths;
	   double forwar_18_mnths;
	   int R_forwar_18_mnths;
	   
	   // nav_report_final;
	   double backward_3;
	   
	   
	   double backward_6;
	   int R_backward_6;
	   
	   double backward_12;
	   int R_backward_12;
	   
	   double backward_18;
	   int R_backward_18;
	   
	   double backward_24;
	   int R_backward_24;
	   
	   double backward_30;
	   int R_backward_30;
	   
	   double backward_36;
	   int R_backward_36;
	   
	   double backward_42;
	   int R_backward_42;
	   
	   double backward_48;
	   int R_backward_48;
	   
	   double backward_54;
	   int R_backward_54;
	   
	   double backward_60;
	   int R_backward_60;
	   
	// Report 5;
	   double year_1;
	   int R_year_1;
	   
	   double year_1_1;
	   int R_year_1_1;
	   
	   double year_1_2;
	   int R_year_1_2;
	   
	   
	   double year_1_3;
	   int R_year_1_3;
	   
	   double year_1_4;
	   int R_year_1_4;
	   
	// Report 6;
	   double last_4_neg_avg_cat_ret_otb;
	   int R_last_4_neg_avg_cat_ret_otb;
	   
	   double last_8_neg_avg_cat_ret_otb;
	   int R_last_8_neg_avg_cat_ret_otb;
	   
	   double last_12_neg_avg_cat_ret_otb;
	   int R_last_12_neg_avg_cat_ret_otb;
	   
	   double last_16_neg_avg_cat_ret_otb;
	   int R_last_16_neg_avg_cat_ret_otb;
	   
	   double last_20_neg_avg_cat_ret_otb;
	   int R_last_20_neg_avg_cat_ret_otb;
	   
	   
	   double last_4_pos_avg_cat_ret_otb;
	   int R_last_4_pos_avg_cat_ret_otb;
	   
	   double last_8_pos_avg_cat_ret_otb;
	   int R_last_8_pos_avg_cat_ret_otb;
	   
	   double last_12_pos_avg_cat_ret_otb;
	   int R_last_12_pos_avg_cat_ret_otb;
	   
	   double last_16_pos_avg_cat_ret_otb;
	   int R_last_16_pos_avg_cat_ret_otb;
	   
	   double last_20_pos_avg_cat_ret_otb;
	   int R_last_20_pos_avg_cat_ret_otb;
	   
	  //Report 8 
	   
	   double cri;
	   int R_cri;
	   
	   long no_of_stock;
	   int R_no_of_stocks;
	  
	   
	   // calmal Ratio
	   
	   double max_Drawdown_year_1;
	   int R_max_Drawdown_year_1;
	   
	   double max_Drawdown_year_2;
	   int R_max_Drawdown_year_2;
	   
	   double max_Drawdown_year_3;
	   int R_max_Drawdown_year_3;
	   
	   double max_Drawdown_year_4;
	   int R_max_Drawdown_year_4;
	   
	   double max_Drawdown_year_5;
	   int R_max_Drawdown_year_5;
	   
	   //Report10
	   
	   double avg_return_50_minus_200;
	   int R_avg_return_50_minus_200;
	   
	   double last_200_day_return;
	   int R_last_200_day_return;
	   
	   
	   // new addition
	   
	   double ex_ratio;
	   double sc_aum;
	   
	   
	public Report_6_pk getKey() {
		return key;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public double getForwar_9_mnths() {
		return forwar_9_mnths;
	}
	public void setForwar_9_mnths(double forwar_9_mnths) {
		this.forwar_9_mnths = forwar_9_mnths;
	}
	public int getR_forwar_9_mnths() {
		return R_forwar_9_mnths;
	}
	public void setR_forwar_9_mnths(int r_forwar_9_mnths) {
		R_forwar_9_mnths = r_forwar_9_mnths;
	}
	public double getForwar_12_mnths() {
		return forwar_12_mnths;
	}
	public void setForwar_12_mnths(double forwar_12_mnths) {
		this.forwar_12_mnths = forwar_12_mnths;
	}
	public int getR_forwar_12_mnths() {
		return R_forwar_12_mnths;
	}
	public void setR_forwar_12_mnths(int r_forwar_12_mnths) {
		R_forwar_12_mnths = r_forwar_12_mnths;
	}
	public double getForwar_18_mnths() {
		return forwar_18_mnths;
	}
	public void setForwar_18_mnths(double forwar_18_mnths) {
		this.forwar_18_mnths = forwar_18_mnths;
	}
	public int getR_forwar_18_mnths() {
		return R_forwar_18_mnths;
	}
	public void setR_forwar_18_mnths(int r_forwar_18_mnths) {
		R_forwar_18_mnths = r_forwar_18_mnths;
	}
	public double getBackward_6() {
		return backward_6;
	}
	public void setBackward_6(double backward_6) {
		this.backward_6 = backward_6;
	}
	public int getR_backward_6() {
		return R_backward_6;
	}
	public void setR_backward_6(int r_backward_6) {
		R_backward_6 = r_backward_6;
	}
	public double getBackward_12() {
		return backward_12;
	}
	public void setBackward_12(double backward_12) {
		this.backward_12 = backward_12;
	}
	public int getR_backward_12() {
		return R_backward_12;
	}
	public void setR_backward_12(int r_backward_12) {
		R_backward_12 = r_backward_12;
	}
	public double getBackward_18() {
		return backward_18;
	}
	public void setBackward_18(double backward_18) {
		this.backward_18 = backward_18;
	}
	public int getR_backward_18() {
		return R_backward_18;
	}
	public void setR_backward_18(int r_backward_18) {
		R_backward_18 = r_backward_18;
	}
	public double getBackward_24() {
		return backward_24;
	}
	public void setBackward_24(double backward_24) {
		this.backward_24 = backward_24;
	}
	public int getR_backward_24() {
		return R_backward_24;
	}
	public void setR_backward_24(int r_backward_24) {
		R_backward_24 = r_backward_24;
	}
	public double getBackward_30() {
		return backward_30;
	}
	public void setBackward_30(double backward_30) {
		this.backward_30 = backward_30;
	}
	public int getR_backward_30() {
		return R_backward_30;
	}
	public void setR_backward_30(int r_backward_30) {
		R_backward_30 = r_backward_30;
	}
	public double getBackward_36() {
		return backward_36;
	}
	public void setBackward_36(double backward_36) {
		this.backward_36 = backward_36;
	}
	public int getR_backward_36() {
		return R_backward_36;
	}
	public void setR_backward_36(int r_backward_36) {
		R_backward_36 = r_backward_36;
	}
	public double getBackward_42() {
		return backward_42;
	}
	public void setBackward_42(double backward_42) {
		this.backward_42 = backward_42;
	}
	public int getR_backward_42() {
		return R_backward_42;
	}
	public void setR_backward_42(int r_backward_42) {
		R_backward_42 = r_backward_42;
	}
	public double getBackward_48() {
		return backward_48;
	}
	public void setBackward_48(double backward_48) {
		this.backward_48 = backward_48;
	}
	public int getR_backward_48() {
		return R_backward_48;
	}
	public void setR_backward_48(int r_backward_48) {
		R_backward_48 = r_backward_48;
	}
	public double getBackward_54() {
		return backward_54;
	}
	public void setBackward_54(double backward_54) {
		this.backward_54 = backward_54;
	}
	public int getR_backward_54() {
		return R_backward_54;
	}
	public void setR_backward_54(int r_backward_54) {
		R_backward_54 = r_backward_54;
	}
	public double getBackward_60() {
		return backward_60;
	}
	public void setBackward_60(double backward_60) {
		this.backward_60 = backward_60;
	}
	public int getR_backward_60() {
		return R_backward_60;
	}
	public void setR_backward_60(int r_backward_60) {
		R_backward_60 = r_backward_60;
	}
	public double getYear_1() {
		return year_1;
	}
	public void setYear_1(double year_1) {
		this.year_1 = year_1;
	}
	public int getR_year_1() {
		return R_year_1;
	}
	public void setR_year_1(int r_year_1) {
		R_year_1 = r_year_1;
	}
	public double getYear_1_1() {
		return year_1_1;
	}
	public void setYear_1_1(double year_1_1) {
		this.year_1_1 = year_1_1;
	}
	public int getR_year_1_1() {
		return R_year_1_1;
	}
	public void setR_year_1_1(int r_year_1_1) {
		R_year_1_1 = r_year_1_1;
	}
	public double getYear_1_2() {
		return year_1_2;
	}
	public void setYear_1_2(double year_1_2) {
		this.year_1_2 = year_1_2;
	}
	public int getR_year_1_2() {
		return R_year_1_2;
	}
	public void setR_year_1_2(int r_year_1_2) {
		R_year_1_2 = r_year_1_2;
	}
	public double getYear_1_3() {
		return year_1_3;
	}
	public void setYear_1_3(double year_1_3) {
		this.year_1_3 = year_1_3;
	}
	public int getR_year_1_3() {
		return R_year_1_3;
	}
	public void setR_year_1_3(int r_year_1_3) {
		R_year_1_3 = r_year_1_3;
	}
	public double getYear_1_4() {
		return year_1_4;
	}
	public void setYear_1_4(double year_1_4) {
		this.year_1_4 = year_1_4;
	}
	public int getR_year_1_4() {
		return R_year_1_4;
	}
	public void setR_year_1_4(int r_year_1_4) {
		R_year_1_4 = r_year_1_4;
	}
	public double getLast_4_neg_avg_cat_ret_otb() {
		return last_4_neg_avg_cat_ret_otb;
	}
	public void setLast_4_neg_avg_cat_ret_otb(double last_4_neg_avg_cat_ret_otb) {
		this.last_4_neg_avg_cat_ret_otb = last_4_neg_avg_cat_ret_otb;
	}
	public int getR_last_4_neg_avg_cat_ret_otb() {
		return R_last_4_neg_avg_cat_ret_otb;
	}
	public void setR_last_4_neg_avg_cat_ret_otb(int r_last_4_neg_avg_cat_ret_otb) {
		R_last_4_neg_avg_cat_ret_otb = r_last_4_neg_avg_cat_ret_otb;
	}
	public double getLast_8_neg_avg_cat_ret_otb() {
		return last_8_neg_avg_cat_ret_otb;
	}
	public void setLast_8_neg_avg_cat_ret_otb(double last_8_neg_avg_cat_ret_otb) {
		this.last_8_neg_avg_cat_ret_otb = last_8_neg_avg_cat_ret_otb;
	}
	public int getR_last_8_neg_avg_cat_ret_otb() {
		return R_last_8_neg_avg_cat_ret_otb;
	}
	public void setR_last_8_neg_avg_cat_ret_otb(int r_last_8_neg_avg_cat_ret_otb) {
		R_last_8_neg_avg_cat_ret_otb = r_last_8_neg_avg_cat_ret_otb;
	}
	public double getLast_12_neg_avg_cat_ret_otb() {
		return last_12_neg_avg_cat_ret_otb;
	}
	public void setLast_12_neg_avg_cat_ret_otb(double last_12_neg_avg_cat_ret_otb) {
		this.last_12_neg_avg_cat_ret_otb = last_12_neg_avg_cat_ret_otb;
	}
	public int getR_last_12_neg_avg_cat_ret_otb() {
		return R_last_12_neg_avg_cat_ret_otb;
	}
	public void setR_last_12_neg_avg_cat_ret_otb(int r_last_12_neg_avg_cat_ret_otb) {
		R_last_12_neg_avg_cat_ret_otb = r_last_12_neg_avg_cat_ret_otb;
	}
	public double getLast_16_neg_avg_cat_ret_otb() {
		return last_16_neg_avg_cat_ret_otb;
	}
	public void setLast_16_neg_avg_cat_ret_otb(double last_16_neg_avg_cat_ret_otb) {
		this.last_16_neg_avg_cat_ret_otb = last_16_neg_avg_cat_ret_otb;
	}
	public int getR_last_16_neg_avg_cat_ret_otb() {
		return R_last_16_neg_avg_cat_ret_otb;
	}
	public void setR_last_16_neg_avg_cat_ret_otb(int r_last_16_neg_avg_cat_ret_otb) {
		R_last_16_neg_avg_cat_ret_otb = r_last_16_neg_avg_cat_ret_otb;
	}
	public double getLast_20_neg_avg_cat_ret_otb() {
		return last_20_neg_avg_cat_ret_otb;
	}
	public void setLast_20_neg_avg_cat_ret_otb(double last_20_neg_avg_cat_ret_otb) {
		this.last_20_neg_avg_cat_ret_otb = last_20_neg_avg_cat_ret_otb;
	}
	public int getR_last_20_neg_avg_cat_ret_otb() {
		return R_last_20_neg_avg_cat_ret_otb;
	}
	public void setR_last_20_neg_avg_cat_ret_otb(int r_last_20_neg_avg_cat_ret_otb) {
		R_last_20_neg_avg_cat_ret_otb = r_last_20_neg_avg_cat_ret_otb;
	}
	public double getLast_4_pos_avg_cat_ret_otb() {
		return last_4_pos_avg_cat_ret_otb;
	}
	public void setLast_4_pos_avg_cat_ret_otb(double last_4_pos_avg_cat_ret_otb) {
		this.last_4_pos_avg_cat_ret_otb = last_4_pos_avg_cat_ret_otb;
	}
	public int getR_last_4_pos_avg_cat_ret_otb() {
		return R_last_4_pos_avg_cat_ret_otb;
	}
	public void setR_last_4_pos_avg_cat_ret_otb(int r_last_4_pos_avg_cat_ret_otb) {
		R_last_4_pos_avg_cat_ret_otb = r_last_4_pos_avg_cat_ret_otb;
	}
	public double getLast_8_pos_avg_cat_ret_otb() {
		return last_8_pos_avg_cat_ret_otb;
	}
	public void setLast_8_pos_avg_cat_ret_otb(double last_8_pos_avg_cat_ret_otb) {
		this.last_8_pos_avg_cat_ret_otb = last_8_pos_avg_cat_ret_otb;
	}
	public int getR_last_8_pos_avg_cat_ret_otb() {
		return R_last_8_pos_avg_cat_ret_otb;
	}
	public void setR_last_8_pos_avg_cat_ret_otb(int r_last_8_pos_avg_cat_ret_otb) {
		R_last_8_pos_avg_cat_ret_otb = r_last_8_pos_avg_cat_ret_otb;
	}
	public double getLast_12_pos_avg_cat_ret_otb() {
		return last_12_pos_avg_cat_ret_otb;
	}
	public void setLast_12_pos_avg_cat_ret_otb(double last_12_pos_avg_cat_ret_otb) {
		this.last_12_pos_avg_cat_ret_otb = last_12_pos_avg_cat_ret_otb;
	}
	public int getR_last_12_pos_avg_cat_ret_otb() {
		return R_last_12_pos_avg_cat_ret_otb;
	}
	public void setR_last_12_pos_avg_cat_ret_otb(int r_last_12_pos_avg_cat_ret_otb) {
		R_last_12_pos_avg_cat_ret_otb = r_last_12_pos_avg_cat_ret_otb;
	}
	public double getLast_16_pos_avg_cat_ret_otb() {
		return last_16_pos_avg_cat_ret_otb;
	}
	public void setLast_16_pos_avg_cat_ret_otb(double last_16_pos_avg_cat_ret_otb) {
		this.last_16_pos_avg_cat_ret_otb = last_16_pos_avg_cat_ret_otb;
	}
	public int getR_last_16_pos_avg_cat_ret_otb() {
		return R_last_16_pos_avg_cat_ret_otb;
	}
	public void setR_last_16_pos_avg_cat_ret_otb(int r_last_16_pos_avg_cat_ret_otb) {
		R_last_16_pos_avg_cat_ret_otb = r_last_16_pos_avg_cat_ret_otb;
	}
	public double getLast_20_pos_avg_cat_ret_otb() {
		return last_20_pos_avg_cat_ret_otb;
	}
	public void setLast_20_pos_avg_cat_ret_otb(double last_20_pos_avg_cat_ret_otb) {
		this.last_20_pos_avg_cat_ret_otb = last_20_pos_avg_cat_ret_otb;
	}
	public int getR_last_20_pos_avg_cat_ret_otb() {
		return R_last_20_pos_avg_cat_ret_otb;
	}
	public void setR_last_20_pos_avg_cat_ret_otb(int r_last_20_pos_avg_cat_ret_otb) {
		R_last_20_pos_avg_cat_ret_otb = r_last_20_pos_avg_cat_ret_otb;
	}
	public double getCri() {
		return cri;
	}
	public void setCri(double cri) {
		this.cri = cri;
	}
	public int getR_cri() {
		return R_cri;
	}
	public void setR_cri(int r_cri) {
		R_cri = r_cri;
	}
	public long getNo_of_stock() {
		return no_of_stock;
	}
	public void setNo_of_stock(long no_of_stock) {
		this.no_of_stock = no_of_stock;
	}
	public int getR_no_of_stocks() {
		return R_no_of_stocks;
	}
	public void setR_no_of_stocks(int r_no_of_stocks) {
		R_no_of_stocks = r_no_of_stocks;
	}
	public double getMax_Drawdown_year_1() {
		return max_Drawdown_year_1;
	}
	public void setMax_Drawdown_year_1(double max_Drawdown_year_1) {
		this.max_Drawdown_year_1 = max_Drawdown_year_1;
	}
	public int getR_max_Drawdown_year_1() {
		return R_max_Drawdown_year_1;
	}
	public void setR_max_Drawdown_year_1(int r_max_Drawdown_year_1) {
		R_max_Drawdown_year_1 = r_max_Drawdown_year_1;
	}
	public double getMax_Drawdown_year_2() {
		return max_Drawdown_year_2;
	}
	public void setMax_Drawdown_year_2(double max_Drawdown_year_2) {
		this.max_Drawdown_year_2 = max_Drawdown_year_2;
	}
	public int getR_max_Drawdown_year_2() {
		return R_max_Drawdown_year_2;
	}
	public void setR_max_Drawdown_year_2(int r_max_Drawdown_year_2) {
		R_max_Drawdown_year_2 = r_max_Drawdown_year_2;
	}
	public double getMax_Drawdown_year_3() {
		return max_Drawdown_year_3;
	}
	public void setMax_Drawdown_year_3(double max_Drawdown_year_3) {
		this.max_Drawdown_year_3 = max_Drawdown_year_3;
	}
	public int getR_max_Drawdown_year_3() {
		return R_max_Drawdown_year_3;
	}
	public void setR_max_Drawdown_year_3(int r_max_Drawdown_year_3) {
		R_max_Drawdown_year_3 = r_max_Drawdown_year_3;
	}
	public double getMax_Drawdown_year_4() {
		return max_Drawdown_year_4;
	}
	public void setMax_Drawdown_year_4(double max_Drawdown_year_4) {
		this.max_Drawdown_year_4 = max_Drawdown_year_4;
	}
	public int getR_max_Drawdown_year_4() {
		return R_max_Drawdown_year_4;
	}
	public void setR_max_Drawdown_year_4(int r_max_Drawdown_year_4) {
		R_max_Drawdown_year_4 = r_max_Drawdown_year_4;
	}
	public double getMax_Drawdown_year_5() {
		return max_Drawdown_year_5;
	}
	public void setMax_Drawdown_year_5(double max_Drawdown_year_5) {
		this.max_Drawdown_year_5 = max_Drawdown_year_5;
	}
	public int getR_max_Drawdown_year_5() {
		return R_max_Drawdown_year_5;
	}
	public void setR_max_Drawdown_year_5(int r_max_Drawdown_year_5) {
		R_max_Drawdown_year_5 = r_max_Drawdown_year_5;
	}
	public double getAvg_return_50_minus_200() {
		return avg_return_50_minus_200;
	}
	public void setAvg_return_50_minus_200(double avg_return_50_minus_200) {
		this.avg_return_50_minus_200 = avg_return_50_minus_200;
	}
	public int getR_avg_return_50_minus_200() {
		return R_avg_return_50_minus_200;
	}
	public void setR_avg_return_50_minus_200(int r_avg_return_50_minus_200) {
		R_avg_return_50_minus_200 = r_avg_return_50_minus_200;
	}
	public double getLast_200_day_return() {
		return last_200_day_return;
	}
	public void setLast_200_day_return(double last_200_day_return) {
		this.last_200_day_return = last_200_day_return;
	}
	public int getR_last_200_day_return() {
		return R_last_200_day_return;
	}
	public void setR_last_200_day_return(int r_last_200_day_return) {
		R_last_200_day_return = r_last_200_day_return;
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
	   
	     
	
}
