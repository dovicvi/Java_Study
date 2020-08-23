package day0821;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class EmpTest {
	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean flag=true;
        EmpMgrImpl dao = new EmpMgrImpl();
        
        while(flag) {
		  System.out.println("<제품메뉴>");
		  System.out.println("1.입력 2.전체목록 3.사원이름검색 4.사원번호검색 5.수정 6.삭제 7.종료");
		  System.out.print("==>번호: ");
		  int no= Integer.parseInt(in.readLine());
		  System.out.println();
		  switch(no) {
		    case 1: {
		    	    System.out.print("사원번호: "); int empNo = Integer.parseInt(in.readLine());
		    	    System.out.print("이름: "); String name = in.readLine();
		    	    System.out.print("직위: "); String position = in.readLine();
		    	    System.out.print("부서: "); String dept = in.readLine();
		    	
		    	    Employee emp = new Employee(empNo, name, position, dept);
		    	     dao.add(emp);
		    	     
		            }break;
		            
		    case 2: printEmployees(dao.search());
		    	    break;
		    	    
		    case 3: {
		    	     System.out.print("검색할 이름: "); String name = in.readLine();
		    	     printEmployees(dao.search(name));
		            }break;
		            
		    case 4: {
		    	System.out.print("검색할 사원번호: "); 
		    	int empNo = Integer.parseInt(in.readLine());
		    	printEmployees(dao.search(empNo));
		        }break;
		            
		    case 5: {		    	
			    	 System.out.print("수정할 사원번호: "); 
			    	 	int empNo = Integer.parseInt(in.readLine());
			    	 System.out.print("수정할 부서: ");
			    	 	String dept = in.readLine();
	                  if(dao.update(empNo,dept)) {
	                	  System.out.println("## 수정이 잘 되었습니다!!");
	                  }else {
	                	  System.err.println("## 일치하는 제품이 없습니다!!");
	                  }
	                }break;
	                
		    case 6: {
		    	     System.out.print("삭제할 사원번호: "); int empNo = Integer.parseInt(in.readLine());
		    	     dao.delete(empNo);
		            }break;
		            
		    case 8: flag=false;
		  }//switch
		  System.out.println();
		}//while
	}//main

	private static void printEmployees(List<Employee> list) {
		System.out.println("▣ 사원목록 ▣");
		for(Employee emp:list) {
			System.out.println(emp);
		}
	}
}
