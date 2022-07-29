package com.ssafy.rent.model.dao;

import java.util.List;

import com.ssafy.rent.model.dto.SchoolInfo;

public interface SchoolDao {
	public void loadData();	
	
	public List<SchoolInfo> searchAll(String dong);
}
