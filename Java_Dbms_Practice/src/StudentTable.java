import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentTable {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "root";
		ArrayList<Student> studentList = new ArrayList<Student>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from students");
			while (rs.next()) {
				Student s = new Student();
				s.setSid(rs.getInt(1));
				s.setStudentName(rs.getString(2));
				s.setMobileNo(rs.getString(3));
				s.setBranch(rs.getString(4));
				s.setCity(rs.getString(5));
				studentList.add(s);
				/*
				 * System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +
				 * rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5));
				 */
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		// print list
		
		for (Student obj : studentList) {
			if(obj.getSid()>5) {
			System.out.println(obj.getSid() + " " + obj.getStudentName() + " " + obj.getMobileNo() + " "
					+ obj.getBranch() + " " + obj.getCity());
		}
		}

	}

}
