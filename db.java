package database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
	
	public static void main(String[] args) throws SQLException {
		  Connection conn = null;
		  
	        try {
	 
	        	
	        	//here we need to download jdbc and we have to add jar to the project
	            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=NORTHWND";
	            String user = "sa";
	            String pass = "1234";
	            conn = DriverManager.getConnection(dbURL, user, pass);
	            if (conn != null) {
	                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
	                System.out.println("Driver name: " + dm.getDriverName());
	                System.out.println("Driver version: " + dm.getDriverVersion());
	                System.out.println("Product name: " + dm.getDatabaseProductName());
	                System.out.println("Product version: " + dm.getDatabaseProductVersion());
	                Statement s1 = conn.createStatement();
	                ResultSet rs = s1.executeQuery("select * from student");
	                String[] result = new String[20];
	                if(rs!=null){
	                    while (rs.next()){
	                    	System.out.println(rs.getNString(1)+"  "+rs.getNString(2)+"  "+rs.getNString(3));  
	                    }
	                }
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            try {
	                if (conn != null && !conn.isClosed()) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	            }

}}}
