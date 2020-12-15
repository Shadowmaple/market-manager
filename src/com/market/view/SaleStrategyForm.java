/*
 * Created by JFormDesigner on Tue Dec 15 22:15:36 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import javax.swing.*;

import com.market.dao.ProductDao;

/**
 * @author Mannix Zhang
 */
public class SaleStrategyForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SaleStrategyForm() {
		initComponents();
	}

	private void searchProductStrategyAction(ActionEvent e) {
		// TODO add your code here
		var name = nameTextField.getText().toString();
		var dao = new ProductDao();
		var product = dao.getProduct(name);
		dao.closeDao();
		if (product == null) {
			JOptionPane.showMessageDialog(this, "商品不存在");
			return ;
		}
		
		strategyOutputLabel.setText(String.valueOf(product.getStratey()));
	}

	private void updateStrategyAction(ActionEvent e) {
		// TODO add your code here
		var name = nameTextField.getText().toString();
		var dao = new ProductDao();
		var product = dao.getProduct(name);		
		if (product == null) {
			dao.closeDao();
			JOptionPane.showMessageDialog(this, "商品不存在");
			return ;
		}
		
		int newStrategy;
		try {
			newStrategy = Integer.valueOf(newStrategyTextField.getText().toString());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "输入错误，必须为0-100的整数");
			return ;
		}
		product.setStratey(newStrategy);
		var ok = dao.update(product);
		if (!ok) {
			JOptionPane.showMessageDialog(this, "修改失败");
			return ;
		}
		JOptionPane.showMessageDialog(this, "修改成功");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		label1 = new JLabel();
		nameTextField = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		newStrategyTextField = new JTextField();
		label2 = new JLabel();
		label3 = new JLabel();
		strategyOutputLabel = new JLabel();

		//======== this ========
		setTitle("\u9500\u552e\u7b56\u7565");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u5546\u54c1\u540d");

		//---- button1 ----
		button1.setText("\u67e5\u8be2");
		button1.addActionListener(e -> searchProductStrategyAction(e));

		//---- button2 ----
		button2.setText("\u4fee\u6539");
		button2.addActionListener(e -> updateStrategyAction(e));

		//---- label2 ----
		label2.setText("\u65b0\u7684\u6298\u6263\uff08%\uff09");

		//---- label3 ----
		label3.setText("\u6298\u6263\uff08%\uff09");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(67, 67, 67)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
					.addGap(32, 32, 32)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(strategyOutputLabel, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
						.addComponent(newStrategyTextField, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE))
					.addGap(59, 59, 59)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(43, 43, 43)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
						.addComponent(button1, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
					.addGap(31, 31, 31)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(strategyOutputLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(39, 39, 39)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(newStrategyTextField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(239, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JLabel label1;
	private JTextField nameTextField;
	private JButton button1;
	private JButton button2;
	private JTextField newStrategyTextField;
	private JLabel label2;
	private JLabel label3;
	private JLabel strategyOutputLabel;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
