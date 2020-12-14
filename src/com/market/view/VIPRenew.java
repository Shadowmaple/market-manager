/*
 * Created by JFormDesigner on Mon Dec 14 21:22:11 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import javax.swing.*;

import com.market.dao.VIPDao;
import com.market.util.Time;

/**
 * @author Mannix Zhang
 */
public class VIPRenew extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public VIPRenew() {
		initComponents();
	}

	// 续费
	private void renewAction(ActionEvent e) {
		var idStr = numberTextField.getText().toString();		
		int month = Integer.valueOf(renewMonthTextField.getText().toString());
		if (idStr.equals("") || month <= 0) {
			JOptionPane.showMessageDialog(this, "无效");
			return ;
		}

		var id = Integer.valueOf(idStr);

		var dao = new VIPDao();
		var vipCard = dao.getVIPById(id);
		if (vipCard == null) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		if (vipCard.getIsUse() == 0) {
			JOptionPane.showMessageDialog(this, "已被注销");
			return ;
		}

		vipCard.setValidityTime(Time.getTimeAfterMonths(vipCard.getValidityTime(), month));
		JOptionPane.showMessageDialog(this, "续费成功");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		label1 = new JLabel();
		numberTextField = new JTextField();
		renewMonthTextField = new JTextField();
		label2 = new JLabel();
		button1 = new JButton();

		//======== this ========
		setTitle("\u4f1a\u5458\u5361\u7eed\u8d39");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u5361\u53f7\uff1a");

		//---- renewMonthTextField ----
		renewMonthTextField.setText("12");

		//---- label2 ----
		label2.setText("\u7eed\u8d39\u65f6\u95f4(\u6708)\uff1a");

		//---- button1 ----
		button1.setText("\u7eed\u8d39");
		button1.addActionListener(e -> renewAction(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(58, 58, 58)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(label1, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
								.addComponent(label2, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
							.addGap(33, 33, 33)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(numberTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(renewMonthTextField, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(90, 90, 90)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(265, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(45, 45, 45)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(numberTextField))
					.addGap(47, 47, 47)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(renewMonthTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(79, 79, 79)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JLabel label1;
	private JTextField numberTextField;
	private JTextField renewMonthTextField;
	private JLabel label2;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
