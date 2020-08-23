package day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server implements Runnable{
	/*
	    <우리들의 약속>  Server - Client
	    
	    100: 대기실 입장(최초접속)
	    140: 중복된 대화명 발견
	    200: 메시지 입력(TextField)
	    250: 대화명 변경
	    
	    300: 방만들기	    
	    350: 방들어가기 (방입장)
	    355: 방제목
	    356: 대기실 인원 정보
	    360: 방나가기
	    
	    400: 방인원 리스트 정보
	        
	    900: 대기실 퇴장(프로그램 종료)
	    
	    
	    10:TextArea Msg(대화방 TextArea)
	    20:List Msg(대화방 대화명리스트)
	*/
	
	
	//Vector<Service> vc;//접속된 클라이언트 관리(입출력 객체)
	
	//전체사용자(대기실,방) 관리
	Vector<Service> globalvc;
	
	//대기실사용자 관리
	Vector<Service> waitvc;
	
	//방관리
	Vector<Room> roomvc;
	
	public Server() {
		globalvc = new Vector<Service>();
		waitvc = new Vector<Service>();
		roomvc = new Vector<Room>();
		
		new Thread(this).start();
	}
	
    public void run(){
    	//서버소켓객체 생성
    	
    	try {
			ServerSocket ss = new  ServerSocket(6000);//현 시스템의 ip주소에 6000포트로 Socket서비스 
			
			Socket s;
			
			System.out.print("Server Start....");
			while(true){
				s = ss.accept();//클라이언트 접속 대기
				new Service(s);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}    	
    }//run
    
    class Service extends Thread{//내부클래스( 메시지 입출력서비스 )
    	BufferedReader in;//from Client
    	OutputStream out;//to Client
    	Socket s;
    	String nickName;
    	Room myRoom;
    	
    	public Service(Socket s) {
    		try {
				in = new BufferedReader(new InputStreamReader(s.getInputStream()));//입력객체
				out = s.getOutputStream();//출력객체
				this.s = s;
				
				//nickName = in.readLine();
				
				start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//Service생성자
    	
    	public void run(){    		  
    		while(true){
    			  try {    				  
					String msg = in.readLine();//클라이언트가 보낸 메시지
					if(msg==null) return;
					
					System.out.println("MSG="+ msg+ "["+  s.getInetAddress().getHostAddress() +"]");					
					
					String data[] = msg.split("\\|");
					int num = Integer.parseInt(data[0]);
					switch( num ){
					   case 100: //대기실 입장
						      nickName=data[1]; 
						      
						      boolean duplicate=false;
						      
						      //중복된 대화명 검사
						      for(int i=0; i<globalvc.size(); i++){
						    	  Service ser = globalvc.get(i);						    	  
						    	  if(ser.nickName.equals(nickName)){
						    		//입력된 대화명과 같은 대화명이 존재한다면
						    		  duplicate=true;
						    	  }
						      }						      
						      
						      if(!duplicate){
							      globalvc.add(this);//전체사용자에 현재접속 Service 등록
							      waitvc.add(this);//대기실에 Service등록							             
							            					             
							      messageAll(getRoomInfo());//대기실에 방정보 보내기
								  messageAll(getWaitNickList());//대기실에 인원정보 보내기
						      }else{
						    	  messageTo("140|");
						      }
						      
					          break;
					                 
					   case 200: //클라이언트가 TextField를 통해 메시지를 전달했다면
						      messageRoom("10|"+nickName+"▶ "+data[1]); 
					          break;
					                 
					   case 250: //클라이언트에서 대화명변경을 요청했다면
					          messageRoom("10|   ## ["+nickName+"]님 ---> ["
					                                             +data[1]+"]님 대화명 변경!! ##");
					          nickName= data[1];
					          messageRoom(getNickNames());//변경된 대화명을 대화방 리스트에 반영
					       
						         break;
					   case 300://방만들기 요청
						      //new Room(title, count, master);
						      myRoom = new Room(data[1], 1, nickName);						      
						      
						      waitvc.remove(this);	//대기실 Service 삭제					      
						      //방에 Service(Socket(in,out), nickName, myRoom) 추가
						      myRoom.roomVC.add(this);//생성된 방객체에 내 Service추가						      
						      roomvc.add(myRoom);//서버에 생성된 방추가						      
						      messageRoom("10|   *** ["+ nickName +"]님 입장 ***");
						      messageRoom(getNickNames());//대화명을 대화방 리스트에 반영
						      
						      //300|자바방--1,오라클방--2,JSP방--3
						      messageAll(getRoomInfo());//대기실에 방정보 보내기
						      messageAll(getWaitNickList());//대기실에 인원정보 보내기
						      
						      break;
						      
					   
					   case 350: //방들어가기 요청이 들어왔다면
						      int idx = Integer.parseInt(data[1]);
						      Room room = roomvc.get(idx);//선택된 Room의 정보를 얻어오기
						      myRoom =  room ; //개설된 방의 레퍼런스 얻어오기
						      myRoom.count++;//방인원 증가
						      
                              waitvc.remove(this);//대기실에서 내 Service삭제
						      myRoom.roomVC.add(this);//개설된 방에 내 Service(클라이언트) 등록
						      messageRoom("10|   *** ["+ nickName +"]님 입장 ***");
						      messageRoom(getNickNames());//대화명을 대화방 리스트에 반영
						      
						      messageAll(getRoomInfo());//대기실에 방정보 보내기
						      messageAll(getWaitNickList());//대기실에 인원정보 보내기
						      
						      break;
						      
					   case 355: //방제목 요청
						      messageTo("355|"+myRoom.title);
						      break;						      
					        
					   case 360: //방나가기 요청이 있을때 (대화방의 나가기버튼, X버튼)
						      myRoom.count--;//방인원 감소
						      
						      messageRoom("10|   *** ["+ nickName +"]님 퇴장 ***");
						      myRoom.roomVC.remove(this);//개설된 방에 내 Service(클라이언트) 삭제
						      waitvc.add(this);//대기실에서 내 Service등록
						      messageRoom(getNickNames());//대화명을 대화방 리스트에 삭제 반영
						      
						      messageAll(getRoomInfo());//대기실에 방정보 보내기
						      messageAll(getWaitNickList());//대기실에 인원정보 보내기
						      
						      break;
					
					   case 400: //선택된 방인원 리스트 정보 요청이 있을때	
						      String inwonList = getRoomNickList(Integer.parseInt(data[1]));
						      messageTo(inwonList);
					          break;
					          
					   case 900: 
						       globalvc.remove(this);
						       waitvc.remove(this);
						       
					}//switch
				} catch (IOException e) {
					//messageAll("   *** ["+ nickName +"]님 퇴장 ***");
					return;
				}
    		}
    	}//run
    	
    	
    	//내방의 클라이언트들의 대화명 얻어오기
    	public String getNickNames(){
    		String str="20|";
    		for(int i=0; i< myRoom.roomVC.size(); i++){
    			str += myRoom.roomVC.get(i).nickName;   //vc.get(i)  == Service
    			if(i<myRoom.roomVC.size()-1)str +=",";
    		}
    	  return str;
    	}//getNickNames
    	
    	//전체 관리 방에서 특정방 내의 대화명 정보 얻어오기
    	public String getRoomNickList(int idx){
    		String str="400|";
    		Room selectedRoom = roomvc.get(idx);
    		for(int i=0; i<selectedRoom.roomVC.size(); i++){
    			str+=selectedRoom.roomVC.get(i).nickName;
    			if(i<selectedRoom.roomVC.size()-1)str+=",";
    		}
    		return str;
    	}//getNickList
    	
    	public String getWaitNickList(){
    		String str="356|";
    		for(int i=0; i<waitvc.size(); i++){
    		    Service ser = waitvc.get(i);
    		    str += ser.nickName;   
    			if(i<waitvc.size()-1)str +=",";
    		}
    		return str;
    	}//getWaitNickList
    	
    	
    	//개설된 방의 정보 얻어오기
    	public String getRoomInfo(){
    		//300|자바방--1,오라클방--2,JSP방--3
    		String str="300|";
    		for(int i=0; i<roomvc.size(); i++){
    			Room r = roomvc.get(i);
    			str += r.title +"--" + r.count;
    			if(i<roomvc.size()-1)str += ",";
    		}
    		return str;
    	}//getRoomInfo
    	
    	
    	public void messageTo(String msg)throws IOException{//특정 Client에게 메시지 전송
    		
    		out.write( (msg+"\n").getBytes());
    		
    	}//messageTo
    	
    	public void messageAll(String msg){//접속된 모든 Client에게 메시지 전송
    		System.out.println("globalvc.size: "+ globalvc.size());
          for(int i=0; i<globalvc.size(); i++){	
        	  Service ser = globalvc.get(i);
    		  try {
				ser.messageTo(msg);
			} catch (IOException e) {
				System.err.println("클라이언트 접속 종료");
				globalvc.remove(i--);
			}
          }
    	}//messageAll
    	
    	public void messageRoom(String msg){//같은 방에 있는 Client들에게 메시지 전송
    		for(int i=0; i<myRoom.roomVC.size(); i++){	
    			Service ser = myRoom.roomVC.get(i);
    			try {
    				ser.messageTo(msg);
    			} catch (IOException e) {
    				System.err.println("클라이언트 접속 종료");
    				myRoom.roomVC.remove(i--);
    			}
    		}
    	}//messageAll
    	
    	
    }//Inner Class Service.
	
    public static void main(String[] args) {
		 new Server();
	}
}

