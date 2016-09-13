package debt_Controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Credit_rating_Pk implements Serializable
{
	long scheme_code;
	java.util.Date inv_date;
	String rv_group;
	
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public java.util.Date getInv_date() {
		return inv_date;
	}
	public void setInv_date(java.util.Date inv_date) {
		this.inv_date = inv_date;
	}
	public String getRv_group() {
		return rv_group;
	}
	public void setRv_group(String rv_group) {
		this.rv_group = rv_group;
	}
	
	
	
	
}
