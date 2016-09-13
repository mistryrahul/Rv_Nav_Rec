package debt_Controller;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credit_rating_sum_groups 
{
   @Id
    int id; 
    long scheme_code;
	java.util.Date inv_date;
	String rv_group;
	String classification;
    double hold_percent;
   			
   

public String getClassification() {
	return classification;
}
public void setClassification(String classification) {
	this.classification = classification;
}

public double getHold_percent() {
	return hold_percent;
}
public void setHold_percent(double hold_percent) {
	this.hold_percent = hold_percent;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public long getScheme_code() {
	return scheme_code;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public java.util.Date getInv_date() {
	return inv_date;
}
public void setInv_date(java.util.Date inv_date) {
	this.inv_date = inv_date;
}
public String getRv_group() {
	return rv_group;
}
public void setRv_group(String rv_group) {
	this.rv_group = rv_group;
}

}
