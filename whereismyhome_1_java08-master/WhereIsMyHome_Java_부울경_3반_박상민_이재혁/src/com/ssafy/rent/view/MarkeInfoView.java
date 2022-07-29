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

import com.ssafy.rent.model.dto.MarketInfo;

public class MarkeInfoView {
	private JFrame 		frame;

	private JTable 				marketTable;
	private JScrollPane 		marketPan;	
	private DefaultTableModel 	marketModel;
	private String[]		  	title = { "번호", "동", "점포이름", "주소", "분류", "기타" };
	
	private String dong;
	private List<MarketInfo> markets;
	
	public MarkeInfoView(String dong, List<MarketInfo> markets) {
		this.dong = dong;
		this.markets = new ArrayList<>();
		
		for (MarketInfo mk : markets) {
			if (mk.getDong() == null) continue;
			if (mk.getDong().equals(dong)) this.markets.add(mk);
		}
		
		frame = new JFrame(this.dong + "주변 상권정보");
				
		setMain();

		frame.setSize(1200, 500);
		frame.setResizable(true);
		frame.setVisible(true);
	}
	
	public void setMain() {
		JPanel mainP = new JPanel(new BorderLayout());
		marketModel = new DefaultTableModel(title, 1);
		marketTable = new JTable(marketModel);
		marketPan = new JScrollPane(marketTable);
		
		marketTable.setColumnSelectionAllowed(true);
		marketTable.setSize(900, 400);
		mainP.add(new JLabel(this.dong + "주변 상권정보", JLabel.CENTER),"North");
		mainP.add(marketPan,"Center");
		
		frame.add(mainP, "Center");
		
		if(markets!=null){
			int i=0;
			String[][]data = new String[markets.size()][6];
			for (MarketInfo market: markets) {
				data[i][0]= ""+market.getNo();
				data[i][1]= market.getDong();
				data[i][2]= market.getMarketName();
				data[i][3]= market.getAddress();
				data[i][4]= market.getCode();
				data[i++][5]= market.getEtc();
			}
			marketModel.setDataVector(data, title);
		}
	}

}
