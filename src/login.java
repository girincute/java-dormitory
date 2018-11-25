// 로그인하기

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

		
		// 로그인 버튼
		
		ImageIcon login  = new ImageIcon("img//login.png");
		JLabel loginlabel = new JLabel(login);
		loginlabel.setBounds(710, 310, 140, 70);
		this.add(loginlabel);
		
		loginlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// 로그인
		    }  
		}); 

				
		TextField id = new TextField(10);
		JLabel id_place = new JLabel("ID");
		id.setBounds(480, 290, 180, 40);
		this.add(id);
		//this.id.add(id_place);
		
		JTextField pw = new JTextField("PW");
		pw.setBounds(480, 375, 180, 40);
		this.add(pw);

		ImageIcon find_passwordbtn  = new ImageIcon("img//find_passwordbtn.jpg");
		JLabel find_password_label = new JLabel(find_passwordbtn);
		find_password_label.setBounds(570, 450, 120, 20);
		this.add(find_password_label);
		
		
		find_password_label.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	signupUI signupUI = new signupUI(); // 비밀번호 찾기
		    }  
		}); 
		
		
		
		ImageIcon backicon = new ImageIcon("img//login_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class login {
	public static void main(String[] args) {
		new loginUI();
	}

}
