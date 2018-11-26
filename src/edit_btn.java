// 사감선생님) 각종 일지 확인

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
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;

class check_laundry_UI extends JFrame {
	public static Connection conn = null;
	
	ArrayList<String[]> laundry_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "세탁기 번호", "시간", "신청자 이름", "신청 호실" };
	
	public void getlaundryList() throws ClassNotFoundException, SQLException { // 세탁일지 확인
		Date d = new Date();
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdfd.format(d);
		
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM laundry where date='"+today+"' order by num, time");
		
		while(rs.next()) {
			laundry_list.add(new String[]{rs.getString("num"), rs.getString("time"), rs.getString("name"), rs.getString("room")});
		}
		
        int i = 0;

        if (laundry_list.size() != 0) {
            for (String[] laundry : laundry_list) {
            	contents[i][0] = laundry[0]; // 학번
            	contents[i][1] = laundry[1]; // 신청 시간
            	contents[i][2] = laundry[2]; // 이름
            	contents[i][3] = laundry[3]; // 신청 호실
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	check_laundry_UI() throws ClassNotFoundException, SQLException { // 세탁 일지 GUI
		getlaundryList();
		this.setTitle("Dormitory Management System check_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//laundry_check_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_out_UI extends JFrame { // 외박 일지 확인
	
	public static Connection conn = null;
	
	ArrayList<String[]> out_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = {"호실", "이름", "외박 종류", "연락처" };
	
	public void getoutList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM out order by room");
		
		while(rs.next()) {
			out_list.add(new String[]{rs.getString("room"), rs.getString("name"), rs.getString("when"), rs.getString("tel")});
		}
		
        int i = 0;
        if (out_list.size() != 0) {
            for (String[] out : out_list) {
            	contents[i][0] = out[0]; // 호실
            	contents[i][1] = out[1]; // 이름
            	contents[i][2] = out[2]; // 외박 기간
            	contents[i][3] = out[3]; // 연락처
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_out_UI() throws ClassNotFoundException, SQLException {  // 외박 일지 GUI

		this.setTitle("Dormitory Management System check_out");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		getoutList();

		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 250, 770, 250);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//goout_check_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_aircon_UI extends JFrame { // 에어컨신청 확인
	public static Connection conn = null;
	
	ArrayList<String[]> aircon_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "호실", "시간" };	
	
	
	public void getairconList() throws ClassNotFoundException, SQLException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
        SimpleDateFormat sdfd = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(d);
        String today = sdfd.format(d);
        int timen = Integer.parseInt(time) + 1;
        
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		aircon_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM aircon where time=" + timen + " AND date='" + today + "' order by room");
		
		while(rs.next()) {
			aircon_list.add(new String[]{rs.getString("room"), rs.getString("time")});
		}
		
		int i = 0;
        if (aircon_list.size() != 0) {
            for (String[] aricon : aircon_list) {
            	contents[i][0] = aricon[0]; // 호실
            	contents[i][1] = "~" +aricon[1] + ":00"; // 신청 시간
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_aircon_UI() throws ClassNotFoundException, SQLException { // 에어컨 신청 GUI
		getairconList();

		this.setTitle("Dormitory Management System check_aircon");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//aircon_check_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_soonout_UI extends JFrame { // 외출 일지 확인
	public static Connection conn = null;
	
	ArrayList<String[]> soonout_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "호실", "이름", "시간" };
	
	public void getSonnoutList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String today = sdf.format(d);
        
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM soonout where date='" + today + "'");
		
		while(rs.next()) {
			soonout_list.add(new String[]{rs.getString("room"), rs.getString("name"), rs.getString("time")});
		}
		
        int i = 0;
        if (soonout_list.size() != 0) {
            for (String[] book : soonout_list) {
            	contents[i][0] = book[0]; // 호실
            	contents[i][1] = book[1]; // 이름
            	contents[i][2] = book[2]; // 시간
                i++;
                table = new JTable(contents, header);
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_soonout_UI() throws ClassNotFoundException, SQLException {
		this.setTitle("Dormitory Management System check_soonout");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		getSonnoutList();

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//out_check_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class edit_btn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new check_laundry_UI();
	}

}
