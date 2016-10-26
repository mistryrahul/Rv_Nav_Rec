package controller;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Bm_Pk implements Serializable
{
	   java.util.Date dte;
	   long Index_Code;
	   
	   
	public java.util.Date getDte() {
		return dte;
	}
	public void setDte(java.util.Date dte) {
		this.dte = dte;
	}
	public long getIndex_Code() {
		return Index_Code;
	}
	public void setIndex_Code(long index_Code) {
		Index_Code = index_Code;
	}
	   
	   
	   
	   
}
