import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.nav_hist;


//for uploading huge data set into DB
public class mn {      

	
	public static void main(String[] args) 
	{
		double no_of_lines;
		String scheme_cd="", dt="";
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		try
		{   
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/navhist.ace"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			while (it.hasNext()) // if the file has lines 
     	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
				String[] separated = matcher.group(1).split("\\|");
						
				nav_hist nb = new nav_hist();
				
				nb.setScheme_code(Integer.parseInt(separated[0]));
				//nb.setNav_date(new java.sql.Date( new SimpleDateFormat("yyyy-mm-dd").parse(separated[1]).getTime()));
				
//				java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
				
				java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[1]);
				
				//System.out.println("SQl DAte After Conversion-->"+new java.sql.Date(dd.getTime()));
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//System.out.println("DATe Actual-->"+separated[1].substring(0, 10));
				//System.out.println("DATe Parsed-->>"+dd);
				
				nb.setNav_date(new java.sql.Date(dd.getTime()));
			   
								
				
				//System.out.println("DATe-->"+new java.sql.Date(dd.getTime()));
				//nb.setNav_date(new java.sql.Date( new java.util.Date(separated[1]).getTime() ));
				if(separated[2] != null && !separated[2].isEmpty())
				{
					nb.setNavrs(Double.parseDouble(separated[2]));	
				}
				else
				{
					nb.setNavrs(0.00);
				}
				if(separated[3] != null && !separated[3].isEmpty())
				{
					nb.setAdjnavrs(Double.parseDouble(separated[3]));
				}
				else
				{
					nb.setAdjnavrs(0.00);
				}
				
				if(separated[4] != null && !separated[4].isEmpty())
				{
					nb.setRepurprice(Double.parseDouble(separated[4]));	
				}
				else
				{
					nb.setRepurprice(0.00);
				}
				if(separated[5] != null && !separated[5].isEmpty())
				{
					nb.setSaleprice(Double.parseDouble(separated[5]));	
				}
				else
				{
					nb.setSaleprice(0.00);
				}
				
//				if(separated[6] != null && !separated[6].isEmpty())
//				{
//					nb.setAdjnavrs(Double.parseDouble(separated[6]));
//				}
//				else
//				{
//					nb.setAdjnavrs(0.00);
//				}
				dt=separated[1];
				scheme_cd=separated[0];
				
				    
				nb.setId(i);
				
				//ssn.merge(nb); 
				ssn.save(nb);
				
//				ssn.flush();
//				ssn.clear();
				
				
//				System.out.println("Scheme_code-->"+separated[0]);
				//System.out.println("Date-->"+separated[1]);
				if (i_i%5000==0)
				{
					  ssn.flush();
				      ssn.clear();
				      ssn.getTransaction().commit(); 
				      ssn.beginTransaction();
				      i_i=0;
				}
				i_i++;
				i++;
     	    }
			
			System.out.println("<---Upload Complete---->");
			
			
			
			
			
		}
		catch(Exception e)
		{
			
			System.out.println("VALUE oF i==>"+i); 
			System.out.println("DATE-->"+dt);
			System.out.println("Scheme Code-->"+scheme_cd);
			e.printStackTrace();
		}
		finally
		{
			ssn.getTransaction().commit();   
			ssn.close();
		}
		
		
		
		
		
		

//	   
	   
	   
		
		

	}

}
