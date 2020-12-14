package com.market.view;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.ProductDao;
import com.market.model.Product;

/**
 * @author Mannix Zhang
 */
public class RepositoryOverview extends JFrame {

	private static final long serialVersionUID = 1L;
	public RepositoryOverview() {
		initComponents();

		monitorRepoCondition();
	}
	
	// 监测库存预警
	private void monitorRepoCondition() {
		var productDao = new ProductDao();
		var list = productDao.getProductList(new Product());
		if (list == null) {
			return ;
		}

		var redundant = new Vector<String>();
		var shortage = new Vector<String>();
		var lack = new Vector<String>();
		for (var p : list) {
			var num = p.getNum();
			if (num > 500) {
				redundant.add(p.getName());
			} else if (num == 0) {
				lack.add(p.getName());
			} else if (num < 50) {
				shortage.add(p.getName());
			}
		}
		
		String warning = "";
		if (lack.size() > 0) {
			warning += "以下货物短缺：\n";
			for (var s : lack) {
				warning += s + "；";
			}
			warning += "\n";
		}
		
		if (shortage.size() > 0) {
			warning += "以下货物过少：\n";
			for (var s : shortage) {
				warning += s + "；";
			}
			warning += "\n";
		}
		
		if (redundant.size() > 0) {
			warning += "以下货物过剩：\n";
			for (var s : redundant) {
				warning += s + "\n";
			}
			warning += "\n";
		}
		
		if (warning.length() > 0) {
			JOptionPane.showMessageDialog(this, warning);
		}
	}

	// 查询库存
	private void searchRepoAction(ActionEvent e) {
		String name = searchTextField.getText().toString();
		var product = new Product();
		product.setName(name);
		var productDao = new ProductDao();
		var list = productDao.getProductList(product);
		if (list == null) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		
		// 填入 table
		DefaultTableModel dft = (DefaultTableModel) repoTable.getModel();
		dft.setRowCount(0);
		for (var p : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(p.getId());
			v.add(p.getName());
			v.add(p.getNum());			
			v.add(p.judgeRepoCondition());
			dft.addRow(v);
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		searchTextField = new JTextField();
		button1 = new JButton();
		label1 = new JLabel();
		scrollPane1 = new JScrollPane();
		repoTable = new JTable();

		//======== this ========
		setTitle("\u5e93\u5b58");
		var contentPane = getContentPane();

		//---- button1 ----
		button1.setText("\u67e5\u8be2");
		button1.addActionListener(e -> searchRepoAction(e));

		//---- label1 ----
		label1.setText("\u5e93\u5b58\u67e5\u8be2");

		//======== scrollPane1 ========
		{

			//---- repoTable ----
			repoTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"\u5546\u54c1\u7f16\u53f7", "\u540d\u79f0", "\u5e93\u5b58\u91cf", "\u72b6\u6001"
				}
			));
			scrollPane1.setViewportView(repoTable);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(24, 24, 24)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addGap(48, 48, 48)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(410, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(52, 52, 52)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(button1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(searchTextField, GroupLayout.Alignment.LEADING)
						.addComponent(label1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35, 35, 35)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37, 37, 37))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JTextField searchTextField;
	private JButton button1;
	private JLabel label1;
	private JScrollPane scrollPane1;
	private JTable repoTable;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
