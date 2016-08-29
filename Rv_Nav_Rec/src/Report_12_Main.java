import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;

import controller.Avg_ret_Model;
import controller.ExpenceRatio;
import controller.Report_12_Model;
import controller.Report_6_pk;
import controller.Scheme_Aum;
import controller.nav_report_temp_1;

import sessionFactory.HIbernateSession;


public class Report_12_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		 Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		   ssn.beginTransaction();	
		   
		   int db_save=0;
		   Report_12_Model r_12_m = null;
		   Report_6_pk pk =null;
		      try
		      {
		    	  ArrayList<Avg_ret_Model> quarter_list = (ArrayList<Avg_ret_Model>) ssn.createQuery("from avg_return order by scheme_code").list();
		    	  
		    	  for(Avg_ret_Model arm : quarter_list)
				     {
			    		  pk = new Report_6_pk();        
			    		  r_12_m = new Report_12_Model();
			    		  
			    		  pk.setFrom_date(arm.getKey().getStart_dt());
			    		  pk.setScheme_code(arm.getKey().getScheme_code());
			    		  
			    		  r_12_m.setKey(pk);
			    		  
			    		  
			    		  ArrayList<Scheme_Aum> aum_lst =(ArrayList<Scheme_Aum>) ssn.createQuery("from Scheme_Aum where day=? and scheme_code=?").setDate(0,get_Date_Corrected(arm.getKey().getStart_dt())).setLong(1,arm.getKey().getScheme_code()).list();
			    		   
			    		  if(aum_lst.size()>0)
			    		  {
			    			  r_12_m.setScheme_aum(aum_lst.get(0).getTotal());
			    		  }
			    		  
			    		  ArrayList<ExpenceRatio> e_ratio_lst =(ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where day=? and scheme_code=?").setDate(0,get_Date_Corrected(arm.getKey().getStart_dt())).setLong(1,arm.getKey().getScheme_code()).list();
			    		   
			    		  if(e_ratio_lst.size()>0)
			    		  {
			    			  r_12_m.setExpence_ratio(e_ratio_lst.get(0).getEx_ratio());
			    		  }
			    		 
			    		  java.util.Date date_nav_chk_end = new Date(arm.getKey().getStart_dt().getTime()-((1000 * 60 * 60 * 24)*10));
			    		  
			    		  ArrayList<nav_report_temp_1> nv_rep_tmp_lst =  (ArrayList<nav_report_temp_1>) ssn.createQuery("from nav_report_temp_1 where scheme_code=? and date_ori between ? and ? order by date_ori desc").setLong(0, arm.getKey().getScheme_code()).setDate(1,date_nav_chk_end).setDate(2,arm.getKey().getStart_dt()).list();
			    		 
			    	    if(nv_rep_tmp_lst.size()>0)
			    		  {
			    			 r_12_m.setForward_return_12(nv_rep_tmp_lst.get(0).getRet_mnth_12_forwd());
			    		  }
			    		 			    		  
			    		  ssn.save(r_12_m);
			    		  db_save++;
			    		  
			    		  
			    		  if(db_save%100==0)
			    		  {
			    			  ssn.getTransaction().commit();
			    			  ssn.clear();
			    			  ssn.flush();
			    			  ssn.beginTransaction();
			    			  
			    			  db_save=0;
			    		  }
		    		  
		    		  
		    		  
				     }
		    	  
		    	  
		      }
		      catch(Exception e)
		      {
		    	  e.printStackTrace();
		      }
		    
		   
		   
		   
		   
		   System.out.println("<<<<<<------Report Complete----->>>");  
		    
		   ssn.getTransaction().commit();
		   ssn.close();
           
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

}
