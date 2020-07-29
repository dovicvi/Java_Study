package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n;
		int [] tenth = new int[10];
		
		while(true) {
			
			n = sc.nextInt();
			if(n==0) break;
			
			int x = n/10;
			tenth[x]++;
		}
		
		for(int i=0;i<10;i++) {
			if(tenth[i]==0) continue;
			System.out.println(i+":"+tenth[i]+"개");
		}
		
	}

}
