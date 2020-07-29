package day0729;

import java.util.Scanner;
import java.io.FileInputStream;

public class HW_Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result=0;
			int n=sc.nextInt();
			int k=sc.nextInt();
			int map[][] = new int[n][n];
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			int plus[][] = new int[n][n];
			for(int i=0;i<=n-k;i++) {
				for(int j=0;j<=n-k;j++) {
					int sum=0;
					for(int x=0;x<k;x++) {
						for(int y=0;y<k;y++) {
							sum+=map[i+x][j+y];
						}
					}
					plus[i][j]=sum;
					if(sum>result) result=sum;
				}
			}
			
			
			System.out.println("#"+test_case+" "+result);
		}
	}
}