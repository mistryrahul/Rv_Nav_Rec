import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;
import controller.Avg_ret_Model;
import controller.Qtr_Avg;
import controller.Report_5_Model;
import controller.nav_hist;
import controller.nav_report_3_stable;
import controller.nav_report_temp_1;


public class Report_5_Main {

	public static void main(String[] args) throws ParseException 
	{
		String Fund_Type;
		int db_flag=0;
		
		// Type of fund is responsible for selecting appropriate scheme codes  
//        Fund_Type="EQUITY_ELSS"; // This field is manditory //
//        Fund_Type="EQUITY_SML"; // This field is manditory //
		
//		Fund_Type="EQUITY_LARGE_CAP_NEW_30.9.2016"; // This field is mandatory //
//		Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory
//		 Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed
		 
		Fund_Type="EQUITY_ELSS_NEW_30.9.2016";  // has to be passed 
		
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		Session ssn = sessionfactry.openSession();
		ssn.beginTransaction();
											
											Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
											criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
											criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
									 		criteria_1.addOrder(Order.asc("key.scheme_code"));
											
									 		ArrayList<Long> scheme_code_list = (ArrayList<Long>) criteria_1.list();
		
		
//		ArrayList<Long> scheme_code_list = new ArrayList<Long>();
//		scheme_code_list.add((long)7615);
		
		
//		ArrayList<Long> scheme_code_list = new ArrayList<Long>();
//		scheme_code_list.add((long) 461);
//		scheme_code_list.add((long) 2090);
		
 		String col_lst[] ={"1_year","1_year_1","1_year_2","1_year_3","1_year_4","1_year_1_plus"};

 		java.util.Date from_dt_temp=null;
 		java.util.Date currDt_tmp=null;
 		java.util.Date currDt_tmp_1=null;
 		java.util.Date currDt_tmp_2=null;
 		java.util.Date currDt_tmp_3=null;
 		java.util.Date currDt_tmp_4=null;
 		
 		
 		
 		nav_hist Prev_Tmp_Obj = null;       // temp object for storing previous values
 		nav_hist Prev_Tmp_Obj_1 = null;   
 		nav_hist Prev_Tmp_Obj_2 = null;
 		nav_hist Prev_Tmp_Obj_3 = null;
 		nav_hist Prev_Tmp_Obj_4 = null;
 		nav_hist Prev_Tmp_Obj_5 = null;
 		
 		Report_5_Model rm5 = null;
 		int rec_exist_flag=0;
		    
 		       for(long sc : scheme_code_list)
 		       {
 		    	     Criteria criteria_12 = ssn.createCriteria( nav_report_3_stable.class );
 		 		     criteria_12.setProjection( Projections.distinct(Projections.property("nav_from_date")));
 		 		     criteria_12.add(Restrictions.eq("Fund_Type",Fund_Type));
 		 		     criteria_12.add(Restrictions.eq("scheme_Code",sc));
 		  		     criteria_12.addOrder(Order.asc("nav_from_date"));
 		  		      
 		  		     ArrayList<java.util.Date> date_list = (ArrayList<java.util.Date>) criteria_12.list(); 
 		  		     
// 		    	  ArrayList<java.util.Date> date_list = new ArrayList<java.util.Date>();
// 		    	  
// 		    	  System.out.println("DATe-->"+new java.util.Date(103, 05, 30));
// 		    	  
// 		    	  date_list.add(new java.util.Date(103, 02, 28));
 		    	   
 		    	   
 		    	  
 		  		         for(java.util.Date dt : date_list)
 		  		         {
 		  		        	  ArrayList<nav_hist> qtr_avg_list = (ArrayList<nav_hist>) ssn
 		  		        			                            .createCriteria(nav_hist.class)
 		  		        			                            .add(Restrictions.eq("scheme_code",(int) sc))
 		  		        			                            .add(Restrictions.eq("nav_date", dt)).list();
 		  		        	  
 		  		        	Prev_Tmp_Obj = qtr_avg_list.get(0); // temporarily storing the from date objects
 		  		        	
 		  		        	from_dt_temp=qtr_avg_list.get(0).getNav_date();
 		  		        	rm5 = new Report_5_Model();
 		  		        	
 		  		        	rm5.setFund_Type(Fund_Type);
 		  		       
// 		  		         System.out.println("FROM DATE-->"+from_dt_temp);
 		  		        	
 		  		        	
 		  		        	
 		  		     	if( dt.getMonth()==2 || dt.getMonth()==1)
 		  				{
// 		  					ob_ts.setComent("Qtr_1_"+( dt.getYear()-100));
 		  		     		
 		  		     		rm5.setDay_comment("Qtr_1_"+( dt.getYear()-100));
 		  		     		
// 		  					ob_tmp.setComment("Q1_"+( Ob2.getNav_date().getYear()-100));	
 		  				}
 		  				else if(dt.getMonth()==4 || dt.getMonth()==5) 
// 		  					if(Ob2.getNav_date().getMonth()==5 || Ob2.getNav_date().getMonth()==4 || Ob2.getNav_date().getMonth()==6)
 		  				{
// 		  					ob_tmp.setComment("Q2_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_2_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_2_"+( dt.getYear()-100));
 		  				}
 		  				else if(dt.getMonth()==8 || dt.getMonth()==7)
// 		  				else if(Ob2.getNav_date().getMonth()==8 || Ob2.getNav_date().getMonth()==7 || Ob2.getNav_date().getMonth()==9)
 		  				{
// 		  					ob_tmp.setComment("Q3_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_3_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_3_"+( dt.getYear()-100));
 		  				}
 		  				else if(dt.getMonth()==11 || dt.getMonth()==0)
// 		  				else if(Ob2.getNav_date().getMonth()==11 || Ob2.getNav_date().getMonth()==10 || Ob2.getNav_date().getMonth()==12)
 		  				{
// 		  					ob_tmp.setComment("Q4_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_4_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_4_"+( dt.getYear()-100));
 		  				}
 		  		        	
 		  		        	
 		  		        	
 		  		     Calendar cal = Calendar.getInstance();
 		  		        	
 		  		        	
 		  		        	rm5.setDay(from_dt_temp);
 		  		        	
 		  		        	rm5.setScheme_code(sc);
 		  		        	
 		  		        	          for(String cl : col_lst)
 		  		        	          {
 		  		        	        	  
 		  		        	        	  		  		        	        	 
 		  		        	        	  
 		  		        	        	    if(cl.equals("1_year") || cl=="1_year")
 		  		        	        	     {

 		  		        	        	    	 		  		        	        	    	
 		  		        	        	    	Prev_Tmp_Obj_1=null;
 		  		        	        	    	Prev_Tmp_Obj_2=null;
 		  		        	        	    	Prev_Tmp_Obj_3=null;
 		  		        	        	    	Prev_Tmp_Obj_4=null;
 		  		        	        	    
 		  		        	        	    	cal.setTime(from_dt_temp);
 		  		        	        	        cal.add(Calendar.YEAR,-1);
 		  		        	        	        java.util.Date ddd = cal.getTime();
 		  		        	    	      
		 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
		 		  		        	    	      {
		 		  		        	    	    	   ddd.setDate(31);
		 		  		        	    	      }
		 		  		        	    	      else
		 		  		        	    	      {
		 		  		        	    	    	   ddd.setDate(30);
		 		  		        	    	      }
 		  		        	        	    			  		        	        	    	
 		  	                                     ArrayList<nav_hist> prob_date_lst=  get_list_of_dates_db(ddd,sc); 
		 		  		        	    	     
 		  	                                   
 		  		        	        	    	if(prob_date_lst.size()>=1)
 		  		        	        	    	{ 		  		        	        	    		 
// 		  		        	        	    		 	 		  		        	        	    	
 		  		        	        	    	 double res = (( ( Prev_Tmp_Obj.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs() )/ prob_date_lst.get(0).getAdjnavrs() )*100);
 		  		        	        	    		
 		  		        	        	    		  rm5.setYear_1(res);
 		  		        	        	    		  
 	 		  		        	        	    	 Prev_Tmp_Obj_1 = prob_date_lst.get(0); 	
 	 		  		        	        	    	 
// 	 		  		            	        	    	 System.out.println("YEAR-1"+Prev_Tmp_Obj_1.getNav_date());
 		  		        	        	    	}
 		  		        	        	
 		  		        	        	    	
 		  		        	        	     }
 		  		        	        	    if(cl.equals("1_year_1") || cl=="1_year_1")
		  		        	        	     {
 		  		        	        	    	if(Prev_Tmp_Obj_1!=null)
 		  		        	        	    	{
 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_1.getNav_date());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
// 	 		  	                                    	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_1.getAdjnavrs() )/Prev_Tmp_Obj_1.getAdjnavrs() );
 	 		  	                                      
 	 		  	                                    	double res =( ( (Prev_Tmp_Obj_1.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100);	 
 	 		  	                                    	 
 	 		  	                                        rm5.setYear_1_1(res);
 	 		  	                                       
 	 		  	                                        Prev_Tmp_Obj_2 = prob_date_lst.get(0);
 	 		  	                                        
// 	 		  	                                         System.out.println("YEAR-1_1"+Prev_Tmp_Obj_2.getNav_date());
 	 		  	                                     }
 		  		        	        	    
 		  		        	        	    		
 		  		        	        	    	}
 		  		        	        	    	
		  		        	        	    	
		  		        	        	     }
 		  		        	        	    if(cl.equals("1_year_2") || cl=="1_year_2")
	  		        	        	         {
 		  		        	        	    	if(Prev_Tmp_Obj_2!=null)
 		  		        	        	    	{
// 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_2.getNav_date());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
// 	 		  	                                    	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_2.getAdjnavrs() )/Prev_Tmp_Obj_2.getAdjnavrs() );
 	 		  	                                    	
 	 		  	                                    	double res = (( (Prev_Tmp_Obj_2.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100);
 	 		  	                                       rm5.setYear_1_2(res);
 	 		  	                                       
 	 		  	                                       Prev_Tmp_Obj_3 = prob_date_lst.get(0);
 	 		  	                                       
// 	 		  	                                        System.out.println("YEAR-1_2"+Prev_Tmp_Obj_3.getNav_date());
 	 		  	                                     }
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    if(cl.equals("1_year_3") || cl=="1_year_3")
	  		        	        	         {
 		  		        	        	    	if(Prev_Tmp_Obj_3!=null)
 		  		        	        	    	{
 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_3.getNav_date());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
 	 		  	                                    //double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_3.getAdjnavrs() )/Prev_Tmp_Obj_3.getAdjnavrs() );
 	 		  	                                   
 	 		  	                                    	double res = (( (Prev_Tmp_Obj_3.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100); 	 
 	 		  	                                    	 
 	 		  	                                        rm5.setYear_1_3(res);
 	 		  	                                       
 	 		  	                                        Prev_Tmp_Obj_4 = prob_date_lst.get(0);
 	 		  	                                  
// 	 		  	                                        System.out.println("YEAR-1-3--->>>>"+Prev_Tmp_Obj_4.getNav_date());
 	 		  	                                        
 	 		  	                                        
 	 		  	                                        
// 	 		  	                                       System.out.println("<<<<<<<<<<<---Year-1-3-->>>>>>>>>>>>>>>");
//													
//	 		  	                                       System.out.println("Return Calculated--- Successfully");
//	 		  	                                       System.out.println("Date---------->"+Prev_Tmp_Obj_3.getNav_date());
//	 		  	                                       System.out.println("Prev_tewmp_Obj-->>"+Prev_Tmp_Obj_3.getAdjnavrs());
//	 		  	                                       System.out.println("Probable Date List-->"+prob_date_lst.get(0).getAdjnavrs());
//															
//	 		  	                                       
//	 		  	                                       
//	 		  	                                       System.out.println("Return-->"+res);
//	 		  	                                       
//	 		  	                                       System.out.println("<<<<<<<<<<<--END YEAR-1-3--->>>>>>>>>>>>>>>");
 	 		  	                                        
 	 		  	                                     }
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    if(cl.equals("1_year_4") || cl=="1_year_4")
	  		        	        	         {
 		  		        	        	    	
 		  		        	        	    	 		  		        	        	    	
 		  		        	        	    	if(Prev_Tmp_Obj_4!=null)
 		  		        	        	    	{
// 		  		        	        	    		 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_4.getNav_date());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
// 	 		  		        	        	        System.out.println("DATE - ! DATE-->"+ddd);
 	 		  		        	        	        
 	 		  		        	        	        
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 			 		  		        	    	      
 			 		  		        	    	      	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
// 	 		  	                                      System.out.println("For Year-4 CCalculation");
// 		  		        	        	    		  System.out.println("Probable List-->>"+prob_date_lst.size());
// 		  		        	        	    		  System.out.println("List FIRST DATA--"+prob_date_lst.get(0).getNav_date());
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
 	 		  	                                    	 
 	 		  	                                   
// 	 		  	                                   	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_4.getAdjnavrs() )/Prev_Tmp_Obj_4.getAdjnavrs() );
 	 		  	                                       double res = (( ( Prev_Tmp_Obj_4.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs() ) /prob_date_lst.get(0).getAdjnavrs())*100); 	
 	 		  	                                       
 	 		  	                                       rm5.setYear_1_4(res);
 	 		  	                                       
 	 		  	                                       Prev_Tmp_Obj_5 = prob_date_lst.get(0);
 	 		  	                                       
// 	 		  	                                       System.out.println("<<<<<<<<<<<--START YEAR-1-4--->>>>>>>>>>>>>>>");
//															
// 	 		  	                                       System.out.println("Return Calculated--- Successfully");
// 	 		  	                                       
// 	 		  	                                       System.out.println("Prev_tewmp_Obj-->>"+Prev_Tmp_Obj_4.getAdjnavrs());
// 	 		  	                                       System.out.println("Probable Date List-->"+prob_date_lst.get(0).getAdjnavrs());
//															
// 	 		  	                                       
// 	 		  	                                       
// 	 		  	                                       System.out.println("Return-->"+res);
// 	 		  	                                       
// 	 		  	                                       System.out.println("<<<<<<<<<<<-- END Year-1-4 --->>>>>>>>>>>>>>>");
 	 		  	                                       
 	 		  	                                       
 	 		  	                                     }	
 	 		  	                                     
 	 		  	                                    
 	 		  	                               
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    
 		  		        	               	 if(cl.equals("1_year_1_plus") || cl=="1_year_1_plus")
		  		        	        	     {
//		  		        	        	    	
 		  		        	               		 
 		  		        	                	cal.setTime(from_dt_temp);
		  		        	        	        cal.add(Calendar.YEAR,1);
		  		        	        	        java.util.Date ddd = cal.getTime();
		  		        	    	      
	 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
	 		  		        	    	      {
	 		  		        	    	    	   ddd.setDate(31);
	 		  		        	    	      }
	 		  		        	    	      else
	 		  		        	    	      {
	 		  		        	    	    	   ddd.setDate(30);
	 		  		        	    	      }
		  		        	        	    			  		        	        	    	
		  	                                     ArrayList<nav_hist> prob_date_lst=  get_list_of_dates_db(ddd,sc); 
	 		  		        	    	         
		  	                                   
		  		        	        	    	if(prob_date_lst.size()>=1)
		  		        	        	    	{ 		  		        	        	    		 
//		  		        	        	    		 currDt_tmp=prob_date_lst.get(0).getNav_date();
	 		  		        	        	   	// prob_date_lst.get(0).getAdjnavrs(); //Adjusted NAVRs
		  		        	        	
		  		        	        	   double res = (( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj.getAdjnavrs() )/Prev_Tmp_Obj.getAdjnavrs() )*100);
		  		        	        	    		 
		  		        	        	    		 
		  		        	        	    		 
	 		  		        	        	    	 rm5.setYear_1_plus(res);
//	 		  		        	        	    	 Prev_Tmp_Obj_1 = prob_date_lst.get(0); 	 
	 		  		        	        	    	 
	 		  		        	        	    	 
	 		  		        	        	    	 
		  		        	        	    	} 
		  		        	        	    	
		  		        	        	    	
		  		        	        	    	
		  		        	        	    	
		  		        	        	     }
 		  		        	          }
 		  		        	          
 		  		        	      
 		  		        	    	ssn.save(rm5);
		  		        	          db_flag++;
 		  		        	      
 		  		        	          
 		  		        	          

 		  		  	        	 if(db_flag%200==0)
 		  		  	        	 {
 		  		  	        		 ssn.flush();
 		  		  	        		 ssn.clear();
 		  		  	        	     ssn.getTransaction().commit();
 		  		  	        		 ssn.beginTransaction();
 		  		  	        		 db_flag=0;
 		  		  	        	 }
 		  		        	          
 		  		        	  
 		  		        	  
 		  		        	
 		  		        	
 		  		         }
 		  		     
 		  		      
 		       }
 		       ssn.getTransaction().commit();
 		       ssn.close();
		      System.out.println("<<--- Report Complete --->>");
	     	
   	      	GENERATE_RANK(Fund_Type);

	}

	private static void GENERATE_RANK(String Fund_Type) 
	{
		
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		Session ssn = sessionfactry.openSession();
		ssn.beginTransaction();
		ArrayList<String> comment_lst =null;
//		ArrayList<String> col_lst =null;
		
		Criteria criteria_12 = ssn.createCriteria( Report_5_Model.class );
		criteria_12.setProjection( Projections.distinct(Projections.property("day_comment")));
//		     criteria_12.add(Restrictions.eq("scheme_Code",sc));
//	    criteria_12.addOrder(Order.asc("nav_from_date"));
		
		
		
		comment_lst = (ArrayList<String>) criteria_12.list();
		String col_lst[] ={"year_1","year_1_1","year_1_2","year_1_3","year_1_4","year_1_plus"};
		int rank_tmp=0;
	 	double tmp_val=0;
		int retval=99;
		int db_flag=0;
		
	for(String column : col_lst)
	{
		for(String cl : comment_lst)
		{
			String hql = "FROM Report_5_Model WHERE day_comment='"+cl+
		              "' and "+column+"!=0 and Fund_Type='"+Fund_Type+"' ORDER BY "+column+" DESC";
		
		    Query query = ssn.createQuery(hql);
		    
			ArrayList<Report_5_Model> r_r_m = (ArrayList<Report_5_Model>) query.list();
			
			
			rank_tmp=1;
		 	tmp_val=98999;
			
			       for(Report_5_Model rm : r_r_m)
			       {
					    	   if(column.equals("year_1") || column=="year_1")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   
					    	   if(column.equals("year_1_1") || column=="year_1_1")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1_1());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_1_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_1_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1_1();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   if(column.equals("year_1_2") || column=="year_1_2")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1_2());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_2_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_2_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1_2();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   if(column.equals("year_1_3") || column=="year_1_3")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1_3());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_3_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_3_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1_3();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   if(column.equals("year_1_4") || column=="year_1_4")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1_4());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_4_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_4_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1_4();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   if(column.equals("year_1_plus") || column=="year_1_plus")
		     		 		    {
		  	   		 		        retval = Double.compare(tmp_val,rm.getYear_1_plus());  		 		        	   	   		 		        
				   	   		 		
		  	   		 		        if(retval==0)
		  	   		 		        {
		  	   		 		        	 rm.setYear_1_plus_rank(rank_tmp-1);
//		  	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
		  	   		 		        	 ssn.update(rm);
		  	   		 		             db_flag++;
		  	   		 		        	
		  	   		 		        }
		  	   		 		        else
		  	   		 		        {
		  	   		 		             rm.setYear_1_plus_rank(rank_tmp);
		  	   		 		             ssn.update(rm);
		  		 		        	     db_flag++;     	
		  	   		 		        }
		  	   		 		        
		  	   		 		        
		  	   		 		        tmp_val=rm.getYear_1_plus();
				   	   		 	    rank_tmp++;
				   	   		 	    
		     		 		    }
					    	   
					    	   
					    	   

					        	 if(db_flag%50==0)
					        	 {
					        		 
					        		 ssn.flush();
					        		 ssn.clear();
					        		 ssn.getTransaction().commit();
					        		 ssn.beginTransaction();
					        		 db_flag=0;
					        	 }
			       
			       
			       
			       
			       }
			
			   
			
			
		}
	}
		
		
		    ssn.getTransaction().commit();
            ssn.close();
        	System.out.println("---Rank Generation COmplete----");
		 
		
	}
	
	
	static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, long scheme_code) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  //System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);	   
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));

			  // date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			  			  
			  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
			  criteria.add(Restrictions.eq("scheme_code",(int) scheme_code)); 
			  criteria.add(Restrictions.between("nav_date", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_date"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}

}
