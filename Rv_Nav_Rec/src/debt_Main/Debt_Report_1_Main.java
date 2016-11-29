package debt_Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Query;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.ExpenceRatio;
import controller.Mf_portfolio_New;
import controller.Scheme_Aum;
import controller.Scheme_Paum;
import controller.nav_hist;
import debt_Controller.Avg_maturity;
import debt_Controller.Credit_rating_sum_groups;
import debt_Controller.Debt_Report_1;
import debt_Controller.Pk_generic;
import javassist.bytecode.stackmap.BasicBlock.Catch;
import sessionFactory.HIbernateSession;

public class Debt_Report_1_Main 
{
     
	public static void main(String[] args)
	{
		Session ssn = null;
		int mc=1;
		int db_save=1;
		Debt_Report_1 ob1 = null;
		Pk_generic ob1_pk =null;
		int frst_iteration=1;
				
		double temp_weight=0;
		
		double ans_1=0,ans_2=0,ans_3=0,fin_res=0;
		
		ArrayList<Debt_Report_1> dr_m = new ArrayList<Debt_Report_1>();
		
		double ret_12_mnths=0,ret_36_mnths=0;
		
		long chek_sch_cd=0;
		String class_chk=null;
		java.util.Date date_chk=null;
		
		try
		  {
			ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    ArrayList<Credit_rating_sum_groups> new_calc = new ArrayList<Credit_rating_sum_groups>();
		    
		    ArrayList<Credit_rating_sum_groups> mn_lst = (ArrayList<Credit_rating_sum_groups>) ssn.createQuery("from Credit_rating_sum_groups where classification like '%Liquid%' order by scheme_code").list();
		    
		     for(Credit_rating_sum_groups crsg: mn_lst)
		     {
		    	 new_calc.add(crsg);
		    	
		    	if(new_calc.size()>=2 && frst_iteration!=1)
		    	{
		    		
//		    		System.out.println("1-"+(new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification())));
//		    	    System.out.println("Sch->"+(new_calc.get(new_calc.size()-1).getKey().getScheme_code()==new_calc.get(new_calc.size()-2).getKey().getScheme_code())); 	
//		    		System.out.println("D->"+(new_calc.get(new_calc.size()-1).getKey().getInv_date().compareTo(new_calc.get(new_calc.size()-2).getKey().getInv_date())));
		    		
		   
		    		
		    		   if(( new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification()) )
		    				   && (new_calc.get(new_calc.size()-1).getScheme_code()==new_calc.get(new_calc.size()-2).getScheme_code())
		    				   && (new_calc.get(new_calc.size()-1).getInv_date().compareTo(new_calc.get(new_calc.size()-2).getInv_date()))==0)
		    		   {
		    			   
		    			    frst_iteration++;	 
//				    		System.out.println("SAEME DTATa--->>>");
		    			   
		    		   }
		    		   else
		    		   {
//		    			   System.out.println("DATA VALUE CHANGED---->>>");
		    			   double tot_val=0;
		    			   new_calc.remove(new_calc.size()-1); // removing the last item as that scheme code is different
		    			   
		    			   
		    			   
//		    			   System.out.println("Credit Rating-->>"+get_credit_rating(new_calc));
		    			   
		    			   dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		    			   
		    			   ssn.save(dr_m.get(0));
		    			   ssn.getTransaction().commit();
		    			   ssn.beginTransaction();
		    			   
		    			   dr_m.clear();
		    			   
		    			   
//		    			   ArrayList<Debt_Report_1> avg_mat_lst = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where day=? and scheme_code=?").setDate(0,crsg.getKey().getInv_date()).setLong(1,crsg.getKey().getScheme_code()).list();
////		    			   
//		    			   avg_mat_lst.get(0).setCredit_rating(tot_val);
//		    			   ssn.update(avg_mat_lst.get(0));
		    			   
//		    			   ob1.setCredit_rating(tot_val);
//		    			   ssn.save(ob1);
		    			   
                      
		    			   
		    			   
		    			   frst_iteration=1;
		    			   
		    			   new_calc.clear();
		    			   
		    			   new_calc.add(crsg);
		    			   
		    			   chek_sch_cd=0;
		    			   class_chk=null;
		    			   date_chk=null;
		    				
		    			   
		    		   }
			    		
			    		
			    }
		    	else
		    	{
		    	        frst_iteration=1;
		    	}
		    	 
		    	 
		    	 if(frst_iteration==1)
		    	 {
		    		 
		    		 
//		    		 System.out.println("IN MAIN CLASS which should run-->>"+mc);
		    		 chek_sch_cd = crsg.getScheme_code();
			    	 class_chk=crsg.getClassification();
			    	 date_chk = crsg.getInv_date();
                       
			    	  mc++;
			    	 
			    	 
			    	 ob1 = new Debt_Report_1();
			    	 ob1_pk = new Pk_generic();
			    	 
			    	 ob1_pk.setDay(crsg.getInv_date());
			    	 ob1_pk.setScheme_code(crsg.getScheme_code());
			    	 
			    	 ob1.setKey(ob1_pk);
			    	 
			    	 
			    	 ArrayList<Avg_maturity> avg_mat_lst = (ArrayList<Avg_maturity>) ssn.createQuery("from Avg_maturity where day=? and scheme_code=?").setDate(0,crsg.getInv_date()).setLong(1,crsg.getScheme_code()).list();
			    	 
			    	 if(avg_mat_lst.size()>0)
			    	 {
			    		 
			    		 if(avg_mat_lst.get(0).getMod_dur_days()!=null)
			    		 {
			    			 if(avg_mat_lst.get(0).getMod_dur_days().equalsIgnoreCase("years"))
				    		 {
				    			 ob1.setModified_duration(avg_mat_lst.get(0).getMod_dur_num());	 
				    		 }
				    		 else if(avg_mat_lst.get(0).getMod_dur_days().equalsIgnoreCase("months"))
				    		 {
				    			 ob1.setModified_duration((avg_mat_lst.get(0).getMod_dur_num()/12));	 
				    		 }
				    		 else if(avg_mat_lst.get(0).getMod_dur_days().equalsIgnoreCase("days"))
				    		 {
				    			 ob1.setModified_duration((avg_mat_lst.get(0).getMod_dur_num() /365 ));	 
				    		 }
			    		 }
			    		 
			    	 }
			    	 
			    	 
			    	 ret_12_mnths = calculate_return(crsg, -12, ssn);
			    	 
			    	 if(!Double.toString(ret_12_mnths).equals("-99.99"))
			    	 {
			    		 ob1.setReturn_12_months(ret_12_mnths);	 
			    	 }
			    	 
			    	 
			    	 
			    	 ret_36_mnths = calculate_return(crsg, -36, ssn);
			    	  
			    	 if(!Double.toString(ret_36_mnths).equals("-99.99"))
			    	 {
//			    		 System.out.println("36 Months Return-->>"+ret_36_mnths);
			    		 
			    		 ans_1= ((ret_36_mnths/100) +1);
			    		 ans_2= (0.333333333);
			    		 ans_3 = Math.pow(ans_1 ,ans_2);
			    		 fin_res = ( ans_3 -1 )*100;
			    		 
//			    		 System.out.println("Ans_1->"+ans_1);
//			    		 System.out.println("Ans_2->"+ans_2);
//			    		 System.out.println("Ans_3->"+ans_3);
//			    		 
//			    		 System.out.println("Result--->>>"+fin_res);
			    		 
			    		 ob1.setReturn_36_months(fin_res);
			    	 }
			    	 
			    	 
			    	 //last ex-ratio where value is not 0
//			    	 ArrayList<ExpenceRatio> e_rat = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day<=? and ex_ratio!=0 order by day desc").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list();
			    	 ArrayList<ExpenceRatio> e_rat = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day=?").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list();
			    	 
			    	 if(e_rat.size()>0)
			    	 {
			    		 ob1.setEx_ratio(e_rat.get(0).getEx_ratio());
                	 }

                     ArrayList<Mf_portfolio_New> sch_aum_mf_prtflio = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code=? and invdate=?").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).setMaxResults(1).list();
			    	 
			    	 if(sch_aum_mf_prtflio.size()>0)
			    	 {
			    		 ob1.setAum(sch_aum_mf_prtflio.get(0).getAum()/100); // cause it is in lakhs, we need that in crores
			    		 
                	 }
			    	 
//			    	 // Previous AUM- 
//			    	 ArrayList<Scheme_Paum> sch_aum = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list(); 
//			    	 if(sch_aum.size()>0)
//			    	 {
//			    		 ob1.setAum(sch_aum.get(0).getAvg_aum()/100); // cause it is in lakhs, we need that in crores
//			    		 
//                	 }
			    	 
			    	 
			    	 
			    	 dr_m.add(ob1); 
			    	 
//			    	 ssn.save(ob1);
//			    	 db_save++;
			    	 
			    	 
			    	 
//			    	 if(db_save%100==0)
//			    	 {
//			    		 ssn.getTransaction().commit();
//			    		 ssn.getTransaction().begin();
//			    		 db_save=1;
//			    	 }
			    	
//			    	 
			    	 
			    	 
			    	 frst_iteration++;
		    	 }
		    	
		    	 
		     }
		     
		         
		             if(dr_m.size()!=0)
		             {
		            	 dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		            	 ssn.save(dr_m.get(0));
		             }
		    
		             
		             ssn.getTransaction().commit();
		             ssn.beginTransaction();
		             
		             Query query = ssn.createQuery("delete from Debt_Report_1 where return_36_months=0");
		              
		             int result = query.executeUpdate();
		              
		             if (result > 0) {
		                 System.out.println("36 Months Returns which are 0 and aum < 100  are removed");
		             }
		             
		             Query query_1 = ssn.createQuery("update Debt_Report_1 set star='Unrated' where aum < 100");
		             
		             		             
		             int result_1 = query_1.executeUpdate();
		             
		             if (result_1 > 0) {
		                 System.out.println("all aum below 100 crore updated as unrated");
		             }
		             
		             
		             ssn.getTransaction().commit();
		             
		             ssn.beginTransaction();
		             
		             
                     Genrate_Rank(ssn);
                     
                     
//                      ssn.close();
//                      ssn = HIbernateSession.getSessionFactory().openSession(); 
//		              ssn.beginTransaction();
		              
		              ArrayList<Debt_Report_1> mn_lst_totl = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null").list();
                     
                       for(Debt_Report_1 ob : mn_lst_totl)
                       {
                    	   temp_weight=(ob.getCredit_rating_rank()*0.3)+(ob.getReturn_12_months_rank()*0.2)+(ob.getReturn_36_months_rank()*0.3)+(ob.getModified_duration_rank()*0.2);
                           ob.setWeight_to_ranks(temp_weight);
                           
                           temp_weight=0;
                           
                           ssn.update(ob);
                       }
                     ssn.getTransaction().commit();
                     ssn.beginTransaction();
                     
                     Genrate_Rank_for_Weight(ssn);
                     
                     Generate_start_rating(ssn);
		             
                      
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		finally
		{
//			ssn.getTransaction().commit();
     	    ssn.close();
		    System.out.println("<<<<----Report COmplete----->>>>>");
		}
	}
	
	
	
