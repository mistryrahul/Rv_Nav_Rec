import java.io.PrintWriter;
import java.util.ArrayList;

import org.hibernate.Session;

import controller.Company_Master;
import controller.Scheme_Detail;
import controller.nav_hist;
import sessionFactory.HIbernateSession;

public class New_Report_M {

	public static void main(String[] args) 
	{
		ArrayList<Scheme_Detail> mn_lst=null;
		ArrayList<nav_hist> nav_hist=null;
		
//		long primary_fd_code[] ={10,169,203,262,298,387,391,472,484,505,554,557,579,605,711,740,811,820,891,914,923,1026,1037,1058,1071,1106,1135,1335,1410,1451,1472,1474,1507,1632,1636,1639,1640,1643,1651,1669,1670,1687,1946,1958,1960,1987,2063,2601,2619,2632,2824,2841,2961,3021,3039,3316,3414,3588,3598,3637,3654,3706,3716,3784,3786,3938,4005,4138,4212,4569,4606,6441,6456,6581,6861,6928,7400,7824,7827,7831,8012};
        
		long primary_fd_code[] ={2238,2250,3210, 3262,3301,7838};
		
		String sql="select scheme_code, AMFI_NAME, PLAN from Scheme_Detail where PRIMARY_FD_CODE="+" AND STATUS = 'Active' AND PLAN NOT IN ('7','5') AND OPT_CODE IN= ('2','1')";
		
		String sql_2="from nav_hist_full_test where scheme_code="+" order by nav_date desc";
		Session ssn = null;
		
		try
		{
			ssn = HIbernateSession.getSessionFactory().openSession();
			ssn.beginTransaction();
			
			PrintWriter writer = new PrintWriter("/home/rv/Desktop/NEW_MV_2.csv", "UTF-8");
			
			
			for(long p_fd_c : primary_fd_code)
			{
				 mn_lst = (ArrayList<Scheme_Detail>) ssn.createQuery("from Scheme_Detail where PRIMARY_FD_CODE=? AND STATUS='Active' AND PLAN NOT IN ('7','5') AND OPT_CODE IN ('2','1')").setLong(0, p_fd_c).list();
				 
				 if(mn_lst.size() > 0)
				 {
					   for(Scheme_Detail sd : mn_lst)
					   {
						   nav_hist = (ArrayList<controller.nav_hist>) ssn.createQuery("from nav_hist_full_test where scheme_code=? order by nav_date desc").setLong(0, sd.getScheme_code()).list();
						   
						   if(nav_hist.size()>0)
						   {
							   writer.println(sd.getScheme_code()+","+sd.getAMFI_NAME()+","+sd.getS_NAME()+","+sd.getTYPE_CODE()+","+sd.getOPT_CODE()+","+sd.getPRIMARY_FUND()+","+sd.getPRIMARY_FD_CODE()+","+sd.getSTATUS()+","+sd.getIsPurchaseAvailable()+","+sd.getPLAN()+","+sd.getDiv_Code()+","+nav_hist.get(0).getAdjnavrs()+","+nav_hist.get(0).getNavrs());
						   }
						   else
						   {
							   writer.println(sd.getScheme_code()+","+sd.getAMFI_NAME()+","+sd.getS_NAME()+","+sd.getTYPE_CODE()+","+sd.getOPT_CODE()+","+sd.getPRIMARY_FUND()+","+sd.getPRIMARY_FD_CODE()+","+sd.getSTATUS()+","+sd.getIsPurchaseAvailable()+","+sd.getPLAN()+","+sd.getDiv_Code());    
						   }
						   
					   }
				 }
			  	 
				 
			}
				
			writer.close();
			
			
			
		
			 ssn.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("<<<<<--Thnak God ... Report Comkplete --->>>>");
		}
		
	}

}
