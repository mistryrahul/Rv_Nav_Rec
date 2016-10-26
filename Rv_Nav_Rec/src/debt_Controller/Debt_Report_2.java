package debt_Controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Debt_Report_2 
{
	@EmbeddedId
	Pk_generic key;
	
 	double return_12_months;
      	
   	double return_36_months_CAGR;
   	
   	
   	double ex_ratio;
   	double aum;
   	
   	double benchmark_return_12_months;
   	double benchmark_return_36_months;
   	
   	
   	double b_12_ret_12;
   	double b_36_ret_36;
   	
   	
   	String Index_Name;
   	
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
	public double getBenchmark_return_12_months() {
		return benchmark_return_12_months;
	}
	public void setBenchmark_return_12_months(double benchmark_return_12_months) {
		this.benchmark_return_12_months = benchmark_return_12_months;
	}
	public double getBenchmark_return_36_months() {
		return benchmark_return_36_months;
	}
	public void setBenchmark_return_36_months(double benchmark_return_36_months) {
		this.benchmark_return_36_months = benchmark_return_36_months;
	}
	public double getB_12_ret_12() {
		return b_12_ret_12;
	}
	public void setB_12_ret_12(double b_12_ret_12) {
		this.b_12_ret_12 = b_12_ret_12;
	}
	public double getB_36_ret_36() {
		return b_36_ret_36;
	}
	public void setB_36_ret_36(double b_36_ret_36) {
		this.b_36_ret_36 = b_36_ret_36;
	}
	public String getIndex_Name() {
		return Index_Name;
	}
	public void setIndex_Name(String index_Name) {
		Index_Name = index_Name;
	}
	
	
   	
   	
   	
   	

}
