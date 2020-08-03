package day0803;

import java.util.Arrays;
import java.util.Scanner;

public class sw_9229_Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
        for(int test_case = 1; test_case <= T; test_case++)
		{
			int n,m;
			n=sc.nextInt();
			m=sc.nextInt();
			
			int w[] = new int[n];
			int result=0;
			for(int i=0;i<n;i++) {
				w[i]=sc.nextInt();
			}
			
			Arrays.sort(w);
			
			if(w[0]+w[1]>m) {
				result=-1;
			}else {
				for(int i=n-1;i>=1;i--) {
					for(int j=i-1;j>=0;j--) {
						if(w[i]+w[j]<=m) {
							if(result<w[i]+w[j]) result=w[i]+w[j];
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}