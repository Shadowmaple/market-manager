/*
 * Created by JFormDesigner on Sun Dec 13 15:42:22 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.ProductDao;
import com.market.dao.SaleRecordDao;
import com.market.dao.VIPDao;
import com.market.model.Product;
import com.market.model.SaleRecord;
import com.market.model.VIP;
import com.market.util.Time;

/**
 * @author Mannix Zhang
 */
public class SellProducts extends JFrame {

	private static final long serialVersionUID = 1L;
	private int userId;
	public SellProducts(int userId) {
		initComponents();
		this.userId = userId;
	}

	private void exitAction(ActionEvent e) {
		this.dispose();
	}

	// 结算,这里设置 record 的 num 的改变
	private void sellAction(ActionEvent e) {
		var vipValid = false;
		String vipField = vipCardTextField.getText().toString();
		if (!vipField.equals("")) {
			if (!VIP.checkValid(Integer.valueOf(vipField))) {
				JOptionPane.showMessageDialog(this, "会员卡无效");
				return ;
			}
			vipValid = true;
		}

		float totalFee = 0;
		rcs = new ArrayList<SaleRecord>();
		// 保存此次交易的record
		for (int i = 0; i < shoppingCartTable.getRowCount(); i++) {
			var productId = Integer.valueOf(shoppingCartTable.getValueAt(i, 0).toString());
			var productPrice = Float.valueOf(shoppingCartTable.getValueAt(i, 2).toString());
			var productNum = Integer.valueOf(shoppingCartTable.getValueAt(i, 3).toString());

			// 货物
			Product product;
			ProductDao productDao = new ProductDao();
			product = productDao.getProductById(productId);
			
			if (product == null) {
				JOptionPane.showMessageDialog(this, "失败");
				return ;
			}

			// 成本
			var pur =  product.getPurchasePrice();

			float curTotal = (float) (productPrice * productNum * product.getStratey() * 0.01);
			if (vipValid) curTotal *= 0.95;
			totalFee += curTotal;

			// 利润
			float profit = (float)curTotal - productNum*pur;
			
			var saleRecord = new SaleRecord();
			saleRecord.setProductId(productId);
			saleRecord.setStaffId(this.userId);
			saleRecord.setNumber(productNum);
			saleRecord.setMoney(curTotal);
			saleRecord.setStratey(product.getStratey());
			saleRecord.setCreateTime(Time.getCurrentTime());
			saleRecord.setProfit(profit);

			// 添加记录至DB
			var saleRecordDao = new SaleRecordDao();
			var ok = saleRecordDao.create(saleRecord);
			saleRecordDao.closeDao();
			if (!ok) {
				JOptionPane.showMessageDialog(this, "失败");
				return ;
			}
			rcs.add(saleRecord);
			belong = saleRecord.getBelong();
		}

		needPayTextField.setText(String.valueOf(totalFee));
		total = totalFee;

		// 清空购物车
		DefaultTableModel dft = (DefaultTableModel) shoppingCartTable.getModel();
		dft.setRowCount(0);
		SaleRecord.setNum();
		
		// 更新会员的消费金额
		if (vipValid) {
			var vipDao = new VIPDao();
			var vip = vipDao.getVIPById(Integer.valueOf(vipField));
			vip.setMoney(vip.getConsumeMoney() + totalFee);
			var ok = vipDao.updateConsumeMoney(vip);
			vipDao.closeDao();
			if (!ok) {
				System.out.println("更新会员消费金额失败");
				return ;
			}
		}
	}
	
