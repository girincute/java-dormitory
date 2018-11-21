
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
		

		
		// 정보 ( 이름, 아이디, 비밀번호, 비밀번호 체크 )
		

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
		
		


		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

public class signup {
	public static void main(String[] args) {
	//	new signupUI();
	}

}
