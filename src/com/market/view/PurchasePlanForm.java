/*
 * Created by JFormDesigner on Sun Dec 13 19:13:18 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.PlanDao;
import com.market.model.Plan;

/**
 * @author Mannix Zhang
 */
public class PurchasePlanForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PurchasePlanForm() {
		initComponents();
		// 刚开始使修改和删除按钮无效，只有选中某一行数据才有效
		updatePlanButtion.setEnabled(false);
		deletePlanButton.setEnabled(false);
	}

	private void searchPlansAction(ActionEvent e) {
		String key = searchTextField.getText().toString();

		var plan = new Plan();
		plan.setName(key);
		var planDao = new PlanDao();
		var list = planDao.getPlanList(plan);
		planDao.closeDao();
		if (list == null) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}

		// 填入 table
		DefaultTableModel dft = (DefaultTableModel) planTable.getModel();
		dft.setRowCount(0);
		for (var p : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(p.getId());
			v.add(p.getName());
			v.add(p.getPrice());
			v.add(p.getNum());
			dft.addRow(v);
		}
	}

	private void deletePlanAction(ActionEvent e) {
		// TODO add your code here
		int index = planTable.getSelectedRow();
        if(index == -1){
            JOptionPane.showMessageDialog(this, "未选中数据");
            return;
        }
        
        DefaultTableModel dft = (DefaultTableModel) planTable.getModel();
        int id = Integer.parseInt(dft.getValueAt(index, 0).toString());
        
        var planDao = new PlanDao();
        var ok = planDao.delete(id);
        planDao.closeDao();
        if (!ok) {
        	JOptionPane.showMessageDialog(this, "失败");
			return ;
        }
        
        planTable.remove(index);
        JOptionPane.showMessageDialog(this, "删除成功");
	}

	private void addNewPlanAction(ActionEvent e) {
		String name = productNameTextField.getText().toString();
		float price = Float.valueOf(productPriceTextField.getText().toString());
		int num = Integer.valueOf(productNumTextField.getText().toString());
		if (name.equals("") || price == 0 || num == 0) {
			JOptionPane.showMessageDialog(this, "商品名、单价和数量不能为空！");
			return ;
		}
		
		var plan = new Plan();
		plan.setName(name);
		plan.setPrice(price);
		plan.setNum(num);
		
		var planDao = new PlanDao();
		boolean ok = planDao.create(plan);
		planDao.closeDao();
		if (!ok) {
			JOptionPane.showMessageDialog(this, "失败");
			return ;
		}
		
		JOptionPane.showMessageDialog(this, "添加成功");
	}

	private void updatePlanAction(ActionEvent e) {
		// TODO add your code here
		String name = productNameTextField.getText().toString();
		float price = Float.valueOf(productPriceTextField.getText().toString());
		int num = Integer.valueOf(productNumTextField.getText().toString());
		if (name.equals("") || price == 0 || num == 0) {
			JOptionPane.showMessageDialog(this, "商品名、单价和数量不能为空！");
			return ;
		}

		int index = planTable.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(this, "未选中数据");
            return;
        }
        
        DefaultTableModel dft = (DefaultTableModel) planTable.getModel();
        int id = Integer.parseInt(dft.getValueAt(index, 0).toString());
        
        var plan = new Plan();
        plan.setId(id);
        plan.setName(name);
        plan.setPrice(price);
        plan.setNum(num);
        
        var planDao = new PlanDao();
        var ok = planDao.update(plan);
        planDao.closeDao();
        if (!ok) {
        	JOptionPane.showMessageDialog(this, "失败");
			return ;
        }

        JOptionPane.showMessageDialog(this, "修改成功");
	}

	// 点击 table 中事件，即选中某一行
	private void selectItemAction(MouseEvent e) {
		// TODO add your code here
		DefaultTableModel dft = (DefaultTableModel) planTable.getModel();
		var selectedName = dft.getValueAt(planTable.getSelectedRow(), 1).toString();
		var selectedPrice = dft.getValueAt(planTable.getSelectedRow(), 2).toString();
		var selectedNum = dft.getValueAt(planTable.getSelectedRow(), 3).toString();
        productNameTextField.setText(selectedName);
        productPriceTextField.setText(selectedPrice);
        productNumTextField.setText(selectedNum);
		JOptionPane.showMessageDialog(this, "选中");

        // 选中后添加按钮失效，即默认操作为修改或删除，无法添加
        addNewPlanButton.setEnabled(false);
        updatePlanButtion.setEnabled(true);
        deletePlanButton.setEnabled(true);
	}

	// 点击空白触发事件
	private void thisMouseClicked(MouseEvent e) {
		// TODO add your code here
		addNewPlanButton.setEnabled(true);
		updatePlanButtion.setEnabled(true);
		deletePlanButton.setEnabled(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		planTable = new JTable();
		deletePlanButton = new JButton();
		addNewPlanButton = new JButton();
		searchTextField = new JTextField();
		button4 = new JButton();
		productNameTextField = new JTextField();
		label1 = new JLabel();
		label2 = new JLabel();
		productPriceTextField = new JTextField();
		label3 = new JLabel();
		productNumTextField = new JTextField();
		updatePlanButtion = new JButton();

		//======== this ========
		setTitle("\u8fdb\u8d27\u8ba1\u5212");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{
			scrollPane1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectItemAction(e);
				}
			});

			//---- planTable ----
			planTable.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
					{null, null, null, null},
				},
				new String[] {
					"\u7f16\u53f7", "\u540d\u79f0", "\u5355\u4ef7", "\u6570\u91cf"
				}
			));
			scrollPane1.setViewportView(planTable);
		}

		//---- deletePlanButton ----
		deletePlanButton.setText("\u5220\u9664");
		deletePlanButton.addActionListener(e -> {
			deletePlanAction(e);
			deletePlanAction(e);
		});

		//---- addNewPlanButton ----
		addNewPlanButton.setText("\u6dfb\u52a0");
		addNewPlanButton.addActionListener(e -> addNewPlanAction(e));

		//---- searchTextField ----
		searchTextField.setText("\u8f93\u5165\u5546\u54c1\u540d");

		//---- button4 ----
		button4.setText("\u67e5\u8be2");
		button4.addActionListener(e -> searchPlansAction(e));

		//---- label1 ----
		label1.setText("\u540d\u79f0");

		//---- label2 ----
		label2.setText("\u5355\u4ef7");

		//---- label3 ----
		label3.setText("\u6570\u91cf");

		//---- updatePlanButtion ----
		updatePlanButtion.setText("\u4fee\u6539");
		updatePlanButtion.addActionListener(e -> updatePlanAction(e));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(40, 40, 40)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(60, 60, 60)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(updatePlanButtion, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
							.addGap(50, 50, 50)
							.addComponent(deletePlanButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(41, 41, 41))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(label2, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
										.addComponent(label1, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(contentPaneLayout.createParallelGroup()
										.addComponent(productNameTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
										.addComponent(productPriceTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
								.addComponent(addNewPlanButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
									.addComponent(label3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
									.addGap(66, 66, 66)
									.addComponent(productNumTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
							.addGap(31, 31, 31))))
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(102, 102, 102)
					.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addGap(67, 67, 67)
					.addComponent(button4, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(133, 133, 133)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(productNameTextField, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
					.addGap(31, 31, 31)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(productPriceTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(23, 23, 23)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(productNumTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(38, 38, 38)
					.addComponent(addNewPlanButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(32, 32, 32)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(updatePlanButtion, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(deletePlanButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(1, 1, 1)
							.addComponent(searchTextField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(button4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(30, 30, 30)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addGap(61, 61, 61))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable planTable;
	private JButton deletePlanButton;
	private JButton addNewPlanButton;
	private JTextField searchTextField;
	private JButton button4;
	private JTextField productNameTextField;
	private JLabel label1;
	private JLabel label2;
	private JTextField productPriceTextField;
	private JLabel label3;
	private JTextField productNumTextField;
	private JButton updatePlanButtion;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
