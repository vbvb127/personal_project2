package item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCUtil;
import item.vo.ItemVO;


public class ItemDAO {
	
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs;
	
	private final String GET_ITEM_LIST = "select * from item order by item_no desc";
	private final String INSERT_ITEM_NO = "select max(item_no)+1 as item_no from item";
	private final String INSERT_ITEM = "insert into item values (?,?,?,?,?)";
	private final String GET_ITEM = "select * from item where item_no=?";
	
	
	public List<ItemVO> getItemList(ItemVO vo) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		System.out.println("---> JDBC get Item List() start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_ITEM_LIST);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ItemVO item = new ItemVO();
				item.setItem_no(rs.getString("item_no"));
				item.setTitle(rs.getString("item_title"));
				item.setContent(rs.getString("item_content"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_cnt(rs.getInt("item_cnt"));				
				itemList.add(item);
			}
		} catch (SQLException e) {
			System.out.println("GET item List error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return itemList;
	}
	
	
	public ItemVO getItem(ItemVO vo) {
		ItemVO item = null;
		
		System.out.println("---> JDBC get item start");
		
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(GET_ITEM);
			stmt.setString(1, vo.getItem_no());
			rs = stmt.executeQuery();
			if (rs.next()) {
				item = new ItemVO();
				item.setItem_no(rs.getString("item_no"));
				item.setTitle(rs.getString("item_title"));
				item.setContent(rs.getString("item_content"));
				item.setItem_price(rs.getInt("item_price"));
				item.setItem_cnt(rs.getInt("item_cnt"));
				
				stmt.executeUpdate();			
			}
		} catch (SQLException e) {
			System.out.println("getItem error");
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return item;
	}
	
	
	public ItemVO insertItem(ItemVO vo) {
		ItemVO item = null;
		System.out.println("---> JDBC insert Item start");
		
		
		try {
			conn = JDBCUtil.getConnection();
			//insert into item values ((select max(item_no)+1 from item),?,?,?,?) 
			//하나로 넣으려다가 item_no null들어와서 나눴음
			stmt = conn.prepareStatement(INSERT_ITEM_NO);
			rs = stmt.executeQuery();
			if (rs.next()) {
			item = new ItemVO();
			item.setItem_no(rs.getString("item_no"));
			
			stmt = conn.prepareStatement(INSERT_ITEM);
			stmt.setString(1, item.getItem_no());
			stmt.setString(2, vo.getTitle());
			stmt.setString(3, vo.getContent());
			stmt.setInt(4, vo.getItem_price());
			stmt.setInt(5, vo.getItem_cnt());
			stmt.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("insertBoard error");
		} finally {
			JDBCUtil.close(rs,stmt, conn);
		}
		
		vo.setItem_no(item.getItem_no());
		return vo;
	}

		
	
	

}
