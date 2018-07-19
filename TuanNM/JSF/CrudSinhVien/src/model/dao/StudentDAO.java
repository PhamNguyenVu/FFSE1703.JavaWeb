package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import model.bean.Student;
import model.bean.StudentBean;

public class StudentDAO {
	final static Connection conn = ConnectDB.getConnect("localhost", "java-web", "tuan180899", "tuan123456");

	public static ArrayList<Student> getStudentList(int start, int total) {
		ArrayList<Student> arrSt = new ArrayList<Student>();
		try {
			String sql = "select * from student LIMIT " + start + "," + total + "";

			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt("id"));
				st.setFirstName(rs.getString("first_name"));
				st.setLastName(rs.getString("last_name"));
				st.setBirthYear(rs.getString("birth_yaer"));
				st.setGender(rs.getString("gender"));
				st.setEmail(rs.getString("email"));
				st.setDiaChi(rs.getString("address"));
				st.setSdt(rs.getString("sdt"));
				st.setClassSv(rs.getString("class"));
				arrSt.add(st);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrSt;
	}

	public static int totalStudent() {
		try {
			int total = 0;
			String sql = "select COUNT(*) from Student";
			Statement statement;

			statement = (Statement) conn.createStatement();

			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt("COUNT(*)");
			}
			return total;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return 0;
	}
	public static String deleteStudent(int id) throws SQLException {

		
			String sql = "DELETE FROM Student WHERE id = ?";
			PreparedStatement statement =  conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();	
		return "index.xhtml?faces-redirect=true";
	}
	public static String insertStudent(Student st) throws SQLException {
		String  redirect= "";
		String sql = "INSERT INTO Student(first_name, last_name,birth_yaer, gender, email, sdt, class, address) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement statement =  conn.prepareStatement(sql);
		statement.setString(1, st.getFirstName());
		statement.setString(2, st.getLastName());
		statement.setString(3, st.getBirthYear());
		statement.setString(4, st.getGender());
		statement.setString(5, st.getEmail());
		statement.setString(6, st.getSdt());
		statement.setString(7, st.getClassSv());
		statement.setString(8, st.getDiaChi());
		boolean rowInserted = statement.executeUpdate() > 0;
		if (rowInserted== true) {
			redirect = "index.xhtml?faces-redirect=true";
		}else {
			redirect = "InsertStudent.xhtml?faces-redirect=true";
		}
		
		return redirect;
	}
	public static String getStudent(int id) {
		Student st = null;
		 Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try {
			Statement statement = (Statement) conn.createStatement();
			String sql = "select * from Student where id = '" + id + "'";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				st = new Student();	
				st.setId(rs.getInt("id"));
				st.setFirstName(rs.getString("first_name"));
				st.setLastName(rs.getString("last_name"));
				st.setBirthYear(rs.getString("birth_yaer"));
				st.setGender(rs.getString("gender"));
				st.setEmail(rs.getString("email"));
				st.setDiaChi(rs.getString("address"));
				st.setSdt(rs.getString("sdt"));
				st.setClassSv(rs.getString("class"));
				sessionMapObj.put("student", st);

			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "updateStudent.xhtml?faces-redirect=true";
	}
	public static String editStudent(Student st) throws SQLException {
	
		String sql = "UPDATE `Student` SET `first_name`=?,`last_name`=?,`birth_yaer`=?,`gender`=?,`email`=?,`sdt`=?,`class`=?,`address`=? WHERE `id`=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, st.getFirstName());
		statement.setString(2, st.getLastName());
		statement.setString(3, st.getBirthYear());
		statement.setString(4, st.getGender());
		statement.setString(5, st.getEmail());
		statement.setString(6, st.getSdt());
		statement.setString(7, st.getClassSv());
		statement.setString(8, st.getDiaChi());
		statement.setInt(9, st.getId());
		statement.executeUpdate();

		return "index.xhtml?faces-redirect=true";
	}
	
}