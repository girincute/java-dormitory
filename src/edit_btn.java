// 쪽지와 관련된 (쪽지함, 쪽지보내기) UI

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
	
	ArrayList<String[]> out_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "세탁기 번호", "시간", "신청자 이름", "신청 호실" };
	String room_num = "401";
	
	public void getlaundryList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		out_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM laundry order by num, time");
		
		while(rs.next()) {
			out_list.add(new String[]{rs.getString("num"), rs.getString("time"), rs.getString("name"), rs.getString("room")});
		}
        int i = 0;
        
        System.out.println(out_list.size());

        if (out_list.size() != 0) {
            for (String[] book : out_list) {
            	contents[i][0] = book[0];// name
            	contents[i][1] = book[1]; // when
            	contents[i][2] = book[2]; // tel
            	contents[i][3] = book[3];
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	check_laundry_UI() throws ClassNotFoundException, SQLException {
		getlaundryList();
		this.setTitle("Dormitory Management System_write_laundry");
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_out_UI extends JFrame { // 외박일지 확인
	
	public static Connection conn = null;
	
	ArrayList<String[]> out_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = {"호실", "이름", "외박 종류", "연락처" };
	String room_num = "401";
	
	public void getoutList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		out_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM out order by room");
		
		while(rs.next()) {
			out_list.add(new String[]{rs.getString("room"), rs.getString("name"), rs.getString("when"), rs.getString("tel")});
		}
        int i = 0;
        
        System.out.println(out_list.size());

        if (out_list.size() != 0) {
            for (String[] book : out_list) {
            	contents[i][0] = book[0];// name
            	contents[i][1] = book[1]; // when
            	contents[i][2] = book[2]; // tel
            	contents[i][3] = book[3];
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_out_UI() throws ClassNotFoundException, SQLException {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String room[] = { "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413",
				"414", "415", "416", "417" };
		
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_aircon_UI extends JFrame { // 에어컨신청 확인
	public static Connection conn = null;
	
	ArrayList<String[]> out_list = new ArrayList<String[]>();
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
		
		out_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM aircon where time="+timen +" AND date='" + today + "' order by room");
		
		while(rs.next()) {
			out_list.add(new String[]{rs.getString("room"), rs.getString("time")});
		}
		
		int i = 0;
        if (out_list.size() != 0) {
            for (String[] book : out_list) {
            	contents[i][0] = book[0];// name
            	contents[i][1] = "~" +book[1] + ":00"; // when
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_aircon_UI() throws ClassNotFoundException, SQLException {
		getairconList();

		this.setTitle("Dormitory Management System_write_laundry");
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_soonout_UI extends JFrame { // 외출일지 확인
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
        System.out.println("현재날짜 : "+ sdf.format(d));
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM soonout where date='" + today + "'");
		
		while(rs.next()) {
			soonout_list.add(new String[]{rs.getString("room"), rs.getString("name"), rs.getString("time")});
		}
		
        int i = 0;
        if (soonout_list.size() != 0) {
            for (String[] book : soonout_list) {
            	contents[i][0] = book[0];// room
            	contents[i][1] = book[1]; // name
            	contents[i][2] = book[2]; // time
                i++;
                table = new JTable(contents, header);
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}

	check_soonout_UI() throws ClassNotFoundException, SQLException {
		this.setTitle("Dormitory Management System_write_laundry");
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class edit_btn {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new check_laundry_UI();
	}

}
