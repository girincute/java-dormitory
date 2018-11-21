
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class message_room_student extends JFrame {
	
	message_room_student() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
			// 세탁기 버튼
		

		JLabel date = new JLabel("2018-11-21");
		date.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		date.setBounds(170, 200, 170, 70);
		this.add(date);

		JLabel label = new JLabel("맛있는 초코쿠키를 먹었습니다.");
		label.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		label.setBounds(340, 200, 300, 70);
		this.add(label);

		
		ImageIcon backicon = new ImageIcon("img//messageroom_student.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}


class message_room_teacher extends JFrame {
	
	message_room_teacher() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
			// 세탁기 버튼
		

		JLabel date = new JLabel("2018-11-21");
		date.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		date.setBounds(170, 200, 150, 70);
		this.add(date);
		
		JLabel receiver = new JLabel("김예빈");
		receiver.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		receiver.setBounds(380, 200, 100, 70);
		this.add(receiver);

		JLabel label = new JLabel("백엔드 화이팅 ㅎvㅎ 쪽지함을 만들었서여");
		label.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		label.setBounds(530, 200, 300, 70);
		this.add(label);

		
		ImageIcon backicon = new ImageIcon("img//messageroom_teacher.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}







public class message {
	public static void main(String[] args) {
//
//		new message_room_teacher();
//		
	}

}
