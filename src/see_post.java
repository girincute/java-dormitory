// 포스트들에 관련된 (공지사항 더보기, 상벌점 더보기, 청소구역 전체보기 ) UI


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class noticeUI extends JFrame { // 공지사항
	
	noticeUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("공지사항을 여기에 써주세용!!");
		index.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
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
	
	plus_and_minusUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		String header[] = { "날짜", "내용", "점수" };

		String contents[][] = { { "2018.05.01", "여기에는", "+3" }, { "2018.09.17", "DB", "-4" },
				{ "2018.11.02", "내 생일", "-1" }, { "2018.11.07", "초코쿠키 먹고싶당", "+0.5" } };

		JTable table = new JTable(contents, header);
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
	
	cleanclassUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel clean_face_room = new JLabel("501");
		clean_face_room.setFont(new Font("나눔고딕", 35, 35)); // 세면실
		clean_face_room.setBounds(300, 200, 400, 70);
		this.add(clean_face_room);
		
		
		JLabel shower_room = new JLabel("502");
		shower_room.setFont(new Font("나눔고딕", 35, 35)); // 샤워실
		shower_room.setBounds(300, 300, 400, 70);
		this.add(shower_room);
		
		
		JLabel laundry_room = new JLabel("503");
		laundry_room.setFont(new Font("나눔고딕", 35, 35)); // 세탁실
		laundry_room.setBounds(300, 410, 400, 70);
		this.add(laundry_room);
		
		JLabel bath_room = new JLabel("504");
		bath_room.setFont(new Font("나눔고딕", 35, 35)); // 화장실
		bath_room.setBounds(300, 510, 400, 70);
		this.add(bath_room);

		
		JLabel hall_room = new JLabel("505");
		hall_room.setFont(new Font("나눔고딕", 35, 35)); // 복도
		hall_room.setBounds(730, 230, 400, 70);
		this.add(hall_room);
		
		
		JLabel stair_room = new JLabel("506");
		stair_room.setFont(new Font("나눔고딕", 35, 35)); // 계단
		stair_room.setBounds(730, 340, 400, 70);
		this.add(stair_room);
		
		
		JLabel rest_room = new JLabel("507");
		rest_room.setFont(new Font("나눔고딕", 35, 35)); // 휴게실
		rest_room.setBounds(730, 445, 400, 70);
		this.add(rest_room);
		
		/////
		
		
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
	
	student_listUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		String room[] = {"401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417"};
		
		JComboBox room_arr = new JComboBox(room);
		room_arr.setBounds(380, 35, 100, 40);
		this.add(room_arr);
		
		ImageIcon searchbtn_small = new ImageIcon("img//searchbtn_small.png"); // 검색
		JLabel searchbtn_small_label = new JLabel(searchbtn_small);
		searchbtn_small_label.setBounds(480, 15, 130, 80);
		this.add(searchbtn_small_label);
		
		searchbtn_small_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 검색버튼 눌렀을 때
			}
		});
		
		ImageIcon add = new ImageIcon("img//add.png"); // 추가
		JLabel add_label = new JLabel(add);
		add_label.setBounds(830, 30, 80, 55);
		this.add(add_label);
		
		add_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String add_room = null;
				add_room = JOptionPane.showInputDialog("추가를 원하는 호실을 입력해주세요");
				// 호실에 사람이 다 차있으면 추가 불가능 (구현필요하면 하깅)
				
				String add_name = null;
				add_name = JOptionPane.showInputDialog("추가를 원하는 학생의 이름을 입력해주세요");
				
				
				String add_id = null;
				add_id = JOptionPane.showInputDialog("추가를 원하는 학생의 id를 입력해주세요");

			}
		});
		
		ImageIcon del = new ImageIcon("img//del.png"); // 삭제
		JLabel del_label = new JLabel(del);
		del_label.setBounds(920, 30, 80, 55);
		this.add(del_label);
		
		del_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String del_room = null;
				del_room = JOptionPane.showInputDialog("삭제를 원하는 학생의 호실을 입력해주세요");
				
				String del_name = null;
				del_name = JOptionPane.showInputDialog("삭제를 원하는 학생의 이름을 입력해주세요");

			}
		});



		
		JLabel student_num = new JLabel("신선영" + "               " + "1234" );
		student_num.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		student_num.setBounds(240, 230, 1000, 70);
		this.add(student_num);
		
		ImageIcon backicon = new ImageIcon("img//allstudent_list_back.jpg");
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



public class see_post {
	public static void main(String[] args) {
		new student_listUI();
	}

}


