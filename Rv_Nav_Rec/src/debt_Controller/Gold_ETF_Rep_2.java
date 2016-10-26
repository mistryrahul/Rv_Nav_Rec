package debt_Controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Gold_ETF_Rep_2 
{
	@EmbeddedId
	Pk_generic key;
	
	double return_12_months;
  	
   	double return_36_months_CAGR;
   	
   	
   	double ex_ratio;
   	double aum;
   	
   	double Final_Amt;
    int R_Final_Amt;      
   	
    String star;
    String Index_Name;
    
	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public int getR_Final_Amt() {
		return R_Final_Amt;
	}

	public void setR_Final_Amt(int r_Final_Amt) {
		R_Final_Amt = r_Final_Amt;
	}

	public Pk_generic getKey() {
		return key;
	}

	public void setKey(Pk_generic key) {
		this.key = key;
	}

	public double getReturn_12_months() {
		return return_12_months;
	}

	public void setReturn_12_months(double return_12_months) {
		this.return_12_months = return_12_months;
	}

	public double getReturn_36_months_CAGR() {
		return return_36_months_CAGR;
	}

	public void setReturn_36_months_CAGR(double return_36_months_CAGR) {
		this.return_36_months_CAGR = return_36_months_CAGR;
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


	public double getFinal_Amt() {
		return Final_Amt;
	}

	public void setFinal_Amt(double final_Amt) {
		Final_Amt = final_Amt;
	}

	public String getIndex_Name() {
		return Index_Name;
	}

	public void setIndex_Name(String index_Name) {
		Index_Name = index_Name;
	}
   	
   	
   	
	
	
}
