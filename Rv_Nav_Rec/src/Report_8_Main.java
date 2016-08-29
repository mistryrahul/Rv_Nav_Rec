import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;
import controller.Avg_ret_Model;
import controller.Mf_portfolio_Model;
import controller.Report_6_pk;
import controller.Report_8_Model;
import controller.Stock_rank_db;
import controller.nav_hist;
import controller.nav_report_3_stable;
import controller.nav_report_temp_1;
import controller.test_Controller;


public class Report_8_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 long id_change = 1720515;  // should be change each time
		 
		
		java.util.Date temp_date_hldr=null;
		java.util.Date actual_date_hldr=null;
		
		long temp_scheme_code_hldr=0;
		double total_rank_generated=0;
		double tmp_rank=0;
		long kk=1;
		int db_save_1=1;
		int db_save=0;
		Report_8_Model r8m =null;
		Report_6_pk pk_r8 =null;
		
		
		
		
		try
		  {
			
			  Complete_Database_Portfolio();  // For the missing Dates in Portfolio TAble
			  
			  System.out.println("<<<<<<<<<<<<<-------START------>>>>>>>>>>>>>>>>>>>");
			  System.out.println("Missing Files Updated in Portfolio Table"); 
			  System.out.println("<<<<<<<<<<<<<------END------->>>>>>>>>>>>>>>>>>>");
			  
			 Session ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();	
			 
			 
			 Query q111 = ssn.createQuery("select Max(id) from Mf_portfolio_Model");
			 
			 id_change=(long) q111.list().get(0);
			
			 
			 String hql_mn="from avg_return where start_dt>='2003-06-30' and start_dt<='2015-03-31' order by scheme_code";
			 Query q1 = ssn.createQuery(hql_mn);
			 ArrayList<Avg_ret_Model> avg_ret_main_list = (ArrayList<Avg_ret_Model>) q1.list();
			 
			 
			 Calendar cal = Calendar.getInstance(); 

			 
			     for(Avg_ret_Model arm :avg_ret_main_list)
			     {
			    	 
			    	 temp_date_hldr=null;
			    	 temp_scheme_code_hldr=0;
			    	 
			    	 temp_date_hldr=get_Date_Corrected(arm.getKey().getStart_dt());
			    	 actual_date_hldr = temp_date_hldr;  
			    	 temp_scheme_code_hldr= arm.getKey().getScheme_code();
			    	 
			    	 ArrayList<java.util.Date> portfolio_lst =  get_list_of_dates_portfolio( temp_date_hldr ,temp_scheme_code_hldr);
			    	 
//			    	 System.out.println("<<<<<<<<<-----1---->>>>>>>>>>>>");
//			    	 System.out.println("DATE--->>"+arm.getKey().getStart_dt());
//			    	 System.out.println("Port folio List SIze-->>"+portfolio_lst.size());
//			    	 System.out.println("<<<<<<<<<-----1 END---->>>>>>>>>>>>");
			    	  
			    	 int loop_breaker=1;
			    	  			    	  
			    	  
			    	  int ss =arm.getKey().getStart_dt().compareTo(new Date(103,05,30));
			    	  
//			    	        System.out.println("First Date--->>>"+temp_date_hldr);
			    	        
					    	 while (portfolio_lst.size()==0 && ss!=0)
					    	 {

					    		 cal.setTime(temp_date_hldr);
		    	        	     cal.add(Calendar.MONTH , -1 );
		    	        	     
//		    	        	     System.out.println("DATE SHOULD BE date -1  -->"+temp_date_hldr);
		    	        	     
					    		 temp_date_hldr = get_Date_Corrected_New(cal.getTime());
					    		 
//					    		 System.out.println("Loop----("+loop_breaker+")-- DAte Taken--->>>"+temp_date_hldr);
					    		 
					    		 portfolio_lst =  get_list_of_dates_portfolio( temp_date_hldr ,temp_scheme_code_hldr);
					    		 
					    		 
					    		 ///<---------------- New Added ------------------->
					    		 if(portfolio_lst.size()>0)
					    		 {
					    			 Criteria criteria_3 = ssn.createCriteria( Mf_portfolio_Model.class );
									 criteria_3.add(Restrictions.eq("inv_date",portfolio_lst.get(0)));
									 criteria_3.add(Restrictions.eq("scheme_code",arm.getKey().getScheme_code()));
							    	 
									  ArrayList<Mf_portfolio_Model> portfolios_1 = (ArrayList<Mf_portfolio_Model>) criteria_3.list();
									  
									     Mf_portfolio_Model new_obj=null;
									  
									     for(Mf_portfolio_Model old_obj : portfolios_1)
									     {
									    	 new_obj = new Mf_portfolio_Model();
									    	 new_obj.setId(new Random().nextLong());
									    	 new_obj.setId(++id_change);
									    	 new_obj.setComp_name(old_obj.getComp_name());
									    	 new_obj.setFin_code(old_obj.getFin_code());
									    	 new_obj.setHolding_prcnt(old_obj.getHolding_prcnt());
									    	 new_obj.setInv_date(actual_date_hldr);
									    	 new_obj.setRv_sect_name(old_obj.getRv_sect_name());
									    	 new_obj.setScheme_code(old_obj.getScheme_code());
									    	 new_obj.setClassification(old_obj.getClassification());
									    	 
//									    	 new_obj = old_obj;
//									    	 Random rand = new Random();
//									    	 new_obj.setId();
									    	
									    	 ssn.save(new_obj);
									    	 
//									    	 System.out.println("<---  New OBject START-->");
//									    	 System.out.println("Id-->"+new_obj.getId());
//									    	 System.out.println("Id-->"+new_obj.getInv_date());
//									    	 System.out.println("<---  New OBject END -->");
									     }
									     portfolio_lst.remove(0);
									     portfolio_lst.add(0,actual_date_hldr);
									     
									     ssn.getTransaction().commit();
									     ssn.beginTransaction();
									     ssn.clear();
									     ssn.flush();
									    
									     
									     
					    		 }
					    		 ///<------------- New Added Upto This -------------->	 
                             					    		 
					    		 if(loop_breaker==3)
					    		 {
					    			 break;
					    		 }
					    		 loop_breaker++;
					    	 }
			    	 
			    	
					    	 
			    	 if(portfolio_lst.size()>0 )
			    	 { 
			    		 Criteria criteria_2 = ssn.createCriteria( Mf_portfolio_Model.class );
						 criteria_2.add(Restrictions.eq("inv_date",portfolio_lst.get(0)));
						 criteria_2.add(Restrictions.eq("scheme_code",arm.getKey().getScheme_code()));
				    	 
						 ArrayList<Mf_portfolio_Model> portfolios = (ArrayList<Mf_portfolio_Model>) criteria_2.list();
						 
//				    	 System.out.println("<<<<<<<<<-----2---->>>>>>>>>>>>");
//						 System.out.println("Portfolio as on DAte---->>"+portfolio_lst.get(0));
//						 System.out.println("Portfolio Value (If Success > 0)"+portfolios.size());
//				    	 System.out.println("<<<<<<<<<-----2 END---->>>>>>>>>>>>");
						 
						 total_rank_generated=0;
						 tmp_rank=0;
						 
						 r8m =new Report_8_Model();
						 pk_r8 = new Report_6_pk();
						 
						 pk_r8.setFrom_date(portfolio_lst.get(0));
						 pk_r8.setScheme_code(arm.getKey().getScheme_code());
                         
						 r8m.setKey(pk_r8);
                         
						 ArrayList<java.util.Date> check_date = Get_date_from_nav_Report_Final( get_Date_Corrected(arm.getKey().getStart_dt()) , arm.getKey().getScheme_code());
						 
						      if(check_date.size()>0)
						      {
						    	  Query frwrd_12_18 = ssn.createQuery("from nav_report_final where nav_from_date=? and scheme_code=? and comment in(?,?)");
							      frwrd_12_18.setDate(0,check_date.get(0));
							      frwrd_12_18.setLong(1, arm.getKey().getScheme_code());
							      frwrd_12_18.setString(2, "12");
							      frwrd_12_18.setString(3, "18");
							      
							      ArrayList<nav_report_3_stable> nav_rep_final_lst = (ArrayList<nav_report_3_stable>) frwrd_12_18.list();
							                     
							              for(nav_report_3_stable nr3s :nav_rep_final_lst)
							              {
							            	   if(nr3s.getComment()=="12"  || nr3s.getComment().equals("12"))
							            	   {
							            		   r8m.setForward_12_mnth(nr3s.getNav_value());
							            	   }
							            	   else if(nr3s.getComment()=="18"  || nr3s.getComment().equals("18"))
							            	   {
							            		   r8m.setForward_18_mnth(nr3s.getNav_value());
							            	   }
							              }
						      }
						      
						 
						 
						      r8m.setNo_of_stock(portfolios.size());
						      
						      for(Mf_portfolio_Model pf:portfolios)
						      {
						    	  
						    	  java.util.Date ddd = get_Date_Corrected( pf.getInv_date() );
						    	  
						    	  					    	  
						    	  
								    	        Query ech = ssn.createQuery("from Stock_rank_db where accord_code=? and day=?");
								    	        ech.setLong(0, pf.getFin_code());
								    	        ech.setDate(1, ddd);
								    	        
								    	        ArrayList<Stock_rank_db> srdb_lst = (ArrayList<Stock_rank_db>) ech.list();
								    	        
								    	        if(srdb_lst.size()>0)
								    	        {
								    	        	tmp_rank = pf.getHolding_prcnt() * srdb_lst.get(0).getRank();
								    	        	total_rank_generated = total_rank_generated + tmp_rank;
								    	        }
						    	        
						    	 
						      }
						      
						      r8m.setGen_rank((total_rank_generated/100));
						      ssn.save(r8m);
						      db_save++;
						      
						      if(db_save%50==0)
						      {
						    	  ssn.getTransaction().commit();
						    	  ssn.beginTransaction();
						    	  
						    	  ssn.clear();
						    	  ssn.flush();
						    	  
						      }
						      
						      
			    		 
			    	 }
			    	 else
			    	 {
			    		 controller.test_Controller tc= new test_Controller();
			    		 tc.setId(kk++);
			    		 tc.setFrom_date(arm.getKey().getStart_dt());
			    		 tc.setQuarter(arm.getComment());
			    		 tc.setScheme_code(arm.getKey().getScheme_code());
			    		 
			    		 ssn.save(tc);
			    		 db_save_1++;
			    		 if(db_save_1%50==0)
					      {
					    	  ssn.getTransaction().commit();
					    	  ssn.beginTransaction();
					    	  ssn.clear();
					    	  ssn.flush();
					    	  
					      }
			    		 
			    	 }
			    	 
			
			    	 
			     }
			 
			
			 
			 
			     ssn.getTransaction().commit();
			     ssn.close();
			     System.out.println("<<<<<-----Report COMPLETE----->>>>>>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
       
	}
	
	
	private static Date get_Date_Corrected_New(java.util.Date time) {
		
		java.util.Date ddd=time;
		
		 if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
	      {
	    	   ddd.setDate(31);
	      }
	  	  if(ddd.getMonth()==1)
	      {
	  	        ddd.setDate(28);
	  	        
	      }
	  	  if(ddd.getMonth()==3 || ddd.getMonth()==5 || ddd.getMonth()==8 || ddd.getMonth()==10)
	      {
	  	        ddd.setDate(30);
	  	        
	      }	
	  	  
		return ddd;
	}


	private static ArrayList<java.util.Date> Get_date_from_nav_Report_Final(java.util.Date day,long sc) 
	{
		  java.util.Date date_nav_chk_end=null;
		  
		  ArrayList<java.util.Date> lst = new ArrayList<java.util.Date>();
		  Session ssn= HIbernateSession.getSessionFactory().openSession(); 
		     
		  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*7));
	   	
