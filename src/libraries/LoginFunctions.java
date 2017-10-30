package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import configruration.ResourceHasMap;
import objects.LoginPage;
import support.CommonFunctions;

public class LoginFunctions extends LoginPage{
	ResourceHasMap resource = new ResourceHasMap();
	
	public LoginFunctions(WebDriver driver) {
		super(driver);
	}

	public void login(WebDriver driver, String email, String password) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
		txt_Password.clear();
		txt_Password.sendKeys(password);
		btn_Submit.click();
	}
	
	public void changePassword(WebDriver driver, String oldPass, String newPass, String confirmPass) {
		lnk_ChangePassword.click();
		txt_OldPass.clear();
		txt_OldPass.sendKeys(oldPass); 
		txt_NewPassword.clear();
		txt_NewPassword.sendKeys(newPass); 
		txt_ConfirmNewPassword.clear();
		txt_ConfirmNewPassword.sendKeys(confirmPass); 
	}
	
	public boolean checkEmailNull(WebDriver driver, String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strEmail = js.executeScript("return document.querySelector('.inner-addon span.field-validation-error').innerText;").toString();
		if (email == " " || email == "") {
			if((password != " " || password != "")) {
				Assert.assertEquals(resource.getResource("emailnull"), strEmail);				
				return true;
			} else return false;				
		} else return false;				
	}
	
	public boolean checkPassNull(WebDriver driver, String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strPass = js.executeScript("return document.querySelector('.inner-addon span.field-validation-error').innerText;").toString();
		if (email != " " || email != "") {
			if((password == " " || password == "")) {
				Assert.assertEquals(resource.getResource("passwordnull"), strPass);				
				return true;
			} else return false;				
		} else return false;				
	}
	
	public void checkWrongAccount(WebDriver driver, String email, String password) {		
		try {   
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String strMess = js.executeScript("return document.querySelector('.alert.alert-danger').innerText;").toString();
			strMess = strMess.substring(2, strMess.length());
			Assert.assertEquals(resource.getResource("wrongaccount"), strMess);
		} catch (Exception e) {	
			CommonFunctions.pause(1);
			String strTitle = driver.getTitle();
			Assert.assertEquals(strTitle, resource.getResource("infobasic"));
		}		
	}
	
	public void updateUserInfo(WebDriver driver, String fName, String lName, String gender, String day, String month, String year, String text) {
		txt_FirstName.clear();
		txt_FirstName.sendKeys(fName);
		txt_LastName.clear();
		txt_LastName.sendKeys(lName);
		CommonFunctions.selectedByText(ddl_IsMale, gender);
		CommonFunctions.selectedByText(ddl_DateOfBirthDay, day);
		CommonFunctions.selectedByText(ddl_DateOfBirthMonth, month);
		CommonFunctions.selectedByText(ddl_DateOfBirthYear, year);
		txt_Description.clear();
		txt_Description.sendKeys(text);
		// click submit & check message
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('bt_submit').click();");
		Assert.assertEquals(resource.getResource("updatesuccess"), lbl_UpdateSuccess.getText());
		//check username
		String strTitleName = fName + " " + lName;
		Assert.assertEquals(lbl_UserTitleName.getText(), strTitleName);
		
	}
}
