package com.ssafy.rent.model.dao;

import java.util.List;

import com.ssafy.rent.model.dto.MarketInfo;

public interface MarketDao {
	public void loadData();	
	
	public List<MarketInfo> searchAll(String dong);
}
