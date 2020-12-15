/*
 * Created by JFormDesigner on Tue Dec 15 14:15:19 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.market.dao.StaffDao;
import com.market.model.Staff;

/**
 * @author Mannix Zhang
 */
public class ListStaffForm extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ListStaffForm() {
		initComponents();
		
		// 默认不能修改和删除，只有选中了某一项表格数据才有效
		updateBotton.setEnabled(false);
        deleteButtion.setEnabled(false);
	}

	private void searchAction(ActionEvent e) {
		// TODO add your code here
		var staffDao = new StaffDao();
		var list = staffDao.getStaffList(new Staff());
		staffDao.closeDao();
		if (list == null) {
			JOptionPane.showMessageDialog(this, "查询失败");
			return ;
		}

		// 填入 table
		DefaultTableModel dft = (DefaultTableModel) staffTable.getModel();
		dft.setRowCount(0);
		for (var staff : list) {
			Vector<Object> v = new Vector<Object>();
			v.add(staff.getId());
			v.add(staff.getName());
			v.add(staff.getTypeForRole());
			v.add(staff.getEntryTime());

			dft.addRow(v);
		}

		// 可以修改和删除
		updateBotton.setEnabled(true);
        deleteButtion.setEnabled(true);
	}

	// 修改人员信息
	private void updateStaffInfoAction(ActionEvent e) {
		// TODO add your code here
		var name = nameTextField.getText().toString();
		var type = typeComBox.getSelectedIndex();

		int index = staffTable.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(this, "未选中数据");
            return;
        }

        DefaultTableModel dft = (DefaultTableModel) staffTable.getModel();
        int id = Integer.parseInt(dft.getValueAt(index, 0).toString());

        var staffDao = new StaffDao();
        var staff = staffDao.getStaffById(id);
        staff.setName(name);
        staff.setType(type);

        var ok = staffDao.update(staff);
        staffDao.closeDao();
        if (!ok) {
        	JOptionPane.showMessageDialog(this, "修改失败");
            return;
        }

        nameTextField.setText("");
        JOptionPane.showMessageDialog(this, "修改成功");
	}

	// 删除人员信息
	private void deleteStaffAction(ActionEvent e) {
		int index = staffTable.getSelectedRow();
        if(index == -1) {
            JOptionPane.showMessageDialog(this, "未选中数据");
            return;
        }

        DefaultTableModel dft = (DefaultTableModel) staffTable.getModel();
        int id = Integer.parseInt(dft.getValueAt(index, 0).toString());
        var dao = new StaffDao();
        var ok = dao.deleteById(id);
        dao.closeDao();
        if (!ok) {
        	JOptionPane.showMessageDialog(this, "删除失败");
            return;
        }
        JOptionPane.showMessageDialog(this, "删除成功");
	}

	// 点击表格，选中事件
	private void selectItemAction(MouseEvent e) {
		var idx = staffTable.getSelectedRow();
		if (idx < 0) {
            return;
		}

		DefaultTableModel dft = (DefaultTableModel) staffTable.getModel();
		var selectedName = dft.getValueAt(idx, 1).toString();
		var selectedType = dft.getValueAt(idx, 2).toString();
        nameTextField.setText(selectedName);
        typeComBox.setSelectedIndex(Staff.gettypeIntByRoleStr(selectedType));

        updateBotton.setEnabled(true);
        deleteButtion.setEnabled(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		staffTable = new JTable();
		button1 = new JButton();
		label1 = new JLabel();
		nameTextField = new JTextField();
		label2 = new JLabel();
		updateBotton = new JButton();
		deleteButtion = new JButton();
		typeComBox = new JComboBox<>();

		//======== this ========
		setTitle("\u4eba\u5458\u6982\u89c8");
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{
			scrollPane1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectItemAction(e);
				}
			});

			//---- staffTable ----
			staffTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\u4eba\u5458\u7f16\u53f7", "\u59d3\u540d", "\u8eab\u4efd", "\u8fdb\u5165\u65f6\u95f4"
				}
			));
			staffTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectItemAction(e);
				}
			});
			scrollPane1.setViewportView(staffTable);
		}

		//---- button1 ----
		button1.setText("\u67e5\u8be2");
		button1.addActionListener(e -> searchAction(e));

		//---- label1 ----
		label1.setText("\u59d3\u540d");

		//---- label2 ----
		label2.setText("\u8eab\u4efd");

		//---- updateBotton ----
		updateBotton.setText("\u4fee\u6539");
		updateBotton.addActionListener(e -> updateStaffInfoAction(e));

		//---- deleteButtion ----
		deleteButtion.setText("\u5220\u9664");
		deleteButtion.addActionListener(e -> deleteStaffAction(e));

		//---- typeComBox ----
		typeComBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"\u6536\u94f6\u5458",
			"\u8fdb\u8d27\u5458",
			"\u7ba1\u7406\u5458"
		}));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 705, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
							.addGap(33, 33, 33)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(typeComBox, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(214, 214, 214)
									.addComponent(updateBotton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
									.addGap(73, 73, 73)
									.addComponent(deleteButtion, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
								.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))))
					.addGap(84, 84, 84))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addGap(40, 40, 40)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addGap(34, 34, 34)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
						.addComponent(label1, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
						.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(updateBotton, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(deleteButtion, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
							.addComponent(typeComBox, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
							.addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)))
					.addContainerGap(48, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTable staffTable;
	private JButton button1;
	private JLabel label1;
	private JTextField nameTextField;
	private JLabel label2;
	private JButton updateBotton;
	private JButton deleteButtion;
	private JComboBox<String> typeComBox;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
