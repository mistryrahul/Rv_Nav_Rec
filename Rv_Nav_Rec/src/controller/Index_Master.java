package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Index_Master 
{
	@Id
	long IndexCode;
	long Fincode;
	String Scripcode;
	String IndexName;
	public long getIndexCode() {
		return IndexCode;
	}
	public void setIndexCode(long indexCode) {
		IndexCode = indexCode;
	}
	public long getFincode() {
		return Fincode;
	}
	public void setFincode(long fincode) {
		Fincode = fincode;
	}
	public String getScripcode() {
		return Scripcode;
	}
	public void setScripcode(String scripcode) {
		Scripcode = scripcode;
	}
	public String getIndexName() {
		return IndexName;
	}
	public void setIndexName(String indexName) {
		IndexName = indexName;
	}
	
	
	
	
	
}
