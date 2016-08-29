package controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Report_11_Standard_Dev {
	
	@EmbeddedId
   Report_6_pk key;
	
	double last_100_day_SD;
//	int R_last_100_day_SD;
	
	double last_200_day_SD;
//	int R_last_200_day_SD;
	
	double last_300_day_SD;
//	int R_last_300_day_SD;
	
	double last_400_day_SD;
//	int R_last_400_day_SD;
	
	double last_500_day_SD;
//	int R_last_500_day_SD;
	
	double last_600_day_SD;
//	int R_last_600_day_SD;
	
	double last_700_day_SD;
//	int R_last_700_day_SD;
	
	double last_800_day_SD;
//	int R_last_800_day_SD;
	
	double last_900_day_SD;
//	int R_last_900_day_SD;
	
	double last_1000_day_SD;
//	int R_last_1000_day_SD;
	
	double forward_return_12;
//	int R_forward_return_12;

	public Report_6_pk getKey() {
		return key;
	}

	public double getLast_100_day_SD() {
		return last_100_day_SD;
	}

	public double getLast_200_day_SD() {
		return last_200_day_SD;
	}

	public double getLast_300_day_SD() {
		return last_300_day_SD;
	}

	public double getLast_400_day_SD() {
		return last_400_day_SD;
	}

	public double getLast_500_day_SD() {
		return last_500_day_SD;
	}

	public double getLast_600_day_SD() {
		return last_600_day_SD;
	}

	public double getLast_700_day_SD() {
		return last_700_day_SD;
	}

	public double getLast_800_day_SD() {
		return last_800_day_SD;
	}

	public double getLast_900_day_SD() {
		return last_900_day_SD;
	}

	public double getLast_1000_day_SD() {
		return last_1000_day_SD;
	}

	public double getForward_return_12() {
		return forward_return_12;
	}

	public void setKey(Report_6_pk key) {
		this.key = key;
	}

	public void setLast_100_day_SD(double last_100_day_SD) {
		this.last_100_day_SD = last_100_day_SD;
	}

	public void setLast_200_day_SD(double last_200_day_SD) {
		this.last_200_day_SD = last_200_day_SD;
	}

	public void setLast_300_day_SD(double last_300_day_SD) {
		this.last_300_day_SD = last_300_day_SD;
	}

	public void setLast_400_day_SD(double last_400_day_SD) {
		this.last_400_day_SD = last_400_day_SD;
	}

	public void setLast_500_day_SD(double last_500_day_SD) {
		this.last_500_day_SD = last_500_day_SD;
	}

	public void setLast_600_day_SD(double last_600_day_SD) {
		this.last_600_day_SD = last_600_day_SD;
	}

	public void setLast_700_day_SD(double last_700_day_SD) {
		this.last_700_day_SD = last_700_day_SD;
	}

	public void setLast_800_day_SD(double last_800_day_SD) {
		this.last_800_day_SD = last_800_day_SD;
	}

	public void setLast_900_day_SD(double last_900_day_SD) {
		this.last_900_day_SD = last_900_day_SD;
	}

	public void setLast_1000_day_SD(double last_1000_day_SD) {
		this.last_1000_day_SD = last_1000_day_SD;
	}

	public void setForward_return_12(double forward_return_12) {
		this.forward_return_12 = forward_return_12;
	}
	
	
	
	
     
	
	
}
