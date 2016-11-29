import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Avg_ret_Model;
import controller.Calma_Ratio_Model;
import controller.ExpenceRatio;
import controller.Mf_portfolio_New;
import controller.Report_10_Model;
import controller.Report_5_Model;
import controller.Report_6_Model;
import controller.Report_6_pk;
import controller.Report_8_Model;
import controller.Report_Merged_5_6_8_Model;
import controller.Scheme_Aum;
import controller.nav_hist;
import controller.nav_report_temp_1;

import sessionFactory.HIbernateSession;


public class Merged_Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException 
	{
	     String Fund_Type;
		 int i=1;
		 Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		 ssn.beginTransaction();	
		
	     // Type of fund is responsible for selecting appropriate scheme codes  
//         Fund_Type="EQUITY_ELSS"; // This field is mandatory
//		   Fund_Type="EQUITY_SML"; // This field is mandatory
//		   Fund_Type="EQUITY_LARGE_CAP_NEW_30.9.2016"; // This field is mandatory
//		   Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory
//		   Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed
		   Fund_Type="EQUITY_ELSS_NEW_30.9.2016";
		  
		  
		                                                //         // If required to done MANUALY for some scheme_Code  
														//		  ArrayList<Long> scheme_code_list_temp = new ArrayList<Long>();
														//		    
														//	         long[] schm_cd_lst = {23,407,447,489,716,748,758,903,905,931,933,942,950,1131,1273,1282,1283,1284,1331,1346,1348,1441,1464,1492,1608,1623,1849,1858,1956,1962,1973,2069,2090,2127,2129,2133,2171,2235,2271,2384,2390,2455,2461,2654,2669,2681,2711,2752,2782,2860,2896,3065,3247,3249,3281,3305,3317,3461,3581,3587,3626,3641,3644,4282,4457,4980,5153,6075,7329,7615,7747,7785,7841,7870,7874,8151,8217,8229,8250,8463,9078,9240,11889,12836,12860,12865,14493,14559,15557,16672,16706,21293,21769,24776,25378,25473,25995,26481,26778,27106,27775,28707,29082,29277,29359,29360,29424,29786,30021,30022,30395,30396,30397,31046,31353,31451,31571,31642,31837,32280,32348,32542,32658,33053,35321};
														//	         
														//	         for(long b : schm_cd_lst)
														//	         {
														//	        	 scheme_code_list_temp.add(b);
														//	         }
														//		 
														//		 String hql_mn="from avg_return where key.Fund_Type='"+Fund_Type+"' and key.scheme_code IN :list order by scheme_code";
		 												//        Query q1 = ssn.createQuery(hql_mn).setParameterList("list", scheme_code_list_temp); 
		 
         String hql_mn="from avg_return where key.Fund_Type='"+Fund_Type+"' order by scheme_code";
//		 String hql_mn="from avg_return where start_dt>='2003-06-30' and start_dt<='2015-03-31' order by scheme_code";
		 Query q1 = ssn.createQuery(hql_mn);
		 
//		 Query q1 = ssn.createQuery(hql_mn)
				 
		 ArrayList<Avg_ret_Model> avg_ret_main_list = (ArrayList<Avg_ret_Model>) q1.list();
		 
		 Report_Merged_5_6_8_Model rm568 = null;
		 controller.Report_6_pk pk=null;
		    
			   for(Avg_ret_Model arm : avg_ret_main_list)
			   {
				     rm568 = new Report_Merged_5_6_8_Model();
				     pk= new Report_6_pk();
				     
				     pk.setFrom_date(arm.getKey().getStart_dt());
				     pk.setScheme_code(arm.getKey().getScheme_code());
				     pk.setFund_Type(Fund_Type);
				     
				     rm568.setKey(pk);
				     				     				     
//				     Criteria criteria_2 = ssn.createCriteria( nav_report_temp_1.class );
//					 criteria_2.add(Restrictions.eq("date_ori",arm.getKey().getStart_dt()));
//					 criteria_2.add(Restrictions.eq("scheme_code",arm.getKey().getScheme_code()));
				     
				     Query q33 =  ssn.createQuery("from nav_report_temp_1 where key.scheme_code=? and key.date_ori=? and key.Fund_Type='"+Fund_Type+"'").setLong(0, arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt());
					 
					 
					 ArrayList<nav_report_temp_1> nav_rem_tmp_lst = (ArrayList<nav_report_temp_1>) q33.list();
					 
					  if(nav_rem_tmp_lst.size()>0)
					  {
						   rm568.setForwar_36_mnths(nav_rem_tmp_lst.get(0).getRet_mnth_36_forwd());
						   rm568.setForwar_12_mnths(nav_rem_tmp_lst.get(0).getRet_mnth_12_forwd());
						   
						   rm568.setForwar_18_mnths(nav_rem_tmp_lst.get(0).getRet_mnth_18_forwd());
						   
						   rm568.setForwar_9_mnths(nav_rem_tmp_lst.get(0).getRet_mnth_9_forwd());
						   
						   rm568.setBackward_3(nav_rem_tmp_lst.get(0).getRet_mnth_3());
						   rm568.setBackward_6(nav_rem_tmp_lst.get(0).getRet_mnth_6());
						   
						   rm568.setBackward_12(nav_rem_tmp_lst.get(0).getRet_mnth_12());
						   rm568.setBackward_18(nav_rem_tmp_lst.get(0).getRet_mnth_18());
						   rm568.setBackward_24(nav_rem_tmp_lst.get(0).getRet_mnth_24());
						   rm568.setBackward_30(nav_rem_tmp_lst.get(0).getRet_mnth_30());
						   rm568.setBackward_36(nav_rem_tmp_lst.get(0).getRet_mnth_36());
						   rm568.setBackward_42(nav_rem_tmp_lst.get(0).getRet_mnth_42());
						   rm568.setBackward_48(nav_rem_tmp_lst.get(0).getRet_mnth_48());
						   rm568.setBackward_54(nav_rem_tmp_lst.get(0).getRet_mnth_54());
						   rm568.setBackward_60(nav_rem_tmp_lst.get(0).getRet_mnth_60());
						   
					  }
					  
//					  Criteria criteria_3 = ssn.createCriteria( Report_5_Model.class );
//					  criteria_3.add(Restrictions.eq("day",arm.getKey().getStart_dt()));
//					  criteria_3.add(Restrictions.eq("scheme_code",arm.getKey().getScheme_code()));
					     
					  Query q34 =  ssn.createQuery("from Report_5_Model where scheme_code=? and day=? and Fund_Type='"+Fund_Type+"'").setLong(0, arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt()); 
					  
					   ArrayList<Report_5_Model> report_5_lst = (ArrayList<Report_5_Model>) q34.list();
						  
					      if(report_5_lst.size()>0)
					      {
					    	  rm568.setYear_1(report_5_lst.get(0).getYear_1());
					    	  rm568.setYear_1_1(report_5_lst.get(0).getYear_1_1());
					    	  rm568.setYear_1_2(report_5_lst.get(0).getYear_1_2());
					    	  rm568.setYear_1_3(report_5_lst.get(0).getYear_1_3());
					    	  rm568.setYear_1_4(report_5_lst.get(0).getYear_1_4());
					      }
				    
//					   Criteria criteria_4 = ssn.createCriteria( Report_6_Model.class );
//					   criteria_4.add(Restrictions.eq("from_date",arm.getKey().getStart_dt()));
//					   criteria_4.add(Restrictions.eq("scheme_code",arm.getKey().getScheme_code()));
						
					      Query q35 =  ssn.createQuery("from Report_6_Model where key.scheme_code=? and key.from_date=? and key.Fund_Type='"+Fund_Type+"'").setLong(0, arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt());    
					      
					   ArrayList<Report_6_Model> report_6_lst = (ArrayList<Report_6_Model>) q35.list();  
					   
					   if(report_6_lst.size()>0)
					   {
						    rm568.setLast_4_neg_avg_cat_ret_otb(report_6_lst.get(0).getLast_4_neg_avg_cat_ret_obt());
						    rm568.setLast_4_pos_avg_cat_ret_otb(report_6_lst.get(0).getLast_4_pos_avg_cat_ret_obt());
						    
						    rm568.setLast_8_neg_avg_cat_ret_otb(report_6_lst.get(0).getLast_8_neg_avg_cat_ret_obt());
						    rm568.setLast_8_pos_avg_cat_ret_otb(report_6_lst.get(0).getLast_8_pos_avg_cat_ret_obt());
						    
						    rm568.setLast_12_neg_avg_cat_ret_otb(report_6_lst.get(0).getLast_12_neg_avg_cat_ret_obt());
						    rm568.setLast_12_pos_avg_cat_ret_otb(report_6_lst.get(0).getLast_12_pos_avg_cat_ret_obt());
						    
						    rm568.setLast_16_neg_avg_cat_ret_otb(report_6_lst.get(0).getLast_16_neg_avg_cat_ret_obt());
						    rm568.setLast_16_pos_avg_cat_ret_otb(report_6_lst.get(0).getLast_16_pos_avg_cat_ret_obt());
						    
						    rm568.setLast_20_neg_avg_cat_ret_otb(report_6_lst.get(0).getLast_20_neg_avg_cat_ret_obt());
						    rm568.setLast_20_pos_avg_cat_ret_otb(report_6_lst.get(0).getLast_20_pos_avg_cat_ret_obt());
						    
						    //new added 
						    
						    rm568.setLast_4_neg_act_ret_sum(report_6_lst.get(0).getLast_4_neg_act_ret_sum());
						    rm568.setLast_4_pos_act_ret_sum(report_6_lst.get(0).getLast_4_pos_act_ret_sum());
						    
						    rm568.setLast_8_neg_act_ret_sum(report_6_lst.get(0).getLast_8_neg_act_ret_sum());
						    rm568.setLast_8_pos_act_ret_sum(report_6_lst.get(0).getLast_8_pos_act_ret_sum());
						    
						    rm568.setLast_12_neg_act_ret_sum(report_6_lst.get(0).getLast_12_neg_act_ret_sum());
						    rm568.setLast_12_pos_act_ret_sum(report_6_lst.get(0).getLast_12_pos_act_ret_sum());
						    
						    rm568.setLast_16_neg_act_ret_sum(report_6_lst.get(0).getLast_16_neg_act_ret_sum());
						    rm568.setLast_16_pos_act_ret_sum(report_6_lst.get(0).getLast_16_pos_act_ret_sum());
						    
						    rm568.setLast_20_neg_act_ret_sum(report_6_lst.get(0).getLast_20_neg_act_ret_sum());
						    rm568.setLast_20_pos_act_ret_sum(report_6_lst.get(0).getLast_20_pos_act_ret_sum());
						    
						   
					   }
					   
					   
//					   Query q3 =  ssn.createQuery("from Report_8_Model where scheme_code=? and from_date=? and Fund_Type='"+Fund_Type+"'").setLong(0, arm.getKey().getScheme_code()).setDate(1, get_Date_Corrected(arm.getKey().getStart_dt()));
//					   
//					   ArrayList<Report_8_Model> r8m_lst = (ArrayList<Report_8_Model>) q3.list();
//					    
//					   
//					   if(r8m_lst.size()>0)
//					   {
//						   for(Report_8_Model r8m :r8m_lst)
//					          {
//					        	  rm568.setCri(r8m.getGen_rank());
//					        	  rm568.setNo_of_stock(r8m.getNo_of_stock());
//					          }
//					   }
					          
					   
					   java.util.Date dd_qtr=arm.getKey().getStart_dt();
					   
			 			 if(dd_qtr.getMonth()==0 || dd_qtr.getMonth()==1 ||dd_qtr.getMonth()==2 )
			 			 {
			 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
			 				 rm568.setQuarter("Qtr_1_"+( dd_qtr.getYear()-100));
			 			 }
			 			 else if(dd_qtr.getMonth()==3 || dd_qtr.getMonth()==4 ||dd_qtr.getMonth()==5 )
						 {
			 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
							 rm568.setQuarter("Qtr_2_"+( dd_qtr.getYear()-100));
						 }
			 			else if(dd_qtr.getMonth()==6 || dd_qtr.getMonth()==7 ||dd_qtr.getMonth()==8 )
						 {
			 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
							 rm568.setQuarter("Qtr_3_"+( dd_qtr.getYear()-100));
						 }
			 			else if(dd_qtr.getMonth()==9 || dd_qtr.getMonth()==10 ||dd_qtr.getMonth()==11 )
						 {
			 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
							 rm568.setQuarter("Qtr_4_"+( dd_qtr.getYear()-100));
						 }
					   
			 		//Calmar Ratio
			 			  
//                           Query get_act_dt = ssn.createQuery("select distinct(from_date) from Calma_Ratio_Model where ");  
			 			 
			 			  ArrayList<java.util.Date> tmp_ddt_lst = get_list_of_dates_Calmar(get_Date_Corrected(arm.getKey().getStart_dt()) ,arm.getKey().getScheme_code());
			 			 
						   if(tmp_ddt_lst.size()>0)
						   {
							   Query q1_calmar =  ssn.createQuery("from Calma_Ratio_Model where key.scheme_code=? and key.from_date=? and key.Fund_Type='"+Fund_Type+"'").setLong(0, arm.getKey().getScheme_code()).setDate(1,tmp_ddt_lst.get(0));
							   
							   ArrayList<Calma_Ratio_Model> crm_lst = (ArrayList<Calma_Ratio_Model>) q1_calmar.list();
							    
							   
							   if(crm_lst.size()>0)
							   {
								   for(Calma_Ratio_Model crm :crm_lst)
							          {
									      rm568.setMax_Drawdown_year_1(-crm.getMax_Drawdown_year_1());
									      rm568.setMax_Drawdown_year_2(-crm.getMax_Drawdown_year_2());
									      rm568.setMax_Drawdown_year_3(-crm.getMax_Drawdown_year_3());
									      rm568.setMax_Drawdown_year_4(-crm.getMax_Drawdown_year_4());
									      rm568.setMax_Drawdown_year_5(-crm.getMax_Drawdown_year_5());
									      
//							        	  rm568.setCri(r8m.getGen_rank());
//							        	  rm568.setNo_of_stock(r8m.getNo_of_stock());
							          }
							   }
						   }
			 			 
			 			   
						   
						  ArrayList<nav_hist> dt_lst_r10 = get_list_of_dates_db_nw( arm.getKey().getStart_dt(), (int)arm.getKey().getScheme_code());
						   
						  ArrayList<Report_10_Model> r_10_lst = (ArrayList<Report_10_Model>) ssn.createQuery("from Report_10_Model where key.scheme_code=? and key.from_date=? and key.Fund_Type='"+Fund_Type+"'").setLong(0,dt_lst_r10.get(0).getScheme_code()).setDate(1, dt_lst_r10.get(0).getNav_date()).list();
						   
						   
						   if(r_10_lst.size()>0)
						   {
							   
							   rm568.setAvg_return_50_minus_200(r_10_lst.get(0).getAvg_return_50_minus_200());
							   
							   rm568.setLast_200_day_return(r_10_lst.get(0).getLast_200_day_return());
							   
						   }
						    
			
						   
	// Newly added
						    
						   
						
				    ArrayList<ExpenceRatio> ex_r_obj = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day=?").setLong(0,arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt()).list();
				    
				    if(ex_r_obj.size()>0)
				    {
				    	rm568.setEx_ratio(ex_r_obj.get(0).getEx_ratio());
				    }
						   
				      
//				    ArrayList<Scheme_Aum> sc_aum_obj = (ArrayList<Scheme_Aum>) ssn.createQuery("from Scheme_Aum where scheme_code=? and day=?").setLong(0,arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt()).list(); 
//						   
//				    if(sc_aum_obj.size()>0)
//				    {
//				    	rm568.setSc_aum(sc_aum_obj.get(0).getExfof());
//				    }
					
				    
				    
//				    *******
				    //DONE
				    // need to DONE (if any data does not exist, check with its PRIMARY_FD_CODE in the portfolio table)
				    // FETCHING AUM FROM MF_PORTFOLIO
				    
				    ArrayList<Mf_portfolio_New> mf_pf_m = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code=? and invdate=?").setLong(0,arm.getKey().getScheme_code()).setDate(1,arm.getKey().getStart_dt()).setMaxResults(1).list();
				    
				    if(mf_pf_m.size()>0)
				    {
				    	rm568.setSc_aum(mf_pf_m.get(0).getAum()/100);
				    }
				    else
				    {
				    	ArrayList<Long> primary_fd_code = (ArrayList<Long>) ssn.createQuery("select PRIMARY_FD_CODE from Scheme_Detail where scheme_code='"+arm.getKey().getScheme_code()+"'").list();
				    	if(primary_fd_code.size()>0)
				    	{
				    		mf_pf_m = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code=? and invdate=?").setLong(0,primary_fd_code.get(0)).setDate(1,arm.getKey().getStart_dt()).setMaxResults(1).list();
				    		
				    		if(mf_pf_m.size()>0)
						    {
						    	rm568.setSc_aum(mf_pf_m.get(0).getAum()/100);
						    }
				    	}
				    }
				    
				    
				    
//				       rm568.setFund_Type(Fund_Type);
					   ssn.save(rm568);
					   i++;
					   
					   
						if(i%50==0)
						{
							  ssn.getTransaction().commit(); 
							  ssn.beginTransaction();
							  ssn.flush();
						      ssn.clear();
						    
						      i=1;
						}			
					  
					  
					 
				   
			   
			    
			   
		       }
			   ssn.getTransaction().commit();
			   ssn.close();
			   
			   System.out.println("<<<<<---Complete--->>>>>>");
		        
		 
		    
		 

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

	static ArrayList<java.util.Date> get_list_of_dates_Calmar(java.util.Date day, long sc) throws ParseException
	{
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<java.util.Date> lst = null;
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
			  
//			  System.out.println("DATE--->>"+day);
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*7));
			 
			  
			  Query get_act_dt = ssn.createQuery("select distinct(key.from_date) from Calma_Ratio_Model where from_date>=? and from_date<=? and scheme_code=? order by from_date desc");
			  
			  get_act_dt.setDate(0, date_nav_chk_end);
			  get_act_dt.setDate(1, day);
			  get_act_dt.setLong(2, sc);
			  
			  
			  
//			  ProjectionList projList = Projections.projectionList();
//			  projList.add(Projections.property("inv_date"));
//			  
//			  Criteria criteria = ssn.createCriteria(controller.Mf_portfolio_Model.class);
//			  criteria.add(Restrictions.eq("scheme_code",sc)); 
//			  criteria.add(Restrictions.between("inv_date", date_nav_chk_end, day));
//			  criteria.setProjection(Projections.distinct(projList));
//			  criteria.addOrder(org.hibernate.criterion.Order.desc("inv_date"));
			  
      		  lst =(ArrayList<java.util.Date>) get_act_dt.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}		
	
	
	static ArrayList<nav_hist> get_list_of_dates_db_nw(java.util.Date day, int scheme_code) throws ParseException
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
			  criteria.add(Restrictions.eq("scheme_code",scheme_code)); 
			  criteria.add(Restrictions.between("nav_date", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("nav_date"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}
	
}
