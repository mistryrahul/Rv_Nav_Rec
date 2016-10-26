import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import controller.*;

import controller.nav_hist;


public class ExpR_AvgM_ScA_Insert_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		double no_of_lines;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i=1;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		try
		{   

//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EXPENCERATIO.ace"), "UTF-8");
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_index_part.ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/SchemeISINMaster.ace"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			while (it.hasNext()) // if the file has lines 
     	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
				String[] separated = matcher.group(1).split("\\|");
						
				
				
//				 -----------------SCHEME INDEX-------------------------------
					Scheme_Index sa = new Scheme_Index();
					
					sa.setIndx(i++);
					
					sa.setScheme_code(Long.parseLong(separated[0]));
					
					if(separated[1]==null || separated[1].isEmpty())
						{
								
						}
						else
						{
							
							sa.setIndex_code(Long.parseLong(separated[1]));
						}
					
					ssn.save(sa);
					
					
//					if(separated[2]==null || separated[2].isEmpty())
//					{
//							
//					}
//					else
//					{
//						sa.setExfof(Double.parseDouble(separated[2]));
//					}
					
				
				
				
				
				
				
////				------------------------SCHEMEISIIN UPLOAD------------------------
//				Schemeisin_Model sim =new Schemeisin_Model();
//				
//				
//				sim.setIsin(separated[1]);
//				
//				if(separated[0]==null || separated[0].isEmpty())
//					{
//							
//					}
//					else
//					{
//						sim.setId(Integer.parseInt(separated[0]));
//					}
//				
//				
//								
//				
//				if(separated[2]==null || separated[2].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setScheme_code(Long.parseLong(separated[2]));
//				}
//				
//				if(separated[3]==null || separated[3].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setAmc_code(Long.parseLong(separated[3]));
//				}
//				
//				if(separated[4]==null || separated[4].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setNseSymbol(separated[4]);
//				}
//				
//				if(separated[5]==null || separated[5].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setSeries(separated[5]);
//				}
//				
//				if(separated[6]==null || separated[6].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setRTAScheme_code(separated[6]);
//				}
//				
//				if(separated[7]==null || separated[7].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setAMCSchemecode(separated[7]);
//				}
//				
//				if(separated[8]==null || separated[8].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setLongSchemeDescrip(separated[8]);
//				}
//				
//				if(separated[9]==null || separated[9].isEmpty())
//				{
//						
//				}
//				else
//				{
//				   sim.setShortSchemeDescrip(separated[9]);
//				}
//				
//				
//				
//				ssn.save(sim);
				
				
////				 ---------------SCHEME AUM-------------------------------
//				Scheme_Aum sa = new Scheme_Aum();
//				
//				sa.setId(i);
//				sa.setScheme_code(Long.parseLong(separated[0]));
//				
//				if(separated[1]==null || separated[1].isEmpty())
//					{
//							
//					}
//					else
//					{
//						java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
//						sa.setDay(dd);
//					}
//				if(separated[2]==null || separated[2].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setExfof(Double.parseDouble(separated[2]));
//				}
//				
//				if(separated[3]==null || separated[3].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setFof(Double.parseDouble(separated[3]));
//				}
//				
//				if(separated[4]==null || separated[4].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setTotal(Double.parseDouble(separated[4]));
//				}
//				
//				
//				ssn.save(sa);
				
				
//				 //--------------------Average Maturity------------------------//
//				Average_Maturity am = new Average_Maturity();
//				
//				am.setId(i);
//				am.setAmc_code(Long.parseLong(separated[0]));
//				am.setSchem_code(Long.parseLong(separated[1]));
//				
//				java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
//				
//				am.setDay(dd);
//				
//				
//				
//				if(separated[3]==null || separated[3].isEmpty())
//				{
//						
//				}
//				else
//				{
//			     	java.util.Date dd_1 = new SimpleDateFormat("M/dd/yyyy").parse(separated[3]);
//				
//				    am.setInv_end_dt(dd_1);
//				}
//				
//				
//				if(separated[4]==null || separated[4].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setAvg_mat_num(Double.parseDouble(separated[4]));
//				}
//			    
//				if(separated[5]==null || separated[5].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setAvg_mat_days(separated[5]);
//				}
//				
//				if(separated[6]==null || separated[6].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setMod_dur_num(Double.parseDouble(separated[6]));
//				}
//				
//				if(separated[7]==null || separated[7].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setMod_dur_days(separated[7]);
//				}
//				
//				if(separated[8]==null || separated[8].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setYtm(Double.parseDouble(separated[8]));
//				}
//				
//				
//				if(separated[9]==null || separated[9].isEmpty())
//				{
//						
//				}
//				else
//				{
//					am.setTurnover_ratio(Double.parseDouble(separated[9]));
//				}
//				
//				
//				am.setTr_mode(separated[10]);
//				
//				ssn.save(am);
				
				
				
////				  //------- Expence-Ratio-TABLE UPLOADING //---------
//			    ExpenceRatio er = new ExpenceRatio();
//				
//			    
//			    er.setAmc_code(Long.parseLong(separated[0]));
//			    
//			    er.setScheme_code(Long.parseLong(separated[1]));
//			    
//			    java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
//			    
//			    er.setDay(dd);
//			    
//			    if(separated[3]==null || separated[3].isEmpty())
//			    {
//			    	er.setEx_ratio(Double.parseDouble(ex_ratio));
//			    }
//			    else
//			    {			    			    	
//			    	er.setEx_ratio(Double.parseDouble(separated[3]));	
//			    	ex_ratio=separated[3];
//			    }
//			    
//			    
//                er.setId(i);
//                
//                
//                scheme_cd=separated[1];
//                amc_cd =separated[0];
//                dt=separated[2];
//			    
//				ssn.save(er);
				
//				ssn.flush();
//				ssn.clear();
				
				
//				System.out.println("Scheme_code-->"+separated[0]);
				//System.out.println("Date-->"+separated[1]);
				if (i_i%50==0)
				{
					  ssn.getTransaction().commit(); 
					  ssn.beginTransaction();
					  ssn.flush();
				      ssn.clear();
				      
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
