/*
 * Created by JFormDesigner on Mon Dec 14 11:51:58 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.ProductDao;
import com.market.dao.PurchaseRecordDao;
import com.market.dao.StaffDao;
import com.market.model.Product;
import com.market.model.PurchaseRecord;
import com.market.model.Staff;

/**
 * @author Mannix Zhang
 */
public class PurchaseRecordOverview extends JFrame {

	private static final long serialVersionUID = 1L;
	public PurchaseRecordOverview() {
		initComponents();
	}

	private void searchPlansAction(ActionEvent e) {
		var key = searchTextField.getText().toString();
		if ("".equals(key)) {
			JOptionPane.showMessageDialog(this, "请输入商品名");
			return ;
		}
		var productDao = new ProductDao();
		var product = productDao.getProduct(key);
		if (product == null) {
			productDao.closeDao();
			JOptionPane.showMessageDialog(this, "商品不存在");
			return ;
		}

		var record = new PurchaseRecord();
		record.setProduceId(product.getId());

		var recordDao = new PurchaseRecordDao();
		var list = recordDao.getPurchaseRecordList(record);
		recordDao.closeDao();
		if (list == null) {
			JOptionPane.showMessageDialog(this, "无进货记录");
			return ;
		}

		Product p = null;
		Staff s = null;
		var staffDao = new StaffDao();
		// 填入 table
		DefaultTableModel dft = (DefaultTableModel) recordTable.getModel();
		dft.setRowCount(0);
		for (var item : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(item.getId());
			
			p = productDao.getProductById(item.getProductId());
			v.add(p.getName());
			
			v.add(item.getNum());			
			v.add(item.getPrice());
			v.add(item.getMoney());
			v.add(item.getCreateTime());
			
			s = staffDao.getStaffById(item.getStaffId());
			v.add(s.getName());
			
			dft.addRow(v);
		}
		productDao.closeDao();
		staffDao.closeDao();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		recordTable = new JTable();
		searchTextField = new JTextField();
		button4 = new JButton();

		//======== this ========
		setTitle("\u8fdb\u8d27\u8bb0\u5f55");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{

			//---- recordTable ----
			recordTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u7f16\u53f7", "\u540d\u79f0", "\u8fdb\u8d27\u6570\u91cf", "\u8fdb\u8d27\u5355\u4ef7", "\u8fdb\u8d27\u603b\u91d1\u989d", "\u8fdb\u8d27\u65f6\u95f4", "\u8fdb\u8d27\u5458"
				}
			));
			scrollPane1.setViewportView(recordTable);
		}

		//---- button4 ----
		button4.setText("\u67e5\u8be2");
		button4.addActionListener(e -> searchPlansAction(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(187, 187, 187)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addGap(67, 67, 67)
							.addComponent(button4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(62, 62, 62)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(210, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(45, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(1, 1, 1)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(button4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(42, 42, 42)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36, 36, 36))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable recordTable;
	private JTextField searchTextField;
	private JButton button4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
