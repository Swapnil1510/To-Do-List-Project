import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertElement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "root");
			Statement st = con.createStatement();
			st.executeUpdate(
					"insert into students(SId,StudentName,MobileNo,Branch,City) values (9,'Vicky Kumar','8675345967','CSE','Nalanda')");

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
