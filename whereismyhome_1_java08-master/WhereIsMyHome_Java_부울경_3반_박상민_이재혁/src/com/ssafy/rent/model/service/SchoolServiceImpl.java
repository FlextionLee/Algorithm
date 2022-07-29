package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dao.SchoolDao;
import com.ssafy.rent.model.dao.SchoolDaoImpl;
import com.ssafy.rent.model.dto.SchoolInfo;

public class SchoolServiceImpl implements SchoolService {
	private SchoolDao dao;

	public SchoolServiceImpl() {
		 dao = new SchoolDaoImpl();
	}

	@Override
	public List<SchoolInfo> searchAll(String dong) {
		return dao.searchAll(dong);
	}
}
