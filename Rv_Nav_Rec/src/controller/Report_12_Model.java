package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_12_Model {

	@EmbeddedId
	Report_6_pk key;
	
	double scheme_aum;
	double expence_ratio;
	double forward_return_12;
	
	
	public Report_6_pk getKey() {
		return key;
	}
	public double getScheme_aum() {
		return scheme_aum;
	}
	public double getExpence_ratio() {
		return expence_ratio;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public void setScheme_aum(double scheme_aum) {
		this.scheme_aum = scheme_aum;
	}
	public void setExpence_ratio(double expence_ratio) {
		this.expence_ratio = expence_ratio;
	}
	public double getForward_return_12() {
		return forward_return_12;
	}
	public void setForward_return_12(double forward_return_12) {
		this.forward_return_12 = forward_return_12;
	}
	
	
	
	
	
}
