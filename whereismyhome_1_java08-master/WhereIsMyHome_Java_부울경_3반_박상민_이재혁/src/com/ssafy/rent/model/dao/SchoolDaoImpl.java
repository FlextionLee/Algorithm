package com.ssafy.rent.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.SchoolInfo;
import com.ssafy.rent.util.SchoolCSVParser;

public class SchoolDaoImpl implements SchoolDao {
	private List<SchoolInfo> schools;

	public SchoolDaoImpl() {
		loadData();
	}
	
	@Override
	public void loadData() {
		try {
			SchoolCSVParser parser = new SchoolCSVParser();
			schools = parser.getSChoolInfo();
		} catch (WhereIsMyHomeException  e) {
			schools = new ArrayList<>();
		}
	}

	@Override
	public List<SchoolInfo> searchAll(String dong) {	
		List<SchoolInfo> finds = new ArrayList<>();
		for (SchoolInfo school : schools) {
			try {
				if (school.getDong().equals(dong)) finds.add(school);
			} catch (NullPointerException e) {	// 동 정보가 없는 경우 catch 한 후 나머지 학교들 탐색
				System.out.println("동 정보가 없는 학교정보가 있음");
				continue;	// 계속 탐색
			}
		}
		return finds;
	}
}
