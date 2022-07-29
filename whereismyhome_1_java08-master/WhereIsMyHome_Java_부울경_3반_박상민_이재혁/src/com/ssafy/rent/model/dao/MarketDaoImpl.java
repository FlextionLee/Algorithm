package com.ssafy.rent.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.MarketInfo;
import com.ssafy.rent.util.MarketCSVParser;

public class MarketDaoImpl implements MarketDao {
	private List<MarketInfo> markets;

	public MarketDaoImpl() {
		loadData();
	}
	
	@Override
	public void loadData() {
		try {
			MarketCSVParser parser = new MarketCSVParser();
			markets = parser.getMarketInfo();
		} catch (WhereIsMyHomeException  e) {
			markets = new ArrayList<>();
		}
	}

	@Override
	public List<MarketInfo> searchAll(String dong) {		
		List<MarketInfo> finds = new ArrayList<>();
		for (MarketInfo market : markets) {
			try {
				if (market.getDong().equals(dong)) finds.add(market);
			} catch (NullPointerException e) {	// 동 정보가 없는 경우 catch 한 후 나머지 가게들 탐색
				System.out.println("동 정보가 없는 가게정보가 있음");
				continue;	// 계속 탐색
			}
		}		
		return finds;
	}	
}
