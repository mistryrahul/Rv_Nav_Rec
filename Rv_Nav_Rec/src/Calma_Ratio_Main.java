import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Avg_ret_Model;
import controller.Calma_Ratio_Model;
import controller.Report_5_Model;
import controller.Report_6_pk;
import controller.nav_hist;
import controller.nav_report_3_stable;

import sessionFactory.HIbernateSession;


public class Calma_Ratio_Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException 
	{
	     int db_save=1;
	     String Fund_Type;
	     
	     
	  // Type of fund is responsible for selecting appropriate scheme codes  
//	    Fund_Type="EQUITY_ELSS"; // This field is mandatory //
	     Fund_Type="EQUITY_SML"; // This field is mandatory // 
	     
		Calendar cal = Calendar.getInstance(); 
		java.util.Date temp_date=null;
		int yr_incr=1; // year increment flag
		ArrayList<nav_report_3_stable>  nav_rep_lst_tmp = null;
		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();		

	    String hql_nw=" from avg_return where start_dt>='2000-03-31' and key.Fund_Type='"+Fund_Type+"'";
// 		String hql_nw=" from avg_return where start_dt>='2003-06-30' and start_dt<='2015-03-31'";
 		
 		Query q_2 = ssn.createQuery(hql_nw);
 		
 		ArrayList<Avg_ret_Model> avg_ret_main_lst = (ArrayList<Avg_ret_Model>) q_2.list();
 		Calma_Ratio_Model crm=null;
 		Report_6_pk pk=null;	    	    
	    
	    
 		   for(Avg_ret_Model arm :avg_ret_main_lst)
 		   {
 			   
 			  yr_incr=1;
// 			   System.out.println("SCHEME_CODE--->>>"+arm.getKey().getScheme_code());
// 			  System.out.println("STARt DATE--->>>"+arm.getKey().getStart_dt());
 			   
 			  cal.setTime(arm.getKey().getStart_dt());
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		     
 			  crm = new Calma_Ratio_Model();
 			  pk = new Report_6_pk();
 			  
 			  pk.setFrom_date(arm.getKey().getStart_dt());
 			  pk.setScheme_code(arm.getKey().getScheme_code());
 			  pk.setFund_Type(Fund_Type);
 			  
 			  crm.setKey(pk);
 			 java.util.Date dd=pk.getFrom_date();
// 			 System.out.println("dd is "+ dd);
// 			 System.out.println("date from pk is" + dd.getMonth());
// 			 System.out.println("year from pk is -->"+dd.getYear());
 			 if(dd.getMonth()==0 || dd.getMonth()==1 ||dd.getMonth()==2 )
 			 {
 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
 				 crm.setComment("Qtr_1_"+( dd.getYear()-100));
 			 }
 			 else if(dd.getMonth()==3 || dd.getMonth()==4 ||dd.getMonth()==5 )
			 {
 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
				 crm.setComment("Qtr_2_"+( dd.getYear()-100));
			 }
 			else if(dd.getMonth()==6 || dd.getMonth()==7 ||dd.getMonth()==8 )
			 {
 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
				 crm.setComment("Qtr_3_"+( dd.getYear()-100));
			 }
 			else if(dd.getMonth()==9 || dd.getMonth()==10 ||dd.getMonth()==11 )
			 {
 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
				 crm.setComment("Qtr_4_"+( dd.getYear()-100));
			 }
 			 
 			 
// 			 crm.setComment(arm.getComment());
 			  
 			  System.out.println("From Date-->>"+arm.getKey().getStart_dt());
 			  
 			 while(yr_incr<=5)
			  {
				  cal.setTime(arm.getKey().getStart_dt()); 
				  cal.add(Calendar.YEAR,-yr_incr);
			      temp_date = cal.getTime();	
			      System.out.println("date" + yr_incr);
			        GET_MAX_DRAW_DOWN(crm , yr_incr , temp_date, ssn); 
			        
			        GET_CAGR(crm , yr_incr , temp_date ,ssn);
 
			        GET_CALMA_RATIO(crm , yr_incr , temp_date);
			       
			    	       
			      
			     yr_incr++;
			  }

 			   Criteria criteria_11 = ssn.createCriteria( nav_report_3_stable.class );
 			   criteria_11.add(Restrictions.eq("nav_from_date", crm.getKey().getFrom_date()));  
 			  criteria_11.add(Restrictions.eq("Fund_Type",Fund_Type));
		       criteria_11.add(Restrictions.eq("scheme_Code",crm.getKey().getScheme_code()));
		       criteria_11.add(Restrictions.eq("comment","12"));
		           
		       nav_rep_lst_tmp = (ArrayList<nav_report_3_stable>) criteria_11.list();
				  
		        if(nav_rep_lst_tmp.size() > 0)
		          {
		        	   crm.setForward_12_mnth_ret(nav_rep_lst_tmp.get(0).getNav_value());   
		          }
 		 		 			  			 
 			  
// 			    crm.setFund_Type(Fund_Type);
 			    ssn.save(crm);
// 			    ssn.getTransaction().commit();
		        db_save++;
		        
		        
		       if(db_save%50==0)
		      {
		    	    
		    	  ssn.getTransaction().commit();
		    	  ssn.beginTransaction();
		    	  ssn.flush();
	  		      ssn.clear();
	  		     
	  		      db_save=1;
	  		      
	  		      System.out.println("Reseting Session...");
		      }
 			  
		     
 			   
 			   
 			 
 		   }
 		
 		      ssn.getTransaction().commit();
			  ssn.close();
			  System.out.println("<<<<<---Report Complete---->>>>>");
		
 		         
	}
	
	private static void GET_CALMA_RATIO(Calma_Ratio_Model crm, int yr_incr,
			Date temp_date) 
	{
	             
		   if( (yr_incr==1) && (crm.getMax_Drawdown_year_1()!=0) && (crm.getCagr_year_1()!=0))
		     {
			   crm.setCalma_ratio_year_1( crm.getCagr_year_1()/crm.getMax_Drawdown_year_1());
		     }
		   if( (yr_incr==2) && (crm.getMax_Drawdown_year_2()!=0) && (crm.getCagr_year_2()!=0))
		     {
			   crm.setCalma_ratio_year_2( crm.getCagr_year_2()/crm.getMax_Drawdown_year_2());
		     }
		   if( (yr_incr==3) && (crm.getMax_Drawdown_year_3()!=0) && (crm.getCagr_year_3()!=0))
		     {
			   crm.setCalma_ratio_year_3( crm.getCagr_year_3()/crm.getMax_Drawdown_year_3());
		     }
		   if( (yr_incr==4) && (crm.getMax_Drawdown_year_4()!=0) && (crm.getCagr_year_4()!=0))
		     {
			   crm.setCalma_ratio_year_4( crm.getCagr_year_4()/crm.getMax_Drawdown_year_4());
		     }
		   if( (yr_incr==5) && (crm.getMax_Drawdown_year_5()!=0) && (crm.getCagr_year_5()!=0))
		     {
			   crm.setCalma_ratio_year_5( crm.getCagr_year_5()/crm.getMax_Drawdown_year_5());
		     }
		    
		
	}

	private static void GET_CAGR(Calma_Ratio_Model crm, int yr_incr,
			Date temp_date, Session ssn) throws ParseException 
	{
		  double cagr=0.0;
		  double tmp=0.0;
		  
//		  Calendar cal = Calendar.getInstance();
//				
//		  cal.setTime(temp_date);
//		  cal.add(Calendar.YEAR,-yr_incr);
//	      java.util.Date ddd = cal.getTime();
		  
		  		  
//		  ArrayList<nav_hist> possible_date_lst = get_list_of_dates_db( ddd,crm.getKey().getScheme_code() );   
		
		  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
		  criteria.add(Restrictions.eq("scheme_code",(int) crm.getKey().getScheme_code()));
		  criteria.add(Restrictions.eq("nav_date",crm.getKey().getFrom_date()));
		  ArrayList<nav_hist> on_the_day =(ArrayList<nav_hist>) criteria.list();
		  
		
		  
		  ArrayList<nav_hist> possible_date_lst_2 = get_list_of_dates_db(temp_date, crm.getKey().getScheme_code()); 
		  
		  
if(possible_date_lst_2.size()!=0)
 {
			  
		  
		  
		  Criteria criteria_2 = ssn.createCriteria(controller.nav_hist.class);
		  criteria_2.add(Restrictions.eq("scheme_code",(int) crm.getKey().getScheme_code()));
		  criteria_2.add(Restrictions.eq("nav_date",possible_date_lst_2.get(0).getNav_date()));
		 
		  ArrayList<nav_hist> day_year =(ArrayList<nav_hist>) criteria_2.list();
		  
		  
//		  criteria.add(Restrictions.between("nav_date", crm.getKey().getFrom_date(),possible_date_lst.get(0).getNav_date()));
//		  criteria.addOrder(org.hibernate.criterion.Order.asc("nav_date"));
		 
		  cagr =  Math.pow((on_the_day.get(0).getAdjnavrs() / day_year.get(0).getAdjnavrs()), yr_incr) -1 ;
		  
		  
		   if(yr_incr==1)
		     {
			   crm.setCagr_year_1(cagr);
		     }
		   if(yr_incr==2)
		     {
			   crm.setCagr_year_2(cagr);
		     }
		   if(yr_incr==3)
		     {
			   crm.setCagr_year_3(cagr);
		     }
		   if(yr_incr==4)
		     {
			   crm.setCagr_year_4(cagr);
		     }
		   if(yr_incr==5)
		     {
			   crm.setCagr_year_5(cagr);
		     }
		   
		  
		  
	   		
 }	 
		
	}

	private static void GET_MAX_DRAW_DOWN(Calma_Ratio_Model crm, int yr_incr,
			Date temp_date, Session ssn) throws ParseException 
	{
		
//		 Calendar cal = Calendar.getInstance();
		 
		  int lp_flg=0;  // Reseting flag value...
		  double Max_Drawdown=0.0;
		  double Max_Drawdown_old=0.0;
		  double Max_Nav=0;
		  
		  
//		  cal.setTime(temp_date);
//		  cal.add(Calendar.YEAR,-yr_incr);
// 	      java.util.Date ddd = cal.getTime();
		  
//		  		 System.out.println("DAte - 1 YEar-->"+temp_date);
//		  		 System.out.println("SCheme_Code-->>"+crm.getKey().getScheme_code());
		  		 
		  ArrayList<nav_hist> possible_date_lst = get_list_of_dates_db( temp_date,crm.getKey().getScheme_code() );  
		
		  
//		   System.out.println("Year Calc-->>"+yr_incr);
//		   System.out.println("FROM DATE-->>"+crm.getKey().getFrom_date());
//		   System.out.println("TO DATE-->>"+temp_date);
//		   
////		   System.out.println("SchemeCode-->>"+crm.getKey().getScheme_code());
//		   System.out.println("Possible Date List SIze---->>"+possible_date_lst.size());
//           System.out.println("POSSIBLE END DATE-->"+possible_date_lst.get(0).getNav_date());
		   
 if(possible_date_lst.size()>0)
 {
			  
//		   System.out.println("GOT DATE");
		   
		  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
		  criteria.add(Restrictions.eq("scheme_code",(int) crm.getKey().getScheme_code())); 
		  criteria.add(Restrictions.between("nav_date", possible_date_lst.get(0).getNav_date() , crm.getKey().getFrom_date()));
		  criteria.addOrder(org.hibernate.criterion.Order.asc("nav_date"));
		
		  
		  ArrayList<nav_hist> final_lst =(ArrayList<nav_hist>) criteria.list();
		  
		  lp_flg=0;  // Reseting flag value...
 		  Max_Drawdown=0.0;
 		  Max_Drawdown_old=0.0;
		  
		  
 		 for(nav_hist nvr:final_lst)
	       {
// 			 System.out.println("Loop");
//	    	  System.out.println("<<<<<<<--------------IN THE LOOP----------------->>>>>>>>");
	    	   
	    	   if(lp_flg==0)
	    	   {
	    		   
	    		   Max_Nav=nvr.getAdjnavrs();
//	    		   System.out.println("First Iteration-->"+Max_Nav);
//	    		   System.out.println("DAte-->"+nvr.getNav_date()+" Scheme-Code-->"+sc);
//	    		   lp_flg++;
//	    		   continue;
	    	   }
	    	   else
	    	   {
//	    		   System.out.println("<<<<<<<--------------COMING HERE----------------->>>>>>>>");
	    		    if(nvr.getAdjnavrs() > Max_Nav)
	    		    {
	    		    	Max_Nav = nvr.getAdjnavrs();
	    		    }
	    		    
	    		    Max_Drawdown = (( Max_Nav - nvr.getAdjnavrs()) / Max_Nav )*100;
	    		    
//	    		    System.out.println("MAX_NAV-->"+Max_Nav);
//	    		    System.out.println("CUrrent NAV VAL-->"+nvr.getAdjnavrs());
//	    		    System.out.println("DRAW DOWN_CALC-->>"+Max_Drawdown);
	    		    
	    		    
	    		    if(Max_Drawdown > Max_Drawdown_old)
	    		    {
	    		    	Max_Drawdown_old = Max_Drawdown;
	    		    }
	    		    
	    		    
//	    		    if(Max_Drawdown_old > Max_Drawdown)
//	    		    {
//	    		    	Max_Drawdown = Max_Drawdown_old;
//	    		    }
//	    		   
//	          		   Max_Drawdown_old = Max_Drawdown;
	    		      
//	    		       System.out.println("<<<<<<<---->>>>>>");
//	    		       System.out.println(" SchemeCode-->"+sc);
//	    		       System.out.println("NAV VAL-->>"+nvr.getAdjnavrs());
//	    		       System.out.println(" Date-->"+nvr.getNav_date());
//	          		   System.out.println(" MAX_DRAW_DOWN--->>"+Max_Drawdown);
//	          		   System.out.println(" MAX_DRAW_DOWN_OLD--->>"+Max_Drawdown_old);
//	    		       System.out.println("<<<<<<<---->>>>>>");
//	    		       
	    		       
	    		      
	    	   }
	    	   
	    	  lp_flg++;
	    	 
	       }
		  
 		     if(yr_incr==1)
 		     {
 		    	 crm.setMax_Drawdown_year_1(Max_Drawdown_old);
 		     }
 		    if(yr_incr==2)
		     {
 		    	crm.setMax_Drawdown_year_2(Max_Drawdown_old);
		     }
 		    if(yr_incr==3)
		     {
 		    	crm.setMax_Drawdown_year_3(Max_Drawdown_old);
		     }
 		   if(yr_incr==4)
		     {
 			    crm.setMax_Drawdown_year_4(Max_Drawdown_old);
		     }
 		  if(yr_incr==5)
		     {
 			    crm.setMax_Drawdown_year_5(Max_Drawdown_old); 
		     } 
 		  
 		  
 		  
 }	  
		
	}

	static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, long sc) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			 
			  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
			  criteria.add(Restrictions.eq("scheme_code",(int) sc)); 
			  criteria.add(Restrictions.between("nav_date", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_date"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}

}
