package bean;

import org.springframework.stereotype.Component;

@Component
public class MonHoa implements MonHoc {

	public String mangSachDiHoc() {
		return "Mang Sách Hóa Đi Học";
	}
	public String giangVien() {
		return "Giang Viên 1"; 
	}

}
