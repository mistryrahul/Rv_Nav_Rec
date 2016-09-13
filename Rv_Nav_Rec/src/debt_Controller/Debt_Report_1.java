package debt_Controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Debt_Report_1 
{    
	@EmbeddedId
	Pk_generic key;
   	double credit_rating;
   	double return_12_months;
   	double return_36_months;
   	double modified_duration;
   	
   	double ex_ratio;
   	double aum;
   	
   	
	public double getModified_duration() {
		return modified_duration;
	}
	public void setModified_duration(double modified_duration) {
		this.modified_duration = modified_duration;
	}
	public Pk_generic getKey() {
		return key;
	}
	public void setKey(Pk_generic key) {
		this.key = key;
	}
	public double getCredit_rating() {
		return credit_rating;
	}
	public void setCredit_rating(double credit_rating) {
		this.credit_rating = credit_rating;
	}
	public double getReturn_12_months() {
		return return_12_months;
	}
	public void setReturn_12_months(double return_12_months) {
		this.return_12_months = return_12_months;
	}
	public double getReturn_36_months() {
		return return_36_months;
	}
	public void setReturn_36_months(double return_36_months) {
		this.return_36_months = return_36_months;
	}
	public double getEx_ratio() {
		return ex_ratio;
	}
	public void setEx_ratio(double ex_ratio) {
		this.ex_ratio = ex_ratio;
	}
	public double getAum() {
		return aum;
	}
	public void setAum(double aum) {
		this.aum = aum;
	}
   	
   	
   	
   	
}
