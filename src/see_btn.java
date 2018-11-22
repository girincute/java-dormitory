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
		
		// 세탁기 버튼
		
		ImageIcon laundry_1 = new ImageIcon("img//laundry_1.png");
		JLabel laundry_1label = new JLabel(laundry_1);
		laundry_1label.setBounds(180, 250, 210, 260);
		this.add(laundry_1label);
		
		ImageIcon laundry_2 = new ImageIcon("img//laundry_2.png");
		JLabel laundry_2label = new JLabel(laundry_2);
		laundry_2label.setBounds(420, 250, 210, 260);
		this.add(laundry_2label);
		
		ImageIcon laundry_3 = new ImageIcon("img//laundry_3.png");
		JLabel laundry_3label = new JLabel(laundry_3);
		laundry_3label.setBounds(660, 250, 210, 260);
		this.add(laundry_3label);
		
		
		
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

		
		String out_kinds_arr[] = { "금토외박", "토요외박", "잔류", "특이"};
		
		JComboBox out_kinds = new JComboBox(out_kinds_arr);
		out_kinds.setBounds(420,290,200,75);
		this.add(out_kinds);

		JTextField tel = new JTextField(10);
		tel.setBounds(420,405,200,40);
		this.add(tel);
		
		ImageIcon send_out = new ImageIcon("img//send_message.png"); // 전송버튼
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(660, 330, 115, 70);
		this.add(send_out_label);
		
		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				//전송버튼 누를 시
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
				//전송버튼 누를 시
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

		
		JLabel index = new JLabel("외출일지");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(250, 200, 400, 70);
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




public class see_btn {
	public static void main(String[] args) {
//
		new write_airconUI();
//		
	}

}
