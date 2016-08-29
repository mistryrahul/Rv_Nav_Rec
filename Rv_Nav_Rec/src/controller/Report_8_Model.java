package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_8_Model 
{
	@EmbeddedId
	 Report_6_pk key;
	
	 double gen_rank;
     double forward_12_mnth;
     double forward_18_mnth; 
     long no_of_stock;
     
     
     
	public Report_6_pk getKey() {
		return key;
	}

	public double getGen_rank() {
		return gen_rank;
	}

	public void setKey(Report_6_pk key) {
		this.key = key;
	}

	public void setGen_rank(double gen_rank) {
		this.gen_rank = gen_rank;
	}

	public double getForward_12_mnth() {
		return forward_12_mnth;
	}

	public double getForward_18_mnth() {
		return forward_18_mnth;
	}

	public void setForward_12_mnth(double forward_12_mnth) {
		this.forward_12_mnth = forward_12_mnth;
	}

	public void setForward_18_mnth(double forward_18_mnth) {
		this.forward_18_mnth = forward_18_mnth;
	}

	public long getNo_of_stock() {
		return no_of_stock;
	}

	public void setNo_of_stock(long no_of_stock) {
		this.no_of_stock = no_of_stock;
	}
	
	
	
   
}
