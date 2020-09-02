import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_boj_17144_미세먼지안녕 {
	private static int[][] map;
	private static int sum;
	private static int r,c,t;//행,열,시간
	private static int air;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		t=Integer.parseInt(st.nextToken());
		map=new int[r][c];
		sum=0;
		air=-2;
		
		
		for(int i=0;i<r;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<c;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					air=i;//공기 청정기의 아래칸이 저장됨
					//공기청정기의 위치는(i-1,0)과(i,0)가 된다.
				}else {
					sum+=map[i][j];
				}
			}
		}
		
		bfs();
//		System.out.println();//없앨것
		System.out.println(sum);
	}

	private static void bfs() {
		for(int i=0;i<t;i++) {
			dustMove();
			AirMove();
//			printMap();
//			System.out.println(sum);
		}
	}

	private static void printMap() {
		System.out.println("====================");
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

	private static void AirMove() {
		int tmp;
		int x=(air-1)-1,y=0;		
		sum-=map[x][y];
		
		for(;x>0;x--) {
			map[x][y]=map[x-1][y];
		}
		for(;y<c-1;y++) {
			map[x][y]=map[x][y+1];
		}
		for(;x<air-1;x++) {
			map[x][y]=map[x+1][y];
		}
		for(;y>1;y--) {
			map[x][y]=map[x][y-1];
		}
		map[x][y]=0;
		x=air+1; y=0;
		sum-=map[x][y];
		for(;x<r-1;x++) {
			map[x][y]=map[x+1][y];
		}
		for(;y<c-1;y++) {
			map[x][y]=map[x][y+1];
		}
		for(;x>air;x--) {
			map[x][y]=map[x-1][y];
		}
		for(;y>1;y--) {
			map[x][y]=map[x][y-1];
		}
		map[x][y]=0;
	}

	private static int[] dx= {-1,0,1,0};
	private static int[] dy= {0,1,0,-1};
	private static void dustMove() {
		int [][] temp = new int[r][c];
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				if(map[i][j]==0 || map[i][j]==-1) continue;
				int x=map[i][j]/5;
				int cnt=0;
				if(x==0) continue;
				for(int k=0;k<4;k++) {
					int mx=i+dx[k];
					int my=j+dy[k];
					if(mx>=0 && mx<r && my>=0 && my<c && map[mx][my]!=-1) {
						temp[mx][my]+=x;
						cnt++;
					}
				}
				temp[i][j]-=x*cnt;
			}
		}
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				map[i][j]+=temp[i][j];
			}
		}
		
	}
}
