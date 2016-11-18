import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.ExpenceRatio;
import controller.Scheme_Aum;
import controller.Scheme_Paum;
import debt_Controller.Avg_maturity;
import debt_Controller.Pk_generic;

public class ExR_AvgM_SchAum_Mass_Inser_Main 
{
    public static void main(String[] args)
    {
    	int c=0; // temp var in main loop 
    	double no_of_lines;
		String tmp_val;
		java.util.Date dd_2=null;
		java.util.Date dd_1=null;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		try
		{   
			
			for( c=20;c>=1;c--)   // main loop( loop size vary table to table)
			{
				
	
			
			

//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EXPENCERATIO.ace"), "UTF-8");
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/DB_Upload/aum/scheme_aum ("+c+").txt"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/scheme_paum.ace"), "UTF-8"); //scheme_paum
			
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/DB_Upload/avg_maturity/avg_maturity ("+c+").txt"), "UTF-8"); //Avg_Maturity Ratio		
				
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/expenceratio.ace"), "UTF-8"); //Expence Ratio
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/SchemeISINMaster.ace"), "UTF-8");
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			
			int tmp_year=0;
			int tmp_mnth=0;
			java.util.Date tmp_dd = null;
			
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			System.out.println("File NO-->>"+c);
			
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
					
//				---------------Avg_Maturity LATEST (Current One)-------------------------------
				
				
				
//				matcher = pattern.matcher(it.nextLine());
//				matcher.find();
//				
////				System.out.println(matcher.group(1));
//				
//				
//				 separated = matcher.group(1).split("\\|");
			
				 

//				 System.out.print(separated[0]+"\t");
//				 System.out.print(separated[1]+"\t");
//				 System.out.print(separated[2]+"\t");
//				 System.out.print(separated[3]+"\t");
//				 System.out.println();
				 
				 
				 Avg_maturity  dc = new Avg_maturity();
				
				 dc.setAmc_code(Long.parseLong(separated[0]));
				
//				   System.out.println("AMC-CODE-->>"+separated[0]);
				 
				 
				Pk_generic pkey = new Pk_generic();
				pkey.setScheme_code(Long.parseLong(separated[1]));         
				
//				System.out.println("SchemeCode-CODE-->>"+separated[1]);
				
				
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
//					System.out.print("7-"+separated[7]+"\t");
					dc.setMod_dur_days(separated[7]);
				}
				
				
			   if(separated[8]!=null && !separated[8].isEmpty())
			   {
				dc.setYtm(Double.parseDouble(separated[8]));   
//				System.out.print("8-"+separated[8]+"\t");
			   }
				
				
				if(separated[9] != null && !separated[9].isEmpty() )
				{
					if(separated[9]!="NULL" || (separated[9].equals("NULL")!=true))
					{
//						System.out.print("9-"+separated[9]+"\t"); 
						dc.setTurnover_ratio(Double.parseDouble(separated[9]));	
					}
					
				}
				
				
				
				
				ArrayList<Avg_maturity> avg_mat_lst = (ArrayList<Avg_maturity>) ssn.createQuery("from Avg_maturity where scheme_code=? and day=?").setLong(0,dc.getKey().getScheme_code() ).setDate(1, dc.getKey().getDay()).list();
				
				
				if(avg_mat_lst.size()>0)
				{
					
//					  if(avg_mat_lst.get(0).getMod_dur_num()!=0)
//					  {
//						  avg_mat_lst.get(0).setMod_dur_num(dc.getMod_dur_num());
//					  }
					
				}
				else
				{
					ssn.save(dc);
					i_i++;
				}
				
				
				
     				
     					
						
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//				---------------SCHEME PAUM LATEST (Current One)-------------------------------
				Scheme_Paum sa = new Scheme_Paum();
				Pk_generic sa_pk =new Pk_generic();
				
				sa_pk.setScheme_code(Long.parseLong(separated[0]));
				
				scheme_cd=separated[0]; // for error showing
				
				if(separated[1]==null || separated[1].isEmpty())
					{
							
					}
					else
					{   
						tmp_year = Integer.parseInt(separated[1].substring(0,4));
						tmp_mnth = Integer.parseInt(separated[1].substring(4,6));
						
						if(tmp_mnth==1 && tmp_mnth==3 && tmp_mnth==5 && tmp_mnth==7 && tmp_mnth==8 && tmp_mnth==10 && tmp_mnth==12)
						{
							tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 31);
						}
						else if(tmp_mnth==4)
						{
							if(tmp_year%4==0  || (tmp_year%100==0 && tmp_year%400==0))
							{
								tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 29);
							}							
							else
							{
								tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 28);
							}
						}
						else
						{
							tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 30);
						}
						
						
						sa_pk.setDay(tmp_dd);
				   }
				if(separated[2]==null || separated[2].isEmpty())
				{
						
				}
				else
				{
					sa.setAmc_code(Integer.parseInt(separated[2]));
				}
				
				if(separated[3]==null || separated[3].isEmpty())
				{
						
				}
				else
				{
					sa.setAvg_aum(Double.parseDouble(separated[3]));
				}
				
				
				sa.setKey(sa_pk);
				
				
				
				ArrayList<Scheme_Paum> schme_lst = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0,sa.getKey().getScheme_code() ).setDate(1, sa.getKey().getDay()).list();
				
