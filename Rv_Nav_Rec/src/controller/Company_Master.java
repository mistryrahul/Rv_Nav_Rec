package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Company_Master {

	@Id 
	long fincode;
	String SCRIPCODE;
	String SYMBOL;
	String COMPNAME;
	String S_NAME;
	int IND_CODE;
	String Ind_Name;	
	String ISIN;
	String Status;
	String eq_mf;
	String UPD_FLAG;
	
	
	
	public String getEq_mf() {
		return eq_mf;
	}
	public void setEq_mf(String eq_mf) {
		this.eq_mf = eq_mf;
	}
	public String getUPD_FLAG() {
		return UPD_FLAG;
	}
	public void setUPD_FLAG(String uPD_FLAG) {
		UPD_FLAG = uPD_FLAG;
	}
	public long getFincode() {
		return fincode;
	}
	public void setFincode(long fincode) {
		this.fincode = fincode;
	}
	public String getSCRIPCODE() {
		return SCRIPCODE;
	}
	public void setSCRIPCODE(String sCRIPCODE) {
		SCRIPCODE = sCRIPCODE;
	}
	public String getSYMBOL() {
		return SYMBOL;
	}
	public void setSYMBOL(String sYMBOL) {
		SYMBOL = sYMBOL;
	}
	public String getCOMPNAME() {
		return COMPNAME;
	}
	public void setCOMPNAME(String cOMPNAME) {
		COMPNAME = cOMPNAME;
	}
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public int getIND_CODE() {
		return IND_CODE;
	}
	public void setIND_CODE(int iND_CODE) {
		IND_CODE = iND_CODE;
	}
	public String getInd_Name() {
		return Ind_Name;
	}
	public void setInd_Name(String ind_Name) {
		Ind_Name = ind_Name;
	}
	public String getISIN() {
		return ISIN;
	}
	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
}
