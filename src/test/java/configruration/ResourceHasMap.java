package configruration;

import java.util.HashMap;

//import java.awt.List;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;

public class ResourceHasMap {
	private HashMap<String, String> hm = new HashMap<String, String>();

	public ResourceHasMap() {
		SSOResource();		
		dayOffWeek();
	}
	
	private void SSOResource(){
		hm.put("infobasic", "Thông tin cơ bản");
		hm.put("urlaccount", "/tai-khoan");
		hm.put("urlchangepass", "/tai-khoan/doi-mat-khau");
		hm.put("urlupdateavatar", "/tai-khoan/doi-hinh-dai-dien");
		hm.put("urlsession", "/tai-khoan/quan-ly-phien-dang-nhap");
		hm.put("urladress", "/tai-khoan/quan-ly-dia-chi");
		hm.put("male","Nam");
		hm.put("female", "Nữ");
		hm.put("emailnull", "Vui lòng nhập username or email");
		hm.put("passwordnull", "Vui lòng nhập mật khẩu");
		//hm.put("wrongaccount", "Email hoặc Mật khẩu không chính xác!");
		hm.put("updatesuccess", "Cập nhật thành công!");
		hm.put("oldpassnull", "Nhập mật khẩu cũ");
		hm.put("newpassnull", "Nhập mật khẩu mới");
		hm.put("confirmpassnull", "Xác nhận mật khẩu mới");
		hm.put("forgotpass", "Forgot Password");
		hm.put("inputmail", "Vui lòng nhập email của bạn");
		hm.put("inputpass", "Vui lòng nhập mật khẩu đăng nhập");
		hm.put("notfoundmail", "Email sai định dạng");
		hm.put("insystem", "Email sai định dạng");
		hm.put("notfoundmail", "Không tìm thấy email ");
		hm.put("insystem", " trong hệ thống, vui lòng kiểm tra lại email đăng kí của bạn!");
		hm.put("wrongformatemail", "Email sai định dạng");
		hm.put("messsentmail", "Email hướng dẫn lấy lại mật khẩu đã được gửi tới ");
		hm.put("messcheckmail", ", vui lòng kiểm tra email để có hướng dẫn lấy lại mật khẩu");

	}
	
	private void dayOffWeek(){
		hm.put("mon", "Thứ hai");
		hm.put("tue", "Thứ ba");
		hm.put("web", "Thứ tư");
		hm.put("thu", "Thứ năm");
		hm.put("fri", "Thứ sáu");
		hm.put("sat", "Thứ bảy");
		hm.put("sun", "Chủ nhật");
		hm.put("lbl_Day", "ngày ");
		hm.put("lbl_Month", "tháng ");
		hm.put("lbl_Year", "năm ");
	}

	public String getResource(String key){
		return getHm().get(key);
	}

	public HashMap<String, String> getHm() {
		return hm;
	}

	public void setHm(HashMap<String, String> hm) {
		this.hm = hm;
	}
}
