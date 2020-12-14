/*
 * Created by JFormDesigner on Fri Dec 11 11:51:45 CST 2020
 */

package com.market.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.market.dao.StaffDao;
import com.market.model.Staff;

import net.miginfocom.swing.*;

/**
 * @author Mannix Zhang
 */
public class Login extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public Login() {
		initComponents();
	}

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	private void LoginAction(ActionEvent e) {
		String username = usernameTextField.getText().toString();
		String password = String.valueOf(passwordField.getPassword());
		System.out.println(username + " " + password);
		if ("".equals(username) || "".equals(password)) {
			System.out.println("error");
			JOptionPane.showMessageDialog(usernameTextField, "用户名和密码不能为空");
			return ;
		}
		System.out.println("OK");
		Staff staff = new Staff();
//		this.dispose();
//		new Home(staff).setVisible(true);
//		return ;
		StaffDao staffDao = new StaffDao();
		staff.setName(username);
		staff.setPassword(password);
		staff = staffDao.login(staff);
		staffDao.closeDao();
		if (staff == null) {
			JOptionPane.showMessageDialog(this, "用户名或密码错误");
            return;
		}
		JOptionPane.showMessageDialog(this, "用户" + staff.getName() + "登录成功");
		this.dispose();
		new Home(staff).setVisible(true);
	}

	private void ExitAction(ActionEvent e) {
		System.exit(0);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		label1 = new JLabel();
		label2 = new JLabel();
		usernameTextField = new JTextField();
		passwordField = new JPasswordField();
		button1 = new JButton();
		button2 = new JButton();
		label3 = new JLabel();

		//======== this ========
		setMinimumSize(new Dimension(500, 400));
		setTitle("\u767b\u5f55");
		var contentPane = getContentPane();

		//---- label1 ----
		label1.setText("\u7528\u6237\u540d");
		label1.setHorizontalAlignment(SwingConstants.CENTER);

		//---- label2 ----
		label2.setText("\u5bc6\u7801");
		label2.setHorizontalAlignment(SwingConstants.CENTER);

		//---- button1 ----
		button1.setText("\u767b\u5f55");
		button1.addActionListener(e -> LoginAction(e));

		//---- button2 ----
		button2.setText("\u9000\u51fa");
		button2.addActionListener(e -> ExitAction(e));

		//---- label3 ----
		label3.setText("\u767b\u5f55\u754c\u9762");
		label3.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
		label3.setHorizontalAlignment(SwingConstants.CENTER);

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(187, 187, 187)
							.addComponent(button1, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(73, 73, 73)
							.addComponent(button2, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(212, 212, 212)
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(130, 130, 130)
							.addGroup(contentPaneLayout.createParallelGroup()
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(label2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(47, 47, 47)
							.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(usernameTextField)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(146, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGap(40, 40, 40)
					.addComponent(label3, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(57, 57, 57)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(usernameTextField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(62, 62, 62)
					.addGroup(contentPaneLayout.createParallelGroup()
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(80, 80, 80)
					.addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(button1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
						.addComponent(button2, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JLabel label1;
	private JLabel label2;
	private JTextField usernameTextField;
	private JPasswordField passwordField;
	private JButton button1;
	private JButton button2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
