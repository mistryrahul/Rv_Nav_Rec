package controller;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scheme_Detail 
{
     @Id
	 long scheme_code;
     
	 long AMFI_CODE;
	 String CAMS_CODE;
	 long AMC_CODE;
	 String S_NAME;
	 String AMFI_NAME;
	 String ISIN_CODE;
	 int TYPE_CODE;
	 int OPT_CODE;
	 int CLASSCODE;
	 int THEME_CODE;
	 int RT_CODE;
	 int PLAN;
	 int CUST_CODE;
	 int CUST_CODE2;
	 int PRICE_FREQ;
	 double INIT_PRICE;
	 double OFFERPRICE;
	 java.util.Date NFO_OPEN;
	 java.util.Date NFO_CLOSE;
	 java.util.Date REOPEN_DT;
	 String ELF;
	 String ETF;
	 String STP;
	 String PRIMARY_FUND;
	 long PRIMARY_FD_CODE;
	 String SIP;
	 String SWP;
	 String SWITCH;
	 double MININVT;
	 int MULTIPLES;
	 double INC_INVEST;
	 double ADNMULTIPLES;
	 String FUND_MGR1;
	 String FUND_MGR2;
	 String FUND_MGR3;
	 String FUND_MGR4;
	 java.util.Date SINCE;
	 String STATUS;
	 String CUTSUB;
	 String CUTRED;
	 String RED;
	 String MOB_NAME;
	 int DIV_FREQ;
	 String Scheme_Symbol;
	 int FUND_MGR_CODE1;
	 int FUND_MGR_CODE2;
	 int FUND_MGR_CODE3;
	 int FUND_MGR_CODE4;
	 java.util.Date Redemption_date;
	 java.util.Date DateOfAllot;
	 double Div_Code;
	 String LegalNames;
	 String AMFIType;
	 String NonTxnDay;
	 String SchemeBank;
	 String SchemeBankAccountNumber;
	 String SchemeBankBranch;
	 String DividendOptionFlag;
	 String LockInPeriod;
	 String IsPurchaseAvailable;
	 String IsRedeemAvailable;
	 double MinRedemptionAmount;
	 double RedemptionMultipleAmount;
	 double MinRedemptionUnits;
	 double RedemptionMultiplesUnits;
	 double MinSwitchAmount;
	 double SwitchMultipleAmount;
	 double MinSwitchUnits;
	 double SwitchMultiplesUnits;
	 String SecurityCode;
	 String Unit;
	 String SwitchOut;
	 double MinSwitchOutAmount;
	 double SwitchOutMultipleAmount;
	 double MinSwitchOutUnits;
	 double SwitchOutMultiplesUnits;
	 java.util.Date Incept_date;
	 double Incept_Nav;
	 String DefaultOpt;
	 String DefaultPlan;
	 int LockPeriod;
	 java.util.Date ODDraftDate;
	 String RV_Classification;
	 
	 
	 
	 
	 
	 public Scheme_Detail()
	 {
		 
	 }
	 
	public void Copy_Objects(Scheme_Detail obj) {
		
		scheme_code = obj.scheme_code;
		AMFI_CODE = obj.AMFI_CODE;
		CAMS_CODE = obj.CAMS_CODE;
		AMC_CODE = obj.AMC_CODE;
		S_NAME = obj.S_NAME;
		AMFI_NAME = obj.AMFI_NAME;
		ISIN_CODE = obj.ISIN_CODE;
		TYPE_CODE = obj.TYPE_CODE;
		OPT_CODE = obj.OPT_CODE;
		CLASSCODE = obj.CLASSCODE;
		THEME_CODE = obj.THEME_CODE;
		RT_CODE = obj.RT_CODE;
		PLAN = obj.PLAN;
		CUST_CODE = obj.CUST_CODE;
		CUST_CODE2 = obj.CUST_CODE2;
		PRICE_FREQ = obj.PRICE_FREQ;
		INIT_PRICE = obj.INIT_PRICE;
		OFFERPRICE = obj.OFFERPRICE;
		NFO_OPEN = obj.NFO_OPEN;
		NFO_CLOSE = obj.NFO_CLOSE;
		REOPEN_DT = obj.REOPEN_DT;
		ELF = obj.ELF;
		ETF = obj.ETF;
		STP = obj.STP;
		PRIMARY_FUND = obj.PRIMARY_FUND;
		PRIMARY_FD_CODE = obj.PRIMARY_FD_CODE;
		SIP = obj.SIP;
		SWP = obj.SWP;
		SWITCH = obj.SWITCH;
		MININVT = obj.MININVT;
		MULTIPLES = obj.MULTIPLES;
		INC_INVEST = obj.INC_INVEST;
		ADNMULTIPLES = obj.ADNMULTIPLES;
		FUND_MGR1 = obj.FUND_MGR1;
		FUND_MGR2 = obj.FUND_MGR2;
		FUND_MGR3 = obj.FUND_MGR3;
		FUND_MGR4 = obj.FUND_MGR4;
		SINCE = obj.SINCE;
		STATUS = obj.STATUS;
		CUTSUB = obj.CUTSUB;
		CUTRED = obj.CUTRED;
		RED = obj.RED;
		MOB_NAME = obj.MOB_NAME;
		DIV_FREQ = obj.DIV_FREQ;
		Scheme_Symbol = obj.Scheme_Symbol;
		FUND_MGR_CODE1 = obj.FUND_MGR_CODE1;
		FUND_MGR_CODE2 = obj.FUND_MGR_CODE2;
		FUND_MGR_CODE3 = obj.FUND_MGR_CODE3;
		FUND_MGR_CODE4 = obj.FUND_MGR_CODE4;
		Redemption_date = obj.Redemption_date;
		DateOfAllot = obj.DateOfAllot;
		Div_Code = obj.Div_Code;
		LegalNames = obj.LegalNames;
		AMFIType = obj.AMFIType;
		NonTxnDay = obj.NonTxnDay;
		SchemeBank = obj.SchemeBank;
		SchemeBankAccountNumber = obj.SchemeBankAccountNumber;
		SchemeBankBranch = obj.SchemeBankBranch;
		DividendOptionFlag = obj.DividendOptionFlag;
		LockInPeriod = obj.LockInPeriod;
		IsPurchaseAvailable = obj.IsPurchaseAvailable;
		IsRedeemAvailable = obj.IsRedeemAvailable;
		MinRedemptionAmount = obj.MinRedemptionAmount;
		RedemptionMultipleAmount = obj.RedemptionMultipleAmount;
		MinRedemptionUnits = obj.MinRedemptionUnits;
		RedemptionMultiplesUnits = obj.RedemptionMultiplesUnits;
		MinSwitchAmount = obj.MinSwitchAmount;
		SwitchMultipleAmount = obj.SwitchMultipleAmount;
		MinSwitchUnits = obj.MinSwitchUnits;
		SwitchMultiplesUnits = obj.SwitchMultiplesUnits;
		SecurityCode = obj.SecurityCode;
		Unit = obj.Unit;
		SwitchOut = obj.SwitchOut;
		MinSwitchOutAmount = obj.MinSwitchOutAmount;
		SwitchOutMultipleAmount = obj.SwitchOutMultipleAmount;
		MinSwitchOutUnits = obj.MinSwitchOutUnits;
		SwitchOutMultiplesUnits = obj.SwitchOutMultiplesUnits;
		Incept_date = obj.Incept_date;
		Incept_Nav = obj.Incept_Nav;
		DefaultOpt = obj.DefaultOpt;
		DefaultPlan = obj.DefaultPlan;
		LockPeriod = obj.LockPeriod;
		ODDraftDate = obj.ODDraftDate;
		RV_Classification = obj.RV_Classification;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public long getAMFI_CODE() {
		return AMFI_CODE;
	}
	public void setAMFI_CODE(long aMFI_CODE) {
		AMFI_CODE = aMFI_CODE;
	}
	public String getCAMS_CODE() {
		return CAMS_CODE;
	}
	public void setCAMS_CODE(String cAMS_CODE) {
		CAMS_CODE = cAMS_CODE;
	}
	public long getAMC_CODE() {
		return AMC_CODE;
	}
	public void setAMC_CODE(long aMC_CODE) {
		AMC_CODE = aMC_CODE;
	}
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public String getAMFI_NAME() {
		return AMFI_NAME;
	}
	public void setAMFI_NAME(String aMFI_NAME) {
		AMFI_NAME = aMFI_NAME;
	}
	public String getISIN_CODE() {
		return ISIN_CODE;
	}
	public void setISIN_CODE(String iSIN_CODE) {
		ISIN_CODE = iSIN_CODE;
	}
	public int getTYPE_CODE() {
		return TYPE_CODE;
	}
	public void setTYPE_CODE(int tYPE_CODE) {
		TYPE_CODE = tYPE_CODE;
	}
	public int getOPT_CODE() {
		return OPT_CODE;
	}
	public void setOPT_CODE(int oPT_CODE) {
		OPT_CODE = oPT_CODE;
	}
	public int getCLASSCODE() {
		return CLASSCODE;
	}
	public void setCLASSCODE(int cLASSCODE) {
		CLASSCODE = cLASSCODE;
	}
	public int getTHEME_CODE() {
		return THEME_CODE;
	}
	public void setTHEME_CODE(int tHEME_CODE) {
		THEME_CODE = tHEME_CODE;
	}
	public int getRT_CODE() {
		return RT_CODE;
	}
	public void setRT_CODE(int rT_CODE) {
		RT_CODE = rT_CODE;
	}
	public int getPLAN() {
		return PLAN;
	}
	public void setPLAN(int pLAN) {
		PLAN = pLAN;
	}
	public int getCUST_CODE() {
		return CUST_CODE;
	}
	public void setCUST_CODE(int cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	public int getCUST_CODE2() {
		return CUST_CODE2;
	}
	public void setCUST_CODE2(int cUST_CODE2) {
		CUST_CODE2 = cUST_CODE2;
	}
	public int getPRICE_FREQ() {
		return PRICE_FREQ;
	}
	public void setPRICE_FREQ(int pRICE_FREQ) {
		PRICE_FREQ = pRICE_FREQ;
	}
	public double getINIT_PRICE() {
		return INIT_PRICE;
	}
	public void setINIT_PRICE(double iNIT_PRICE) {
		INIT_PRICE = iNIT_PRICE;
	}
	public double getOFFERPRICE() {
		return OFFERPRICE;
	}
	public void setOFFERPRICE(double oFFERPRICE) {
		OFFERPRICE = oFFERPRICE;
	}
	public java.util.Date getNFO_OPEN() {
		return NFO_OPEN;
	}
	public void setNFO_OPEN(java.util.Date nFO_OPEN) {
		NFO_OPEN = nFO_OPEN;
	}
	public java.util.Date getNFO_CLOSE() {
		return NFO_CLOSE;
	}
	public void setNFO_CLOSE(java.util.Date nFO_CLOSE) {
		NFO_CLOSE = nFO_CLOSE;
	}
	public java.util.Date getREOPEN_DT() {
		return REOPEN_DT;
	}
	public void setREOPEN_DT(java.util.Date rEOPEN_DT) {
		REOPEN_DT = rEOPEN_DT;
	}
	public String getELF() {
		return ELF;
	}
	public void setELF(String eLF) {
		ELF = eLF;
	}
	public String getETF() {
		return ETF;
	}
	public void setETF(String eTF) {
		ETF = eTF;
	}
	public String getSTP() {
		return STP;
	}
	public void setSTP(String sTP) {
		STP = sTP;
	}
	public String getPRIMARY_FUND() {
		return PRIMARY_FUND;
	}
	public void setPRIMARY_FUND(String pRIMARY_FUND) {
		PRIMARY_FUND = pRIMARY_FUND;
	}
	public long getPRIMARY_FD_CODE() {
		return PRIMARY_FD_CODE;
	}
	public void setPRIMARY_FD_CODE(long pRIMARY_FD_CODE) {
		PRIMARY_FD_CODE = pRIMARY_FD_CODE;
	}
	public String getSIP() {
		return SIP;
	}
	public void setSIP(String sIP) {
		SIP = sIP;
	}
	public String getSWP() {
		return SWP;
	}
	public void setSWP(String sWP) {
		SWP = sWP;
	}
	public String getSWITCH() {
		return SWITCH;
	}
	public void setSWITCH(String sWITCH) {
		SWITCH = sWITCH;
	}
	public double getMININVT() {
		return MININVT;
	}
	public void setMININVT(double mININVT) {
		MININVT = mININVT;
	}
	public int getMULTIPLES() {
		return MULTIPLES;
	}
	public void setMULTIPLES(int mULTIPLES) {
		MULTIPLES = mULTIPLES;
	}
	public double getINC_INVEST() {
		return INC_INVEST;
	}
	public void setINC_INVEST(double iNC_INVEST) {
		INC_INVEST = iNC_INVEST;
	}
	public double getADNMULTIPLES() {
		return ADNMULTIPLES;
	}
	public void setADNMULTIPLES(double aDNMULTIPLES) {
		ADNMULTIPLES = aDNMULTIPLES;
	}
	public String getFUND_MGR1() {
		return FUND_MGR1;
	}
	public void setFUND_MGR1(String fUND_MGR1) {
		FUND_MGR1 = fUND_MGR1;
	}
	public String getFUND_MGR2() {
		return FUND_MGR2;
	}
	public void setFUND_MGR2(String fUND_MGR2) {
		FUND_MGR2 = fUND_MGR2;
	}
	public String getFUND_MGR3() {
		return FUND_MGR3;
	}
	public void setFUND_MGR3(String fUND_MGR3) {
		FUND_MGR3 = fUND_MGR3;
	}
	public String getFUND_MGR4() {
		return FUND_MGR4;
	}
	public void setFUND_MGR4(String fUND_MGR4) {
		FUND_MGR4 = fUND_MGR4;
	}
	public java.util.Date getSINCE() {
		return SINCE;
	}
	public void setSINCE(java.util.Date sINCE) {
		SINCE = sINCE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCUTSUB() {
		return CUTSUB;
	}
	public void setCUTSUB(String cUTSUB) {
		CUTSUB = cUTSUB;
	}
	public String getCUTRED() {
		return CUTRED;
	}
	public void setCUTRED(String cUTRED) {
		CUTRED = cUTRED;
	}
	public String getRED() {
		return RED;
	}
	public void setRED(String rED) {
		RED = rED;
	}
	public String getMOB_NAME() {
		return MOB_NAME;
	}
	public void setMOB_NAME(String mOB_NAME) {
		MOB_NAME = mOB_NAME;
	}
	public int getDIV_FREQ() {
		return DIV_FREQ;
	}
	public void setDIV_FREQ(int dIV_FREQ) {
		DIV_FREQ = dIV_FREQ;
	}
	public String getScheme_Symbol() {
		return Scheme_Symbol;
	}
	public void setScheme_Symbol(String scheme_Symbol) {
		Scheme_Symbol = scheme_Symbol;
	}
	public int getFUND_MGR_CODE1() {
		return FUND_MGR_CODE1;
	}
	public void setFUND_MGR_CODE1(int fUND_MGR_CODE1) {
		FUND_MGR_CODE1 = fUND_MGR_CODE1;
	}
	public int getFUND_MGR_CODE2() {
		return FUND_MGR_CODE2;
	}
	public void setFUND_MGR_CODE2(int fUND_MGR_CODE2) {
		FUND_MGR_CODE2 = fUND_MGR_CODE2;
	}
	public int getFUND_MGR_CODE3() {
		return FUND_MGR_CODE3;
	}
	public void setFUND_MGR_CODE3(int fUND_MGR_CODE3) {
		FUND_MGR_CODE3 = fUND_MGR_CODE3;
	}
	public int getFUND_MGR_CODE4() {
		return FUND_MGR_CODE4;
	}
	public void setFUND_MGR_CODE4(int fUND_MGR_CODE4) {
		FUND_MGR_CODE4 = fUND_MGR_CODE4;
	}
	public java.util.Date getRedemption_date() {
		return Redemption_date;
	}
	public void setRedemption_date(java.util.Date redemption_date) {
		Redemption_date = redemption_date;
	}
	public java.util.Date getDateOfAllot() {
		return DateOfAllot;
	}
	public void setDateOfAllot(java.util.Date dateOfAllot) {
		DateOfAllot = dateOfAllot;
	}
	public double getDiv_Code() {
		return Div_Code;
	}
	public void setDiv_Code(double div_Code) {
		Div_Code = div_Code;
	}
	public String getLegalNames() {
		return LegalNames;
	}
	public void setLegalNames(String legalNames) {
		LegalNames = legalNames;
	}
	public String getAMFIType() {
		return AMFIType;
	}
	public void setAMFIType(String aMFIType) {
		AMFIType = aMFIType;
	}
	public String getNonTxnDay() {
		return NonTxnDay;
	}
	public void setNonTxnDay(String nonTxnDay) {
		NonTxnDay = nonTxnDay;
	}
	public String getSchemeBank() {
		return SchemeBank;
	}
	public void setSchemeBank(String schemeBank) {
		SchemeBank = schemeBank;
	}
	public String getSchemeBankAccountNumber() {
		return SchemeBankAccountNumber;
	}
	public void setSchemeBankAccountNumber(String schemeBankAccountNumber) {
		SchemeBankAccountNumber = schemeBankAccountNumber;
	}
	public String getSchemeBankBranch() {
		return SchemeBankBranch;
	}
	public void setSchemeBankBranch(String schemeBankBranch) {
		SchemeBankBranch = schemeBankBranch;
	}
	public String getDividendOptionFlag() {
		return DividendOptionFlag;
	}
	public void setDividendOptionFlag(String dividendOptionFlag) {
		DividendOptionFlag = dividendOptionFlag;
	}
	public String getLockInPeriod() {
		return LockInPeriod;
	}
	public void setLockInPeriod(String lockInPeriod) {
		LockInPeriod = lockInPeriod;
	}
	public String getIsPurchaseAvailable() {
		return IsPurchaseAvailable;
	}
	public void setIsPurchaseAvailable(String isPurchaseAvailable) {
		IsPurchaseAvailable = isPurchaseAvailable;
	}
	public String getIsRedeemAvailable() {
		return IsRedeemAvailable;
	}
	public void setIsRedeemAvailable(String isRedeemAvailable) {
		IsRedeemAvailable = isRedeemAvailable;
	}
	public double getMinRedemptionAmount() {
		return MinRedemptionAmount;
	}
	public void setMinRedemptionAmount(double minRedemptionAmount) {
		MinRedemptionAmount = minRedemptionAmount;
	}
	public double getRedemptionMultipleAmount() {
		return RedemptionMultipleAmount;
	}
	public void setRedemptionMultipleAmount(double redemptionMultipleAmount) {
		RedemptionMultipleAmount = redemptionMultipleAmount;
	}
	public double getMinRedemptionUnits() {
		return MinRedemptionUnits;
	}
	public void setMinRedemptionUnits(double minRedemptionUnits) {
		MinRedemptionUnits = minRedemptionUnits;
	}
	public double getRedemptionMultiplesUnits() {
		return RedemptionMultiplesUnits;
	}
	public void setRedemptionMultiplesUnits(double redemptionMultiplesUnits) {
		RedemptionMultiplesUnits = redemptionMultiplesUnits;
	}
	public double getMinSwitchAmount() {
		return MinSwitchAmount;
	}
	public void setMinSwitchAmount(double minSwitchAmount) {
		MinSwitchAmount = minSwitchAmount;
	}
	public double getSwitchMultipleAmount() {
		return SwitchMultipleAmount;
	}
	public void setSwitchMultipleAmount(double switchMultipleAmount) {
		SwitchMultipleAmount = switchMultipleAmount;
	}
	public double getMinSwitchUnits() {
		return MinSwitchUnits;
	}
	public void setMinSwitchUnits(double minSwitchUnits) {
		MinSwitchUnits = minSwitchUnits;
	}
	public double getSwitchMultiplesUnits() {
		return SwitchMultiplesUnits;
	}
	public void setSwitchMultiplesUnits(double switchMultiplesUnits) {
		SwitchMultiplesUnits = switchMultiplesUnits;
	}
	public String getSecurityCode() {
		return SecurityCode;
	}
	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getSwitchOut() {
		return SwitchOut;
	}
	public void setSwitchOut(String switchOut) {
		SwitchOut = switchOut;
	}
	public double getMinSwitchOutAmount() {
		return MinSwitchOutAmount;
	}
	public void setMinSwitchOutAmount(double minSwitchOutAmount) {
		MinSwitchOutAmount = minSwitchOutAmount;
	}
	public double getSwitchOutMultipleAmount() {
		return SwitchOutMultipleAmount;
	}
	public void setSwitchOutMultipleAmount(double switchOutMultipleAmount) {
		SwitchOutMultipleAmount = switchOutMultipleAmount;
	}
	public double getMinSwitchOutUnits() {
		return MinSwitchOutUnits;
	}
	public void setMinSwitchOutUnits(double minSwitchOutUnits) {
		MinSwitchOutUnits = minSwitchOutUnits;
	}
	public double getSwitchOutMultiplesUnits() {
		return SwitchOutMultiplesUnits;
	}
	public void setSwitchOutMultiplesUnits(double switchOutMultiplesUnits) {
		SwitchOutMultiplesUnits = switchOutMultiplesUnits;
	}
	public java.util.Date getIncept_date() {
		return Incept_date;
	}
	public void setIncept_date(java.util.Date incept_date) {
		Incept_date = incept_date;
	}
	public double getIncept_Nav() {
		return Incept_Nav;
	}
	public void setIncept_Nav(double incept_Nav) {
		Incept_Nav = incept_Nav;
	}
	public String getDefaultOpt() {
		return DefaultOpt;
	}
	public void setDefaultOpt(String defaultOpt) {
		DefaultOpt = defaultOpt;
	}
	public String getDefaultPlan() {
		return DefaultPlan;
	}
	public void setDefaultPlan(String defaultPlan) {
		DefaultPlan = defaultPlan;
	}
	public int getLockPeriod() {
		return LockPeriod;
	}
	public void setLockPeriod(int lockPeriod) {
		LockPeriod = lockPeriod;
	}
	public java.util.Date getODDraftDate() {
		return ODDraftDate;
	}
	public void setODDraftDate(java.util.Date oDDraftDate) {
		ODDraftDate = oDDraftDate;
	}
	public String getRV_Classification() {
		return RV_Classification;
	}
	public void setRV_Classification(String rV_Classification) {
		RV_Classification = rV_Classification;
	}
	 
	 
	 
	 
	 
	 

}
