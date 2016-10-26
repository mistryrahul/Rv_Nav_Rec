import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;

import controller.Company_Master;
import controller.Industry_Master;
import sessionFactory.HIbernateSession;

public class Industry_Master_Insert_Main {

	public static void main(String[] args) 
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
		  	
		LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Industrymaster.ace"), "UTF-8");
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
				
				Industry_Master im = new Industry_Master();
				im.setInd_code(Long.parseLong(separated[0]));
				
				if(separated[1]!=null && !separated[1].isEmpty())
				{
					 im.setIndustry(separated[1]);
				}
				
				if(separated[2]!=null && !separated[2].isEmpty())
				{
					 im.setInd_ShortName(separated[2]);
				}
				
				if(separated[3]!=null && !separated[3].isEmpty())
				{
					 im.setSector(separated[3]);
				}
				
				
				ssn.save(im);
				db_save++;
				
				
				
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
