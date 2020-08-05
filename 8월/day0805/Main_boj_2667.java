package day0805;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main_boj_2667 {
	static int map[][];
	static int visit[][];
	static int n;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n=Integer.parseInt(st.nextToken());

		map= new int[n][n];
		visit=new int[n][n];
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(str.substring(j,j+1));
			}
		}
		int cnt=0;
		
		Vector<Integer> v = new Vector<Integer>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(map[i][j]==1 && visit[i][j]==0) {
					cnt++;
					visit[i][j]=cnt;
					v.add(bfs(i,j));
				}
			}
		}
		
		Object[] objs = v.toArray();
		Arrays.sort(objs);
		System.out.println(cnt);
		for(int i=0;i<objs.length;i++) {
			System.out.println(objs[i]);
		}
		
	}
	
	private static int bfs(int a, int b) {
		Queue<Point> q=new LinkedList<Point>();
		q.offer(new Point(a,b));
		
		int count=0;
		
		while(!q.isEmpty()) {
			int x=q.peek().x;
			int y=q.peek().y;
			q.poll();
			count++;
			
			for(int i=0;i<4;i++) {
				int mx=x+dx[i];
				int my=y+dy[i];
				if(mx>=0 && mx<n && my>=0 && my<n && visit[mx][my]==0 && map[mx][my]==1) {
					visit[mx][my]=visit[x][y];
					q.offer(new Point(mx,my));
				}
			}
		}
		return count;
	}
	
	
}