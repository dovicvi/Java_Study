package day0812;

public class Product {
	private int no;
	private String name;
	private int price;
	private int stock;
	
	public Product() {}

	

	public Product(int no, String name, int price, int stock) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}



	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	
	

	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", price=");
		builder.append(price);
		builder.append(", stock=");
		builder.append(stock);
		builder.append("]");
		return builder.toString();
	}
	
}
