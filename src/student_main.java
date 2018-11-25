
// 학생 전체 UI

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
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Calendar;
import java.util.List;

//import org.hyunjun.school.School;
//import org.hyunjun.school.SchoolMenu;
//import org.hyunjun.school.SchoolException;

class UItest extends JFrame {
	public static Connection conn = null;
	
	public int clean = 7;
	
	ArrayList<String[]> score_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "내용", "점수" };
	
	public String notice;
	
	public String meal;
	
//	public void getMeal() {
//		School api = new School(School.Type.HIGH, School.Region.SEOUL, "B100000439");
//
//        Calendar cal = Calendar.getInstance(); // Date 가져오기
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH) + 1; // 월
//        int date = cal.get(Calendar.DAY_OF_MONTH); // 일
//
//        try {
//            List<SchoolMenu> menu = api.getMonthlyMenu(year, month);
//            System.out.println(year + "년 " + month + "월 " + date + "일 급식\n");
//            meal = menu.get(date - 1).breakfast;
//
//        } catch(SchoolException e) {
//            e.printStackTrace();
//        }
//	}
	
	public void noticeList() throws SQLException, ClassNotFoundException {	
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM notice order by nid desc LIMIT 1");
		
		while(rs.next()) {
			notice = rs.getString("notice");
		}
		
		s.close();
		rs.close();
		
		conn.close();
	}
	
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
	
	public void updateClean() throws ClassNotFoundException, SQLException {
		String clean_where_db[] = {"washroom", "shower", "laundary", "toilet", "hall", "stair", "restarea"};
		
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		rs = s.executeQuery("SELECT * FROM clean");
		
		int nowroom = 400;
		while(rs.next()) {
			nowroom = rs.getInt("room");
		}
		
		System.out.println(nowroom);
		
		s.close();
		rs.close();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE clean SET room = '" + nowroom + "' where area = '" + clean_where_db[6] + "'");;
		
		for(int i = 0; i < 7; i++) {
			nowroom++;

			ps = conn.prepareStatement("UPDATE clean SET room = '" + nowroom + "' where area = '" + clean_where_db[i] + "'");
			int res = ps.executeUpdate();
			
			if(nowroom == 417) nowroom = 400;
		}
		
		ps.close();
		
		conn.close();
	}
	
	// 청소 구역 얻기
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
		
		rs = s.executeQuery("SELECT * FROM clean");
		
		s.close();
		rs.close();
		
		conn.close();
	}

	UItest() throws ClassNotFoundException, SQLException {
		if(loginUI.score <= -10) {
			JOptionPane.showMessageDialog(null, "벌점이 10점 이상입니다!("+loginUI.score + "점) 주의하세요!!");
		}
		else {
			System.out.println("메인 " + loginUI.score);
		}
//		getMeal(); // 자바 업데이트 후 보셔야 합니당!

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		// 닉네임
		JLabel nickname = new JLabel(loginUI.name + " 님");
		nickname.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		nickname.setBounds(890, 40, 170, 70);
		this.add(nickname);

		// 공지사항
		noticeList();
		JLabel post1 = new JLabel(notice);
		post1.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		post1.setBounds(50, 20, 400, 300);
		this.add(post1);

		// 공지사항 더 보기

		ImageIcon more_post = new ImageIcon("img//more_post.png");
		JLabel more_postlable = new JLabel(more_post);
		more_postlable.setBounds(360, 250, 120, 60);
		this.add(more_postlable);

		more_postlable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					noticeUI notice = new noticeUI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 공지사항 전체 보기
			}
		});

		// 상 벌점
		getScoreList();
		
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(50, 480, 400, 75);
		this.add(scrollpane);

		ImageIcon more_table = new ImageIcon("img//more_table.png");
		JLabel more_tablelabel = new JLabel(more_table);
		more_tablelabel.setBounds(360, 560, 120, 60);
		this.add(more_tablelabel);

		more_tablelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					plus_and_minusUI plus_and_minus = new plus_and_minusUI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 상벌점 더 보기
			}
		});

		Calendar cal = Calendar.getInstance() ;
	    cal.setTime(new Date());
	     
