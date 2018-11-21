//
//import java.awt.*;
//import java.awt.event.*;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import javax.swing.event.*;
//
//
//class messageUI extends JFrame {
//	
//	write_laundryUI() {
//		
//	
//		this.setTitle("Dormitory Management System_write_laundry");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(null);
//			// 세탁기 버튼
//		
//		ImageIcon laundry_1 = new ImageIcon("img//laundry_1.png");
//		JLabel laundry_1label = new JLabel(laundry_1);
//		laundry_1label.setBounds(180, 250, 210, 260);
//		this.add(laundry_1label);
//		
//		ImageIcon laundry_2 = new ImageIcon("img//laundry_2.png");
//		JLabel laundry_2label = new JLabel(laundry_2);
//		laundry_2label.setBounds(420, 250, 210, 260);
//		this.add(laundry_2label);
//		
//		ImageIcon laundry_3 = new ImageIcon("img//laundry_3.png");
//		JLabel laundry_3label = new JLabel(laundry_3);
//		laundry_3label.setBounds(660, 250, 210, 260);
//		this.add(laundry_3label);
//		
//		
//		
//		ImageIcon backicon = new ImageIcon("img//write_laundry_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
//		
//		// this.setResizable(false); // 프로그램을 함부로 크기 조정할 수 있나?
//		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // 왼쪽, 오른쪽 둘 다 넣을
//		// 수 있게 하는게 디맨션
//		this.pack();
//		this.setSize(1080, 720);
//		this.setVisible(true);
//		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
//		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	}
//}
//
//
//
//
//public class message {
//	public static void main(String[] args) {
////
//		new write_outUI();
////		
//	}
//
//}
