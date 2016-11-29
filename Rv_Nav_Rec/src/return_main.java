import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Avg_ret_Model;
import controller.nav_hist;
import controller.nav_report_3_stable;

import sessionFactory.HIbernateSession;


public class return_main {

	static ArrayList<nav_hist> get_list_of_dates_db(String day, int scheme_code) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
			  formatter = new SimpleDateFormat("dd/MM/yyyy");
			  //System.out.println("DATE-FOrmatter-->>"+myDate);
			  date_nav_chk_start = formatter.parse(day);	   
			  date_nav_chk_end = new Date(date_nav_chk_start.getTime()-((1000 * 60 * 60 * 24)*10));

			  // date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
			  criteria.add(Restrictions.eq("scheme_code",scheme_code)); 
			  
			  
			  criteria.add(Restrictions.between("nav_date", date_nav_chk_end, date_nav_chk_start));
      		  
			  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_date"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
			  
			  
			  
		 return lst;
	}
	
	static String get_date(String day, int months, String opr) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(formatter.parse(day));
	      months=Math.abs(months);
	      
		      if(opr=="add")
		      {
		    	  cal.add(Calendar.MONTH,months);
		      }
		      else if(opr=="sub")
		      {
		    	  cal.add(Calendar.MONTH,-months);
		      }
	      java.util.Date ddd = cal.getTime();
	      
	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
	      {
	    	   ddd.setDate(31);
	      }
	      else
	      {
	    	   ddd.setDate(30);
	      }
	      
