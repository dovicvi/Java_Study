package day0818;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductMgrImpl implements IProductMgr{
//	private Product products[] = new Product[100];
//	private int index;

	ArrayList<Product> products = new ArrayList<Product>();

	@Override
	public void add(Product p) {
		products.add(p);
	}

	@Override
	public ArrayList<Product> searchAll() {
		return products;
	}

	@Override
	public Product searchNo(int no) {
		for(Product p : products) {
			if(p.getNo()==no) {
				return p;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> searchTitle(String name) {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getName().contains(name)) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Tv> searchTv() {
		ArrayList<Tv> temp = new ArrayList<>();
		for(int i=0;i<products.size();i++) {
			if((products.get(i) instanceof Tv)) {
				temp.add((Tv)products.get(i));
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Refrigerator> searchRefrigerator() {
		ArrayList<Refrigerator> temp = new ArrayList<>();
		for(int i=0;i<products.size();i++) {
			if((products.get(i) instanceof Refrigerator)) {
				temp.add((Refrigerator) products.get(i));
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Refrigerator> search400L() {
		ArrayList<Refrigerator> refrigerators = searchRefrigerator();
		ArrayList<Refrigerator> temp = new ArrayList<Refrigerator>();
		for(int i=0;i<refrigerators.size();i++) {
			if(refrigerators.get(i).getVolume()>=400) {
				temp.add(refrigerators.get(i));
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Tv> search50inch() {
		ArrayList<Tv> tvs = searchTv();
		ArrayList<Tv> temp = new ArrayList<>();
		for(int i=0;i<tvs.size();i++) {
			if(tvs.get(i).getInch()>=50) {
				temp.add(tvs.get(i));
			}
		}
		return temp;
	}

	@Override
	public boolean resave(int no, int price) {
		Product p = searchNo(no);
		if(p==null) {
			System.out.println("일치하는 번호가 없습니다.");
			return false;
		}else {
			p.setPrice(price);
			System.out.println(p.toString());
			return true;
		}
	}

	@Override
	public boolean delete(int no) {
		for(int i=0;i<products.size();i++) {
			if(products.get(i).getNo()==no) {
				products.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public int searchTotal() {
		int total=0;
		for (int i=0; i<products.size(); i++) {
			total+=products.get(i).getPrice();
		}
		return total;
	}
	
	
	
//	public void add(Product p) {
//		products[index++] = p;
//	}
//	
//	public Product[] search() {
//		Product[] temp = Arrays.copyOf(products, index);
//		return temp;
//	}
//	
//	public Product searchNo(int no) {
//		for(Product p: products) {
//			if(p.getNo()==no) {
//				return p;
//			}
//		}
//		return null;
//	}
//	public Product[] searchName(String name) {//상품명 부분 검색 가능
////		Product[] seachName = null;
//		int cnt=0;
//		for(int i=0;i<index;i++) {
//			if(products[i].getName().contains(name)) cnt++;
//		}
//		if(cnt==0) return null;
//		Product[] temp = new Product[cnt];
//		cnt=0;
//		for(int i=0;i<index;i++) {
//			if(products[i].getName().contains(name)) {
//				temp[cnt++]=products[i];
//			}
//		}
//		return temp;
//	}
//	
//	public Product[] searchTv() {
//		Product temp[];
//		int cnt=0;
//		for(Product p : products) {
//			if(p!=null && (p instanceof Tv)) cnt++;
//		}
//		temp=new Product[cnt];
//		cnt=0;
//		for(Product p : products) {
//			if(p!=null && (p instanceof Tv)) {
//				temp[cnt++] = p;
//			}
//		}
//		
//		return temp;
//	}
//	
//	public Product[] searchRefrigerator() {
//		Product temp[];
//		int cnt=0;
//		for(Product p : products) {
//			if(p!=null && (p instanceof Refrigerator)) cnt++;
//		}
//		temp=new Product[cnt];
//		cnt=0;
//		for(Product p : products) {
//			if(p!=null && (p instanceof Refrigerator)) {
//				temp[cnt++] = p;
//			}
//		}
//		
//		return temp;
//	}
//	
//	public boolean delete(int no) {
//		int x=500;
//		for(int i=0;i<index;i++) {
//			if(products[i].getNo()==no) {
//				x=i;
//				break;
//			}
//		}
//		if(x==500) return false;
//		for(int i=x;i<index-1;i++) {
//			products[i]=products[i+1];
//		}
//		index--;
//		return true;
//	}
//	
//	public int totalPrice() {
//		int sum=0;
//		for(int i=0;i<index;i++) {
//			sum+=products[i].getPrice();
//		}
//		return sum;
//	}
}
