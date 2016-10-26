import java.io.PrintWriter;
import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Company_Master;
import controller.Scheme_Detail;
import sessionFactory.HIbernateSession;

public class Custom_Report_2_May {

	public static void main(String[] args) 
	{
		Session ssn = null;
		ArrayList<Scheme_Detail> list_to_print = new ArrayList<Scheme_Detail>();  
		  try
		  {
			  ssn = HIbernateSession.getSessionFactory().openSession();
			  ssn.beginTransaction();
				
			  Criteria crit = ssn.createCriteria(Scheme_Detail.class);
			  crit.add(Restrictions.in("OPT_CODE",1,2,3));
			  crit.add(Restrictions.in("TYPE_CODE",1,2,3));
			  crit.add(Restrictions.in("PLAN",1,2,3,4,6));
			
			  ArrayList<Scheme_Detail> mn_lst = (ArrayList<Scheme_Detail>) crit.list(); 
			  
			  
//			 ArrayList<Scheme_Detail> mn_lst = (ArrayList<Scheme_Detail>) ssn.createQuery("from Scheme_Detail where (OPT_CODE=1 or OPT_CODE=2 or OPT_CODE=3) and (PLAN=1 or PLAN=2 or PLAN=3 or PLAN=4 or PLAN=6) and (TYPE_CODE=1 or TYPE_CODE=2 or TYPE_CODE=3)").list();
			 
			 System.out.println("Main List Size-->>"+mn_lst.size());
			 if(mn_lst.size()>0)
			 {
				  for(Scheme_Detail ob : mn_lst)
				  {
					  list_to_print.add(ob);
				  }
			 }
			  
			 
			 PrintWriter writer = new PrintWriter("/home/rv/Desktop/Custom_Report_3_1.csv", "UTF-8");
				
				
				for(Scheme_Detail xxx: list_to_print )
				{
						
					writer.println(xxx.getScheme_code()+","+xxx.getAMFI_NAME()+","+xxx.getS_NAME()+","+xxx.getTYPE_CODE()+","+xxx.getOPT_CODE()+","+xxx.getPRIMARY_FUND()+","+xxx.getPRIMARY_FD_CODE()+","+xxx.getSTATUS()+","+xxx.getIsPurchaseAvailable()+","+xxx.getPLAN()+","+xxx.getDiv_Code());		
					
				}
				
				writer.close();
			  
			  
		  }
		  catch(Exception e)
		  {
			 e.printStackTrace(); 
		  }
		  finally 
		  {
			  ssn.close();
		     System.out.println("<<<<--- Report Complete --->>>>");	
		  }

	}

}
