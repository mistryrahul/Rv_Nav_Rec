import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;

import controller.Company_Master;
import sessionFactory.HIbernateSession;

public class Custom_Report_May {

	public static void main(String[] args) 
	{
	  
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		Session ssn = null;
		String tmp_val=null;
		int i=1,index=99;
		ArrayList<Long> Ind_code_list = new ArrayList<Long>(); 
		ArrayList<ArrayList<Company_Master>> list_to_print = new ArrayList<ArrayList<Company_Master>>(); 
		
		try
		{
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Industrymaster.ace"), "UTF-8");
			
			
			
				while (it.hasNext()) // if the file has lines 
	     	    {
//					System.out.println("has value");
				   tmp_val=it.nextLine();		
					if(tmp_val.equals("<<eof>>"))
					{
						i=1;
						break;
					}
					matcher = pattern.matcher(tmp_val);
					matcher.find();
					String[] separated = matcher.group(1).split("\\|");	
					

					if(Long.parseLong(separated[0])==113 || Long.parseLong(separated[0])==142 || Long.parseLong(separated[0])==147 || Long.parseLong(separated[0])==153 || Long.parseLong(separated[0])==154)
					{
						
					}
					else
					{
						if( Ind_code_list.indexOf(separated[0])== -1)
						   {
							Ind_code_list.add(Long.parseLong(separated[0]));
						   }
					}
			
	     	    }
				
//				System.out.println("IND CODE--- SIZE_->>>"+Ind_code_list.size());
				
				
				ssn = HIbernateSession.getSessionFactory().openSession();
				ssn.beginTransaction();
				
				for( long lg :Ind_code_list)
				{
					ArrayList<Company_Master> mn_lst = (ArrayList<Company_Master>) ssn.createQuery("from Company_Master where IND_CODE=?").setLong(0, lg).list();
					
					if(mn_lst.size()>0)
					{
						list_to_print.add(mn_lst);
					}
					
				}
				
				
				
				
//				System.out.println("TO PRINT--->>"+list_to_print.size());
				
				PrintWriter writer = new PrintWriter("/home/rv/Desktop/Custom_Report.csv", "UTF-8");
				
				
				for(ArrayList<Company_Master> xxx: list_to_print )
				{
					for(Company_Master ob: xxx)
					{
						
						writer.println(ob.getFincode()+","+ob.getSCRIPCODE()+","+ob.getSYMBOL()+","+ob.getCOMPNAME()+","+ob.getS_NAME()+","+ob.getIND_CODE()+","+ob.getInd_Name()+","+ob.getISIN()+","+ob.getStatus());
						
					}
				}
				
				writer.close();
				
				
				
				System.out.println("<<<<<<--(Report Complete)--->>>>>>");
				
				
				
				
				
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
		   ssn.close();	
		}

		
	}

}
