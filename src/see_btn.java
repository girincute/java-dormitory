// ������ ���õ� (������, ����������) UI

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
		
		// ��Ź�� ��ȣ

		String laundry_num_arr[] = {"1", "2", "3"};

		JComboBox laundry_num = new JComboBox(laundry_num_arr);
		laundry_num.setBounds(290, 580, 50, 40);
		this.add(laundry_num);


		// �ð�

		String laundry_time_arr[] = {"20:00~21:30", "21:30~22:30", "22:30~23:30"};
		
		JComboBox laundry_time = new JComboBox(laundry_time_arr);
		laundry_time.setBounds(400, 580, 250, 40);
		this.add(laundry_time);
		
		ImageIcon send_laundry = new ImageIcon("img//apply.png"); // ���۹�ư
		JLabel send_laundry_label = new JLabel(send_laundry);
		send_laundry_label.setBounds(690, 560, 130, 80);
		this.add(send_laundry_label);

		send_laundry_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���۹�ư ���� ��
			}
		});
		
		
		// ���
		ImageIcon backicon = new ImageIcon("img//write_laundry_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		

		// this.setResizable(false); // ���α׷��� �Ժη� ũ�� ������ �� �ֳ�?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // ����, ������ �� �� ����
		// �� �ְ� �ϴ°� ��Ǽ�
		this.pack();
		this.setSize(1080, 720);
		this.dispose();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class write_outUI extends JFrame { // �ܹ�����

	write_outUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		String out_kinds_arr[] = { "����ܹ�", "���ܹ�", "�ܷ�", "Ư��" };

		JComboBox out_kinds = new JComboBox(out_kinds_arr);
		out_kinds.setBounds(420, 290, 200, 75);
		this.add(out_kinds);

		JTextField tel = new JTextField(10);
		tel.setBounds(420, 405, 200, 40);
		this.add(tel);

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // ���۹�ư
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(660, 330, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���۹�ư ���� ��
			}
		});

		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
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

class write_airconUI extends JFrame { // ������ ��û

	write_airconUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel index = new JLabel("~ 14:00");
		index.setFont(new Font("�������", 30, 30)); // ��Ʈ ����
		index.setBounds(530, 300, 200, 70);
		this.add(index);

		ImageIcon send_aircon = new ImageIcon("img//apply.png"); // ���۹�ư
		JLabel send_aircon_label = new JLabel(send_aircon);
		send_aircon_label.setBounds(480, 480, 130, 80);
		this.add(send_aircon_label);

		send_aircon_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���۹�ư ���� ��
			}
		});

		ImageIcon backicon = new ImageIcon("img//aircon_back.jpg");
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

class write_soonoutUI extends JFrame { // ��������

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

		ImageIcon send_out = new ImageIcon("img//send_message.png"); // ���۹�ư
		JLabel send_out_label = new JLabel(send_out);
		send_out_label.setBounds(480, 450, 115, 70);
		this.add(send_out_label);

		send_out_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���۹�ư ���� ��
			}
		});

		ImageIcon backicon = new ImageIcon("img//soonout_back.jpg");
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

public class see_btn {
	public static void main(String[] args) {
		//
		//new write_laundryUI();
		//
	}

}
