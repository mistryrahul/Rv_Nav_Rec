package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class nav_hist_updater 
{
	@EmbeddedId
	nav_hist_updator_PK key;
	double navrs;
	double adjnavrs;
	double repurprice;
	double saleprice;
	
	
	public nav_hist_updator_PK getKey() {
		return key;
	}
	public void setKey(nav_hist_updator_PK key) {
		this.key = key;
	}
	public double getNavrs() {
		return navrs;
	}
	public void setNavrs(double navrs) {
		this.navrs = navrs;
	}
	public double getAdjnavrs() {
		return adjnavrs;
	}
	public void setAdjnavrs(double adjnavrs) {
		this.adjnavrs = adjnavrs;
	}
	public double getRepurprice() {
		return repurprice;
	}
	public void setRepurprice(double repurprice) {
		this.repurprice = repurprice;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	
	
	

}
