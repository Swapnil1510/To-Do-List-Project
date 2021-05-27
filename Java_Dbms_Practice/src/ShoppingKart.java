import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingKart {
	static String items;

	public static void insert(Scanner sc) {
		System.out.print("insert items name : ");
		items = sc.next();
	}

	public static void main(String[] args) {
		System.out.println("......Welcome to SRS Mall.....");
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Statement st = null;

		ArrayList<Shopping> itemsList = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			st = con.createStatement();
			rs = st.executeQuery("select * from shoppingkart");
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		Scanner sc = new Scanner(System.in);
		System.out.println("Choose your option");
		int user = sc.nextInt();
		switch (user) {
		case 1:
			System.out.println("...Please tell what you want to buy ?...");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, username, password);
				insert(sc);
				pstm = con.prepareStatement("select price,items from shoppingkart where items=?");
				Shopping s = new Shopping();
				
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			for(Shopping obj : itemsList) {
				System.out.println(obj.getItems()+" "+obj.getPrice());
			}
			break;
			
		case 2: System.out.println("....Your bill....");
			
		default:
			break;
		}
	}

}
