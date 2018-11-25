// 로그인하기

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class loginUI extends JFrame {
	public static Connection conn = null;
	
	public static String id;
	public static String name;
	public static String pw;
	public static int room;
	public static int score;
	
	int idch = 0;
	int pwch = 0;
	
	public void getStudent() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM student");
		
		while(rs.next()) {
			String dbid = rs.getString("id");
			
			if(dbid.equals(id)) {
				idch = 1;
				String dbpw = rs.getString("pw");
				if(dbpw.equals(pw)) {
					pwch = 1;
					name = rs.getString("name");
					room = rs.getInt("room");
					score = rs.getInt("score");

//					student_main uitest = new student_main();
					
					student_main.main();
					
					System.out.println(score);
					break;
				}
				else {
					pwch = 0;
				}
				break;
			}
			else {
				idch = 0;
			}
		}
		
		if(idch == 0) JOptionPane.showMessageDialog(null, "없는 아이디입니다!");
		else if(pwch == 0) JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
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
		
		TextField idfd = new TextField(10);
//		JLabel id_place = new JLabel("id");
		idfd.setBounds(480, 290, 180, 40);
		this.add(idfd);
		//this.id.add(id_place);
		
		JTextField pwfd = new JTextField("pw");
		pwfd.setBounds(480, 375, 180, 40);
		this.add(pwfd);
		
		loginlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
				try {
					id = idfd.getText();
					pw = pwfd.getText();
					
					System.out.println(id);
					System.out.println(pw);
					getStudent();
					dispose();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }  
		}); 
	
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
