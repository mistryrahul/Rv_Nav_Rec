import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Avg_ret_Model;
import controller.Qtr_Avg;
import controller.nav_report_3_stable;
import controller.nav_report_temp_1;

import sessionFactory.HIbernateSession;



public class Excel_report_mn {
	
	
	public static HSSFSheet Get_Average_Column_WISE(HSSFSheet sheet , int size ,int cmnt_size, String Fund_Type)
	{
		   String col_name="";
		   int ctr=0;
		   ArrayList<String> final_row =new ArrayList<String>();
		   Session ssn=null;
		   
		   double tot_val=0;
		   int tot_count=0;
		   double res=0;
		 
			
		   ssn = HIbernateSession.getSessionFactory().openSession(); 
		   ssn.beginTransaction();
		   
		   final_row.add("Average Return");
		   
		   for(int k=0;k<cmnt_size;k++)
		   {
			    tot_val=0;
			    tot_count=0;
			    res=0;
	         
			    if(k==0)
			    {
			    	continue;
			    }
			    
		       	for(int i=0;i<=size;i++)
		       	{
//		       		System.out.println("<----In second loop---->");
			       	   Row row = null;
		    		   Cell cell = null;
		    		   row = sheet.getRow(i);
	    		   
			    		   if(i==0)
			    		   {   
			    			   
			    			     cell = row.getCell(k);
			    			     col_name= cell.toString();   
//			    			     System.out.println("Cell NAME-->>"+cell.toString());
			    		   }    		   
			    		   else
			    		   {
			//    			   row = sheet.getRow(i);
			    			   cell = row.getCell(k);
//			    			   System.out.println(cell.toString());
			    			   
//			    			   System.out.println(cell.toString().equals("0.0"));
			    			   
			    			   
			    			    if(cell.toString().equals("0.0")  || cell.toString().equals("0"))
			    			    {
			    			    	
			    			    }
			    			    else
			    			    {
//			    			    	System.out.println("VALUE TAKEN---->>>"+cell.toString());
			    			    	
			    			    	tot_val= tot_val + Double.parseDouble(cell.toString());
			    			    	tot_count++;
			    			    	
			    			    }
			    			    
			    			       	           
			                  
			    	             
			    		   }
		          
		       	 }
		       	
		       	res = (tot_val/tot_count);
		       	final_row.add(String.valueOf(res));
		       	
//		       	System.out.println("Columnn Name-->"+col_name+" -Avg VAlue-->"+res);
		       	
		       	
		       	if(Double.isNaN(res))
		       	{
		       		
		       	}
		       	else
		       	{
		       		Qtr_Avg ob = new Qtr_Avg();
			       	
			       	ob.setQuarter(col_name);
			       	ob.setAverage(res);
			       	ob.setFund_Type(Fund_Type);
//			       	System.out.println("saving VALUE of Res in Object// value of K-->>"+k);
			       	
			       	ssn.saveOrUpdate(ob);		
		       	}
		       	
		       
		       	
		       	
	       	
		   }
		   
		   ssn.getTransaction().commit();
		   ssn.close();
		   System.out.println("<----Saved/Updated Quarter Average Table---->");
		   
		   int cellnum =0;
		   int rownum = sheet.getLastRowNum();
			
		   Row row = sheet.createRow(rownum++); 
		   for(String rv :final_row)
		   { 
			   Cell cell = row.createCell(cellnum++);
	           cell.setCellValue(rv);
	       }
		   
		   
		    ssn = HIbernateSession.getSessionFactory().openSession();     
		    ssn.beginTransaction();
		    
	// Saving the Return_value column in db by comparing the value by Qtr_Avg table
		    
		    ArrayList<Qtr_Avg> qtr_avg_list = (ArrayList<Qtr_Avg>) ssn.createCriteria(Qtr_Avg.class).add(Restrictions.eq("Fund_Type", Fund_Type)).list();
		    int db_flg=0;
		    
		    for(Qtr_Avg qa : qtr_avg_list)
		    {
		    	ArrayList<Avg_ret_Model> avg_return_list = (ArrayList<Avg_ret_Model>) ssn.createCriteria(Avg_ret_Model.class).add(Restrictions.eq("comment", qa.getQuarter())).add(Restrictions.eq("key.Fund_Type", Fund_Type)).list();
		    	
		         for(Avg_ret_Model a_r_m: avg_return_list)
		         {
		        	 if(a_r_m.getNav_val() >= qa.getAverage())
		        	 {
		        		 a_r_m.setReturn_value(1);
		        		 ssn.update(a_r_m);
		        		 db_flg++;
		        		 
		        	 }
		        	 else
		        	 {
		        		 a_r_m.setReturn_value(-1);
		        		 ssn.update(a_r_m);
		        		 db_flg++;
		        		 
		        	 }
		        	 
		        	 
		        	 

		         }
		       
	        	 if(db_flg%50==0)
	        	 {
	        		 
	        		 ssn.flush();
	        		 ssn.clear();
	        		 ssn.getTransaction().commit();
	        		 ssn.beginTransaction();
	        		 db_flg=0;
	        	 }
		        
		    	
		    }
		      
		    ssn.getTransaction().commit();
	    	ssn.close();
		       
		    
		   
		   
		   
		   System.out.println("--Calculated Average---");
		   return sheet;
		   
	}
	
