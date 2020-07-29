package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T;
		T=sc.nextInt();
		
		int dx[] = {-1,-1,-1,0,1,1,1,0};
		int dy[] = {-1,0,1,1,1,0,-1,-1};
		
		for(int test=1;test<=T;test++) {
			int n = sc.nextInt();
			char[][] grid = new char[n][n];
			int [][] map = new int[n][n];
			int max_floor=2;
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					grid[i][j]=sc.next().charAt(0);
					if(grid[i][j]=='G') map[i][j]=0;
					else if(grid[i][j]=='B') map[i][j]=1;
				}
			}
			
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					if(map[i][j]==0) continue;
					boolean check=true;
					for(int k=0;k<8;k++) {
						int x=i+dx[k], y=j+dy[k];
						if(x<0 || x>=n || y<0 || y>=n) continue;
						if(map[x][y]==0) {
							check=false;
							break;
						}
					}
					if(check) {
						int temp=-1;//자기 두번 더해질거 생각해서 -1
						for(int k=0;k<n;k++) {
							if(map[i][k]==1) temp++;
							if(map[k][j]==1) temp++;
						}
//						System.out.println("x:"+i+",y:"+j+", "+temp);
						if(temp>max_floor) max_floor=temp;
					}
				}
			}
			
			System.out.println("#"+test+" "+max_floor);
		}

	}

}
