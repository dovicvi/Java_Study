package day0819;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainChat extends JFrame implements ActionListener, Runnable{
	
	JList<String> roomInfo, roomInwon, waitUser;//방정보, 인원정보,대기실정보
	JScrollPane sp_roomInfo, sp_roomInwon, sp_waitUser;
	JButton bt_create, bt_enter, bt_exit;
	JPanel p;
	
	ChatClient client;//대화방
	
	Socket s;
    BufferedReader in;
    OutputStream out;
    
    int idx=-1;
	
	public MainChat() {
	   setTitle("대기실");
	   
	   client = new ChatClient();
	   
	   roomInfo = new JList<String>();	
	     roomInfo.setBorder(new TitledBorder("방정보"));
	   roomInwon = new JList<String>();	
	     roomInwon.setBorder(new TitledBorder("인원정보"));	   
	   
	   waitUser = new JList<String>();	
	     waitUser.setBorder(new TitledBorder("대기실정보"));
	     
	   sp_roomInfo = new JScrollPane(roomInfo);
	   sp_roomInwon = new JScrollPane(roomInwon);
	   sp_waitUser = new JScrollPane(waitUser);
	   
	   bt_create = new JButton("방만들기");
	   bt_enter = new JButton("방들어가기");
	   bt_exit = new JButton("나가기");
	   
	   p = new JPanel();
	   p.setBackground(Color.cyan);	   
	   
	   sp_roomInfo.setBounds(10,10,260,250);
	   sp_roomInwon.setBounds(280,10,140,250);
	   sp_waitUser.setBounds(10,270,260,130);
	   
	   bt_create.setBounds(280, 280, 140, 30);
	   bt_enter.setBounds(280, 320, 140, 30);
	   bt_exit.setBounds(280, 360, 140, 30);
	   
	   p.setLayout(null);
	   p.add(sp_roomInfo);
	   p.add(sp_roomInwon);
	   p.add(sp_waitUser);
	   
	   p.add(bt_create);	   
	   p.add(bt_enter);	   
	   p.add(bt_exit);	   
	   
	   add(p);
       
	   setBounds(300,200,450,450);
	   setVisible(true);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   
	    connProcess();
		new Thread(this).start();
		eventUp();
	}//생성자
	
	private void eventUp(){
		
		//--------- 대기실 -----------//
		bt_create.addActionListener(this);
		bt_enter.addActionListener(this);
		bt_exit.addActionListener(this);
		
		roomInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//int idx = roomInfo.getSelectedIndex();
				idx = roomInfo.getSelectedIndex();
				toServerMsg("400|"+idx);
			}
		});
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				toServerMsg("900|");
				System.exit(0);
			}
		});
		
		//--------- 대화방 -----------//
		client.send_tf.addActionListener(this);
		client.bt_change.addActionListener(this);
		client.bt_exit.addActionListener(this);
		
		client.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//대화방 ---> 대기실 이동
				toServerMsg("360|");
				client.setVisible(false);
				setVisible(true);
			}
		});
		
	}//eventUp
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==client.send_tf){//메시지를 입력했을때
		   sendProcess();
		}else if(ob==client.bt_change){//대화명 변경 버튼을 클릭시
		   String newName = JOptionPane.showInputDialog(client,"변경할 대화명:");
		   client.send_tf.requestFocus();		   
		   toServerMsg("250|"+newName);//서버에게 변경된 대화명을 전달			
			
		}else if(ob==bt_create){//방만들기 버튼 클릭
		   client.ta.setText(""); //방내용초기화	
			
           String roomTitle = JOptionPane.showInputDialog(this,"방제목: ");
           toServerMsg("300|"+roomTitle);
           
           //대기실 ---> 만든 방으로 입장!!
           roomTitleChange(roomTitle);
           setVisible(false);
           client.setVisible(true);
		}else if(ob==bt_enter){//방들어가기 버튼 클릭
			client.ta.setText(""); //방내용초기화
			
			//int idx = roomInfo.getSelectedIndex();
			if(idx==-1){
				JOptionPane.showMessageDialog(this, "입장할 방을 선택!!");
				return;
			}
			toServerMsg("350|"+idx);//서버에게 방에 입장했다는 것을 알림
			toServerMsg("355|");//대화방의 타이틀제목 요청
			
			//대기실 ---> 대화방 이동
			setVisible(false);
			client.setVisible(true);
			
		}else if(ob==client.bt_exit){//방 나가기 버튼 클릭
			//대화방 ---> 대기실 이동
			toServerMsg("360|");
			client.setVisible(false);
			setVisible(true);
		}
		
		 else if(ob==bt_exit){//대기실 나가기 버튼 클릭(종료)
		   toServerMsg("900|");
		   System.exit(0);
		}
		
	}//actionPerformed
	
	private void connProcess(){//서버 연결 관련 객체생성
		try {
			s = new Socket("localhost", 6000 );//서버연결
			
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));//입력객체
			out = s.getOutputStream();//서버에게 보낼 출력객체
				
			inputNickName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//connProcess
	
	private void inputNickName(){
		String nickName;
		
		while(true){
			nickName = JOptionPane.showInputDialog(this,"대화명: ");
//			if(nickName==null){
//				nickName="guest";
//				break;
//			}
		    if(nickName==null || nickName.trim().length() == 0){
				JOptionPane.showMessageDialog(this, "대화명을 입력하세요!!");
			}else{
				break;
			}				
		}//while
		
		toServerMsg ("100|"+nickName); 
	}//inputNickName
	
	private void sendProcess(){//서버에게 메시지 보내기
		
			String msg = client.send_tf.getText();		
			if(msg.length()==0)return;
			toServerMsg("200|"+msg);
			client.send_tf.setText("");			
		
	}//sendProcess
	
	@Override
	public void run() {//서버가 보내온 메시지 ------> TextArea에 출려
		
		while(true){
			try {
				String msg = in.readLine();
				if(msg==null)return;
				
				StringTokenizer st = new StringTokenizer(msg,"|");
				int num = Integer.parseInt(st.nextToken());
				
				switch(num){
				   case 10:
					   //ta.append(msg+"\n");
					   client.ta.append(st.nextToken()+"\n");//  10|안녕
					   client.ta.setCaretPosition(client.ta.getText().length());
					   break;
				   case 20: // "길동,라임,주원" st.nextToken()
					   String listData[]=st.nextToken().split(",");
					   client.list.setListData(listData);
					   break;
					   
				   case 140://서버로 부터 중복된 대화명 연락이 왔다면
					   JOptionPane.showMessageDialog(this, "이미존재하는 대화명입니다!!");
					   inputNickName();
					   break;
					   
				   case 300: //방을 만들었을때 
					   //"자바방--1,오라클방--2,JSP방--3"
					   if(st.hasMoreTokens()){//개설된 방이 1개 이상 존재했을때
						   String roomInfoList[]= st.nextToken().split(",");
						   roomInfo.setListData(roomInfoList);
					    }
					   break;
				     
				   case 350: //방들어가기에 대한 갱신
					   String roomInfoList[]= st.nextToken().split(",");
					   roomInfo.setListData(roomInfoList);
					   break;
					   
				   case 355:
					   roomTitleChange(st.nextToken());
					   break;
					   
				   case 356: //대기실에 waitInfo출력							   
					   if(st.hasMoreTokens()){//대기인원이 1명 이상 존재했을때
					   String waitNickName[]=st.nextToken().split(",");
					   waitUser.setListData(waitNickName);
					   }
					   break;					   
					   
				   case 400: 
					   if(st.hasMoreTokens()){
					   String roomInwonList[]= st.nextToken().split(",");
					   roomInwon.setListData(roomInwonList);
				      }
				}
				
			} catch (IOException e) {
				return;
			}
		}
		
	}//run
	
	
	public void toServerMsg(String msg){//서버에게 메시지 보내기
		try {
			out.write( (msg+"\n").getBytes() );
		} catch (IOException e) {
			System.out.println("서버와 접속끊김!!");
		}
	}//toServer
	
	public void roomTitleChange(String title){
		client.setTitle("대화방-["+title+"]");
	}
	
	
	

	public static void main(String[] args) {
	   new MainChat();
	}

}



