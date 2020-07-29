package com.ssafy.algo;

public class ProductTest {

	public static void main(String[] args) {
		TV tv1 = new TV("215", "Good TV", 200000, 10, 21, "LED");
		TV tv2 = new TV("999", "BEST TV", 1500000, 5, 45, "MOVIE");
		Refrigerator ref1 = new Refrigerator("123", "SoSo Refrigerator", 500000, 5, 200);
		
		System.out.println(tv1);
		System.out.println(tv2);
		System.out.println(ref1);
		
	}

}
