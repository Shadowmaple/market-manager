/*
 * Created by JFormDesigner on Sun Dec 13 15:42:22 CST 2020
 */

package com.market.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.ProductDao;
import com.market.dao.SaleRecordDao;
import com.market.model.Product;
import com.market.model.SaleRecord;
import com.market.util.Time;

/**
 * @author Mannix Zhang
 */
public class SellProducts extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	public SellProducts(int userId) {
		initComponents();
		this.userId = userId;
	}

	private void exitAction(ActionEvent e) {
//		this.setVisible(false);
		this.dispose();
	}
	
	// 计算总金额
	private float countTotalFee(float price, int num, int stratey) {		
		// TO DO: 销售策略
		float total = num * price;
		return total;
	}

	private void countTotalFeeAction(ActionEvent e) {
		String productName = productNameTextField.getText().toString();
		int productNumber = Integer.parseInt(productNumberTextField.getText().toString());
		
		// 查询商品单价
		Product product = new Product();
		product.setName(productName);

		ProductDao productDao = new ProductDao();
		product = productDao.getProduct(product);
		productDao.closeDao();
		if (product == null) {
			JOptionPane.showMessageDialog(this, "添加失败");
			return ;
		}
		
		var total = countTotalFee(product.getPrice(), productNumber, product.getStratey());
		if (total == 0) {
			JOptionPane.showMessageDialog(this, "添加失败");
			return ;
		}
		
		totalFeeTextField.setText(String.valueOf(total));		
		this.dispose();
	}

	private void sellAction(ActionEvent e) {
		// TODO add your code here
		String productName = productNameTextField.getText().toString();
		int productNumber = Integer.parseInt(productNumberTextField.getText().toString());
		
		// 查询商品
		Product product = new Product();
		product.setName(productName);
		ProductDao productDao = new ProductDao();
		product = productDao.getProduct(product);
		productDao.closeDao();
		if (product == null) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		
		// TO DO
		var saleRecord = new SaleRecord();
		saleRecord.setProductId(product.getId());
		saleRecord.setStaffId(this.userId);
		saleRecord.setNumber(productNumber);
		saleRecord.setMoney(countTotalFee(product.getPrice(), productNumber, product.getStratey()));
		saleRecord.setStratey(product.getStratey());
		var time = new Time();
		saleRecord.setCreateTime(time.getCurrentTime());

		var saleRecordDao = new SaleRecordDao();
		var ok = saleRecordDao.create(saleRecord);
		saleRecordDao.closeDao();
		if (!ok) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		JOptionPane.showMessageDialog(this, "结算成功");
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		table = new JTable();
		textField1 = new JTextField();
		productNameTextField = new JTextField();
		textField3 = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		productNumberTextField = new JTextField();
		label1 = new JLabel();
		textField5 = new JTextField();
		totalFeeTextField = new JTextField();

		//======== this ========
		setTitle("\u5546\u54c1\u8d2d\u4e70");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- table ----
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{"", null, "", null},
				},
				new String[] {
					"\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u4ef7\u683c", "\u5e93\u5b58\u91cf"
				}
			));
			scrollPane1.setViewportView(table);
		}

		//---- textField1 ----
		textField1.setText("\u5546\u54c1\u540d");

		//---- textField3 ----
		textField3.setText("\u6570\u91cf");

		//---- button1 ----
		button1.setText("\u8ba1\u7b97\u91d1\u989d");
		button1.addActionListener(e -> countTotalFeeAction(e));

		//---- button2 ----
		button2.setText("\u8d2d\u4e70");
		button2.addActionListener(e -> sellAction(e));

		//---- button3 ----
		button3.setText("\u8fd4\u56de");
		button3.addActionListener(e -> exitAction(e));

		//---- label1 ----
		label1.setText("\u8d2d\u4e70\u5546\u54c1");
		label1.setHorizontalTextPosition(SwingConstants.LEADING);
		label1.setHorizontalAlignment(SwingConstants.CENTER);

		//---- textField5 ----
		textField5.setText("\u603b\u4ef7");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(61, 61, 61)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(73, 73, 73)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
									.addGap(37, 37, 37)
									.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(productNameTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addComponent(productNumberTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addGap(37, 37, 37)
									.addComponent(totalFeeTextField, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(75, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(button2, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
								.addComponent(button1, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
							.addGap(85, 85, 85)
							.addComponent(button3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(59, 59, 59))))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(612, Short.MAX_VALUE)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(154, 154, 154))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(30, 30, 30)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(78, 78, 78)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(productNameTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(30, 30, 30)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(textField3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(productNumberTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(24, 24, 24)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(textField5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(totalFeeTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(32, 32, 32)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(39, 39, 39)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(66, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(94, Short.MAX_VALUE)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addGap(81, 81, 81))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable table;
	private JTextField textField1;
	private JTextField productNameTextField;
	private JTextField textField3;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextField productNumberTextField;
	private JLabel label1;
	private JTextField textField5;
	private JTextField totalFeeTextField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
