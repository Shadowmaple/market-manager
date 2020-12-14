/*
 * Created by JFormDesigner on Mon Dec 14 20:52:46 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import javax.swing.*;

import com.market.dao.VIPDao;
import com.market.model.VIP;
import com.market.util.Time;

/**
 * @author Mannix Zhang
 */
public class GrantVIPCard extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GrantVIPCard() {
		initComponents();
	}

	// 发放会员卡
	private void grantVIPCardAction(ActionEvent e) {
		// TODO add your code here
		String name = nameTextField.getText().toString();
		int validMonth = Integer.valueOf(validMonthTExtField.getText().toString());
		if (name.equals("") || validMonth <= 0) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		
		var vip = new VIP();
		vip.setName(name);
		vip.setCreateTime(Time.getCurrentTime());
		vip.setValidityTime(Time.getTimeAfterMonths(validMonth));
		var dao = new VIPDao();
		var ok = dao.create(vip);
		dao.closeDao();
		if (!ok) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		
		JOptionPane.showMessageDialog(this, "新发放的会员卡号是" + vip.getId());
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		nameTextField = new JTextField();
		label1 = new JLabel();
		button1 = new JButton();
		label2 = new JLabel();
		validMonthTExtField = new JTextField();

		//======== this ========
		setTitle("\u53d1\u653e\u4f1a\u5458\u5361");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u7533\u8bf7\u4eba\uff1a");

		//---- button1 ----
		button1.setText("\u53d1\u653e\u4f1a\u5458\u5361");
		button1.addActionListener(e -> grantVIPCardAction(e));

		//---- label2 ----
		label2.setText("\u6709\u6548\u65f6\u95f4\uff08\u6708\uff09:");

		//---- validMonthTExtField ----
		validMonthTExtField.setText("12");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(49, 49, 49)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(label2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(validMonthTExtField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(97, 97, 97)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
					.addGap(104, 104, 104))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(66, 66, 66)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addGap(38, 38, 38)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(validMonthTExtField, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(65, 65, 65))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JTextField nameTextField;
	private JLabel label1;
	private JButton button1;
	private JLabel label2;
	private JTextField validMonthTExtField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
