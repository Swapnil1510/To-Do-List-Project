import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Operation {
	static String firstname;
	static String lastname;
	static int Age;
	static int personid;
	
	public static void insert(Scanner sc) {
		System.out.print("enter firstname : ");
		firstname = sc.next();
		System.out.print("enter lastname : ");
		lastname = sc.next();
		System.out.print("enter age : ");
		Age = sc.nextInt();
	}
	
	public static void delete(Scanner sc) {
		System.out.print("enter personid : ");
		personid = sc.nextInt();
	}
	
	public static void update(Scanner sc) {
		System.out.print("enter personid : ");
		personid = sc.nextInt();
		System.out.print("enter firstname : ");
		firstname = sc.next();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the operation you want:");
		int op = sc.nextInt();
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String pswd = "root"; 
		Connection con = null;
		PreparedStatement pstm = null;
		do {
			switch (op) {
			case 1:
				System.out.println("insert data in table:");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, pswd);
					insert(sc);
				    pstm = con
							.prepareStatement("insert into persons(firstname,lastname,Age)" + "values(?,?,?)");
					pstm.setString(1, firstname);
					pstm.setString(2, lastname);
					pstm.setInt(3, Age);
					int res = pstm.executeUpdate();
					if (res > 0) {
						System.out.println("data inserted successfully....");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("delete data from table:");
				try {
					Class.forName("com.mysql.jdbc.Driver");
				    con = DriverManager.getConnection(url, username, pswd);
				    delete(sc);
					pstm = con.prepareStatement("delete from persons where personid=?");
					pstm.setInt(1, personid);
					int res = pstm.executeUpdate();
					System.out.println("data deleted successfully....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 3:
				System.out.println("update data in table:");
				try {
					Class.forName("com.mysql.jdbc.Driver");
				    con = DriverManager.getConnection(url, username, pswd);
				    update(sc);
				    pstm = con.prepareStatement("update persons set firstname=? where personid=?");
					pstm.setString(1, firstname);
					pstm.setInt(2, personid);
					int res = pstm.executeUpdate();
					System.out.println("data updated successfully....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("exit");
				break;
			default:
				System.out.println("default data");
			}
			System.out.print("Enter the operation you want: ");
			op = sc.nextInt();

		} while (op != 4);
	}

}
