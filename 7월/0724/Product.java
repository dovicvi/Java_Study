package com.ssafy;

public class Product {
	private int num;
	private String name;
	private int price;
	private int capacity;
	
	public Product() {}
	
	public Product(int num, String name, int price, int capacity) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.capacity = capacity;
	}

	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [num=");
		builder.append(num);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", capacity=");
		builder.append(capacity);
		builder.append("]");
		return builder.toString();
	}
	
		
}
