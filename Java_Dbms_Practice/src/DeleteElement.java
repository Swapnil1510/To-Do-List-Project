import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteElement {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","root");
			Statement st = con.createStatement();
			st.executeUpdate("Delete from students where SId=9");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
