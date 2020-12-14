/*
 * Created by JFormDesigner on Mon Dec 14 16:00:35 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Mannix Zhang
 */
public class SaleCondition extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SaleCondition() {
		initComponents();
	}
	
	// 校验填入的日期是否合法
	private boolean checkInputDate(int year, int month, int day) {
		
		return true;
	}
	
	// 查询销售排行榜/报表
	private void searchSaleConditionAction(ActionEvent e) {
		// TODO add your code here
		int type = typeComBox.getSelectedIndex();
		int year = Integer.valueOf(yearTextField.getText().toString());
		int month = monthComBox.getSelectedIndex() + 1;
		int day = dayComBox.getSelectedIndex() + 1;
		
		if (!checkInputDate(year, month, day)) {
			JOptionPane.showMessageDialog(this, "填入的时间无效");
			return ;
		}

		String beginTime, endTime;		
		// 日报表
		if (type == 0) {
			beginTime = String.format("%d-%02d-%02d", year, month, day);
			beginTime = String.format("%d-%02d-%02d", year, month, day+1);
		} else if (type == 1) {
			// TO DO:获取当月的最后一个天
			int endDay = 0;
			beginTime = String.format("%d-%02d-01", year, month, day);
			beginTime = String.format("%d-%02d-%02d", year, month, endDay);
		} else {
			beginTime = String.format("%d-01-01", year);
			beginTime = String.format("%d-12-31", year);
		}
		
		// TODO;
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		table1 = new JTable();
		button1 = new JButton();
		typeComBox = new JComboBox<>();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		monthComBox = new JComboBox<>();
		label4 = new JLabel();
		dayComBox = new JComboBox<>();
		yearTextField = new JTextField();

		//======== this ========
		setTitle("\u9500\u552e\u60c5\u51b5");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- table1 ----
			table1.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"\u6392\u540d", "\u5546\u54c1\u540d", "\u9500\u552e\u91cf", "\u9500\u552e\u603b\u989d"
				}
			));
			scrollPane1.setViewportView(table1);
		}

		//---- button1 ----
		button1.setText("\u67e5\u8be2");
		button1.addActionListener(e -> searchSaleConditionAction(e));

		//---- typeComBox ----
		typeComBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"\u65e5\u62a5\u8868",
			"\u5468\u62a5\u8868",
			"\u5e74\u62a5\u8868"
		}));

		//---- label1 ----
		label1.setText("\u62a5\u8868\u7c7b\u522b\uff1a");

		//---- label2 ----
		label2.setText("\u5e74");

		//---- label3 ----
		label3.setText("\u6708");

		//---- monthComBox ----
		monthComBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11",
			"12"
		}));

		//---- label4 ----
		label4.setText("\u65e5");

		//---- dayComBox ----
		dayComBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"10",
			"11",
			"12",
			"13",
			"14",
			"15",
			"16",
			"17",
			"18",
			"19",
			"20",
			"21",
			"22",
			"23",
			"24",
			"25",
			"26",
			"27",
			"28",
			"29",
			"30",
			"31"
		}));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(53, 53, 53)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(78, 78, 78)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
							.addComponent(typeComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addComponent(dayComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addComponent(monthComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
							.addComponent(yearTextField, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
					.addGap(154, 154, 154))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(78, 78, 78)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(96, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGap(115, 115, 115)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(typeComBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(27, 27, 27)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(yearTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(monthComBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(26, 26, 26)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label4, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(dayComBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(141, 141, 141))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable table1;
	private JButton button1;
	private JComboBox<String> typeComBox;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JComboBox<String> monthComBox;
	private JLabel label4;
	private JComboBox<String> dayComBox;
	private JTextField yearTextField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
