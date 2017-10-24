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
		//
		hm.put("male","Nam");
		hm.put("female", "Nữ");
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