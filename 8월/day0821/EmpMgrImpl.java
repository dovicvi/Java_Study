package day0821;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpMgrImpl implements EmpMgr{	
	
	@Override
	public void add(Employee emp) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into Employee (empNo,name,position,dept) values (?,?,?,?)";//핵심코드
			pstmt = conn.prepareStatement(sql);//입력받은 데이터는 '?' 바인딩변수처리
												//즉, preparedStatement(sql문)메소드를 통해 데이터를 제외한 'sql문만 전달'!!
			
			//pstmt.set 자료형(?의 위치번호, 데이터); '?'의 갯수만큼 세터메소드를 정의
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getPosition());
			pstmt.setString(4, emp.getDept());
			
			pstmt.executeUpdate();//DB에게 sql실행요청 
			//>>주의: sql문은 위에서 전달했으므로 executeUpdate()에 매개변수로 sql문을 집어넣으면 안됨!!
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
	}

	@Override
	public List<Employee> search() {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select empNo,name,position,dept from Employee";
			pstmt=conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("empNo"), rs.getString("name"),
										rs.getString("position"),	rs.getString("dept")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Employee> search(int empNo) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select empNo,name,position,dept from Employee where empNo=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, empNo);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("empNo"), rs.getString("name"),
										rs.getString("position"),	rs.getString("dept")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<Employee> search(String name) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			String sql = "select empNo,name,position,dept from Employee where name like ?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Employee(rs.getInt("empNo"), rs.getString("name"),
										rs.getString("position"),	rs.getString("dept")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {//끊을때는 시작할때의 역순으로!!
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public boolean update(int empNo, String dept) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql="update Employee set dept=? where empNo=?";//핵심코드
			pstmt = conn.prepareStatement(sql);//입력받은 데이터는 '?' 바인딩변수처리
												//즉, preparedStatement(sql문)메소드를 통해 데이터를 제외한 'sql문만 전달'!!
			
			//pstmt.set 자료형(?의 위치번호, 데이터); '?'의 갯수만큼 세터메소드를 정의
			pstmt.setString(1, dept);
			pstmt.setInt(2, empNo);
			
			int t= pstmt.executeUpdate();//DB에게 sql실행요청
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return false;
	}

	@Override
	public boolean delete(int empNo) {
		Connection conn = DBUtil.getConnection();
		PreparedStatement pstmt = null;
		try {
			String sql = "delete Employee where empNo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, empNo);
			
			int t= pstmt.executeUpdate();//DB에게 sql실행요청
			if(t==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(conn);
		}
		return false;
	}

}
