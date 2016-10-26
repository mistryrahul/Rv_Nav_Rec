import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;

import controller.Company_Master;

public class Ace_Csv {

	public static void main(String[] args) 
	{
	 
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		Session ssn = null;
		String tmp_val=null;
		int i=1,index=99;
		ArrayList<Long> Ind_code_list = new ArrayList<Long>(); 
		ArrayList<ArrayList<Company_Master>> list_to_print = new ArrayList<ArrayList<Company_Master>>(); 
		
		//Output File Destination 
		
		
		try
		{
			PrintWriter writer = new PrintWriter("/home/rv/Desktop/Company_Master.csv", "UTF-8");
			
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/mf_companymaster.ace"), "UTF-8");
			
			
			
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
					
//					System.out.println("Size-->>"+separated.length);
//					String row = matcher.group(1).replace(',', '.');
//					
//					row = row.replace('|', ',');
					
//					writer.println(separated[0].replace(',', '.').trim()+","+separated[1].replace(',', '.').trim()+","+separated[2].replace(',', '.').trim()+","+separated[3].replace(',', '.').trim()+","+separated[4].replace(',', '.').trim()+","+separated[5].replace(',', '.').trim()+","+separated[6].replace(',', '.').trim()+","+separated[7].replace(',', '.').trim()+","+separated[8].replace(',', '.').trim()+","+separated[9].replace(',','.').trim());
					
					
	     	    }
				
//				writer.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("<<<<---| Report Complete |---->>>");
		}
  
	}

}
