import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.nav_hist;
import controller.nav_hist_updater;
import controller.nav_hist_updator_PK;

public class Insert_NavHistFull_Updates {

	public static void main(String[] args) 
	{
	 
		double no_of_lines;
		String scheme_cd="", dt="";
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		int db_save=1;
		long i= 0;  // make this the last id after each operation
		int i_i=1;
		Session ssn = null;
		try
		{   
//			nav_hist_updater nb;
//			nav_hist_updator_PK key;
			
			
			
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/navhist/navhist (2).ace"), "UTF-8");
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/navhist_till_august_20.ace"), "UTF-8");
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/navhist.ace"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			ArrayList<Long> max_id_lst =  (ArrayList<Long>) ssn.createQuery("select MAX(id) from nav_hist_full").list();
			i = max_id_lst.get(0);
			
			i = i+1;
			
			while (it.hasNext()) // if the file has lines 
     	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
				String[] separated = matcher.group(1).split("\\|");
						
//				key = new nav_hist_updator_PK();
//				nb = new nav_hist_updater();
				
				nav_hist nb = new nav_hist();
				
//				key.setScheme_code(Integer.parseInt(separated[0]));
				
				nb.setScheme_code(Integer.parseInt(separated[0]));
				
				//nb.setNav_date(new java.sql.Date( new SimpleDateFormat("yyyy-mm-dd").parse(separated[1]).getTime()));
				
//				java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
				
				java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[1]);
				
				//System.out.println("SQl DAte After Conversion-->"+new java.sql.Date(dd.getTime()));
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//System.out.println("DATe Actual-->"+separated[1].substring(0, 10));
				//System.out.println("DATe Parsed-->>"+dd);
				
//				key.setNav_date(new java.sql.Date(dd.getTime()));
			    
				nb.setNav_date(new java.sql.Date(dd.getTime()));
								
				nb.setId(i);
				
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
				
//				nb.setKey(key);
				
				
				
				
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
				
//				    "insert into nav_hist_updater select * from nav_hist_full"
			
//				ArrayList<controller.nav_hist_updater> nav_hist_lst = (ArrayList<nav_hist_updater>) ssn.createQuery("from nav_hist_updater where key.scheme_code=? and key.nav_date=?").setLong(0, nb.getScheme_code()).setDate(1, nb.getNav_date()).list();

				ArrayList<controller.nav_hist> nav_hist_lst = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where scheme_code=? and nav_date=?").setLong(0, nb.getScheme_code()).setDate(1, nb.getNav_date()).list();
				
//				ArrayList<controller.nav_hist_updater> nav_hist_lst = (ArrayList<nav_hist_updater>) ssn.createQuery("from nav_hist_updater where key.scheme_code=? and key.nav_date=?").setLong(0, nb.getKey().getScheme_code()).setDate(1, nb.getKey().getNav_date()).list();
				
				if(nav_hist_lst.size() > 0)
				{
			         		
				}
				else
				{
					ssn.save(nb);	
					db_save++;
                    
					i++;
					
//                    System.out.println("<<<<----  (*) ------------- (*)  ----->>>>");
					System.out.println("Getting Saved...");
				}
				System.out.println(i_i);
				//ssn.merge(nb); 
				
				
//				ssn.flush();
//				ssn.clear();
				
				
//				System.out.println("Scheme_code-->"+separated[0]);
				//System.out.println("Date-->"+separated[1]);
				if (db_save%50==0)
				{
					  
				      ssn.getTransaction().commit(); 
				      ssn.beginTransaction();
				      ssn.flush();
				      ssn.clear();
				      db_save=1;
				}
				i_i++;
//				i++;
     	    }
			
			
			
			
			
			
			
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
			System.out.println("<---Update Complete---->");
		}
  
	}

}
