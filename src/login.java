
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

class loginUI extends JFrame {
	loginUI() {

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel la = new JLabel();
		this.add(la);

		
		// �α��� ��ư
		
		ImageIcon login  = new ImageIcon("img//login.png");
		JLabel loginlabel = new JLabel(login);
		loginlabel.setBounds(680, 310, 140, 70);
		this.add(loginlabel);
		
		loginlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// �α���
		    }  
		}); 
		
		JTextField id = new JTextField("ID");
		id.setBounds(450, 290, 180, 40);
		this.add(id);
		
		JTextField pw = new JTextField("PW");
		pw.setBounds(450, 375, 180, 40);
		this.add(pw);
	
		JLabel sign = new JLabel("Sign Up");
		sign.setFont(new Font("��������", 20, 20)); // ��Ʈ ����
		sign.setBounds(580, 440, 90, 30);
		this.add(sign);
		
		loginlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// �α���
		    }  
		}); 
		
		
		
		
		ImageIcon backicon = new ImageIcon("img//login_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		


		// this.setResizable(false); // ���α׷��� �Ժη� ũ�� ������ �� �ֳ�?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // ����, ������ �� �� ����
		// �� �ְ� �ϴ°� ��Ǽ�
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

public class login {
	public static void main(String[] args) {
		new loginUI();
	}

}