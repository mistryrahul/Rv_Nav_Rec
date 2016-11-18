package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;
import java.util.Date;
@Embeddable
public class MF_portfolio_pk implements Serializable
{
  Date invdate;
  long scheme_code;
  long srno;
  
  
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
  
  
  
  
  
}
