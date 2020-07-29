package com.ssafy.algo;

public class Refrigerator {
	
	String number;
	String name;
	int price;
	int have;
	int capacity;
	
	public Refrigerator(String number, String name, int price, int have, int capacity) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.have = have;
		this.capacity = capacity;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public int getHave() {
		return have;
	}

	public void setHave(int have) {
		this.have = have;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Refrigerator [number=" + number + ", name=" + name + ", price=" + price + ", have=" + have
				+ ", capacity=" + capacity + "]";
	}

}
