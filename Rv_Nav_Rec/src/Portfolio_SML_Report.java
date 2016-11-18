import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import controller.MF_portfolio_SML_pk;
import controller.MF_portfolio_pk;
import controller.Mf_portfolio_New;
import controller.Portfolio_SML_Report_Model;
import debt_Controller.Credit_rating_sum_groups;
import sessionFactory.HIbernateSession;

public class Portfolio_SML_Report {

	public static void Save_To_Db(ArrayList<Mf_portfolio_New> Portfolio_List,long actual_scheme_code,Session ssn)
	{
		Portfolio_SML_Report_Model nw_obj=null;
		int db_save=1;
		
		  try
		  {
		
				for(Mf_portfolio_New mfp :Portfolio_List)
			     {
			    	 nw_obj = new Portfolio_SML_Report_Model();
			    	 
			    	 MF_portfolio_SML_pk key = new MF_portfolio_SML_pk();
			    	 
			    	 key.setActual_Scheme_Code(actual_scheme_code);
			 		 key.setInvdate(mfp.getKey().getInvdate());
			 		 key.setScheme_code(mfp.getKey().getScheme_code());
			 		 key.setSrno(mfp.getKey().getSrno());
			 		
			    	 nw_obj.SET_Portfolio_SML_Report_Model(mfp,key);
			    	 
			    	 
			    	 
			    	 
			    	 ssn.save(nw_obj);
			    	 db_save++;
			    	 
			    	 if(db_save%30==0)
			    	 {
			    		 ssn.getTransaction().commit();
			    		 ssn.beginTransaction();
			    		 db_save=1;
			    	 }
			     } 
		  }
		  catch (Exception e) 
		  {
			  
			  
			 e.printStackTrace();
			 System.out.println("Actual Scheme_Code----->>"+actual_scheme_code);
			 System.exit(0);
			 
		  }
		ssn.getTransaction().commit();
		ssn.beginTransaction();
	}
	
	
	
	public static HashMap<Long, String> Get_Data_From_Xcel(String fileName) throws IOException
	{
		 System.out.println("<<<<----- In Excel Data File Fetching Method------>>>");
	   
		 long temp_fincode=0;
		 String temp_classification=null;
		 HashMap<Long, String> clasifi_fincode_pair = new HashMap<Long, String>();
		 
		 //Excel FIle Location  
//        String fileName = "/home/rv/Desktop/mcap_classification_19102016.xlsx";
		FileInputStream fis = new FileInputStream(new File(fileName));
         
		
		
		
		
	     	Workbook workbook = null;
			if(fileName.toLowerCase().endsWith("xlsx")){
				workbook = new XSSFWorkbook(fis);
			}else if(fileName.toLowerCase().endsWith("xls")){
				workbook = new HSSFWorkbook(fis);
			}
		

			Sheet sheet = workbook.getSheetAt(0);
	        
			Iterator<Row> rowIterator = sheet.iterator();
		
						while (rowIterator.hasNext()) 
				        {
							 			 
							Row row = rowIterator.next();
							 
							   Iterator<Cell> cellIterator = row.cellIterator();
							   int cell_counter=0;
							   
							   temp_fincode=0;
							   temp_classification=null;
							   
							   Credit_rating_sum_groups crsg = new Credit_rating_sum_groups();
							  
							   
								while (cellIterator.hasNext()) 
					               {
							    	   Cell cell = cellIterator.next();
							    	   
							    	   if(cell.getCellType()== Cell.CELL_TYPE_STRING )
							    	   {
							    		   
							    		   
							    		   if(cell_counter==3)
							    		   {
							    			   temp_classification = cell.getStringCellValue();
							    			   
							    			   clasifi_fincode_pair.put(temp_fincode, temp_classification);
							                   
							    			   
				//			    			   crsg.setClassification(cell.getStringCellValue());
				//			    			   System.out.print("Classification-(1)->"+cell.getStringCellValue()+"\t");
							    		   }
							    		   else
							    		   {
				//			    			   System.out.print("Rv_Group-(4)->"+cell.getStringCellValue()+"\t");
				//			    			   crsg.setRv_group(cell.getStringCellValue());
							    			    
							    			  
							    			   
							    		   }
							    		   
							    		   
							    	   }
							    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
							    	   {
							    		   
							    		 if( DateUtil.isCellDateFormatted(cell))
							    		  {
				//		    			  System.out.println("DATE-(2)->>"+cell.getDateCellValue()+"\t");
				//			    			  dd = cell.getDateCellValue();				    			  
				//			    			  crsg.setInv_date(dd);
							    			  
							    			  
							    			  
							    		  }
							    		  else
							    		  {
							    			   if(cell_counter==0)
							    			   {
				//			    				   temp_acc_code = (long) cell.getNumericCellValue();
				//			    				   System.out.print("Scheme_Code-(0)->"+cell.getNumericCellValue() +"\t");
							    				   
				//			    				   System.out.println("Scheme_Code-->>"+cell.getNumericCellValue());
							    				   temp_fincode = (long) cell.getNumericCellValue();			 
							    				   
							    			    }
							    			   else
							    			   {
				//			    				   System.out.print("HOlding-(3)->>"+cell.getNumericCellValue() +"\t"); 
				//			    				   crsg.setHold_percent((double) cell.getNumericCellValue());
							    			   }
							    		  }
							    	   }
							    	   cell_counter++;
							        }
				//				System.out.println();
				//			 row_incrementor++;
				        }
		
		System.out.println("<---Excel Input COmplete------>>");
		
		return clasifi_fincode_pair;
	}
	
