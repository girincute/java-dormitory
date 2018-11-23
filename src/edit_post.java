// ����Ʈ�鿡 ���õ� (�������� ������, ����� ������, û�ұ��� ��ü���� ) UI


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class plus_and_minus_edit_UI extends JFrame { // ����� �߰�/����
	
	plus_and_minus_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("����� ����");
		index.setFont(new Font("�������", 50, 50)); // ��Ʈ ����
		index.setBounds(170, 200, 600, 70);
		this.add(index);
		
//		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
		
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class classroom_edit_UI extends JFrame { // û�ұ��� ����
	
	classroom_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("û�ұ��� ����");
		index.setFont(new Font("�������", 50, 50)); // ��Ʈ ����
		index.setBounds(170, 200, 600, 70);
		this.add(index);
		
//		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
//		JLabel backlabel = new JLabel(backicon);
//		backlabel.setBounds(0, 0, 1080, 720);
//		this.add(backlabel);
		
		// this.setResizable(false); // ���α׷��� �Ժη� ũ�� ������ �� �ֳ�?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // ����, ������ �� �� ����
		// �� �ְ� �ϴ°� ��Ǽ�
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class notice_edit_UI extends JFrame { // �������� ����
	
	notice_edit_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		//�������� ����
		JTextField search = new JTextField();
		search.setBounds(120, 150, 840, 410);
		this.add(search);
		
		//���� ��ư
		ImageIcon changbtn = new ImageIcon("img//changbtn.png");
		JLabel changbtn_label = new JLabel(changbtn);
		changbtn_label.setBounds(420, 590, 170, 70);
		this.add(changbtn_label);
		
		changbtn_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �����ư Ŭ������ ��
			}
		});
		
		// ���
		ImageIcon backicon = new ImageIcon("img//upload_notice.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


public class edit_post {
	public static void main(String[] args) {
		new notice_edit_UI();
	}
}
