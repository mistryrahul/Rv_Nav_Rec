package controller;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Benchmark_Hist 
{
//   @Id
//   long Index_Code;
//   
//   java.util.Date dte;
	
   @EmbeddedId	
   Bm_Pk key;
	
   double DayRet_1;
   
   java.util.Date WeekDate_1;
   double WeekClose_1;
   double WeekRet_1;
   
   java.util.Date MTHDate_1;
   double MTHClose_1;
   double MonthRet_1;
   
   java.util.Date MTHDate_3;
   double MTHClose_3;
   double MonthRet_3;
   
   java.util.Date MTHDate_6;
   double MTHClose_6;
   double MonthRet_6;
   
   java.util.Date MTHDate_9;
   double MTHClose_9;
   double MonthRet_9;
   
   java.util.Date Date_1YR;
   double Close_1YR;
   double Ret_1YR;
   
   java.util.Date Date_2YR;
   double Close_2YR;
   double Ret_2YR;
   
   java.util.Date Date_3YR;
   double Close_3YR;
   double Ret_3YR;
   
   java.util.Date Date_4YR;
   double Close_4YR;
   double Ret_4YR;
   
   java.util.Date Date_5YR;
   double Close_5YR;
   double Ret_5YR;
   
   java.util.Date IncDate;
   double IncClose;
   double IncRet;
   
   java.util.Date WeekDate_2;
   double WeekClose_2;
   double WeekRet_2;
   
   java.util.Date WeekDate_3;
   double WeekClose_3;
   double WeekRet_3;
   
   java.util.Date MTHDate_2;
   double MTHClose_2;
   double MonthRet_2;
   
   java.util.Date YTDDate;
   double YTDNav;
   double YTDRet;
   
   
   
   
   
//   
//public Benchmark_Hist() {
//	super();	
//}

public void Benchmark_Hist_Copy(Benchmark_Hist obj) {
//	this.Index_Code = obj.Index_Code;
	
	this.DayRet_1 = obj.DayRet_1;
	this.WeekDate_1 = obj.WeekDate_1;
	this.WeekClose_1 = obj.WeekClose_1;
	this.WeekRet_1 = obj.WeekRet_1;
	this.MTHDate_1 = obj.MTHDate_1;
	this.MTHClose_1 = obj.MTHClose_1;
	this.MonthRet_1 = obj.MonthRet_1;
	this.MTHDate_3 = obj.MTHDate_3;
	this.MTHClose_3 = obj.MTHClose_3;
	this.MonthRet_3 = obj.MonthRet_3;
	this.MTHDate_6 = obj.MTHDate_6;
	this.MTHClose_6 = obj.MTHClose_6;
	this.MonthRet_6 = obj.MonthRet_6;
	this.MTHDate_9 = obj.MTHDate_9;
	this.MTHClose_9 = obj.MTHClose_9;
	this.MonthRet_9 = obj.MonthRet_9;
	this.Close_1YR = obj.Close_1YR;
	this.Ret_1YR = obj.Ret_1YR;
	this.Date_2YR = obj.Date_2YR;
	this.Close_2YR = obj.Close_2YR;
	this.Ret_2YR = obj.Ret_2YR;
	this.Date_3YR = obj.Date_3YR;
	this.Close_3YR = obj.Close_3YR;
	this.Ret_3YR = obj.Ret_3YR;
	this.Date_4YR = obj.Date_4YR;
	this.Close_4YR = obj.Close_4YR;
	this.Ret_4YR = obj.Ret_4YR;
	this.Date_5YR = obj.Date_5YR;
	this.Close_5YR = obj.Close_5YR;
	this.Ret_5YR = obj.Ret_5YR;
	this.IncDate = obj.IncDate;
	this.IncClose = obj.IncClose;
	this.IncRet = obj.IncRet;
	this.WeekDate_2 = obj.WeekDate_2;
	this.WeekClose_2 = obj.WeekClose_2;
	this.WeekRet_2 = obj.WeekRet_2;
	this.WeekDate_3 = obj.WeekDate_3;
	this.WeekClose_3 = obj.WeekClose_3;
	this.WeekRet_3 = obj.WeekRet_3;
	this.MTHDate_2 = obj.MTHDate_2;
	this.MTHClose_2 = obj.MTHClose_2;
	this.MonthRet_2 = obj.MonthRet_2;
	this.YTDDate = obj.YTDDate;
	this.YTDNav = obj.YTDNav;
	this.YTDRet = obj.YTDRet;
}



public Bm_Pk getKey() {
	return key;
}
public void setKey(Bm_Pk key) {
	this.key = key;
}
public double getDayRet_1() {
	return DayRet_1;
}
public void setDayRet_1(double dayRet_1) {
	DayRet_1 = dayRet_1;
}
public java.util.Date getWeekDate_1() {
	return WeekDate_1;
}
public void setWeekDate_1(java.util.Date weekDate_1) {
	WeekDate_1 = weekDate_1;
}
public double getWeekClose_1() {
	return WeekClose_1;
}
public void setWeekClose_1(double weekClose_1) {
	WeekClose_1 = weekClose_1;
}
public double getWeekRet_1() {
	return WeekRet_1;
}
public void setWeekRet_1(double weekRet_1) {
	WeekRet_1 = weekRet_1;
}
public java.util.Date getMTHDate_1() {
	return MTHDate_1;
}
public void setMTHDate_1(java.util.Date mTHDate_1) {
	MTHDate_1 = mTHDate_1;
}
public double getMTHClose_1() {
	return MTHClose_1;
}
public void setMTHClose_1(double mTHClose_1) {
	MTHClose_1 = mTHClose_1;
}
public double getMonthRet_1() {
	return MonthRet_1;
}
public void setMonthRet_1(double monthRet_1) {
	MonthRet_1 = monthRet_1;
}
public java.util.Date getMTHDate_3() {
	return MTHDate_3;
}
public void setMTHDate_3(java.util.Date mTHDate_3) {
	MTHDate_3 = mTHDate_3;
}
public double getMTHClose_3() {
	return MTHClose_3;
}
public void setMTHClose_3(double mTHClose_3) {
	MTHClose_3 = mTHClose_3;
}
public double getMonthRet_3() {
	return MonthRet_3;
}
public void setMonthRet_3(double monthRet_3) {
	MonthRet_3 = monthRet_3;
}
public java.util.Date getMTHDate_6() {
	return MTHDate_6;
}
public void setMTHDate_6(java.util.Date mTHDate_6) {
	MTHDate_6 = mTHDate_6;
}
public double getMTHClose_6() {
	return MTHClose_6;
}
public void setMTHClose_6(double mTHClose_6) {
	MTHClose_6 = mTHClose_6;
}
public double getMonthRet_6() {
	return MonthRet_6;
}
public void setMonthRet_6(double monthRet_6) {
	MonthRet_6 = monthRet_6;
}
public java.util.Date getMTHDate_9() {
	return MTHDate_9;
}
public void setMTHDate_9(java.util.Date mTHDate_9) {
	MTHDate_9 = mTHDate_9;
}
public double getMTHClose_9() {
	return MTHClose_9;
}
public void setMTHClose_9(double mTHClose_9) {
	MTHClose_9 = mTHClose_9;
}
public double getMonthRet_9() {
	return MonthRet_9;
}
public void setMonthRet_9(double monthRet_9) {
	MonthRet_9 = monthRet_9;
}
public java.util.Date getDate_1YR() {
	return Date_1YR;
}
public void setDate_1YR(java.util.Date date_1yr) {
	Date_1YR = date_1yr;
}
public double getClose_1YR() {
	return Close_1YR;
}
public void setClose_1YR(double close_1yr) {
	Close_1YR = close_1yr;
}
public double getRet_1YR() {
	return Ret_1YR;
}
public void setRet_1YR(double ret_1yr) {
	Ret_1YR = ret_1yr;
}
public java.util.Date getDate_2YR() {
	return Date_2YR;
}
public void setDate_2YR(java.util.Date date_2yr) {
	Date_2YR = date_2yr;
}
public double getClose_2YR() {
	return Close_2YR;
}
public void setClose_2YR(double close_2yr) {
	Close_2YR = close_2yr;
}
public double getRet_2YR() {
	return Ret_2YR;
}
public void setRet_2YR(double ret_2yr) {
	Ret_2YR = ret_2yr;
}
public java.util.Date getDate_3YR() {
	return Date_3YR;
}
public void setDate_3YR(java.util.Date date_3yr) {
	Date_3YR = date_3yr;
}
public double getClose_3YR() {
	return Close_3YR;
}
public void setClose_3YR(double close_3yr) {
	Close_3YR = close_3yr;
}
public double getRet_3YR() {
	return Ret_3YR;
}
public void setRet_3YR(double ret_3yr) {
	Ret_3YR = ret_3yr;
}
public java.util.Date getDate_4YR() {
	return Date_4YR;
}
public void setDate_4YR(java.util.Date date_4yr) {
	Date_4YR = date_4yr;
}
public double getClose_4YR() {
	return Close_4YR;
}
public void setClose_4YR(double close_4yr) {
	Close_4YR = close_4yr;
}
public double getRet_4YR() {
	return Ret_4YR;
}
public void setRet_4YR(double ret_4yr) {
	Ret_4YR = ret_4yr;
}
public java.util.Date getDate_5YR() {
	return Date_5YR;
}
public void setDate_5YR(java.util.Date date_5yr) {
	Date_5YR = date_5yr;
}
public double getClose_5YR() {
	return Close_5YR;
}
public void setClose_5YR(double close_5yr) {
	Close_5YR = close_5yr;
}
public double getRet_5YR() {
	return Ret_5YR;
}
public void setRet_5YR(double ret_5yr) {
	Ret_5YR = ret_5yr;
}
public java.util.Date getIncDate() {
	return IncDate;
}
public void setIncDate(java.util.Date incDate) {
	IncDate = incDate;
}
public double getIncClose() {
	return IncClose;
}
public void setIncClose(double incClose) {
	IncClose = incClose;
}
public double getIncRet() {
	return IncRet;
}
public void setIncRet(double incRet) {
	IncRet = incRet;
}
public java.util.Date getWeekDate_2() {
	return WeekDate_2;
}
public void setWeekDate_2(java.util.Date weekDate_2) {
	WeekDate_2 = weekDate_2;
}
public double getWeekClose_2() {
	return WeekClose_2;
}
public void setWeekClose_2(double weekClose_2) {
	WeekClose_2 = weekClose_2;
}
public double getWeekRet_2() {
	return WeekRet_2;
}
public void setWeekRet_2(double weekRet_2) {
	WeekRet_2 = weekRet_2;
}
public java.util.Date getWeekDate_3() {
	return WeekDate_3;
}
public void setWeekDate_3(java.util.Date weekDate_3) {
	WeekDate_3 = weekDate_3;
}
public double getWeekClose_3() {
	return WeekClose_3;
}
public void setWeekClose_3(double weekClose_3) {
	WeekClose_3 = weekClose_3;
}
public double getWeekRet_3() {
	return WeekRet_3;
}
public void setWeekRet_3(double weekRet_3) {
	WeekRet_3 = weekRet_3;
}
public java.util.Date getMTHDate_2() {
	return MTHDate_2;
}
public void setMTHDate_2(java.util.Date mTHDate_2) {
	MTHDate_2 = mTHDate_2;
}
public double getMTHClose_2() {
	return MTHClose_2;
}
public void setMTHClose_2(double mTHClose_2) {
	MTHClose_2 = mTHClose_2;
}
public double getMonthRet_2() {
	return MonthRet_2;
}
public void setMonthRet_2(double monthRet_2) {
	MonthRet_2 = monthRet_2;
}
public java.util.Date getYTDDate() {
	return YTDDate;
}
public void setYTDDate(java.util.Date yTDDate) {
	YTDDate = yTDDate;
}
public double getYTDNav() {
	return YTDNav;
}
public void setYTDNav(double yTDNav) {
	YTDNav = yTDNav;
}
public double getYTDRet() {
	return YTDRet;
}
public void setYTDRet(double yTDRet) {
	YTDRet = yTDRet;
}
      
   
   
   
   
}

