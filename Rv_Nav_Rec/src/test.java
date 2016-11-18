import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;

import controller.Avg_ret_Model;
import controller.Custom_Merged_Report_W_Rank;
import controller.Mf_portfolio_Model;
import controller.Qtr_Avg;
import controller.composite_pk;
import controller.composite_pk_avg_re_model;
import controller.nav_hist;
import controller.nav_report_temp_1;



public class test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	
//private static Date get_Date_Corrected_New(java.util.Date time) {
//		
//		java.util.Date ddd=time;
//		
//		 if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
//	      {
//	    	   ddd.setDate(31);
//	      }
//	  	  if(ddd.getMonth()==1)
//	      {
//	  	        ddd.setDate(28);
//	  	        
//	      }
//	  	  if(ddd.getMonth()==3 || ddd.getMonth()==5 || ddd.getMonth()==8 || ddd.getMonth()==10)
//	      {
//	  	        ddd.setDate(30);
//	  	        
//	      }	
//	  	  
//		return ddd;
//	}
//	
//	static String get_date(String day, int months, String opr) throws ParseException
//	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		  Calendar cal = Calendar.getInstance();
//	      cal.setTime(formatter.parse(day));
//	      months=Math.abs(months);
//	      
//	      if(opr=="add")
//	      {
////	    	  cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+months)); 
//	    	  
//	    	  
//	    	  cal.add(Calendar.MONTH,months);
//	      }
//	      else if(opr=="sub")
//	      {
////	    	  cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)-months));
//	    	  
//	    	  
//	    	  cal.add(Calendar.MONTH,months);
//	      }
//	      
//	      
//	     
//	      
//	      java.util.Date ddd = cal.getTime();
//	      
//	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
//	      {
//	    	   ddd.setDate(31);
//	      }
//	      else
//	      {
//	    	   ddd.setDate(30);
//	      }
//	      
//	      
//	      
////	      SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//	      String formatted = formatter.format(ddd);
//	      
//	      return formatted;
//	}
//	
//	static ArrayList<nav_hist> get_list_of_dates_db(String day, int scheme_code) throws ParseException
//	{
//			  SimpleDateFormat formatter=null;
//			  java.util.Date date_nav_chk_start=null;
//			  java.util.Date date_nav_chk_end=null;
//			  
//			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
//			  Session ssn= HIbernateSession.getSessionFactory().openSession();
//			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  //System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);	   
//			  date_nav_chk_end = new Date(date_nav_chk_start.getTime()-((1000 * 60 * 60 * 24)*5));
//
//			  // date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
//			  System.out.println("<<<<<<------------>>>>>>>");
//			  System.out.println("Scheme Code-->"+scheme_code);
//			  System.out.println("Start Date-->"+date_nav_chk_start);
//			  System.out.println("End Date-->"+date_nav_chk_end);
//			  System.out.println("<<<<<<------------>>>>>>>");
//			  
//			  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
//			  criteria.add(Restrictions.eq("scheme_code",scheme_code)); 
//			  criteria.add(Restrictions.between("nav_date", date_nav_chk_end, date_nav_chk_start));
//      		  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_date"));
//			  lst =(ArrayList<nav_hist>) criteria.list();
//			  
////			  ssn.getTransaction().commit();
//			  ssn.close();
//		 return lst;
//	}
//	
//
//	
//	
//	static ArrayList<java.util.Date> get_list_of_dates_portfolio(java.util.Date day, long sc) throws ParseException
//	{
//			  java.util.Date date_nav_chk_end=null;
//			  
//			  ArrayList<java.util.Date> lst = new ArrayList<java.util.Date>();
//			  Session ssn= HIbernateSession.getSessionFactory().openSession();
//			 
//			  
//			  System.out.println("DATE--->> "+day);
////			  formatter = new SimpleDateFormat("dd/MM/yyyy");
////			  System.out.println("DATE-FOrmatter-->>"+myDate);
////			  date_nav_chk_start = formatter.parse(day);
//			  
//			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*7));
//			 
//			  ProjectionList projList = Projections.projectionList();
//			  projList.add(Projections.property("inv_date"));
//			  
//			  Criteria criteria = ssn.createCriteria(controller.Mf_portfolio_Model.class);
//			  criteria.add(Restrictions.eq("scheme_code",sc)); 
//			  criteria.add(Restrictions.between("inv_date", date_nav_chk_end, day));
//			  criteria.setProjection(Projections.distinct(projList));
//			  criteria.addOrder(org.hibernate.criterion.Order.desc("inv_date"));
//			  
//      		  lst =(ArrayList<java.util.Date>) criteria.list();
//			  
////			  ssn.getTransaction().commit();
//			  ssn.close();
//		 return lst;
//	}
//	
	
	
	public static long Check_for_Portfolio(long scheme_code, Session ssn , String code_type)
	{
		 ArrayList<Long> schm_cd= (ArrayList<Long>) ssn.createQuery("select count(*) from Mf_portfolio_New where scheme_code='"+scheme_code+"'").list();
		 long scheme_code_to_return=0;
		 
		 
		 if(schm_cd.get(0)>0)
		 {
//			 System.out.println("coming here.......");
			 scheme_code_to_return = scheme_code;
			 
		 }
		 else 
		 {
//			 System.out.println("coming here.......");
			 if(!code_type.equals("PRIMARY_FD_CODE"))
			 {
//				 System.out.println("coming here toooo.......");
		        ArrayList<Long> pri_fd_cd = (ArrayList<Long>) ssn.createQuery("select PRIMARY_FD_CODE from Scheme_Detail where scheme_code='"+scheme_code+"' ").list();
		         if(pri_fd_cd.size()>0)
		         {
		        	 scheme_code_to_return =  Check_for_Portfolio(pri_fd_cd.get(0),ssn,"PRIMARY_FD_CODE");
		        	 
		        	 
		         }
		         
			 }
		 }
		return scheme_code_to_return;
	}
	
	
	
	
	
	
	
	public static List<java.util.Date> getDates(long s_code, Session ssn , java.util.Date next_qtr_dt) throws ParseException
	{
		List<java.util.Date> dd_final=null;
//		Session ssn=null;
//		ssn = HIbernateSession.getSessionFactory().openSession(); 
	    
//		ssn.beginTransaction();
	  	
		if(next_qtr_dt==null)
		{
			System.out.println("IN NULLL CASE");
			
			Criteria criteria_1 = ssn.createCriteria(nav_hist.class );
			criteria_1.setProjection( Projections.distinct(Projections.property("nav_date")));  		
	  		criteria_1.add(Restrictions.eq("scheme_code",(int) s_code));
	  		criteria_1.addOrder(Order.asc("nav_date"));
	  		criteria_1.setMaxResults(1);
	  		
	  		// NEW ADDED 
	  		List<java.util.Date> dd = criteria_1.list(); 
	           
	  		if(dd.size()==0)
	  		{
	  			
	  			System.out.println("COMING HERE IN THE no DTA LIST(==NULL)");
	  			dd_final=null;
	  			
	  		}
	  		else if(dd.size()>0)
	  		{
	  	  		java.util.Date ddd = dd.get(0);         		
	  	  		
			  	  if(ddd.getMonth()==0 || ddd.getMonth()==1 || ddd.getMonth()==2)
			      {
			    	   ddd.setDate(31);
			    	   ddd.setMonth(2);
			      }
			  	  if(ddd.getMonth()==3 || ddd.getMonth()==4 || ddd.getMonth()==5)
			      {
			  	        ddd.setDate(30);
			  	        ddd.setMonth(5);
			      }
			  	  if(ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==8)
			      {
			  	        ddd.setDate(30);
			  	        ddd.setMonth(8);
			      }
			  	  if(ddd.getMonth()==9 || ddd.getMonth()==10 || ddd.getMonth()==11)
			      {
				        ddd.setDate(31);
				        ddd.setMonth(11);
			      }
//	        System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
//		  	  System.out.println("FInal Date Prepared-->>"+ddd);
//			  System.out.println("Scheme_code-->>"+s_code);	  
//			  System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
			  
			  
			  
			  	List<nav_hist> nv_dt_lst = avg_return_2_main.get_list_of_dates_db(ddd, (int) s_code, ssn);		  	  
		        
			  	
//			  	   System.out.println("Got value @ Date-->>"+nv_dt_lst.get(0));
			  	if(nv_dt_lst.size()==0)
			  	{
			  		dd_final=null;
			  		
			  		
			  		ArrayList<Date> first_dt = (ArrayList<Date>) ssn.createQuery("select distinct(nav_date) from nav_hist_full where scheme_code='"+s_code+"'").list();
					java.util.Date ddd_1 = first_dt.get(0);
			
					if(ddd_1.getMonth()==0 || ddd_1.getMonth()==1 || ddd_1.getMonth()==2)
				      {
						ddd_1.setDate(31);
						ddd_1.setMonth(2);
				      }
				  	  if(ddd_1.getMonth()==3 || ddd_1.getMonth()==4 || ddd_1.getMonth()==5)
				      {
				  		ddd_1.setDate(30);
				  		ddd_1.setMonth(5);
				      }
				  	  if(ddd_1.getMonth()==6 || ddd_1.getMonth()==7 || ddd_1.getMonth()==8)
				      {
				  		ddd_1.setDate(30);
				  		ddd_1.setMonth(8);
				      }
				  	  if(ddd_1.getMonth()==9 || ddd_1.getMonth()==10 || ddd_1.getMonth()==11)
				      {
				  		ddd_1.setDate(31);
				  		ddd_1.setMonth(11);
				      }
		  			
		  			dd_final = getDates(s_code,ssn,ddd);
			  		
			  		
			  	}
			  	else
			  	{
			  		dd_final = new ArrayList<java.util.Date>();
				  	
				  	dd_final.add(nv_dt_lst.get(0).getNav_date());
			  	}
			  	
			  	
	  		}
		}
		else
		{
			Calendar cal = Calendar.getInstance();	  	  
		  	  
		  	  cal.setTime(next_qtr_dt);
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		      cal.add(Calendar.MONTH,3);
		      Date ddd = cal.getTime();
		      
		      
		       
		  	List<nav_hist> nv_dt_lst = avg_return_2_main.get_list_of_dates_db(ddd, (int) s_code, ssn);		  	  
	        
		  	
//		  	   System.out.println("Got value @ Date-->>"+nv_dt_lst.get(0));
		  	if(nv_dt_lst.size()==0)
		  	{
		  		dd_final=null;
		  		
		  	}
		  	else
		  	{
		  		dd_final = new ArrayList<java.util.Date>();
			  	
			  	dd_final.add(nv_dt_lst.get(0).getNav_date());
		  	}
		      
		  	  
			
		}
		
		
		  
  		
  		
//  		ssn.close();
  		
  		ssn.getTransaction().commit();
  		ssn.beginTransaction();
  		
  		return dd_final;
  		
	}
	
	
	
	// main function...///
	
	public static void main(String[] args) throws ParseException {
	
		
		Session ssn = HIbernateSession.getSessionFactory().openSession();
		ssn.beginTransaction();
		
		
		System.out.println("Print----->>");
		System.out.println((getDates(7615, ssn, null)).get(0));
		
		
//		
//		long schm_code=0,res;
//		
//		schm_code=3269;
//		
//		res = Check_for_Portfolio(schm_code, ssn, "SCHEME_CODE");
//		
//		System.out.println("Scheme_Code--->>>"+res);
		
		
//				
//		ArrayList<Long> max_id_lst =  (ArrayList<Long>) ssn.createQuery("select MAX(id) from Scheme_Aum").list();
//				
//		System.out.println("MAX-ID>"+max_id_lst.get(0));
//		ssn.close();
		
		
		
//		ArrayList<Long> scheme_code_lst = new ArrayList<Long>();
//		String Fund_Type="EQUITY_SML";
//		
////		System.out.println("select DISTINCT(scheme_Code) from avg_return where Fund_Type='"+Fund_Type+"'");
//		
////		scheme_code_lst = (ArrayList<Long>) ssn.createQuery("select DISTINCT(scheme_Code)from avg_return where key.Fund_Type='"+Fund_Type+"'").list();
//
//		Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//		criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
//		criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
// 		criteria_1.addOrder(Order.asc("key.scheme_code"));
//		
// 		scheme_code_lst = (ArrayList<Long>) criteria_1.list();
//		
//		System.out.println("LIST SIze-->>"+scheme_code_lst.size());
//		
//		
//		for(Long bbb : scheme_code_lst)
//		{
//			System.out.println(bbb);
//		}
		
		ssn.close();
		
//		while(true)
//		{
//			System.out.println("Run...");
//		}
		
		
//		int retval;
//		double temp_val_hldr=-9999;
//		int rank_hldr=0;
//		int same_rank_flag=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		ssn.beginTransaction();
//		
//		
//		
//		 ArrayList<Custom_Merged_Report_W_Rank> data_lst = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank where quarter='Qtr_1_15' order by last_4_neg_avg_cat_ret_otb").list();
//		
//		 
//		 
//		 for(Custom_Merged_Report_W_Rank arm : data_lst)
//		 {
//			 retval = Double.compare(temp_val_hldr,arm.getLast_4_neg_avg_cat_ret_otb());
//			    
//			 
//			 
//		    	if(retval==0)
//		    	{
//		    		System.out.println("<<<<<<<<<<<<<<<<-------START------->>>>>>>>>>>>>>>>>");
//		       
//		    		System.out.println("COmparing Val-1"+temp_val_hldr+"   with val2->"+arm.getLast_4_neg_avg_cat_ret_otb());
//		    		System.out.println("Compare Result-->"+retval);
//		    		System.out.println("VALUE--->>"+arm.getLast_4_neg_avg_cat_ret_otb());
//		    		System.out.println("DATE-->>"+arm.getKey().getFrom_date());
//		    		System.out.println("RANK-->>"+(rank_hldr));
//		    		System.out.println("<<<<<<<<<<<<<<<<-------END------->>>>>>>>>>>>>>>>>");
//		    		temp_val_hldr= arm.getLast_4_neg_avg_cat_ret_otb();
//		    		same_rank_flag++;
////		    	    arm.setR_last_4_neg_avg_cat_ret_otb(rank_hldr-1);
////		    	    ssn.update(arm);
////		    	    db_flag++;
//		    	}
//		    	else
//		    	{    
//		    		System.out.println("<<<<<<<<<<<<<<<<-------START------->>>>>>>>>>>>>>>>>");
//		    		
//		    		rank_hldr=rank_hldr+same_rank_flag;
//		    		same_rank_flag=0;
//		    		rank_hldr=rank_hldr+1;
//		    		
//		    		System.out.println("COmparing Val-1"+temp_val_hldr+"   with val2->"+arm.getLast_4_neg_avg_cat_ret_otb());
//		    		System.out.println("Compare Result-->"+retval);
//		    		System.out.println("VALUE--->>"+arm.getLast_4_neg_avg_cat_ret_otb());
//		    		System.out.println("DATE-->>"+arm.getKey().getFrom_date());
//		    		System.out.println("RANK-->>"+(rank_hldr));
//		    		System.out.println("<<<<<<<<<<<<<<<<-------END------->>>>>>>>>>>>>>>>>");
//		    		temp_val_hldr= arm.getLast_4_neg_avg_cat_ret_otb();
////		    		arm.setR_last_4_neg_avg_cat_ret_otb(rank_hldr);
////		    	    ssn.update(arm);
////		    	     db_flag++;  
//		    		
//		    	}
//		    	
//		    	
//		    	
//		 }
		 
		
//		Date nnn = new Date(115, 02, 31);
//		
//		
//		Date mm2 = new Date();
//		
//		Date mmn = new Date(120, 03, 31);
//		
//		System.out.println("Today--(mm2)---"+mm2);
//		System.out.println("2012/03-31--(nnn)---"+nnn);
//		System.out.println("2020/03/31- (mmn)--"+mmn);
//		
//		System.out.println(mm2.compareTo( new Date(120,04,21)));
		
//		System.out.println(mm2.compareTo(nnn));
		 	
//--------------------------------------------------------------------------------------------------------------------------------		
//		Session ssn = HIbernateSession.getSessionFactory().openSession();
//		ssn.beginTransaction();
//		
//		 nav_hist current_nav_obj= ssn.get(nav_hist.class,(long)4007);
//		
//		
//		 
//		ArrayList<nav_hist> dt_lst_last_50_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where nav_date<=? and scheme_code=? order by nav_date desc").setDate(0,current_nav_obj.getNav_date()).setLong(1,current_nav_obj.getScheme_code()).setMaxResults(50).list();
//		
//		if(dt_lst_last_50_days.size()>0)
//		{ 
//			for(nav_hist ob :  dt_lst_last_50_days)
//			 {
//				 System.out.println("Objects ID-->>"+ob.getId());
//				 System.out.println("Objects NAV-->>"+ob.getAdjnavrs());
//				 System.out.println("Objects DATE-->>"+ob.getNav_date());
//			 }
//		}
//		 
//		
//		ssn.close();
		
//--------------------------------------------------------------------------------------------------------------------------------		
		
		
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		ssn.beginTransaction();	
//		
//		int db_save=1;
//		
//		long arr[] = {407, 447, 641, 716, 748, 758, 931, 946, 950, 1131, 1273, 1282, 1283, 1284, 1331,
//                1348, 1495, 1608, 1623, 1849, 1858, 1961, 2129, 2133, 2384, 2669, 2681, 2751,
//                2782, 2808, 3007, 3065, 3247, 3249, 3281, 3283, 3305, 3317, 3460, 3627, 3642};
//		java.util.Date date_corr=null;
//		
//		long l=0;   /// for id in portfolio Table
//		
//		Query q111 = ssn.createQuery("select Max(id) from Mf_portfolio_Model");
//		 
//		l=(long) q111.list().get(0);
//		
//		for(long sc : arr)
//		{
//              //     get_Date_Corrected_New
//		    String qry_strng="select DISTINCT(inv_date) from  Mf_portfolio_Model where scheme_code="+sc+" and inv_date>='2003-05-20' and inv_date<='2003-06-30'";
//		    Query q1 = ssn.createQuery(qry_strng);
//		
//		        ArrayList<java.util.Date> avg_ret_main_list = (ArrayList<java.util.Date>) q1.list();
//		   
////		             System.out.println("SchemeCode-->>"+sc);
//		           
//		             Mf_portfolio_Model nw_obj = null;
//			         for(java.util.Date rr :avg_ret_main_list)
//			         {
//			        	 
//			        	 Criteria criteria_3 = ssn.createCriteria( Mf_portfolio_Model.class );
//						 criteria_3.add(Restrictions.eq("inv_date",rr));
//						 criteria_3.add(Restrictions.eq("scheme_code",sc));
//				    	 
//						  ArrayList<Mf_portfolio_Model> portfolios_1 = (ArrayList<Mf_portfolio_Model>) criteria_3.list();
//			        	 
//			        	 
//			//			        	 System.out.println("Dates-->"+rr);
//								for(Mf_portfolio_Model old_obj : portfolios_1)
//											 {
//						//			        	 date_corr =new Date(103,04,31);
//									        	 nw_obj = new Mf_portfolio_Model();
//									        	 
//									        	 nw_obj.setId(new Random().nextLong());
//										    	 nw_obj.setId(++l);
//										    	 nw_obj.setComp_name(old_obj.getComp_name());
//										    	 nw_obj.setFin_code(old_obj.getFin_code());
//										    	 nw_obj.setHolding_prcnt(old_obj.getHolding_prcnt());
//										    	 nw_obj.setInv_date(new Date(103,05,30));
//										    	 nw_obj.setRv_sect_name(old_obj.getRv_sect_name());
//										    	 nw_obj.setScheme_code(old_obj.getScheme_code());
//										    	 nw_obj.setClassification(old_obj.getClassification()); 	 
//										    	 
//										    	 
//										    	 ssn.save(nw_obj);
//										    	 db_save++;
//						//				    	 ssn.getTransaction().commit();
//										    	 
//										    	 if(db_save%50==0)
//											      {
//											    	  ssn.getTransaction().commit();
//											    	  ssn.clear();
//											    	  ssn.flush();
//											    	  ssn.beginTransaction();
//											      }
//										    	 
//										    	 
//										    	 
//											 }	 
//			        	 
//			        	 
//			         }
//		        	 
//		}
//		
//		
//		ssn.getTransaction().commit();
// 		ssn.close();
		 
		 
		 
		 
//		
//		long x=15;
//		ArrayList<java.util.Date> lst = get_list_of_dates_portfolio( new Date(105, 11, 31), x);
//		
//		System.out.println("Generated Date--->>"+new Date(105, 11, 31));
//		
//		System.out.println("LIST SIZEE--->>"+lst.size());
//		for(java.util.Date dd : lst)
//		{
//			System.out.println(dd);
//		}
		
		
		
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		ssn.beginTransaction();	
//		    
////		String hql_p1="select DISTINCT(scheme_Code)from nav_report_final";
//// 		Query q_p1 = ssn.createQuery(hql_p1);
//// 		
//// 		ArrayList<Long> comment_list_sch_wise = (ArrayList<Long>) q_p1.list();
//		ArrayList<Long> comment_list_sch_wise = new ArrayList<Long>();
//		
//		comment_list_sch_wise.add((long)407); 
//		
//		ArrayList<java.util.Date> dt_lst_mismatch = new ArrayList<java.util.Date>();
//		ArrayList<java.util.Date> dt_lst_match_try = new ArrayList<java.util.Date>();
//		
//		for(Long sc : comment_list_sch_wise)
//		{
//			
//			String sql_1="select distinct(key.from_date) from Report_8_Model where scheme_code="+sc+"order by scheme_code";
//			
//			String sql_2="select distinct(key.start_dt) from avg_return where scheme_code="+sc+" and start_dt>='2000-01-31' and start_dt<='2015-03-31' order by scheme_code";
//			
//			Query q_sql_1 = ssn.createQuery(sql_1);
//			
//			Query q_sql_2 = ssn.createQuery(sql_2);
//			
//			ArrayList<java.util.Date> dt_lst_Report_8 = (ArrayList<java.util.Date>) q_sql_1.list(); 
//			
//			ArrayList<java.util.Date> dt_lst_avg_return = (ArrayList<java.util.Date>) q_sql_2.list();
//			
//  
//							  System.out.println("<<<<<<<<<<<<<<<<<<<--------------->>>>>>>>>>>>>>>>>>>>>");
//					   	      System.out.println("Date Mismatched Scheme_Code-->>"+sc);
//					   	      System.out.println("Difference-->>"+(dt_lst_avg_return.size() - dt_lst_Report_8.size() ));
//					   	      System.out.println("Mismatch Dates--->>");
//				    	      
//				    	      
//				    	      for(java.util.Date r88 : dt_lst_Report_8 )
//				    	      {
//				    	    	 
//				    	    	    
//				    	    	  for(java.util.Date armm :dt_lst_avg_return)
//					    	      {
//					    	    	    if(armm.compareTo(r88)==0)
//					    	    	    {
//					    	    	    	
//					    	    	    	if(dt_lst_match_try.contains(armm))
//					    	    	    	{
//					    	    	    		
//					    	    	    	}
//					    	    	    	else
//					    	    	    	{
//					    	    	    		dt_lst_match_try.add(armm);	
//					    	    	    	}
//					    	    	    	
//					    	    	    }
//					    	    	    else
//					    	    	    {
//					    	    	    	if( (armm.getMonth()==r88.getMonth()) && (armm.getYear()==r88.getYear()) ) 
//					    	    	    	{
//					    	    	    		if(dt_lst_match_try.contains(armm))
//						    	    	    	{
//						    	    	    		
//						    	    	    	}
//						    	    	    	else
//						    	    	    	{
//						    	    	    		dt_lst_match_try.add(armm);	
//						    	    	    	}
//					    	    	    	}
//					    	    	    	else
//					    	    	    	{
//					    	    	    		
//					    	    	    		if(dt_lst_mismatch.contains(armm))
//					    	    	    		{
//					    	    	    			
//					    	    	    		}
//					    	    	    		else
//					    	    	    		{
//					    	    	    		  dt_lst_mismatch.add(armm);
//					    	    	    		}
////					    	    	    		System.out.println(arm);
//					    	    	    	}
//					    	    	    }
//					    	    	  
//					    	      }
//				    	    	  
//				    	    	  
//				    	    	  
//				    	      }
				    	      
				    	      //
				    	      
//				    	      for(java.util.Date hh : dt_lst_mismatch)
//				    	      {
//				    	    	  System.out.println(hh);
//				    	      }
//				    	      System.out.println("<<<<<<<<<<<<<<<<<<<------END--------->>>>>>>>>>>>>>>>>>>>>");
//				    	      
//				    	      System.out.println("<<<<<<-------------MATCH DATES------------->>>>>>>>>>>>>>>>");
//				    	      for(java.util.Date hh : dt_lst_match_try)
//				    	      {
//				    	    	  System.out.println(hh);
//				    	      }
				    	      
				    	      
				    	      
				    	      

			
			
//		}
 		
 		
 		
 		
 		
 		
// 		System.out.println("<<------MismATCH SCheme Code List----->>>");
// 		System.out.println("Total-->>"+sc_lst_mismatch.size());
// 		for(Long hh : sc_lst_mismatch)
// 		{
// 			System.out.println(hh);
// 		}
// 		System.out.println("<<------MismATCH SCheme Code List END----->>>");

 		
 		
 		
 		//		
//		String dd = "31/03/2009";
		
//		Date startDate = new Date(115,02,31);
//        System.out.println("Today-->"+startDate);
		
//		ArrayList<nav_hist> nml = get_list_of_dates_db(dd, 15);
//		
//		
//		System.out.println(get_date(dd,6,"add"));
//		System.out.println(get_date(dd,6,"sub"));
		
		
		
//		System.out.println("DAte List");
//		System.out.println(nml.get(0).getNav_date());
		
		
		
		
		
//          Qtr_Avg qa = new Qtr_Avg();
//          
//          qa.setQuarter("Qtr_Avg_1");
//          
//          
//         change_val(qa);
//         
//         
//         System.out.println("Quarter-->"+qa.getQuarter());
//         System.out.println("Average-->"+qa.getAverage());
//     
//         qa.setAverage(999999.9990);
//		
//		 
//         System.out.println("Quarter-->"+qa.getQuarter());
//         System.out.println("Average-->"+qa.getAverage());
         
         
//		ArrayList<String> al = new ArrayList<String>();
//		
//		al.add("mango");
//		al.add("apple");
//		al.add("banana");
//		al.add("guava");
//		al.add("pineapple");
//		al.add("kiwi");
//		al.add("nut");
//		
//		int t= al.indexOf("banana");
//		
//		System.out.println(t);
		
//		double temp_val=-0.269405198;
//		double temp_val_1= -0.094953795;
//
//		int retval = Double.compare(temp_val,temp_val_1);  		
//
//		
//		System.out.println(retval);
//		
		
		
//		String cmnt="Qtr_1_10";
//		String colmn="ret_mnth_6";
//		int col_val=0;
//		
//		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
//		Session ssn = sessionfactry.openSession();		
//    	String hql = "from nav_report_temp_1 where coment=:cmnt and :column!=0 order by :column asc";            
//	 		   Query q = ssn.createQuery(hql);
//	 		   q.setParameter("cmnt", cmnt);
//	 		   q.setParameter("column",colmn);
//	 		 
//	 		   
////	 		   composite_pk cpk =new composite_pk();
////	 		   cpk.setComent(cmnt);
//	 		   
//	 		  
//	 		   
////	 		  Criteria criteria_1 = ssn.createCriteria( nav_report_temp_1.class );
////	 		  criteria_1.setProjection( Projections.distinct(Projections.property("comment")));  		
////	   		  criteria_1.add(Restrictions.eq("coment",cmnt));
////	   		  criteria_1.add(Restrictions.ne(colmn,col_val));
////	   		  criteria_1.addOrder(Order.asc(colmn));
//	 		   
//	 		   
////	   	 ArrayList<nav_report_temp_1> n_r_t =  (ArrayList<nav_report_temp_1>) criteria_1.list();
//	 		   ArrayList<nav_report_temp_1> n_r_t = (ArrayList<nav_report_temp_1>) q.list();
//		
//		for(nav_report_temp_1 nrt : n_r_t)
//		{
//			System.out.println(nrt.getRet_mnth_6());
//		}
//	 		   
	 		   
	 		   
		
	
//		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
//		Session ssn = sessionfactry.openSession();		
//		String hql_1="from nav_report_temp_1 group by coment";
		
//		SQLQuery query = ssn.createSQLQuery(sql_1);
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		
		
//		Query q_1 = ssn.createQuery(hql_1);
		
//		Query q_1 = ssn.createQuery(hql_1);
//		
//		
////		List<String> coment_list = query.list();
//		List<nav_report_temp_1> nav_report_list = q_1.list();
//		List<String> coment_list = new ArrayList<String>();
//		
//		
//		for(nav_report_temp_1 s : nav_report_list)
//		{
//			coment_list.add(s.getKey().getComent());
//			
////			System.out.println(s.getKey().getComent());
//		}
		
		
		
		
		
//		int index_tmp=0;
//		ArrayList<String> comment_list = new ArrayList<String>(); 
//		ArrayList<String> comment_list_revised = new ArrayList<String>(); 
//		comment_list.add("first");
//		comment_list.add("second");
//		comment_list.add("third");
//		comment_list.add("fourth");
//		comment_list.add("fifth");
//		comment_list.add("sixth");
//		comment_list.add("seventh");
//		comment_list.add("eighth");
//		
//		
//		for(String xx :comment_list)
//	      { 
//			if(index_tmp!=0)
//			{
//				comment_list_revised.add(xx);
//				comment_list_revised.add(xx+"_Rank");
//			}
//			else
//			{
//				comment_list_revised.add(xx);
//			}
//			index_tmp++;
//	      }
//		
//		System.out.println("New Result--->>>");
//		for(String x :comment_list_revised)
//	      {   
//			 System.out.println(x);
//	      }	
//	      
		
		
//		
//		java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse("12/2/2004 12:00:00 AM");
//
//		
//		System.out.println("DATE--->>>"+dd);
		
		
		
		
		
//		java.util.Date today = new Date();    
//		Date tomorrow = new Date(today.getTime() - (1000 * 60 * 60 * 24));
//		Date tomorrow_p_3 = new Date(today.getTime() + (1000 * 60 * 60 * 24*180));
//		
////		Date startDate = new Date(103,02,31);
////		System.out.println("Today-->"+startDate);
//		
//		System.out.println("Tomorrow-->"+tomorrow);
//		System.out.println("Tomorrow-->"+tomorrow_p_3);
//		
//		System.out.println("Changing the day in Date ---->>>");
//		if(tomorrow.getMonth()==5)
//		{
//			tomorrow.setDate(31);
//			tomorrow_p_3.setDate(21);
//		}
//		
//		
//		
//		System.out.println("Tomorrow-->"+tomorrow);
//		System.out.println("Tomorrow-->"+tomorrow_p_3);
		
		
//		
//		      Calendar cal = Calendar.getInstance();
//			 
//		      cal.setTime(startDate);
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
//		      java.util.Date ddd = cal.getTime();
//		
////		      System.out.println("TODAY--->"+today);
//		      System.out.println("Date-->"+startDate);
//		      System.out.println("Calender Print--->"+ddd);
////		      System.out.println("NOrmal Date Print-->"+tomorrow_p_3);
//		      
//		      Calendar c2 = Calendar.getInstance();
//		      
//		      c2.setTime(startDate);
//		      c2.add(Calendar.MONTH, 3);
//		      java.util.Date dd_d1 = c2.getTime();
//		      System.out.println("Calender Print 2--->"+dd_d1);
		      
		      
//		      SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//		      String formatted = format1.format(ddd);
//		      
//		      
//		      System.out.println("String Print--->>"+formatted);
		      // Output "Wed Sep 26 14:23:28 EST 2012"

		     

		      
//		      int ret_lst_mnths[] = {-6,-12,-24,-36,-60,12,18,24};
//		      
//		      for(int x : ret_lst_mnths)
//		      {
//		    	  System.out.println("months--->"+x);
//		    	  if(x<0)
//		    	  {
//		    		  System.out.println("xx NEgetive==>"+x);
//		    		  String xc = Integer.toString(x);
//		    		  System.out.println("String x="+xc);
//		    	  }
//		    	  if(x>0)
//		    	  {
//		    		  System.out.println("xx Positive==>"+x);
//		    		  String xc = Integer.toString(x);
//		    		  System.out.println("String x="+xc);
//		    	  }
//		      }
		      
		
//        long days = Math.abs(((tomorrow_p_3.getTime()-startDate.getTime())/86400000));
//		
//		System.out.println("days-->>"+days);
		
		
//		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
//		final Matcher matcher = pattern.matcher("<<row>>1|2010-01-14 00:00:00.000|10.003|10.003|10.003|1283.96151718039|1293.71658911772| <</row>>");
//		matcher.find();
//		String[] separated = matcher.group(1).split("\\|");
//		
//		System.out.println(matcher.group(1)); // Prints String I want to extract
//		
//		System.out.println("Final Output-->");
		
//		for(int i=0;i<separated.length;i++)
//		{
//			System.out.println(separated[i]);
//		}

	}

	private static void change_val(Qtr_Avg qa) {
		
		
		qa.setAverage(145.369);
		
	}
	
	
	
	

}