	public static long Check_for_Portfolio(long scheme_code, Session ssn , String code_type)
	{
		 ArrayList<Long> schm_cd= (ArrayList<Long>) ssn.createQuery("select count(*) from Mf_portfolio_New where scheme_code='"+scheme_code+"'").list();
		 long scheme_code_to_return=0;
		 
		 
		 if(schm_cd.get(0)>0)
		 {
//			 System.out.println("coming here.......");
			 scheme_code_to_return = scheme_code;
			 
		 }
		 else 
		 {
//			 System.out.println("coming here.......");
			 if(!code_type.equals("PRIMARY_FD_CODE"))
			 {
//				 System.out.println("coming here toooo.......");
		        ArrayList<Long> pri_fd_cd = (ArrayList<Long>) ssn.createQuery("select PRIMARY_FD_CODE from Scheme_Detail where scheme_code='"+scheme_code+"' ").list();
		         if(pri_fd_cd.size()>0)
		         {
		        	 scheme_code_to_return =  Check_for_Portfolio(pri_fd_cd.get(0),ssn,"PRIMARY_FD_CODE");
		        	 
		        	 
		         }
		         
			 }
		 }
		return scheme_code_to_return;
	}
	
	public static void main(String[] args) 
	{
        
		String Fund_Type="";
		Session ssn=null;
		int row_incrementor=0;
		int db_save=0;
		long temp_scheme_code_holder=0; 
		
		long temp_fincode=0;
    	String temp_classification=null;
    	 
		ArrayList<Mf_portfolio_New> Portfolio_List = new ArrayList<>();
		
		ArrayList<Long> Actual_Scheme_Code_List = new  ArrayList<Long>();
		
		 try
		 {
		
//		
		   LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/SML_scheme_code_list.txt"), "UTF-8");
		   List<Long> oo = new ArrayList<Long>();
		   long temp_scheme_code=0;
		   
		   
			while (it_s.hasNext()) // if the file has lines 
	           {
		                 oo.add(Long.parseLong(it_s.nextLine()));
	           }		
	 
	       System.out.println("File loaded Successfullyy----->"+oo.size());
		  
	       ssn = HIbernateSession.getSessionFactory().openSession(); 
           ssn.beginTransaction();
	       
//	       

	       
	           
	           
	         
//           Actual_Scheme_Code_List.add((long)15);
//           Actual_Scheme_Code_List.add((long)23);
           
	           Portfolio_SML_Report_Model nw_obj = null;
	           MF_portfolio_pk  nx_pk =null;
	           nw_obj = new Portfolio_SML_Report_Model();
	           
	           
	           for(long bb :  oo)
	           {
	        	   
	        	   Portfolio_List = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code='"+bb+"' and key.invdate=(SELECT MAX(key.invdate) as invdate from Mf_portfolio_New where scheme_code='"+bb+"')").list();
	        	   
	        	   if(Portfolio_List.size()>0)
	        	   {
	        		   Save_To_Db(Portfolio_List,bb,ssn);
	        	   }
	        	   else
	        	   {
	        		   
	        		   temp_scheme_code =  Check_for_Portfolio(bb, ssn, "PRIMARY_CODE");   
	        		   Portfolio_List.clear();
	        		   Portfolio_List = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from Mf_portfolio_New where scheme_code='"+temp_scheme_code+"' and key.invdate=(SELECT MAX(key.invdate) as invdate from Mf_portfolio_New where scheme_code='"+temp_scheme_code+"')").list(); 	   
	        		   if(Portfolio_List.size()>0)
	        		   {
	        			   Save_To_Db(Portfolio_List,bb,ssn);
	        		   }
	        		   
	        	   }
	        	   
	           }
	            
	          
//	            
	           HashMap<Long, String> clasifi_fincode_pair = Get_Data_From_Xcel("/home/rv/Desktop/mcap_classification_19102016.xlsx");
	           
//				
//				
//				
				 // Get a set of the entries
			      Set set = clasifi_fincode_pair.entrySet();
			      
			      // Get an iterator
			      Iterator i = set.iterator();
	             
//			      ssn.beginTransaction();
			      
			      
			      // Display elements
			      while(i.hasNext()) 
			      {
			         Map.Entry me = (Map.Entry)i.next();
			        
//			         System.out.println("key-(scheme_code)->"+(long)me.getKey());
//			         System.out.println("value-(Rv_Classification)->>"+(String)me.getValue());
			         
			         ArrayList<Portfolio_SML_Report_Model> mdl = (ArrayList<Portfolio_SML_Report_Model>) ssn.createQuery("from Portfolio_SML_Report_Model where fincode='"+(Long)me.getKey()+"'").list();
			         
                         if(mdl.size()>0)
                         {
                        	 for(Portfolio_SML_Report_Model pfrm :mdl)
                        	 {
                        		 pfrm.setRv_classification((String) me.getValue());
                        		 ssn.save(pfrm);
                        	 }
                         }
			         
			         
//			         System.out.print(me.getKey() + ": ");
//			         System.out.println(me.getValue());
			      } 
			      
           
           
           Actual_Scheme_Code_List = (ArrayList<Long>) ssn.createQuery("select DISTINCT(key.actual_Scheme_Code) from Portfolio_SML_Report_Model").list();
           
           
			     double s_hp=0,l_hp=0,m_hp=0,s_total=0,l_total=0,m_total=0; 
			     String scheme_name ="";
			     java.util.Date dd=null;
			     
			    PrintWriter writer = new PrintWriter("/home/rv/Desktop/New.csv", "UTF-8"); 
					
				writer.println("Scheme_Code"+","+"Date"+","+"Fund"+","+"L"+","+"M"+","+"S");
			      
				
				
				for(long sch_cd : Actual_Scheme_Code_List)
				{
					ArrayList<Portfolio_SML_Report_Model> mdl_list = (ArrayList<Portfolio_SML_Report_Model>) ssn.createQuery("from Portfolio_SML_Report_Model where key.actual_Scheme_Code = '"+sch_cd+"'" ).list();
					
					if(mdl_list.size()>0)
					{
						for(Portfolio_SML_Report_Model ll : mdl_list)
						{ 
							if(ll.getRv_classification()!=null)
							{
								if(ll.getRv_classification().equals("S") || ll.getRv_classification()=="S")
								{
									s_total = s_total + ll.getHoldpercentage();
								}
								if(ll.getRv_classification().equals("M") || ll.getRv_classification()=="M")
								{
									m_total = m_total + ll.getHoldpercentage();
								}
								if(ll.getRv_classification().equals("L") || ll.getRv_classification()=="L")
								{
									l_total = l_total + ll.getHoldpercentage();
								}	
							}
							
							dd = ll.getKey().getInvdate();
						}	
						
						 
						
						ArrayList<String> sch_nm = (ArrayList<String>) ssn.createQuery("select S_NAME from Scheme_Detail where scheme_code='"+sch_cd+"'").list();
						
						if(sch_nm.size()>0)
						{
							scheme_name = sch_nm.get(0);	
						}
						
					}
					writer.println(sch_cd+","+dd+","+scheme_name+","+l_total+","+m_total+","+s_total);
					
					s_total=0;
					l_total=0;
					m_total=0;
                    dd=null;					
				}
				
				
				
				
				
				writer.close();
			      
			                  
	             
	             
	             
	             
           System.out.println("<<<----Copy Complete---->>");
           
//           
           
	  
	      
	   
	  
		 }
		 catch (Exception e) 
		 {
             e.printStackTrace();
		 }
		 finally 
		 {
		    ssn.getTransaction().commit();
		    ssn.close();
		    System.out.println("<<----Report Cmplete-->>");
		 }
	}

}
