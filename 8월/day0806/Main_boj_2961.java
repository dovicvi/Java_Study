package day0806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_boj_2961 {
	
	static int n;
	static int x[][];
	static int min=Integer.MAX_VALUE;
	static boolean check[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n=Integer.parseInt(st.nextToken());
		
		x=new int[n][2];
		check = new boolean [n];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			x[i][0]=Integer.parseInt(st.nextToken());
			x[i][1]=Integer.parseInt(st.nextToken());
		}
		
		bfs(0,1,0);
		
		System.out.println(min);
	}

	private static void bfs(int k,int s,int b) {
		int result = Math.abs(s-b);
		if(b!=0 && result<min) {
			min = result;
		}
		
		for(int i=k;i<n;i++) {
			if(check[i]) continue;
			check[i]=true;
			bfs(k+1,s*x[i][0],b+x[i][1]);
			check[i]=false;
			bfs(k+1,s,b);
		}
		
	}
}
