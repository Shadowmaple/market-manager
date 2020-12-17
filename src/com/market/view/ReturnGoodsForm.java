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
public class ReturnGoodsForm extends JFrame {
	public ReturnGoodsForm() {
		initComponents();
	}

	// 确认退货
	private void returnGoodsAction(ActionEvent e) {
		// TODO add your code here
		var recordNum = treatRecordNumTextField.getText().toString();
		var id = Integer.valueOf(goodsidtextField.getText().toString());
		var record = SaleRecord.getRecordById(recordNum,id);
		if (record == null) {
			JOptionPane.showMessageDialog(this, "记录不存在");
			return ;
		}

		// 退货，删除记录
		SaleRecordDao dao = new SaleRecordDao();
		var ok = dao.delete(recordNum,id);
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
		label2 = new JLabel();
		goodsidtextField = new JTextField();

		//======== this ========
		setTitle("\u9000\u8d27");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u4ea4\u6613\u6d41\u6c34\u53f7");

		//---- button1 ----
		button1.setText("\u786e\u8ba4\u9000\u8d27");
		button1.addActionListener(e -> returnGoodsAction(e));

		//---- label2 ----
		label2.setText("\u5546\u54c1\u53f7");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(161, 161, 161)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(61, 61, 61)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
							.addGap(64, 64, 64)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(treatRecordNumTextField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
								.addComponent(goodsidtextField, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(45, 45, 45)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(treatRecordNumTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(goodsidtextField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(label2, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(85, 85, 85)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(167, Short.MAX_VALUE))
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
	private JLabel label2;
	private JTextField goodsidtextField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
