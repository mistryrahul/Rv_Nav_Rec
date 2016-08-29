package controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Report_5_Model 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	long scheme_code;
	
	java.util.Date day;
	
	String day_comment;
	
	double year_1;
	int year_1_rank;
	
	double year_1_1;
	int year_1_1_rank;
	
	double year_1_2;
	int year_1_2_rank;
	
	double year_1_3;
	int year_1_3_rank;
	
	double year_1_4;
	int year_1_4_rank;
	
	double year_1_plus;
	int year_1_plus_rank;
	
//	java.util.Date nav_from_date;
//	java.util.Date nav_to_date;
//	double nav_value;
//	String comment;
	
	
	
	public java.util.Date getDay() {
		return day;
	}
	public String getDay_comment() {
		return day_comment;
	}
	public void setDay_comment(String day_comment) {
		this.day_comment = day_comment;
	}
	public double getYear_1_plus() {
		return year_1_plus;
	}
	public void setYear_1_plus(double year_1_plus) {
		this.year_1_plus = year_1_plus;
	}
	public int getYear_1_plus_rank() {
		return year_1_plus_rank;
	}
	public void setYear_1_plus_rank(int year_1_plus_rank) {
		this.year_1_plus_rank = year_1_plus_rank;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public double getYear_1() {
		return year_1;
	}
	public void setYear_1(double year_1) {
		this.year_1 = year_1;
	}
	public int getYear_1_rank() {
		return year_1_rank;
	}
	public void setYear_1_rank(int year_1_rank) {
		this.year_1_rank = year_1_rank;
	}
	public double getYear_1_1() {
		return year_1_1;
	}
	public void setYear_1_1(double year_1_1) {
		this.year_1_1 = year_1_1;
	}
	public int getYear_1_1_rank() {
		return year_1_1_rank;
	}
	public void setYear_1_1_rank(int year_1_1_rank) {
		this.year_1_1_rank = year_1_1_rank;
	}
	public double getYear_1_2() {
		return year_1_2;
	}
	public void setYear_1_2(double year_1_2) {
		this.year_1_2 = year_1_2;
	}
	public int getYear_1_2_rank() {
		return year_1_2_rank;
	}
	public void setYear_1_2_rank(int year_1_2_rank) {
		this.year_1_2_rank = year_1_2_rank;
	}
	public double getYear_1_3() {
		return year_1_3;
	}
	public void setYear_1_3(double year_1_3) {
		this.year_1_3 = year_1_3;
	}
	public int getYear_1_3_rank() {
		return year_1_3_rank;
	}
	public void setYear_1_3_rank(int year_1_3_rank) {
		this.year_1_3_rank = year_1_3_rank;
	}
	public double getYear_1_4() {
		return year_1_4;
	}
	public void setYear_1_4(double year_1_4) {
		this.year_1_4 = year_1_4;
	}
	public int getYear_1_4_rank() {
		return year_1_4_rank;
	}
	public void setYear_1_4_rank(int year_1_4_rank) {
		this.year_1_4_rank = year_1_4_rank;
	}
	

}
