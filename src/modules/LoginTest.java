package modules;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
	
	@Test(dataProvider = "listUserAccount")
	public void login(String email, String password) {
		login.login(driver, email, password); 
		// check login successful 
		if(driver.getCurrentUrl().contentEquals(resource.getResource("infobasic"))) {
			Assert.assertEquals("", "");
		}		 
	}

	@DataProvider
	public Object[][] listUserAccount() {
		return new Object[][] { new Object[] { "tai.kha", " " }, new Object[] { "tai.kha", "123123" }, };
	}

	@Parameters({ "BROWSER", "URL" })
	@BeforeClass
	public void beforeClass(String BROWSER, String URL) throws MalformedURLException {
		driver = CommonFunctions.getBrowser(BROWSER);
		CommonFunctions.visit(driver, URL);
		login = new LoginFunctions(driver);
	}

	@Test
	public void login001_CheckUrl() {
		strUrl = driver.getCurrentUrl();
		
		//driver.get("");
	}
	
	
	
	@AfterClass
	public void afterClass() {

	}
}
