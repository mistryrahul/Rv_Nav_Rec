package debt_Main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.nav_hist;
import debt_Controller.Avg_maturity;
import debt_Controller.Pk_generic;

public class Insert_Data_Bean {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		
		double no_of_lines;
		String scheme_cd="", dt="";
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		int db_flg=0;
		int ii=1;
		
		java.util.Date dd_1 = null;
		java.util.Date dd_2 = null;
		String[] separated = null;
		
		Avg_maturity dc = null;
		Pk_generic pkey = null;
		try
		{   
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/avg_maturity.ace"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			while (it.hasNext()) // if the file has lines 
     	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
				
//				System.out.println(matcher.group(1));
				
				
				 separated = matcher.group(1).split("\\|");
			
				 

//				 System.out.print(separated[0]+"\t");
//				 System.out.print(separated[1]+"\t");
//				 System.out.print(separated[2]+"\t");
//				 System.out.print(separated[3]+"\t");
//				 System.out.println();
				 
				 
				 dc = new Avg_maturity();
				
				 dc.setAmc_code(Long.parseLong(separated[0]));
				
				 
				 
				pkey = new Pk_generic();
				pkey.setScheme_code(Long.parseLong(separated[1]));         
				
				dd_1 = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
				
//				System.out.println(dd_1);
				pkey.setDay(dd_1);
				
				
				dc.setKey(pkey);
				
				if(separated[3]!=null && !separated[3].isEmpty())
				{
					dd_2 = new SimpleDateFormat("M/dd/yyyy").parse(separated[3]);
//					System.out.println(dd_2);
					
					dc.setInv_end_date(dd_2);	
				}
				
				
				if(separated[4] != null && !separated[4].isEmpty())
				{
//					System.out.print("4-"+separated[4]+"\t");
					dc.setAvg_mat_num(Double.parseDouble(separated[4]));
				}
				
				

				
				if(separated[5]!= null && !separated[5].isEmpty())
				{
//					System.out.print("5-"+separated[5]+"\t");
					dc.setAvg_mat_days(separated[5]);
				}
				
				
				if(separated[6]!= null && !separated[6].isEmpty())
				{
//					System.out.print("6-"+separated[6]+"\t");
					dc.setMod_dur_num(Double.parseDouble(separated[6]));
				}
				
				
				if(separated[7] != null && !separated[7].isEmpty())
				{
					System.out.print("7-"+separated[7]+"\t");
					dc.setMod_dur_days(separated[7]);
				}
				
				
			   if(separated[8]!=null && !separated[8].isEmpty())
			   {
				dc.setYtm(Double.parseDouble(separated[8]));   
				System.out.print("8-"+separated[8]+"\t");
			   }
				
				
				if(separated[9] != null && !separated[9].isEmpty() )
				{
					if(separated[9]!="NULL" || (separated[9].equals("NULL")!=true))
					{
						System.out.print("9-"+separated[9]+"\t"); 
						dc.setTurnover_ratio(Double.parseDouble(separated[9]));	
					}
					
				}
				
				
				
				
     					ssn.save(dc);
						db_flg++;
						ii++;
				
				
				
				if (db_flg%50==0)
				{
					  
//					  ssn.flush();
//					  ssn.clear();
				      ssn.getTransaction().commit(); 
				      ssn.beginTransaction();
				      db_flg=0;
				}
				
				
     	    }
		}
		catch(Exception e)
		{
			System.out.println("Error at Line--->>>"+ii);
//			System.out.println("ERROR IN DATA");
//			System.out.println(separated[0]+"\n");
//			System.out.println(separated[1]+"\n");
//			System.out.println(separated[2]+"\n");
//			System.out.println(separated[3]+"\n");
//			System.out.println(separated[4]+"\n");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("<---Upload Complete---->");
			ssn.getTransaction().commit();
			ssn.close();
		}
		
		
		
	}

}
