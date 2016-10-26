import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.Scheme_Detail;
import controller.Stock_rank_db;
import debt_Controller.Credit_rating_sum_groups;
import sessionFactory.HIbernateSession;

public class Scheme_Details_Insert_Main {

	public static void main(String[] args) 
	{
		double db_save=0;
		String scheme_cd="", dt="", amc_cd="" , ex_ratio=""; 
		java.util.Date dd,dd_1,dd_2;
		String tmp_val=null;
		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
		Matcher matcher;
		long i= 0;  // make this the last id after each operation
		int i_i=0;
		Session ssn = null;
		
		Update_rv_Rank_scheme_detail();
		
//		try
//		{   
//
//			
//			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_details_full_upto_august.ace"), "UTF-8");
////			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Scheme_details_full.ace"), "UTF-8");
//
//			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
//			ssn = sessionfactry.openSession();
//			ssn.beginTransaction();
//			
//			
//			while (it.hasNext()) // if the file has lines 
//     	    {
//
//			   tmp_val=it.nextLine();
//
//				
//				if(tmp_val.equals("<<eof>>"))
//				{
//					i=1;
//					break;
//					
//				}
//				matcher = pattern.matcher(tmp_val);
//				matcher.find();
//				String[] separated = matcher.group(1).split("\\|");
//				
//				Scheme_Detail nw_obj = new Scheme_Detail();
//				
//				nw_obj.setScheme_code(Long.parseLong(separated[0]));
//				
//				
//				
//				
//				if(separated[1]!=null && !separated[1].isEmpty())
//				{
//					nw_obj.setAMFI_CODE(Long.parseLong(separated[1]));
//				}
//				
//				if(separated[2]!=null && !separated[2].isEmpty())
//				{
//					nw_obj.setCAMS_CODE(separated[2]);
//				}
//				
//				if(separated[3]!=null && !separated[3].isEmpty())
//				{
//					nw_obj.setAMC_CODE(Long.parseLong(separated[3]));
//				}
//				
//				if(separated[4]!=null && !separated[4].isEmpty())
//				{
//					nw_obj.setS_NAME(separated[4]);
//				}
//				
//				if(separated[5]!=null && !separated[5].isEmpty())
//				{
//					nw_obj.setAMFI_NAME(separated[5]);
//				}
//				
//				if(separated[6]!=null && !separated[6].isEmpty())
//				{
//					nw_obj.setISIN_CODE(separated[6]);
//				}
//				
//				if(separated[7]!=null && !separated[7].isEmpty())
//				{
//					nw_obj.setTYPE_CODE(Integer.parseInt(separated[7]));
//				}
//				
//				if(separated[8]!=null && !separated[8].isEmpty())
//				{
//					nw_obj.setOPT_CODE(Integer.parseInt(separated[8]));
//				}
//				if(separated[9]!=null && !separated[9].isEmpty())
//				{
//					nw_obj.setCLASSCODE(Integer.parseInt(separated[9]));
//				}
//				
//				if(separated[10]!=null && !separated[10].isEmpty())
//				{
//					nw_obj.setTHEME_CODE(Integer.parseInt(separated[10]));
//				}
//				
//				if(separated[11]!=null && !separated[11].isEmpty())
//				{
//					nw_obj.setRT_CODE(Integer.parseInt(separated[11]));
//				}
//				
//				if(separated[12]!=null && !separated[12].isEmpty())
//				{
//					nw_obj.setPLAN(Integer.parseInt(separated[12]));
//				}
//				
//				if(separated[13]!=null && !separated[13].isEmpty())
//				{
//					nw_obj.setCUST_CODE(Integer.parseInt(separated[13]));
//				}
//				
//				if(separated[14]!=null && !separated[14].isEmpty())
//				{
//					nw_obj.setCUST_CODE2(Integer.parseInt(separated[14]));
//				}
//				
//				if(separated[15]!=null && !separated[15].isEmpty())
//				{
//					nw_obj.setPRICE_FREQ(Integer.parseInt(separated[15]));
//				}
//				
//				if(separated[16]!=null && !separated[16].isEmpty())
//				{
//					nw_obj.setINIT_PRICE(Double.parseDouble(separated[16]));
//				}
//				
//				if(separated[17]!=null && !separated[17].isEmpty())
//				{
//					nw_obj.setOFFERPRICE(Double.parseDouble(separated[17]));
//				}
//				
//				if(separated[18]!=null && !separated[18].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[18].substring(0,10));
//					
//					nw_obj.setNFO_OPEN(dd);
//				}
//								
//				if(separated[19]!=null && !separated[19].isEmpty())
//				{
//					dd_1 = new SimpleDateFormat("yyyy-MM-dd").parse(separated[19].substring(0,10));
//					
//					nw_obj.setNFO_CLOSE(dd_1);
//				}
//				if(separated[20]!=null && !separated[20].isEmpty())
//				{
//					dd_2 = new SimpleDateFormat("yyyy-MM-dd").parse(separated[20].substring(0,10));
//					
//					nw_obj.setREOPEN_DT(dd_2);
//				}
//				
//				if(separated[21]!=null && !separated[21].isEmpty())
//				{
//					nw_obj.setELF(separated[21]);
//				}
//				
//				if(separated[22]!=null && !separated[22].isEmpty())
//				{
//					nw_obj.setETF(separated[22]);
//				}
//				
//				if(separated[23]!=null && !separated[23].isEmpty())
//				{
//					nw_obj.setSTP(separated[23]);
//				}
//				
//				if(separated[24]!=null && !separated[24].isEmpty())
//				{
//					nw_obj.setPRIMARY_FUND(separated[24]);
//				}
//				if(separated[25]!=null && !separated[25].isEmpty())
//				{
//					nw_obj.setPRIMARY_FD_CODE(Integer.parseInt(separated[25]));
//				}
//				
//				if(separated[26]!=null && !separated[26].isEmpty())
//				{
//					nw_obj.setSIP(separated[26]);
//				}
//				
//				if(separated[27]!=null && !separated[27].isEmpty())
//				{
//					nw_obj.setSWP(separated[27]);
//				}
//				
//				if(separated[28]!=null && !separated[28].isEmpty())
//				{
//					nw_obj.setSWITCH(separated[28]);
//				}
//				
//				if(separated[29]!=null && !separated[29].isEmpty())
//				{
//					nw_obj.setMININVT(Double.parseDouble(separated[29]));
//				}
//				if(separated[30]!=null && !separated[30].isEmpty())
//				{
//					nw_obj.setMULTIPLES(Integer.parseInt(separated[30]));
//				}
//				if(separated[31]!=null && !separated[31].isEmpty())
//				{
//					nw_obj.setINC_INVEST(Double.parseDouble(separated[31]));
//				}
//				if(separated[32]!=null && !separated[32].isEmpty())
//				{
//					nw_obj.setADNMULTIPLES(Double.parseDouble(separated[32]));
//				}
//				
//				if(separated[33]!=null && !separated[33].isEmpty())
//				{
//					nw_obj.setFUND_MGR1(separated[33]);
//				}
//				if(separated[34]!=null && !separated[34].isEmpty())
//				{
//					nw_obj.setFUND_MGR2(separated[34]);
//				}
//				if(separated[35]!=null && !separated[35].isEmpty())
//				{
//					nw_obj.setFUND_MGR3(separated[35]);
//				}
//				if(separated[36]!=null && !separated[36].isEmpty())
//				{
//					nw_obj.setFUND_MGR4(separated[36]);
//				}
//				if(separated[37]!=null && !separated[37].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[37].substring(0,10));
//					
//					nw_obj.setSINCE(dd);
//				}
//				if(separated[38]!=null && !separated[38].isEmpty())
//				{
//					nw_obj.setSTATUS(separated[38]);
//				}
//				if(separated[39]!=null && !separated[39].isEmpty())
//				{
//					nw_obj.setCUTSUB(separated[39]);
//				}
//				
//				if(separated[40]!=null && !separated[40].isEmpty())
//				{
//					nw_obj.setCUTRED(separated[40]);
//				}
//				
//				if(separated[41]!=null && !separated[41].isEmpty())
//				{
//					nw_obj.setRED(separated[41]);
//				}
//				
//				if(separated[42]!=null && !separated[42].isEmpty())
//				{
//					nw_obj.setMOB_NAME(separated[42]);
//				}
//				if(separated[43]!=null && !separated[43].isEmpty())
//				{
//					nw_obj.setDIV_FREQ(Integer.parseInt(separated[43]));
//				}
//				
//				if(separated[44]!=null && !separated[44].isEmpty())
//				{
//					nw_obj.setScheme_Symbol(separated[44]);
//				}
//				
//				if(separated[45]!=null && !separated[45].isEmpty())
//				{
//					nw_obj.setFUND_MGR_CODE1(Integer.parseInt(separated[45]));
//				}
//				if(separated[46]!=null && !separated[46].isEmpty())
//				{
//					nw_obj.setFUND_MGR_CODE2(Integer.parseInt(separated[46]));
//				}
//				if(separated[47]!=null && !separated[47].isEmpty())
//				{
//					nw_obj.setFUND_MGR_CODE3(Integer.parseInt(separated[47]));
//				}
//				if(separated[48]!=null && !separated[48].isEmpty())
//				{
//					nw_obj.setFUND_MGR_CODE4(Integer.parseInt(separated[48]));
//				}
//				if(separated[49]!=null && !separated[49].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[49].substring(0,10));
//					
//					nw_obj.setRedemption_date(dd);
//				}
//				if(separated[50]!=null && !separated[50].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[50].substring(0,10));
//					
//					nw_obj.setDateOfAllot(dd);
//				}
//				
//				if(separated[51]!=null && !separated[51].isEmpty())
//				{
//					nw_obj.setDiv_Code(Double.parseDouble(separated[51]));
//				}
//				
//				if(separated[52]!=null && !separated[52].isEmpty())
//				{
//					nw_obj.setLegalNames(separated[52]);
//				}
//				
//				if(separated[53]!=null && !separated[53].isEmpty())
//				{
//					nw_obj.setAMFIType(separated[53]);
//				}
//				
//				if(separated[54]!=null && !separated[54].isEmpty())
//				{
//					nw_obj.setNonTxnDay(separated[54]);
//				}
//				if(separated[55]!=null && !separated[55].isEmpty())
//				{
//					nw_obj.setSchemeBank(separated[55]);
//				}
//				if(separated[56]!=null && !separated[56].isEmpty())
//				{
//					nw_obj.setSchemeBankAccountNumber(separated[56]);
//				}
//				if(separated[57]!=null && !separated[57].isEmpty())
//				{
//					nw_obj.setSchemeBankBranch(separated[57]);
//				}
//				if(separated[58]!=null && !separated[58].isEmpty())
//				{
//					nw_obj.setDividendOptionFlag(separated[58]);
//				}
//				if(separated[59]!=null && !separated[59].isEmpty())
//				{
//					nw_obj.setLockInPeriod(separated[59]);
//				}
//				if(separated[60]!=null && !separated[60].isEmpty())
//				{
//					nw_obj.setIsPurchaseAvailable(separated[60]);
//				}
//				
//				if(separated[61]!=null && !separated[61].isEmpty())
//				{
//					nw_obj.setIsRedeemAvailable(separated[61]);
//				}
//				
//				if(separated[62]!=null && !separated[62].isEmpty())
//				{
//					nw_obj.setMinRedemptionAmount(Double.parseDouble(separated[62]));
//				}
//				if(separated[63]!=null && !separated[63].isEmpty())
//				{
//					nw_obj.setRedemptionMultipleAmount(Double.parseDouble(separated[63]));
//				}
//				if(separated[64]!=null && !separated[64].isEmpty())
//				{
//					nw_obj.setMinRedemptionUnits(Double.parseDouble(separated[64]));
//				}
//				if(separated[65]!=null && !separated[65].isEmpty())
//				{
//					nw_obj.setRedemptionMultiplesUnits(Double.parseDouble(separated[65]));
//				}
//				if(separated[66]!=null && !separated[66].isEmpty())
//				{
//					nw_obj.setMinSwitchAmount(Double.parseDouble(separated[66]));
//				}
//				if(separated[67]!=null && !separated[67].isEmpty())
//				{
//					nw_obj.setSwitchMultipleAmount(Double.parseDouble(separated[67]));
//				}
//				if(separated[68]!=null && !separated[68].isEmpty())
//				{
//					nw_obj.setMinSwitchUnits(Double.parseDouble(separated[68]));
//				}
//				if(separated[69]!=null && !separated[69].isEmpty())
//				{
//					nw_obj.setSwitchMultiplesUnits(Double.parseDouble(separated[69]));
//				}
//				
//				if(separated[70]!=null && !separated[70].isEmpty())
//				{
//					nw_obj.setSecurityCode(separated[70]);
//				}
//				
//				if(separated[71]!=null && !separated[71].isEmpty())
//				{
//					nw_obj.setUnit(separated[71]);
//				}
//				
//				if(separated[72]!=null && !separated[72].isEmpty())
//				{
//					nw_obj.setSwitchOut(separated[72]);
//				}
//				
//				if(separated[73]!=null && !separated[73].isEmpty())
//				{
//					nw_obj.setMinSwitchOutAmount(Double.parseDouble(separated[73]));
//				}
//				
//				if(separated[74]!=null && !separated[74].isEmpty())
//				{
//					nw_obj.setSwitchOutMultipleAmount(Double.parseDouble(separated[74]));
//				}
//				
//				if(separated[75]!=null && !separated[75].isEmpty())
//				{
//					nw_obj.setMinSwitchOutUnits(Double.parseDouble(separated[75]));
//				}
//				
//				if(separated[76]!=null && !separated[76].isEmpty())
//				{
//					nw_obj.setSwitchOutMultiplesUnits(Double.parseDouble(separated[76]));
//				}
//				
//				if(separated[77]!=null && !separated[77].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[77].substring(0,10));
//					
//					nw_obj.setIncept_date(dd);
//				}
//				//float
//				
//				if(separated[78]!=null && !separated[78].isEmpty())
//				{
//					nw_obj.setIncept_Nav(Double.parseDouble(separated[78]));
//				}
//				
//				
//				if(separated[79]!=null && !separated[79].isEmpty())
//				{
//					nw_obj.setDefaultOpt(separated[79]);
//				}
//				
//				if(separated[80]!=null && !separated[80].isEmpty())
//				{
//					nw_obj.setDefaultPlan(separated[80]);
//				}
//				
//				if(separated[81]!=null && !separated[81].isEmpty())
//				{
//					nw_obj.setLockPeriod(Integer.parseInt(separated[81]));
//				}
//				if(separated[82]!=null && !separated[82].isEmpty())
//				{
//					dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[82].substring(0,10));
//					
//					nw_obj.setODDraftDate(dd);
//				}
//				
//                 Scheme_Detail sch_dtl_chk = ssn.get(Scheme_Detail.class, Long.parseLong(separated[0]));
//				
//				if (sch_dtl_chk!=null)
//				{
//					sch_dtl_chk.Copy_Objects(nw_obj);
//					ssn.saveOrUpdate(sch_dtl_chk);
//					db_save++;
//				}
//				else
//				{
//					ssn.save(nw_obj);
//					db_save++;
//				}
//				
//				
//				
//				
//				
//				
//				   if(db_save%50==0)
//				   {
//					   ssn.getTransaction().commit();
//					   ssn.beginTransaction();
//					 
//					   db_save=1;
//				   }
//				
//				
//     	    }
//		}
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
//		finally 
//		{
//		      ssn.getTransaction().commit();
//		      ssn.close();
//		      System.out.println("<<<<<<<<<|-Completed Update-|>>>>>>>>>>");
//		}
   
	}
	
