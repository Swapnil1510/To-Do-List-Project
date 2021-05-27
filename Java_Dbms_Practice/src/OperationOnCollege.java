import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationOnCollege {
	static int rollno;
	static String studentname;
	static String mobileno;
	static String branch;
	static String semester;

	public static void insert(Scanner sc) {
		System.out.print("enter roll no : ");
		rollno = sc.nextInt();
		System.out.print("enter student name : ");
		studentname = sc.next();
		sc.nextLine();
		System.out.print("enter student mobile no : ");
		mobileno = sc.next();
		sc.nextLine();
		System.out.print("enter branch name : ");
		branch = sc.next();
		sc.nextLine();
		System.out.print("enter semester : ");
		semester=sc.next();
	}

	public static void delete(Scanner sc) {
		System.out.print("enter roll no : ");
		rollno = sc.nextInt();
	}

	public static void update(Scanner sc) {
		System.out.print("enter roll no : ");
		rollno = sc.nextInt();
		System.out.print("enter student name : ");
		studentname = sc.next();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the operation you want : ");
		int operation = sc.nextInt();
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root";
		Connection con = null;
		PreparedStatement pstm = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<College> collegeList = new ArrayList<College>();
		do {
			switch (operation) {
			case 1:
				System.out.println("insert the data in the table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					insert(sc);
					pstm = con.prepareStatement(
							"insert into College (rollno,studentname,mobileno,branch,semester) values (?,?,?,?,?)");
					pstm.setInt(1, rollno);
					pstm.setString(2, studentname);
					pstm.setString(3, mobileno);
					pstm.setString(4, branch);
					pstm.setString(5, semester);
					int res = pstm.executeUpdate();
					if (res > 0) {
						System.out.println("data inserted successfuly.....");
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
					pstm = con.prepareStatement("delete from College where rollno=?");
					pstm.setInt(1, rollno);
					int res = pstm.executeUpdate();
					System.out.println("data delted successfully.....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 3:
				System.out.println("update data in the table : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					update(sc);
					pstm = con.prepareStatement("update College set studentname=? where rollno=?");
					pstm.setInt(1, rollno);
					pstm.setString(2, studentname);
					int res = pstm.executeUpdate();
					System.out.println("data updated successfully.....");
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				break;
			case 4:
				System.out.println("fetching all data from table College : ");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection(url, username, password);
					st = con.createStatement();
					rs = st.executeQuery("select * from College");
					while (rs.next()) {
						College c = new College();
						c.setRollno(rs.getInt(1));
						c.setStudentname(rs.getString(2));
						c.setMobileno(rs.getString(3));
						c.setBranch(rs.getString(4));
						c.setSemester(rs.getString(5));
						collegeList.add(c);
					}
					con.close();
				} catch (Exception e) {
					System.out.println(e);
				}
				for (College obj : collegeList) {
					System.out.println(obj.getRollno() + " " + obj.getStudentname() + " " + obj.getMobileno() + " "
							+ obj.getBranch() + " " + obj.getSemester());
				}
			default:
				
				break;
			}
			System.out.print("enter the operation you want : ");
			operation = sc.nextInt();
		} while (operation != 5);
	}

}
