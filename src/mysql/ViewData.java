


package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewData {
	public ViewData() {
		
	}

	public void GetUserData() {
		//Credentials
		String url = "jdbc:mysql://localhost:3306/loginscreen";
		String username = "root";
		String password = "Intervallum11141";
		
		//Register driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create connection 
			Connection connection = DriverManager.getConnection(url, username, password);
			
			//create statement
			Statement statement = connection.createStatement();
			
			
			//execute queries
			ResultSet resultSet = statement.executeQuery("select * from employees");
			
			//make numbers same order as columns in MySQL
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("employee_id")+ "\t" +resultSet.getString("first_name")+"  "+resultSet.getString("last_name")+"  "+resultSet.getDouble("Hourly_pay")+ "  "+resultSet.getString("hire_date"));
			}
			
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
	}

}
