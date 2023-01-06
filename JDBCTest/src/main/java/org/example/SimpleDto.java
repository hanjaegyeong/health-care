package org.example;

public class SimpleDto {
	private int colId;
	private String colNm;
	private String colNotNull;
	private String colDefaultVal;
	
	public int getColId() {
		return colId;
	}
	public void setColId(int colId) {
		this.colId = colId;
	}
	public String getColNm() {
		return colNm;
	}
	public void setColNm(String colNm) {
		this.colNm = colNm;
	}
	public String getColNotNull() {
		return colNotNull;
	}
	public void setColNotNull(String colNotNull) {
		this.colNotNull = colNotNull;
	}
	public String getColDefaultVal() {
		return colDefaultVal;
	}
	public void setColDefaultVal(String colDefaultVal) {
		this.colDefaultVal = colDefaultVal;
	}
	
	public SimpleDto() {}
	public SimpleDto(int colId, String colNm, String colNotNull, String colDefaultVal) {
		this.colId = colId;
		this.colNm = colNm;
		this.colNotNull = colNotNull;
		this.colDefaultVal = colDefaultVal;
	}
	public SimpleDto(String colNm, String colNotNull, String colDefaultVal) {
		this.colNm = colNm;
		this.colNotNull = colNotNull;
		this.colDefaultVal = colDefaultVal;
	}
	@Override
	public String toString() {
		return "SimpleDto [colId=" + colId + ", colNm=" + colNm + ", colNotNull=" + colNotNull + ", colDefaultVal="
				+ colDefaultVal + "]";
	}
	
	
}
