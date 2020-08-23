package day0821;

import java.util.List;

public interface EmpMgr {
	public void add(Employee emp);
	public List<Employee> search();
	public List<Employee> search(int empNo);
	public List<Employee> search(String name);
	public boolean update(int empNo, String dept);
	public boolean delete(int empNo);
}
