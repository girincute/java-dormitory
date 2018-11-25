// 정보수정하기

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class Changing_informationUI extends JFrame { // 정보수정
	
	Changing_informationUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JTextField search = new JTextField(40);
		search.setBounds(450, 335, 270, 40);
		this.add(search);
		
		ImageIcon changebtn = new ImageIcon("img//changbtn.png");
		JLabel changebtn_label = new JLabel(changebtn);
		changebtn_label.setBounds(450, 550, 170, 70);
		this.add(changebtn_label);

		
		ImageIcon backicon = new ImageIcon("img//changing_information_back.jpg");
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


public class changing_information {

}
