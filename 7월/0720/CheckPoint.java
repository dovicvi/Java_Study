package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height, weight;
		System.out.print("키를 입력해주세요 >> ");
		height = sc.nextInt();
		System.out.print("몸무게를 입력해주세요 >> ");
		weight = sc.nextInt();
		
		int result = weight+100-height;
		System.out.printf("당신의 비만도는 %d입니다\n",result);
		if(result>0)
			System.out.println("당신은 비만이군요");

	}

}
