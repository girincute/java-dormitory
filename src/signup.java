import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class signupUI extends JFrame {
	public static Connection conn = null;
	
	String id;
	String pw;
	
	int idch = 0;
	int pwch = 0;
	
	public void checkId(String send_id) throws SQLException, ClassNotFoundException {
		id = send_id;
		System.out.println(id);
		
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM student");
		
		while(rs.next()) {
			String dbid = rs.getString("id");
			
			if(dbid.equals(id)) { // 아이디 있음
				idch = 1;
				String dbpw = rs.getString("pw");
				
				JOptionPane.showMessageDialog(null, "당신의 비밀번호는 " + dbpw + "입니다");
				break;
			}
			else {
				idch = 0;
			}
		}
		
		if(idch == 0) JOptionPane.showMessageDialog(null, "없는 아이디입니다!");

		s.close();
		rs.close();
		
		conn.close();
	}
	
	signupUI() {

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);


		JTextField send_id = new JTextField();
		send_id.setBounds(450, 315, 200, 40);
		this.add(send_id);

		ImageIcon signupicon = new ImageIcon("img//signupicon_gray.jpg");
		JLabel signupiconlabel = new JLabel(signupicon);
		signupiconlabel.setBounds(450, 500, 115, 55);
		this.add(signupiconlabel);

		signupiconlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					checkId(send_id.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class signup {
	public static void main(String[] args) {
		new signupUI();
	}

}