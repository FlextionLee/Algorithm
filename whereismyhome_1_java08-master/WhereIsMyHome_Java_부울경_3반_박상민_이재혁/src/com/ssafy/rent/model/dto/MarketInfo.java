package com.ssafy.rent.model.dto;

public class MarketInfo {
	private int no;
	private String dong;
	private String marketName;
	private String address;
	private String code;
	private String etc;
	
	public MarketInfo() {}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getEtc() {
		return etc;
	}

	public void setEtc(String etc) {
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "MarketInfo [no=" + no + ", dong=" + dong + ", marketName=" + marketName + ", address=" + address
				+ ", code=" + code + ", etc=" + etc + "]";
	}
	
	
}
