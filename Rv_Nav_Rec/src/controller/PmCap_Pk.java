package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class PmCap_Pk  implements Serializable{


    long Portfolio_Security_Code;
    java.util.Date Trade_Date;
    
    
	public long getPortfolio_Security_Code() {
		return Portfolio_Security_Code;
	}
	public void setPortfolio_Security_Code(long portfolio_Security_Code) {
		Portfolio_Security_Code = portfolio_Security_Code;
	}
	public java.util.Date getTrade_Date() {
		return Trade_Date;
	}
	public void setTrade_Date(java.util.Date trade_Date) {
		Trade_Date = trade_Date;
	}
    
    
    
    
    
	   
    
    
	
}
