package com.ssafy;

public class ProductMgr {
	private Product[] products = new Product[100];
	private int index;
	
	private static ProductMgr instance;
	
	public static ProductMgr getInstance() {
		if(instance==null) {
			instance=new ProductMgr();
		}
		return instance;
	}
	
	public void add(Product p) {
		products[index++] = p;
	}
	
	public Product[] list() {
		return products;
	}
	
	public Product list(int num) {
		Product temp = null;
		
		for(int i=0;i<index;i++) {
			if(products[i].getNum()==num) {
				temp = products[i];
				break;
			}
		}
		
		return temp;
	}
	
	public void delete(int num) {
		for(int i=0;i<index;i++) {
			if(products[i].getNum()==num) {
				products[i]=products[index-1];
				break;
			}
		}
		products[index-1]=null;
		index--;
	}
	
	public Product[] priceList(int price) {
		Product[] temp;
		int size=0;
		int cnt=0;
		for(int i=0;i<index;i++) {
			if(products[i].getPrice()<=price) size++;
		}
		temp = new Product[size];
		for(int i=0;i<index;i++) {
			if(products[i].getPrice()<=price) {
				temp[cnt++]=products[i];
			}
		}
		return temp;
	}
	
	public int getSize() {
		return index;
	}
}
