import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution_swea_2948_문자열교집합 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1;tc<=T;tc++) {
			int a,b,cnt=0;
			a=sc.nextInt();
			b=sc.nextInt();
			
			Map<String, Integer> m = new HashMap<String, Integer>();
			String str;
			for(int i=0;i<a;i++) {
				str=sc.next();
				m.put(str, 1);
			}
			for(int i=0;i<b;i++) {
				str=sc.next();
				if(m.get(str)!=null) cnt++;
			}
			System.out.println("#"+tc+" "+cnt);
		}
		
	}
}
