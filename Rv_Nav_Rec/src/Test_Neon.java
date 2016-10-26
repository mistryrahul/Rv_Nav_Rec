import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.hibernate.Session;

import controller.Company_Master;
import controller.Custom_Merged_Report_W_Rank;
import controller.PmCap;
import sessionFactory.HIbernateSession;

public class Test_Neon {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException 
	{
	    
		
		

		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();	
	    
	    ArrayList<Long> distinct_cd = (ArrayList<Long>) ssn.createQuery("select DISTINCT(key.Portfolio_Security_Code) from PmCap").list(); 
	    
	    ArrayList<PmCap> pmcap_lst = new ArrayList<PmCap>();
	    
	    System.out.println("sizeee--->>"+distinct_cd.size());
	    
	    
	    for(Long cd : distinct_cd)
	    {
	    	  ArrayList<PmCap> pmc1 = (ArrayList<PmCap>) ssn.createQuery(" from PmCap where Portfolio_Security_Code="+cd+" order by Trade_Date desc").setMaxResults(1).list();
	    	  
	    	  pmcap_lst.add(pmc1.get(0));
	    	  
 	    }
	    
	    PrintWriter writer = new PrintWriter("/home/rv/Desktop/pmcap_distinct_list.csv", "UTF-8");
		
		for(PmCap xxx: pmcap_lst )
		{	
			writer.println(xxx.getKey().getPortfolio_Security_Code()+","+xxx.getKey().getTrade_Date()+","+xxx.getMCAP_of_the_Company());	
		}
		
		writer.close();
				
	    
//	   ArrayList<Custom_Merged_Report_W_Rank> cm_lst = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank").list();
//	   
//	   ArrayList<ArrayList<String>> book = new ArrayList<ArrayList<String>>();
//	   
//	   ArrayList<String> rows=null;
//	   
//	   
//	   
//	    for(Custom_Merged_Report_W_Rank cl :  cm_lst)
//	    {
//	    	rows=new ArrayList<String>();
//	    	
//	    	
//	    }
//	   
	    
	    
	   
	   
	    
	    ssn.getTransaction().commit();
	    ssn.close();
		 
		System.out.println("<<<<<--- Report Cmplete  ----->>>>");
		
		
		
	}

}
