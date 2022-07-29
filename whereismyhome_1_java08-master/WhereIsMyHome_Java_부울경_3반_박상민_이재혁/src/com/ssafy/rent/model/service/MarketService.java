package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dto.MarketInfo;

public interface MarketService {
	List<MarketInfo> searchAll(String dong);
}
