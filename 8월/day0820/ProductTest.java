package day0820;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ProductTest {
	private static final int PRODUCT_INPUT=1;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        ProductDAO dao = new ProductDAO();
        
        while(flag) {
		  System.out.println("<제품메뉴>");
		  System.out.println("1.입력 2.전체목록 3.상품명검색 4.상품가격검색 5.상품번호검색 6.수정 7.삭제 8.종료");
		  System.out.print("==>번호: ");
		  int no= Integer.parseInt(in.readLine());
		  System.out.println();
		  switch(no) {
		    case PRODUCT_INPUT: {
		    	    System.out.print("제품번호: "); String serial = in.readLine();
		    	    System.out.print("제품명: "); String name = in.readLine();
		    	    System.out.print("가격: "); int price = Integer.parseInt(in.readLine());
		    	    System.out.print("재고: "); int stock = Integer.parseInt(in.readLine());
		    	
		    	    Product p = new Product(serial, name, price, stock);
		    	     dao.addProduct(p);
		    	     
		            }break;
		            
		    case 2: printProducts(dao.searchProduct());
		    	    break;
		    	    
		    case 3: {
		    	     System.out.print("검색할 상품명: "); String name = in.readLine();
		    	     printProducts(dao.searchProduct(name));
		            }break;
		            
		    case 4: {
		    	System.out.print("검색할 상품가격: "); 
		    	int price = Integer.parseInt(in.readLine());
		    	printProducts(dao.searchProduct(price));
		        }break;
		            
		    case 5: {
		    	System.out.print("검색할 상품번호: "); String serial = in.readLine();
		    	printProducts(dao.searchSerialProduct(serial));
		    }break;
		    
		    case 6: {		    	
			    	 System.out.print("수정할 제품번호: "); 
			    	     String serial = in.readLine();
			    	 System.out.print("수정할 가격: "); 
			    	     int price = Integer.parseInt(in.readLine());
	                  if(dao.modifyProduct(serial,price)) {
	                	  System.out.println("## 수정이 잘 되었습니다!!");
	                  }else {
	                	  System.err.println("## 일치하는 제품이 없습니다!!");
	                  }
	                }break;
	                
		    case 7: {
		    	     System.out.print("삭제할 제품번호: "); String serial = in.readLine();
		    	     dao.deleteProduct(serial);
		            }break;
		            
		    case 8: flag=false;
		  }//switch
		  System.out.println();
		}//while
	}//main

	private static void printProducts(List<Product> list) {
		System.out.println("▣ 제품목록 ▣");
		for(Product pro:list) {
			System.out.println(pro);
		}
	}
}