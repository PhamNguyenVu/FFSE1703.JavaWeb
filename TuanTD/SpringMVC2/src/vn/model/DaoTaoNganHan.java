package vn.model;

import org.springframework.stereotype.Component;

@Component
public class DaoTaoNganHan implements HeDaoTao{
	public String heDaoTao() {
		return "Trong Vòng 6 tháng,mời bạn đi học buổi tối từ 18h30 đến 21h30";
	}
}
