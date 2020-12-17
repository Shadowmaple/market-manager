/*
 * Created by JFormDesigner on Thu Dec 17 19:20:00 CST 2020
 */

package com.market.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.util.List;
import com.market.model.SaleRecord;

/**
 * @author Mannix Zhang
 */
public class DealingFrm extends JFrame {
	
	public DealingFrm(List<SaleRecord> rcs,String belong,float total) {
		initComponents();
		textArea1.setText("交易流水号："+belong+"\n");
		textArea1.append("交易总金额："+total+"\n");
		textArea1.append("--------------------------------------\n");
		textArea1.append("产品名称   产品数量   产品总价\n");
		for(SaleRecord r :rcs) {
			textArea1.append(String.format("%12s   ",r.getProductName()));
			//textArea1.append(String.format("%12s   ",r.getMoney()));
			textArea1.append(String.format("%12s   ",r.getNumber()));
			textArea1.append(String.format("%12.2f\n",r.getMoney()));
		}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Mannix Zhang
		scrollPane1 = new JScrollPane();
		textArea1 = new JTextArea();
		label1 = new JLabel();

		//======== this ========
		setFont(new Font(Font.DIALOG, Font.PLAIN, 30));
		var contentPane = getContentPane();

		//======== scrollPane1 ========
		{
			scrollPane1.setViewportView(textArea1);
		}

		//---- label1 ----
		label1.setText("\u4ea4\u6613\u6e05\u5355");
		label1.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addGroup(contentPaneLayout.createParallelGroup()
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(43, 43, 43)
							.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 540, GroupLayout.PREFERRED_SIZE))
						.addGroup(contentPaneLayout.createSequentialGroup()
							.addGap(228, 228, 228)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addGroup(contentPaneLayout.createSequentialGroup()
					.addContainerGap(16, Short.MAX_VALUE)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE)
					.addGap(18, 18, 18))
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Mannix Zhang
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private JLabel label1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
