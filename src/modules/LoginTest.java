package modules;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import configruration.ResourceHasMap;
import libraries.LoginFunctions;
import support.CommonFunctions;

public class LoginTest {

	public static WebDriver driver; 	
	ResourceHasMap resource = new ResourceHasMap();
	LoginFunctions login;
	String strUrl;
	
	@Test
	private void login001_CheckUrl() {
		strUrl = driver.getCurrentUrl();
		strUrl = CommonFunctions.chuyenDoiKyTu(strUrl, "dang-nhap", "");
		driver.navigate().to(strUrl + resource.getResource("urlaccount"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urlchangepass"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urlupdateavatar"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urlsession"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urladress"));
		Assert.assertEquals(driver.getTitle(), "Login");
	}	
	
	@Test(dataProvider = "listUserAccount")
	private void login002_Login(String email, String password) {		
		login.login(driver, email, password); 		
		if(email == " " && password != " ")
			login.checkEmailNull(driver, email, password);
		if(email != " " && password == " ")
			login.checkPassNull(driver, email, password);
		if(email != " " && password != " ")
			login.checkWrongAccount(driver, email, password);			 
	}
	
	@Test(dataProvider = "listUserInfo")
	private void login003_UpdateInfo(String fName, String lName, String gender, String day, String month, String year, String text) {
		String time = new SimpleDateFormat("yyMMdd_HHmmss").format(Calendar.getInstance().getTime());getClass();

		String strTitle = driver.getTitle();
		if(strTitle.equalsIgnoreCase(resource.getResource("infobasic"))) {
			login.updateUserInfo(driver, fName + time, lName + time,  gender, day, month, year, text  + time);			
		} else { // link from other page
			driver.navigate().to(strUrl + resource.getResource("urlaccount"));
			login.updateUserInfo(driver, fName + time, lName + time,  gender, day, month, year, text + time);
		}
	}
	
	@Test(dataProvider = "listChangePass")
	private void login004_ChangePassword(String oldPass, String newPass, String confirmPass) {
		login.changePassword(driver, oldPass, newPass, confirmPass);
		if(newPass != confirmPass) {
			login.checkMessageNull(driver, confirmPass, "ConfirmNewPassword-error", resource.getResource("confirmpassnull"));
		} else {
			if(oldPass == "") {
				login.checkMessageNull(driver, oldPass, "OldPassword-error", resource.getResource("oldpassnull"));
			} if(newPass == "") {
				login.checkMessageNull(driver, newPass, "NewPassword-error", resource.getResource("newpassnull"));
			} if(confirmPass == "") {
				login.checkMessageNull(driver, confirmPass, "ConfirmNewPassword-error", resource.getResource("confirmpassnull"));
			}
		}
	}

	@DataProvider
	public Object[][] listUserAccount() {
		return new Object[][] { 
			new Object[] { " ", " " },
			new Object[] { " ", "123123" }, 
			new Object[] { "tai.kha", " " },
			new Object[] { "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", 
					"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" }, 
			//new Object[] { "!@#$%^&*()-=_+[]|;',./<>?", "!@#$%^&*()-=_+[]|;',./<>?" }, 
			new Object[] { "khangnghiatai@gmail.com", "123456" }, 
		};
	}

	@DataProvider
	public Object[][] listUserInfo() {
		return new Object[][] { 
			new Object[] { "firstName 1", "lastName 1", resource.getResource("male"), "1", "1", "1990", "text area 1" },
			new Object[] { "firstName 2", "lastName 2", resource.getResource("female"), "2", "2", "1992", "text area 2" },		
		};
	}
	
	@DataProvider
	public Object[][] listChangePass() {
		return new Object[][] { 
			new Object[] { "", "", "" },
			new Object[] { "123456", "", "" },
			new Object[] { "", "123123", "123456" },
			new Object[] { "123456", "", "123123" },
			new Object[] { "123456", "123123", "" },
			new Object[] { "123456", "123123", "123123" },
			new Object[] { "123123", "123456", "123456" },		
		};
	}
	
	@Parameters({ "BROWSER", "URL" })
	@BeforeTest
	public void beforeClass(String BROWSER, String URL) throws MalformedURLException {
		driver = CommonFunctions.getBrowser(BROWSER);
		CommonFunctions.visit(driver, URL);
		login = new LoginFunctions(driver);
		strUrl = URL;
	}	
	
	@AfterTest
	public void afterClass() {
		driver.quit();
	}
}
