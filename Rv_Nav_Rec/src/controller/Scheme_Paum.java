package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import debt_Controller.Pk_generic;

@Entity
public class Scheme_Paum 
{
	 @EmbeddedId
	 Pk_generic key;
	 int amc_code;
	 double avg_aum;
	 
	 
	public Pk_generic getKey() {
		return key;
	}
	public void setKey(Pk_generic key) {
		this.key = key;
	}
	public int getAmc_code() {
		return amc_code;
	}
	public void setAmc_code(int amc_code) {
		this.amc_code = amc_code;
	}
	public double getAvg_aum() {
		return avg_aum;
	}
	public void setAvg_aum(double avg_aum) {
		this.avg_aum = avg_aum;
	}
	 
 
}
