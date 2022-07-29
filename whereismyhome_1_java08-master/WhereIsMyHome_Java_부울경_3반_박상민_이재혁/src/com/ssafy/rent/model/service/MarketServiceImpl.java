package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dao.MarketDao;
import com.ssafy.rent.model.dao.MarketDaoImpl;
import com.ssafy.rent.model.dto.MarketInfo;

public class MarketServiceImpl implements MarketService {
	private MarketDao dao;

	public MarketServiceImpl() {
		 dao = new MarketDaoImpl();
	}

	@Override
	public List<MarketInfo> searchAll(String dong) {
		return dao.searchAll(dong);
	}
}
