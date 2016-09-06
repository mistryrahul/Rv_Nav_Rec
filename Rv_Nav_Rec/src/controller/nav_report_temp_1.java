package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class nav_report_temp_1
{
	
	@EmbeddedId
	private composite_pk key;
	   
	double ret_mnth_3;
	double ret_mnth_3_rank;
	
	double ret_mnth_6;
	double ret_mnth_6_rank;
	double ret_mnth_12;
	double ret_mnth_12_rank;
	double ret_mnth_18;
	double ret_mnth_18_rank;
	double ret_mnth_24;
	double ret_mnth_24_rank;
	double ret_mnth_30;
	double ret_mnth_30_rank;
	double ret_mnth_36;
	double ret_mnth_36_rank;
	double ret_mnth_42;
	double ret_mnth_42_rank;
	double ret_mnth_48;
	double ret_mnth_48_rank;
	double ret_mnth_54;
	double ret_mnth_54_rank;
	double ret_mnth_60;
	double ret_mnth_60_rank;
   
   
	double ret_mnth_9_forwd;
	double ret_mnth_9_forwd_rank;
	double ret_mnth_12_forwd;
	double ret_mnth_12_forwd_rank;
	double ret_mnth_18_forwd;
	double ret_mnth_18_forwd_rank;
	double ret_mnth_24_forwd;
	double ret_mnth_24_forwd_rank;
	double ret_mnth_30_forwd;
	double ret_mnth_36_forwd;
	double ret_mnth_42_forwd;
	
	String coment;
	
	
	
	
	public double getRet_mnth_3() {
		return ret_mnth_3;
	}
	public void setRet_mnth_3(double ret_mnth_3) {
		this.ret_mnth_3 = ret_mnth_3;
	}
	public double getRet_mnth_3_rank() {
		return ret_mnth_3_rank;
	}
	public void setRet_mnth_3_rank(double ret_mnth_3_rank) {
		this.ret_mnth_3_rank = ret_mnth_3_rank;
	}
	public double getRet_mnth_9_forwd_rank() {
		return ret_mnth_9_forwd_rank;
	}
	public void setRet_mnth_9_forwd_rank(double ret_mnth_9_forwd_rank) {
		this.ret_mnth_9_forwd_rank = ret_mnth_9_forwd_rank;
	}
	public double getRet_mnth_9_forwd() {
		return ret_mnth_9_forwd;
	}
	public void setRet_mnth_9_forwd(double ret_mnth_9_forwd) {
		this.ret_mnth_9_forwd = ret_mnth_9_forwd;
	}
	public String getComent() {
		return coment;
	}
	public void setComent(String coment) {
		this.coment = coment;
	}
	public double getRet_mnth_6_rank() {
		return ret_mnth_6_rank;
	}
	public void setRet_mnth_6_rank(double ret_mnth_6_rank) {
		this.ret_mnth_6_rank = ret_mnth_6_rank;
	}
	public double getRet_mnth_12_rank() {
		return ret_mnth_12_rank;
	}
	public void setRet_mnth_12_rank(double ret_mnth_12_rank) {
		this.ret_mnth_12_rank = ret_mnth_12_rank;
	}
	public double getRet_mnth_18_rank() {
		return ret_mnth_18_rank;
	}
	public void setRet_mnth_18_rank(double ret_mnth_18_rank) {
		this.ret_mnth_18_rank = ret_mnth_18_rank;
	}
	public double getRet_mnth_24_rank() {
		return ret_mnth_24_rank;
	}
	public void setRet_mnth_24_rank(double ret_mnth_24_rank) {
		this.ret_mnth_24_rank = ret_mnth_24_rank;
	}
	public double getRet_mnth_30_rank() {
		return ret_mnth_30_rank;
	}
	public void setRet_mnth_30_rank(double ret_mnth_30_rank) {
		this.ret_mnth_30_rank = ret_mnth_30_rank;
	}
	public double getRet_mnth_36_rank() {
		return ret_mnth_36_rank;
	}
	public void setRet_mnth_36_rank(double ret_mnth_36_rank) {
		this.ret_mnth_36_rank = ret_mnth_36_rank;
	}
	public double getRet_mnth_42_rank() {
		return ret_mnth_42_rank;
	}
	public void setRet_mnth_42_rank(double ret_mnth_42_rank) {
		this.ret_mnth_42_rank = ret_mnth_42_rank;
	}
	public double getRet_mnth_48_rank() {
		return ret_mnth_48_rank;
	}
	public void setRet_mnth_48_rank(double ret_mnth_48_rank) {
		this.ret_mnth_48_rank = ret_mnth_48_rank;
	}
	public double getRet_mnth_54_rank() {
		return ret_mnth_54_rank;
	}
	public void setRet_mnth_54_rank(double ret_mnth_54_rank) {
		this.ret_mnth_54_rank = ret_mnth_54_rank;
	}
	public double getRet_mnth_60_rank() {
		return ret_mnth_60_rank;
	}
	public void setRet_mnth_60_rank(double ret_mnth_60_rank) {
		this.ret_mnth_60_rank = ret_mnth_60_rank;
	}
	public double getRet_mnth_12_forwd_rank() {
		return ret_mnth_12_forwd_rank;
	}
	public void setRet_mnth_12_forwd_rank(double ret_mnth_12_forwd_rank) {
		this.ret_mnth_12_forwd_rank = ret_mnth_12_forwd_rank;
	}
	public double getRet_mnth_18_forwd_rank() {
		return ret_mnth_18_forwd_rank;
	}
	public void setRet_mnth_18_forwd_rank(double ret_mnth_18_forwd_rank) {
		this.ret_mnth_18_forwd_rank = ret_mnth_18_forwd_rank;
	}
	public double getRet_mnth_24_forwd_rank() {
		return ret_mnth_24_forwd_rank;
	}
	public void setRet_mnth_24_forwd_rank(double ret_mnth_24_forwd_rank) {
		this.ret_mnth_24_forwd_rank = ret_mnth_24_forwd_rank;
	}
	public composite_pk getKey() {
		return key;
	}
	public void setKey(composite_pk key) {
		this.key = key;
	}
	public double getRet_mnth_6() {
		return ret_mnth_6;
	}
	public void setRet_mnth_6(double ret_mnth_6) {
		this.ret_mnth_6 = ret_mnth_6;
	}
	public double getRet_mnth_12() {
		return ret_mnth_12;
	}
	public void setRet_mnth_12(double ret_mnth_12) {
		this.ret_mnth_12 = ret_mnth_12;
	}
	public double getRet_mnth_18() {
		return ret_mnth_18;
	}
	public void setRet_mnth_18(double ret_mnth_18) {
		this.ret_mnth_18 = ret_mnth_18;
	}
	public double getRet_mnth_24() {
		return ret_mnth_24;
	}
	public void setRet_mnth_24(double ret_mnth_24) {
		this.ret_mnth_24 = ret_mnth_24;
	}
	public double getRet_mnth_30() {
		return ret_mnth_30;
	}
	public void setRet_mnth_30(double ret_mnth_30) {
		this.ret_mnth_30 = ret_mnth_30;
	}
	public double getRet_mnth_36() {
		return ret_mnth_36;
	}
	public void setRet_mnth_36(double ret_mnth_36) {
		this.ret_mnth_36 = ret_mnth_36;
	}
	public double getRet_mnth_42() {
		return ret_mnth_42;
	}
	public void setRet_mnth_42(double ret_mnth_42) {
		this.ret_mnth_42 = ret_mnth_42;
	}
	public double getRet_mnth_48() {
		return ret_mnth_48;
	}
	public void setRet_mnth_48(double ret_mnth_48) {
		this.ret_mnth_48 = ret_mnth_48;
	}
	public double getRet_mnth_54() {
		return ret_mnth_54;
	}
	public void setRet_mnth_54(double ret_mnth_54) {
		this.ret_mnth_54 = ret_mnth_54;
	}
	public double getRet_mnth_60() {
		return ret_mnth_60;
	}
	public void setRet_mnth_60(double ret_mnth_60) {
		this.ret_mnth_60 = ret_mnth_60;
	}
	public double getRet_mnth_12_forwd() {
		return ret_mnth_12_forwd;
	}
	public void setRet_mnth_12_forwd(double ret_mnth_12_forwd) {
		this.ret_mnth_12_forwd = ret_mnth_12_forwd;
	}
	public double getRet_mnth_18_forwd() {
		return ret_mnth_18_forwd;
	}
	public void setRet_mnth_18_forwd(double ret_mnth_18_forwd) {
		this.ret_mnth_18_forwd = ret_mnth_18_forwd;
	}
	public double getRet_mnth_24_forwd() {
		return ret_mnth_24_forwd;
	}
	public void setRet_mnth_24_forwd(double ret_mnth_24_forwd) {
		this.ret_mnth_24_forwd = ret_mnth_24_forwd;
	}
	public double getRet_mnth_30_forwd() {
		return ret_mnth_30_forwd;
	}
	public void setRet_mnth_30_forwd(double ret_mnth_30_forwd) {
		this.ret_mnth_30_forwd = ret_mnth_30_forwd;
	}
	public double getRet_mnth_36_forwd() {
		return ret_mnth_36_forwd;
	}
	public void setRet_mnth_36_forwd(double ret_mnth_36_forwd) {
		this.ret_mnth_36_forwd = ret_mnth_36_forwd;
	}
	public double getRet_mnth_42_forwd() {
		return ret_mnth_42_forwd;
	}
	public void setRet_mnth_42_forwd(double ret_mnth_42_forwd) {
		this.ret_mnth_42_forwd = ret_mnth_42_forwd;
	}
	
	
	
	
	
     
}


