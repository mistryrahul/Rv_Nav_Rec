import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import controller.nav_hist;
import controller.nav_report;


public class nav_report_main {

	static List<nav_hist> check_db(java.util.Date dt , int scheme_code, Session ssn)
	{
		System.out.println("Date in Method-->"+dt);
		System.out.println("Scheme Code in Method-->"+scheme_code);
		
		Criteria criteria = ssn.createCriteria(controller.nav_hist.class);
		criteria.add(Restrictions.eq("scheme_code",scheme_code));
		criteria.add(Restrictions.eq("nav_date", dt));
		return criteria.list();	
	}
	
	public static void main(String[] args) 
	{
		Session ssn = null;	
		   int i=0;
		   int scheme_code_tmp=0;int k=0;
		   String scheme_code_tmp_str="";
		   SimpleDateFormat formatter=null;
		   String date_to_comp=null;
		   String myDate=null;
		   java.util.Date date_nav_chk;
		   int db_flag=0;
		   java.util.Date nav_start_date_tmp=null;
		   double to_day_nav=0.0;
		   double res_nav=0.0;
		   ArrayList<String> scheme_code_lst = new ArrayList<String>();
		   ArrayList<String> date_lst = new ArrayList<String>();
		   
		   try {
			    LineIterator it_s = FileUtils.lineIterator(new File("/home/rupeevest/Desktop/nav_hist_file_parts/rv_nav_task/scheme_code_list.txt"), "UTF-8");
			    while (it_s.hasNext()) // if the file has lines 
	     	    {
			    	scheme_code_lst.add(it_s.nextLine());
	     	    }
			    
			    
				LineIterator it = FileUtils.lineIterator(new File("/home/rupeevest/Desktop/nav_hist_file_parts/rv_nav_task/nav_report_date_ori.txt"), "UTF-8");
				//PrintWriter pw = new PrintWriter(new FileWriter("/home/rupeevest/Desktop/nav_hist_file_parts/rv_nav_task/report_out.txt"));
				SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
				ssn = sessionfactry.openSession();
				ssn.beginTransaction();
				List<nav_hist> f_res=null; 
				
				while(it.hasNext())
				{
					date_lst.add(it.nextLine());
				}

				
		for(String scheme_code :scheme_code_lst)  // Traversing date list
		{
			scheme_code_tmp = Integer.parseInt(scheme_code);
			//pw.write("\n\n<<--Scheme Code-->>"+scheme_code_tmp+"<<--Scheme Code-->>\n");
			//pw.write("|"+"Date Given"+"|"+"Date Actual"+"|"+"Calculated Nav"+"|\n");
			i=0;
			
			
			
//				while (it.hasNext()) // if the file has lines 
			for(String dt : date_lst)
	     	    {
					f_res=null;
					
			
						 formatter = new SimpleDateFormat("dd/MM/yyyy");
						 myDate = dt;
						 //System.out.println("DATE-FOrmatter-->>"+myDate);
						 date_nav_chk = formatter.parse(myDate);
						 k=0;
						 while(true)
						 {
							    
								 f_res =check_db(date_nav_chk, scheme_code_tmp,ssn) ;
								 
							 if(f_res.size()>=1)
								 {
								        for(nav_hist ob :f_res)	   
								        {
	                                                       //&& ob.getAdjustednav_c()!=0.00 && ob.getRepurprice()!=0.0 && ob.getSaleprice()!=0.00
								        	 if(ob.getAdjnavrs()!=0.00 && ob.getAdjnavrs()!=0.00)
								        	   {
//								        		 System.out.println("getting value for date-->"+myDate);
//								        		 System.out.println("PRint val 1-->"+ob.getAdjustednav_c());
//								        		 System.out.println("PRint val 2-->"+ob.getAdjustednav_nonc());
								        		 
								        		 if (i==0)
								        		 {
								        			 to_day_nav = ob.getAdjnavrs(); 
								        			 nav_start_date_tmp = ob.getNav_date();
								        		   //  pw.write("|"+myDate+"|"+ob.getNav_date()+"|\n");	 
								        		 }
								        		 else
								        		 {
								        			 
								        			 //pw.write("|"+myDate+"|"+ob.getNav_date()+"|"+res_nav+"|\n");
								        			 //gen_row= gen_row+","+gen_row+","+ob.getNav_date()+","+res_nav; 
								        			 							        	
								        			 long days = ((ob.getNav_date().getTime()-nav_start_date_tmp.getTime())/86400000);
								        			 
								        			 if(days<0)
								        			 {
								        			  days=Math.abs(days);
								        				 
								        			  res_nav = (((to_day_nav - ob.getAdjnavrs())/ob.getAdjnavrs())*100);
								        			 
								        			  nav_report nr = new nav_report();
								        			 
								        			  nr.setNav_from_date(nav_start_date_tmp);
								        			  nr.setNav_date(ob.getNav_date());
								        			  nr.setNav_value(res_nav);
								        			  nr.setScheme_Code(scheme_code_tmp);
								        			 
								        			  System.out.println("DAys-->"+days); 
								        			 
								        			  if (days >=169 && days<=192)
								        			     {
								        				      nr.setComment("-6");
								        			     }
								        			  else if (days >=345 && days<=375)
								        			    { 
								        				      nr.setComment("-12");
								        			    }
								        			  else if (days >=522 && days<=558)
								        			    {
								        				      nr.setComment("-18");
								        			    }
								        			  else if (days >=698 && days<=742)
								        			    {
								        				      nr.setComment("-24");
								        			    }
								        			 // nr.setComment("");
								        			    res_nav=0;
								        			    db_flag++;
								        			    ssn.save(nr);
								        		    }
								        		  else // if forward date
								        		    {
								        			  days=Math.abs(days);
								        				 
								        			  res_nav = (((ob.getAdjnavrs()- to_day_nav)/ob.getAdjnavrs())*100);
								        			 
								        			  nav_report nr = new nav_report();
								        			 
								        			  nr.setNav_from_date(nav_start_date_tmp);
								        			  nr.setNav_date(ob.getNav_date());
								        			  nr.setNav_value(res_nav);
								        			  nr.setScheme_Code(scheme_code_tmp);
								        			 
								        			  System.out.println("DAys-->"+days); 
								        			 
								        			  if (days >=169 && days<=192)
								        			     {
								        				      nr.setComment("6");
								        			     }
								        			  else if (days >=345 && days<=375)
								        			    { 
								        				      nr.setComment("12");
								        			    }
								        			  else if (days >=522 && days<=558)
								        			    {
								        				      nr.setComment("18");
								        			    }
								        			  else if (days >=698 && days<=742)
								        			    {
								        				      nr.setComment("24");
								        			    }
								        			 // nr.setComment("");
								        			    res_nav=0;
								        			    db_flag++;
								        			    ssn.save(nr);	 
								        			}
								        		 }
								        		 
								        	   }
								        }
								        
								        
								        
								        break;
								 }
								 else						 
								 {
									 System.out.println("Previous Date-->"+date_nav_chk);
									 date_nav_chk = new Date(date_nav_chk.getTime()-(1000 * 60 * 60 * 24));	 
									 k++;
									 System.out.println("Checking for next Date-->>"+date_nav_chk+" For Scheme Code-->"+scheme_code_tmp);
									 
								 }
								 if(k==6)
								 {
									 //System.out.println("NO val for Date-->"+myDate);
									// pw.write("|"+myDate+"|"+"not Found|"+"No Record|\n"); 
									 break;
								 }
								 
								 
						 
						 }
			         //}
					i++;			
				
					   if(db_flag%20==0)  // for hibernate to avoid Out of Memory Exception 
					   {
						      ssn.flush();
						      ssn.clear();
						      ssn.getTransaction().commit(); 
						      ssn.beginTransaction();
						      db_flag=0;
					   }
					
					
	     	    }
				// here need to put hibernate code for saving 
				
		}		
				
				System.out.println("<---COMPLETE--->");
				
				//pw.close(); // closing the file writer
				ssn.getTransaction().commit(); // committing session
				ssn.close(); // closing session
				
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   finally
			{
//				ssn.getTransaction().commit();   
//				ssn.close();
			}

			
			
			
		}
		
		
	}


