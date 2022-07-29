package com.ssafy.rent.view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ssafy.rent.model.dto.SchoolInfo;

public class SchoolInfoView {
	private JFrame 				frame;
	
	private JTable 				schoolTable;
	private JScrollPane 		schoolPan;	
	private DefaultTableModel 	schoolModel;
	private String[]		  	title = { "번호", "동", "학교이름", "우편번호", "주소" , "전화번호", "팩스번호", "홈페이지"};
		
	private String dong;
	List<SchoolInfo> schools;
	
	
	public SchoolInfoView(String dong, List<SchoolInfo> schools) {
		this.dong = dong;
		this.schools = new ArrayList<>();
		
		for (SchoolInfo sc : schools) {
			if (sc.getDong() == null) continue;
			if (sc.getDong().equals(dong)) this.schools.add(sc);
		}
		
		frame = new JFrame(this.dong + "주변 학교정보");
		
		setMain();
		
		frame.setSize(1200, 500);
		frame.setResizable(true);
		frame.setVisible(true);
		
	}
	
	public void setMain() {
		JPanel mainP = new JPanel(new BorderLayout());
		schoolModel = new DefaultTableModel(title, 1);
		schoolTable = new JTable(schoolModel);
		schoolPan = new JScrollPane(schoolTable);
		
		schoolTable.setColumnSelectionAllowed(true);
		mainP.add(new JLabel(this.dong + "주변 초등학교 정보", JLabel.CENTER),"North");
		mainP.add(schoolPan,"Center");
		
		frame.add(mainP, "Center");
		
		if(schools!=null){
			int i=0;
			String[][]data = new String[schools.size()][8];
			for (SchoolInfo school: schools) {
				data[i][0]= ""+school.getNo();
				data[i][1]= school.getDong();
				data[i][2]= school.getSchName();
				data[i][3]= school.getCode();
				data[i][4]= school.getAddress();
				data[i][5]= school.getPhone();
				data[i][6]= school.getFax();
				data[i++][7]= school.getHomepage();
			}
			schoolModel.setDataVector(data, title);
		}
		
	}
}
