import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_boj_14889_스타트와링크 {
	private static int ans;
	private static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][] = new int[n][n];
		
		
		
		for(int i=0;i<n;i++) {
			String[] line = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(line[j]);
			}
		}
		
		int len = 1<<n;//2^n
		visit = new boolean[n];
		ans=Integer.MAX_VALUE;
		
		for(int i=0;i<len/2;i++) {
			Arrays.fill(visit, false);
			int cnt=0;//절반인지 판단하는 변수
			for(int j=0;j<n;j++) {//부분집합 구하는 방식
				if((i &(1<<j)) != 0) {
					visit[j]=true;
				}
			}
//			절반으로 나누어졌는지 확인
			for (int j = 0; j < n; j++) {
				if(visit[j]) {
					cnt++;
				}
			}
//			절반이 맞으면 두 부분집합 차이 비교
			if(cnt==n/2) {
				cal(n,map);
			}
		}
		
		System.out.println(ans);
	}

	private static void cal(int n,int[][] map) {
		int sum1=0,sum2=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) continue;
				if(visit[i]!=visit[j]) continue;
				if(visit[i]) {
					sum1+=map[i][j];
				}else {
					sum2+=map[i][j];
				}
			}
		}
		
		if(Math.abs(sum1-sum2)<ans) {
			ans = Math.abs(sum1-sum2);
		}
	}
}
