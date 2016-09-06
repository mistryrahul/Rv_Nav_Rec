import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;

import controller.*;



public class nav_report_temp_1_main 
{

	public static void Save_Records_DB(java.util.Date dt , long sch_code , Session ssn )
	{
		
		Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
//	    criteria_1.setProjection( Projections.distinct(Projections.property("nav_from_date")));  		
    	criteria_1.add(Restrictions.eq("scheme_Code", sch_code));
    	criteria_1.add(Restrictions.eq("nav_from_date", dt));
		
    	List<nav_report_3_stable> fin_lst = criteria_1.list();
    	nav_report_temp_1 ob_ts=null;
    	composite_pk ob_ts_pk=null;
    	
    	ob_ts = new nav_report_temp_1();
		ob_ts_pk = new composite_pk();

		ob_ts_pk.setDate_ori(dt);
		ob_ts_pk.setScheme_code(sch_code);
		
		// seting comment in from date
		
		if( dt.getMonth()==2 || dt.getMonth()==1)
		{
			ob_ts.setComent("Qtr_1_"+( dt.getYear()-100));
//			ob_tmp.setComment("Q1_"+( Ob2.getNav_date().getYear()-100));	
		}
		else if(dt.getMonth()==4 || dt.getMonth()==5) 
//			if(Ob2.getNav_date().getMonth()==5 || Ob2.getNav_date().getMonth()==4 || Ob2.getNav_date().getMonth()==6)
		{
//			ob_tmp.setComment("Q2_"+( Ob2.getNav_date().getYear()-100));
			ob_ts.setComent("Qtr_2_"+( dt.getYear()-100));
		}
		else if(dt.getMonth()==8 || dt.getMonth()==7)
//		else if(Ob2.getNav_date().getMonth()==8 || Ob2.getNav_date().getMonth()==7 || Ob2.getNav_date().getMonth()==9)
		{
//			ob_tmp.setComment("Q3_"+( Ob2.getNav_date().getYear()-100));
			ob_ts.setComent("Qtr_3_"+( dt.getYear()-100));
		}
		else if(dt.getMonth()==11 || dt.getMonth()==0)
//		else if(Ob2.getNav_date().getMonth()==11 || Ob2.getNav_date().getMonth()==10 || Ob2.getNav_date().getMonth()==12)
		{
//			ob_tmp.setComment("Q4_"+( Ob2.getNav_date().getYear()-100));
			ob_ts.setComent("Qtr_4_"+( dt.getYear()-100));
		}
		else
		{
		        System.out.println("<<<<<<<<<<<<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>");	
			    System.out.println("Scheme Code-->>"+sch_code);
			    System.out.println("Date-->"+dt);
			    System.out.println("<<<<<<<<<<<<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>");
			    
			    System.exit(0);
		}
		
		
		// ------end----
		
		
		
		
		ob_ts.setKey(ob_ts_pk);
		
    	for(nav_report_3_stable ob : fin_lst)
    	{
    		 
    		if(Integer.parseInt(ob.getComment())==-3 )
    		{
    		   	ob_ts.setRet_mnth_3(ob.getNav_value());
    		}
    		if(Integer.parseInt(ob.getComment())==-6 )
    		{
    		   	ob_ts.setRet_mnth_6(ob.getNav_value());
    		}
    		if(Integer.parseInt(ob.getComment())==9 )
    		{
    		   	ob_ts.setRet_mnth_9_forwd(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-12 )
    		{
    			ob_ts.setRet_mnth_12(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==12 )
    		{
    			ob_ts.setRet_mnth_12_forwd(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-18 )
    		{
    			ob_ts.setRet_mnth_18(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==18 )
    		{
    			ob_ts.setRet_mnth_18_forwd(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-24 )
    		{
    			ob_ts.setRet_mnth_24(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==24 )
    		{
    			ob_ts.setRet_mnth_24_forwd(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-30 )
    		{
    			ob_ts.setRet_mnth_30(ob.getNav_value());  	
    		}
    		else if(Integer.parseInt(ob.getComment())==-36 )
    		{
    			ob_ts.setRet_mnth_36(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-42 )
    		{
    			ob_ts.setRet_mnth_42(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-48 )
    		{
    			ob_ts.setRet_mnth_48(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-54 )
    		{
    			ob_ts.setRet_mnth_54(ob.getNav_value());
    		}
    		else if(Integer.parseInt(ob.getComment())==-60 )
    		{
    			ob_ts.setRet_mnth_60(ob.getNav_value());
    		}
    		
    		
    	}
    	
    	ssn.save(ob_ts);
//    	ssn.getTransaction().commit();
    	
    	
    	
	}
	
	
	
	public static void Get_Dates(long sch_code)
	{
		Session ssn=null;
		ssn= HIbernateSession.getSessionFactory().openSession();
		ssn.beginTransaction();
		
		Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
	    criteria_1.setProjection( Projections.distinct(Projections.property("nav_from_date")));  		
    	criteria_1.add(Restrictions.eq("scheme_Code", sch_code));
		criteria_1.addOrder(Order.asc("nav_from_date"));
	
		List<java.util.Date> dt_lst = criteria_1.list(); 
		
		for(java.util.Date dt : dt_lst)
        {
		    Save_Records_DB(dt,sch_code,ssn);        	 
//        	Query query = ssn.createQuery("from controller.nav_report_3_stable where scheme_code"+sch_code+" and nav_from_date"+dt+" order by scheme_code,id");	
        }
		 
		
		
		
		ssn.getTransaction().commit();
		ssn.close();
	}
	
	
	// for all fund and all date
	public static void main(String...args)
	{
		
//		Generate_rank();
		
		
		Session ssn = null;
		int i=0,db_flag=0;
		long scheme_code_temp=0;
		nav_report_temp_1 tmp_obj=null;
		//String date_inp="31/03/2012";
		
		try
		{
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
//			ssn.beginTransaction();
		
			
//			Query query = ssn.createQuery("from controller.nav_report_3_stable order by scheme_code,id");
//			List<controller.nav_report_3_stable> results = query.list();
//			Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
//			criteria_1.setProjection( Projections.distinct(Projections.property("nav_from_date")));  		
//	  		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
//	  		criteria_1.addOrder(Order.asc("nav_from_date"));
			
			
			List<Long> results = ssn.createCriteria( nav_report_3_stable.class ).setProjection( Projections.distinct(Projections.property("scheme_Code"))).list();
			ssn.close(); // closing session
		    
		    for(long sch_cd : results)
		    {
		    	
		    	
		    	Get_Dates(sch_cd);
		    	
		    }
		    
		    System.out.println("<---COMPLETE MAKING REPORT--->");
		    System.out.println("<----Started Caculating Rank---->");
		    Generate_rank();
		    
		    
//			ssn.getTransaction().commit(); // committing session
		
			 
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



	private static void Generate_rank() 
	{
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		Session ssn = sessionfactry.openSession();
		int rank_tmp=1;
		int db_flag=0;
		double tmp_val=98999;
		int retval=0;
		
		List<String> coment_list = new ArrayList<String>();
		Criteria criteria_1 = ssn.createCriteria( nav_report_temp_1.class );
		ssn.beginTransaction();
		criteria_1.setProjection( Projections.distinct(Projections.property("coment")));  		
 		criteria_1.addOrder(Order.asc("coment"));
		
 		coment_list = criteria_1.list(); 

		int col_val=0;
		String[] col_lst ={"ret_mnth_3","ret_mnth_6","ret_mnth_12","ret_mnth_9_forwd","ret_mnth_12_forwd","ret_mnth_18","ret_mnth_18_forwd","ret_mnth_24","ret_mnth_30","ret_mnth_36","ret_mnth_42","ret_mnth_48","ret_mnth_54","ret_mnth_60"};
		
		for(String cmnt : coment_list)
		{  
			
			
			   for(String colmn : col_lst)
			   {
				   
//				System.out.println("Coming....");  
				String hql = "FROM nav_report_temp_1 WHERE coment='"+cmnt+
				             "'and "+colmn+"!=0 ORDER BY "+colmn+" ASC ";
				
				
				System.out.println(hql);
				Query query = ssn.createQuery(hql);
				ArrayList<nav_report_temp_1> n_r_t = (ArrayList<nav_report_temp_1>) query.list();
				
   		 		rank_tmp=1;
   		 	    tmp_val=98999;
   		 	    
   		 		       for(nav_report_temp_1 t1 : n_r_t)
   		 		       {

   		 		    	 if(colmn.equals("ret_mnth_3") || colmn=="ret_mnth_3")
	      		 		    {
	   	   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_6());  		 		        	   	   		 		        
			   	   		 		
	   	   		 		        if(retval==0)
	   	   		 		        {
	   	   		 		        	 t1.setRet_mnth_3_rank(rank_tmp-1);
	   	   		 		        	 ssn.update(t1);
	   	   		 		             db_flag++;
	   	   		 		        	
	   	   		 		        }
	   	   		 		        else
	   	   		 		        {
	   	   		 		             t1.setRet_mnth_3_rank(rank_tmp);
	   		 		        	     ssn.update(t1);
	   		 		        	     db_flag++;     	
	   	   		 		        }
	   	   		 		        
	   	   		 		        
	   	   		 		        tmp_val=t1.getRet_mnth_3();
			   	   		 	    rank_tmp++;
			   	   		 	    
	      		 		    }
   		 		    	 
	   	   		 		   if(colmn.equals("ret_mnth_6") || colmn=="ret_mnth_6")
	      		 		    {
	   	   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_6());  		 		        	   	   		 		        
			   	   		 		
	   	   		 		        if(retval==0)
	   	   		 		        {
	   	   		 		        	 t1.setRet_mnth_6_rank(rank_tmp-1);
	   	   		 		        	 ssn.update(t1);
	   	   		 		             db_flag++;
	   	   		 		        	
	   	   		 		        }
	   	   		 		        else
	   	   		 		        {
	   	   		 		             t1.setRet_mnth_6_rank(rank_tmp);
	   		 		        	     ssn.update(t1);
	   		 		        	     db_flag++;     	
	   	   		 		        }
	   	   		 		        
	   	   		 		        
	   	   		 		        tmp_val=t1.getRet_mnth_6();
			   	   		 	    rank_tmp++;
			   	   		 	    
	      		 		    }
	   	   		 	if(colmn.equals("ret_mnth_9_forwd") || colmn=="ret_mnth_9_forwd")
  		 		    {
	   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_9_forwd());  		 		        	   	   		 		        
	   	   		 		
	   		 		        if(retval==0)
	   		 		        {
	   		 		        	 t1.setRet_mnth_9_forwd_rank(rank_tmp-1);
	   		 		        	 ssn.update(t1);
	   		 		             db_flag++;
	   		 		        	
	   		 		        }
	   		 		        else
	   		 		        {
	   		 		             t1.setRet_mnth_9_forwd_rank(rank_tmp);
		 		        	     ssn.update(t1);
		 		        	     db_flag++;     	
	   		 		        }
	   		 		        
	   		 		        
	   		 		        tmp_val=t1.getRet_mnth_9_forwd();
	   	   		 	        rank_tmp++;
	   	   		 	    
  		 		    }
   		 		    	    
			   	   		 	if(colmn.equals("ret_mnth_12") || colmn=="ret_mnth_12")
		  		 		    {
			   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_12());  		 		        	   	   		 		        
			   	   		 		
			   		 		        if(retval==0)
			   		 		        {
			   		 		        	 t1.setRet_mnth_12_rank(rank_tmp-1);
			   		 		        	 ssn.update(t1);
			   		 		             db_flag++;
			   		 		        	
			   		 		        }
			   		 		        else
			   		 		        {
			   		 		             t1.setRet_mnth_12_rank(rank_tmp);
				 		        	     ssn.update(t1);
				 		        	     db_flag++;     	
			   		 		        }
			   		 		        
			   		 		        
			   		 		        tmp_val=t1.getRet_mnth_12();
			   	   		 	        rank_tmp++;
			   	   		 	    
		  		 		    }
				   	   		if(colmn.equals("ret_mnth_12_forwd") || colmn=="ret_mnth_12_forwd")
		  		 		    {
			   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_12_forwd());  		 		        	   	   		 		        
			   	   		 		
			   		 		        if(retval==0)
			   		 		        {
			   		 		        	 t1.setRet_mnth_12_forwd_rank(rank_tmp-1);
			   		 		        	 ssn.update(t1);
			   		 		             db_flag++;
			   		 		        	
			   		 		        }
			   		 		        else
			   		 		        {
			   		 		             t1.setRet_mnth_12_forwd_rank(rank_tmp);
				 		        	     ssn.update(t1);
				 		        	     db_flag++;     	
			   		 		        }
			   		 		        
			   		 		        
			   		 		        tmp_val=t1.getRet_mnth_12_forwd();
			   	   		 	        rank_tmp++;
			   	   		 	    
		  		 		    }
				   	   		if(colmn.equals("ret_mnth_18") || colmn=="ret_mnth_18")
					 		    {
			   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_18());  		 		        	   	   		 		        
			   	   		 		
			   		 		        if(retval==0)
			   		 		        {
			   		 		        	 t1.setRet_mnth_18_rank(rank_tmp-1);
			   		 		        	 ssn.update(t1);
			   		 		             db_flag++;
			   		 		        	
			   		 		        }
			   		 		        else
			   		 		        {
			   		 		             t1.setRet_mnth_18_rank(rank_tmp);
				 		        	     ssn.update(t1);
				 		        	     db_flag++;     	
			   		 		        }
			   		 		        
			   		 		        
			   		 		        tmp_val=t1.getRet_mnth_18();
			   	   		 	        rank_tmp++;
			   	   		 	    
					 		    }
					   	   	if(colmn.equals("ret_mnth_18_forwd") || colmn=="ret_mnth_18_forwd")
				 		    {
		   		 		        retval = Double.compare(tmp_val,t1.getRet_mnth_18_forwd());  		 		        	   	   		 		        
		   	   		 		
		   		 		        if(retval==0)
		   		 		        {
		   		 		        	 t1.setRet_mnth_18_forwd_rank(rank_tmp-1);
		   		 		        	 ssn.update(t1);
		   		 		             db_flag++;
		   		 		        	
		   		 		        }
		   		 		        else
		   		 		        {
		   		 		        t1.setRet_mnth_18_forwd_rank(rank_tmp);
			 		        	     ssn.update(t1);
			 		        	     db_flag++;     	
		   		 		        }
		   		 		        
		   		 		        
		   		 		        tmp_val=t1.getRet_mnth_18_forwd();
		   	   		 	        rank_tmp++;
		   	   		 	    
				 		    }
					   	   	if(colmn.equals("ret_mnth_24") || colmn=="ret_mnth_24")
				 		    {
					 		        retval = Double.compare(tmp_val,t1.getRet_mnth_24());  		 		        	   	   		 		        
				  		 		
					 		        if(retval==0)
					 		        {
					 		        	 t1.setRet_mnth_24_rank(rank_tmp-1);
					 		        	 ssn.update(t1);
					 		             db_flag++;
					 		        	
					 		        }
					 		        else
					 		        {
					 		             t1.setRet_mnth_24_rank(rank_tmp);
						        	     ssn.update(t1);
						        	     db_flag++;     	
					 		        }
					 		        
					 		        
					 		        tmp_val=t1.getRet_mnth_24();
				  		 	        rank_tmp++;
				  		 	    
				 		    }
					   	 if(colmn.equals("ret_mnth_30") || colmn=="ret_mnth_30")
						    {
					 		        retval = Double.compare(tmp_val,t1.getRet_mnth_30());  		 		        	   	   		 		        
						 		
					 		        if(retval==0)
					 		        {
					 		        	 t1.setRet_mnth_30_rank(rank_tmp-1);
					 		        	 ssn.update(t1);
					 		             db_flag++;
					 		        	
					 		        }
					 		        else
					 		        {
					 		             t1.setRet_mnth_30_rank(rank_tmp);
						        	     ssn.update(t1);
						        	     db_flag++;     	
					 		        }
					 		        
					 		        
					 		        tmp_val=t1.getRet_mnth_30();
						 	        rank_tmp++;
						 	    
						    }
					   	if(colmn.equals("ret_mnth_36") || colmn=="ret_mnth_36")
					    {
				 		        retval = Double.compare(tmp_val,t1.getRet_mnth_36());  		 		        	   	   		 		        
					 		
				 		        if(retval==0)
				 		        {
				 		        	 t1.setRet_mnth_36_rank(rank_tmp-1);
				 		        	 ssn.update(t1);
				 		             db_flag++;
				 		        	
				 		        }
				 		        else
				 		        {
				 		             t1.setRet_mnth_36_rank(rank_tmp);
					        	     ssn.update(t1);
					        	     db_flag++;     	
				 		        }
				 		        
				 		        
				 		        tmp_val=t1.getRet_mnth_36();
					 	        rank_tmp++;
					 	    
					    }
					   	if(colmn.equals("ret_mnth_42") || colmn=="ret_mnth_42")
					    {
				 		        retval = Double.compare(tmp_val,t1.getRet_mnth_42());  		 		        	   	   		 		        
					 		
				 		        if(retval==0)
				 		        {
				 		        	 t1.setRet_mnth_42_rank(rank_tmp-1);
				 		        	 ssn.update(t1);
				 		             db_flag++;
				 		        	
				 		        }
				 		        else
				 		        {
				 		             t1.setRet_mnth_42_rank(rank_tmp);
					        	     ssn.update(t1);
					        	     db_flag++;     	
				 		        }
				 		        
				 		        
				 		        tmp_val=t1.getRet_mnth_42();
					 	        rank_tmp++;
					 	    
					    }
					   	if(colmn.equals("ret_mnth_48") || colmn=="ret_mnth_48")
					    {
				 		        retval = Double.compare(tmp_val,t1.getRet_mnth_48());  		 		        	   	   		 		        
					 		
				 		        if(retval==0)
				 		        {
				 		        	 t1.setRet_mnth_48_rank(rank_tmp-1);
				 		        	 ssn.update(t1);
				 		             db_flag++;
				 		        	
				 		        }
				 		        else
				 		        {
				 		             t1.setRet_mnth_48_rank(rank_tmp);
					        	     ssn.update(t1);
					        	     db_flag++;     	
				 		        }
				 		        
				 		        
				 		        tmp_val=t1.getRet_mnth_48();
					 	        rank_tmp++;
					 	    
					    }
					   	if(colmn.equals("ret_mnth_54") || colmn=="ret_mnth_54")
					    {
				 		        retval = Double.compare(tmp_val,t1.getRet_mnth_54());  		 		        	   	   		 		        
					 		
				 		        if(retval==0)
				 		        {
				 		        	 t1.setRet_mnth_54_rank(rank_tmp-1);
				 		        	 ssn.update(t1);
				 		             db_flag++;
				 		        	
				 		        }
				 		        else
				 		        {
				 		             t1.setRet_mnth_54_rank(rank_tmp);
					        	     ssn.update(t1);
					        	     db_flag++;     	
				 		        }
				 		        
				 		        
				 		        tmp_val=t1.getRet_mnth_54();
					 	        rank_tmp++;
					 	    
					    }
					   	if(colmn.equals("ret_mnth_60") || colmn=="ret_mnth_60")
					    {
				 		        retval = Double.compare(tmp_val,t1.getRet_mnth_60());  		 		        	   	   		 		        
					 		
				 		        if(retval==0)
				 		        {
				 		        	 t1.setRet_mnth_60_rank(rank_tmp-1);
				 		        	 ssn.update(t1);
				 		             db_flag++;
				 		        	
				 		        }
				 		        else
				 		        {
				 		             t1.setRet_mnth_60_rank(rank_tmp);
					        	     ssn.update(t1);
					        	     db_flag++;     	
				 		        }
				 		        
				 		        
				 		        tmp_val=t1.getRet_mnth_60();
					 	        rank_tmp++;
					 	    
					    }
   		 		    	    
	   	   		 		    
	   	   		 		   
	   	   		 		   
   

	      		   		 		
		   	   		 	 if(db_flag%100==0)
		   		 		    {
		   		 		    	
		   		 		        ssn.flush();
						        ssn.clear();
						        ssn.getTransaction().commit();
		   		 		    	ssn.beginTransaction();
		   		 		        db_flag=0;
		   		 		    }	
   		 		       } //end of for
   		 		   
   		 		       
   		 		   

//   		 		   
//   		 		   
//   		 		   

//   		 		    
//   		 		
			   }
		}
		
		         ssn.getTransaction().commit();
		         ssn.close();
		  System.out.println("---Rank Generation COmplete----");
	}
	
}
