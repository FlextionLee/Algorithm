package com.ssafy.rent.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.MarketInfo;

public class MarketCSVParser {
	List<MarketInfo> markets;
	
	public MarketCSVParser() throws WhereIsMyHomeException {
		loadData();
	}
	
	public List<MarketInfo> getMarketInfo(){
		return this.markets;
	}
	
	public void loadData() throws WhereIsMyHomeException  {
		String[] fileNames = {"res/market_1.csv", "res/market_2.csv"};
		
		this.markets = new ArrayList<>();
		
		for (String file : fileNames) {
			File csv = new File(file);
			int no = 0;
			
			try ( BufferedReader br = new BufferedReader(new FileReader(csv)); ) {
				Charset.forName("UTF-8");
				String line = null;
				
				while((line = br.readLine()) != null) {
					MarketInfo marketInfo = new MarketInfo();				
					String[] input = line.split(",");
					
					input[1] = input[1].replace("\"", "");
					if (input[1].contains("(")) {
						String[] dongParse = input[1].split("\\(");
						String dong = dongParse[1].replace(")", "");		
						marketInfo.setAddress(dongParse[0]);
						marketInfo.setDong(dong);
					} else {
						marketInfo.setAddress(input[1]);
					}
					
					marketInfo.setNo(no++);
					marketInfo.setMarketName(input[0]);		
					marketInfo.setCode(input[2]);
					marketInfo.setEtc(input[3]);
					markets.add(marketInfo);
				} 
			} catch(Exception e) {
	        	throw new WhereIsMyHomeException();
	        }
		}
		
	}
}
