package day0819;

import java.util.Vector;

public class Room {
	//방타이틀,방인원수,방장, 접속된 클라이언트 정보
    String title;
    int count;
    String master;
    Vector<Server.Service> roomVC;
    
	public Room(String title, int count, String master) {
		this.title = title;
		this.count = count;
		this.master = master;
		roomVC = new Vector<Server.Service>();
	}

}
