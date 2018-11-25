// 쪽지와 관련된(쪽지함, 쪽지보내기) UI

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;


class message_room_student extends JFrame { // 학생 쪽지함
	ArrayList<String[]> message_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "보낸 날짜", "보낸 사람", "받은 사람", "내용", "읽음 여부"};
	String read[] = {"안 읽음", "읽음"};
	
	public static Connection conn = null;
	
	public void getmessageList() throws ClassNotFoundException, SQLException { // 쪽지함 확인
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");

		message_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE message SET read = 1 where toname='" + loginUI.name +"'");
		int res = ps.executeUpdate();
		
		rs = s.executeQuery("SELECT * FROM message where toname='" + loginUI.name + "' order by date desc");
		
		while(rs.next()) {
			message_list.add(new String[]{rs.getString("date"), rs.getString("mename"), rs.getString("toname"), rs.getString("message"), rs.getString("read")});
		}
        int i = 0;

        if (message_list.size() != 0) {
            for (String[] message : message_list) {
            	contents[i][0] = message[0]; // 보낸 날짜
            	contents[i][1] = message[1]; // 보낸 사람
            	contents[i][2] = message[2]; // 받은 사람
            	contents[i][3] = message[3]; // 내용
            	contents[i][4] = read[Integer.parseInt(message[4])]; // 읽었어?
                i++;
            }
        }
		
        ps.close();
		s.close();
		rs.close();
		
		conn.close();
	}
	message_room_student() throws ClassNotFoundException, SQLException {
		getmessageList();
		this.setTitle("Dormitory Management System student_message_room");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 170, 770, 410);
		this.add(scrollpane);
		
		ImageIcon backicon = new ImageIcon("img//messageroom_student.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}


class message_room_teacher extends JFrame { // 사감쌤 쪽지함
	ArrayList<String[]> message_list = new ArrayList<String[]>();
	String[][] contents = new String[100][100];
	JTable table = new JTable();
	String header[] = { "보낸 날짜", "보낸 사람", "받은 사람", "내용", "읽음 여부"};
	String read[] = {"안 읽음", "읽음"};
	
	public static Connection conn = null;
	
	public void getmessageList() throws ClassNotFoundException, SQLException { // 사감쌤 쪽지
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:" + "dormitory.db");

		message_list.clear();
		
		Statement s = conn.createStatement();
		ResultSet rs;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE message SET read = 1 where toname='사감선생님'");
		int res = ps.executeUpdate();
		
		rs = s.executeQuery("SELECT * FROM message where toname='사감선생님' or mename='사감선생님' order by date desc");
		
		while(rs.next()) {
			message_list.add(new String[]{rs.getString("date"), rs.getString("mename"), rs.getString("toname"), rs.getString("message"), rs.getString("read")});
		}
        int i = 0;

        if (message_list.size() != 0) {
            for (String[] message : message_list) {
            	contents[i][0] = message[0]; // 보낸 날짜
            	contents[i][1] = message[1]; // 보낸 사람
            	contents[i][2] = message[2]; // 받은 사람
            	contents[i][3] = message[3]; // 내용
            	contents[i][4] = read[Integer.parseInt(message[4])]; // 읽었어?
                i++;
            }
        }
		
		s.close();
		ps.close();
		rs.close();
		
		conn.close();
	}
	message_room_teacher() throws ClassNotFoundException, SQLException {
		getmessageList();
		
		this.setTitle("Dormitory Management System teacher_message_room");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		
		table = new JTable(contents, header);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(150, 170, 770, 410);
		this.add(scrollpane);

		ImageIcon backicon = new ImageIcon("img//messageroom_teacher.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class send_message_student extends JFrame { // 학생 -> 사감
	public static String checktext(String text) {
		String[] bad = {"씨발", "존나", "병신", "새끼", "미친"};
		
		for(int i=0; i<bad.length; i++) {
			text = text.replaceAll(bad[i], "**");
			System.out.println(text);
		}
		
		return text;
	}
	
	send_message_student() {
		this.setTitle("Dormitory Management System send_message");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel send_teacher = new JLabel("사감 선생님");
		send_teacher.setFont(new Font("나눔고딕", 30, 30));
		send_teacher.setBounds(370, 185, 170, 70);
		this.add(send_teacher);
		
		JTextField post = new JTextField();
		post.setBounds(170, 270, 600, 300);
		this.add(post);
		
		ImageIcon send_message = new ImageIcon("img//send_message.png");
		JLabel send_messagelabel = new JLabel(send_message);
		send_messagelabel.setBounds(820, 520, 120, 70);
		this.add(send_messagelabel);
		
		send_messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = checktext(post.getText());
				String a[] = {loginUI.name, "사감선생님", text}; // 학생 id, 사감선생님 id, 내용
				try {
					sendMessage.main(a);
					JOptionPane.showMessageDialog(null, "쪽지를 전송하였습니다!");
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		ImageIcon backicon = new ImageIcon("img//send_message.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);
		
		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}

class send_message_teacher extends JFrame { // 사감 -> 학생
	
	send_message_teacher() {
		this.setTitle("Dormitory Management System send_message");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);

		JLabel search = new JLabel(UImain.sname);
		search.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		search.setBounds(370, 200, 170, 40);
		this.add(search);

		
		JTextField post = new JTextField();
		post.setBounds(170, 270, 600, 300);
		this.add(post);
		
		ImageIcon send_message = new ImageIcon("img//send_message.png");
		JLabel send_messagelabel = new JLabel(send_message);
		send_messagelabel.setBounds(820, 520, 120, 70);
		this.add(send_messagelabel);

		send_messagelabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String text = send_message_student.checktext(post.getText());
				String a[] = {"사감선생님", UImain.sname, text}; // 선생님 id, 학생 id, 내용
				System.out.println(UImain.sname);
				try {
					sendMessage.main(a);
					JOptionPane.showMessageDialog(null, "쪽지를 전송하였습니다!");
					dispose();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		ImageIcon backicon = new ImageIcon("img//send_message.jpg");
		JLabel backlabel = new JLabel(backicon);
		backlabel.setBounds(0, 0, 1080, 720);
		this.add(backlabel);

		this.pack();
		this.setSize(1080, 720);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

public class message {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new message_room_student();
	}

}
