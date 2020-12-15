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
			saleStrategyMenuItem.setVisible(false);
			saleRecordMenuItem.setVisible(false);
			returnGoodsMenuItem.setEnabled(false);
		} else if (role == 1) {
			staffMenu.setEnabled(false);
			saleMenu.setEnabled(false);
			vipMenu.setEnabled(false);
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
//		desktopPane.add(newStaffForm);
	}

	private void saleProductsAction(ActionEvent e) {
		SellProducts sellProductsForm = new SellProducts(userId);
		sellProductsForm.setVisible(true);
	}

	// 查看人员列表
	private void listStaffsAction(ActionEvent e) {
		var listStaffsForm = new ListStaffForm();
		listStaffsForm.setVisible(true);
	}

	// 退货
	private void returnGoodsAction(ActionEvent e) {
		var returnGoodsForm = new ReturnGoodsForm();
		returnGoodsForm.setVisible(true);
	}

	// 进货计划
	private void purchasePlanLookAction(ActionEvent e) {
		var purchasePlanForm = new PurchasePlanForm();
		purchasePlanForm.setVisible(true);
	}

	// 进货
	private void purchaseGoodsAction(ActionEvent e) {
		var purchaseGoodsForm = new PurchaseForm(userId);
		purchaseGoodsForm.setVisible(true);
	}

	// 查看库存
	private void reposotoryOverviewAction(ActionEvent e) {
		var repoOverviewForm = new RepositoryOverview();
		repoOverviewForm.setVisible(true);
	}

	// 发放会员卡
	private void grantVIPCardAction(ActionEvent e) {
		var grantVIPCardForm = new GrantVIPCard();
		grantVIPCardForm.setVisible(true);
	}

	// 会员卡续期
	private void renewVIPCardAction(ActionEvent e) {
		var renewVIPForm = new VIPRenew();
		renewVIPForm.setVisible(true);
	}

	// 退出登录
	private void logoutAction(ActionEvent e) {
		var loginForm = new Login();
		this.dispose();
		this.userId = 0;
		loginForm.setVisible(true);
	}

	// 查看销售记录/报表
	private void saleConditionOverviewAction(ActionEvent e) {
		var saleConditionForm = new SaleCondition();
		saleConditionForm.setVisible(true);
	}

	// 查看进货记录
	private void purchaseRecordOverviewAction(ActionEvent e) {
		var purchaseRecordOverviewForm = new PurchaseRecordOverview();
		purchaseRecordOverviewForm.setVisible(true);
	}	

	private void exitSystemAction(ActionEvent e) {
		System.exit(0);
	}

	// 销售策略
	private void saleStrategyAction(ActionEvent e) {
		var saleStrategyForm = new SaleStrategyForm();
		saleStrategyForm.setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		menuBar1 = new JMenuBar();
		menu5 = new JMenu();
		menuItem13 = new JMenuItem();
		menuItem12 = new JMenuItem();
		staffMenu = new JMenu();
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		saleMenu = new JMenu();
		menuItem3 = new JMenuItem();
		saleRecordMenuItem = new JMenuItem();
		saleStrategyMenuItem = new JMenuItem();
		returnGoodsMenuItem = new JMenuItem();
		purchaseMenu = new JMenu();
		menuItem11 = new JMenuItem();
		menuItem4 = new JMenuItem();
		menuItem5 = new JMenuItem();
		menuItem7 = new JMenuItem();
		vipMenu = new JMenu();
		menuItem9 = new JMenuItem();
		menuItem10 = new JMenuItem();
		desktopPane = new JDesktopPane();
		label1 = new JLabel();

		//======== this ========
		setTitle("\u8d85\u5e02\u96f6\u552e\u7ba1\u7406\u7cfb\u7edf");
		setMinimumSize(new Dimension(960, 700));
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== menuBar1 ========
		{

			//======== menu5 ========
			{
				menu5.setText("\u7cfb\u7edf");

				//---- menuItem13 ----
				menuItem13.setText("\u9000\u51fa\u767b\u5f55");
				menuItem13.addActionListener(e -> logoutAction(e));
				menu5.add(menuItem13);

				//---- menuItem12 ----
				menuItem12.setText("\u9000\u51fa\u7cfb\u7edf");
				menuItem12.addActionListener(e -> exitSystemAction(e));
				menu5.add(menuItem12);
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

				//---- saleRecordMenuItem ----
				saleRecordMenuItem.setText("\u9500\u552e\u8bb0\u5f55");
				saleRecordMenuItem.addActionListener(e -> saleConditionOverviewAction(e));
				saleMenu.add(saleRecordMenuItem);

				//---- saleStrategyMenuItem ----
				saleStrategyMenuItem.setText("\u9500\u552e\u7b56\u7565");
				saleStrategyMenuItem.addActionListener(e -> saleStrategyAction(e));
				saleMenu.add(saleStrategyMenuItem);

				//---- returnGoodsMenuItem ----
				returnGoodsMenuItem.setText("\u9000\u8d27");
				returnGoodsMenuItem.addActionListener(e -> returnGoodsAction(e));
				saleMenu.add(returnGoodsMenuItem);
			}
			menuBar1.add(saleMenu);

			//======== purchaseMenu ========
			{
				purchaseMenu.setText("\u5e93\u5b58\u7ba1\u7406");

				//---- menuItem11 ----
				menuItem11.setText("\u5e93\u5b58\u67e5\u770b");
				menuItem11.addActionListener(e -> reposotoryOverviewAction(e));
				purchaseMenu.add(menuItem11);

				//---- menuItem4 ----
				menuItem4.setText("\u8fdb\u8d27\u8ba1\u5212");
				menuItem4.addActionListener(e -> purchasePlanLookAction(e));
				purchaseMenu.add(menuItem4);

				//---- menuItem5 ----
				menuItem5.setText("\u8fdb\u8d27");
				menuItem5.addActionListener(e -> purchaseGoodsAction(e));
				purchaseMenu.add(menuItem5);

				//---- menuItem7 ----
				menuItem7.setText("\u8fdb\u8d27\u8bb0\u5f55");
				menuItem7.addActionListener(e -> purchaseRecordOverviewAction(e));
				purchaseMenu.add(menuItem7);
			}
			menuBar1.add(purchaseMenu);

			//======== vipMenu ========
			{
				vipMenu.setText("\u4f1a\u5458");

				//---- menuItem9 ----
				menuItem9.setText("\u53d1\u653e\u4f1a\u5458\u5361");
				menuItem9.addActionListener(e -> grantVIPCardAction(e));
				vipMenu.add(menuItem9);

				//---- menuItem10 ----
				menuItem10.setText("\u4f1a\u5458\u5361\u7eed\u671f");
				menuItem10.addActionListener(e -> renewVIPCardAction(e));
				vipMenu.add(menuItem10);
			}
			menuBar1.add(vipMenu);
		}
		setJMenuBar(menuBar1);

		//======== desktopPane ========
		{
			desktopPane.setBackground(Color.darkGray);
			desktopPane.setMinimumSize(new Dimension(830, 645));

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
	private JMenuItem menuItem12;
	private JMenu staffMenu;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenu saleMenu;
	private JMenuItem menuItem3;
	private JMenuItem saleRecordMenuItem;
	private JMenuItem saleStrategyMenuItem;
	private JMenuItem returnGoodsMenuItem;
	private JMenu purchaseMenu;
	private JMenuItem menuItem11;
	private JMenuItem menuItem4;
	private JMenuItem menuItem5;
	private JMenuItem menuItem7;
	private JMenu vipMenu;
	private JMenuItem menuItem9;
	private JMenuItem menuItem10;
	private JDesktopPane desktopPane;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
