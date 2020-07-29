package com.ssafy.algo;

public class TV {
	private String number;
	private String name;
	private int price;
	private int have;
	private int inch;
	private String type;
	
	public TV(String number, String name, int price, int have, int inch, String type) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
		this.have = have;
		this.inch = inch;
		this.type = type;
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
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		this.inch = inch;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "TV [number=" + number + ", name=" + name + ", price=" + price + ", have=" + have + ", inch=" + inch
				+ ", type=" + type + "]";
	}
	

}
