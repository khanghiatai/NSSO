package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

	public WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	public WebElement txt_Email;
	
	@FindBy(id = "Password")
	public WebElement txt_Password;
	
	@FindBy(id = "bt_submit")
	public WebElement btn_Submit;
}
