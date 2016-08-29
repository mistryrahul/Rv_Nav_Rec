package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Stock_rank_db 
{   
	@EmbeddedId
	Stock_rank_db_PK pk;
	String comp_name;
	double rank;
	
	
	
	public String getComp_name() {
		return comp_name;
	}
	public double getRank() {
		return rank;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public void setRank(double rank) {
		this.rank = rank;
	}
	public Stock_rank_db_PK getPk() {
		return pk;
	}
	public void setPk(Stock_rank_db_PK pk) {
		this.pk = pk;
	}
	
	
	
	

}
