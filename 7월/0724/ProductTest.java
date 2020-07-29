package com.ssafy;

import java.util.Scanner;

public class ProductTest {

	static ProductMgr list = ProductMgr.getInstance();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n;
		
		do {
			System.out.println("<<< 물품 관리 시스템 >>>");
			System.out.println("1. 물품 추가");
			System.out.println("2. 전체 상품 보기");
			System.out.println("3. 상품 번호로 검색");
			System.out.println("4. 상품 번호로 삭제");
			System.out.println("5. 가격이하 상품 검색");
			System.out.println("종료하시려면 0을 입력해주세요!");
			System.out.print("숫자를 입력해주세요 >> ");
			n=sc.nextInt();
			sc.nextLine();
			switch (n) {
			case 1:
				add_product();
				break;
			case 2:
				print_all();
				break;
			case 3:
				print_num();
				break;
			case 4:
				delete_num();
				break;
			case 5:
				print_price();
				break;
			case 0:
				System.out.println("\n!!!시슴템 종료!!!");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
			System.out.println();
			System.out.println();
		}while(n!=0);
		
	}

	private static void add_product() {
		System.out.println("1. 물품 추가 기능");
		System.out.print("상품 번호 >> ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("상품 이름 >> ");
		String name = sc.nextLine();
		System.out.print("상품 가격 >> ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("상품 수량 >> ");
		int capacity = sc.nextInt();
		sc.nextLine();
		
		Product p = new Product(num, name, price, capacity);
		list.add(p);
	}

	private static void print_all() {
		System.out.println("2. 전체 상품 목록");
		Product [] products = new Product[100];
		products = list.list();
		for(int i=0;i<list.getSize();i++) {
			System.out.println(products[i]);
		}
	}

	private static void print_num() {
		System.out.println("3. 상품 검색");
		System.out.print("검색할 상품 번호 >> ");
		int num=sc.nextInt();
		sc.nextLine();
		System.out.println(list.list(num));
	}

	private static void delete_num() {
		System.out.println("4. 상품 삭제");
		System.out.print("삭제할 상품 번호 >> ");
		int num=sc.nextInt();
		sc.nextLine();
		list.delete(num);
	}

	private static void print_price() {
		System.out.println("5. 가격 검색");
		System.out.print("상품 가격 >> ");
		int price = sc.nextInt();
		sc.nextLine();
		Product [] temp;
		temp = list.priceList(price);
		for(int i=0;i<temp.length;i++) {
			System.out.println(temp[i]);
		}
	}
	
}
