import java.util.Arrays;
import java.util.Scanner;

//0~9의 숫자가 모두 포함되어야함
//삐긋수여야함
//0으로 시작 못함
public class Solution_swea_7393_대규의팬덤활동 {
	private static final int MOD = 1000000000;//10억
	private static int[][][] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int n = sc.nextInt();
			dp = new int[n+1][10][1<<11];
			long r = 0;
			
			for(int i=0;i<n+1;i++) {
				for(int j=0;j<10;j++) {
					Arrays.fill(dp[i][j], -1);
				}
			}
			
			for(int idx=1; idx<10; idx++) {
				r = (r+recursive(n, idx, 0)) % MOD;
			}
			
			System.out.println("#"+tc+" "+r);
		}
		
	}

	private static long recursive(int position, int idx, int state) {
		if(idx<0 || idx>9)
			return 0;
		if(position == 1) {
			if((state | (1 << idx)) == ((1 << 10)-1))
				return 1;
			else
				return 0;
		}
		
		if(dp[position][idx][state] != -1)
			return dp[position][idx][state];
		state |= (1 << idx);//or 연산
		return dp[position][idx][state] = 
				(int) ((recursive(position - 1, idx + 1, state) + recursive(position-1, idx-1, state)) % MOD);
	}
	
}
