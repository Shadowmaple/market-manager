/*
 * Created by JFormDesigner on Sun Dec 13 21:00:42 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.PlanDao;
import com.market.dao.ProductDao;
import com.market.dao.PurchaseRecordDao;
import com.market.model.Plan;
import com.market.model.PurchaseRecord;

/**
 * @author Mannix Zhang
 */
public class PurchaseForm extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
	public PurchaseForm(int userId) {
		initComponents();
		this.userId = userId;
	}

	// 导入进货计划
	private void importPurchasePlansAction(ActionEvent e) {
		var planDao = new PlanDao();
		var list = planDao.getPlanList(null);
		planDao.closeDao();
		if (list == null) {
			JOptionPane.showMessageDialog(this, "导入失败");
			return ;
		}

		// 填入 table
		DefaultTableModel dft = (DefaultTableModel) productPlanTable.getModel();
		dft.setRowCount(0);
		for (var p : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(p.getId());
			v.add(p.getProductName());
			v.add(p.getPrice());
			v.add(p.getNum());
			v.add(p.getPrice() * p.getNum());
			dft.addRow(v);
		}
		JOptionPane.showMessageDialog(this, "导入成功");
	}

	// 进货事件
	private void purchaseAction(ActionEvent e) {
		int count = 0;
		for (int i = 0; i < productPlanTable.getRowCount(); i++) {
			var productName = productPlanTable.getValueAt(i, 1).toString();
			var productDao = new ProductDao();
			var product = productDao.getProduct(productName);
			if (product == null) {
				JOptionPane.showMessageDialog(this, "商品" + productName + "不存在。该商品进货失败。");
			}

			var record = new PurchaseRecord();
			record.setProduceId(product.getId());
			record.setStaffId(this.userId);
			record.setPrice(Float.valueOf(productPlanTable.getValueAt(i, 2).toString()));
			record.setNum(Integer.valueOf(productPlanTable.getValueAt(i, 3).toString()));
			record.setMoney(Float.valueOf(productPlanTable.getValueAt(i, 4).toString()));

			// 新建数据DB
			var recordDao = new PurchaseRecordDao();
			var ok = recordDao.create(record);
			recordDao.closeDao();
			if (!ok) {
				JOptionPane.showMessageDialog(this, "数据新建失败");
				return ;
			}
			count++;
		}

		JOptionPane.showMessageDialog(this, "进货"+ count + "类货物成功");
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		productPlanTable = new JTable();
		button1 = new JButton();
		button2 = new JButton();

		//======== this ========
		setTitle("\u8fdb\u8d27");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- productPlanTable ----
			productPlanTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7f16\u53f7", "\u540d\u79f0", "\u5355\u4ef7", "\u6570\u91cf", "\u603b\u91d1\u989d"
				}
			));
			scrollPane1.setViewportView(productPlanTable);
		}

		//---- button1 ----
		button1.setText("\u5bfc\u5165\u8fdb\u8d27\u8ba1\u5212");
		button1.addActionListener(e -> importPurchasePlansAction(e));

		//---- button2 ----
		button2.setText("\u786e\u5b9a\u8fdb\u8d27");
		button2.addActionListener(e -> purchaseAction(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(81, 81, 81)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(72, 72, 72)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(button2, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
						.addComponent(button1, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
					.addContainerGap(124, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(75, 75, 75)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(64, Short.MAX_VALUE))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(149, 149, 149)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
					.addComponent(button2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(129, 129, 129))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable productPlanTable;
	private JButton button1;
	private JButton button2;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
