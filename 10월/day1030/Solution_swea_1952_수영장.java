import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_swea_1952_수영장 {
	private static int[] price,mon,pMonth, dpMon;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(in.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			price = new int[4];
			mon = new int[13];
			
			pMonth = new int[13];
			dpMon = new int[13];
			
			st = new StringTokenizer(in.readLine()," ");
			for(int i=0;i<4;i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine()," ");
			for(int i=1;i<=12;i++) {
				mon[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=1;i<=12;i++) {
				pMonth[i] = Math.min(mon[i]*price[0], price[1]);
			}
			
			for(int i=1;i<=12;i++) {
				dpMon[i] = dpMon[i-1]+pMonth[i];
				if(i>=3) {
					if(dpMon[i] > dpMon[i-3]+price[2]) {
						dpMon[i] = dpMon[i-3]+price[2];
					}
				}
			}
			
			if(dpMon[12] > price[3]) dpMon[12]=price[3];
			
			System.out.println("#"+tc+" "+dpMon[12]);
		}
	}
}
