package entity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc{
	public String mangSachDiHoc() {
		return "mang sách Toán đi học";
	}
}
