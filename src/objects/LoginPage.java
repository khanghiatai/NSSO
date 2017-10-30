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
	
	@FindBy(xpath = "//*[@id='bt_submit']")
	public WebElement btn_Submit;
	
	@FindBy(id = "FirstName")
	public WebElement txt_FirstName;
	
	@FindBy(id = "LastName")
	public WebElement txt_LastName;
	
	@FindBy(id = "Description")
	public WebElement txt_Description;
	
	@FindBy(id = "IsPrivate")
	public WebElement chk_IsPrivate;
	
	@FindBy(id = "IsMale")
	public WebElement ddl_IsMale;
	
	@FindBy(id = "DateOfBirthDay")
	public WebElement ddl_DateOfBirthDay;
	
	@FindBy(id = "DateOfBirthMonth")
	public WebElement ddl_DateOfBirthMonth;
	
	@FindBy(id = "DateOfBirthYear")
	public WebElement ddl_DateOfBirthYear;
	
	@FindBy(xpath = ".//*[@data-valmsg-for='Email']")
	public WebElement lbl_EmailNull;
	
	@FindBy(xpath = "//*[@id='Password-error']")
	public WebElement lbl_PasswordNull;
	
	@FindBy(xpath = "//*[@class='bs-example-bg-classes']")
	public WebElement lbl_UpdateSuccess;
	
	@FindBy(className = "profile-usertitle-name")
	public WebElement lbl_UserTitleName;
	
	@FindBy(name = "OldPassword")
	public WebElement txt_OldPass;
	
	@FindBy(name = "NewPassword")
	public WebElement txt_NewPassword;
	
	@FindBy(name = "ConfirmNewPassword")
	public WebElement txt_ConfirmNewPassword;
	
	@FindBy(id = "proChangePass")
	public WebElement lnk_ChangePassword;
}
