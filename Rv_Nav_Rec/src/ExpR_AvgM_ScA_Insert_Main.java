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
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;

import controller.*;
import debt_Controller.Pk_generic;


public class ExpR_AvgM_ScA_Insert_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		double no_of_lines;
		int tmp_year=0,tmp_mnth=0;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		Date tmp_dd;
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i=1;  // make this the last id after each operation
		int db_save=1;
		Session ssn = null;
		try
		{   

//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EXPENCERATIO.ace"), "UTF-8");
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_index_part.ace"), "UTF-8");
//			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/scheme_aum_april_octobor_20.ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/scheme_aum/scheme_aum (7).ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/SchemeISINMaster.ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/scheme_paum_oct_20.ace"), "UTF-8");
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/mf_portfolio_new/mf_portfolio_new (5).ace"), "UTF-8");
			
			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/portfolio_file_parts/port_folio_part_10.ace"), "UTF-8");
			
			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/updated_data_dump/mf_portfolio.ace"), "UTF-8");

//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/expenceratio_sept_to_oct_20.ace"), "UTF-8");
			
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
			ssn.beginTransaction();
			
			
			
////			FOR SCHEM_AUM
//			ArrayList<Long> max_id_lst =  (ArrayList<Long>) ssn.createQuery("select MAX(id) from Scheme_Aum").list();
//			
//			
//			
//			
//			
//			i=max_id_lst.get(0);
			
			
			while (it.hasNext()) // if the file has lines 
     	    {

				
				matcher = pattern.matcher(it.nextLine());
				matcher.find();
				String[] separated = matcher.group(1).split("\\|");
						
				
////			 -----------------MF_PORT_FOLIO_NEW(UPDATED)-------------------------------				
				Mf_portfolio_New mfp = new Mf_portfolio_New();
				MF_portfolio_pk key = new MF_portfolio_pk();
				
				
				if(separated[0]!=null && !separated[0].isEmpty())
				{
					 key.setScheme_code(Long.parseLong(separated[0]));
				}
				if(separated[1]!=null && !separated[1].isEmpty())
				{
//					java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
					java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[1]);
					 key.setInvdate(dd);
				}
				if(separated[2]!=null && !separated[2].isEmpty())
				{
//					java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
					java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
					 mfp.setInv_end_date(dd);
				}
				if(separated[3]!=null && !separated[3].isEmpty())
				{
					 key.setSrno(Long.parseLong(separated[3]));
				}
				
				mfp.setKey(key);
				
				if(separated[4]!=null && !separated[4].isEmpty())
				{
					 mfp.setFincode(Long.parseLong(separated[4]));
				}
				
				if(separated[5]!=null && !separated[5].isEmpty())
				{
					 mfp.setAsect_code(Long.parseLong(separated[5]));
				}
				
				if(separated[6]!=null && !separated[6].isEmpty())
				{
					 mfp.setSect_code(Long.parseLong(separated[6]));
				}
				
				if(separated[7]!=null && !separated[7].isEmpty())
				{
					 mfp.setNoshares(Double.parseDouble(separated[7]));
				}
				
				if(separated[8]!=null && !separated[8].isEmpty())
				{
					 mfp.setMktval(Double.parseDouble(separated[8]));
				}
				
				if(separated[9]!=null && !separated[9].isEmpty())
				{
					 mfp.setAum(Double.parseDouble(separated[9]));
				}
				if(separated[10]!=null && !separated[10].isEmpty())
				{
					 mfp.setHoldpercentage(Double.parseDouble(separated[10]));
				}
				if(separated[11]!=null && !separated[11].isEmpty())
				{
					 mfp.setCompname(separated[11]);
				}
				if(separated[12]!=null && !separated[12].isEmpty())
				{
					 mfp.setSect_name(separated[12]);
				}
				if(separated[13]!=null && !separated[13].isEmpty())
				{
					 mfp.setAsect_name(separated[13]);
				}
				if(separated[14]!=null && !separated[14].isEmpty())
				{
					 mfp.setRating(separated[14]);
				}
				
				
				ArrayList<Mf_portfolio_New> portfolio_lst = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code=? and invdate=? and srno=?").setLong(0,key.getScheme_code()).setDate(1, key.getInvdate()).setLong(2,key.getSrno()) .list();
                 
				if(portfolio_lst.size()>0)
				{
				
				}
				else
				{
					ssn.save(mfp);
					db_save++;
				}
				
				
				
				
				
				
				
				
				
////				 -----------------SCHEME INDEX-------------------------------
//					Scheme_Index sa = new Scheme_Index();
//					
//					sa.setIndx(i++);
//					
//					sa.setScheme_code(Long.parseLong(separated[0]));
//					
//					if(separated[1]==null || separated[1].isEmpty())
//						{
//								
//						}
//						else
//						{
//							
//							sa.setIndex_code(Long.parseLong(separated[1]));
//						}
//					
//					ssn.save(sa);
//					
					
//					if(separated[2]==null || separated[2].isEmpty())
//					{
//							
//					}
//					else
//					{
//						sa.setExfof(Double.parseDouble(separated[2]));
//					}
					
				
				
				
				
//////			---------------ExpenceRatio Latest (Current one)-------------------------------
//			ExpenceRatio sa = new ExpenceRatio();
//			Pk_generic sa_pk =new Pk_generic();
//			
//			
////		    sa.setId(i++);
//			sa.setAmc_code(Long.parseLong(separated[0]));
////			sa.setScheme_code(Long.parseLong(separated[1]));
//			
//			sa_pk.setScheme_code(Long.parseLong(separated[1]));
//			
//			scheme_cd=separated[1]; // for error showing
//			
//			if(separated[2]==null || separated[2].isEmpty())
//				{
//						
//				}
//				else
//				{   dt=separated[2]; // for error catching 
//				
//					java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[2]);
//					sa_pk.setDay(dd);
////					sa.setDay(dd);
//			    }
//			if(separated[3]==null || separated[3].isEmpty())
//			{
//					
//			}
//			else
//			{
//				sa.setEx_ratio(Double.parseDouble(separated[3]));
//			}
//						
//			
//			sa.setKey(sa_pk);
//			
//			
//			
//			ArrayList<ExpenceRatio> schme_lst = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day=?").setLong(0,sa.getKey().getScheme_code() ).setDate(1, sa.getKey().getDay()).list();
//			
////			System.out.println("LIST SIZE_____----->>>"+schme_lst.size());
//			
//			if(schme_lst.size()>0)
//			{
////				 System.out.println("Prev exFOF-->>"+schme_lst.get(0).getExfof());
////				 System.out.println("New FOF--->>"+sa.getExfof());
////				 
////				 System.out.println("COMpare-->>"+(schme_lst.get(0).getExfof()!=0));
//				 
//				 
////				if(schme_lst.get(0).getEx_ratio()!=0)
////				{
//////					System.out.println("IN HERE----");
////					
////					schme_lst.get(0).setEx_ratio(sa.getEx_ratio());
////					schme_lst.get(0).setAmc_code(sa.getAmc_code());
////					
//////					schme_lst.get(0).setFof(sa.getFof());
//////					schme_lst.get(0).setScheme_code(sa.getScheme_code());
//////					schme_lst.get(0).setTotal(sa.getTotal());
////					
////					ssn.saveOrUpdate(schme_lst.get(0));
////				}
//			}
//			else
//			{
//				ssn.save(sa);	
//				db_save++;
//			}
				
				
				
				
				
				
				
				
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
				
				
////				---------------SCHEME PAUM LATEST (Current One)-------------------------------
//				Scheme_Paum sa = new Scheme_Paum();
//				Pk_generic sa_pk =new Pk_generic();
//				
//				sa_pk.setScheme_code(Long.parseLong(separated[0]));
//				
//				scheme_cd=separated[0]; // for error showing
//				
//				if(separated[1]==null || separated[1].isEmpty())
//					{
//							
//					}
//					else
//					{   
//						tmp_year = Integer.parseInt(separated[1].substring(0,4));
//						tmp_mnth = Integer.parseInt(separated[1].substring(4,6));
//						
//						if(tmp_mnth==1 && tmp_mnth==3 && tmp_mnth==5 && tmp_mnth==7 && tmp_mnth==8 && tmp_mnth==10 && tmp_mnth==12)
//						{
//							tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 31);
//						}
//						else if(tmp_mnth==4)
//						{
//							if(tmp_year%4==0  || (tmp_year%100==0 && tmp_year%400==0))
//							{
//								tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 29);
//							}							
//							else
//							{
//								tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 28);
//							}
//						}
//						else
//						{
//							tmp_dd = new Date((tmp_year-1900), (tmp_mnth-1), 30);
//						}
//						
//						
//						sa_pk.setDay(tmp_dd);
//				   }
//				if(separated[2]==null || separated[2].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setAmc_code(Integer.parseInt(separated[2]));
//				}
//				
//				if(separated[3]==null || separated[3].isEmpty())
//				{
//						
//				}
//				else
//				{
//					sa.setAvg_aum(Double.parseDouble(separated[3]));
//				}
//				
//				sa.setKey(sa_pk);
//				
//				
//				ArrayList<Scheme_Paum> schme_lst = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0,sa.getKey().getScheme_code() ).setDate(1, sa.getKey().getDay()).list();
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
//					if(schme_lst.get(0).getAvg_aum()!=0)
//					{
////						System.out.println("IN HERE----");
//						
//						schme_lst.get(0).setAvg_aum(sa.getAvg_aum());
//						schme_lst.get(0).setAmc_code(sa.getAmc_code());
//						
////						schme_lst.get(0).setFof(sa.getFof());
////						schme_lst.get(0).setScheme_code(sa.getScheme_code());
////						schme_lst.get(0).setTotal(sa.getTotal());
//						
//						ssn.saveOrUpdate(schme_lst.get(0));
//						db_save++;
//					
//					}
//				}
//				else
//				{
//					ssn.save(sa);
//					db_save++;
//					i++;
//				}
				
				
				
				
//			   
//			
//			
//			ArrayList<Scheme_Paum> schme_lst = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0,sa.getKey().getScheme_code() ).setDate(1, sa.getKey().getDay()).list();
//			
////			System.out.println("LIST SIZE_____----->>>"+schme_lst.size());
//			
//			if(schme_lst.size()>0)
//			{
////				 System.out.println("Prev exFOF-->>"+schme_lst.get(0).getExfof());
////				 System.out.println("New FOF--->>"+sa.getExfof());
////				 
////				 System.out.println("COMpare-->>"+(schme_lst.get(0).getExfof()!=0));
//				 
//				 
//				if(schme_lst.get(0).getAvg_aum()!=0)
//				{
////					System.out.println("IN HERE----");
//					
//					schme_lst.get(0).setAvg_aum(sa.getAvg_aum());
//					schme_lst.get(0).setAmc_code(sa.getAmc_code());
//					
////					schme_lst.get(0).setFof(sa.getFof());
////					schme_lst.get(0).setScheme_code(sa.getScheme_code());
////					schme_lst.get(0).setTotal(sa.getTotal());
//					
//					ssn.saveOrUpdate(schme_lst.get(0));
//				}
//			}
//			else
//			{
//				ssn.save(sa);	
//			}
			
	
				
				
				
				
////				 ---------------SCHEME AUM-------------------------------
//				Scheme_Aum sa = new Scheme_Aum();
//				
//				
//				
//						
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
//				ArrayList<Scheme_Aum> schm_aum_lst = (ArrayList<Scheme_Aum>) ssn.createQuery("from Scheme_Aum where scheme_code=? and day=?").setLong(0, sa.getScheme_code()).setDate(1, sa.getDay()).list();
//                 
//				if(schm_aum_lst.size()>0)
//				{
//					System.out.println("...");
//				}
//				else
//				{
//					ssn.save(sa);	
//					db_save++;
//				    i++;
//					System.out.println("<--New Record Added-->");
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
//				System.out.println("Db_SAVE-->>"+db_save);
//				System.out.println("db_save%50=="+(db_save%50));
				
				
				if (db_save%50==0)
				{
					 
					  ssn.getTransaction().commit(); 
					  ssn.beginTransaction();
					  ssn.flush();
				      ssn.clear();
				      System.out.println("<<<--- Batch Saved --->>"); 
				      db_save=1;
				}
				
				i++;
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
			System.out.println("<---Upload Complete---->");
		}
		
		
		
		
		
		

//	   
	   
	   
		
			

	}

}
