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
		
		
		ImageIcon signupicon = new ImageIcon("img//signupicon.png");
		JLabel signupiconlabel = new JLabel(signupicon);
		signupiconlabel.setBounds(800, 530, 115, 55);
		this.add(signupiconlabel);
		

		
		// ���� ( �̸�, ���̵�, ��й�ȣ, ��й�ȣ üũ )
		

		JTextField name = new JTextField();
		name.setBounds(500, 220, 200, 40);
		this.add(name);
		
		JTextField id = new JTextField();
		id.setBounds(500, 310, 200, 40);
		this.add(id);
		
		JTextField pw = new JTextField();
		pw.setBounds(500, 400, 200, 40);
		this.add(pw);

		JTextField pw_ch = new JTextField();
		pw_ch.setBounds(500, 490, 200, 40);
		this.add(pw_ch);

		

		
		
		ImageIcon backicon = new ImageIcon("img//signup_back.jpg");
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
	//	new signupUI();
	}

}
