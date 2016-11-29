import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Avg_ret_Model;
import controller.Qtr_Avg;
import controller.Report_6_Model;
import controller.Report_6_pk;
import controller.nav_report_3_stable;

import sessionFactory.HIbernateSession;


public class Report_6_main {

	
	
	
	public static void main(String[] args) 
	{
	
		    Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    int x=-2;
		    int last_4_qtr=0,last_8_qtr=0,last_12_qtr=0,last_16_qtr=0,last_20_qtr=0;
		    String Fund_Type;
		    
		    
		    ArrayList<nav_report_3_stable>  nav_rep_lst_tmp = null;
		    
		    
			// Type of fund is responsible for selecting appropriate scheme codes  
//	        Fund_Type="EQUITY_ELSS"; // This field is manditory //
//		    Fund_Type="EQUITY_SML"; // This field is manditory //
//		    Fund_Type="EQUITY_LARGE_CAP_NEW_30.9.2016"; // This field is mandatory // 
//		    Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory 
//  		Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed
	        
		    Fund_Type="EQUITY_ELSS_NEW_30.9.2016";  // has to be passed 
//		    
//	        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//			criteria_1.setProjection( Projections.distinct(Projections.property("comment")));  		
//     		criteria_1.addOrder(Order.asc("end_dt"));
//     		
//	// 		criteria_1.add(Restrictions.eq("comment", cmnt));
//			
//     		ArrayList<String> sortd_commnt_lst = null;
//	 		sortd_commnt_lst = (ArrayList<String>) criteria_1.list();
	 		
		                                        //  If required to done MANUALY for some scheme_Code 
												//		     ArrayList<Long> scheme_code_list_temp = new ArrayList<Long>();
												//		    
												//	         long[] schm_cd_lst = {23,407,447,489,716,748,758,903,905,931,933,942,950,1131,1273,1282,1283,1284,1331,1346,1348,1441,1464,1492,1608,1623,1849,1858,1956,1962,1973,2069,2090,2127,2129,2133,2171,2235,2271,2384,2390,2455,2461,2654,2669,2681,2711,2752,2782,2860,2896,3065,3247,3249,3281,3305,3317,3461,3581,3587,3626,3641,3644,4282,4457,4980,5153,6075,7329,7615,7747,7785,7841,7870,7874,8151,8217,8229,8250,8463,9078,9240,11889,12836,12860,12865,14493,14559,15557,16672,16706,21293,21769,24776,25378,25473,25995,26481,26778,27106,27775,28707,29082,29277,29359,29360,29424,29786,30021,30022,30395,30396,30397,31046,31353,31451,31571,31642,31837,32280,32348,32542,32658,33053,35321};
												//	         
												//	         for(long b : schm_cd_lst)
												//	         {
												//	        	 scheme_code_list_temp.add(b);
												//	         }
												//		    
												//	         String hql_nw=" from avg_return where key.Fund_Type='"+Fund_Type+"' and key.scheme_code IN:list";
//		                                        //           Query q_2 = ssn.createQuery(hql_nw).setParameterList("list", scheme_code_list_temp);
	 		
		    String hql_nw=" from avg_return where key.Fund_Type='"+Fund_Type+"'";
		    
//	 		String hql_nw=" from avg_return where start_dt<='2016-10-20'";	    
//		    String hql_nw=" from avg_return where start_dt='2010-03-31' and scheme_code=407";
		    
	 		
	 		Query q_2 = ssn.createQuery(hql_nw);
	 		
//	 		Criteria criteria_2 = ssn.createCriteria( Avg_ret_Model.class );
//	 		criteria_2.add(Restrictions.le("start_dt",  new Date(115,02,31)));
//	 		criteria_2.addOrder(Order.asc("scheme_code"));
//	 		ArrayList<Avg_ret_Model> avg_ret_lst = (ArrayList<Avg_ret_Model>) criteria_2.list();
	 		
	 		ArrayList<Avg_ret_Model> avg_ret_lst = (ArrayList<Avg_ret_Model>) q_2.list();
	 		
	 		
	 			for(Avg_ret_Model arm :  avg_ret_lst)
	 			{
	 				  Report_6_Model r6m = new Report_6_Model();
	 				  Report_6_pk pk = new Report_6_pk();
	 				  
	 				  pk.setScheme_code(arm.getKey().getScheme_code());
	 				  pk.setFrom_date(arm.getKey().getStart_dt());
	 				  pk.setFund_Type(Fund_Type);
	 				  
	 				  r6m.setKey(pk);
	 				  
	 				  
	 				  
	 				 if(arm.getKey().getStart_dt().getMonth()==0 || arm.getKey().getStart_dt().getMonth()==1 ||arm.getKey().getStart_dt().getMonth()==2 )
		 			 {
		 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
		 				 r6m.setComment("Qtr_1_"+( arm.getKey().getStart_dt().getYear()-100));
		 			 }
		 			 else if(arm.getKey().getStart_dt().getMonth()==3 || arm.getKey().getStart_dt().getMonth()==4 || arm.getKey().getStart_dt().getMonth()==5 )
					 {
		 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
						 r6m.setComment("Qtr_2_"+( arm.getKey().getStart_dt().getYear()-100));
					 }
		 			else if(arm.getKey().getStart_dt().getMonth()==6 || arm.getKey().getStart_dt().getMonth()==7 ||arm.getKey().getStart_dt().getMonth()==8 )
					 {
		 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
						 r6m.setComment("Qtr_3_"+( arm.getKey().getStart_dt().getYear()-100));
					 }
		 			else if(arm.getKey().getStart_dt().getMonth()==9 || arm.getKey().getStart_dt().getMonth()==10 ||arm.getKey().getStart_dt().getMonth()==11 )
					 {
		 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
						 r6m.setComment("Qtr_4_"+( arm.getKey().getStart_dt().getYear()-100));
					 }  				  
	 				  
//	 				  r6m.setComment(arm.getComment());
	 				  
//	 				  x = sortd_commnt_lst.indexOf(arm.getComment());
	 				 
//	 				  if(x!=-1)
//	 				  {
//	 					   if(x!=0)
//	 					   {
//	 						  last_4_qtr  = Quarter_index_calc(x,4);
//	 						  last_8_qtr  = Quarter_index_calc(x,8);
//	 						  last_12_qtr = Quarter_index_calc(x,12);
//	 						  last_16_qtr  = Quarter_index_calc(x,16);
//	 						  last_20_qtr  = Quarter_index_calc(x,20);
	 						  
	 						  Calculate_Save_Actual_Values(r6m,4,arm,ssn,Fund_Type);
	 						  Calculate_Save_Actual_Values(r6m,8,arm,ssn,Fund_Type);
	 						  Calculate_Save_Actual_Values(r6m,12,arm,ssn,Fund_Type);
	 						  Calculate_Save_Actual_Values(r6m,16,arm,ssn,Fund_Type);
	 						  Calculate_Save_Actual_Values(r6m,20,arm,ssn,Fund_Type);
	 						  
	 						 Criteria criteria_11 = ssn.createCriteria( nav_report_3_stable.class );
	 				         criteria_11.add(Restrictions.eq("nav_from_date", r6m.getKey().getFrom_date()));  
	 				         criteria_11.add(Restrictions.eq("scheme_Code",r6m.getKey().getScheme_code()));
	 				         criteria_11.add(Restrictions.eq("comment","12"));
	 				           
	 				         nav_rep_lst_tmp = (ArrayList<nav_report_3_stable>) criteria_11.list();
	 						  
	 				         if(nav_rep_lst_tmp.size() > 0)
	 				           {
	 				        	   r6m.setForward_12_mnth_ret(nav_rep_lst_tmp.get(0).getNav_value());   
	 				           }						  
	 						  
	 						  
	 				              
	 						     ssn.save(r6m);
	 						     					
	 						     
	  		  	        		 ssn.flush();
	  		  	        		 ssn.clear();
	  		  	        		 
	  		  	        	     ssn.getTransaction().commit();
	  		  	        		 ssn.beginTransaction();
//	 						  
//	 					   }
//	 					   
//	 					  
//	 					  
//	 				  }
	 				  
	 				  
	 				  
	 			}
	 		 
 		   
	 		
 		System.out.println("<<<<<<<--------Report Complete---------->>>>>>>>>>>>");
 		
 		
 		
 		
 		

	}


