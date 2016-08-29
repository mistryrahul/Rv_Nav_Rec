import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import sessionFactory.HIbernateSession;
import controller.Average_Maturity;
import controller.Avg_ret_Model;
import controller.Calma_Ratio_Model;
import controller.ExpenceRatio;
import controller.Report_6_pk;
import controller.Report_7_Model;
import controller.Scheme_Aum;
import controller.nav_report_3_stable;


public class Report_7_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int db_save=0;
			Calendar cal = Calendar.getInstance(); 
			java.util.Date temp_date=null;
			ArrayList<nav_report_3_stable>  nav_rep_lst_tmp = null;
			ArrayList<ExpenceRatio>  exp_rat_lst_tmp = null;
			ArrayList<Average_Maturity>  avg_mat_lst_tmp = null;
			ArrayList<Scheme_Aum> sch_aum_lst_tmp = null;
			Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    String hql_nw=" from avg_return where start_dt<='2015-03-31'";
	 		Query q_2 = ssn.createQuery(hql_nw);
	 		
	 		ArrayList<Avg_ret_Model> avg_ret_main_lst = (ArrayList<Avg_ret_Model>) q_2.list();
	 		Report_7_Model rm=null;
	 		Report_6_pk pk=null;
	 		Average_Maturity am=null;
	 		ExpenceRatio er=null;
	 		Scheme_Aum sa=null;
	 		 for(Avg_ret_Model arm :avg_ret_main_lst)
	 		   {
	 			   
	 			//  yr_incr=1;
//	 			   System.out.println("SCHEME_CODE--->>>"+arm.getKey().getScheme_code());
//	 			  System.out.println("STARt DATE--->>>"+arm.getKey().getStart_dt());
	 			   
	 			  cal.setTime(arm.getKey().getStart_dt());
//			      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
			     
	 			  rm = new Report_7_Model();
	 			  pk = new Report_6_pk();
	 			  am=new Average_Maturity();
	 			  er=new ExpenceRatio();
	 			  sa=new Scheme_Aum();
	 			  
	 			  pk.setFrom_date(arm.getKey().getStart_dt());
	 			  pk.setScheme_code(arm.getKey().getScheme_code());
	 			 rm.setKey(pk);
	 			 java.util.Date dd=pk.getFrom_date();
//	 			 System.out.println("dd is "+ dd);
//	 			 System.out.println("date from pk is" + dd.getMonth());
//	 			 System.out.println("year from pk is -->"+dd.getYear());
	 			 if(dd.getMonth()==0 || dd.getMonth()==1 ||dd.getMonth()==2 )
	 			 {
	 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
	 				 rm.setComment("Qtr_1_"+( dd.getYear()-100));
	 			 }
	 			 else if(dd.getMonth()==3 || dd.getMonth()==4 ||dd.getMonth()==5 )
				 {
	 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
					 rm.setComment("Qtr_2_"+( dd.getYear()-100));
				 }
	 			else if(dd.getMonth()==6 || dd.getMonth()==7 ||dd.getMonth()==8 )
				 {
	 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
					 rm.setComment("Qtr_3_"+( dd.getYear()-100));
				 }
	 			else if(dd.getMonth()==9 || dd.getMonth()==10 ||dd.getMonth()==11 )
				 {
	 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
					 rm.setComment("Qtr_4_"+( dd.getYear()-100));
				 }
	 			Criteria criteria_12 = ssn.createCriteria( ExpenceRatio.class );
		         criteria_12.add(Restrictions.eq("day", rm.getKey().getFrom_date()));  
		         criteria_12.add(Restrictions.eq("scheme_code",rm.getKey().getScheme_code()));
		         exp_rat_lst_tmp = (ArrayList<ExpenceRatio>) criteria_12.list();
		         if(exp_rat_lst_tmp.size()>0)
		         {
		           rm.setEx_ratio(exp_rat_lst_tmp.get(0).getEx_ratio());
		         }
//	 			 er.setDay(arm.getKey().getStart_dt());
//	 			 er.setScheme_code(arm.getKey().getScheme_code());
//	 			  rm.setEx_ratio(er.getEx_ratio());
//	 			 Criteria criteria_12 = ssn.createCriteria( ExpenceRatio.class );
		           Criteria criteria_13 = ssn.createCriteria( Average_Maturity.class );
		           criteria_13.add(Restrictions.eq("day", rm.getKey().getFrom_date()));  
			         criteria_13.add(Restrictions.eq("schem_code",rm.getKey().getScheme_code()));
			         avg_mat_lst_tmp= (ArrayList<Average_Maturity>) criteria_13.list();
			         if(avg_mat_lst_tmp.size()>0)
			         {
			           rm.setTurnover_ratio(avg_mat_lst_tmp.get(0).getTurnover_ratio());
			         }
//	 			 am.setDay(arm.getKey().getStart_dt());
//	 			 am.setSchem_code(arm.getKey().getScheme_code());
//	 			  rm.setTurnover_ratio(am.getTurnover_ratio());
	 			  
			           
			           Criteria criteria_14 = ssn.createCriteria( Scheme_Aum.class );
			           criteria_14.add(Restrictions.eq("day", rm.getKey().getFrom_date()));  
				         criteria_14.add(Restrictions.eq("scheme_code",rm.getKey().getScheme_code()));
				         sch_aum_lst_tmp= (ArrayList<Scheme_Aum>) criteria_14.list();
				         if(sch_aum_lst_tmp.size()>0)
				         {
				           rm.setTotal(sch_aum_lst_tmp.get(0).getTotal());
				         }
//	 			 sa.setDay(arm.getKey().getStart_dt());
//	 			 sa.setScheme_code(arm.getKey().getScheme_code());
//	 			  rm.setTotal(sa.getTotal());
	 			 Criteria criteria_11 = ssn.createCriteria( nav_report_3_stable.class );
		         criteria_11.add(Restrictions.eq("nav_from_date", rm.getKey().getFrom_date()));  
		         criteria_11.add(Restrictions.eq("scheme_Code",rm.getKey().getScheme_code()));
		         criteria_11.add(Restrictions.eq("comment","12"));
		           
		         nav_rep_lst_tmp = (ArrayList<nav_report_3_stable>) criteria_11.list();
				  
		         if(nav_rep_lst_tmp.size() > 0)
		           {
		        	   rm.setForward_12_mnth_ret(nav_rep_lst_tmp.get(0).getNav_value());   
		           }

		         ssn.save(rm);
//	 			    ssn.getTransaction().commit();
			        db_save++;
			        
			        
			       if(db_save%50==0)
			      {
			    	    
			    	  
			    	  ssn.flush();
		  		      ssn.clear();
		  		    ssn.getTransaction().commit();
		  		      ssn.beginTransaction();
		  		      
		  		      db_save=0;
		  		      
		  		      System.out.println("Reseting Session...");
			      }

	}
	 		  ssn.getTransaction().commit();
	 		  ssn.close();
			  System.out.println("<<<<<---Report Complete---->>>>>");


}}
