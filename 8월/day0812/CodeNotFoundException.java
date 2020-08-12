package day0812;

public class CodeNotFoundException extends Exception {
	public CodeNotFoundException() {
		super("없는 상품번호입니다");
	}
}
