package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ProductDTO;
import dto.UserDTO;

public class DBManager extends DAO {
	
	
	// userId と pass から探す
	public UserDTO getUser(String userId, String password) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM user WHERE id = ? AND pass = ?;";
		UserDTO user = null;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				user = new UserDTO();
				
				user.setUserId(rset.getString(1));
				user.setUserName(rset.getString(2));
				user.setPassword(rset.getString(3));
				user.setDivision(rset.getString(4));
				
				
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
			close(conn);
		}
		
		return user;
	}

	
	// ユーザー登録
	public boolean setRegist(String userId, String password, String userName, String division) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;
		String sql = "INSERT INTO user(id, name, pass, division)VALUES(?,?,?,?);";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// SQL文に値をセット
			pstmt.setString(1, userId);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			pstmt.setString(4, division);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				result = true;
			}
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
			close(conn);
			
		}
		
		
		return result;
		
	}
	
	
	// 削除する商品を探す
	public ProductDTO getProduct(String productName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ProductDTO product = null;
		String sql = "SELECT * FROM product p JOIN category c ON p.category_id = c.id HAVING p.name = ?;";
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productName);
			rset = pstmt.executeQuery();
			
			
			if(rset.next()) {
				
				product = new ProductDTO();
				
				product.setProductName(rset.getString(2));
				product.setPrice(rset.getInt(4));
				product.setCategoryName(rset.getString(7));
				
				
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
			close(conn);
			
		}
		
		return product;
		
		
	}
	
	
	
	// 商品登録
	public boolean setProduct(String productName, String category, int price) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;
		String sql = "INSERT INTO product(no, name, category_id, price, del_flg)VALUES(0,?,?,?,1)";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productName);
			pstmt.setString(2, category);
			pstmt.setInt(3, price);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				result = true;
			}
			
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
			close(conn);
			
		}
		
		return result;
		
		
	}
	
	
	
	// 商品削除（フラグを0に）
	public boolean deleteProduct(String productName) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		boolean result = false;
		String sql = "UPDATE product SET del_flg = '0' WHERE name = ?;";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productName);
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt == 1) {
				
				result = true;
			}
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(pstmt);
			close(conn);
		}
		
		return result;
		
		
	}
	
	
	
	// 商品検索
	public ArrayList<ProductDTO> getProductList(String sql) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<ProductDTO> list = null;
		
		try {
			
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<ProductDTO>();
			
			while(rset.next()) {
				
				ProductDTO product = new ProductDTO();
				
				product.setProductName(rset.getString(2));
				product.setPrice(rset.getInt(4));
				product.setCategoryName(rset.getString(7));
				
				list.add(product);
				
			}
			
			
			
			
			
			
		} catch(SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(rset);
			close(pstmt);
			close(conn);
			
		}
		
		return list;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
