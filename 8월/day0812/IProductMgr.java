package day0812;

import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> searchAll();	
	public Product searchNo(int no) throws CodeNotFoundException;	
	public ArrayList<Product> searchTitle(String name);
	public ArrayList<Tv> searchTv();	
	public ArrayList<Refrigerator> searchRefrigerator();
	public ArrayList<Refrigerator> search400L() throws ProductNotFoundException;	
	public ArrayList<Tv> search50inch() throws ProductNotFoundException;
	public boolean resave(int no,int price) throws CodeNotFoundException;
	public boolean delete(int no);
	public int searchTotal();	
}