	// 判断字符串是商品名还是商品编号
	// 0->名，1->编号
	private int checkInputIsNameOrId(String key) {
		try {
			Integer.valueOf(key);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return 1;
	}

	// 加入购物车
	private void addToShoppingCartAction(ActionEvent e) {
		// 输入的是商品名或商品编号
		String key = productNameTextField.getText().toString();
		int num = Integer.valueOf(productNumberTextField.getText().toString());		
		if (key.equals("") || num < 1) {
			JOptionPane.showMessageDialog(this, "输入错误");
			return ;
		}
		
		var kind = checkInputIsNameOrId(key);

		Product product = new Product();
		ProductDao productDao = new ProductDao();
		if (kind == 0) {
			product = productDao.getProduct(key);
		} else if (kind == 1) {
			product = productDao.getProductById(Integer.valueOf(key));
		}
		productDao.closeDao();

		if (product == null) {
			System.out.println("数据库查询商品 " + key + "失败");
			JOptionPane.showMessageDialog(this, "该商品不存在");
			return ;
		}

		Vector<Object> v = new Vector<Object>();
		v.add(product.getId());
		v.add(product.getName());
		v.add(product.getPrice());
		v.add(num);

		// 加入 table
		DefaultTableModel dft = (DefaultTableModel) shoppingCartTable.getModel();
		dft.addRow(v);

		productNameTextField.setText("");
		productNumberTextField.setText(String.valueOf(1));
	}

	// 重置
	private void resumeAction(ActionEvent e) {
		productNameTextField.setText("");
		productNumberTextField.setText(String.valueOf(1));
		vipCardTextField.setText("");
		needPayTextField.setText("");
		realPayTextField.setText("");
		chargeTextField.setText("");

		DefaultTableModel dft = (DefaultTableModel) shoppingCartTable.getModel();
		dft.setRowCount(0);
	}

	// 计算零钱
	private void countChargeAction(ActionEvent e) {
		var realPay = Float.valueOf(realPayTextField.getText().toString());
		var needPay = Float.valueOf(needPayTextField.getText().toString());
		if (realPay < needPay) {
			JOptionPane.showMessageDialog(this, "实付金额不足");
			return ;
		}

		var charge = realPay - needPay;
		chargeTextField.setText(String.valueOf(charge));
	}

	private void button6ActionPerformed(ActionEvent e) {
		// TODO add your code here
		//生成小票
		createlist();
	}

	private void createlist() {
		// TODO Auto-generated method stub
		new DealingFrm(rcs,belong,total).setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		shoppingCartTable = new JTable();
		productNameTextField = new JTextField();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		productNumberTextField = new JTextField();
		label2 = new JLabel();
		button5 = new JButton();
		realPayTextField = new JTextField();
		label3 = new JLabel();
		needPayTextField = new JTextField();
		label4 = new JLabel();
		label5 = new JLabel();
		label6 = new JLabel();
		label7 = new JLabel();
		chargeTextField = new JTextField();
		label8 = new JLabel();
		vipCardTextField = new JTextField();
		button4 = new JButton();
		button6 = new JButton();

		//======== this ========
		setTitle("\u5546\u54c1\u7ed3\u7b97");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- shoppingCartTable ----
			shoppingCartTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7f16\u53f7", "\u5546\u54c1\u540d\u79f0", "\u4ef7\u683c", "\u6570\u91cf"
				}
			));
			scrollPane1.setViewportView(shoppingCartTable);
		}

		//---- button1 ----
		button1.setText("\u7ed3\u7b97");
		button1.addActionListener(e -> sellAction(e));

		//---- button2 ----
		button2.setText("\u91cd\u7f6e");
		button2.addActionListener(e -> resumeAction(e));

		//---- button3 ----
		button3.setText("\u8fd4\u56de");
		button3.addActionListener(e -> exitAction(e));

		//---- productNumberTextField ----
		productNumberTextField.setText("1");

		//---- label2 ----
		label2.setText("\u8d2d\u7269\u8f66");
		label2.setHorizontalTextPosition(SwingConstants.LEADING);
		label2.setHorizontalAlignment(SwingConstants.CENTER);

		//---- button5 ----
		button5.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
		button5.addActionListener(e -> addToShoppingCartAction(e));

		//---- label3 ----
		label3.setText("\u5e94\u4ed8\uff1a");

		//---- label4 ----
		label4.setText("\u5b9e\u4ed8\uff1a");

		//---- label5 ----
		label5.setText("\u5546\u54c1\u540d\u6216\u7f16\u53f7\uff1a");

		//---- label6 ----
		label6.setText("\u6570\u91cf\uff1a");

		//---- label7 ----
		label7.setText("\u627e\u96f6");

		//---- label8 ----
		label8.setText("\u4f1a\u5458\u5361*");

		//---- button4 ----
		button4.setText("\u627e\u96f6");
		button4.addActionListener(e -> countChargeAction(e));

		//---- button6 ----
		button6.setText("\u751f\u6210\u5c0f\u7968");
		button6.addActionListener(e -> button6ActionPerformed(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(62, 62, 62)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 322, GroupLayout.PREFERRED_SIZE))
					.addGap(56, 56, 56)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(button5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addComponent(label8, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
									.addComponent(label3, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
									.addGap(2, 2, 2)))
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(10, 10, 10)
									.addComponent(vipCardTextField, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(66, 66, 66)
									.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(10, 10, 10)
									.addComponent(needPayTextField))))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(label7, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
								.addComponent(label4, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(realPayTextField)
								.addComponent(chargeTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGap(3, 3, 3)
									.addComponent(label5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(productNameTextField, GroupLayout.Alignment.TRAILING)
								.addComponent(productNumberTextField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))))
					.addGap(59, 59, 59)
					.addComponent(button3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(28, 28, 28))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(148, 148, 148)
					.addComponent(button6, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(650, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addGap(63, 63, 63)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(44, 44, 44)
							.addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
						.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
							.addContainerGap(45, Short.MAX_VALUE)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(productNameTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label5, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(28, 28, 28)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(productNumberTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(vipCardTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label8, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(42, 42, 42)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(button5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
							.addGap(36, 36, 36)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(needPayTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(realPayTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label4, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(18, 18, 18)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(chargeTextField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(label7, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
							.addGap(30, 30, 30)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(button2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addComponent(button3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(button6, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable shoppingCartTable;
	private JTextField productNameTextField;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JTextField productNumberTextField;
	private JLabel label2;
	private JButton button5;
	private JTextField realPayTextField;
	private JLabel label3;
	private JTextField needPayTextField;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JTextField chargeTextField;
	private JLabel label8;
	private JTextField vipCardTextField;
	private JButton button4;
	private JButton button6;
	private List<SaleRecord> rcs;
	private String belong;
	private float total;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