	   public static String Update_rv_Rank_scheme_detail()
	   {
		   int updt_flg=0;  
		   
		   try
		   {   
			   
			   HashMap<Long,String> scheme_classification = new HashMap<Long,String>();
			   
			   String fileName = "/home/rv/Desktop/files_to_upload/rv_scheme_classifications_01022016.xlsx";
				FileInputStream fis = new FileInputStream(new File(fileName));
		        
				int row_incrementor=0;
				
				Workbook workbook = null;
				if(fileName.toLowerCase().endsWith("xlsx")){
					workbook = new XSSFWorkbook(fis);
				}else if(fileName.toLowerCase().endsWith("xls")){
					workbook = new HSSFWorkbook(fis);
				}
				
				java.util.Date dd=null;
				
				Sheet sheet = workbook.getSheetAt(0);
		        
				Iterator<Row> rowIterator = sheet.iterator();
		        Stock_rank_db srdb = null;
//				Stock_rank_db_PK pkk = null;
				
				long temp_scheme_code=0;
				String temp_Compname=null;
				
			    
			    
				while (rowIterator.hasNext()) 
		        {
					
					 if(row_incrementor==0)
					 {
						 row_incrementor++;
						 continue;
					 }
					 			 
					Row row = rowIterator.next();
					 
					   Iterator<Cell> cellIterator = row.cellIterator();
					   int cell_counter=0;
					   
					   temp_scheme_code=0;
					   temp_Compname=null;
					   
					  
					  
					   
						while (cellIterator.hasNext()) 
			               {
							
					    	   Cell cell = cellIterator.next();
					    	   
					    	   if(cell.getCellType()== Cell.CELL_TYPE_STRING )
					    	   {
					    		   
					    		   
					    		   if(cell_counter==1)
					    		   {
					    			   
//					    			   System.out.print("Classification-(1)->"+cell.getStringCellValue()+"\t");
					    		   }
					    		   else if(cell_counter==2)
					    		   {
//					    			   System.out.print("Rv_Group-(4)->"+cell.getStringCellValue()+"\t");
					    			   
					    			   scheme_classification.put(temp_scheme_code, cell.getStringCellValue()); 					    			   
					    			   
					    		   }
					    		   
					    		   
					    	   }
					    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
					    	   {
					    		   
					    		 if( DateUtil.isCellDateFormatted(cell))
					    		  {
//				    			  System.out.println("DATE-(2)->>"+cell.getDateCellValue()+"\t");
					    			  dd = cell.getDateCellValue();				    			  
					    			  
					    			  
					    			  
					    			  
					    		  }
					    		  else
					    		  {
					    			   if(cell_counter==0)
					    			   {
					    				   temp_scheme_code = (long) cell.getNumericCellValue(); //scheme_code
					    				   
//					    				   System.out.print("Scheme_Code-(0)->"+cell.getNumericCellValue() +"\t");
					    				   
					    				   				 
					    			    }
					    			   else
					    			   {
//					    				   System.out.print("HOlding-(3)->>"+cell.getNumericCellValue() +"\t"); 
					    				  
					    			   }
					    		  }
					    	   }
					    	   cell_counter++;
					        }
//						System.out.println();
					 row_incrementor++;
		        }
				
				
				Session ssn = HIbernateSession.getSessionFactory().openSession(); 
			    ssn.beginTransaction();	
				
				for (Map.Entry<Long, String> entry : scheme_classification.entrySet()) {
				    Long scheme_code = entry.getKey();
				    String description = entry.getValue();
				    
				    ArrayList<Scheme_Detail> sdtl = (ArrayList<Scheme_Detail>) ssn.createQuery("from Scheme_Detail where scheme_code="+scheme_code).list();
				    
				    if(sdtl.size()>0)
				    {
				    	sdtl.get(0).setRV_Classification(description);
				    	ssn.update(sdtl.get(0));
				    	updt_flg++;
				    }
				    
				    
				    if(updt_flg%500==0)
				    {
				    	ssn.getTransaction().commit();
				    	ssn.beginTransaction();
				    	updt_flg=1;
				    }
				    
				}
				
				
				ssn.getTransaction().commit();
				ssn.close();
				
		   }
		   catch (Exception e) 
		   {
			  e.printStackTrace();
		   }
		   finally
		   {
			   System.out.println("<<<-------Process Complete------>>>");
		   }
			
		   
		   return null;
	   }
	
	

}
