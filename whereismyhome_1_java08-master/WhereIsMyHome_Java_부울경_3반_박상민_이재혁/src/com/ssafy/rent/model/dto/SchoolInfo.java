package com.ssafy.rent.model.dto;

public class SchoolInfo {
	private int no;
	private String dong;
	private String SchName;
	private String code;
	private String address;
	private String phone;
	private String fax;
	private String homepage;
	
	public SchoolInfo () {}

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

	public String getSchName() {
		return SchName;
	}

	public void setSchName(String schName) {
		SchName = schName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "SchoolInfo [no=" + no + ", dong=" + dong + ", SchName=" + SchName + ", code=" + code + ", address="
				+ address + ", phone=" + phone + ", fax=" + fax + ", homepage=" + homepage + "]";
	}
	
	
	
}
