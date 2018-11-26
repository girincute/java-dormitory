// 포스트들에 관련된 (공지사항 더보기, 상벌점 더보기, 청소구역 전체보기 ) UI

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
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class noticeUI extends JFrame { // 공지사항
	public static Connection conn = null;
	
	public String notice;
	
	public void noticeList() throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM notice order by nid desc LIMIT 1");
		
		while(rs.next()) {
			notice = "<html>" + rs.getString("notice") + "</html>";
		}
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	noticeUI() throws ClassNotFoundException, SQLException {
		noticeList();
		
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel(notice);
		index.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		index.setBounds(170, 100, 700, 300);
		this.add(index);
		
		ImageIcon notice_back = new ImageIcon("img//notice_back.jpg");
		JLabel notice_back_label = new JLabel(notice_back);
		notice_back_label.setBounds(0, 0, 1080, 720);
		this.add(notice_back_label);
		

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class plus_and_minusUI extends JFrame { // 상벌점 더보기
	public static Connection conn = null;
	
	ArrayList<String[]> score_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "내용", "점수" };
	
	public void getScoreList() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM score where id='" + loginUI.id + "'");
		
		while(rs.next()) {
			score_list.add(new String[]{rs.getString("reason"), rs.getString("score")});
		}
		
        int i = 0;
        if (score_list.size() != 0) {
            for (String[] list : score_list) {
            	contents[i][0] = list[0];// reason
            	contents[i][1] = list[1]; // score
                i++;
                table = new JTable(contents, header);
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	plus_and_minusUI() throws ClassNotFoundException, SQLException {
		getScoreList();
		
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(170, 200, 700, 400);
		this.add(scrollpane);
		
		
		ImageIcon plusandminus = new ImageIcon("img//plusandminus.jpg");
		JLabel plusandminus_label = new JLabel(plusandminus);
		plusandminus_label.setBounds(0, 0, 1080, 720);
		this.add(plusandminus_label);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class cleanclassUI extends JFrame { // 청소구역 전체보기
	
	public static Connection conn = null;
	String[] cleanRoom = new String[7];
	
	// 청소구역 db에서 가지고 오기
	public void getClean() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM clean");
		
		int i = 0;
		while(rs.next()) {
			cleanRoom[i] = rs.getString("room");
			i++;
		}
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	cleanclassUI() throws ClassNotFoundException, SQLException {
		
		getClean();

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel clean_face_room = new JLabel(cleanRoom[0]);
		clean_face_room.setFont(new Font("나눔고딕", 35, 35)); // 세면실
		clean_face_room.setBounds(300, 200, 400, 70);
		this.add(clean_face_room);
		
		
		JLabel shower_room = new JLabel(cleanRoom[1]);
		shower_room.setFont(new Font("나눔고딕", 35, 35)); // 샤워실
		shower_room.setBounds(300, 300, 400, 70);
		this.add(shower_room);
		
		
		JLabel laundry_room = new JLabel(cleanRoom[2]);
		laundry_room.setFont(new Font("나눔고딕", 35, 35)); // 세탁실
		laundry_room.setBounds(300, 410, 400, 70);
		this.add(laundry_room);
		
		JLabel bath_room = new JLabel(cleanRoom[3]);
		bath_room.setFont(new Font("나눔고딕", 35, 35)); // 화장실
		bath_room.setBounds(300, 510, 400, 70);
		this.add(bath_room);

		
		JLabel hall_room = new JLabel(cleanRoom[4]);
		hall_room.setFont(new Font("나눔고딕", 35, 35)); // 복도
		hall_room.setBounds(730, 230, 400, 70);
		this.add(hall_room);
		
		
		JLabel stair_room = new JLabel(cleanRoom[5]);
		stair_room.setFont(new Font("나눔고딕", 35, 35)); // 계단
		stair_room.setBounds(730, 340, 400, 70);
		this.add(stair_room);
		
		
		JLabel rest_room = new JLabel(cleanRoom[6]);
		rest_room.setFont(new Font("나눔고딕", 35, 35)); // 휴게실
		rest_room.setBounds(730, 445, 400, 70);
		this.add(rest_room);
		
		ImageIcon backicon = new ImageIcon("img//cleanroom_back.jpg");
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

class student_listUI extends JFrame { // 학생 리스트 전체보기
	public static Connection conn = null;
	int chk = 0;
	
	ArrayList<String[]> out_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "이름", "호실", "아이디", "상벌점" };	
	
	public void addStudent(String room, String name, String id) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO student(id, name, pw, room, score) VALUES(?, ?, ?, ?, ?)");

		ps.setInt(1, Integer.parseInt(id));
		ps.setString(2, name);
		ps.setString(3, id);
		ps.setInt(4, Integer.parseInt(room));
		ps.setInt(5, 0);
		
		int res = ps.executeUpdate();
		
		if(res == 1) System.out.println(String.format("%d row insert success", res));
		
		ps.close();
		
		conn.close();
	}
	
	public void delStudent(String room, String name) throws SQLException, ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");

		PreparedStatement ps = conn.prepareStatement("DELETE FROM student WHERE name='" + name + "' AND room=" + room);

		int res = ps.executeUpdate();
		
		if(res == 1) System.out.println(String.format("%d row insert success", res));
		
		ps.close();
		
		conn.close();
	}
	
	
	public void showStudent() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		out_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM student order by room");
		
		while(rs.next()) {
			out_list.add(new String[]{rs.getString("name"), rs.getString("room"), rs.getString("id"), rs.getString("score")});
		}
		
		int i = 0;
        if (out_list.size() != 0) {
            for (String[] book : out_list) {
            	contents[i][0] = book[0];// name
            	contents[i][1] = book[1]; // when
            	contents[i][2] = book[2]; // when
            	contents[i][3] = book[3]; // when
                i++;
            }
        }
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	student_listUI() throws ClassNotFoundException, SQLException {
		showStudent();

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		String room[] = {"401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417"};
		
		
		ImageIcon add = new ImageIcon("img//add.png"); // 추가
		JLabel add_label = new JLabel(add);
		add_label.setBounds(830, 50, 80, 55);
		this.add(add_label);
		
		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);
		
		add_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String add_room = null;
				add_room = JOptionPane.showInputDialog("추가를 원하는 호실을 입력해주세요");
				
				String add_name = null;
				add_name = JOptionPane.showInputDialog("추가를 원하는 학생의 이름을 입력해주세요");
				
				
				String add_id = null;
				add_id = JOptionPane.showInputDialog("추가를 원하는 학생의 id를 입력해주세요");
				
				try {
					addStudent(add_room, add_name, add_id);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				dispose();
			}
		});
		
		ImageIcon del = new ImageIcon("img//del.png");
		JLabel del_label = new JLabel(del);
		del_label.setBounds(920, 50, 80, 55);
		this.add(del_label);
		
		del_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String del_room = null;
				del_room = JOptionPane.showInputDialog("삭제를 원하는 학생의 호실을 입력해주세요");
				
				String del_name = null;
				del_name = JOptionPane.showInputDialog("삭제를 원하는 학생의 이름을 입력해주세요");
				
				try {
					delStudent(del_room, del_name);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				dispose();
 			}
		});
		
		JLabel student_num = new JLabel("신선영" + "               " + "1234" );
		student_num.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		student_num.setBounds(240, 230, 1000, 70);
		
		ImageIcon backicon = new ImageIcon("img//allstudent_list_back.png");
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



public class see_post {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new student_listUI();
	}

}


