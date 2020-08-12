package day0812;

public class DuplicateException extends Exception {
	public DuplicateException(){
		super("이미 있는 상품입니다");
	}
}
