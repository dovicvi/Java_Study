package day0818;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p);
	public ArrayList<Product> searchAll();	
	public Product searchNo(int no);	
	public ArrayList<Product> searchTitle(String name);
	public ArrayList<Tv> searchTv();	
	public ArrayList<Refrigerator> searchRefrigerator();
	public ArrayList<Refrigerator> search400L();	
	public ArrayList<Tv> search50inch();
	public boolean resave(int no,int price);
	public boolean delete(int no);
	public int searchTotal();	
}
