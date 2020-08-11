package day0810;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgr mgr = new ProductMgr();
		Product p1 = new Product(1, "product1", 100000, 50);
		Product p2 = new Product(2, "product2", 99900000, 10);
		Tv tv1 = new Tv(3, "tv1", 500000, 9);
		Refrigerator r1 = new Refrigerator(4, "r1", 2500000, 10);
		mgr.add(p1);
		mgr.add(p2);
		mgr.add(tv1);
		mgr.add(r1);
		
		System.out.println("=====모두검색===========");
		Product[] products1  = mgr.search();
		for (Product p : products1) {
			System.out.println(p);
		}
		
		System.out.println("\n=====no 검색===========");
		Product products2 = mgr.searchNo(2);
		System.out.println(products2);
		
		System.out.println("\n=====title 검색===========");
		Product[] products3  = mgr.searchName("product");
		for (Product p : products3) {
			System.out.println(p);
		}
		System.out.println("\n======TV 검색==============");
		Product[] products4 = mgr.searchTv();
		for (Product p : products4) {
		    System.out.println(p);
		}		
		
		System.out.println("\n======냉장고 검색==============");
		Product[] products5 = mgr.searchRefrigerator();
		for (Product p :products5) {
			System.out.println(p);
		}
		
		System.out.println("\n======삭제 확인==============");
		if(mgr.delete(2)) {
			for (Product p : mgr.search()) {
				System.out.println(p);
			}
		}else {
			System.err.println("삭제실패");
		}
		
		System.out.println("\n======상품 금액의 합계==============");
		System.out.println("합계 :"+ mgr.totalPrice());
	}

}
