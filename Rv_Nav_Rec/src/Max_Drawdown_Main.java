import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;

import controller.Max_Drawdown_Model;
import controller.nav_hist;
import controller.nav_report_3_stable;


public class Max_Drawdown_Main {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException 
	{
		int db_save=0; 
		int lp_flg=0;
		double Max_Nav=0.0;
		double Max_Drawdown=0;
		double Max_Drawdown_old=0.0;
				
		java.util.Date dd = null;
		Calendar cal = Calendar.getInstance(); 
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		Session ssn = sessionfactry.openSession();
		ssn.beginTransaction();
		
		Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
		criteria_1.setProjection( Projections.distinct(Projections.property("scheme_Code")));  		
 		criteria_1.addOrder(Order.asc("scheme_Code"));
 		
 		ArrayList<Long> scheme_code_list = (ArrayList<Long>) criteria_1.list();
 		
//		ArrayList<Long> scheme_code_list = new ArrayList<Long>();
//		scheme_code_list.add((long) 15);
		
 		
 		for(long sc : scheme_code_list)
 		{
 			
 			String hql = "from nav_hist_full where scheme_code="+sc+" order by nav_date";
 			
 			Query query = ssn.createQuery(hql);
 			ArrayList<nav_hist> max_min_date = (ArrayList<nav_hist>) query.list();
 			
 			
 			  System.out.println("DATe STARt-->>"+max_min_date.get(0).getNav_date());
 			
 			
 			  cal.setTime(max_min_date.get(0).getNav_date());
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		      cal.add(Calendar.YEAR,1);
		      dd = cal.getTime();
 			ArrayList<nav_hist> possible_date_lst = get_list_of_dates_db(dd,sc);
 			 
 			  
 			  Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
			  criteria.add(Restrictions.eq("scheme_code",(int) sc)); 
			  criteria.add(Restrictions.between("nav_date", max_min_date.get(0).getNav_date(),possible_date_lst.get(0).getNav_date()));
     		  criteria.addOrder(org.hibernate.criterion.Order.asc("nav_date"));
     		  ArrayList<nav_hist> final_lst =(ArrayList<nav_hist>) criteria.list();
 			  
     		  Max_Drawdown_Model mdm = new Max_Drawdown_Model();
     		  
     		  mdm.setStart_date(max_min_date.get(0).getNav_date());
     		  mdm.setEnd_date(possible_date_lst.get(0).getNav_date());
     		  mdm.setScheme_code(sc);
     		  
     		  lp_flg=0;  // Reseting flag value...
     		  Max_Drawdown=0.0;
     		  Max_Drawdown_old=0.0;
     		  
     		       for(nav_hist nvr:final_lst)
     		       {
//     		    	  System.out.println("<<<<<<<--------------IN THE LOOP----------------->>>>>>>>");
     		    	   
     		    	   if(lp_flg==0)
     		    	   {
     		    		   
     		    		   Max_Nav=nvr.getAdjnavrs();
//     		    		   System.out.println("First Iteration-->"+Max_Nav);
//     		    		   System.out.println("DAte-->"+nvr.getNav_date()+" Scheme-Code-->"+sc);
//     		    		   lp_flg++;
//     		    		   continue;
     		    	   }
     		    	   else
     		    	   {
//     		    		   System.out.println("<<<<<<<--------------COMING HERE----------------->>>>>>>>");
     		    		    if(nvr.getAdjnavrs() > Max_Nav)
     		    		    {
     		    		    	Max_Nav = nvr.getAdjnavrs();
     		    		    }
     		    		    
     		    		    Max_Drawdown = (( Max_Nav - nvr.getAdjnavrs()  ) / Max_Nav )*100;
     		    		    
//     		    		    System.out.println("MAX_NAV-->"+Max_Nav);
//     		    		    System.out.println("CUrrent NAV VAL-->"+nvr.getAdjnavrs());
//     		    		    System.out.println("DRAW DOWN_CALC-->>"+Max_Drawdown);
     		    		    
     		    		    
     		    		    if(Max_Drawdown > Max_Drawdown_old)
     		    		    {
     		    		    	Max_Drawdown_old = Max_Drawdown;
     		    		    }
     		    		    
     		    		    
//     		    		    if(Max_Drawdown_old > Max_Drawdown)
//     		    		    {
//     		    		    	Max_Drawdown = Max_Drawdown_old;
//     		    		    }
//     		    		   
//     		          		   Max_Drawdown_old = Max_Drawdown;
     		    		      
//     		    		       System.out.println("<<<<<<<---->>>>>>");
//     		    		       System.out.println(" SchemeCode-->"+sc);
//     		    		       System.out.println("NAV VAL-->>"+nvr.getAdjnavrs());
//     		    		       System.out.println(" Date-->"+nvr.getNav_date());
//    		          		   System.out.println(" MAX_DRAW_DOWN--->>"+Max_Drawdown);
//     		          		   System.out.println(" MAX_DRAW_DOWN_OLD--->>"+Max_Drawdown_old);
//     		    		       System.out.println("<<<<<<<---->>>>>>");
//     		    		       
     		    		       
     		    		      
     		    	   }
     		    	   
     		    	  lp_flg++;
     		    	 
     		       }
 			
     		      mdm.setMax_drawdown(Max_Drawdown_old);
     		      ssn.save(mdm);
     		      db_save++;
     		      
     		      
     		      if(db_save%50==0)
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
 		
// 		System.out.println("<---Report Complete---->");
 		
		
       
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