//	    int dayNum = cal.get(Calendar.DAY_OF_WEEK) ;
	    int dayNum = 2;
	
	    if(dayNum == 2) updateClean();
		// 청소구역
		getClean();
		String clean_where[] = { "세면실", "샤워실", "세탁실", "화장실", "복도", "계단", "휴게실", "없음" };
		
		JLabel todayclean = new JLabel(clean_where[clean]);
		todayclean.setFont(new Font("나눔고딕", 35, 35)); // 폰트 설정
		todayclean.setBounds(600, 200, 400, 300);
		this.add(todayclean);

		// 청소구역 전체보기

		ImageIcon seeall = new ImageIcon("img//seeall.png");
		JLabel seealllable = new JLabel(seeall);
		seealllable.setBounds(695, 298, 60, 20);
		this.add(seealllable);

		seealllable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					cleanclassUI cleanclass = new cleanclassUI();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}// 청소 구역 전체 보기
			}
		});

		// 학사일정

		JLabel special_date = new JLabel("11월 17일");
		special_date.setFont(new Font("나눔고딕", 25, 25)); // 폰트 설정
		special_date.setBounds(580, 150, 150, 50);
		this.add(special_date);

		JLabel special_post = new JLabel("일정이 없습니다.");
		special_post.setFont(new Font("나눔고딕", 15, 15)); // 폰트 설정
		special_post.setBounds(580, 180, 150, 50);
		this.add(special_post);
			
		JLabel mealL = new JLabel(meal);
		mealL.setFont(new Font("나눔고딕", 25, 25)); // 폰트 설정
		mealL.setBounds(810, 150, 600, 600);
		this.add(mealL);

		// 버튼 (쪽지, 쪽지함, 프로필, 세탁일지, 외박일지, 에어컨사용, 외출일지)

		ImageIcon send = new ImageIcon("img//send.png");
		JLabel sendlabel = new JLabel(send);
		sendlabel.setBounds(530, 30, 90, 90);
		this.add(sendlabel);

		sendlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				send_message_student message = new send_message_student(); // 쪽지보내기
			}
		});

		ImageIcon postbox = new ImageIcon("img//postbox.png");
		JLabel postboxlabel = new JLabel(postbox);
		postboxlabel.setBounds(655, 30, 90, 90);
		this.add(postboxlabel);

		postboxlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					message_room_student message_room_student = new message_room_student();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 쪽지함
			}
		});

		ImageIcon profile = new ImageIcon("img//profile.png");
		JLabel profilelabel = new JLabel(profile);
		profilelabel.setBounds(785, 30, 90, 90);
		this.add(profilelabel);

		profilelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Changing_informationUI changing_informationUI = new Changing_informationUI(); // 정보수정 클릭했을 때
			}
		});

		ImageIcon laundryicon = new ImageIcon("img//laundryicon.png");
		JLabel laundrylabel = new JLabel(laundryicon);
		laundrylabel.setBounds(770, 415, 260, 90);
		this.add(laundrylabel);

		laundrylabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					write_laundryUI laundryUI = new write_laundryUI();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // 세탁일지
			}
		});

		ImageIcon outicon = new ImageIcon("img//outicon.png");
		JLabel outlabel = new JLabel(outicon);
		outlabel.setBounds(510, 415, 260, 90);
		this.add(outlabel);

		outlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				write_outUI outUI = new write_outUI(); // 외박일지
			}
		});

		ImageIcon airconicon = new ImageIcon("img//airconicon.png");
		JLabel airconlabel = new JLabel(airconicon);
		airconlabel.setBounds(510, 512, 260, 90);
		this.add(airconlabel);

		airconlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				write_airconUI airconUI = new write_airconUI(); // 에어컨 신청 클릭했을 때
			}
		});

		ImageIcon soonouticon = new ImageIcon("img//soonouticon.png");
		JLabel soonoutlabel = new JLabel(soonouticon);
		soonoutlabel.setBounds(770, 515, 260, 90);
		this.add(soonoutlabel);

		soonoutlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				write_soonoutUI soonoutUI = new write_soonoutUI(); // 외출일지 클릭했을 때
			}
		});

		ImageIcon backicon = new ImageIcon("img//back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.dispose();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


public class student_main { 
	
	public static void main() throws ClassNotFoundException, SQLException{			
		new UItest();
	}

}
