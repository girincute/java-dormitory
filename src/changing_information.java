// 정보수정하기

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class Changing_informationUI extends JFrame { // 정보수정
	
	public static Connection conn = null;
	
	public void change_pw(String chpw) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("UPDATE student SET pw = ? where id = ?");
		ps.setInt(1, Integer.parseInt(chpw));
		ps.setInt(2, Integer.parseInt(loginUI.id));
		int res = ps.executeUpdate();
		
		// res가 0보다 크다면 UPDATE로 인해 영향 받은 행이 1개 이상 있다는 의미
		if(res > 0) System.out.println(String.format("%d row update success", res));
		
		ps.close();

		conn.close();
	}
	
	Changing_informationUI() {

		this.setTitle("Dormitory Management Changing information");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField search = new JTextField(40);
		search.setBounds(450, 335, 270, 40);
		this.add(search);
		
		ImageIcon changebtn = new ImageIcon("img//changbtn.png");
		JLabel changebtn_label = new JLabel(changebtn);
		changebtn_label.setBounds(450, 550, 170, 70);
		this.add(changebtn_label);

		
		ImageIcon backicon = new ImageIcon("img//changing_information_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		changebtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					change_pw(search.getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


public class changing_information {

}
