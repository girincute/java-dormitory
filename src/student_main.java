
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

class UItest extends JFrame {
	
	UItest() {

		this.setTitle("Dormitory Management System");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	

		// �г���
		
		JLabel nickname = new JLabel("�ż���" + " ��");
		nickname.setFont(new Font("�������", 30, 30)); // ��Ʈ ����
		nickname.setBounds(890, 40, 170, 70);
		this.add(nickname);

		// ��������

		JLabel post1 = new JLabel("- �ȳ��ϼ��� ���� �ż����Դϴ�.");
		post1.setFont(new Font("�������", 20, 20)); // ��Ʈ ����
		post1.setBounds(50, 20, 400, 300);
		this.add(post1);

		JLabel post2 = new JLabel("- ���������� ���⼭ �ٲٻ�");
		post2.setFont(new Font("�������", 20, 20)); // ��Ʈ ����
		post2.setBounds(50, 60, 400, 300);
		this.add(post2);

		JLabel post3 = new JLabel("- ���Ǫ��");
		post3.setFont(new Font("�������", 20, 20)); // ��Ʈ ����
		post3.setBounds(50, 100, 400, 300);
		this.add(post3);
		
		// �������� �� ����

		ImageIcon more_post = new ImageIcon("img//more_post.png");
		JLabel more_postlable = new JLabel(more_post);
		more_postlable.setBounds(360, 250, 120, 60);
		this.add(more_postlable);
		
		more_postlable.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// �������� ��ü ����
		    }  
		}); 

		// û�� ����

		JLabel todayclean = new JLabel("����");
		todayclean.setFont(new Font("�������", 35, 35)); // ��Ʈ ����
		todayclean.setBounds(600, 200, 400, 300);
		this.add(todayclean);
		
		// û�� ���� ��ü����
		
		ImageIcon seeall = new ImageIcon("img//seeall.png");
		JLabel seealllable = new JLabel(seeall);
		seealllable.setBounds(695, 298, 60, 20);
		this.add(seealllable);
		
		seealllable.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// û�� ���� ��ü ����
		    }  
		}); 
		
		

		
		// �л�����

		JLabel special_date = new JLabel("11�� 17��");
		special_date.setFont(new Font("�������", 25, 25)); // ��Ʈ ����
		special_date.setBounds(580, 150, 150, 50);
		this.add(special_date);
		
		JLabel special_post = new JLabel("������ �����ϴ�.");
		special_post.setFont(new Font("�������", 15, 15)); // ��Ʈ ����
		special_post.setBounds(580, 180, 150, 50);
		this.add(special_post);



		// �� ����

		String header[] = { "��¥", "����", "����" };

		String contents[][] = { { "2018.05.01", "���⿡��", "+3" }, { "2018.09.17", "DB", "-4" }, { "2018.11.02", "�� ����", "-1" } };

		JTable table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(50, 480, 400, 75);
		this.add(scrollpane);
		
		ImageIcon more_table = new ImageIcon("img//more_table.png");
		JLabel more_tablelabel = new JLabel(more_table);
		more_tablelabel.setBounds(360, 560, 120, 60);
		this.add(more_tablelabel);
		
		more_tablelabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// �� ���� �� ����
		    }  
		}); 
		
		
		// ��ư (����, ������, ������, ��Ź����, �ܹ�����, ���������, ��������)
		
		
		ImageIcon send = new ImageIcon("img//send.png");
		JLabel sendlabel = new JLabel(send);
		sendlabel.setBounds(530, 30, 90, 90);
		this.add(sendlabel);
		
		sendlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	send_message_student message  = new send_message_student(); // ����������
		    }  
		}); 
		
		ImageIcon postbox = new ImageIcon("img//postbox.png");
		JLabel postboxlabel = new JLabel(postbox);
		postboxlabel.setBounds(655, 30, 90, 90);
		this.add(postboxlabel);
		
		postboxlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	message_room_student message_room_student = new message_room_student();
		    }  
		}); 


		ImageIcon profile = new ImageIcon("img//profile.png");
		JLabel profilelabel = new JLabel(profile);
		profilelabel.setBounds(785, 30, 90, 90);
		this.add(profilelabel);
		
		profilelabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// ��������
		    }  
		}); 
		
		ImageIcon laundryicon = new ImageIcon("img//laundryicon.png");
		JLabel laundrylabel = new JLabel(laundryicon);
		laundrylabel.setBounds(770, 415, 260, 90);
		this.add(laundrylabel);
		
		laundrylabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	write_laundryUI laundryUI = new write_laundryUI(); // ��Ź����
		    }  
		}); 

		ImageIcon outicon = new ImageIcon("img//outicon.png");
		JLabel outlabel = new JLabel(outicon);
		outlabel.setBounds(510, 415, 260, 90);
		this.add(outlabel);
		
		outlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	write_outUI outUI = new write_outUI();
		    }  
		}); 

		ImageIcon airconicon = new ImageIcon("img//airconicon.png");
		JLabel airconlabel = new JLabel(airconicon);
		airconlabel.setBounds(510, 512, 260, 90);
		this.add(airconlabel);
		
		airconlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// ������ ��û Ŭ������ ��
		    }  
		}); 		
		

		ImageIcon soonouticon = new ImageIcon("img//soonouticon.png");
		JLabel soonoutlabel = new JLabel(soonouticon);
		soonoutlabel.setBounds(770, 515, 260, 90);
		this.add(soonoutlabel);
		
		
		soonoutlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// �������� Ŭ������ ��
		    }  
		}); 	
		

		ImageIcon backicon = new ImageIcon("img//back.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

	
		this.pack();
		this.setSize(1080, 720);
		this.dispose();
		this.setVisible(true);
		this.setLocationRelativeTo(null); // �ڵ����� ������� ����ϰ�
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}



public class student_main {
	public static void main(String[] args) {
		new UItest();
	}

}
