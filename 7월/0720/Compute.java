package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		System.out.printf("곱=%d\n",a*b);
		System.out.printf("몫=%d\n",a/b);
	}

}
