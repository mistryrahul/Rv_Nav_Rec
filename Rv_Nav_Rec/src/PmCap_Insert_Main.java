import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;

import controller.Industry_Master;
import controller.PmCap;
import controller.PmCap_Pk;
import sessionFactory.HIbernateSession;

public class PmCap_Insert_Main {

	public static void main(String[] args) 
	{
		double db_save=1;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		java.util.Date dd,dd_1,dd_2;
		int save_flg=1;
		String tmp_val=null;
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		
		try
		{
		  	
		LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/pmcap_sept_oct_20.ace"), "UTF-8");
//		LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Scheme_details_full.ace"), "UTF-8");

		
		ssn = HIbernateSession.getSessionFactory().openSession();
		ssn.beginTransaction();
		
		
			while (it.hasNext()) // if the file has lines 
     	    {

			   tmp_val=it.nextLine();

				
				if(tmp_val.equals("<<eof>>"))
				{
					i=1;
					break;
					
				}
				matcher = pattern.matcher(tmp_val);
				matcher.find();
				String[] separated = matcher.group(1).split("\\|");	

				PmCap pmc = new PmCap();
				PmCap_Pk key = new PmCap_Pk();
				
				key.setPortfolio_Security_Code(Long.parseLong(separated[0]));
				
				if(separated[1]!=null && !separated[1].isEmpty())
				{
					pmc.setMCAP_of_the_Company(Double.parseDouble(separated[1]));
					
				}
				
				
				if(separated[2]!=null && !separated[2].isEmpty())
				{
					dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
				   key.setTrade_Date(dd);
				   pmc.setKey(key);
				}
				else
				{
					continue;
				}
				
				ArrayList<PmCap> pcap_lst = (ArrayList<PmCap>) ssn.createQuery(" from PmCap where Portfolio_Security_Code=? and Trade_Date=?").setLong(0, pmc.getKey().getPortfolio_Security_Code()).setDate(1, pmc.getKey().getTrade_Date() ).list();
				
					if(pcap_lst.size()>0)
					{
						pcap_lst.get(0).set_PmCap(pmc);
						ssn.update(pcap_lst.get(0));
					}
					else
					{
						ssn.save(pmc);
						db_save++;	
					}
				
				
				if(db_save%50==0)
				{
					ssn.getTransaction().commit();
					ssn.beginTransaction();
					ssn.flush();
					ssn.clear();
					db_save=1;
				}
				
				
				
     	    }
		}
		catch (Exception e) 
		{
		   e.printStackTrace();	
		}
		finally {
			
			
			ssn.getTransaction().commit();
			ssn.close();
			System.out.println("<<<<<-- Report Complete -->>>>>");
		}	 
	}

}
