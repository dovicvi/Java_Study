package day0810;

import java.util.Arrays;

public class ProductMgr {
	private Product products[] = new Product[100];
	private int index;
	
	public void add(Product p) {
		products[index++] = p;
	}
	
	public Product[] search() {
		Product[] temp = Arrays.copyOf(products, index);
		return temp;
	}
	
	public Product searchNo(int no) {
		for(Product p: products) {
			if(p.getNo()==no) {
				return p;
			}
		}
		return null;
	}
	public Product[] searchName(String name) {//상품명 부분 검색 가능
		int cnt=0;
		for(int i=0;i<index;i++) {
			if(products[i].getName().contains(name)) cnt++;
		}
		if(cnt==0) return null;
		Product[] temp = new Product[cnt];
		cnt=0;
		for(int i=0;i<index;i++) {
			if(products[i].getName().contains(name)) {
				temp[cnt++]=products[i];
			}
		}
		return temp;
	}
	
	public Product[] searchTv() {
		Product temp[];
		int cnt=0;
		for(Product p : products) {
			if(p!=null && (p instanceof Tv)) cnt++;
		}
		temp=new Product[cnt];
		cnt=0;
		for(Product p : products) {
			if(p!=null && (p instanceof Tv)) {
				temp[cnt++] = p;
			}
		}
		
		return temp;
	}
	
	public Product[] searchRefrigerator() {
		Product temp[];
		int cnt=0;
		for(Product p : products) {
			if(p!=null && (p instanceof Refrigerator)) cnt++;
		}
		temp=new Product[cnt];
		cnt=0;
		for(Product p : products) {
			if(p!=null && (p instanceof Refrigerator)) {
				temp[cnt++] = p;
			}
		}
		
		return temp;
	}
	
	public boolean delete(int no) {
		int x=500;
		for(int i=0;i<index;i++) {
			if(products[i].getNo()==no) {
				x=i;
				break;
			}
		}
		if(x==500) return false;
		for(int i=x;i<index-1;i++) {
			products[i]=products[i+1];
		}
		return true;
	}
	
	public int totalPrice() {
		int sum=0;
		for(int i=0;i<index;i++) {
			sum+=products[i].getPrice();
		}
		return sum;
	}
}
