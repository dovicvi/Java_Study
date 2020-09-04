import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 0은 빈칸, 1~6 물고기의 크기, 9 아기 상어의 위치
 * 아기 상어는 공간에 무조건 1마리
 * n의 범위는 2~20
 * 물고기는 없을 수도 있다.
 * 아기 상어는 가장 가까운 위치의 물고기를 먹고
 * -위에 있는 먹이 우선, 왼쪽에 있는 먹이 우선이다
 * 아기 상어의 초기 크기는 2이다.
 * 자기보다 큰 물고기는 못 먹으며, 못 지나간다.
 * 자기랑 크기가 같은 물고기는 못 먹지만, 지나갈 순 있다.
 * 자기보다 작은 물고기는 먹으며, 지나갈 수 있다.
 * 1칸 이동에 1초이며, 먹는 시간은 0초이다.
 */

//문제 풀이
//bfs를 이용해서 길이를 따져서 같은 길이 중 왼쪽 위에 위치한 물고기 잡아먹기

public class Main_boj_16236_아기상어 {
	private static int cnt;
	private static int n;
	private static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		Shark baby = null;//아기 상어 변수
		cnt=0;//시간
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < n; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					map[i][j]=0;
					baby = new Shark(2, 0, i, j);
				}
			}
		}
		
		bfs(baby);
		
		System.out.println(cnt);
	}
	
	private static int dx[] = {-1,0,0,1};
	private static int dy[] = {0,-1,1,0};
	
	private static void bfs(Shark baby) {
		int x,y;
		
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(baby.x,baby.y));
		boolean flag=false;
		int len=1;//탐색하는 거리 변수, 초기에 거리가 1인위치 탐색
		List<Point> pointList = new ArrayList<Point>();//잡아 먹을 수 있는 고기의 리스트
		boolean[][] visit=new boolean[n][n];
		visit[baby.x][baby.y]=true;//초기 아기상어 위치 true

		while(!q.isEmpty()) {
			int size=q.size();
			
			for(int i=0;i<size;i++) {
				Point p = q.poll();
				x=p.x;
				y=p.y;
				for(int j=0;j<4;j++) {
					int mx = x+dx[j];
					int my = y+dy[j];
					if(mx>=0 && mx<n && my>=0 && my<n && visit[mx][my]==false && baby.size>=map[mx][my]) {//이동이 가능한 위치인지 판단
						visit[mx][my]=true;
						q.offer(new Point(mx,my));
						if(map[mx][my]>0 && map[mx][my]<baby.size) {//먹을 수 있는 물고기가 있다면 리스트에 추가
							flag=true;
							pointList.add(new Point(mx,my));
						}
					}
				}//4방 탐색 for문 end
			}//같은거리 탐색 for문 end
			if(flag) break;
			len++;
		}//while end
		
		if(flag) {//먹을 수 있는 물고기가 있다
			//먹을 수 있는 고기 중에서 왼쪽 위에 해당하는 고기를 찾기 위해 정렬
			Collections.sort(pointList,new MyComparator());
			//고기 위치의  map 0으로 바꾸기
			Point p = pointList.get(0);
			map[p.x][p.y]=0;
			//아기 상어의 위치 변경
			baby.setX(p.x);
			baby.setY(p.y);
			//아기 상어가 물고기 잡아먹기 함수
			baby.eat();
			//cnt에 이동한 길이 더하기
			cnt+=len;
			//queue메모리 삭제
			q.clear();
			//변경된 아기상어로 bfs반복
			bfs(baby);//bfs반복
		}else {//먹을 수 있는 물고기가 없다.
			return;//끝내기
		}
		
	}//bfs end

	static class Shark{
		int size, eat;//크기,먹은 양
		int x,y;//좌표
		
		public Shark(int size, int eat, int x, int y) {
			super();
			this.size = size;
			this.eat = eat;
			this.x = x;
			this.y = y;
		}
		
		public void eat() {
			this.eat++;
			if(eat>=size) {
				this.size++;
				this.eat=0;
			}
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}
		
	}
	static class MyComparator implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			if(p1.x>p2.x) {
				return 1;
			}else if(p1.x == p2.x) {
				if(p1.y>p2.y) {
					return 1;
				}
			}
			return -1;
		}
		
	}
}
