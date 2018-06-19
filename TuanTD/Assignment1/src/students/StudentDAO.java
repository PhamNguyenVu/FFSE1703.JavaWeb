package students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	Connection conn = (Connection) ConnectDB.getConnect(); // <--Kết nối database-->
	double total;

	public boolean insertStudent(Student student) throws SQLException {
		String sql = "INSERT INTO student (Name, Class, Address, Age, Author, Diemlp1, Diemlp2) VALUES (?, ?, ?, ?, ?,?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, student.getName());
		statement.setString(2, student.getClas());
		statement.setString(3, student.getAddress());
		statement.setInt(4, student.getAge());
		statement.setInt(5, student.getAuthor());
		statement.setString(6, String.valueOf(student.getDiemLp1()));
		statement.setString(7, String.valueOf(student.getDiemLp2()));

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		return rowInserted;
	}

	public List<Student> listAllStudents(int start, int end) throws SQLException {
		List<Student> listStudent = new ArrayList<>();
		
		String sql = "SELECT * FROM `student` limit ?,?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, start);
		ps.setInt(2, end);
		ResultSet resultSet=ps.executeQuery();

		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("Name");
			String clas = resultSet.getString("Class");
			String address = resultSet.getString("Address");
			int age = resultSet.getInt("Age");
			int author = resultSet.getInt("Author");
			double diemlp1 = Double.parseDouble(resultSet.getString("Diemlp1"));
			double diemlp2 = Double.parseDouble(resultSet.getString("Diemlp2"));

			Student student = new Student(id, name, clas, address, age, author,diemlp1,diemlp2);
			listStudent.add(student);
		}

		resultSet.close();
		ps.close();

		return listStudent;
	}

	public boolean deleteStudent(Student student) throws SQLException {
		String sql = "DELETE FROM `student` WHERE id=?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, student.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		return rowDeleted;
	}

	public boolean updateStudent(Student student) throws SQLException {
		String sql = "UPDATE `student` SET `Name`=?,`Class`=?,`Address`=?,`Age`=?,`Author`=?, `Diemlp1`=?, `Diemlp2`=?";
		sql += " WHERE id = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, student.getName());
		statement.setString(2, student.getClas());
		statement.setString(3, student.getAddress());
		statement.setInt(4, student.getAge());
		statement.setInt(5, student.getAuthor());
		statement.setString(6, String.valueOf(student.getDiemLp1()));
		statement.setString(7, String.valueOf(student.getDiemLp2()));
		statement.setInt(8, student.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		return rowUpdated;
	}

	public Student getStudent(int id) throws SQLException {
		Student student = null;
		String sql = "SELECT * FROM student WHERE id = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String name = resultSet.getString("Name");
			String clas = resultSet.getString("Class");
			String address = resultSet.getString("Address");
			int age = resultSet.getInt("Age");
			int author = resultSet.getInt("Author");
			double diemlp1 = Double.parseDouble(resultSet.getString("Diemlp1"));
			double diemlp2 = Double.parseDouble(resultSet.getString("Diemlp2"));

			student = new Student(id, name, clas, address, age, author, diemlp1, diemlp2);
		}

		resultSet.close();
		statement.close();

		return student;
	}
	
	public double countSinhVien() {
		try {
			String sql = "select count(*) from student";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				total = result.getDouble("COUNT(*)");
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return total;
	}
}