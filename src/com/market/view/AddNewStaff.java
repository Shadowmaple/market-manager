/*
 * Created by JFormDesigner on Sun Dec 13 14:56:49 CST 2020
 */

package com.market.view;

import java.awt.event.*;
import javax.swing.*;
import com.market.dao.StaffDao;
import com.market.model.Staff;

/**
 * @author Mannix Zhang
 */
public class AddNewStaff extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AddNewStaff() {
		initComponents();
	}

	private void quitAction(ActionEvent e) {
		// TODO add your code here
		System.exit(0);
	}

	private void AddStaffAction(ActionEvent e) {
		// 添加新员工
		String username = staffNameTextField.getText().toString();
		String password = String.valueOf(staffPasswordField.getPassword());
		int staffType = staffTypeCmdBox.getSelectedIndex();
		System.out.println(username + " " + password + " "+ staffType);
		if ("".equals(username) || "".equals(password)) {
			System.out.println("error");
			JOptionPane.showMessageDialog(this, "用户名和密码不能为空");
			return ;
		}
		System.out.println("OK");
		Staff staff = new Staff();
		staff.setName(username);
		staff.setPassword(password);
		staff.setType(staffType);
		StaffDao staffDao = new StaffDao();
		boolean ok = staffDao.create(staff);
		staffDao.closeDao();
		if (!ok) {
			JOptionPane.showMessageDialog(this, "添加失败");
			return ;
		}
		JOptionPane.showMessageDialog(this, "添加新员工" + staff.getName() + "成功");		
		this.dispose();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		label1 = new JLabel();
		staffNameTextField = new JTextField();
		staffPasswordlabel = new JLabel();
		button1 = new JButton();
		button2 = new JButton();
		staffTypeCmdBox = new JComboBox<>();
		label3 = new JLabel();
		staffPasswordField = new JPasswordField();

		//======== this ========
		setTitle("\u6dfb\u52a0\u65b0\u5458\u5de5");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u5458\u5de5\u59d3\u540d");

		//---- staffPasswordlabel ----
		staffPasswordlabel.setText("\u5bc6\u7801");

		//---- button1 ----
		button1.setText("\u6dfb\u52a0");
		button1.addActionListener(e -> AddStaffAction(e));

		//---- button2 ----
		button2.setText("\u53d6\u6d88");
		button2.addActionListener(e -> quitAction(e));

		//---- staffTypeCmdBox ----
		staffTypeCmdBox.setModel(new DefaultComboBoxModel<>(new String[] {
			"\u552e\u8d27\u5458",
			"\u8fdb\u8d27\u5458"
		}));

		//---- label3 ----
		label3.setText("\u5458\u5de5\u7c7b\u578b");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(90, 90, 90)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(34, 34, 34)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(53, 53, 53)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
									.addComponent(staffPasswordlabel, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
									.addComponent(label1, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
								.addComponent(label3, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(67, 67, 67)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addGroup(contentPaneLayout.createSequentialGroup()
									.addComponent(staffTypeCmdBox, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
									.addGap(19, 19, 19))
								.addComponent(staffNameTextField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
								.addComponent(staffPasswordField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))))
					.addContainerGap(142, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(53, 53, 53)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(staffNameTextField, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addGap(18, 18, 18)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(staffPasswordlabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(staffPasswordField, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addGap(21, 21, 21)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(staffTypeCmdBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(32, 32, 32))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JLabel label1;
	private JTextField staffNameTextField;
	private JLabel staffPasswordlabel;
	private JButton button1;
	private JButton button2;
	private JComboBox<String> staffTypeCmdBox;
	private JLabel label3;
	private JPasswordField staffPasswordField;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
