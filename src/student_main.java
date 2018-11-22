
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
	

		// 닉네임
		
		JLabel nickname = new JLabel("신선영" + " 님");
		nickname.setFont(new Font("나눔고딕", 30, 30)); // 폰트 설정
		nickname.setBounds(890, 40, 170, 70);
		this.add(nickname);

		// 공지사항

		JLabel post1 = new JLabel("- 안녕하세요 저는 신선영입니다.");
		post1.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		post1.setBounds(50, 20, 400, 300);
		this.add(post1);

		JLabel post2 = new JLabel("- 공지사항은 여기서 바꾸삼");
		post2.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		post2.setBounds(50, 60, 400, 300);
		this.add(post2);

		JLabel post3 = new JLabel("- 배고푸당");
		post3.setFont(new Font("나눔고딕", 20, 20)); // 폰트 설정
		post3.setBounds(50, 100, 400, 300);
		this.add(post3);
		
		// 공지사항 더 보기

		ImageIcon more_post = new ImageIcon("img//more_post.png");
		JLabel more_postlable = new JLabel(more_post);
		more_postlable.setBounds(360, 250, 120, 60);
		this.add(more_postlable);
		
		more_postlable.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// 공지사항 전체 보기
		    }  
		}); 

		// 청소 구역

		JLabel todayclean = new JLabel("복도");
		todayclean.setFont(new Font("나눔고딕", 35, 35)); // 폰트 설정
		todayclean.setBounds(600, 200, 400, 300);
		this.add(todayclean);
		
		// 청소 구역 전체보기
		
		ImageIcon seeall = new ImageIcon("img//seeall.png");
		JLabel seealllable = new JLabel(seeall);
		seealllable.setBounds(695, 298, 60, 20);
		this.add(seealllable);
		
		seealllable.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// 청소 구역 전체 보기
		    }  
		}); 
		
		

		
		// 학사일정

		JLabel special_date = new JLabel("11월 17일");
		special_date.setFont(new Font("나눔고딕", 25, 25)); // 폰트 설정
		special_date.setBounds(580, 150, 150, 50);
		this.add(special_date);
		
		JLabel special_post = new JLabel("일정이 없습니다.");
		special_post.setFont(new Font("나눔고딕", 15, 15)); // 폰트 설정
		special_post.setBounds(580, 180, 150, 50);
		this.add(special_post);



		// 상 벌점

		String header[] = { "날짜", "내용", "점수" };

		String contents[][] = { { "2018.05.01", "여기에는", "+3" }, { "2018.09.17", "DB", "-4" }, { "2018.11.02", "내 생일", "-1" } };

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
		    	// 상 벌점 더 보기
		    }  
		}); 
		
		
		// 버튼 (쪽지, 쪽지함, 프로필, 세탁일지, 외박일지, 에어컨사용, 외출일지)
		
		
		ImageIcon send = new ImageIcon("img//send.png");
		JLabel sendlabel = new JLabel(send);
		sendlabel.setBounds(530, 30, 90, 90);
		this.add(sendlabel);
		
		sendlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	send_message_student message  = new send_message_student(); // 쪽지보내기
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
		    	// 정보수정
		    }  
		}); 
		
		ImageIcon laundryicon = new ImageIcon("img//laundryicon.png");
		JLabel laundrylabel = new JLabel(laundryicon);
		laundrylabel.setBounds(770, 415, 260, 90);
		this.add(laundrylabel);
		
		laundrylabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	write_laundryUI laundryUI = new write_laundryUI(); // 세탁일지
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
		    	// 에어컨 신청 클릭했을 때
		    }  
		}); 		
		

		ImageIcon soonouticon = new ImageIcon("img//soonouticon.png");
		JLabel soonoutlabel = new JLabel(soonouticon);
		soonoutlabel.setBounds(770, 515, 260, 90);
		this.add(soonoutlabel);
		
		
		soonoutlabel.addMouseListener(new MouseAdapter()  {  
		    public void mouseClicked(MouseEvent e)  {  
		    	// 외출일지 클릭했을 때
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
		this.setLocationRelativeTo(null); // 자동으로 가운데에서 출력하게
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}
}



public class student_main {
	public static void main(String[] args) {
		new UItest();
	}

}
