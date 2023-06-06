package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData {

	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		
		//Credentials DO NOT TOUCH
		String url = "jdbc:mysql://localhost:3306/loginscreen";
		String username = "root";
		String password = "Intervallum11141";
		
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			//Getting the connection to database
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("CONNECTION ESTABLISHED");
			
			// Creating the statement
			statement = connection.createStatement();
			
			// Executing the SQL Query
			System.out.println("CAUTION YOU ARE DELETING ENTIRE EMPLOYEE DATA");
			System.out.println("THERE IS NO UNDO OR BACKUP");
			System.out.println("Enter employee ID number");
			String empid = scan.next();
			
			
			statement.executeUpdate("Delete from employees where employee_id="+empid);
		
						
			System.out.println("Delete Completed!");
			MasterControl.main(args);
			scan.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		
	}
}
