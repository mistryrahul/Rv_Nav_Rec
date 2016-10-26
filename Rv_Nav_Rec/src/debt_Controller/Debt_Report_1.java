package debt_Controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Debt_Report_1 
{    
	@EmbeddedId
	Pk_generic key;
   	double credit_rating;
   	int credit_rating_rank;
   	
   	double return_12_months;
   	int return_12_months_rank;
   	
   	double return_36_months;
   	int return_36_months_rank;
   	
   	double modified_duration;
   	int modified_duration_rank;
   	
   	double weight_to_ranks;
   	int rank_of_weight_to_ranks;
   	
   	double ex_ratio;
   	double aum;
   	
   	String star;
   	
   	
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
	public int getCredit_rating_rank() {
		return credit_rating_rank;
	}
	public void setCredit_rating_rank(int credit_rating_rank) {
		this.credit_rating_rank = credit_rating_rank;
	}
	public int getReturn_12_months_rank() {
		return return_12_months_rank;
	}
	public void setReturn_12_months_rank(int return_12_months_rank) {
		this.return_12_months_rank = return_12_months_rank;
	}
	public int getReturn_36_months_rank() {
		return return_36_months_rank;
	}
	public void setReturn_36_months_rank(int return_36_months_rank) {
		this.return_36_months_rank = return_36_months_rank;
	}
	public int getModified_duration_rank() {
		return modified_duration_rank;
	}
	public void setModified_duration_rank(int modified_duration_rank) {
		this.modified_duration_rank = modified_duration_rank;
	}
	public double getWeight_to_ranks() {
		return weight_to_ranks;
	}
	public void setWeight_to_ranks(double weight_to_ranks) {
		this.weight_to_ranks = weight_to_ranks;
	}
	public int getRank_of_weight_to_ranks() {
		return rank_of_weight_to_ranks;
	}
	public void setRank_of_weight_to_ranks(int rank_of_weight_to_ranks) {
		this.rank_of_weight_to_ranks = rank_of_weight_to_ranks;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
   	
   	
   	
   	
}