//	      SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
	      String formatted = formatter.format(ddd);
	      
	      return formatted;
	}
	
	public static void main(String[] args) 
	{
		  ArrayList<Long> scheme_code_lst_lng = new ArrayList<Long>();
		  ArrayList<String> scheme_code_lst = new ArrayList<String>();
		  ArrayList<String> date_lst = new ArrayList<String>();
		  
		  String Fund_Type;
		  
		   // Type of fund is responsible for selecting appropriate scheme codes  
//	         Fund_Type="EQUITY_ELSS"; // This field is mandatory
//		  Fund_Type="EQUITY_SML"; // This field is mandatory
//		  Fund_Type="EQUITY_LARGE_CAP_NEW_30.9.2016";  // has to be passed
//		  Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory
//		  Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed
		  Fund_Type="EQUITY_ELSS_NEW_30.9.2016";  // has to be passed 
		  
		  nav_hist tmp_obj=null;
		  Session ssn=null;
		  int ret_lst_mnths[] = {-3,-6,-12,-18,-24,-30,-36,-42,-48,-54,-60,9,12,18,24,36}; // list of month interval for which data need to be calculated
//		  int ret_lst_mnths[] = {-3}; // list of month interval for which data need to be calculated
		  int db_flag=1;
		  
	  	try
	  	{
	  		
	  		
	  		// EITHER YOU CAN PROVIDE SCHEME_CODE LIST (1) OR GET THAT FROM AVG_RETURN TABLE (2)
	  		
//	  		(1)
//	  	   LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list_EQUITY_ELSS.txt"), "UTF-8");	
////	  	   LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list.txt"), "UTF-8");	  	   
//	  	   
//	  	    while (it_s.hasNext()) // if the file has lines 
//   	            {
//		    	          scheme_code_lst.add(it_s.nextLine());
//   	            }
	  		
	  		 ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();
	  		
//	  		(2)
										Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
										criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
										criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
									 	criteria_1.addOrder(org.hibernate.criterion.Order.asc("key.scheme_code"));
											
									 	scheme_code_lst_lng = (ArrayList<Long>) criteria_1.list();
			 
			 
//			 scheme_code_lst_lng = new ArrayList<Long>();
//			 scheme_code_lst_lng.add((long)7615);
		 	
		 	for(Long tmp : scheme_code_lst_lng)
		 	{
		 		scheme_code_lst.add(String.valueOf(tmp));
		 	}
		 	
		 	System.out.println("SCHEMCODE LIST CONVERTED:----->>");
		 	
			 
	  	    
	  	  LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/date_list.txt"), "UTF-8"); 
	  	   
		  	 while(it.hasNext())
		     	{
			            	date_lst.add(it.nextLine());
		     	}
		  	 
		   
		  	
		  	for(String scheme_code : scheme_code_lst) //Travarsing SchemeCode List
		  	{
		  	   for(String day: date_lst)
		  	   {
		  		 ArrayList<nav_hist> list = get_list_of_dates_db(day,Integer.parseInt(scheme_code));
		  		 
		  		 nav_report_3_stable obj;
		  		 
		  		 if(list.size()>1)
		  		 {
		  		   tmp_obj = list.get(0);
		  		   
		  		   for(int mnths : ret_lst_mnths)
		  		   {
		  			  if(mnths<0) // backward months
		  			  {
		  				List<nav_hist> mm = get_list_of_dates_db(get_date(day, mnths, "sub"),Integer.parseInt(scheme_code));
		  				if(mm.size() >= 1) 
		  				{
		  				   nav_hist b = mm.get(0);
		  				   
//		  				   System.out.println("Negetive--->"+mnths);
//		  				   System.out.println("Date--->"+b.getNav_date());
//		  				   System.out.println("Date--->"+b.getScheme_code());
		  				   
		  				   obj = new nav_report_3_stable();
		  				   double res = (((tmp_obj.getAdjnavrs() - b.getAdjnavrs())/ b.getAdjnavrs())*100);
		  				   obj.setComment(Integer.toString(mnths));
		  				   obj.setNav_date(b.getNav_date());
		  				   obj.setNav_from_date(tmp_obj.getNav_date());
		  				   obj.setNav_value(res);
		  				   obj.setScheme_Code(Long.parseLong(scheme_code));
		  				   obj.setFund_Type(Fund_Type);
		  				   ssn.save(obj);
		  				   db_flag++;
		  				   
//		  				   System.out.println("Return-->"+res);
//		  				   System.out.println("Date-->"+obj.getNav_value());
//		  				   System.out.println("Comment-->"+obj.getComment());
		  				}
		  				
		  				
		  			  }
		  			  else if(mnths>0) // forward months
		  			  {
		  				List<nav_hist> mm = get_list_of_dates_db(get_date(day, mnths, "add"),Integer.parseInt(scheme_code));  
		  				
		  				if(mm.size() > 1)
		  				{
		  				   nav_hist b = mm.get(0);
		  				   
//		  				   System.out.println("Positive--->"+mnths);
//		  				   System.out.println("Date--->"+b.getNav_date());
//		  				   System.out.println("Date--->"+b.getScheme_code());
		  				   
		  				   obj = new nav_report_3_stable();
		  				   double res = (((b.getAdjnavrs() - tmp_obj.getAdjnavrs())/ tmp_obj.getAdjnavrs())*100);
		  				   obj.setComment(Integer.toString(mnths));
		  				   obj.setNav_date(b.getNav_date());
		  				   obj.setNav_from_date(tmp_obj.getNav_date());
		  				   obj.setNav_value(res);
		  				   obj.setScheme_Code(Long.parseLong(scheme_code));
		  				   obj.setFund_Type(Fund_Type);
		  				   ssn.save(obj);
		  				   db_flag++;
		  				   
//		  				   System.out.println("Return-->"+res);
//		  				   System.out.println("Date-->"+obj.getNav_value());
//		  				   System.out.println("Comment-->"+obj.getComment());
		  				   
		  				   
		  				}
		  				
		  			  }
		  			  
		  			 if(db_flag%50==0)
			  		 {
			  		      
			  		      ssn.flush();
					      ssn.clear();
//					      ssn.getTransaction().commit();
//					      ssn.beginTransaction();
					      db_flag=1;
			  		 }
		  			    
		  		   }
		  		      
		  			    
		  			 
		  		 }
		  		 else
		  		 {
		  			 continue;
		  		 }
		  		
		  		 
		  		
				  
			   }
		  		
		  	}
		  
		  	
//		  	ssn.getTransaction().commit();
		  	
		  	
		    
		    
	  	}
	  	catch(Exception e)
	  	{   
	  		System.out.println(""); 
	  		e.printStackTrace();
	  	}
	  	finally
	  	{
    		ssn.getTransaction().commit();
	  		ssn.close();
	  		System.out.println("<-- Complete -->");
	  	}
		
		
		

	}

}
