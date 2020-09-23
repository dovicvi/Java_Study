import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//====입력====
//첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 
//빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
//====출력====
//첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 
//이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.
//====주의점====
//조건에 (N,N)이 빈칸이란 말이 없는걸 보면 (N,N)에 벽이 올 수 도 있다.
public class Main_boj_17069_파이프옮기기2 {
	private static long ans;
	private static int n;
	private static int[][] map;
	private static Pipe[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		dp = new Pipe[n][n];
		
		for(int i=0;i<n;i++) {
			st  = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j]=new Pipe();
			}
		}
		ans=0;
//		dfs방식으로 마지막 테케 결과
//		걸린 시간 : 277.664초
//		dp방식
//		걸린 시간 : 0.001초
		
		
//		long start = System.currentTimeMillis();
		
//		dfs(0,1,0);//행,열,방향
		
		dp[0][1].dir[0]=1;
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(dp[i][j].getSum()==0) continue;
				
				if(j+1<n && map[i][j+1]==0) {
					dp[i][j+1].dir[0] += dp[i][j].dir[0] + dp[i][j].dir[2];
				}
				if(i+1<n && map[i+1][j]==0) {
					dp[i+1][j].dir[1] += dp[i][j].dir[1] + dp[i][j].dir[2];
				}
				if(i+1<n && j+1<n && map[i+1][j]==0 && map[i][j+1]==0 && map[i+1][j+1]==0) {
					dp[i+1][j+1].dir[2] += dp[i][j].getSum();
				}
			}
		}
		
		ans = dp[n-1][n-1].getSum();
		
//		long end = System.currentTimeMillis();
		
		System.out.println(ans);
//		System.out.println("걸린 시간 : "+(end-start)/1000.0+"초");
	}
	
	private static void dfs(int x, int y, int d) {
		if(x==n-1 && y==n-1) {
			ans++;
			return;
		}
		
		//d는 방향
		//0 가로,1 세로,2 대각선
		if((d==0 || d==2) && y+1<n && map[x][y+1]==0) {//가로 이동
			dfs(x,y+1,0);
		}
		if((d==1 || d==2) && x+1<n && map[x+1][y]==0) {
			dfs(x+1,y,1);
		}
		if(x+1<n && y+1<n && map[x+1][y]==0 && map[x][y+1]==0 && map[x+1][y+1]==0) {
			dfs(x+1,y+1,2);
		}
	}

	private static class Pipe{
		long[] dir = new long[3];
		
		public Pipe() {
			dir[0]=0;
			dir[1]=0;
			dir[2]=0;
		}
		
		public long getSum() {
			return dir[0]+dir[1]+dir[2];
		}
	}

}
