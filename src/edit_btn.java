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

		
		JLabel index = new JLabel("세탁일지확인");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
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


class check_out_UI extends JFrame { // 외박일지 확인
	
	check_out_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("외박일지 확인");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
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


class check_aircon_UI extends JFrame { // 에어컨신청 확인
	
	check_aircon_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("에어컨신청 확인");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
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

class check_soonout_UI extends JFrame { // 외출일지 확인
	
	check_soonout_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("외출일지 확인");
		index.setFont(new Font("나눔고딕", 50, 50)); // 폰트 설정
		index.setBounds(170, 200, 400, 70);
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



public class edit_btn {
	public static void main(String[] args) {

	}

}
