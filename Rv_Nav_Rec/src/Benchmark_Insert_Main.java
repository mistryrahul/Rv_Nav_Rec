import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;

import controller.Benchmark_Hist;
import controller.Bm_Pk;
import sessionFactory.HIbernateSession;

public class Benchmark_Insert_Main {

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
			  	
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/bm_indices_return_august.ace"), "UTF-8");
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
					
					
					Benchmark_Hist bh = new Benchmark_Hist();
					Bm_Pk bpk = new Bm_Pk();
					
					
					bpk.setIndex_Code(Long.parseLong(separated[0]));
					
					if(separated[1]==null || separated[1].isEmpty())
					{
						continue;
					}
					else if(separated[1]!=null && !separated[1].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
						 bpk.setDte(dd);
					}
					
					bh.setKey(bpk);
					
					if(separated[2]!=null && !separated[2].isEmpty())
					{
						 
						 bh.setDayRet_1(Double.parseDouble(separated[2]));
					}
					
					if(separated[3]!=null && !separated[3].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[3].substring(0,10));
						 bh.setWeekDate_1(dd);
					}
					
					if(separated[4]!=null && !separated[4].isEmpty())
					{
						 
						 bh.setWeekClose_1(Double.parseDouble(separated[4]));
					}
					
					if(separated[5]!=null && !separated[5].isEmpty())
					{
						 
						 bh.setWeekRet_1(Double.parseDouble(separated[5]));
					}
					
					if(separated[6]!=null && !separated[6].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[6].substring(0,10));
						 bh.setMTHDate_1(dd);
					}
					
					if(separated[7]!=null && !separated[7].isEmpty())
					{
						 
						 bh.setMTHClose_1(Double.parseDouble(separated[7]));
					}
					
					if(separated[8]!=null && !separated[8].isEmpty())
					{
						 
						 bh.setMonthRet_1(Double.parseDouble(separated[8]));
					}
					
					if(separated[9]!=null && !separated[9].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[9].substring(0,10));
						 bh.setMTHDate_3(dd);
					}
					
					if(separated[10]!=null && !separated[10].isEmpty())
					{
						 
						 bh.setMTHClose_3(Double.parseDouble(separated[10]));
					}
					
					if(separated[11]!=null && !separated[11].isEmpty())
					{
						 
						 bh.setMonthRet_3(Double.parseDouble(separated[11]));
					}
					
					if(separated[12]!=null && !separated[12].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[12].substring(0,10));
						 bh.setMTHDate_6(dd);
					}
					
					if(separated[13]!=null && !separated[13].isEmpty())
					{
						 
						 bh.setMTHClose_6(Double.parseDouble(separated[13]));
					}
					
					if(separated[14]!=null && !separated[14].isEmpty())
					{
						 
						 bh.setMonthRet_6(Double.parseDouble(separated[14]));
					}
					
					
					
					
					if(separated[15]!=null && !separated[15].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[15].substring(0,10));
						 bh.setMTHDate_9(dd);
					}
					
					if(separated[16]!=null && !separated[16].isEmpty())
					{
						 
						 bh.setMTHClose_9(Double.parseDouble(separated[16]));
					}
					
					if(separated[17]!=null && !separated[17].isEmpty())
					{
						 
						 bh.setMonthRet_9(Double.parseDouble(separated[17]));
					}
					
					
					
					
					
					
					if(separated[18]!=null && !separated[18].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[18].substring(0,10));
						 bh.setDate_1YR(dd);
					}
					
					if(separated[19]!=null && !separated[19].isEmpty())
					{
						 
						 bh.setClose_1YR(Double.parseDouble(separated[19]));
					}
					
					if(separated[20]!=null && !separated[20].isEmpty())
					{
						 
						 bh.setRet_1YR(Double.parseDouble(separated[20]));
					}
					
					
					
					
					
					if(separated[21]!=null && !separated[21].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[21].substring(0,10));
						 bh.setDate_2YR(dd);
					}
					
					if(separated[22]!=null && !separated[22].isEmpty())
					{
						 
						 bh.setClose_2YR(Double.parseDouble(separated[22]));
					}
					
					if(separated[23]!=null && !separated[23].isEmpty())
					{
						 
						 bh.setRet_2YR(Double.parseDouble(separated[23]));
					}
					
					
					
					if(separated[24]!=null && !separated[24].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[24].substring(0,10));
						 bh.setDate_3YR(dd);
					}
					
					if(separated[25]!=null && !separated[25].isEmpty())
					{
						 
						 bh.setClose_3YR(Double.parseDouble(separated[25]));
					}
					
					if(separated[26]!=null && !separated[26].isEmpty())
					{
						 
						 bh.setRet_3YR(Double.parseDouble(separated[26]));
					}
					
					
					
					if(separated[27]!=null && !separated[27].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[27].substring(0,10));
						 bh.setDate_4YR(dd);
					}
					
					if(separated[28]!=null && !separated[28].isEmpty())
					{
						 
						 bh.setClose_4YR(Double.parseDouble(separated[28]));
					}
					
					if(separated[29]!=null && !separated[29].isEmpty())
					{
						 
						 bh.setRet_4YR(Double.parseDouble(separated[29]));
					}
					
					
					
					if(separated[30]!=null && !separated[30].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[30].substring(0,10));
						 bh.setDate_5YR(dd);
					}
					
					if(separated[31]!=null && !separated[31].isEmpty())
					{
						 
						 bh.setClose_5YR(Double.parseDouble(separated[31]));
					}
					
					if(separated[32]!=null && !separated[32].isEmpty())
					{
						 
						 bh.setRet_5YR(Double.parseDouble(separated[32]));
					}
					
					
					
					if(separated[33]!=null && !separated[33].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[33].substring(0,10));
						 bh.setIncDate(dd);
					}
					
					if(separated[34]!=null && !separated[34].isEmpty())
					{
						 
						 bh.setIncClose(Double.parseDouble(separated[34]));
					}
					
					if(separated[35]!=null && !separated[35].isEmpty())
					{
						 
						 bh.setIncRet(Double.parseDouble(separated[35]));
					}	
					
					
					
					if(separated[36]!=null && !separated[36].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[36].substring(0,10));
						 bh.setWeekDate_2(dd);
					}
					
					if(separated[37]!=null && !separated[37].isEmpty())
					{
						 
						 bh.setWeekClose_2(Double.parseDouble(separated[37]));
						
					}
					
					if(separated[38]!=null && !separated[38].isEmpty())
					{
						 
						 bh.setWeekRet_2(Double.parseDouble(separated[38]));
					}
					
					if(separated[39]!=null && !separated[39].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[39].substring(0,10));
						 bh.setWeekDate_3(dd);
					}
					
					if(separated[40]!=null && !separated[40].isEmpty())
					{
						 
						 bh.setWeekClose_3(Double.parseDouble(separated[40]));
					}
					
					
					
					if(separated[41]!=null && !separated[41].isEmpty())
					{
						 
						 bh.setWeekRet_3(Double.parseDouble(separated[41]));
					}
					
					if(separated[42]!=null && !separated[42].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[42].substring(0,10));
						 bh.setMTHDate_2(dd);
					}
					
					if(separated[43]!=null && !separated[43].isEmpty())
					{
						 
						 bh.setMTHClose_2(Double.parseDouble(separated[43]));
					}
					
					if(separated[44]!=null && !separated[44].isEmpty())
					{
						 
						 bh.setMonthRet_2(Double.parseDouble(separated[44]));
					}
					
					
					if(separated[45]!=null && !separated[45].isEmpty())
					{
						 dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[45].substring(0,10));
						 bh.setYTDDate(dd);
					}
					
					if(separated[46]!=null && !separated[46].isEmpty())
					{
						 
						 bh.setYTDNav(Double.parseDouble(separated[46]));
					}
					
					if(separated[47]!=null && !separated[47].isEmpty())
					{
						 
						 bh.setYTDRet(Double.parseDouble(separated[47]));
					}
					
					ArrayList<Benchmark_Hist> chk_bnchmrk = (ArrayList<Benchmark_Hist>) ssn.createQuery("from Benchmark_Hist where Index_Code=? and dte=?").setLong(0,bh.getKey().getIndex_Code()).setDate(1,bh.getKey().getDte()).list();
					
					System.out.println("Check--->>"+chk_bnchmrk.size());
					
					if(chk_bnchmrk.size()>0)
					{
						chk_bnchmrk.get(0).Benchmark_Hist_Copy(bh);
						ssn.update(chk_bnchmrk.get(0));
//						ssn.getTransaction().commit();
//				    	ssn.beginTransaction();
						db_save++;
					}
					else if(chk_bnchmrk.size()==0)
					{
						System.out.println("-------Coming Here-----");
						ssn.save(bh);
//						ssn.getTransaction().commit();
//				    	ssn.beginTransaction();
						db_save++;	
					}
					
					
					
					
					
					  if(db_save%2==0)
					    {
					    	ssn.getTransaction().commit();
					    	ssn.beginTransaction();
					    	db_save=1;
					    }
					
					
	     	    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
     		   ssn.getTransaction().commit();
			   ssn.close();
			   
			    System.out.println("<<<<<<---| Report Complete |----->>>>>>>");
			}

	}

}