	private static void Generate_start_rating(Session ssn) 
	{
		ssn.getTransaction().commit();
		ssn.beginTransaction();
		
		int rec_counter=1;
		int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//        ssn.beginTransaction();
        
        ArrayList<Debt_Report_1> mn_lst_rank_wise = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by rank_of_weight_to_ranks desc").list();
        tmp_size = mn_lst_rank_wise.size();
        
        top_grp_1=(int) Math.round(tmp_size*.10);
        top_grp_2=(int) Math.round(tmp_size*.25);
        top_grp_3=(int) Math.round(tmp_size*.30);
        top_grp_4=(int) Math.round(tmp_size*.25);
        top_grp_5=(int) Math.round(tmp_size*.10);
        
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
        
        for(Debt_Report_1 ob : mn_lst_rank_wise)
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
         
       ssn.getTransaction().commit();
//		ssn.close();
	}

	private static void Genrate_Rank_for_Weight(Session ssn) 
	{
		 double retval=99999;
		 double temp_val_hldr=123.00;
		 int rank_hldr=1;
		 int same_rank_flag=0;
		 
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();
	    
		ArrayList<Debt_Report_1> quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by weight_to_ranks desc").list();
	    
		rank_hldr= quarter_list.size()+1;
		
		for(Debt_Report_1 arm: quarter_list)
		{
			 retval = Double.compare(temp_val_hldr,arm.getWeight_to_ranks());
	 		    
		    	if(retval==0)
		    	{
		    	    arm.setRank_of_weight_to_ranks(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;
		    	    same_rank_flag--;
		    	}
		    	else
		    	{   
		    		rank_hldr=rank_hldr+same_rank_flag;
		    		same_rank_flag=0;
		    		rank_hldr=rank_hldr-1;
		    		
		    		arm.setRank_of_weight_to_ranks(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;  
		    	}
		    	
		    	
		    	temp_val_hldr=arm.getWeight_to_ranks();
		}
	    
	    
	    ssn.getTransaction().commit();
	    ssn.beginTransaction();
//	    ssn.close();
		
	 	
	}
	
	

	private static void Genrate_Rank(Session ssn)
	{
	     
		ArrayList<Debt_Report_1> quarter_list = null;
		String colum_lst[] = {"return_12_months","return_36_months","credit_rating","modified_duration"};
		double temp_val_hldr=0;
		int rank_hldr=1;
		int same_rank_flag=0;
		int retval=99;
		
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();
	    
	    for(String colmn : colum_lst)
	    {
	    	if(colmn.equals("modified_duration"))
	    	{
	    		  quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by "+colmn+" desc").list();
	    		  rank_hldr=0;  
	    	}
	    	else
	    	{
	    		quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by "+colmn+" desc").list();
	    		rank_hldr=quarter_list.size()+1;
	    	}
	    	
	    	
//	    	System.out.println("<<<<<<<<<--------LIST SIZE----------------->>>>>>>>>>>>>>>>>>>>");
//    	    System.out.println(quarter_list.size());
//    	    System.out.println("<<<<<<<<<--------LIST SIZE END----------->>>>>>>>>>>>>>>>>>>>");
	    	
	    	
	    	   temp_val_hldr=-999999;
//   	    	   rank_hldr=0;
   	    	   same_rank_flag=0;
   	    	   
   	    	   for(Debt_Report_1 arm : quarter_list)
   	    	   {
   	    		   
		   	    		if(colmn=="return_12_months")
		 			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getReturn_12_months());
		  		 		    
		 	 		    	if(retval==0)
		 	 		    	{
		 	 		    	    arm.setReturn_12_months_rank(rank_hldr);
		 	 		    	    ssn.update(arm);
//		 	 		    	    db_flag++;
		 	 		    	    same_rank_flag--;
		 	 		    	}
		 	 		    	else
		 	 		    	{   
		 	 		    		rank_hldr=rank_hldr+same_rank_flag;
		 			    		same_rank_flag=0;
		 			    		rank_hldr=rank_hldr-1;
		 			    		
		 	 		    		arm.setReturn_12_months_rank(rank_hldr);
		 	 		    	    ssn.update(arm);
//		 	 		    	    db_flag++;  
		 	 		    	}
		 	 		    	
		 	 		    	temp_val_hldr=arm.getReturn_12_months();
		 			   }
		   	    		
		   	    		if(colmn=="return_36_months")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getReturn_36_months());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setReturn_36_months_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag--;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr-1;
			 			    		
			 	 		    		arm.setReturn_36_months_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	temp_val_hldr=arm.getReturn_36_months();
			 			   }	
		   	    		
		   	    		if(colmn=="credit_rating")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getCredit_rating());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setCredit_rating_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag--;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr-1;
			 			    		
