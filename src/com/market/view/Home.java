package com.market.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
		initComponents();
		
		// 权限
		int role = staff.getType(); 
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
		menu5 = new JMenu();
		menuItem13 = new JMenuItem();
		staffMenu = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		saleMenu = new JMenu();
		menuItem3 = new JMenuItem();
		menuItem14 = new JMenuItem();
		menuItem6 = new JMenuItem();
		menuItem8 = new JMenuItem();
		purchaseMenu = new JMenu();
		menuItem11 = new JMenuItem();
		menuItem4 = new JMenuItem();
		menuItem5 = new JMenuItem();
		menuItem7 = new JMenuItem();
		menu4 = new JMenu();
		menuItem9 = new JMenuItem();
		desktopPane = new JDesktopPane();
		label1 = new JLabel();

		//======== this ========
		setTitle("\u8d85\u5e02\u96f6\u552e\u7ba1\u7406\u7cfb\u7edf");
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//======== menu5 ========
			{
				menu5.setText("\u7cfb\u7edf");

				//---- menuItem13 ----
				menuItem13.setText("\u9000\u51fa\u767b\u5f55");
				menu5.add(menuItem13);
			}
			menuBar1.add(menu5);

			//======== staffMenu ========
			{
				staffMenu.setText("\u4eba\u5458\u7ba1\u7406");

				//---- menuItem1 ----
				menuItem1.setText("\u6dfb\u52a0\u65b0\u4eba\u5458");
				menuItem1.addActionListener(e -> addNewStaffAction(e));
				staffMenu.add(menuItem1);

				//---- menuItem2 ----
				menuItem2.setText("\u4eba\u5458\u5217\u8868");
				menuItem2.addActionListener(e -> listStaffsAction(e));
				staffMenu.add(menuItem2);
			}
			menuBar1.add(staffMenu);

			//======== saleMenu ========
			{
				saleMenu.setText("\u9500\u552e\u7ba1\u7406");

				//---- menuItem3 ----
				menuItem3.setText("\u7ed3\u7b97");
				menuItem3.addActionListener(e -> saleProductsAction(e));
				saleMenu.add(menuItem3);

				//---- menuItem14 ----
				menuItem14.setText("\u9500\u552e\u7b56\u7565");
				saleMenu.add(menuItem14);

				//---- menuItem6 ----
				menuItem6.setText("\u9500\u552e\u8bb0\u5f55");
				saleMenu.add(menuItem6);

				//---- menuItem8 ----
				menuItem8.setText("\u9000\u8d27");
				saleMenu.add(menuItem8);
			}
			menuBar1.add(saleMenu);

			//======== purchaseMenu ========
			{
				purchaseMenu.setText("\u5e93\u5b58\u7ba1\u7406");

				//---- menuItem11 ----
				menuItem11.setText("\u5e93\u5b58\u67e5\u770b");
				purchaseMenu.add(menuItem11);

				//---- menuItem4 ----
				menuItem4.setText("\u8fdb\u8d27\u8ba1\u5212");
				purchaseMenu.add(menuItem4);

				//---- menuItem5 ----
				menuItem5.setText("\u8fdb\u8d27");
				purchaseMenu.add(menuItem5);

				//---- menuItem7 ----
				menuItem7.setText("\u8fdb\u8d27\u8bb0\u5f55");
				purchaseMenu.add(menuItem7);
			}
			menuBar1.add(purchaseMenu);

			//======== menu4 ========
			{
				menu4.setText("\u4f1a\u5458");

				//---- menuItem9 ----
				menuItem9.setText("\u53d1\u653e\u4f1a\u5458\u5361");
				menu4.add(menuItem9);
			}
			menuBar1.add(menu4);
		}
		setJMenuBar(menuBar1);

		//======== desktopPane ========
		{
			desktopPane.setBackground(Color.darkGray);

			//---- label1 ----
			label1.setText("\u5c0f\u578b\u8d85\u5e02\u96f6\u552e\u7ba1\u7406\u7cfb\u7edf");
			label1.setFont(new Font(Font.DIALOG, Font.BOLD, 48));
			label1.setForeground(Color.white);
			desktopPane.add(label1, JLayeredPane.DEFAULT_LAYER);
			label1.setBounds(155, 70, 540, 195);
		}
		contentPane.add(desktopPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JMenuBar menuBar1;
	private JMenu menu5;
	private JMenuItem menuItem13;
	private JMenu staffMenu;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenu saleMenu;
	private JMenuItem menuItem3;
	private JMenuItem menuItem14;
	private JMenuItem menuItem6;
	private JMenuItem menuItem8;
	private JMenu purchaseMenu;
	private JMenuItem menuItem11;
	private JMenuItem menuItem4;
	private JMenuItem menuItem5;
	private JMenuItem menuItem7;
	private JMenu menu4;
	private JMenuItem menuItem9;
	private JDesktopPane desktopPane;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
