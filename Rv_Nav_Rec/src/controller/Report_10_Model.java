package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Report_10_Model {

	@EmbeddedId
	Report_6_pk key;
	
	double current_nav;
	double last_50_days_avg;
	double last_200_days_avg;
	double last_50_day_return;
	double last_200_day_return;
	double avg_return_50_minus_200;
	
	double forward_12_months;
	double forward_9_months;
	
	
	
     
	public Report_6_pk getKey() {
		return key;
	}

	public double getCurrent_nav() {
		return current_nav;
	}

	public double getLast_50_days_avg() {
		return last_50_days_avg;
	}

	public double getLast_200_days_avg() {
		return last_200_days_avg;
	}

	public double getLast_50_day_return() {
		return last_50_day_return;
	}

	public double getLast_200_day_return() {
		return last_200_day_return;
	}

	public double getAvg_return_50_minus_200() {
		return avg_return_50_minus_200;
	}

	public double getForward_12_months() {
		return forward_12_months;
	}

	public void setKey(Report_6_pk key) {
		this.key = key;
	}

	public void setCurrent_nav(double current_nav) {
		this.current_nav = current_nav;
	}

	public void setLast_50_days_avg(double last_50_days_avg) {
		this.last_50_days_avg = last_50_days_avg;
	}

	public void setLast_200_days_avg(double last_200_days_avg) {
		this.last_200_days_avg = last_200_days_avg;
	}

	public void setLast_50_day_return(double last_50_day_return) {
		this.last_50_day_return = last_50_day_return;
	}

	public void setLast_200_day_return(double last_200_day_return) {
		this.last_200_day_return = last_200_day_return;
	}

	public void setAvg_return_50_minus_200(double avg_return_50_minus_200) {
		this.avg_return_50_minus_200 = avg_return_50_minus_200;
	}

	public void setForward_12_months(double forward_12_months) {
		this.forward_12_months = forward_12_months;
	}

	public double getForward_9_months() {
		return forward_9_months;
	}

	public void setForward_9_months(double forward_9_months) {
		this.forward_9_months = forward_9_months;
	}
	
	
	
	
	
	
}
