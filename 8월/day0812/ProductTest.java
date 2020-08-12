package day0812;

public class ProductTest {
	
	public static void main(String[] args) throws DuplicateException, ProductNotFoundException, CodeNotFoundException {
		IProductMgr mgr = new ProductMgrImpl();
		Product p1 = new Product(1, "product1", 100000, 50);
		Product p2 = new Product(2, "product2", 99900000, 10);
//		Tv tv1 = new Tv(3, "tv1", 500000, 9, 42);
		Refrigerator r1 = new Refrigerator(4, "r1", 2500000, 10, 400);
		mgr.add(p1);
		mgr.add(p2);
		mgr.add(new Tv(3, "tv1", 500000, 9, 42));
		mgr.add(r1);
		mgr.add(new Tv(5, "tv2", 500000, 9, 60));
		mgr.add(new Refrigerator(6, "r2", 4500000, 1, 800));
		
		System.out.println("=====모두검색===========");
		System.out.println(mgr.searchAll());
		
		System.out.println("\n=====no 검색===========");
		Product products2 = mgr.searchNo(2);
		System.out.println(products2);
		
		System.out.println("\n=====title 검색===========");
		System.out.println(mgr.searchTitle("pro"));
		
		System.out.println("\n======TV 검색==============");
		System.out.println(mgr.searchTv());
		
		System.out.println("\n======냉장고 검색==============");
		System.out.println(mgr.searchRefrigerator());
		
		System.out.println("\n======400L이상 냉장고 검색==============");
		System.out.println(mgr.search400L());
		
		System.out.println("\n======50inch이상 TV 검색==============");
		System.out.println(mgr.search50inch());
		
		System.out.println("\n======가격변경 검색==============");
		if(mgr.resave(6,3990000)) {
			System.out.println("가격이 변경 되었습니다.");
		}else {
			System.err.println("변경 실패");
		}
		
		//
		//삭제가 제대로 안됨
		//
		System.out.println("\n======삭제 확인==============");
		if(mgr.delete(2)) {
			System.out.println("삭제되었습니다.");
		}else {
			System.err.println("삭제 실패");
		}
		
		System.out.println("=====모두검색===========");
		System.out.println(mgr.searchAll());
		
		System.out.println("\n======상품 금액의 합계==============");
		System.out.println("합계 :"+ mgr.searchTotal());
	}

}
