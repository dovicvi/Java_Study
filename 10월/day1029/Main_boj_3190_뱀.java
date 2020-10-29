import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main_boj_3190_뱀 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N,K,L;
		int time=0;
		N = sc.nextInt();
		K = sc.nextInt();
		
		Set<Point> apple = new HashSet<Point>();
		
		for(int i=0;i<K;i++) {
			apple.add(new Point(sc.nextInt()-1,sc.nextInt()-1));
		}
		
		L = sc.nextInt();
		int[] Rtime = new int[L];
		char[] Rot = new char[L];
		for(int i=0;i<L;i++) {
			Rtime[i]=sc.nextInt();
			Rot[i]=sc.next().charAt(0);
		}
		
		List<Point> snake = new ArrayList<Point>();
		snake.add(new Point(0,0));
		int dir = 0;//방향 오른쪽
		int index=0;//방향을 따지는 index
		
		boolean live = true;
		while(live) {
			Point preHead = snake.get(0);
			
			if(index<L && time==Rtime[index]) {
				if(Rot[index]=='D') {
					dir = (dir+1)%4;
				}else {
					dir--;
					if(dir==-1) dir=3;
				}
				index++;
			}
			
			switch (dir) {
			case 0:
				snake.add(0,new Point(preHead.x,preHead.y+1));
				break;
			case 1:
				snake.add(0,new Point(preHead.x+1,preHead.y));
				break;
			case 2:
				snake.add(0,new Point(preHead.x,preHead.y-1));
				break;
			case 3:
				snake.add(0,new Point(preHead.x-1,preHead.y));
				break;
			}
			time++;
			
			//몸통이나 벽에 부딪치는지 확인
			Point Head = snake.get(0);
//			System.out.println("머리 위치 ==> ("+Head.x+","+Head.y+")");
			
			if(Head.x<0 || Head.x>=N || Head.y<0 || Head.y>=N) {
//				System.out.println("#####게임판 탈출#####");
				live= false;
				break;
			}else {
//				System.out.println("###몸체충돌체크###");
				for(int i=1;i<snake.size();i++) {
					if(Head.x == snake.get(i).x && Head.y == snake.get(i).y) {
//						System.out.println("@@@@@몸체충돌@@@@@");
						live=false;
						break;
					}
				}
			}
			
			if(apple.contains(snake.get(0))) {//머리 위치에 사과가 있을때
				apple.remove(snake.get(0));
			}else {//사과가 없을때
				snake.remove(snake.size()-1);//꼬리 삭제
			}
//			System.out.println("사과 개수:"+apple.size()+" , 뱀 길이:"+snake.size());
		}
		
		System.out.println(time);
	}
	
}
