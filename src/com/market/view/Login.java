/*
 * Created by JFormDesigner on Fri Dec 11 11:51:45 CST 2020
 */

package com.market.view;

import java.awt.*;
import javax.swing.*;
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

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		panel9 = new JPanel();
		panel10 = new JPanel();
		panel11 = new JPanel();
		panel12 = new JPanel();
		center = new JPanel();
		label1 = new JLabel();
		panel14 = new JPanel();
		label2 = new JLabel();
		label3 = new JLabel();
		panel15 = new JPanel();
		textField1 = new JTextField();
		passwordField1 = new JPasswordField();
		button1 = new JButton();
		panel16 = new JPanel();

		//======== this ========
		setMinimumSize(new Dimension(800, 600));
		var contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== panel9 ========
		{
			panel9.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
			.border.EmptyBorder(0,0,0,0), "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e",javax.swing.border.TitledBorder
			.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dialo\u0067",java.
			awt.Font.BOLD,12),java.awt.Color.red),panel9. getBorder()))
			;panel9. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
			){if("borde\u0072".equals(e.getPropertyName()))throw new RuntimeException();}})
			;
			panel9.setLayout(new BorderLayout());
		}
		contentPane.add(panel9, BorderLayout.NORTH);

		//======== panel10 ========
		{
			panel10.setMinimumSize(new Dimension(20, 20));
			panel10.setLayout(new BorderLayout());
		}
		contentPane.add(panel10, BorderLayout.SOUTH);

		//======== panel11 ========
		{
			panel11.setLayout(new BorderLayout());
		}
		contentPane.add(panel11, BorderLayout.EAST);

		//======== panel12 ========
		{
			panel12.setLayout(new BorderLayout());
		}
		contentPane.add(panel12, BorderLayout.WEST);

		//======== center ========
		{
			center.setLayout(new BorderLayout(50, 100));

			//---- label1 ----
			label1.setText("\u767b\u5f55");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
			label1.setMinimumSize(new Dimension(110, 100));
			center.add(label1, BorderLayout.NORTH);

			//======== panel14 ========
			{
				panel14.setLayout(new GridLayout(2, 1, 0, 100));

				//---- label2 ----
				label2.setText("\u7528\u6237\u540d");
				label2.setHorizontalAlignment(SwingConstants.LEFT);
				panel14.add(label2);

				//---- label3 ----
				label3.setText("\u5bc6\u7801");
				label3.setHorizontalAlignment(SwingConstants.CENTER);
				panel14.add(label3);
			}
			center.add(panel14, BorderLayout.WEST);

			//======== panel15 ========
			{
				panel15.setMaximumSize(new Dimension(1212, 1212));
				panel15.setLayout(new GridLayout(2, 1, 0, 100));

				//---- textField1 ----
				textField1.setMaximumSize(new Dimension(80, 50));
				panel15.add(textField1);
				panel15.add(passwordField1);
			}
			center.add(panel15, BorderLayout.CENTER);

			//---- button1 ----
			button1.setText("\u767b\u5f55");
			center.add(button1, BorderLayout.SOUTH);

			//======== panel16 ========
			{
				panel16.setLayout(new BorderLayout());
			}
			center.add(panel16, BorderLayout.EAST);
		}
		contentPane.add(center, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel center;
	private JLabel label1;
	private JPanel panel14;
	private JLabel label2;
	private JLabel label3;
	private JPanel panel15;
	private JTextField textField1;
	private JPasswordField passwordField1;
	private JButton button1;
	private JPanel panel16;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
