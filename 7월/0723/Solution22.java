package com.ssafy.algo;

import java.util.Scanner;

public class Solution22 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		int dx[]= {-1,1,0,0};
		int dy[]= {0,0,-1,1};
		
		for(int test=1;test<=T;test++) {
			int n, bug, die=0;
			n=sc.nextInt();
			bug = sc.nextInt();
			int [][] map = new int[n][n];
			
			for(int i=0;i<bug;i++) {
				int x,y,d;
				x=sc.nextInt();
				y=sc.nextInt();
				d=sc.nextInt()-1;
				
				boolean check = true;//살았는지 죽었는지 확인
				
				for(int j=3;j>0;j--) {
					if(map[x][y]!=0) {
						check = false;
						break;
					}
					x+=dx[d]*j;
					y+=dy[d]*j;
					if(x<0 || x>=n ||y<0 || y>=n) {
						check=false;
						break;
					}
				}
				if(check && map[x][y]!=0) check=false;
				
				if(check) {//살아있을때
					map[x][y]=1;
				}else {//죽었을떼
					die++;
				}
			}
			System.out.println("#"+test+" "+(bug-die));
		}

	}

}
