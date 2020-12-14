/*
 * Created by JFormDesigner on Mon Dec 14 15:38:10 CST 2020
 */

package com.market.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.market.dao.SaleRecordDao;
import com.market.model.SaleRecord;

/**
 * @author Mannix Zhang
 */
public class returnGoodsForm extends JFrame {
	public returnGoodsForm() {
		initComponents();
	}

	// 确认退货
	private void returnGoodsAction(ActionEvent e) {
		// TODO add your code here
		var recordNum = Integer.valueOf(treatRecordNumTextField.getText().toString());
		var record = SaleRecord.getRecordById(recordNum);
		if (record == null) {
			JOptionPane.showMessageDialog(this, "记录不存在");
			return ;
		}

		// 退货，删除记录
		SaleRecordDao dao = new SaleRecordDao();
		var ok = dao.delete(recordNum);
		if (!ok) {
			JOptionPane.showMessageDialog(this, "记录不存在");
			return ;
		}
		JOptionPane.showMessageDialog(this, "退货成功");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		treatRecordNumTextField = new JTextField();
		label1 = new JLabel();
		button1 = new JButton();

		//======== this ========
		setTitle("\u9000\u8d27");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u4ea4\u6613\u6d41\u6c34\u53f7");

		//---- button1 ----
		button1.setText("\u786e\u8ba4\u9000\u8d27");
		button1.addActionListener(e -> returnGoodsAction(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(61, 61, 61)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(64, 64, 64)
							.addComponent(treatRecordNumTextField, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(161, 161, 161)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(45, 45, 45)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(treatRecordNumTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(145, 145, 145)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(156, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JTextField treatRecordNumTextField;
	private JLabel label1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
