package debt_Main;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import controller.Stock_rank_db;
import controller.Stock_rank_db_PK;
import debt_Controller.Credit_rating_Pk;
import debt_Controller.Credit_rating_sum_groups;
import sessionFactory.HIbernateSession;

public class Insert_Data_from_excel_Main {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int ide_y=1;
		int row_incrementor=0;
	   	int db_save=0;
	   	int ii=0;
		try
		{
			 
			String fileName = "/home/rv/Desktop/files_to_upload/credit_rating_sum_groups.xlsx";
			FileInputStream fis = new FileInputStream(new File(fileName));
	        ArrayList<java.util.Date> date_lst = new ArrayList<java.util.Date>();
			
			
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
//			Stock_rank_db_PK pkk = null;
			
			long temp_acc_code=0;
			String temp_Compname=null;
			
			
			ArrayList<Credit_rating_sum_groups> credit_list = new ArrayList<Credit_rating_sum_groups>();
			
			
		    
		    
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
				    			   crsg.setClassification(cell.getStringCellValue());
//				    			   System.out.print("Classification-(1)->"+cell.getStringCellValue()+"\t");
				    		   }
				    		   else
				    		   {
//				    			   System.out.print("Rv_Group-(4)->"+cell.getStringCellValue()+"\t");
				    			   crsg.setRv_group(cell.getStringCellValue());
				    			    
				    			   credit_list.add(crsg);
				    			   
				    		   }
				    		   
				    		   
				    	   }
				    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
				    	   {
				    		   
				    		 if( DateUtil.isCellDateFormatted(cell))
				    		  {
//			    			  System.out.println("DATE-(2)->>"+cell.getDateCellValue()+"\t");
				    			  dd = cell.getDateCellValue();				    			  
				    			  crsg.setInv_date(dd);
				    			  
				    			  
				    			  
				    		  }
				    		  else
				    		  {
				    			   if(cell_counter==0)
				    			   {
				    				   temp_acc_code = (long) cell.getNumericCellValue();
//				    				   System.out.print("Scheme_Code-(0)->"+cell.getNumericCellValue() +"\t");
				    				   
				    				   crsg.setId(ide_y++);
				    				   crsg.setScheme_code(temp_acc_code);				 
				    			    }
				    			   else
				    			   {
//				    				   System.out.print("HOlding-(3)->>"+cell.getNumericCellValue() +"\t"); 
				    				   crsg.setHold_percent((double) cell.getNumericCellValue());
				    			   }
				    		  }
				    	   }
				    	   cell_counter++;
				        }
//					System.out.println();
				 row_incrementor++;
	        }			
			
			
			
			Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    for(Credit_rating_sum_groups crgs :credit_list)
		    {
//		    	System.out.println("<<<<--START-->>>>");
//		    	System.out.println("Pk-(1)->"+crgs.getKey().getRv_group());
//		    	System.out.println("Pk-(2)->"+crgs.getKey().getScheme_code());
//		    	System.out.println("Pk-(3)->"+crgs.getKey().getInv_date());
//		    	System.out.println("<<<<--END-->>>>");
		      	
		    	ssn.save(crgs);
		    	ii++;	
		    	
		    	    if(ii%100==0)
		    	   {
			    		ssn.getTransaction().commit();
			    		ssn.beginTransaction();
			    		ii=0;
		    	   }
		    }
		    
		    
		    ssn.getTransaction().commit();
		    ssn.close();
			
			
			
			System.out.println("<<----Upload Complete---->>>");
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			
		}

	}

}