	private static void Calculate_Save_Actual_Values(Report_6_Model r6m,int no_of_quarters, Avg_ret_Model arm,Session ssn,String Fund_Type) 
	{
	    
		int qtrs=0;
		
		double cat_avg_tmp = 0;
   		double actula_val=0.0;
   		double actula_val_1=0.0;
   		
		int tot_return_value=0;
		double tot_nav_val=0l;
		double postv_act_ret_sum=0;
		double negtv_act_ret_sum=0;
		
				
		double last_pos_nav_ret_value_sum=0;
		double last_neg_nav_ret_value_sum=0;
		
		double last_pos_avg_cat_ret_obt=0;
		double last_neg_avg_cat_ret_obt=0;
		
				
		int index=0;
//		int tmp=0;
	
		  
//        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//		criteria_1.setProjection( Projections.distinct(Projections.property("comment")));
//		criteria_1.add(Restrictions.eq("scheme_code", arm.getKey().getScheme_code()));
// 		criteria_1.addOrder(Order.asc("end_dt"));
		
		String hql_p1="select DISTINCT(comment)from avg_return where key.scheme_code="+arm.getKey().getScheme_code()+" and key.Fund_Type='"+Fund_Type+"' order by end_dt";
		
// 		String hql_p1="select DISTINCT(comment) from avg_return where scheme_code="+arm.getKey().getScheme_code()+"order by end_dt,comment";
 		Query q_p1 = ssn.createQuery(hql_p1);
 		
// 		ArrayList<String> comment_list_sch_wise = (ArrayList<String>) criteria_1.list();
 		
 		ArrayList<String> comment_list_sch_wise = (ArrayList<String>) q_p1.list();
 		
 		
 		index = comment_list_sch_wise.indexOf(arm.getComment());
 		
		if(index>0)
		{
			qtrs=index-no_of_quarters;
			
			if(qtrs>=0)
			{
				if (no_of_quarters==4)
				 {
//					 for(int i=(qtrs+1);i<=index;i++)  // for testing Purpose
					   for(int i=qtrs;i<index;i++)  // orininal 
					   {
						     
						        String hql = "from avg_return where"+" key.scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
								Query q = ssn.createQuery(hql);
								q.setParameter("s_cd", r6m.getKey().getScheme_code());
								q.setParameter("cmnt", comment_list_sch_wise.get(i));
						  		
						   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
						   		
						   		
//						   		System.out.println("<<<<<<<<<<<<<<<<---------------->>>>>>>>>>>>>>>>>>>");
//						   	    System.out.println("DAte-->"+a_r_m.get(0).getEnd_dt());
//						   		System.out.println("Nav_Val---->"+a_r_m.get(0).getNav_val());
//						   		System.out.println("Comment-->"+a_r_m.get(0).getComment());
//						   		System.out.println("Scheme_COde-->"+a_r_m.get(0).getKey().getScheme_code());
//						   		System.out.println("St-->"+a_r_m.get(0).getKey().getStart_dt());
						   		
						   		if(a_r_m.size()>0)
						   		{
							   			tot_return_value = tot_return_value + a_r_m.get(0).getReturn_value();
								   		tot_nav_val = tot_nav_val + a_r_m.get(0).getNav_val();
									   	   
									   	 cat_avg_tmp = GET_QTR_AVG_VAL(a_r_m.get(0).getComment(),ssn,Fund_Type);
								   		 actula_val=0.0;
								   		 actula_val_1=0.0;
								   		 
//								   		 System.out.println("Category Average--->>"+cat_avg_tmp);
								   		 
								   		 
								   		if(a_r_m.get(0).getReturn_value() > 0)
								   		{
								   			actula_val = a_r_m.get(0).getNav_val() - cat_avg_tmp;
								   			
								   			postv_act_ret_sum = postv_act_ret_sum + actula_val;
								   			
								   			last_pos_avg_cat_ret_obt = last_pos_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
								   			
								   			last_pos_nav_ret_value_sum = last_pos_nav_ret_value_sum + a_r_m.get(0).getReturn_value(); 
								   			
								   		}
								   		else
								   		{
								   			actula_val_1 = cat_avg_tmp - a_r_m.get(0).getNav_val();
								   			
								   			negtv_act_ret_sum = negtv_act_ret_sum + actula_val_1;
								   			
								   			last_neg_avg_cat_ret_obt = last_neg_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
								   			
								   			last_neg_nav_ret_value_sum = last_neg_nav_ret_value_sum + a_r_m.get(0).getReturn_value();
								   		}	
						   		  
						   		
//								   		System.out.println("Last_neg_nav_ret_value_sum-->"+last_neg_nav_ret_value_sum);
//								   		System.out.println("Last_neg_avg_cat_ret_obt"+last_neg_avg_cat_ret_obt);
//								   		
//								   		System.out.println("Last_pos_nav_ret_value_sum-->"+last_neg_nav_ret_value_sum);
//								   		System.out.println("Last_pos_avg_cat_ret_obt"+last_pos_avg_cat_ret_obt);
//								   		System.out.println("<<<<<<<<<<<<<<<<--------END-------->>>>>>>>>>>>>>>>>>>\n\n\n");
		                          
						   		
						   		}
						   		
					   }
					      
					        
					   

					
					 		
					 		
					       r6m.setLast_4_qtr_val(tot_nav_val);
					       r6m.setLast_4_qtr_ret(tot_return_value);
					       r6m.setLast_4_pos_act_ret_sum(postv_act_ret_sum);
					       r6m.setLast_4_neg_act_ret_sum(negtv_act_ret_sum);
					     
					       r6m.setLast_4_neg_avg_cat_ret_obt(last_neg_avg_cat_ret_obt);
					       r6m.setLast_4_pos_avg_cat_ret_obt(last_pos_avg_cat_ret_obt);
					       
					       r6m.setLast_4_pos_nav_ret_value_sum(last_pos_nav_ret_value_sum);
					       r6m.setLast_4_neg_nav_ret_value_sum(last_neg_nav_ret_value_sum);
					       
					       
//					       System.out.println("Total Val 4 Qtr->"+tot_nav_val);
//					       System.out.println("Total Val->"+tot_nav_val);
					       
					       
					       
//					       ssn.update(r6m);
					 
				 }
				if (no_of_quarters==8)
				 {
					  for(int i=qtrs;i<index;i++)
					   {
						     
						     
						        String hql = "from avg_return where"+" key.scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
								Query q = ssn.createQuery(hql);
								q.setParameter("s_cd", r6m.getKey().getScheme_code());
								q.setParameter("cmnt", comment_list_sch_wise.get(i));
						  		
						   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
						   		
						   		
						   		if(a_r_m.size()>0)
						   		{
						   			tot_return_value = tot_return_value + a_r_m.get(0).getReturn_value();
							   		tot_nav_val = tot_nav_val + a_r_m.get(0).getNav_val();
							   	   
							   	 cat_avg_tmp = GET_QTR_AVG_VAL(a_r_m.get(0).getComment(),ssn,Fund_Type);
						   		 actula_val=0.0;
						   		 actula_val_1=0.0;
						   		 
						   		if(a_r_m.get(0).getReturn_value() > 0)
						   		{
						   			actula_val = a_r_m.get(0).getNav_val() - cat_avg_tmp;
						   			
						   			postv_act_ret_sum = postv_act_ret_sum + actula_val;
						   			
						   			last_pos_avg_cat_ret_obt = last_pos_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_pos_nav_ret_value_sum = last_pos_nav_ret_value_sum + a_r_m.get(0).getReturn_value(); 
						   			
						   		}
						   		else
						   		{
						   			actula_val_1 = cat_avg_tmp - a_r_m.get(0).getNav_val();
						   			
						   			negtv_act_ret_sum = negtv_act_ret_sum + actula_val_1;
						   			
						   			last_neg_avg_cat_ret_obt = last_neg_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_neg_nav_ret_value_sum = last_neg_nav_ret_value_sum + a_r_m.get(0).getReturn_value();
						   		}	
						   		  
						   		
		                          
		                          
		                          
						   		
						   		}
						   		
					   }
					      
					        
						    
					
					 		
					 		
					       r6m.setLast_8_qtr_val(tot_nav_val);
					       r6m.setLast_8_qtr_ret(tot_return_value);
					       r6m.setLast_8_pos_act_ret_sum(postv_act_ret_sum);
					       r6m.setLast_8_neg_act_ret_sum(negtv_act_ret_sum);
					     
					       r6m.setLast_8_neg_avg_cat_ret_obt(last_neg_avg_cat_ret_obt);
					       r6m.setLast_8_pos_avg_cat_ret_obt(last_pos_avg_cat_ret_obt);
					       
					       r6m.setLast_8_pos_nav_ret_value_sum(last_pos_nav_ret_value_sum);
					       r6m.setLast_8_neg_nav_ret_value_sum(last_neg_nav_ret_value_sum);
					     
//					       ssn.update(r6m);
					 
				 }
				 if (no_of_quarters==12)
				 {
					  for(int i=qtrs;i<index;i++)
					   {
						     
						     
						        String hql = "from avg_return where"+" key.scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
								Query q = ssn.createQuery(hql);
								q.setParameter("s_cd", r6m.getKey().getScheme_code());
								q.setParameter("cmnt", comment_list_sch_wise.get(i));
						  		
						   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
						   		
						   		
						   		if(a_r_m.size()>0)
						   		{
						   			tot_return_value = tot_return_value + a_r_m.get(0).getReturn_value();
							   		tot_nav_val = tot_nav_val + a_r_m.get(0).getNav_val();
							   	   
							   	 cat_avg_tmp = GET_QTR_AVG_VAL(a_r_m.get(0).getComment(),ssn,Fund_Type);
						   		 actula_val=0.0;
						   		 actula_val_1=0.0;
						   		 
						   		if(a_r_m.get(0).getReturn_value() > 0)
						   		{
						   			actula_val = a_r_m.get(0).getNav_val() - cat_avg_tmp;
						   			
						   			postv_act_ret_sum = postv_act_ret_sum + actula_val;
						   			
						   			last_pos_avg_cat_ret_obt = last_pos_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_pos_nav_ret_value_sum = last_pos_nav_ret_value_sum + a_r_m.get(0).getReturn_value(); 
						   			
						   		}
						   		else
						   		{
						   			actula_val_1 = cat_avg_tmp - a_r_m.get(0).getNav_val();
						   			
						   			negtv_act_ret_sum = negtv_act_ret_sum + actula_val_1;
						   			
						   			last_neg_avg_cat_ret_obt = last_neg_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_neg_nav_ret_value_sum = last_neg_nav_ret_value_sum + a_r_m.get(0).getReturn_value();
						   		}	
						   		  
						   		
		                          
		                          
		                          
						   		
						   		}
						   		
					   }
					      
					        
						    
					
					 		
					 		
					       r6m.setLast_12_qtr_val(tot_nav_val);
					       r6m.setLast_12_qtr_ret(tot_return_value);
					       r6m.setLast_12_pos_act_ret_sum(postv_act_ret_sum);
					       r6m.setLast_12_neg_act_ret_sum(negtv_act_ret_sum);
					     
					       r6m.setLast_12_neg_avg_cat_ret_obt(last_neg_avg_cat_ret_obt);
					       r6m.setLast_12_pos_avg_cat_ret_obt(last_pos_avg_cat_ret_obt);
					       
					       r6m.setLast_12_pos_nav_ret_value_sum(last_pos_nav_ret_value_sum);
					       r6m.setLast_12_neg_nav_ret_value_sum(last_neg_nav_ret_value_sum);
					       
//					       ssn.update(r6m);
					 
				 }
				 if (no_of_quarters==16)
				 {
					  for(int i=qtrs;i<index;i++)
					   {
						     
						     
						        String hql = "from avg_return where"+" key.scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
								Query q = ssn.createQuery(hql);
								q.setParameter("s_cd", r6m.getKey().getScheme_code());
								q.setParameter("cmnt", comment_list_sch_wise.get(i));
						  		
						   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
						   		
						   		
						   		if(a_r_m.size()>0)
						   		{
						   			tot_return_value = tot_return_value + a_r_m.get(0).getReturn_value();
							   		tot_nav_val = tot_nav_val + a_r_m.get(0).getNav_val();
							   	   
							   	 cat_avg_tmp = GET_QTR_AVG_VAL(a_r_m.get(0).getComment(),ssn,Fund_Type);
						   		 actula_val=0.0;
						   		 actula_val_1=0.0;
						   		 
						   		if(a_r_m.get(0).getReturn_value() > 0)
						   		{
						   			actula_val = a_r_m.get(0).getNav_val() - cat_avg_tmp;
						   			
						   			postv_act_ret_sum = postv_act_ret_sum + actula_val;
						   			
						   			last_pos_avg_cat_ret_obt = last_pos_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_pos_nav_ret_value_sum = last_pos_nav_ret_value_sum + a_r_m.get(0).getReturn_value(); 
						   			
						   		}
						   		else
						   		{
						   			actula_val_1 = cat_avg_tmp - a_r_m.get(0).getNav_val();
						   			
						   			negtv_act_ret_sum = negtv_act_ret_sum + actula_val_1;
						   			
						   			last_neg_avg_cat_ret_obt = last_neg_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_neg_nav_ret_value_sum = last_neg_nav_ret_value_sum + a_r_m.get(0).getReturn_value();
						   		}	
						   		  
						   		
		                          
		                          
		                          
						   		
						   		}
						   		
					   }
					      
					        
						    
					
					 		
					 		
					       r6m.setLast_16_qtr_val(tot_nav_val);
					       r6m.setLast_16_qtr_ret(tot_return_value);
					       r6m.setLast_16_pos_act_ret_sum(postv_act_ret_sum);
					       r6m.setLast_16_neg_act_ret_sum(negtv_act_ret_sum);
					     
					       r6m.setLast_16_neg_avg_cat_ret_obt(last_neg_avg_cat_ret_obt);
					       r6m.setLast_16_pos_avg_cat_ret_obt(last_pos_avg_cat_ret_obt);
					       
					       r6m.setLast_16_pos_nav_ret_value_sum(last_pos_nav_ret_value_sum);
					       r6m.setLast_16_neg_nav_ret_value_sum(last_neg_nav_ret_value_sum);
					     
//					       ssn.update(r6m);
					 
				 }
				 if (no_of_quarters==20)
				 { 
					   
					  for(int i=qtrs;i<index;i++)
					   {
						     
						     
						        String hql = "from avg_return where"+" key.scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
								Query q = ssn.createQuery(hql);
								q.setParameter("s_cd", r6m.getKey().getScheme_code());
								q.setParameter("cmnt", comment_list_sch_wise.get(i));
						  		
						   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
						   		
						   		
						   		if(a_r_m.size()>0)
						   		{
						   			tot_return_value = tot_return_value + a_r_m.get(0).getReturn_value();
							   		tot_nav_val = tot_nav_val + a_r_m.get(0).getNav_val();
							   	   
							   	 cat_avg_tmp = GET_QTR_AVG_VAL(a_r_m.get(0).getComment(),ssn,Fund_Type);
						   		 actula_val=0.0;
						   		 actula_val_1=0.0;
						   		 
						   		if(a_r_m.get(0).getReturn_value() > 0)
						   		{
						   			actula_val = a_r_m.get(0).getNav_val() - cat_avg_tmp;
						   			
						   			postv_act_ret_sum = postv_act_ret_sum + actula_val;
						   			
						   			last_pos_avg_cat_ret_obt = last_pos_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_pos_nav_ret_value_sum = last_pos_nav_ret_value_sum + a_r_m.get(0).getReturn_value(); 
						   			
						   		}
						   		else
						   		{
						   			actula_val_1 = cat_avg_tmp - a_r_m.get(0).getNav_val();
						   			
						   			negtv_act_ret_sum = negtv_act_ret_sum + actula_val_1;
						   			
						   			last_neg_avg_cat_ret_obt = last_neg_avg_cat_ret_obt + a_r_m.get(0).getNav_val();
						   			
						   			last_neg_nav_ret_value_sum = last_neg_nav_ret_value_sum + a_r_m.get(0).getReturn_value();
						   		}	
						   		  
						   		
		                          
		                          
		                          
						   		
						   		}
						   		
					   }
					      
					        
						    
					
					 		
					 		
					       r6m.setLast_20_qtr_val(tot_nav_val);
					       r6m.setLast_20_qtr_ret(tot_return_value);
					       r6m.setLast_20_pos_act_ret_sum(postv_act_ret_sum);
					       r6m.setLast_20_neg_act_ret_sum(negtv_act_ret_sum);
					     
					       r6m.setLast_20_neg_avg_cat_ret_obt(last_neg_avg_cat_ret_obt);
					       r6m.setLast_20_pos_avg_cat_ret_obt(last_pos_avg_cat_ret_obt);
					       
					       r6m.setLast_20_pos_nav_ret_value_sum(last_pos_nav_ret_value_sum);
					       r6m.setLast_20_neg_nav_ret_value_sum(last_neg_nav_ret_value_sum);
					      
//					       ssn.update(r6m);
					   
					 
				 }
				 
				
				

				   
				
			}
			
			
		}
		
	
		
		
		
		  
		
		
	}


	private static double GET_QTR_AVG_VAL(String comment, Session ssn,String Fund_Type) 
	{
		
		   Criteria criteria_1 = ssn.createCriteria( Qtr_Avg.class );
		   criteria_1.add(Restrictions.eq("quarter", comment));
		   criteria_1.add(Restrictions.eq("Fund_Type",Fund_Type));
		   
//			criteria_1.setProjection( Projections.distinct(Projections.property("comment")));  		
//	 		criteria_1.addOrder(Order.asc("end_dt"));
		   
//		    String hql = "from Qtr_Avg where quarter="+comment;            
//			Query q = ssn.createQuery(hql);
//			q.setParameter("cmnt", comment);
	  		
	   		ArrayList<Qtr_Avg> a_r_m =  (ArrayList<Qtr_Avg>) criteria_1.list();
		
	   		return a_r_m.get(0).getAverage();	
	}


}
