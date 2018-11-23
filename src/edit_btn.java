// ������ ���õ� (������, ����������) UI

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

		String header[] = { "��Ź�� ��ȣ", "�ð�", "��û�� �̸�" };

		String contents[][] = { { "1", "20:00~21:30", "������" }, { "2", "20:00~21:30", "�󸶻�" },
				{ "1", "22:30~23:30", "ŸŸŸ" } };

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
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_out_UI extends JFrame { // �ܹ����� Ȯ��

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
				// �����ư Ŭ������ ��
			}
		});

		String header[] = { "����", "�̸�", "�ܹ� ����", "����ó" };

		String contents[][] = { { "1", "������", "�ݿ�ܹ�", "010-0000-0000" }, { "2", "��ݱ�", "�ݿ�ܹ�", "010-1111-0000" },
				{ "3", "������", "���ܹ�", "010-0000-1111" }, { "4", "�����", "�ܷ�", "010-2222-0000" } };

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
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_aircon_UI extends JFrame { // ��������û Ȯ��

	check_aircon_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String header[] = { "����", "ȣ��" };

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
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class check_soonout_UI extends JFrame { // �������� Ȯ��

	check_soonout_UI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String header[] = { "ȣ��", "�̸�", "�ð�" };

		String contents[][] = { { "401", "������", "18:31~20:00" }, { "412", "����", "12:31~15:00" },
				{ "403", "�Żǽ�", "19:17~20:30" } };

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
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

public class edit_btn {
	public static void main(String[] args) {
		new check_out_UI();
	}

}
