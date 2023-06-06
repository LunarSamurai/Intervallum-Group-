package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData {

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
			System.out.println("ENTER EMPLOYEE FIRST NAME");
			String empfirstname = scan.next();
			System.out.println("ENTER EMPLOYEE LAST NAME");
			String emplastname = scan.next();
			System.out.print("ENTER EMPLOYEE HOURLY PAY");
			double hourlypay = scan.nextDouble();
			System.out.println("ENTER EMPLOYEE HIRE DATE Y-M-D or 'today'");
			String hiredate = scan.next();
			if (hiredate.equals("today")) {
				statement.executeUpdate("insert into employees (first_name, last_name, hourly_pay, hire_date) value('"+empfirstname+"','"+emplastname+"','"+hourlypay+"', current_date())");
				System.out.println("Insert Completed!\n");
				MasterControl.main(args);
			}else {
				statement.executeUpdate("insert into employees (first_name, last_name, hourly_pay, hire_date) value('"+empfirstname+"','"+emplastname+"','"+hourlypay+"','"+hiredate+"')");
				System.out.println("Insert Completed!\n");
				MasterControl.main(args);
			}
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
