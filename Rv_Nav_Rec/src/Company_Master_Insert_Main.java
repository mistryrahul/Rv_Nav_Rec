import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.auth.login.Configuration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controller.Company_Master;
import sessionFactory.HIbernateSession;

public class Company_Master_Insert_Main {
	
	 public static void main(String[]  args)
	 {
		 double db_save=0;
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
			  	
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/mf_companymaster.ace"), "UTF-8");
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Scheme_details_full.ace"), "UTF-8");

			
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
				
					Company_Master cm = new Company_Master();
					
					cm.setFincode(Long.parseLong(separated[0]));
					
					if(separated[1]!=null && !separated[1].isEmpty())
						{
							cm.setSCRIPCODE(separated[1]);
						}
					
					if(separated[2]!=null && !separated[2].isEmpty())
					{
						cm.setSYMBOL(separated[2]);
					}
					
					if(separated[3]!=null && !separated[3].isEmpty())
					{
						cm.setCOMPNAME(separated[3]);
					}
					if(separated[4]!=null && !separated[4].isEmpty())
					{
						cm.setS_NAME(separated[4]);
					}
					if(separated[5]!=null && !separated[5].isEmpty())
					{
						cm.setIND_CODE(Integer.parseInt(separated[5]));
					}
					if(separated[6]!=null && !separated[6].isEmpty())
					{
						cm.setInd_Name(separated[6]);
					}
					if(separated[7]!=null && !separated[7].isEmpty())
					{
						cm.setISIN(separated[7]);
					}
					if(separated[8]!=null && !separated[8].isEmpty())
					{
						cm.setStatus(separated[8]);
					}
					if(separated[9]!=null && !separated[9].isEmpty())
					{
						cm.setEq_mf(separated[9]);
					}
					if(separated[10]!=null && !separated[10].isEmpty())
					{
						cm.setUPD_FLAG(separated[10]);
					}
					
					ssn.save(cm);
					save_flg++;
					
					
					
					
					  if(save_flg%50==0)
					    {
					    	ssn.getTransaction().commit();
					    	ssn.beginTransaction();
					    	save_flg=1;
					    }
	     	    }	
				
				
			}
			catch (Exception e) 
			{
				e.printStackTrace();	
			}
			finally 
			{	
				ssn.getTransaction().commit();
				ssn.close();
				System.out.println("<<<<<<<<<--Upload COmplete------>>>>>>>>>");
				
			}
	 }

}
