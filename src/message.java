// 쪽지와 관련된(쪽지함, 쪽지보내기) UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class message_room_student extends JFrame { // 학생 쪽지함
	
	message_room_student() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

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

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class message_room_teacher extends JFrame { // 사감쌤 쪽지함
	
	message_room_teacher() {
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		

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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class send_message_student extends JFrame { // 학생 -> 사감
	
	send_message_student() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);


		JLabel send_teacher = new JLabel("사감 선생님");
		send_teacher.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		send_teacher.setBounds(370, 185, 170, 70);
		this.add(send_teacher);
		
		JTextField post = new JTextField("내용");
		post.setBounds(170, 270, 600, 300);
		this.add(post);
		
		ImageIcon send_message = new ImageIcon("img//send_message.png");
		JLabel send_messagelabel = new JLabel(send_message);
		send_messagelabel.setBounds(820, 520, 120, 70);
		this.add(send_messagelabel);
		
		send_messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String a[] = {loginUI.id, "2018", post.getText()};
				try {
					sendMessage.main(a);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//send_message.jpg");
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

class send_message_teacher extends JFrame { // 사감 -> 학생
	
	send_message_teacher() {
		
	
		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel search = new JLabel("신선영");
		search.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		search.setBounds(370, 200, 170, 40);
		this.add(search);

		
		JTextField post = new JTextField("내용");
		post.setBounds(170, 270, 600, 300);
		this.add(post);
		
		ImageIcon send_message = new ImageIcon("img//send_message.png");
		JLabel send_messagelabel = new JLabel(send_message);
		send_messagelabel.setBounds(820, 520, 120, 70);
		this.add(send_messagelabel);

		send_messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String a[] = {"2018", String.valueOf(UImain.sid), post.getText()};
				try {
					sendMessage.main(a);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		ImageIcon backicon = new ImageIcon("img//send_message.jpg");
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




public class message {
	public static void main(String[] args) {

		new send_message_student();

	}

}
