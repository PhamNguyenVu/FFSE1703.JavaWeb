package assignment5.entity;

import javax.validation.constraints.NotEmpty;

public class SinhVien {
	@NotEmpty(message= "nha ten")
	private String name;
	private String sex,email,phone,adress,classes;
	private int year,id;
	private String hinhAnh;
	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SinhVien() {
		
	}
	
	public SinhVien(int id,String name,int year,String sex,String email,String phone,String adress,String classes) {
		this.id = id;
		this.name = name;
		this.year = year;
		this.sex = sex;
		this.email = email;
		this.phone = phone;
		this.adress = adress;
		this.classes = classes;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
}
