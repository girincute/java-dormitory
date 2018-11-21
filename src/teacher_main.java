
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class UImain extends JFrame {
	UImain() {

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel la = new JLabel();
		this.add(la);

		// �л� �˻� �ؽ�Ʈ / ��ư
		JTextField search = new JTextField("�̸�");
		search.setBounds(120, 32, 170, 40);
		this.add(search);

		ImageIcon searchbtn = new ImageIcon("img//searchbtn.png");
		JLabel searchlabel = new JLabel(searchbtn);
		searchlabel.setBounds(315, 12, 140, 85);
		this.add(searchlabel);

		// �г���

		JLabel nickname = new JLabel("��簨" + " ��");
		nickname.setFont(new Font("�������", 30, 30)); // ��Ʈ ����
		nickname.setBounds(865, 70, 170, 70);
		this.add(nickname);

		// �̸� ( ���� )

		JLabel room_num = new JLabel("503-3");
		JLabel name = new JLabel("�ż���");

		room_num.setFont(new Font("�������", 50, 50)); // ��Ʈ ����
		name.setFont(new Font("�������", 50, 50)); // ��Ʈ ����

		room_num.setForeground(Color.BLUE);

		room_num.setBounds(50, 130, 150, 50);
		name.setBounds(200, 130, 150, 50);

		this.add(name);
		this.add(room_num);
		
		
		// ��ư (����, ���� �� ����)
		
		ImageIcon modifi_clean = new ImageIcon("img//modifi.png");
		JLabel modifi_clean_label = new JLabel(modifi_clean);
		modifi_clean_label.setBounds(640, 570, 85, 45);
		this.add(modifi_clean_label);

		modifi_clean_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ����(û�ұ���)
			}
		});
		
		ImageIcon modifiandremove = new ImageIcon("img//modifiandremove.png");
		JLabel modifiandremovelabel = new JLabel(modifiandremove);
		modifiandremovelabel.setBounds(233, 575, 140, 40);
		this.add(modifiandremovelabel);

		modifiandremovelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ���� �� ����(����� ��Ȳ)
			}
		});

		
		
		

		// ��ư (�޼���, ������, ��Ź����, �ܹ�����, ���������, ��������)

		ImageIcon message = new ImageIcon("img//profile.png");
		JLabel messagelabel = new JLabel(message);
		messagelabel.setBounds(360, 110, 90, 90);
		this.add(messagelabel);

		messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				send_message_teacher send_message_teacher = new send_message_teacher(); // ����������
			}
		});
		
		ImageIcon postbox = new ImageIcon("img//postbox.png");
		JLabel postboxlabel = new JLabel(postbox);
		postboxlabel.setBounds(755, 60, 90, 90);
		this.add(postboxlabel);

		postboxlabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				message_room_teacher message_room_teacherUI = new message_room_teacher(); // ������
			}
		});
		

		

		ImageIcon laundryicon_teacher = new ImageIcon("img//laundryicon_teacher.png");
		JLabel laundrylabel_teacher = new JLabel(laundryicon_teacher);
		laundrylabel_teacher.setBounds(750, 185, 260, 90);
		this.add(laundrylabel_teacher);

		laundrylabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ��Ź���� Ŭ������ ��
			}
		});

		ImageIcon outicon_teacher = new ImageIcon("img//outicon_teacher.png");
		JLabel outlabel_teacher = new JLabel(outicon_teacher);
		outlabel_teacher.setBounds(750, 275, 260, 90);
		this.add(outlabel_teacher);

		outlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �ܹ����� Ŭ������ ��
			}
		});

		ImageIcon airconicon_teacher = new ImageIcon("img//airconicon_teacher.png");
		JLabel airconlabel_teacher = new JLabel(airconicon_teacher);
		airconlabel_teacher.setBounds(750, 365, 260, 90);
		this.add(airconlabel_teacher);

		airconlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// ������ ��û Ŭ������ ��
			}
		});

		ImageIcon soonouticon_teacher = new ImageIcon("img//soonouticon_teacher.png");
		JLabel soonoutlabel_teacher = new JLabel(soonouticon_teacher);
		soonoutlabel_teacher.setBounds(750, 455, 260, 90);
		this.add(soonoutlabel_teacher);

		soonoutlabel_teacher.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �������� Ŭ������ ��
			}
		});
		
		
		
		ImageIcon notice = new ImageIcon("img//notice.png");
		JLabel noticelabel = new JLabel(notice);
		noticelabel.setBounds(750, 545, 260, 90);
		this.add(noticelabel);

		noticelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �������
			}
		});
		

		ImageIcon backicon = new ImageIcon("img//teacher_back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		// this.setResizable(false); // ���α׷��� �Ժη� ũ�� ������ �� �ֳ�?
		// this.setPreferredSize(new Dimension(1080, 1080 / 12 * 9)); // ����, ������ �� �� ����
		// �� �ְ� �ϴ°� ��Ǽ�
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}

public class teacher_main {
	public static void main(String[] args) {
		new UImain();
	}

}
