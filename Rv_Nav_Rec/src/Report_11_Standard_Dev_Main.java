import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;
import controller.Avg_ret_Model;
import controller.Report_10_Model;
import controller.Report_11_Standard_Dev;
import controller.Report_6_pk;
import controller.nav_hist;
import controller.nav_report_temp_1;


public class Report_11_Standard_Dev_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Report_6_pk pk_6=null;
		Report_11_Standard_Dev rtm=null;
		nav_hist current_nav_obj=null;
		
	    int db_save=0;
		 try
		   {
			   
			   Session ssn = HIbernateSession.getSessionFactory().openSession(); 
			   ssn.beginTransaction();		
			    
//			   ArrayList<Custom_Merged_Report_W_Rank> quarter_list = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank order by scheme_code").list();
            
			   ArrayList<Avg_ret_Model> quarter_list = (ArrayList<Avg_ret_Model>) ssn.createQuery("from avg_return order by scheme_code").list();
			   
			   
			   
//			     for(Custom_Merged_Report_W_Rank cmrwr : quarter_list)
			    for(Avg_ret_Model cmrwr : quarter_list)
			     {
//			    	 temp_dt
			    	   rtm = new Report_11_Standard_Dev();
					   pk_6 =new Report_6_pk();
					   
					   pk_6.setFrom_date(cmrwr.getKey().getStart_dt());
					   pk_6.setScheme_code(cmrwr.getKey().getScheme_code());
					   
					   rtm.setKey(pk_6);
					   
					  
					   
			    	  ArrayList<nav_hist> dt_lst  = get_list_of_dates_db(cmrwr.getKey().getStart_dt(),(int) cmrwr.getKey().getScheme_code()); 	 
			    	  
			    	  current_nav_obj=dt_lst.get(0);
			 	  			    	  
			    	  
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,100,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,200,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,300,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,400,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,500,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,600,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,700,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,800,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,900,ssn,rtm);
			    	  Calculate_And_Save_Std_Dev(current_nav_obj,1000,ssn,rtm);
			    	  
			    	  		      
			    	   Query q33 =  ssn.createQuery("from nav_report_temp_1 where scheme_code=? and date_ori=?").setLong(0, current_nav_obj.getScheme_code()).setDate(1,current_nav_obj.getNav_date());
						 
						 
						 ArrayList<nav_report_temp_1> nav_rem_tmp_lst = (ArrayList<nav_report_temp_1>) q33.list();
						 
						  if(nav_rem_tmp_lst.size()>0)
						  {
						       						       
						       rtm.setForward_return_12(nav_rem_tmp_lst.get(0).getRet_mnth_12_forwd());
						      
						       
						  }
			    	  
			    	     
			    	  
			    	  
			    	  ssn.save(rtm);
			    	  db_save++;
			    	  
			    	  if(db_save%5==0)
	   		 		    {
	   		 		    	ssn.getTransaction().commit();
	   		 		        ssn.flush();
					        ssn.clear();
	   		 		    	ssn.beginTransaction();
	   		 		    	
	   		 		        db_save=0;
	   		 		    }
			    	  
			    	  
			    	 
			     }
			     
			     
			     
			     ssn.getTransaction().commit();
			     ssn.close();
			     
			     System.out.println("------Report Complete----");
			   
			   
		
			   
			   
			   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		
		

	}
	
	private static void Calculate_And_Save_Std_Dev(nav_hist current_nav_obj,int days, Session ssn ,Report_11_Standard_Dev rtm) {
		
	  DescriptiveStatistics stats = null;
	  double Sdev_Res=0;	
  	  ArrayList<nav_hist> dt_lst_last_n_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where id<="+current_nav_obj.getId()+" and scheme_code="+current_nav_obj.getScheme_code()+" order by id desc").setMaxResults(days).list();
  	  
  	   
  	  
  	  
  	  
  	  
  	  if(dt_lst_last_n_days.size()==100)
  	  {
  		  stats = new DescriptiveStatistics();
  		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_100_day_SD(Sdev_Res);
	    	  
	    	  
  	  }
     
  	  if(dt_lst_last_n_days.size()==200)
  	  {
  		  stats = new DescriptiveStatistics();
  		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_200_day_SD(Sdev_Res);
	    	  
	    	  
  	  }
  	 if(dt_lst_last_n_days.size()==300)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_300_day_SD(Sdev_Res);
	    	  
	    	  
	  }  	 
  	 if(dt_lst_last_n_days.size()==400)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_400_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 if(dt_lst_last_n_days.size()==500)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_500_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 
  	 if(dt_lst_last_n_days.size()==600)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_600_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 if(dt_lst_last_n_days.size()==700)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_700_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 if(dt_lst_last_n_days.size()==800)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_800_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 if(dt_lst_last_n_days.size()==900)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_900_day_SD(Sdev_Res);
	    	  
	    	  
	  }
  	 
  	 if(dt_lst_last_n_days.size()==1000)
	  {
		  stats = new DescriptiveStatistics();
		  Sdev_Res=0;

	    	  for(nav_hist nh : dt_lst_last_n_days)
	    	  {
	    		stats.addValue(nh.getAdjnavrs());
	    	  }
	    	  
	    	  Sdev_Res= stats.getStandardDeviation();
	    	  
	    	  rtm.setLast_1000_day_SD(Sdev_Res);
	    	  
	    	  
	  }
		
  	 
  	 ssn.save(rtm);
		
	}

	static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, int scheme_code) throws ParseException
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
