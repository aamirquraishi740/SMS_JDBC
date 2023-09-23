package com.example.StudentDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.entity.Student;
import com.example.util.util;
import com.mysql.cj.protocol.Resultset;

public class StudentDao {
	
	static Connection con =null;
	
	public static Connection getC() throws ClassNotFoundException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return con;
	}

	public void creatStudent() throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con =null;
		PreparedStatement pstm =null;
		
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			
			StudentDao.getC();
			
			String q ="create table student(id int auto_increment unique,name varchar(30) not null,phone int unique not null,city varchar(30) not null)";
			
			
			pstm =con.prepareStatement(q);
			
			pstm.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
		
	}



	public void insertData(Student s) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con =null;
		PreparedStatement pstm =null;
		
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			con=StudentDao.getC();
			
			String q ="insert into  student (name,phone,city) values(?,?,?)";
			
			
			pstm =con.prepareStatement(q);
			
			pstm.setString(1,s.getName());
			pstm.setString(2, s.getPhone());
			pstm.setString(3, s.getCity());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
		
		
	}

	public void showAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstm =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			
			String q ="select * from student";
			
			
			pstm =con.prepareStatement(q);
			
		
			
			ResultSet rs =pstm.executeQuery();
			
			ArrayList<Student> li=new ArrayList<Student>();
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString(4);
				
				Student s =new Student(id,name,phone,city);
				
				li.add(s);
				
			}
			System.out.println(li);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
	}

	public void showAllById(Integer id1) throws SQLException {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstm =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			
			String q ="select * from student where id=?";
			
			
			pstm =con.prepareStatement(q);
			
		pstm.setInt(1, id1);
			
			ResultSet rs =pstm.executeQuery();
			
			ArrayList<Student> li=new ArrayList<Student>();
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString(4);
				
				Student s =new Student(id,name,phone,city);
				
				li.add(s);
				
			}
			System.out.println(li);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
		
	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstm =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			
			String q ="delete student from student where id=?";
			
			
			
			pstm =con.prepareStatement(q);
			
			pstm.setInt(1, id);
						
        pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
		
	}

	public void update(int id,int newId,String newName,String newPhone,String newCity) throws SQLException {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstm =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con =DriverManager.getConnection(util.JDBC_URL,util.JDBC_USERNAME,util.JDBC_PASS);
			
			String q ="update student set id=? ,name=?,phone=?,city=? where id=?";
			
			
			
			pstm =con.prepareStatement(q);
			
			pstm.setInt(1, newId);
			pstm.setString(2, newName);
			pstm.setString(3, newPhone);
			pstm.setString(4, newCity);
			pstm.setInt(5, id);

						
        pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		finally {
			if(con!=null) {
				con.close();
				System.out.println("_____x_______");
			}
		}
		
		
	}

}
