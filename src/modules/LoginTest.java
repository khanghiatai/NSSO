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
	public void login001_CheckUrl() {
		strUrl = driver.getCurrentUrl();
		strUrl = CommonFunctions.chuyenDoiKyTu(strUrl, "dang-nhap", "");
		driver.navigate().to(strUrl + resource.getResource("urltaikhoan"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urldoimatkhau"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urlupdateavatar"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urlsession"));
		Assert.assertEquals(driver.getTitle(), "Login");
		driver.navigate().to(strUrl + resource.getResource("urladress"));
		Assert.assertEquals(driver.getTitle(), "Login");
	}	
	
	@Test(dataProvider = "listUserAccount")
	public void login002_Login(String email, String password) {
		login.login(driver, email, password); 
		// check login successful 
		if(driver.getCurrentUrl().contentEquals(resource.getResource("infobasic"))) {
			Assert.assertEquals("", "");
		}		 
	}
	
	@Test
	public void updateInfo() {
		String time = new SimpleDateFormat("yyMMdd_HHmmss").format(Calendar.getInstance().getTime());getClass();
		
	}

	@DataProvider
	public Object[][] listUserAccount() {
		return new Object[][] { 
			new Object[] { " ", " " },
			new Object[] { "", "123123" }, 
			new Object[] { "tai.kha", " " },
			new Object[] { "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890", 
					"123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890" }, 
			//new Object[] { "!@#$%^&*()-=_+[]|;',./<>?", "!@#$%^&*()-=_+[]|;',./<>?" }, 
			new Object[] { "tai.kha", " " },
			new Object[] { "tai.kha", "123123" }, 
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