//		  System.out.println("Scheme_Code-->>"+sc);  
//		  System.out.println("FROM DATE--->>"+day);
//		  System.out.println("TO DATE--->>"+date_nav_chk_end);
		  
		  
		  ProjectionList projList = Projections.projectionList();
		  projList.add(Projections.property("nav_from_date"));
		  
		  Criteria criteria = ssn.createCriteria(controller.nav_report_3_stable.class);
		  criteria.add(Restrictions.eq("scheme_Code",sc)); 
		  criteria.add(Restrictions.between("nav_from_date", date_nav_chk_end, day));
		  criteria.setProjection(Projections.distinct(projList));
		  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_from_date"));
		  
  		  lst =(ArrayList<java.util.Date>) criteria.list();
		  
  		  
//  		  System.out.println("Array SIze--->>"+lst.size());
  		  
//		  ssn.getTransaction().commit();
		  ssn.close();
	 return lst;
	}


	static ArrayList<java.util.Date> get_list_of_dates_portfolio(java.util.Date day, long sc) throws ParseException
	{
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<java.util.Date> lst = new ArrayList<java.util.Date>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
			  
//			  System.out.println("DATE--->>"+day);
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*7));
			 
			  ProjectionList projList = Projections.projectionList();
			  projList.add(Projections.property("inv_date"));
			  
			  Criteria criteria = ssn.createCriteria(controller.Mf_portfolio_Model.class);
			  criteria.add(Restrictions.eq("scheme_code",sc)); 
			  criteria.add(Restrictions.between("inv_date", date_nav_chk_end, day));
			  criteria.setProjection(Projections.distinct(projList));
			  criteria.addOrder(org.hibernate.criterion.Order.desc("inv_date"));
			  
      		  lst =(ArrayList<java.util.Date>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}
	
	
	static java.util.Date get_Date_Corrected(java.util.Date ddd)
	{
		
		// Date corrected as in the Stock db all date are quarter dates only 
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
	  	  
	  	  return ddd;
	}
	
	
	static void Complete_Database_Portfolio()
	{ 
		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		ssn.beginTransaction();	
		
		int db_save=1;
		
		long arr[] = {407, 447, 641, 716, 748, 758, 931, 946, 950, 1131, 1273, 1282, 1283, 1284, 1331,
                1348, 1495, 1608, 1623, 1849, 1858, 1961, 2129, 2133, 2384, 2669, 2681, 2751,
                2782, 2808, 3007, 3065, 3247, 3249, 3281, 3283, 3305, 3317, 3460, 3627, 3642};
		java.util.Date date_corr=null;
		
		long l=0;   /// for id in portfolio Table
		
		Query q111 = ssn.createQuery("select Max(id) from Mf_portfolio_Model");
		 
		l=(long) q111.list().get(0);
		
		for(long sc : arr)
		{
              //     get_Date_Corrected_New
		             
			           ArrayList<Mf_portfolio_Model> portfolio_lst = (ArrayList<Mf_portfolio_Model>) ssn.createQuery("from Mf_portfolio_Model where scheme_code="+sc+" and inv_date='2003-06-30'").list();
		              
			    if(portfolio_lst.size()==0)
			    {
			        String qry_strng="select DISTINCT(inv_date) from  Mf_portfolio_Model where scheme_code="+sc+" and inv_date>='2003-05-20' and inv_date<='2003-06-30'";
				    Query q1 = ssn.createQuery(qry_strng);
				
				        ArrayList<java.util.Date> avg_ret_main_list = (ArrayList<java.util.Date>) q1.list();
				   
//				             System.out.println("SchemeCode-->>"+sc);
				           
				             Mf_portfolio_Model nw_obj = null;
					         for(java.util.Date rr :avg_ret_main_list)
					         {
					        	 
					        	 Criteria criteria_3 = ssn.createCriteria( Mf_portfolio_Model.class );
								 criteria_3.add(Restrictions.eq("inv_date",rr));
								 criteria_3.add(Restrictions.eq("scheme_code",sc));
						    	 
								  ArrayList<Mf_portfolio_Model> portfolios_1 = (ArrayList<Mf_portfolio_Model>) criteria_3.list();
					        	 
					        	 
					//			        	 System.out.println("Dates-->"+rr);
										for(Mf_portfolio_Model old_obj : portfolios_1)
													 {
								//			        	 date_corr =new Date(103,04,31);
											        	 nw_obj = new Mf_portfolio_Model();
											        	 
											        	 nw_obj.setId(new Random().nextLong());
												    	 nw_obj.setId(++l);
												    	 nw_obj.setComp_name(old_obj.getComp_name());
												    	 nw_obj.setFin_code(old_obj.getFin_code());
												    	 nw_obj.setHolding_prcnt(old_obj.getHolding_prcnt());
												    	 nw_obj.setInv_date(new Date(103,05,30));
												    	 nw_obj.setRv_sect_name(old_obj.getRv_sect_name());
												    	 nw_obj.setScheme_code(old_obj.getScheme_code());
												    	 nw_obj.setClassification(old_obj.getClassification()); 	 
												    	 
												    	 
												    	 ssn.save(nw_obj);
												    	 db_save++;
												    	 System.out.println("New Record Added in Mf_Portfolio Table");
								//				    	 ssn.getTransaction().commit();
												    	 
												    	 if(db_save%50==0)
													      {
													    	  ssn.getTransaction().commit();
													    	  ssn.beginTransaction();
													    	  ssn.clear();
													    	  ssn.flush();
													    	 
													      }
												    	 
												    	 
												    	 
													 }	 
					        	 
					        	 
					         }
			    }
			
		}
		
		
		ssn.getTransaction().commit();
 		ssn.close(); 
	}
	

}
