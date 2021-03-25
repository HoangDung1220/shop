package com.laptrinhjavaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.GenericDAO;
import com.laptrinhjavaweb.mapper.RowMapper;

public class AbstractDAO<T> implements GenericDAO<T> {
	
	public  Connection getConnection() {
		Connection conn = null;
	try {
			String url ="jdbc:mysql://localhost:3306/shop";
			String username ="root";
			String password ="120301200201";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	      catch (SQLException e) {
	     	e.printStackTrace();
	}
		

		return conn;
	}

	public  List<T> query(String querry, RowMapper<T> rowMapper, Object... paramters) {
		
		Connection conn = getConnection();
		PreparedStatement ppst=null;
		ResultSet rs =null;
		List<T> list = new ArrayList<T>();
		try {
			ppst = conn.prepareStatement(querry);
			setParameter(ppst,paramters);
		    rs = ppst.executeQuery();
			while (rs.next()) {
			list.add(rowMapper.mapRow(rs));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
			
			if (rs!=null) {
				rs.close();
			}
			
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		
		return list;
	}

	
	public void setParameter(PreparedStatement ppst,Object... parameters) {
		try {
		for (int i=0;i<parameters.length;i++) {
			if (parameters[i] instanceof Long ) {
				
					ppst.setLong(i+1, (Long) parameters[i]);
				} 
			if (parameters[i] instanceof String ) {
				
				ppst.setString(i+1, (String) parameters[i]);
			} 
			if (parameters[i] instanceof Integer ) {
				
				ppst.setInt(i+1, (Integer) parameters[i]);
			} 
			if (parameters[i] instanceof Timestamp ) {
				
				ppst.setTimestamp(i+1, (Timestamp) parameters[i]);
			} 
		}
		
		}
		catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

	public Long insert(String querry, Object... paramters) {
 
		Connection conn=null;
		PreparedStatement ppst = null;
		ResultSet rs=null;
		try {
			Long id = null;

			conn = getConnection();
			conn.setAutoCommit(false);
			ppst= conn.prepareStatement(querry,Statement.RETURN_GENERATED_KEYS);
			setParameter(ppst,paramters);
			ppst.executeUpdate();
			rs = ppst.getGeneratedKeys();
			if (rs.next()) {
				id =rs.getLong(1);
			}
			conn.commit();
			return id;
		    	
		} catch (SQLException e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			return null;
		}
		
		finally
		{
			try {
				if (conn != null) {
					conn.close();
				}
				if (ppst != null) {
					ppst.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		
		
	}

	public void update(String querry, Object... paramters) {

		PreparedStatement ppst = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst= conn.prepareStatement(querry,Statement.RETURN_GENERATED_KEYS);
			setParameter(ppst, paramters);
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn!=null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {

			if (conn!=null) {
					conn.close();
			}
			if (ppst!=null) {
				ppst.close();
			}
			
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

	public void delete(String querry, Object... paramters) {

		PreparedStatement ppst = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(querry,Statement.RETURN_GENERATED_KEYS);
			setParameter(ppst,paramters);
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
			if (conn!=null) {
				
					conn.close();
			}
			
			if (ppst!=null) {
				ppst.close();
			}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	public int count(String querry, Object... paramters) {
		
		Connection conn = null;
		PreparedStatement ppst = null;
		ResultSet rs = null;
		
		try {
			int d=0;
			conn = getConnection();
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(querry,Statement.RETURN_GENERATED_KEYS);
            setParameter(ppst,paramters);
			rs = ppst.executeQuery();
			if (rs.next()) {
				d= rs.getInt(1);
			}
			conn.commit();
			return d;
			
		} catch (SQLException e) {
			
			if (conn!=null) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
		finally {
				try {
					if (conn!=null) {

					conn.close();
					}
					
					if (ppst!=null) {
						ppst.close();
					}
					
					if (rs!=null) {
						rs.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return 0;
	}
		
	
		
	
}
