package com.ssafy.rent.model.service;

import java.util.List;

import com.ssafy.rent.model.dto.SchoolInfo;

public interface SchoolService {
	List<SchoolInfo> searchAll(String dong);
}
