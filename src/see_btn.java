// 쪽지와 관련된 (쪽지함, 쪽지보내기) UI

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class write_laundryUI extends JFrame {
public static Connection conn = null;

	public String oneone = "없음";
	public String onetwo = "없음";
	public String onethr = "없음";
	public String twoone = "없음";
	public String twotwo = "없음";
	public String twothr = "없음";
	public String throne = "없음";
	public String thrtwo = "없음";
	public String thrthr = "없음";

	public void show_laundry_DB() throws SQLException, ClassNotFoundException {
		String laundry_time_arr[] = {"20:00~21:30", "21:30~22:30", "22:30~23:30"};
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(d);
		
		Statement s = conn.createStatement();
		System.out.println(today);
		
		ResultSet rs = s.executeQuery("SELECT * FROM laundry where date='"+ today +"' order by num, time");
		
		while(rs.next()) {
			String room = rs.getString("room");
			int num = rs.getInt("num");
			String time = rs.getString("time");
			int timen = -1;
			
			System.out.println(room + " " + num + " " + time + " " + timen);
			
			for(int i = 0; i < laundry_time_arr.length; i++) {
				if(laundry_time_arr[i].equals(time)) {
					timen = i;
					break;
				}
			}
				
			System.out.println(room + " " + num + " " + time + " " + timen);
			
			switch(num) {
			case 1:
				switch(timen+1) {
				case 1: oneone = room;
					break;
				case 2: onetwo = room;
					break;
				case 3: onethr = room;
					break;
				}
				break;
			case 2:
				switch(timen+1) {
				case 1: twoone = room;
					break;
				case 2: twotwo = room;
					break; 
				case 3: twothr = room;
					break;
				}
				break;
			case 3:
				switch(timen+1) {
				case 1: throne = room;
					break;
				case 2: thrtwo = room;
					break;
				case 3: thrthr = room;
					break;
				}
				break;
			}
		}
		
		s.close();
		rs.close();
		conn.close();
	}
	
	public void laundry_DB(String value, String time) throws SQLException, ClassNotFoundException {
		String laundry_time_arr[] = {"20:00~21:30", "21:30~22:30", "22:30~23:30"};
		
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(d);
		
		Calendar cal = Calendar.getInstance() ;
	    cal.setTime(new Date());
	    
	    int timen = -1;
	    for(int i = 0; i < laundry_time_arr.length; i++) {
	    	if(laundry_time_arr[i].equals(time)) {
	    		timen = i;
	    		break;
	    	}
	    }
	    
	    String chk = "없음";
	    
	    switch(Integer.parseInt(value)) {
		case 1:
			switch(timen+1) {
			case 1: chk = oneone;
				break;
			case 2: chk = onetwo;
				break;
			case 3: chk = onethr;
				break;
			}
			break;
		case 2:
			switch(timen+1) {
			case 1: chk = twoone;
				break;
			case 2: chk = twotwo;
				break; 
			case 3: chk = twothr;
				break;
			}
			break;
		case 3:
			switch(timen+1) {
			case 1: chk = throne;
				break;
			case 2: chk = thrtwo;
				break;
			case 3: chk = thrthr;
				break;
			}
			break;
		}
	    
	     
	    int dayNum = cal.get(Calendar.DAY_OF_WEEK);
	    System.out.println(dayNum);
	    
	    if(chk.equals("없음")) {
	    	PreparedStatement ps = conn.prepareStatement("INSERT INTO laundry VALUES(?, ?, ?, ?, ?)");

			ps.setInt(1, loginUI.room);
			ps.setString(2, time);
			ps.setString(3, today);
			ps.setString(4, loginUI.name);
			ps.setInt(5, Integer.parseInt(value));
			
			int res = ps.executeUpdate();
			
			if(res > 0) JOptionPane.showMessageDialog(null, "변경사항이 모두 잘 적용되었습니다!");
			ps.close();
	    }
	    else JOptionPane.showMessageDialog(null, "이미 있는 자리입니다!!");

		conn.close();
	}

	write_laundryUI() throws ClassNotFoundException, SQLException {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// 세탁기 번호

		String laundry_num_arr[] = {"1", "2", "3"};

		JComboBox laundry_num = new JComboBox(laundry_num_arr);
		laundry_num.setBounds(290, 580, 50, 40);
		this.add(laundry_num);
		
		show_laundry_DB();
		
		JLabel one_one = new JLabel(oneone);
		one_one.setFont(new Font("나눔고딕", 30, 30));
		one_one.setBounds(275, 250, 120, 50);
		this.add(one_one);
		
		JLabel one_two = new JLabel(onetwo);
		one_two.setFont(new Font("나눔고딕", 30, 30)); 
		one_two.setBounds(275, 340, 120, 50);
		this.add(one_two);
		
		JLabel one_three = new JLabel(onethr);
		one_three.setFont(new Font("나눔고딕", 30, 30)); 
		one_three.setBounds(275, 430, 120, 50);
		this.add(one_three);
		
		JLabel two_one = new JLabel(twoone);
		two_one.setFont(new Font("나눔고딕", 30, 30)); 
		two_one.setBounds(560, 250, 120, 50);
		this.add(two_one);
		
		JLabel two_two = new JLabel(twotwo);
		two_two.setFont(new Font("나눔고딕", 30, 30)); 
		two_two.setBounds(560, 340, 120, 50);
		this.add(two_two);
		
		JLabel two_three = new JLabel(twothr);
		two_three.setFont(new Font("나눔고딕", 30, 30)); 
		two_three.setBounds(560, 430, 120, 50);
		this.add(two_three);
		
		JLabel three_one = new JLabel(throne);
		three_one.setFont(new Font("나눔고딕", 30, 30)); 
		three_one.setBounds(845, 250, 120, 50);
		this.add(three_one);
		
		JLabel three_two = new JLabel(thrtwo);
		three_two.setFont(new Font("나눔고딕", 30, 30)); 
		three_two.setBounds(845, 340, 120, 50);
		this.add(three_two);
		
		JLabel three_three = new JLabel(thrthr);
		three_three.setFont(new Font("나눔고딕", 30, 30)); 
		three_three.setBounds(845, 430, 120, 50);
		this.add(three_three);


		// 시간

		String laundry_time_arr[] = {"20:00~21:30", "21:30~22:30", "22:30~23:30"};
		
		JComboBox laundry_time = new JComboBox(laundry_time_arr);
		laundry_time.setBounds(400, 580, 250, 40);
		this.add(laundry_time);
		
		ImageIcon send_laundry = new ImageIcon("img//apply.png"); // 전송버튼
		JLabel send_laundry_label = new JLabel(send_laundry);
		send_laundry_label.setBounds(690, 560, 130, 80);
		this.add(send_laundry_label);

		send_laundry_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					laundry_DB(laundry_num.getSelectedItem().toString(), laundry_time.getSelectedItem().toString());
					dispose();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		// 배경
		ImageIcon backicon = new ImageIcon("img//write_laundry_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		

		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.dispose();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class write_outUI extends JFrame { // 외박일지
	public static Connection conn = null;
	
	public void out_DB(String value, String teltext) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Calendar cal = Calendar.getInstance() ;
	    cal.setTime(new Date());
	     
	    int dayNum = cal.get(Calendar.DAY_OF_WEEK);
	    System.out.println(dayNum);
	    
		if(dayNum == 3) {
			Statement s = conn.createStatement();
			s.executeUpdate("DELETE FROM out");
			
			s.close();
		}
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO out VALUES(?, ?, ?, ?, ?)");

		ps.setInt(1, Integer.parseInt(loginUI.id));
		ps.setInt(2, loginUI.room);
		ps.setString(3, loginUI.name);
		ps.setString(4, value);
		ps.setString(5, teltext);
		
		int res = ps.executeUpdate();
		
		if(res > 0) JOptionPane.showMessageDialog(null, "변경사항이 모두 잘 적용되었습니다!");
		
		ps.close();

		conn.close();
	}

	write_outUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String out_kinds_arr[] = { "금토외박", "토요외박", "잔류", "특이" };

		JComboBox out_kinds = new JComboBox(out_kinds_arr);
		out_kinds.setBounds(420, 290, 200, 75);
		this.add(out_kinds);

		JTextField tel = new JTextField(10);
		tel.setBounds(420, 405, 200, 40);
		this.add(tel);

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // 전송버튼
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(660, 330, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String value = out_kinds.getSelectedItem().toString();
				
				String teltext = tel.getText();
				try {
					out_DB(value, teltext);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				dispose();
			}
		});

		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
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

class write_airconUI extends JFrame { // 에어컨 신청
public static Connection conn = null;
	
	public void aircon_DB() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Date d = new Date();
		SimpleDateFormat sdfn = new SimpleDateFormat("HH");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdfn.format(d);
        String today = sdf.format(d);
        int timen = Integer.parseInt(time) + 1;
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO aircon VALUES(?, ?, ?)");

		ps.setInt(1, loginUI.room);
		ps.setInt(2, timen);
		ps.setString(3, today);
		
		int res = ps.executeUpdate();
		
		if(res > 0) JOptionPane.showMessageDialog(null, "변경사항이 모두 잘 적용되었습니다!");
		
		ps.close();

		conn.close();
	}

	write_airconUI() {
		
		Date d = new Date();
        SimpleDateFormat sdfn = new SimpleDateFormat("HH");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdfn.format(d);
        String today = sdf.format(d);
        int timen = Integer.parseInt(time) + 1;
        
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel index = new JLabel("~"+timen+":00");
		index.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		index.setBounds(530, 300, 200, 70);
		this.add(index);

		ImageIcon send_aircon = new ImageIcon("img//apply.png"); // 전송버튼
		JLabel send_aircon_label = new JLabel(send_aircon);
		send_aircon_label.setBounds(480, 480, 130, 80);
		this.add(send_aircon_label);

		send_aircon_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					aircon_DB();
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

		ImageIcon backicon = new ImageIcon("img//aircon_back.jpg");
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

class write_soonoutUI extends JFrame { // 외출일지
	public static Connection conn = null;
	
	public void soonout_DB(String hour, String min) throws SQLException, ClassNotFoundException {
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfn = new SimpleDateFormat("HH:mm");
        String today = sdf.format(d);
        String now = sdfn.format(d);
        System.out.println(today + " " + now + " " + hour + " " + min);
        
        Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO soonout(room, name, date, time) VALUES(?, ?, ?, ?)");
		ps.setInt(1, loginUI.room);
		ps.setString(2, loginUI.name);
		ps.setString(3, today);
		ps.setString(4, now + "~" + hour + ":" + min);
		int res = ps.executeUpdate();
		
		// res가 0보다 크다면 UPDATE로 인해 영향 받은 행이 1개 이상 있다는 의미
		if(res > 0) System.out.println(String.format("%d row update success", res));
		
		ps.close();

		conn.close();
	}

	write_soonoutUI() {
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField hour = new JTextField(2);
		hour.setBounds(540, 290, 50, 60);
		this.add(hour);

		JTextField minute = new JTextField(2);
		minute.setBounds(650, 290, 50, 60);
		this.add(minute);

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // 전송버튼
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(480, 450, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					soonout_DB(hour.getText(), minute.getText());
					JOptionPane.showMessageDialog(null, "데이터가 전송되었습니다!");
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

		ImageIcon backicon = new ImageIcon("img//soonout_back.jpg");
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

public class see_btn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//
		new write_airconUI();
		//
	}

}
