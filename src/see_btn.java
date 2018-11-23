// 쪽지와 관련된 (쪽지함, 쪽지보내기) UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class write_laundryUI extends JFrame {

	write_laundryUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		// 세탁기 번호

		String laundry_num_arr[] = {"1", "2", "3"};

		JComboBox laundry_num = new JComboBox(laundry_num_arr);
		laundry_num.setBounds(290, 580, 50, 40);
		this.add(laundry_num);


		// 시간

		String laundry_time_arr[] = {"20:00~21:30", "21:30~22:30", "22:30~23:30"};
		
		JComboBox laundry_time = new JComboBox(laundry_time_arr);
		laundry_time.setBounds(400, 580, 250, 40);
		this.add(laundry_time);
		
		ImageIcon send_laundry = new ImageIcon("img//apply.png"); // 전송버튼
		JLabel send_laundry_label = new JLabel(send_laundry);
		send_laundry_label.setBounds(690, 560, 130, 80);
		this.add(send_laundry_label);

		send_laundry_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전송버튼 누를 시
			}
		});
		
		
		// 배경
		ImageIcon backicon = new ImageIcon("img//write_laundry_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		

		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
		// 수 있게 하는게 디맨션
		this.pack();
		this.setSize(1080, 720);
		this.dispose();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class write_outUI extends JFrame { // 외박일지

	write_outUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String out_kinds_arr[] = { "금토외박", "토요외박", "잔류", "특이" };

		JComboBox out_kinds = new JComboBox(out_kinds_arr);
		out_kinds.setBounds(420, 290, 200, 75);
		this.add(out_kinds);

		JTextField tel = new JTextField(10);
		tel.setBounds(420, 405, 200, 40);
		this.add(tel);

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // 전송버튼
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(660, 330, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전송버튼 누를 시
			}
		});

		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
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

class write_airconUI extends JFrame { // 에어컨 신청

	write_airconUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel index = new JLabel("~ 14:00");
		index.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		index.setBounds(530, 300, 200, 70);
		this.add(index);

		ImageIcon send_aircon = new ImageIcon("img//apply.png"); // 전송버튼
		JLabel send_aircon_label = new JLabel(send_aircon);
		send_aircon_label.setBounds(480, 480, 130, 80);
		this.add(send_aircon_label);

		send_aircon_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전송버튼 누를 시
			}
		});

		ImageIcon backicon = new ImageIcon("img//aircon_back.jpg");
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

class write_soonoutUI extends JFrame { // 외출일지

	write_soonoutUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField hour = new JTextField(2);
		hour.setBounds(540, 290, 50, 60);
		this.add(hour);

		JTextField minute = new JTextField(2);
		minute.setBounds(650, 290, 50, 60);
		this.add(minute);

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // 전송버튼
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(480, 450, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 전송버튼 누를 시
			}
		});

		ImageIcon backicon = new ImageIcon("img//soonout_back.jpg");
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

public class see_btn {
	public static void main(String[] args) {
		//
		//new write_laundryUI();
		//
	}

}