	private static int Get_Rank(String comment, Long s_code, Session ssn , String Fund_Type) {
	
		ArrayList<String> tmp =new ArrayList<String>();
		int r=0;
		ArrayList<String> comment_list = null;
		
		String hql = "from avg_return where"+" scheme_code=:s_cd and comment=:cmnt and Fund_Type='"+Fund_Type+"'";            
		Query q = ssn.createQuery(hql);
		q.setParameter("s_cd", s_code);
		q.setParameter("cmnt", comment);
  		
   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
        
   		
   		
   		if(a_r_m.size()!=0)
   		{
   			r = a_r_m.get(0).getRank();
   		}
        
		return r;
	}

	
	
	public static double Generate_rows(String cmnt,Long s_code, Session ssn, String Fund_Type)
	{
//		ArrayList<String> tmp =new ArrayList<String>();
		double r=0;
		ArrayList<String> comment_list = null;
//        Session ssn = HIbernateSession.getSessionFactory().openSession();
//        ssn.beginTransaction();
		
		String hql = "from avg_return where"+" scheme_code=:s_cd and comment=:cmnt and key.Fund_Type='"+Fund_Type+"'";            
		Query q = ssn.createQuery(hql);
		q.setParameter("s_cd", s_code);
		q.setParameter("cmnt", cmnt);
		
		
		
//        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//// 		criteria_1.setProjection( Projections.distinct(Projections.property("comment")));  		
//   		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
//   		criteria_1.add(Restrictions.eq("comment", cmnt));
//   		criteria_1.setMaxResults(1);
   		
   		ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
        
   		
   		
   		if(a_r_m.size()!=0)
   		{
   			r = a_r_m.get(0).getNav_val();
   		}
        
		return r;
		
//        ssn.getTransaction().commit();
//        ssn.close();
//		return tmp;
	}
	
	
	public static void main(String[] args) 
	{
		 int comment_list_length=0;
		 String Fund_Type;
         ArrayList<ArrayList<String>> book = new ArrayList<ArrayList<String>>();
         double res=0;
         int rank=0;
         int flag=0;
         ArrayList<String> comment_list = null;
         ArrayList<Long> scheme_code_list = null;
         
         ArrayList<Long> scheme_code_list_temp = new ArrayList<Long>();
         
         
         Session ssn = HIbernateSession.getSessionFactory().openSession();
//		 ssn.beginTransaction();
         
         // Type of fund is responsible for selecting appropriate scheme codes  
//         Fund_Type="EQUITY_ELSS"; // This field is mandatory
         Fund_Type="EQUITY_SML"; // This field is mandatory
         
                        
         
//                         // If required to done MANUALY for some scheme_Code 
//				         long[] schm_cd_lst = {23,407,447,489,716,748,758,903,905,931,933,942,950,1131,1273,1282,1283,1284,1331,1346,1348,1441,1464,1492,1608,1623,1849,1858,1956,1962,1973,2069,2090,2127,2129,2133,2171,2235,2271,2384,2390,2455,2461,2654,2669,2681,2711,2752,2782,2860,2896,3065,3247,3249,3281,3305,3317,3461,3581,3587,3626,3641,3644,4282,4457,4980,5153,6075,7329,7615,7747,7785,7841,7870,7874,8151,8217,8229,8250,8463,9078,9240,11889,12836,12860,12865,14493,14559,15557,16672,16706,21293,21769,24776,25378,25473,25995,26481,26778,27106,27775,28707,29082,29277,29359,29360,29424,29786,30021,30022,30395,30396,30397,31046,31353,31451,31571,31642,31837,32280,32348,32542,32658,33053,35321};
//				         
//				         for(long b : schm_cd_lst)
//				         {
//				        	 scheme_code_list_temp.add(b);
//				         }
//				         
//				         System.out.println("Added to list Successfully......");
//				         
//				         comment_list = (ArrayList<String>) ssn.createQuery("select DISTINCT(comment) from avg_return where scheme_code IN :list and Fund_Type='"+Fund_Type+"' order by end_dt ").setParameterList("list", scheme_code_list_temp).list();
//				         scheme_code_list = (ArrayList<Long>) ssn.createQuery("select DISTINCT(key.scheme_code) from avg_return where scheme_code IN :list and Fund_Type='"+Fund_Type+"' order by key.scheme_code ").setParameterList("list", scheme_code_list_temp).list();
         
         
         
//          int schm_cd_lst=15;
         
         
								        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
								 		criteria_1.setProjection( Projections.distinct(Projections.property("comment")));
								 		criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
								//   		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
								   		criteria_1.addOrder(Order.asc("end_dt"));
   		
   		
//   		Criteria criteria_2 = ssn.createCriteria( nav_report_3_stable.class );
// 		criteria_2.setProjection( Projections.distinct(Projections.property("scheme_Code")));
// 		criteria_2.add(Restrictions.eq("Fund_Type", Fund_Type));
////   		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
//   		criteria_2.addOrder(Order.asc("scheme_Code"));
   		
									   		Criteria criteria_2 = ssn.createCriteria( Avg_ret_Model.class );
									 		criteria_2.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
									 		criteria_2.add(Restrictions.eq("key.Fund_Type", Fund_Type));
									//   		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
									   		criteria_2.addOrder(Order.asc("key.scheme_code"));
   		
   		   		
		comment_list = (ArrayList<String>) criteria_1.list();
		scheme_code_list = (ArrayList<Long>) criteria_2.list();
   		
   		
   		
		comment_list_length=comment_list.size();
//		ssn.getTransaction().commit();
 
       ArrayList<String> rows=null;
      for(Long s_code : scheme_code_list)
      {
    	  rows=new ArrayList<String>();
    	  rows.add(s_code.toString());
    	  
        for(String comment:comment_list)
        {
        	 res = Generate_rows(comment ,s_code,ssn,Fund_Type);
        	 rank =Get_Rank(comment ,s_code,ssn,Fund_Type);
        	 
        	 rows.add(Double.toString(res));
        	 rows.add(Integer.toString(rank));
        	 
        }
        
        book.add(rows);  // adding each row in the main list
      } 
      ssn.close();
     
    //Blank workbook
      HSSFWorkbook workbook = new HSSFWorkbook();
      HSSFSheet sheet = workbook.createSheet("AvgReport");
      
           
      comment_list.add(0, "scheme_code");
      int index_tmp=0;
      ArrayList<String> comment_list_revised = new ArrayList<String>(); 
    
      // adding the rank field in the exal files heading
      for(String xx :comment_list)
      { 
		if(index_tmp!=0)
		{
			comment_list_revised.add(xx);
			comment_list_revised.add(xx+"_Rank");
		}
		else
		{
			comment_list_revised.add(xx);
		}
		index_tmp++;
      }
     
      book.add(0, comment_list_revised);
      
      Map<Integer, String[]> data = new TreeMap<Integer, String[]>();
      int ln_no=0;
      for(ArrayList<String> lt : book)
        {
    	  String[] stockArr = new String[lt.size()];
    	  stockArr = lt.toArray(stockArr);
    	  
    	  data.put(++ln_no,stockArr);
    	  
        } 
    	  
      Set<Integer> keyset = data.keySet();
      int rownum = 0;
      for (int key : keyset)
      {
          Row row = sheet.createRow(rownum++);
          Object [] objArr = data.get(key);
          int cellnum = 0;
          for (Object obj : objArr)
          {
             Cell cell = row.createCell(cellnum++);
             if(obj instanceof String)
                  cell.setCellValue((String)obj);
              else if(obj instanceof Integer)
                  cell.setCellValue((Integer)obj);
          }
      }
            
      sheet = Get_Average_Column_WISE(sheet,scheme_code_list.size() ,comment_list_revised.size(), Fund_Type);
      
//      GeneRating the New Sheet With 1 and -1 
        
       Get_Cat_Avg_Indicator( scheme_code_list,comment_list,Fund_Type) ;
       
      
      
      
      try {
			FileOutputStream out = 
					new FileOutputStream(new File("/home/rv/Desktop/SampleReport.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");
			
			
			
			
		  }       
      catch (FileNotFoundException e) 
          {
			 e.printStackTrace();
		  } catch (IOException e) 
		  {
			  e.printStackTrace();
		  }     
//      XSSFWorkbook workbook = new XSSFWorkbook();
//      XSSFSheet sheet = workbook.createSheet("Java Books");
      
      

	}

	private static void Get_Cat_Avg_Indicator ( ArrayList<Long> scheme_code_list, ArrayList<String> comment_list , String Fund_Type ) 
	{
		HSSFWorkbook workbook2 = new HSSFWorkbook();
	    HSSFSheet sheet2 = workbook2.createSheet("AvgReport2");
	      	           
	    Session ssn = HIbernateSession.getSessionFactory().openSession();
    	ssn.beginTransaction();
	    
	    ArrayList<ArrayList<String>> final_fl = new ArrayList<ArrayList<String>>();
	    final_fl.add(comment_list);
	    
	    ArrayList<String> rows = null;
	    
	    
	    Criteria crt2 = ssn.createCriteria(Qtr_Avg.class);
		ArrayList<Qtr_Avg> qtr_avg_lst = (ArrayList<Qtr_Avg>) crt2.list();
		 int itr=0;
	    
	    for(long sc :scheme_code_list)
	    {
	    	rows = new ArrayList<String>();
	    	rows.add(Long.toString(sc));
//	    	comment_list.remove(0); // deleting the first element as the first element was scheme_code // added previously 
	    	itr=0;
		    	 for(String coment : comment_list)
		    	 {
		    		   if(itr==0)
		    		   {   
		    			   itr++;
		    		   
		    			   continue;
		    		   }
		    		 
		 
		    		 String hql = "FROM avg_return WHERE comment='"+coment+
				     "' and scheme_code="+sc+" and key.Fund_Type='"+Fund_Type+"'" ;
				
				     Query query = ssn.createQuery(hql);
		    		 
		    		 		    		 		    		 
		    		 List<Avg_ret_Model> nrt_lst = query.list();
		    		 
		    		 
		    		 if(nrt_lst.size()>=1)
		    		 {
		    			    
		    			 for(Qtr_Avg qa : qtr_avg_lst)
		    			  {
		    			     if( qa.getQuarter().equals(nrt_lst.get(0).getComment()) || qa.getQuarter()==(nrt_lst.get(0).getComment()) )
		    			     {
		    			    	 if(nrt_lst.get(0).getNav_val() >= qa.getAverage())
		    			    	 {
		    			    		 rows.add("1"); // if greater than average value 
		    			    	 }
		    			    	 else
		    			    	 {
		    			    		 rows.add("-1"); // if lesser than average value
		    			    	 }
		    			     }
		    			  }
		    			 		    			 
		    			 
		    		 }
		    		 else
		    		 {
		    			 rows.add(" ");
		    		 }
		    		 
		    	    itr++;
		    	 }
		    	 final_fl.add(rows); 
	    } 
	    
	    
	        // finally Writing the Excel file and DATA
	    
	       
	    Map<Integer, String[]> data = new TreeMap<Integer, String[]>();
	      int ln_no=0;
	      for(ArrayList<String> lt : final_fl)
	        {
	    	  String[] stockArr = new String[lt.size()];
	    	  stockArr = lt.toArray(stockArr);
	    	  
	    	  data.put(++ln_no,stockArr);
	    	  
	        } 
	    	  
	      Set<Integer> keyset = data.keySet();
	      int rownum = 0;
	      for (int key : keyset)
	      {
	          Row row = sheet2.createRow(rownum++);
	          Object [] objArr = data.get(key);
	          int cellnum = 0;
	          for (Object obj : objArr)
	          {
	             Cell cell = row.createCell(cellnum++);
	             if(obj instanceof String)
	                  cell.setCellValue((String)obj);
	              else if(obj instanceof Integer)
	                  cell.setCellValue((Integer)obj);
	          }
	      }
	      
	      ssn.close();
	      
	      
	      try {
				FileOutputStream out = 
						new FileOutputStream(new File("/home/rv/Desktop/SampleReport_Cat_Avg_Indicator.xls"));
				workbook2.write(out);
				out.close();
				System.out.println("2nd Excel written successfully..");
				
				
				
				
			  }       
	      catch (FileNotFoundException e) 
	          {
				 e.printStackTrace();
			  } catch (IOException e) 
			  {
				  e.printStackTrace();
			  }     
	      
	      
	      
	    
	    
	  		
	}

	
}
