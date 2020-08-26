import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_boj_2206_벽부수고이동하기 {
	private static int len[][][];
	private static int n,m,result;
	private static boolean flag;
	private static int dx[] = {0,0,-1,1};
	private static int dy[] = {-1,1,0,0};
	private static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		result=-1;
		n=Integer.parseInt(str[0]);
		m=Integer.parseInt(str[1]);
		map = new int[n][m];
		len = new int[n][m][2];
		for(int i=0;i<n;i++) {
			str = br.readLine().split("");
			for(int j=0;j<m;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		len[0][0][0]=1;//거리 1
		len[0][0][0]=0;//벽 부수기 안했음
		bfs();
		
		if(result==-1) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0,0));
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			int x=p.x;
			int y=p.y;
			if(x==n-1 && y==m-1) {
				result=len[n-1][m-1][0]+1;
				break;
			}
//			System.out.println(x+","+y+" "+len[x][y][0]);
			for(int i=0;i<4;i++) {
				int mx=x+dx[i];
				int my=y+dy[i];
				if(mx>=0 && mx<n && my>=0 && my<m && len[mx][my][0]==0) {
					if(map[mx][my]==0) {
						len[mx][my][0]=len[x][y][0]+1;
						len[mx][my][1]=len[x][y][1];
						q.offer(new Point(mx,my));
					}else if(map[mx][my]==1 && len[x][y][1]==0) {
						len[mx][my][0]=len[x][y][0]+1;
						len[mx][my][1]=1;
						q.offer(new Point(mx,my));
					}
				}
			}
			
		}
	}
}
