package debt_Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Benchmark_Hist;
import controller.ExpenceRatio;
import controller.Index_Master;
import controller.Industry_Master;
import controller.Scheme_Detail;
import controller.Scheme_Index;
import controller.Scheme_Paum;
import controller.nav_hist;
import debt_Controller.Credit_rating_sum_groups;
import debt_Controller.Debt_Report_1;
import debt_Controller.Debt_Report_2;
import debt_Controller.Gold_ETF_Rep_2;
import debt_Controller.Indices_ETF_Rep_2;
import debt_Controller.Pk_generic;
import sessionFactory.HIbernateSession;

public class Debt_Report_2_Main {

	public static void main(String[] args) 
	{
		Session ssn=null;
	    double ret_12_mnths=0,ret_36_mnths=0;
	    double ans_1,ans_2=0,ans_3=0,fin_res=0;
	    int db_save=0;
	    
        java.util.Date date_of_report= new Date(116, 4, 31); // date can be changed according to choice
		
		try
		{
			ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		   
		    
		    
		    
		    
		    ArrayList<Scheme_Detail> scheme_code_lst = (ArrayList<Scheme_Detail>) ssn.createQuery("from Scheme_Detail where  RV_Classification like'%ETF%' order by scheme_code").list();
		    
//		    System.out.println("Scheme_COde List-->>"+scheme_code_lst.size());
		    
			    for(Scheme_Detail ob : scheme_code_lst)
			    {			    
//			    	System.out.println("Scheme_Code--->>"+ob.getScheme_code());
			    	
			    	Debt_Report_2 dr2 = new Debt_Report_2();
					Pk_generic key= new Pk_generic();
					    
			    	key.setScheme_code(ob.getScheme_code());
			    	key.setDay(date_of_report);
			    	
			        dr2.setKey(key);
			    	
			    	ret_12_mnths = calculate_return(ob.getScheme_code(),date_of_report ,-12, ssn);
			    	 
//			    	System.out.println("Ret_12_Months-->>"+ret_12_mnths);
			    	
			    	 if(!Double.toString(ret_12_mnths).equals("-99.99"))
			    	 {
			    		dr2.setReturn_12_months(ret_12_mnths);
			    	 }
			    	
			    	ret_36_mnths = calculate_return(ob.getScheme_code(),date_of_report ,-36, ssn); 
			    	 
//			    	System.out.println("Ret_36_Months-->>"+ret_36_mnths);
			    	
			    	 if(!Double.toString(ret_36_mnths).equals("-99.99"))
			    	 {
			    		 ans_1= ((ret_36_mnths/100) +1);
			    		 ans_2= (0.333333333);
			    		 ans_3 = Math.pow(ans_1 ,ans_2);
			    		 fin_res = ( ans_3 -1 )*100;
			    		 
			    		dr2.setReturn_36_months_CAGR(fin_res);
			    	 }
			    				    	
			    	
			    	ArrayList<ExpenceRatio> e_rat = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day=?").setLong(0,ob.getScheme_code()).setDate(1,date_of_report).list();
			    	 
			    	 if(e_rat.size()>0)
			    	 {
			    		 dr2.setEx_ratio(e_rat.get(0).getEx_ratio());
			    		 
//			    		 System.out.println("Ex-Ratio-->>"+e_rat.get(0).getEx_ratio());
                	 }
			  
			    	 ArrayList<Scheme_Paum> sch_aum = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0, ob.getScheme_code()).setDate(1,date_of_report).list(); 
			    	 
			    	 if(sch_aum.size()>0)
			    	 {
			    		 dr2.setAum(sch_aum.get(0).getAvg_aum()/100); // cause it is in lakhs, we need that in crores
//			    		 System.out.println("Scheme-Aum-->>"+sch_aum.get(0).getAvg_aum()/100);
			    		 
                	 }
			    	 
			    	 
			    	 ArrayList<Scheme_Index> scheme_indx_lst = (ArrayList<Scheme_Index>) ssn.createQuery("from Scheme_Index where scheme_code=?").setLong(0,ob.getScheme_code()).list();
			    	 
			     System.out.println("Scheme Index Size--->>>"+scheme_indx_lst.size());
			     System.out.println("Scheme_Code-->"+ob.getScheme_code()+"Index-->>"+scheme_indx_lst.get(0).getIndex_code());	 
			    	 
			    	 if(scheme_indx_lst.size()>0)
			    	 {
			    		 ArrayList<Benchmark_Hist> benchmark_hist = (ArrayList<Benchmark_Hist>) ssn.createQuery("from Benchmark_Hist where Index_Code=? and dte=?").setLong(0,scheme_indx_lst.get(0).getIndex_code()).setDate(1,date_of_report).list();
				    	 
				    	 if(benchmark_hist.size()>0)
				    	 {
				    		 System.out.println("BenchMark Size--->>>"+scheme_indx_lst.size());
				    		 
				    		 if(benchmark_hist.get(0).getRet_1YR()!=0)
				    		 {
				    			 dr2.setBenchmark_return_12_months(benchmark_hist.get(0).getRet_1YR());	 
				    		 }
				    		 
				    		 if(benchmark_hist.get(0).getRet_3YR()!=0)
				    		 {
				    			 dr2.setBenchmark_return_36_months(benchmark_hist.get(0).getRet_3YR());	 
				    		 }
				    		 
				    		 
				    		 
				    	 }
				    	 
				    	 ArrayList<Index_Master> im_lst = (ArrayList<Index_Master>) ssn.createQuery(" from Index_Master where IndexCode=?").setLong(0, scheme_indx_lst.get(0).getIndex_code()).list();
				    	 
				    	 if(im_lst.size()>0)
				    	 {
				    		 dr2.setIndex_Name(im_lst.get(0).getIndexName());
				    	 }
				    	 else
				    	 {
				    		 dr2.setIndex_Name(" ");
				    	 }
				    	 
			    	 }
			    	 
			    	 if(dr2.getBenchmark_return_12_months()!=0 && dr2.getReturn_12_months()!=0)
			    	 {
			    		 dr2.setB_12_ret_12((dr2.getReturn_12_months()-dr2.getBenchmark_return_12_months()));
			    	 }
			    	 
			    	 if(dr2.getBenchmark_return_36_months()!=0 && dr2.getReturn_36_months_CAGR()!=0)
			    	 {
			    		 dr2.setB_36_ret_36((dr2.getReturn_36_months_CAGR()-dr2.getBenchmark_return_36_months()));
			    		 
			    		 
			    		 
			    	 }
			    	 
			    	 
			    	 ssn.save(dr2);
			    	 db_save++;
			    	 
			    	 if(db_save%10==0)
			    	 {
			    		 ssn.getTransaction().commit();
			    		 ssn.beginTransaction();
			    		 db_save=1;
			    	 }
			    	 
			    	 
			    }
			    ssn.getTransaction().commit();
			    
			    ssn.beginTransaction();
			    
			    String sql_gold="from Debt_Report_2 where Index_Name like '%GOLD%'";
			    String sql_not_gold="from Debt_Report_2 where Index_Name not like '%GOLD%'";
			    
			    ArrayList<Debt_Report_2> gld_lst= (ArrayList<Debt_Report_2>) ssn.createQuery(sql_gold).list();
//			   
			    ArrayList<Debt_Report_2> nt_gld_lst= (ArrayList<Debt_Report_2>) ssn.createQuery(sql_not_gold).list();
			    
			    for(Debt_Report_2 ob : gld_lst)
			    {
			    	
			    	if(ob.getReturn_36_months_CAGR()!=0)
			    	{
			    		Gold_ETF_Rep_2 gld = new Gold_ETF_Rep_2();
				    	Pk_generic key = new Pk_generic();
				    	   
				    	   key.setDay(ob.getKey().getDay());
				    	   key.setScheme_code(ob.getKey().getScheme_code());
				    	   gld.setKey(key);
				    	
				    	 gld.setAum(ob.getAum());
//				    	 gld.setBenchmark_return_12_months(ob.getBenchmark_return_12_months());
//				    	 gld.setBenchmark_return_36_months(ob.getBenchmark_return_36_months());
				    	 gld.setEx_ratio(ob.getEx_ratio());
				    	 gld.setReturn_12_months(ob.getReturn_12_months());
				    	 gld.setReturn_36_months_CAGR(ob.getReturn_36_months_CAGR());
				    	 gld.setFinal_Amt( ((0.6*ob.getReturn_36_months_CAGR())+(0.4*ob.getReturn_12_months())));			    	
				         gld.setIndex_Name(ob.getIndex_Name());
				    	 ssn.save(gld);
			    	}
			    	 
			    	 
			    }
			    
			    for(Debt_Report_2 ob : nt_gld_lst)
			    {
			    	if(ob.getReturn_36_months_CAGR()!=0)
			    	{
			    		Indices_ETF_Rep_2 indcs = new Indices_ETF_Rep_2();
				    	Pk_generic key = new Pk_generic();
				    	key.setDay(ob.getKey().getDay());
				    	key.setScheme_code(ob.getKey().getScheme_code());
				    	indcs.setKey(key);
				    	
				    	indcs.setAum(ob.getAum());
				    	indcs.setB_12_ret_12(ob.getB_12_ret_12());
				    	indcs.setB_36_ret_36(ob.getB_36_ret_36());
				    	indcs.setBenchmark_return_12_months(ob.getBenchmark_return_12_months());
				    	indcs.setBenchmark_return_36_months(ob.getBenchmark_return_36_months());
				    	indcs.setEx_ratio(ob.getEx_ratio());
				    	indcs.setIndex_Name(ob.getIndex_Name());
				    	indcs.setReturn_12_months(ob.getReturn_12_months());
				    	indcs.setReturn_36_months_CAGR(ob.getReturn_36_months_CAGR());
				    	indcs.setFinal_Amt( ((0.4*ob.getB_12_ret_12())+(0.6*ob.getB_36_ret_36())) );
				    	
				    	ssn.save(indcs);
			    	}
			    	
			    }
			    
			         ssn.getTransaction().commit();
			         ssn.beginTransaction();
			         ssn.createQuery("delete from Debt_Report_2").executeUpdate();
			   
			         
			         Genrate_Rank_for_Weight(ssn);
			         
			         Generate_start_rating(ssn,"GOLD");
			         
			         Generate_start_rating(ssn,"Indices");
			         
			   
			    ssn.getTransaction().commit();
			   
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
			ssn.close();
			System.out.println("<<<----Report Complete---->>>");
		}
		

	}
	
	
	static double calculate_return(long scheme_code, java.util.Date date_of_report ,int months ,Session ssn) throws ParseException
	{
//		 ArrayList<nav_hist> nav_hst_lst_mn = get_list_of_dates_db(crsg_obj.getKey().getInv_date(),crsg_obj.getKey().getScheme_code());
		 
		 double nav_ret=0;
		
		 Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
		 criteria.add(Restrictions.eq("scheme_code",(int)scheme_code ));
		 criteria.add(Restrictions.eq("nav_date",date_of_report));
		 
		 ArrayList<nav_hist> nav_hst_lst_mn = (ArrayList<nav_hist>) criteria.list();
		 
		 
		 if(nav_hst_lst_mn.size()>0)
		 {
			 java.util.Date ddd=null;
			 
			 Calendar cal = Calendar.getInstance();
	    	 cal.setTime(date_of_report);
	    	 cal.add(Calendar.MONTH,months);
		     ddd = cal.getTime();
	    	 
		     	     
		     ArrayList<nav_hist> nav_hst_lst = get_list_of_dates_db(ddd, scheme_code);
		     
		     if(nav_hst_lst.size()>0)
		     {
		    	   if(months<0)
		    	   {
		    		   nav_ret = (((nav_hst_lst_mn.get(0).getAdjnavrs() - nav_hst_lst.get(0).getAdjnavrs())/nav_hst_lst.get(0).getAdjnavrs())*100);
		    	   }
		    	   else
		    	   {
		    		   nav_ret = ((( nav_hst_lst.get(0).getAdjnavrs() - nav_hst_lst_mn.get(0).getAdjnavrs() )/nav_hst_lst_mn.get(0).getAdjnavrs())*100);
		    	   }
		    	 
		    	 
		    	 
		     }
		     else
		     {
		    	return -99.99; 
		     }
		     
		 }
		 else
		 {
			 return -99.99;
		 }
	     
	     
	     
		return nav_ret;
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
    
	private static void Genrate_Rank_for_Weight(Session ssn) 
	{
		 double retval=99999;
		 double temp_val_hldr=123.00;
		 int rank_hldr=1;
		 int same_rank_flag=0;
		 
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();
	    
		ArrayList<Indices_ETF_Rep_2> quarter_list = (ArrayList<Indices_ETF_Rep_2>) ssn.createQuery("from Indices_ETF_Rep_2 order by Final_Amt desc").list();
	    
		rank_hldr= quarter_list.size()+1;
		
		for(Indices_ETF_Rep_2 arm: quarter_list)
		{
			 retval = Double.compare(temp_val_hldr,arm.getFinal_Amt());
	 		    
		    	if(retval==0)
		    	{
		    	    arm.setR_Final_Amt(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;
		    	    same_rank_flag--;
		    	}
		    	else
		    	{   
		    		rank_hldr=rank_hldr+same_rank_flag;
		    		same_rank_flag=0;
		    		rank_hldr=rank_hldr-1;
		    		
		    		arm.setR_Final_Amt(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;  
		    	}
		    	
		    	
		    	temp_val_hldr=arm.getFinal_Amt();
		}
	    
	    
	    ssn.getTransaction().commit();
	    ssn.beginTransaction();
//	    ssn.close();
		

		  retval=99999;
		  temp_val_hldr=123.00;
		  rank_hldr=1;
		  same_rank_flag=0;
	      
		  ArrayList<Gold_ETF_Rep_2> quarter_list_1 = (ArrayList<Gold_ETF_Rep_2>) ssn.createQuery("from Gold_ETF_Rep_2 order by Final_Amt desc").list();
		    
			rank_hldr= quarter_list_1.size()+1;
			
			for(Gold_ETF_Rep_2 arm: quarter_list_1)
			{
				 retval = Double.compare(temp_val_hldr,arm.getFinal_Amt());
		 		    
			    	if(retval==0)
			    	{
			    	    arm.setR_Final_Amt(rank_hldr);
			    	    ssn.update(arm);
//			    	    db_flag++;
			    	    same_rank_flag--;
			    	}
			    	else
			    	{   
			    		rank_hldr=rank_hldr+same_rank_flag;
			    		same_rank_flag=0;
			    		rank_hldr=rank_hldr-1;
			    		
			    		arm.setR_Final_Amt(rank_hldr);
			    	    ssn.update(arm);
//			    	    db_flag++;  
			    	}
			    	
			    	
			    	temp_val_hldr=arm.getFinal_Amt();
			}
		    
		    
		    ssn.getTransaction().commit();
		    ssn.beginTransaction(); 
	    
	    
	 	
	}
	
	private static void Generate_start_rating(Session ssn, String table_name) 
	{
		
		
		int rec_counter=1;
		int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//        ssn.beginTransaction();
        if(table_name.equals("GOLD") || table_name=="GOLD")
        {
        	   ssn.getTransaction().commit();
    		   ssn.beginTransaction();
    		
	          ArrayList<Gold_ETF_Rep_2> mn_lst_rank_wise = (ArrayList<Gold_ETF_Rep_2>) ssn.createQuery("from Gold_ETF_Rep_2 order by R_Final_Amt desc").list();
	          
	          tmp_size = mn_lst_rank_wise.size();
	          
	          top_grp_1=(int) Math.round(tmp_size*.10);
	          top_grp_2=(int) Math.round(tmp_size*.25);
	          top_grp_3=(int) Math.round(tmp_size*.30);
	          top_grp_4=(int) Math.round(tmp_size*.25);
//	          top_grp_5=(int) Math.round(tmp_size*.10);
	          top_grp_5 = (tmp_size - (top_grp_1+top_grp_2+top_grp_3+top_grp_4));
	          
	          if((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)>tmp_size)
	          {
	          	top_grp_5 = top_grp_5 - ( (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5) - tmp_size );
	          }
	          
	          for(Gold_ETF_Rep_2 ob : mn_lst_rank_wise)
	          {
	          	
	          	 
	          		 
	               if(rec_counter>=1 && rec_counter<=top_grp_1)
	               {
	//              	 System.out.println("5 star");
	  		           	     
	  		           	  if(ob.getAum()<100)
	  		         	 {
	  		           		ob.setStar("Unrated");
	  		         	 }
	  		         	 else
	  		         	 {
	  		         		ob.setStar("5 Star");
	  		         	 }
	               }
	               
	               if(rec_counter>top_grp_1 &&  rec_counter<=(top_grp_1+top_grp_2))
	               {
	              	 if(ob.getAum()<100)
	  	         	 {
	  	           		ob.setStar("Unrated");
	  	         	 }
	  	         	 else
	  	         	 {
	  	         		ob.setStar("4 Star");
	  	         	 }
	//              	 System.out.println("4 star");
	              
	               }
	               if(rec_counter>(top_grp_1+top_grp_2) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3))
	               {
	              	 if(ob.getAum()<100)
	  	         	 {
	  	           		ob.setStar("Unrated");
	  	         	 }
	  	         	 else
	  	         	 {
	  	         		ob.setStar("3 Star");
	  	         	 }
	             	 //            	 System.out.println("3 star");
	              
	               }
	               if(rec_counter>(top_grp_1+top_grp_2+top_grp_3) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4))
	               {
	              	 if(ob.getAum()<100)
	  	         	 {
	  	           		ob.setStar("Unrated");
	  	         	 }
	  	         	 else
	  	         	 {
	  	         		ob.setStar("2 Star");
	  	         	 }
	             	 //            	 System.out.println("2 star");
	              
	               }
	               if(rec_counter>(top_grp_1+top_grp_2+top_grp_3+top_grp_4) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5))
	               {
	              	 if(ob.getAum()<100)
	  	         	 {
	  	           		ob.setStar("Unrated");
	  	         	 }
	  	         	 else
	  	         	 {
	  	         		ob.setStar("1 Star");
	  	         	 }
	             	 //            	 System.out.println("1 star");
	              
	               }
	               
	               ssn.update(ob);
	          	 rec_counter++;
	       
	          }
          
        }
        else
        {
		          ArrayList<Indices_ETF_Rep_2> mn_lst_rank_wise = (ArrayList<Indices_ETF_Rep_2>) ssn.createQuery("from Indices_ETF_Rep_2 order by R_Final_Amt desc").list();   	
		        
		       
		        tmp_size = mn_lst_rank_wise.size();
		        
		        top_grp_1=(int) Math.round(tmp_size*.10);
		        top_grp_2=(int) Math.round(tmp_size*.25);
		        top_grp_3=(int) Math.round(tmp_size*.30);
		        top_grp_4=(int) Math.round(tmp_size*.25);
		        top_grp_5 = (tmp_size - (top_grp_1+top_grp_2+top_grp_3+top_grp_4));
//		        top_grp_5=(int) Math.round(tmp_size*.10);
		        
		        if((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)>tmp_size)
		        {
		        	top_grp_5 = top_grp_5 - ( (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5) - tmp_size );
		        }
		        
		//       System.out.println("Size-->"+tmp_size);
		//        System.out.println("1->"+top_grp_1);
		//        System.out.println("2->"+top_grp_2);
		//        System.out.println("3->"+top_grp_3);
		//        System.out.println("4->"+top_grp_4);
		//        System.out.println("5->"+top_grp_5);
		        
		        for(Indices_ETF_Rep_2 ob : mn_lst_rank_wise)
		        {
		        	
		        	 
		        		 
		             if(rec_counter>=1 && rec_counter<=top_grp_1)
		             {
		//            	 System.out.println("5 star");
				           	     
				           	  if(ob.getAum()<100)
				         	 {
				           		ob.setStar("Unrated");
				         	 }
				         	 else
				         	 {
				         		ob.setStar("5 Star");
				         	 }
		             }
		             
		             if(rec_counter>top_grp_1 &&  rec_counter<=(top_grp_1+top_grp_2))
		             {
		            	 if(ob.getAum()<100)
			         	 {
			           		ob.setStar("Unrated");
			         	 }
			         	 else
			         	 {
			         		ob.setStar("4 Star");
			         	 }
		//            	 System.out.println("4 star");
		            
		             }
		             if(rec_counter>(top_grp_1+top_grp_2) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3))
		             {
		            	 if(ob.getAum()<100)
			         	 {
			           		ob.setStar("Unrated");
			         	 }
			         	 else
			         	 {
			         		ob.setStar("3 Star");
			         	 }
		           	 //            	 System.out.println("3 star");
		            
		             }
		             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4))
		             {
		            	 if(ob.getAum()<100)
			         	 {
			           		ob.setStar("Unrated");
			         	 }
			         	 else
			         	 {
			         		ob.setStar("2 Star");
			         	 }
		           	 //            	 System.out.println("2 star");
		            
		             }
		             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3+top_grp_4) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5))
		             {
		            	 if(ob.getAum()<100)
			         	 {
			           		ob.setStar("Unrated");
			         	 }
			         	 else
			         	 {
			         		ob.setStar("1 Star");
			         	 }
		           	 //            	 System.out.println("1 star");
		            
		             }
		             
		             ssn.update(ob);
		        	 rec_counter++;
		     
		        }
//		ssn.close();
		        
	}
        ssn.getTransaction().commit();
        ssn.beginTransaction();
}
}
