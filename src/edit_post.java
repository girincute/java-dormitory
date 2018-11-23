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

		
		JLabel index = new JLabel("상벌점 수정");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 600, 70);
		this.add(index);
		
//		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
		
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

		
		JLabel index = new JLabel("청소구역 수정");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 600, 70);
		this.add(index);
		
//		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
		
		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
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

		//공지사항 내용
		JTextField search = new JTextField();
		search.setBounds(120, 150, 840, 410);
		this.add(search);
		
		//변경 버튼
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
		new notice_edit_UI();
	}
}
