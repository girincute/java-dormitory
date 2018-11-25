// 쪽지와 관련된 (쪽지함, 쪽지보내기) UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class check_laundry_UI extends JFrame {

	check_laundry_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String header[] = { "세탁기 번호", "시간", "신청자 이름" };

		String contents[][] = { { "1", "20:00~21:30", "가나다" }, { "2", "20:00~21:30", "라마사" },
				{ "1", "22:30~23:30", "타타타" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//laundry_check_back.jpg");
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

class check_out_UI extends JFrame { // 외박일지 확인

	check_out_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String room[] = { "401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413",
				"414", "415", "416", "417" };

		JComboBox room_arr = new JComboBox(room);
		room_arr.setBounds(430, 250, 100, 50);
		this.add(room_arr);
		
		ImageIcon changbtn = new ImageIcon("img//changbtn_small.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(550, 250, 120, 50);
		this.add(changbtn_label);

		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 변경버튼 클릭했을 때
			}
		});

		String header[] = { "순번", "이름", "외박 종류", "연락처" };

		String contents[][] = { { "1", "영영영", "금요외박", "010-0000-0000" }, { "2", "김금김", "금요외박", "010-1111-0000" },
				{ "3", "허히후", "토요외박", "010-0000-1111" }, { "4", "모찌랑", "잔류", "010-2222-0000" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 350, 770, 89);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//goout_check_back.jpg");
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

class check_aircon_UI extends JFrame { // 에어컨신청 확인

	check_aircon_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String header[] = { "순번", "호실" };

		String contents[][] = { { "1", "402" }, { "2", "411" }, { "3", "402" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//aircon_check_back.jpg");
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

class check_soonout_UI extends JFrame { // 외출일지 확인

	check_soonout_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String header[] = { "호실", "이름", "시간" };

		String contents[][] = { { "401", "갸오오", "18:31~20:00" }, { "412", "룰라라", "12:31~15:00" },
				{ "403", "신뽀스", "19:17~20:30" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 180, 770, 400);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//out_check_back.jpg");
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

public class edit_btn {
	public static void main(String[] args) {
		new check_out_UI();
	}

}
