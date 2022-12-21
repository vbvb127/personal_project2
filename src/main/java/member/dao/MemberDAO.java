package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCUtil;
import member.vo.MemberVO;


public class MemberDAO {
	
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs;
	
	private final String USER_LOGIN = "SELECT count(*) as cnt from members where m_id = ? and m_password = ?";
	private final String USER_GET = "select * from members where m_id = ? and m_password = ?";
	private final String USER_CREATE = "insert into members(m_num,m_id,m_password,m_name,m_tel,m_address) values ((select max(m_num)+1 from members),?,?,?,?,?)";
	private final String USER_UPDATE = "update members set m_password=?, m_name=?,m_address=?,m_tel=? where m_id =? ";
	
	
	public void createMember(MemberVO vo) {
		System.out.println("----------JDBC create user---------");
		
		try {
			System.out.println(vo.toString());
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_CREATE);
			stmt.setString(1, vo.getM_id());
			stmt.setString(2, vo.getM_password());
			stmt.setString(3, vo.getM_name());
			stmt.setString(4, vo.getM_tel());
			stmt.setString(5, vo.getM_address());
			stmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println("create user error");
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	
	public void updateMember(MemberVO vo) {
			
		System.out.println("----------JDBC update member ---------");
		
		try {
			conn = JDBCUtil.getConnection();
			String id =  vo.getM_id();
			String name =  vo.getM_name();
			String password =  vo.getM_password();
			String address =  vo.getM_address();
			String tel =  vo.getM_tel();
			
			stmt = conn.prepareStatement(USER_UPDATE);
			stmt.setString(1, password);
			stmt.setString(2, name);
			stmt.setString(3, address);
			stmt.setString(4, tel);
			stmt.setString(5, id);
			stmt.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("update member error");
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	
	//id, pw 확인
	public int checkLogin(String id, String password) {
		
		System.out.println("---> JDBC Login check start");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_LOGIN);
			stmt.setString(1, id);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next()) {
				if (rs.getInt("cnt")==1){
					System.out.println("id,pw 확인");
					return 0; //성공
					
				}else {
					System.out.println("retrun 1");
					return 1; // 비밀번호 안맞음
				}
			}
		} catch (SQLException e) {
			System.out.println("login ceck error");
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		System.out.println("retrun -1");
		return -1; //오류
	}
	
	
	public MemberVO getUser(MemberVO vo) {
		MemberVO member = null;
		
		System.out.println("---> JDBC getUser() start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getM_id());
			stmt.setString(2, vo.getM_password());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				member = new MemberVO();
				member.setM_num(rs.getInt("m_num"));
				member.setM_id(rs.getString("m_id"));
				member.setM_password(rs.getString("m_password"));
				member.setM_name(rs.getString("m_name"));
				member.setM_tel(rs.getString("m_tel"));
				member.setM_address(rs.getString("m_address"));
				member.setM_level(rs.getInt("m_level"));
				
				
			}
			
		} catch (SQLException e) {
			System.out.println("getUser error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
			
		return member;
	}
	
	


}
