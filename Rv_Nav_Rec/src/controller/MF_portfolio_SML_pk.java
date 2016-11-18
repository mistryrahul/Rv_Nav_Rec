package controller;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class MF_portfolio_SML_pk implements Serializable
{
	  Date invdate;
	  long scheme_code;
	  long srno;
	  long actual_Scheme_Code; // added as in some case scheme_code will be PRIMARY_FD_CODE
	
	 
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public long getSrno() {
		return srno;
	}
	public void setSrno(long srno) {
		this.srno = srno;
	}
	public long getActual_Scheme_Code() {
		return actual_Scheme_Code;
	}
	public void setActual_Scheme_Code(long actual_Scheme_Code) {
		this.actual_Scheme_Code = actual_Scheme_Code;
	}
	  
	  
}
