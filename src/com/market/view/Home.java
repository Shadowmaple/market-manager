package com.market.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import com.market.model.Staff;

/**
 * @author Mannix Zhang
 */
public class Home extends JFrame {
	private static final long serialVersionUID = 1L;
	private int userId; // 当前的用户id

	public Home() {
		initComponents();
	}

	public Home(Staff staff) {
		// 权限
		int role = staff.getType(); 
		initComponents();
		if (role == 0) {
			staffMenu.setEnabled(false);
			purchaseMenu.setEnabled(false);
		} else if (role == 1) {
			staffMenu.setEnabled(false);
			saleMenu.setEnabled(false);
		}
		this.userId = staff.getId();
	}
	
	public int getCurrentUserId() {
		return userId;
	}

	// 添加新员工 action
	private void addNewStaffAction(ActionEvent e) {
		// TODO add your code here
		AddNewStaff newStaffForm = new AddNewStaff();
		newStaffForm.setVisible(true);
		desktopPane.add(newStaffForm);
	}

	// 查看员工列表 action
	private void listStaffsAction(ActionEvent e) {
		// TODO add your code here
	}

	private void saleProductsAction(ActionEvent e) {
		// TODO add your code here
		SellProducts sellProductsForm = new SellProducts(userId);
		sellProductsForm.setVisible(true);
		desktopPane.add(sellProductsForm);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		menuBar1 = new JMenuBar();
		staffMenu = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		saleMenu = new JMenu();
		menuItem3 = new JMenuItem();
		menuItem6 = new JMenuItem();
		purchaseMenu = new JMenu();
		menuItem4 = new JMenuItem();
		menuItem5 = new JMenuItem();
		menuItem7 = new JMenuItem();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button5 = new JButton();
		desktopPane = new JDesktopPane();

		//======== this ========
		setTitle("\u8d85\u5e02\u96f6\u552e\u7ba1\u7406\u7cfb\u7edf");
		var contentPane = getContentPane();

		//======== menuBar1 ========
		{

			//======== staffMenu ========
			{
				staffMenu.setText("\u5458\u5de5\u7ba1\u7406");

				//---- menuItem1 ----
				menuItem1.setText("\u6dfb\u52a0\u65b0\u5458\u5de5");
				menuItem1.addActionListener(e -> addNewStaffAction(e));
				staffMenu.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("\u5458\u5de5\u5217\u8868");
				menuItem2.addActionListener(e -> listStaffsAction(e));
				staffMenu.add(menuItem2);
			}
			menuBar1.add(staffMenu);

			//======== saleMenu ========
			{
				saleMenu.setText("\u96f6\u552e\u7ba1\u7406");

				//---- menuItem3 ----
				menuItem3.setText("\u96f6\u552e\u7ed3\u7b97");
				menuItem3.addActionListener(e -> saleProductsAction(e));
				saleMenu.add(menuItem3);

				//---- menuItem6 ----
				menuItem6.setText("\u96f6\u552e\u8bb0\u5f55");
				saleMenu.add(menuItem6);
			}
			menuBar1.add(saleMenu);

			//======== purchaseMenu ========
			{
				purchaseMenu.setText("\u8fdb\u8d27\u7ba1\u7406");

				//---- menuItem4 ----
				menuItem4.setText("\u8fdb\u8d27\u8ba1\u5212");
				purchaseMenu.add(menuItem4);

				//---- menuItem5 ----
				menuItem5.setText("\u65b0\u589e\u8fdb\u8d27");
				purchaseMenu.add(menuItem5);

				//---- menuItem7 ----
				menuItem7.setText("\u8fdb\u8d27\u8bb0\u5f55");
				purchaseMenu.add(menuItem7);
			}
			menuBar1.add(purchaseMenu);
		}
		setJMenuBar(menuBar1);

		//---- button1 ----
		button1.setText("\u5458\u5de5\u7ba1\u7406");

		//---- button2 ----
		button2.setText("\u8fdb\u8d27\u7ba1\u7406");

		//---- button3 ----
		button3.setText("\u6536\u94f6");

		//---- button4 ----
		button4.setText("\u8bb0\u5f55\u67e5\u770b");

		//---- button5 ----
		button5.setText("\u9000\u51fa");

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(269, 269, 269)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(button4, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
						.addComponent(button3, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(188, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
					.addContainerGap(654, Short.MAX_VALUE)
					.addComponent(button5, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addGap(75, 75, 75))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(71, 71, 71)
					.addComponent(button1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(57, 57, 57)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addComponent(button3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(89, 89, 89)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
						.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
					.addGap(54, 54, 54)
					.addComponent(button4, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18)
					.addComponent(button5, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JMenuBar menuBar1;
	private JMenu staffMenu;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenu saleMenu;
	private JMenuItem menuItem3;
	private JMenuItem menuItem6;
	private JMenu purchaseMenu;
	private JMenuItem menuItem4;
	private JMenuItem menuItem5;
	private JMenuItem menuItem7;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JDesktopPane desktopPane;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
