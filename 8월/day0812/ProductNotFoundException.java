package day0812;

public class ProductNotFoundException extends Exception {
	public ProductNotFoundException() {
		super("일치하는 상품이 하나도 없습니다.");
	}
}
