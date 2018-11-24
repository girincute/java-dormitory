// ����Ʈ�鿡 ���õ� (�������� ������, ����� ������, û�ұ��� ��ü���� ) UI


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class noticeUI extends JFrame { // ��������
	
	noticeUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("���������� ���⿡ ���ּ���!!");
		index.setFont(new Font("�������", 20, 20)); // ��Ʈ ����
		index.setBounds(170, 200, 400, 70);
		this.add(index);
		
		ImageIcon notice_back = new ImageIcon("img//notice_back.jpg");
		JLabel notice_back_label = new JLabel(notice_back);
		notice_back_label.setBounds(0, 0, 1080, 720);
		this.add(notice_back_label);
		

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class plus_and_minusUI extends JFrame { // ����� ������
	
	plus_and_minusUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		String header[] = { "��¥", "����", "����" };

		String contents[][] = { { "2018.05.01", "���⿡��", "+3" }, { "2018.09.17", "DB", "-4" },
				{ "2018.11.02", "�� ����", "-1" }, { "2018.11.07", "������Ű �԰�ʹ�", "+0.5" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(170, 200, 700, 400);
		this.add(scrollpane);
		
		
		ImageIcon plusandminus = new ImageIcon("img//plusandminus.jpg");
		JLabel plusandminus_label = new JLabel(plusandminus);
		plusandminus_label.setBounds(0, 0, 1080, 720);
		this.add(plusandminus_label);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class cleanclassUI extends JFrame { // û�ұ��� ��ü����
	
	cleanclassUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel clean_face_room = new JLabel("501");
		clean_face_room.setFont(new Font("�������", 35, 35)); // �����
		clean_face_room.setBounds(300, 200, 400, 70);
		this.add(clean_face_room);
		
		
		JLabel shower_room = new JLabel("502");
		shower_room.setFont(new Font("�������", 35, 35)); // ������
		shower_room.setBounds(300, 300, 400, 70);
		this.add(shower_room);
		
		
		JLabel laundry_room = new JLabel("503");
		laundry_room.setFont(new Font("�������", 35, 35)); // ��Ź��
		laundry_room.setBounds(300, 410, 400, 70);
		this.add(laundry_room);
		
		JLabel bath_room = new JLabel("504");
		bath_room.setFont(new Font("�������", 35, 35)); // ȭ���
		bath_room.setBounds(300, 510, 400, 70);
		this.add(bath_room);

		
		JLabel hall_room = new JLabel("505");
		hall_room.setFont(new Font("�������", 35, 35)); // ����
		hall_room.setBounds(730, 230, 400, 70);
		this.add(hall_room);
		
		
		JLabel stair_room = new JLabel("506");
		stair_room.setFont(new Font("�������", 35, 35)); // ���
		stair_room.setBounds(730, 340, 400, 70);
		this.add(stair_room);
		
		
		JLabel rest_room = new JLabel("507");
		rest_room.setFont(new Font("�������", 35, 35)); // �ްԽ�
		rest_room.setBounds(730, 445, 400, 70);
		this.add(rest_room);
		
		/////
		
		
		ImageIcon backicon = new ImageIcon("img//cleanroom_back.jpg");
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

class student_listUI extends JFrame { // �л� ����Ʈ ��ü����
	
	student_listUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		String room[] = {"401", "402", "403", "404", "405", "406", "407", "408", "409", "410", "411", "412", "413", "414", "415", "416", "417"};
		
		JComboBox room_arr = new JComboBox(room);
		room_arr.setBounds(380, 35, 100, 40);
		this.add(room_arr);
		
		ImageIcon searchbtn_small = new ImageIcon("img//searchbtn_small.png"); // �˻�
		JLabel searchbtn_small_label = new JLabel(searchbtn_small);
		searchbtn_small_label.setBounds(480, 15, 130, 80);
		this.add(searchbtn_small_label);
		
		searchbtn_small_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// �˻���ư ������ ��
			}
		});
		
		ImageIcon add = new ImageIcon("img//add.png"); // �߰�
		JLabel add_label = new JLabel(add);
		add_label.setBounds(830, 30, 80, 55);
		this.add(add_label);
		
		add_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String add_room = null;
				add_room = JOptionPane.showInputDialog("�߰��� ���ϴ� ȣ���� �Է����ּ���");
				// ȣ�ǿ� ����� �� �������� �߰� �Ұ��� (�����ʿ��ϸ� �ϱ�)
				
				String add_name = null;
				add_name = JOptionPane.showInputDialog("�߰��� ���ϴ� �л��� �̸��� �Է����ּ���");
				
				
				String add_id = null;
				add_id = JOptionPane.showInputDialog("�߰��� ���ϴ� �л��� id�� �Է����ּ���");

			}
		});
		
		ImageIcon del = new ImageIcon("img//del.png"); // ����
		JLabel del_label = new JLabel(del);
		del_label.setBounds(920, 30, 80, 55);
		this.add(del_label);
		
		del_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String del_room = null;
				del_room = JOptionPane.showInputDialog("������ ���ϴ� �л��� ȣ���� �Է����ּ���");
				
				String del_name = null;
				del_name = JOptionPane.showInputDialog("������ ���ϴ� �л��� �̸��� �Է����ּ���");

			}
		});



		
		JLabel student_num = new JLabel("�ż���" + "               " + "1234" );
		student_num.setFont(new Font("�������", 30, 30)); // ��Ʈ ����
		student_num.setBounds(240, 230, 1000, 70);
		this.add(student_num);
		
		ImageIcon backicon = new ImageIcon("img//allstudent_list_back.jpg");
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



public class see_post {
	public static void main(String[] args) {
		new student_listUI();
	}

}


