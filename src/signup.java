
// ȸ������ UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class signupUI extends JFrame {
	signupUI() {

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		// test

		String id = "1234";
		String pw = "tlstjsdud";

		JTextField send_id = new JTextField();
		send_id.setBounds(450, 315, 200, 40);
		this.add(send_id);

		ImageIcon signupicon = new ImageIcon("img//signupicon_gray.jpg");
		JLabel signupiconlabel = new JLabel(signupicon);
		signupiconlabel.setBounds(450, 500, 115, 55);
		this.add(signupiconlabel);

		signupiconlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (id.equals(send_id.getText())) {
					JOptionPane.showMessageDialog(null, pw); // Ȯ�ι�ư
				} else {
					JOptionPane.showMessageDialog(null, "���� id�Դϴ�!"); // Ȯ�ι�ư
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//find_password_backJPG.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�

	}
}

public class signup {
	public static void main(String[] args) {
		new signupUI();
	}

}
