import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class OperationOnTable {
	static int SId;
	static String StudentName;
	static String MobileNo;
	static String Branch;
	static String City;

	public static void insert(Scanner sc) {
		System.out.print("enter the SId : ");
		SId = sc.nextInt();
		System.out.print("enter the StudentName : ");
		StudentName = sc.next();
		sc.nextLine();
		System.out.print("enter the MobileNo : ");
		MobileNo = sc.next();
		sc.nextLine();
		System.out.print("enter branch : ");
		Branch = sc.next();
		sc.nextLine();
		System.out.print("enter city name : ");
		City = sc.next();
	}

	public static void delete(Scanner sc) {
		System.out.print("enter student id : ");
		SId = sc.nextInt();
	}

	public static void update(Scanner sc) {
		System.out.print("enter student id : ");
		SId = sc.nextInt();
		System.out.println("enter the student name : ");
		StudentName = sc.next();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the operation you want : ");
		int operation = sc.nextInt();
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root";
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Statement st = null;
		do {
			switch (operation) {
			case 1:
				System.out.println("insert the data in table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					insert(sc);
					pstm = con.prepareStatement(
							"insert into students (SId,StudentName,MobileNo,Branch,City) values (?,?,?,?,?)");
					pstm.setInt(1, SId);
					pstm.setString(2, StudentName);
					pstm.setString(3, MobileNo);
					pstm.setString(4, Branch);
					pstm.setString(5, City);
					int res = pstm.executeUpdate();
					if (res > 0) {
						System.out.println("data inserted successfully....");
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}

				break;

			case 2:
				System.out.println("delete data from table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					delete(sc);
					pstm = con.prepareStatement("delete from students where Sid=?");
					pstm.setInt(1, SId);
					int res = pstm.executeUpdate();
					System.out.println("data deleted successfully....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 3:
				System.out.println("update data in table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					update(sc);
					pstm = con.prepareStatement("update students set StudentName=? where SId =? ");
					pstm.setInt(1, SId);
					pstm.setString(2, StudentName);
					int res = pstm.executeUpdate();
					System.out.println("data updated successfully....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 4:
				System.out.println("showing all data from table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					st = con.createStatement();
					rs = st.executeQuery("select * from students");
					while (rs.next()) {
						System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
								+ rs.getString(4) + " " + rs.getString(5));
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 5:
				System.out.println("exit");
				break;

			default:
				break;
			}
			System.out.print("Enter the operation you want : ");
			operation = sc.nextInt();
		} while (operation != 5);
	}

}
