package indexMain;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DBOperactions {
	Connection connection;
	public void ConnectDB() {
		
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "FOMS";
        String password = "FOMS123";

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int InsertDB(String sql, Object[] params) {
        String sqlc=sql;
        int result = 0;
        try {
        	
            PreparedStatement statement = connection.prepareStatement(sqlc);
  
            for (int i = 0; i < params.length; i++) {
                statement.setObject(i + 1, params[i]);
            }
            result = statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
        

    }
    public ResultSet ReadAllDB(String sql) throws SQLException {
		 PreparedStatement statement = connection.prepareStatement(sql);
		 return statement.executeQuery();
		 }
	   
public void printResultSet(ResultSet resultSet) throws SQLException {
	 ResultSetMetaData metaData = resultSet.getMetaData();
	 int columnCount = metaData.getColumnCount();
	 
	 while (resultSet.next()) {
		 System.out.println("------------------------------------------------------------------------------------------");
	 StringBuilder row = new StringBuilder();
	 for (int i = 1; i <= columnCount; i++) {
		
	 if (i > 1) {
	 row.append("\t ");
	 }
	String columnName = metaData.getColumnName(i);
	 Object value = resultSet.getObject(i);
     
	 row.append(columnName).append("\t:").append(value).append("\t: ");
    

	 }
	 System.out.println(row.toString());
	 }
}
public ResultSet ReadDB(String sql, Object[] params) throws SQLException {
	 PreparedStatement statement = connection.prepareStatement(sql);
	 for (int i = 0; i < params.length; i++) {
	 statement.setObject(i + 1, params[i]);
	 }
	 return statement.executeQuery();
   
}
public void DeleteDB(String sql, Object[] params) {
	Scanner scan=new Scanner(System.in);
	 int result = 0;
	 char opt;
	 try {
	 PreparedStatement statement = connection.prepareStatement(sql);
	 for (int i = 0; i < params.length; i++) {
	 statement.setObject(i + 1, params[i]);
	 }
	 System.out.println("Do you want to delete the data(y/n)?");
	 opt=scan.next().charAt(0);
	 if(opt=='y') { 
	 result = statement.executeUpdate();
	 if (result > 0) 
	 System.out.println("Data was deleted successfully!");
	 else
	 System.out.println("No data with the specified username found.");
	 }else {
	 System.out.println("Data was not deleted");
	 }
	 statement.close();
	 } catch (SQLException e) {
	 e.printStackTrace();
	 }
	 scan.close();
	 }
}   

