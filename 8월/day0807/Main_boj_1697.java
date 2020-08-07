package day0807;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_boj_1697 {
	
	static boolean visit[] = new boolean[100001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start,finish;
		start=sc.nextInt();
		finish=sc.nextInt();
		visit[start]=true;
		System.out.println(bfs(start,finish));
	}

	private static int bfs(int a, int b) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(a,0));
		
		while(true) {
			Point p =q.poll();
			int x=p.x;
			int cnt=p.y;
			if(x==b) return cnt;
			
			if(2*x<=100000 && !visit[2*x]) {
				visit[2*x]=true;
				q.offer(new Point(2*x,cnt+1));
			}
			if(x+1<=100000 && !visit[x+1]) {
				visit[x+1]=true;
				q.offer(new Point(x+1,cnt+1));
			}
			if(x-1>=0 && !visit[x-1]) {
				visit[x-1]=true;
				q.offer(new Point(x-1,cnt+1));
			}
		}
		
	}
}