			 	 		    		arm.setCredit_rating_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	
			 	 		    	temp_val_hldr=arm.getCredit_rating();
			 			   }
		   	    		
		   	    		if(colmn=="modified_duration")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getModified_duration());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setModified_duration_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag++;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr+1;
			 			    		
			 	 		    		arm.setModified_duration_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	
			 	 		    	temp_val_hldr=arm.getModified_duration();
			 			   }
		   	    		   
   	    	   }
   	    	   
   	    	   
   	    	   
   	    	  
	    	
	    	
	    	
	    	
	    }
	    
	    
//	    ssn.getTransaction().commit();
//	    ssn.close();
		
		
	}

	private static double get_credit_rating(ArrayList<Credit_rating_sum_groups> new_calc) {
		
		double tot_val=0;
		double tmp_hld_prcnt=0;
		
		 for(Credit_rating_sum_groups oo:new_calc)
		   {  
//			     System.out.println("HOlding Percentage--->>"+oo.getHold_percent()+" Scheme COde-->"+oo.getKey().getScheme_code());
			     
//			      if(oo.getHold_percent()>0)
//			      {
//			    	  tmp_hld_prcnt =oo.getHold_percent(); 
//			      }
//			      else
//			      {
//			    	  tmp_hld_prcnt = 0;
//			      }
			        
			    	tmp_hld_prcnt =oo.getHold_percent(); 
			   
			     if(oo.getRv_group().equalsIgnoreCase("AAA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*9);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Cash & Equivalent"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("SOV"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("AA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*7);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("A"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*5);	 
			     }
			     
			     else if(oo.getRv_group().equalsIgnoreCase("Others"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Deposits"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Equity"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Unrated"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     
			   
		   }
		 
		 return tot_val;
		
	}

	static double calculate_return(Credit_rating_sum_groups crsg_obj,int months ,Session ssn) throws ParseException
	{
//		 ArrayList<nav_hist> nav_hst_lst_mn = get_list_of_dates_db(crsg_obj.getKey().getInv_date(),crsg_obj.getKey().getScheme_code());
		 
		 double nav_ret=0;
		
		 Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
		 criteria.add(Restrictions.eq("scheme_code",(int)crsg_obj.getScheme_code()));
		 criteria.add(Restrictions.eq("nav_date",crsg_obj.getInv_date()));
		 
		 ArrayList<nav_hist> nav_hst_lst_mn = (ArrayList<nav_hist>) criteria.list();
		 
		 
		 if(nav_hst_lst_mn.size()>0)
		 {
			 java.util.Date ddd=null;
			 
			 Calendar cal = Calendar.getInstance();
	    	 cal.setTime(crsg_obj.getInv_date());
	    	 cal.add(Calendar.MONTH,months);
		     ddd = cal.getTime();
	    	 
		     	     
		     ArrayList<nav_hist> nav_hst_lst = get_list_of_dates_db(ddd, crsg_obj.getScheme_code());
		     
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
	
}
