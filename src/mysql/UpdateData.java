package mysql;
import java.sql.*;
import java.util.Scanner;
public class UpdateData {

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
			
			// Creating the statement
			statement = connection.createStatement();
			
			// Executing the SQL Query
			
			
			//statement.executeUpdate(sql);
			System.out.println("What would you like to update?");
			System.out.println("1. First Name");
			System.out.println("2. Last Name");
			System.out.println("3. Hourly Pay");
			System.out.println("4. Hire Date");
			System.out.println("5. Username");
			System.out.println("6. Pin");
			String input = scan.next();
			
			if (input.equals("1")){
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter fist name");
				String FirstName = scan.next();
				statement.executeUpdate("UPDATE employees SET first_name='"+FirstName+"'WHERE employee_id=" +empid);
				System.out.println("First Name Updated!\n");
				MasterControl.main(args);
				
			}else if (input.equals("2")) {
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter last name");
				String LastName = scan.next();
				statement.executeUpdate("UPDATE employees SET last_name='"+LastName+"'WHERE employee_id=" +empid);
				System.out.println("Last Name Updated!\n");
				MasterControl.main(args);
				
			}else if (input.equals("3")) {
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter Hourly pay");
				String HourlyPay = scan.next();
				statement.executeUpdate("UPDATE employees SET hourly_pay='"+HourlyPay+"'WHERE employee_id=" +empid);
				System.out.println("Hourly pay Updated!\n");
				MasterControl.main(args);
				
			}else if (input.equals("4")) {
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter hire date Y-MM-DD");
				String HireDate = scan.next();
				
				if (HireDate.equals("today")) {
					statement.executeUpdate("UPDATE employees SET hire_date= current_date() WHERE employee_id=" +empid);
				} else {
					statement.executeUpdate("UPDATE employees SET hire_date='"+HireDate+"'WHERE employee_id=" +empid);
				}
				
				System.out.println("Hire date Updated!\n");
				MasterControl.main(args);
				
			}else if (input.equals("5")) {
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter username");
				String User = scan.next();
				statement.executeUpdate("UPDATE employees SET username='"+User+"'WHERE employee_id=" +empid);
				System.out.println("Username Updated!\n");
				MasterControl.main(args);
				
			}else if (input.equals("6")) {
				System.out.println("Enter Employee ID");
				String empid = scan.next();
				System.out.println("Enter Pin code");
				String Pin = scan.next();
				statement.executeUpdate("UPDATE employees SET pin='"+Pin+"'WHERE employee_id=" +empid);
				System.out.println("Pin code Updated!\n");
				MasterControl.main(args);
				
			}else {
				System.out.println("Invalid Input");
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
