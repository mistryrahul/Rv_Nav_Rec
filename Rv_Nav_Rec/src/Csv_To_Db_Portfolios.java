import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.Mf_portfolio_Model;


public class Csv_To_Db_Portfolios {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		long i=1;
		
		Session ssn = null;
		
		Mf_portfolio_Model portfolio =null;
		
		
		try
		{   
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/mf_portfolios_Equity.csv"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			while (it.hasNext()) // if the file has lines 
     	    {
//				String[] separated = it.nextLine().split("\\,");
				String[] separated = it.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);			
				
				portfolio = new Mf_portfolio_Model();
				
				portfolio.setId(i);
				
				
				if(separated[0]==null || separated[0].isEmpty() ||separated[0].replace("\"", "").equals("NULL") || separated[0].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
					portfolio.setScheme_code(Long.parseLong(separated[0].replace("\"", "")));			
//					System.out.println(separated[0].replace("\"", ""));	
				}
				
				if(separated[1]==null || separated[1].isEmpty() ||separated[1].replace("\"", "").equals("NULL") || separated[1].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
				
				java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].replace("\"", "").substring(0,10));
				portfolio.setInv_date(dd);
//				System.out.println(separated[1].replace("\"", ""));
				}
				
				if(separated[2]==null || separated[2].isEmpty() ||separated[2].replace("\"", "").equals("NULL") || separated[2].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
				portfolio.setComp_name(separated[2].replace("\"", ""));
//				System.out.println(separated[2].replace("\"", ""));
				}
				
				if(separated[3]==null || separated[3].isEmpty() ||separated[3].replace("\"", "").equals("NULL") || separated[3].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
				
				portfolio.setHolding_prcnt(Double.parseDouble(separated[3].replace("\"", "")));
//				System.out.println(separated[3].replace("\"", ""));
	           
				}
				
				if(separated[4]==null || separated[4].isEmpty() ||separated[4].replace("\"", "").equals("NULL") || separated[4].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
				portfolio.setFin_code(Long.parseLong(separated[4].replace("\"", "")));
//				System.out.println(separated[4].replace("\"", ""));
				
				}
				
				if(separated[5]==null || separated[5].isEmpty() ||separated[5].replace("\"", "").equals("NULL") || separated[5].replace("\"", "")=="NULL")
				{
						
				}
				else
				{
					
				portfolio.setClassification(separated[5].replace("\"", ""));
//				System.out.println(separated[5].replace("\"", ""));
				
     	        }
			
			
				if(separated[6]==null || separated[6].isEmpty() ||separated[6].replace("\"", "").equals("NULL") || separated[6].replace("\"", "")=="NULL")
				{
						
				}
				else
				{ 
				portfolio.setRv_sect_name(separated[6].replace("\"", ""));
//				System.out.println(separated[6].replace("\"", ""));
				}
				
				ssn.save(portfolio);
				
				if(i%5000==0)
				{
					  ssn.getTransaction().commit(); 
					  ssn.beginTransaction();
					  ssn.flush();
				      ssn.clear();
				      
				}			
				
				
							
				
				i++;
     	    }
			
			ssn.getTransaction().commit();
			ssn.close();
			System.out.println("<---- Uploading Complete---->");
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in Line-->"+i);
			
			e.printStackTrace();
		}


	   	

	}

}
