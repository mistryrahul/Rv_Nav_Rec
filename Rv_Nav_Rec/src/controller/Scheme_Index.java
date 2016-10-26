package controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Scheme_Index 
{
	@Id
	long indx;
    long scheme_code; 
	long index_code;
	
	
	
	
	public long getIndx() {
		return indx;
	}

	public void setIndx(long indx) {
		this.indx = indx;
	}

	public long getScheme_code() {
		return scheme_code;
	}

	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}

	public long getIndex_code() {
		return index_code;
	}

	public void setIndex_code(long index_code) {
		this.index_code = index_code;
	}
	
}
