// 사감 선생님 전체 UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class UImain extends JFrame {
	public static Connection conn = null;
	public static int sid = -1;
	public static int ssid;
	public static String sname;
	public static int sroom;
	public static int sscore;
	public static int clean = 7;
	
	public static JLabel cleanroom;
	public static JLabel room_num;
	public static JLabel name;
	public static JLabel score;
	
	String clean_where[] = { "세면실", "샤워실", "세탁실", "화장실", "복도", "계단", "휴게실", "없음" };
	
	public void getClean() throws ClassNotFoundException, SQLException {
		String clean_where_db[] = {"washroom", "shower", "laundary", "toilet", "hall", "stair", "restarea"};
		
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM clean where room=" + loginUI.room);
		
		while(rs.next()) {
			String dbarea = rs.getString("area");
			
			for(int i = 0; i < clean_where_db.length; i++) {
				if(dbarea.equals(clean_where_db[i])) {
					clean = i;
					break;
				}
			}
		}
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	public static void chgStatus() {
		String clean_where[] = { "세면실", "샤워실", "세탁실", "화장실", "복도", "계단", "휴게실", "없음" };
		cleanroom.setText(clean_where[clean]);
		room_num.setText(String.valueOf(sroom));
		name.setText(sname);
		score.setText(sscore + "점");
	}
	
	public void fistu() throws ClassNotFoundException, SQLException {
		int chname = 0;
		
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		if(sid == -1) {
			rs = s.executeQuery("SELECT * FROM student ORDER BY sid LIMIT 1;");
			
			while(rs.next()) {
				chname = 1;
				sid = rs.getInt("id");
				ssid = rs.getInt("sid");
				System.out.println("f : " + sid);
				sname = rs.getString("name");
				sroom = rs.getInt("room");
				sscore = rs.getInt("score");
				getClean();
			}
			rs.close();
		}
		else chname = 1;
		
		if(chname == 0) JOptionPane.showMessageDialog(null, "없는 이름입니다!");
		
		s.close();
		
		conn.close();
	}
	
	public void chkStu(String name) throws ClassNotFoundException, SQLException {
		int chname = 0;
		
		Class.forName("org.sqlite.JDBC");
		
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM student where name='" + name + "'");
		
		while(rs.next()) {
			chname = 1;
			sid = rs.getInt("id");
			sname = rs.getString("name");
			sroom = rs.getInt("room");
			sscore = rs.getInt("score");
			getClean();
		}
		
		if(chname == 0) JOptionPane.showMessageDialog(null, "없는 이름입니다!");
		else chgStatus();
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
	UImain() throws ClassNotFoundException, SQLException {
		fistu();

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel la = new JLabel();
		this.add(la);

		// 학생 검색 텍스트 / 버튼
		JTextField search = new JTextField("이름");
		search.setBounds(120, 32, 170, 40);
		this.add(search);

		ImageIcon searchbtn = new ImageIcon("img//searchbtn.png");
		JLabel searchlabel = new JLabel(searchbtn);
		searchlabel.setBounds(315, 12, 140, 85);
		this.add(searchlabel);
			

		// 닉네임
		JLabel nickname = new JLabel("김사감" + " 님");
		nickname.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		nickname.setBounds(865, 70, 170, 70);
		this.add(nickname);

		// 이름 ( 수정 )

		room_num = new JLabel(String.valueOf(sroom));
		name = new JLabel(sname);

		room_num.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		name.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정

		room_num.setForeground(Color.BLUE);

		room_num.setBounds(50, 130, 150, 50);
		name.setBounds(160, 130, 150, 50);

		this.add(name);
		this.add(room_num);
		
		
		// 버튼 (수정, 수정 및 삭제)
		
		ImageIcon modifi_clean = new ImageIcon("img//modifi.png");
		JLabel modifi_clean_label = new JLabel(modifi_clean);
		modifi_clean_label.setBounds(640, 570, 85, 45);
		this.add(modifi_clean_label);
	
		cleanroom = new JLabel(clean_where[clean]);
		cleanroom.setFont(new Font("나눔고딕", 50, 50));
		cleanroom.setBounds(530, 430, 170, 50);
		this.add(cleanroom);
		
		score = new JLabel(String.valueOf(sscore)+"점");
		score.setFont(new Font("나눔고딕", 50, 50));
		score.setBounds(140, 430, 170, 50);
		this.add(score);

		modifi_clean_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				classroom_edit_UI classroom_edit = new classroom_edit_UI(); // 수정(청소구역)
			}
		});
		
		ImageIcon modifiandremove = new ImageIcon("img//modifiandremove.png");
		JLabel modifiandremovelabel = new JLabel(modifiandremove);
		modifiandremovelabel.setBounds(233, 575, 140, 40);
		this.add(modifiandremovelabel);

		modifiandremovelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				plus_and_minus_edit_UI plus_and_minus_edit = new plus_and_minus_edit_UI(); // 수정 및 삭제(상벌점 현황)
			}
		});

		// 버튼 (학생 리스트, 메세지, 우편함, 세탁일지, 외박일지, 에어컨사용, 외출일지)
		
		
		
		ImageIcon student_list = new ImageIcon("img//student_list.png");
		JLabel student_listlabel = new JLabel(student_list);
		student_listlabel.setBounds(500, 110, 200, 100);
		this.add(student_listlabel);
		
		student_listlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					student_listUI student_list = new student_listUI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 학생 리스트 전체 보기
			}
		});		

		ImageIcon message = new ImageIcon("img//profile.png");
		JLabel messagelabel = new JLabel(message);
		messagelabel.setBounds(360, 110, 90, 90);
		this.add(messagelabel);

		messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				send_message_teacher send_message_teacher = new send_message_teacher(); // 쪽지보내기
			}
		});
		
		ImageIcon postbox = new ImageIcon("img//postbox.png");
		JLabel postboxlabel = new JLabel(postbox);
		postboxlabel.setBounds(755, 60, 90, 90);
		this.add(postboxlabel);

		postboxlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					message_room_teacher message_room_teacherUI = new message_room_teacher();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 쪽지함
			}
		});

		ImageIcon laundryicon_teacher = new ImageIcon("img//laundryicon_teacher.png");
		JLabel laundrylabel_teacher = new JLabel(laundryicon_teacher);
		laundrylabel_teacher.setBounds(750, 185, 260, 90);
		this.add(laundrylabel_teacher);

		laundrylabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					check_laundry_UI check_laundry = new check_laundry_UI();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}// 세탁일지 클릭했을 때
			}
		});

		ImageIcon outicon_teacher = new ImageIcon("img//outicon_teacher.png");
		JLabel outlabel_teacher = new JLabel(outicon_teacher);
		outlabel_teacher.setBounds(750, 275, 260, 90);
		this.add(outlabel_teacher);

		outlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					check_out_UI check_out = new check_out_UI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}// 외박일지 클릭했을 때
			}
		});

		ImageIcon airconicon_teacher = new ImageIcon("img//airconicon_teacher.png");
		JLabel airconlabel_teacher = new JLabel(airconicon_teacher);
		airconlabel_teacher.setBounds(750, 365, 260, 90);
		this.add(airconlabel_teacher);

		airconlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					check_aircon_UI check_aircon = new check_aircon_UI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 에어컨 신청 클릭했을 때
			}
		});

		ImageIcon soonouticon_teacher = new ImageIcon("img//soonouticon_teacher.png");
		JLabel soonoutlabel_teacher = new JLabel(soonouticon_teacher);
		soonoutlabel_teacher.setBounds(750, 455, 260, 90);
		this.add(soonoutlabel_teacher);

		soonoutlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					check_soonout_UI check_soonout = new check_soonout_UI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 외출일지 클릭했을 때
			}
		});
		
		
		ImageIcon notice = new ImageIcon("img//notice.png");
		JLabel noticelabel = new JLabel(notice);
		noticelabel.setBounds(750, 545, 260, 90);
		this.add(noticelabel);

		noticelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				notice_edit_UI notice_edit = new notice_edit_UI();// 공지사항
			}
		});
		

		ImageIcon backicon = new ImageIcon("img//teacher_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		searchlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					chkStu(search.getText());
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

public class teacher_main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new UImain();
	}

}
