import java.util.ArrayList;

import org.hibernate.Session;

import controller.Custom_Merged_Report_W_Rank;
import sessionFactory.HIbernateSession;

public class Test_Neon {

	public static void main(String[] args) 
	{
	    
		
		

		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();	
	    
	    
	   ArrayList<Custom_Merged_Report_W_Rank> cm_lst = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank").list();
	   
	   ArrayList<ArrayList<String>> book = new ArrayList<ArrayList<String>>();
	   
	   ArrayList<String> rows=null;
	   
	   
	   
	    for(Custom_Merged_Report_W_Rank cl :  cm_lst)
	    {
	    	rows=new ArrayList<String>();
	    	
	    	
	    }
	   
	   
	   
	    
	    ssn.getTransaction().commit();
	    ssn.close();
		 
		
		
		
		
	}

}
