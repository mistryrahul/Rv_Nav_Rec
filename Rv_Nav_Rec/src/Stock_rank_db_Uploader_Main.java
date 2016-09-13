import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import sessionFactory.HIbernateSession;

import controller.Stock_rank_db;
import controller.Stock_rank_db_PK;






public class Stock_rank_db_Uploader_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int row_incrementor=0;
	   	int db_save=0;
	   	
		try
		{
			 
			String fileName = "/home/rv/Desktop/files_to_upload/rank_database_final.xlsx";
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
			Stock_rank_db_PK pkk = null;
			
			long temp_acc_code=0;
			String temp_Compname=null;
			
			
			
			Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    
			while (rowIterator.hasNext()) 
	        {
				 			 
				Row row = rowIterator.next();
				 
				   Iterator<Cell> cellIterator = row.cellIterator();
				   int cell_counter=0;
				   
				   temp_acc_code=0;
				   temp_Compname=null;
				   
					while (cellIterator.hasNext()) 
		               {
				    	   Cell cell = cellIterator.next();
				    	   
				    	   if(cell.getCellType()== Cell.CELL_TYPE_STRING )
				    	   {
//				    		   System.out.print("\t"+cell.getStringCellValue()+"\t");
				    		   
				    		   if(cell_counter==1 && row_incrementor!=0)
				    		   {
				    			   temp_Compname = cell.getStringCellValue();
				    		   }
				    		   
				    		   
				    	   }
				    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
				    	   {
				    		 if( DateUtil.isCellDateFormatted(cell))
				    		  {
				    			  System.out.println("\t"+cell.getDateCellValue()+"\t");
				    			  dd = cell.getDateCellValue();
				    			  System.out.println("\t"+dd+"\t");
				    			  date_lst.add(dd);
				    			  
				    			  
				    			  
				    		  }
				    		  else
				    		  {
//				    			  System.out.print("\t"+cell.getNumericCellValue() +"\t");  
				    			   if(cell_counter==0)
				    			   {
				    				   temp_acc_code = (long) cell.getNumericCellValue();
				    			   }
				    			   else
				    			   {   
				    				     srdb = new Stock_rank_db();
				    					 pkk = new Stock_rank_db_PK();
				    					 
				    					 pkk.setAccord_code(temp_acc_code);
				    					 pkk.setDay(date_lst.get(cell_counter-2));
				    				     
				    					 srdb.setPk(pkk);
				    					 
				    					 srdb.setComp_name(temp_Compname);
				    					 srdb.setRank(cell.getNumericCellValue());
				    					 
//				    					 System.out.println("LONG VAL--->>"+cell.getNumericCellValue());
				    					 
				    					 ssn.save(srdb);
				    					 db_save++;
				    					 
				    					 if(db_save%100==0)
				    					 {
				    						 ssn.getTransaction().commit();
				    						 ssn.beginTransaction();
				    						 ssn.clear();
				    						 ssn.flush();
				    						 
				    						 
				    						 
				    					 }
				    					 
				    					 
				    			   }
				    			  
				    			  
				    		  }
				    	   }
				    	   cell_counter++;
				        }
				 
//					System.out.println("CEll COUnter-->>"+cell_counter);	 
				 row_incrementor++;
	        }
			
			ssn.getTransaction().commit();
			ssn.close();
			
			
//			System.out.println("Row COUnter-->>"+row_incrementor);
			
			System.out.println("<<----Upload Complete---->>>");
			
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
  
	}

}
