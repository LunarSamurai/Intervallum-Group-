package mysql;

import java.sql.SQLException;
import java.util.Scanner;

public class MasterControl {

	public static void main(String[] args) throws SQLException {
		Scanner master = new Scanner(System.in);
		
		ViewData viewdata = new ViewData();
		
		System.out.println("Welcome please choose an option!\n");
		System.out.println("1. View Data");
		System.out.println("2. Insert Data");
		System.out.println("3. Update Data");
		System.out.println("4. Delete Data");
		String option = master.next();
		
		if(option.equals("1")) {
			viewdata.GetUserData();
			
		} else if (option.equals("2")) {
			InsertData.main(args);
			
			
			
			
			
			
			
			
		} else if (option.equals("3")) {
			UpdateData.main(args);
			
		} else if (option.equals("4")) {
			DeleteData.main(args);
			
		} else {
			System.out.println("Invalid Input");
			
		}
		master.close();
	}

}
