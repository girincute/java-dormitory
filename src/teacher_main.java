// 사감 선생님 전체 UI

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

class UImain extends JFrame {
	UImain() {

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
		
		searchlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				search_student_UI search_student = new search_student_UI();// 검색 버튼 누르면
			}
		});
		

		// 닉네임

		JLabel nickname = new JLabel("김사감" + " 님");
		nickname.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		nickname.setBounds(865, 70, 170, 70);
		this.add(nickname);

		// 이름 ( 수정 )

		JLabel room_num = new JLabel("503-3");
		JLabel name = new JLabel("신선영");

		room_num.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		name.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정

		room_num.setForeground(Color.BLUE);

		room_num.setBounds(50, 130, 150, 50);
		name.setBounds(200, 130, 150, 50);

		this.add(name);
		this.add(room_num);
		
		
		// 버튼 (수정, 수정 및 삭제)
		
		ImageIcon modifi_clean = new ImageIcon("img//modifi.png");
		JLabel modifi_clean_label = new JLabel(modifi_clean);
		modifi_clean_label.setBounds(640, 570, 85, 45);
		this.add(modifi_clean_label);

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
				student_listUI student_list = new student_listUI(); // 학생 리스트 전체 보기
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
				message_room_teacher message_room_teacherUI = new message_room_teacher(); // 쪽지함
			}
		});
		

		

		ImageIcon laundryicon_teacher = new ImageIcon("img//laundryicon_teacher.png");
		JLabel laundrylabel_teacher = new JLabel(laundryicon_teacher);
		laundrylabel_teacher.setBounds(750, 185, 260, 90);
		this.add(laundrylabel_teacher);

		laundrylabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check_laundry_UI check_laundry = new check_laundry_UI();// 세탁일지 클릭했을 때
			}
		});

		ImageIcon outicon_teacher = new ImageIcon("img//outicon_teacher.png");
		JLabel outlabel_teacher = new JLabel(outicon_teacher);
		outlabel_teacher.setBounds(750, 275, 260, 90);
		this.add(outlabel_teacher);

		outlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check_out_UI check_out = new check_out_UI();// 외박일지 클릭했을 때
			}
		});

		ImageIcon airconicon_teacher = new ImageIcon("img//airconicon_teacher.png");
		JLabel airconlabel_teacher = new JLabel(airconicon_teacher);
		airconlabel_teacher.setBounds(750, 365, 260, 90);
		this.add(airconlabel_teacher);

		airconlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check_aircon_UI check_aircon = new check_aircon_UI(); // 에어컨 신청 클릭했을 때
			}
		});

		ImageIcon soonouticon_teacher = new ImageIcon("img//soonouticon_teacher.png");
		JLabel soonoutlabel_teacher = new JLabel(soonouticon_teacher);
		soonoutlabel_teacher.setBounds(750, 455, 260, 90);
		this.add(soonoutlabel_teacher);

		soonoutlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				check_soonout_UI check_soonout = new check_soonout_UI(); // 외출일지 클릭했을 때
			}
		});
		
		
		
		ImageIcon notice = new ImageIcon("img//notice.png");
		JLabel noticelabel = new JLabel(notice);
		noticelabel.setBounds(750, 545, 260, 90);
		this.add(noticelabel);

		noticelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				notice_edit_UI notice_edit = new notice_edit_UI();// 공지사랑
			}
		});
		

		ImageIcon backicon = new ImageIcon("img//teacher_back.jpg");
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

public class teacher_main {
	public static void main(String[] args) {
		new UImain();
	}

}
