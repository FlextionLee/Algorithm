package com.ssafy.rent.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.rent.WhereIsMyHomeException;
import com.ssafy.rent.model.dto.SchoolInfo;

public class SchoolCSVParser {
	List<SchoolInfo> schools;
	
	public SchoolCSVParser() throws WhereIsMyHomeException {
		loadData();
	}
	
	public List<SchoolInfo> getSChoolInfo(){
		return this.schools;
	}
	
	public void loadData() throws WhereIsMyHomeException {        
        this.schools = new ArrayList<>();
        
        File file = new File("./res/school.csv");  
        int n = 0;
        
        try (BufferedReader bufReader = new BufferedReader(new FileReader(file));) {    
            Charset.forName("UTF-8");
            String line = null;
            
            while((line = bufReader.readLine()) != null) {
                
                String arr[] = line.split(",");
                SchoolInfo si = new SchoolInfo();
                si.setNo(n++);

                si.setSchName(arr[2]);
                si.setCode(arr[4]);
                
                if (arr[5].contains("(")) {
					String[] dongParse = arr[5].split("\\(");
					String dong = dongParse[1].replace(")", "");		
					si.setAddress(dongParse[0]);
					si.setDong(dong);
				} else {
					si.setAddress(arr[5]);
				}
                
                si.setPhone(arr[6]);
                si.setFax(arr[7]);
                si.setHomepage(arr[8]);
                schools.add(si);
            }
            schools.remove(0);
            
                
        }catch(Exception e) {
        	throw new WhereIsMyHomeException();
        }
    }
}
