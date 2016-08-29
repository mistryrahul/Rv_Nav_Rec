import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Custom_Merged_report_quarterwise_Main {

	public static void main(String[] args) {
		
		Session ssn = null;
		ArrayList<java.util.Date> start_dt_list = new ArrayList<java.util.Date>();
		
		ArrayList<java.util.Date> end_dt_list = new ArrayList<java.util.Date>();
		
		start_dt_list.add(new Date(103, 05, 30));
		
		
        
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		ssn = sessionfactry.openSession();
		ssn.beginTransaction();
		
		String query_2 ="select distinct(from_date) from Report_Merged_5_6_8_Model where quarter in(select distinct(quarter) from Report_Merged_5_6_8_Model where from_date>=? and from_date<=? order by from_date desc) order by from_date";
       		
		ArrayList<java.util.Date> dt_lst_mn= (ArrayList<Date>) ssn.createQuery(query_2).list();
		
		
		
		

	}

}
