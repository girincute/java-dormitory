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
			// ��Ź�� ��ư
		
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

		
		String out_kinds_arr[] = { "����ܹ�", "���ܹ�", "�ܷ�", "Ư��"};
		
		JComboBox out_kinds = new JComboBox(out_kinds_arr);
		out_kinds.setBounds(50,480,400,75);
		this.add(out_kinds);

	
		
		ImageIcon backicon = new ImageIcon("img//write_out_back.jpg");
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
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class write_airconUI extends JFrame {
	
	write_airconUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("��������û");
		index.setFont(new Font("�������", 50, 50)); // ��Ʈ ����
		index.setBounds(170, 200, 400, 70);
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


class write_soonoutUI extends JFrame { // ��������
	
	write_soonoutUI() {

		this.setTitle("Dormitory Management System_write_laundry");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		
		JLabel index = new JLabel("��������");
		index.setFont(new Font("�������", 50, 50)); // ��Ʈ ����
		index.setBounds(170, 200, 400, 70);
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




public class see_btn {
	public static void main(String[] args) {
//
//		new write_outUI();
//		
	}

}
