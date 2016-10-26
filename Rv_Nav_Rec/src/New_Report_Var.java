import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Scheme_Detail;
import controller.Stock_rank_db;
import debt_Controller.Credit_rating_sum_groups;
import sessionFactory.HIbernateSession;

public class New_Report_Var {

	public static void main(String[] args) 
	{
        
		      ArrayList<Integer> scheme_code_list = new ArrayList<Integer>();
		      Session ssn = null;
		      
		// TODO Auto-generated method stub
				int ide_y=1;
				int row_incrementor=0;
			   	int db_save=0;
			   	int ii=0;
				try
				{
					 
					String fileName = "/home/rv/Desktop/scheme_classification_LMS_21102016.xlsx";
					FileInputStream fis = new FileInputStream(new File(fileName));
			        
					ArrayList<java.util.Date> date_lst = new ArrayList<java.util.Date>();
					
					ArrayList<Scheme_Detail> scheme_details_lst = new ArrayList<Scheme_Detail>();
					
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
//					Stock_rank_db_PK pkk = null;
					
					long temp_acc_code=0;
					String temp_Compname=null;
					
					
//					ArrayList<Credit_rating_sum_groups> credit_list = new ArrayList<Credit_rating_sum_groups>();
					
					
				    
				    
					while (rowIterator.hasNext()) 
			        {
						 			 
						Row row = rowIterator.next();
						 
						   Iterator<Cell> cellIterator = row.cellIterator();
						   int cell_counter=0;
						   
						   temp_acc_code=0;
						   temp_Compname=null;
						   
						   Credit_rating_sum_groups crsg = new Credit_rating_sum_groups();
						  
						   
							while (cellIterator.hasNext()) 
				               {
						    	   Cell cell = cellIterator.next();
						    	   
						    	   if(cell.getCellType()== Cell.CELL_TYPE_STRING )
						    	   {
						    		   
						    		   
						    		   if(cell_counter==1)
						    		   {
//						    			   crsg.setClassification(cell.getStringCellValue());
//						    			   System.out.print("Classification-(1)->"+cell.getStringCellValue()+"\t");
						    		   }
						    		   else
						    		   {
//						    			   System.out.print("Rv_Group-(4)->"+cell.getStringCellValue()+"\t");
//						    			   crsg.setRv_group(cell.getStringCellValue());
						    			    
						    			  
						    			   
						    		   }
						    		   
						    		   
						    	   }
						    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
						    	   {
						    		   
						    		 if( DateUtil.isCellDateFormatted(cell))
						    		  {
//					    			  System.out.println("DATE-(2)->>"+cell.getDateCellValue()+"\t");
//						    			  dd = cell.getDateCellValue();				    			  
//						    			  crsg.setInv_date(dd);
						    			  
						    			  
						    			  
						    		  }
						    		  else
						    		  {
						    			   if(cell_counter==1)
						    			   {
//						    				   temp_acc_code = (long) cell.getNumericCellValue();
//						    				   System.out.print("Scheme_Code-(0)->"+cell.getNumericCellValue() +"\t");
						    				   
//						    				   System.out.println("Scheme_Code-->>"+cell.getNumericCellValue());
						    				   scheme_code_list.add((int) cell.getNumericCellValue());			 
						    				   
						    			    }
						    			   else
						    			   {
//						    				   System.out.print("HOlding-(3)->>"+cell.getNumericCellValue() +"\t"); 
//						    				   crsg.setHold_percent((double) cell.getNumericCellValue());
						    			   }
						    		  }
						    	   }
						    	   cell_counter++;
						        }
//							System.out.println();
						 row_incrementor++;
			        }
					ArrayList<Scheme_Detail> mn_lst=null;
					ssn = HIbernateSession.getSessionFactory().openSession();
					ssn.beginTransaction();
					
					for(long sc_code :scheme_code_list)
					{
						   Criteria crit = ssn.createCriteria(Scheme_Detail.class);
						   crit.add(Restrictions.eq("scheme_code", sc_code));
						   crit.add(Restrictions.eq("STATUS", "Active"));
						   crit.add(Restrictions.eq("PLAN",7));
						   
						    mn_lst = (ArrayList<Scheme_Detail>) crit.list();
						   
						   if(mn_lst.size()>0)
						   {
							   scheme_details_lst.add(mn_lst.get(0));
						   }
						   
						   
//						   crit.add(Restrictions.in("OPT_CODE",1,2,3));
//						  crit.add(Restrictions.in("TYPE_CODE",1,2,3));
//						  crit.add(Restrictions.in("PLAN",1,2,3,4,6));
						  
					}
					
					
					  
					
									
					
					ssn.close();
					
					 PrintWriter writer = new PrintWriter("/home/rv/Desktop/LMS.csv", "UTF-8");
						
						
						for(Scheme_Detail xxx: scheme_details_lst )
						{
								
							writer.println(xxx.getScheme_code()+","+xxx.getAMFI_NAME()+","+xxx.getS_NAME()+","+xxx.getTYPE_CODE()+","+xxx.getOPT_CODE()+","+xxx.getPRIMARY_FUND()+","+xxx.getPRIMARY_FD_CODE()+","+xxx.getSTATUS()+","+xxx.getIsPurchaseAvailable()+","+xxx.getPLAN()+","+xxx.getDiv_Code());		
							
						}
						
						writer.close();
					  
					
					
					
					
					
					
					
				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				finally
				{
					System.out.println("---Report Complete---");
				}
  
	}

}