//				System.out.println("LIST SIZE_____----->>>"+schme_lst.size());
				
				if(schme_lst.size()>0)
				{
//					 System.out.println("Prev exFOF-->>"+schme_lst.get(0).getExfof());
//					 System.out.println("New FOF--->>"+sa.getExfof());
//					 
//					 System.out.println("COMpare-->>"+(schme_lst.get(0).getExfof()!=0));
					 
					 
					if(schme_lst.get(0).getAvg_aum()!=0)
					{
//						System.out.println("IN HERE----");
						
						schme_lst.get(0).setAvg_aum(sa.getAvg_aum());
						schme_lst.get(0).setAmc_code(sa.getAmc_code());
						
//						schme_lst.get(0).setFof(sa.getFof());
//						schme_lst.get(0).setScheme_code(sa.getScheme_code());
//						schme_lst.get(0).setTotal(sa.getTotal());
						
						ssn.saveOrUpdate(schme_lst.get(0));
					}
				}
				else
				{
					ssn.save(sa);	
				}
				
				
				
				
////				---------------Expence Ration Latest (Current one)-------------------------------
//				ExpenceRatio sa = new ExpenceRatio();
//				Pk_generic sa_pk =new Pk_generic();
//				
//				
////			    sa.setId(i++);
//				sa.setAmc_code(Long.parseLong(separated[0]));
////				sa.setScheme_code(Long.parseLong(separated[1]));
//				
//				sa_pk.setScheme_code(Long.parseLong(separated[1]));
//				
//				scheme_cd=separated[1]; // for error showing
//				
//				if(separated[2]==null || separated[2].isEmpty())
//					{
//							
//					}
//					else
//					{   dt=separated[2]; // for error catching 
//					
//						java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
//						sa_pk.setDay(dd);
////						sa.setDay(dd);
//				    }
//				if(separated[3]==null || separated[3].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setEx_ratio(Double.parseDouble(separated[3]));
//				}
//							
//				
//				sa.setKey(sa_pk);
//				
//				
//				
//				ArrayList<ExpenceRatio> schme_lst = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day=?").setLong(0,sa.getKey().getScheme_code() ).setDate(1, sa.getKey().getDay()).list();
//				
////				System.out.println("LIST SIZE_____----->>>"+schme_lst.size());
//				
//				if(schme_lst.size()>0)
//				{
////					 System.out.println("Prev exFOF-->>"+schme_lst.get(0).getExfof());
////					 System.out.println("New FOF--->>"+sa.getExfof());
////					 
////					 System.out.println("COMpare-->>"+(schme_lst.get(0).getExfof()!=0));
//					 
//					 
////					if(schme_lst.get(0).getEx_ratio()!=0)
////					{
//////						System.out.println("IN HERE----");
////						
////						schme_lst.get(0).setEx_ratio(sa.getEx_ratio());
////						schme_lst.get(0).setAmc_code(sa.getAmc_code());
////						
//////						schme_lst.get(0).setFof(sa.getFof());
//////						schme_lst.get(0).setScheme_code(sa.getScheme_code());
//////						schme_lst.get(0).setTotal(sa.getTotal());
////						
////						ssn.saveOrUpdate(schme_lst.get(0));
////					}
//				}
//				else
//				{
//					ssn.save(sa);	
//				}
//				
				
				
				
				
				
				
				
				
				
				
				
				
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
//				
//				ArrayList<Scheme_Aum> schme_lst = (ArrayList<Scheme_Aum>) ssn.createQuery("from Scheme_Aum where scheme_code=? and day=?").setLong(0,sa.getScheme_code() ).setDate(1, sa.getDay()).list();
//				
////				System.out.println("LIST SIZE_____----->>>"+schme_lst.size());
//				
//				if(schme_lst.size()>0)
//				{
////					 System.out.println("Prev exFOF-->>"+schme_lst.get(0).getExfof());
////					 System.out.println("New FOF--->>"+sa.getExfof());
////					 
////					 System.out.println("COMpare-->>"+(schme_lst.get(0).getExfof()!=0));
//					 
//					 
//					if(schme_lst.get(0).getExfof()!=0)
//					{
////						System.out.println("IN HERE----");
//						
//						schme_lst.get(0).setDay(sa.getDay());
//						schme_lst.get(0).setExfof(sa.getExfof());
//						schme_lst.get(0).setFof(sa.getFof());
//						schme_lst.get(0).setScheme_code(sa.getScheme_code());
//						schme_lst.get(0).setTotal(sa.getTotal());
//						
//						ssn.saveOrUpdate(schme_lst.get(0));
//					}
//				}
//				else
//				{
//					ssn.save(sa);	
//				}
				
				
				
				
				
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
				
				if (i_i%5==0)
				{
					  ssn.getTransaction().commit(); 
					  ssn.beginTransaction();
//					  ssn.flush();
//				      ssn.clear();
				      
				      i_i=0;
				}
				i_i++;
				i++;
     	    }
			
			
			
			
			}// end of main loop
			
			System.out.println("<--- Complete File Uploaded ---->");
		}
		catch(Exception e)
		{
			
			System.out.println("VALUE oF i==>"+i); 
//			System.out.println("DATE-->"+dt);
			System.out.println("Scheme Code-->"+scheme_cd);
			
//			System.out.println("Sheet no-->>"+c);
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
