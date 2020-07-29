package day0728;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution3
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n=sc.nextInt();
            int [][]map =new int[n][n];
            
            int dx[]={0,1,0,-1};
            int dy[]={1,0,-1,0};
            
            int plus=1,num=1;
            int len=n;
            int x=0,y=-1;
            while(num<=n*n){
                for(int i=0;i<len;i++){
                	y+=plus;
                	map[x][y]=num++;
                }
                if(num>n*n) break;
                len--;
                for(int i=0;i<len;i++) {
                	x+=plus;
                	map[x][y]=num++;
                }
                plus*=-1;
            }
            System.out.println("#"+test_case);
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    System.out.print(map[i][j]+" ");
                }
            	System.out.println();
            }
		}
	}
}