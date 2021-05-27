import java.io.ObjectInputStream.GetField;

public class Student {

		private int sid;
		private String studentName;
		private String mobileNo;
		private String branch;
		private String city;
		
		public Student() {
			// TODO Auto-generated constructor stub
		}

		public Student(int sid, String studentName, String mobileNo, String branch, String city) {
			super();
			this.sid = sid;
			this.studentName = studentName;
			this.mobileNo = mobileNo;
			this.branch = branch;
			this.city = city;
		}

		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public String getStudentName() {
			return studentName;
		}

		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getBranch() {
			return branch;
		}

		public void setBranch(String branch) {
			this.branch = branch;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
}
