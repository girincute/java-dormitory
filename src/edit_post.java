
// 포스트들에 관련된 (공지사항 더보기, 상벌점 더보기, 청소구역 전체보기 ) UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class plus_and_minus_edit_UI extends JFrame { // 상벌점 추가/삭제

	plus_and_minus_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField why = new JTextField(); // 항목
		why.setBounds(460, 265, 250, 40);
		this.add(why);
		
		JTextField plus = new JTextField(); // 상점
		plus.setBounds(460, 330, 70, 40);
		this.add(plus);
		
		JTextField minus = new JTextField(); // 벌점
		minus.setBounds(460, 400, 70, 40);
		this.add(minus);
		
		// 변경 버튼
				ImageIcon changbtn = new ImageIcon("img//changbtn.png");
				JLabel changbtn_label = new JLabel(changbtn);
				changbtn_label.setBounds(460, 560, 170, 70);
				this.add(changbtn_label);

				changbtn_label.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						// 변경버튼 클릭했을 때
					}
				});
		
		// 백그라운드 (배경)
		ImageIcon backicon = new ImageIcon("img//add_plus_and_minus_back.jpg");
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

class classroom_edit_UI extends JFrame { // 청소구역 수정

	classroom_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String clean_where[] = { "세면실", "샤워실", "세탁실", "화장실", "복도", "계단", "휴게실" };

		JComboBox room_arr = new JComboBox(clean_where);
		room_arr.setBounds(570, 285, 100, 40);
		this.add(room_arr);

		JTextField search = new JTextField();
		search.setBounds(570, 375, 100, 40);
		this.add(search);

		// 변경 버튼
		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(460, 560, 170, 70);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 변경버튼 클릭했을 때
			}
		});

		// 백그라운드
		ImageIcon backicon = new ImageIcon("img//change_cleanroom_back.jpg");
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

class notice_edit_UI extends JFrame { // 공지사항 수정

	notice_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		// 공지사항 내용
		JTextField search = new JTextField();
		search.setBounds(120, 150, 840, 410);
		this.add(search);

		// 변경 버튼
		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(420, 590, 170, 70);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 변경버튼 클릭했을 때
			}
		});

		// 배경
		ImageIcon backicon = new ImageIcon("img//upload_notice.jpg");
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

public class edit_post {
	public static void main(String[] args) {
		new plus_and_minus_edit_UI();
	}
}
