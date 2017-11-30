package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import configruration.ResourceHasMap;
import objects.LoginPage;
import supports.CommonFunctions;

public class LoginFunctions extends LoginPage{
	private ResourceHasMap sResource = new ResourceHasMap();
	
	public LoginFunctions(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String password) {
		txt_Email.clear();
		txt_Email.sendKeys(email);
		txt_Password.clear();
		txt_Password.sendKeys(password);
		btn_Submit.click();
	}
	
	public void changePassword(String oldPass, String newPass, String confirmPass) {
		lnk_ChangePassword.click();
		txt_OldPass.clear();
		txt_OldPass.sendKeys(oldPass); 
		txt_NewPassword.clear();
		txt_NewPassword.sendKeys(newPass); 
		txt_ConfirmNewPassword.clear();
		txt_ConfirmNewPassword.sendKeys(confirmPass); 
		btn_Submit.click();
	}
	
	public void logout(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelectorAll('.nav li a')[6].click();");
		CommonFunctions.pause(1);
		Assert.assertEquals(driver.getTitle(), "Login");
	}
	
	public void checkMessageNull(WebDriver driver, String textbox, String id, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strPass = js.executeScript("return document.getElementById('" + id + "').innerText;").toString();
		if(textbox.equals("") || textbox.equals(" ")) {
			Assert.assertEquals(value, strPass);
		}
	}
	
	public void checkEmailNull(WebDriver driver, String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strEmail = js.executeScript("return document.querySelector('.inner-addon span.field-validation-error').innerText;").toString();
		if (email.equals(" ") || email.equals("")) {
			if(!password.equals(" ")) {
				Assert.assertEquals(sResource.getResource("emailnull"), strEmail);
			}
		}
	}
	
	public void checkPassNull(WebDriver driver, String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String strPass = js.executeScript("return document.querySelector('.inner-addon span.field-validation-error').innerText;").toString();
		if (!email.equals(" ") || !email.equals(" ")) {
			if(!password.equals(" ")) {
				Assert.assertEquals(sResource.getResource("passwordnull"), strPass);
			}
		}
	}
	
	public void checkWrongAccount(WebDriver driver) {
		try {   
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String strMess = js.executeScript("return document.querySelector('.alert.alert-danger').innerText;").toString();
			strMess = strMess.substring(2, strMess.length());
			Assert.assertEquals(sResource.getResource("wrongaccount"), strMess);
		} catch (Exception e) {	
			CommonFunctions.pause(2);
			String strTitle = driver.getTitle();
			Assert.assertEquals(strTitle, sResource.getResource("infobasic"));
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
		Assert.assertEquals(sResource.getResource("updatesuccess"), lbl_UpdateSuccess.getText());
		//check username
		String strTitleName = fName + " " + lName;
		Assert.assertEquals(lbl_UserTitleName.getText(), strTitleName);
		
	}
	
	public void clickForgotPassWord() {//WebDriver driver
		hpl_forgotPass.click();
	}
	
	public void forgotPassword(WebDriver driver, String email) {
		Assert.assertEquals(sResource.getResource("forgotpass"), driver.getTitle());	
		txt_Email.clear();
		txt_Email.sendKeys(email); 		
		btn_Submit.click();
	}
	
	public void checkMesageGetPass(WebDriver driver, String email) {
		email = CommonFunctions.chuanHoa(email);
		if(email.equals("") || email.equals(" ")) {		
			Assert.assertEquals(sResource.getResource("inputmail"), lbl_EmailNull.getText());
		} else if(!email.equals("")) {
			try {
				String _messEmail = driver.findElement(By.xpath(".//div[@class='mess-box']")).getText();
				String strMessNotFoundEmail = sResource.getResource("notfoundmail") + email + sResource.getResource("insystem");
				String strMessSuccess = sResource.getResource("messsentmail") + email + sResource.getResource("messcheckmail");
				if(_messEmail.equalsIgnoreCase(strMessNotFoundEmail)){
					Assert.assertEquals(strMessNotFoundEmail, _messEmail);
				} else {
					Assert.assertEquals(strMessSuccess, _messEmail);
				}
			} catch (Exception e) {
				if (lbl_EmailNull.getText().equalsIgnoreCase(sResource.getResource("wrongformatemail"))) {
					Assert.assertEquals(sResource.getResource("wrongformatemail"), lbl_EmailNull.getText()); 
				} else {
					Assert.assertEquals(0,1);  
				}
			}
		}	
	}
}
