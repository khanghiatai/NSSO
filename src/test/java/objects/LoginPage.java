package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		//AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,100);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email")
	protected WebElement txt_Email;
	
	@FindBy(id = "Password")
	protected WebElement txt_Password;
	
	@FindBy(xpath = "//*[@id='bt_submit']")
	protected WebElement btn_Submit;
	
	@FindBy(id = "FirstName")
	protected WebElement txt_FirstName;
	
	@FindBy(id = "LastName")
	protected WebElement txt_LastName;
	
	@FindBy(id = "Description")
	protected WebElement txt_Description;
	
/*	@FindBy(id = "IsPrivate")
	protected WebElement chk_IsPrivate;*/
	
	@FindBy(id = "IsMale")
	protected WebElement ddl_IsMale;
	
	@FindBy(id = "DateOfBirthDay")
	protected WebElement ddl_DateOfBirthDay;
	
	@FindBy(id = "DateOfBirthMonth")
	protected WebElement ddl_DateOfBirthMonth;
	
	@FindBy(id = "DateOfBirthYear")
	protected WebElement ddl_DateOfBirthYear;
	
	@FindBy(xpath = ".//*[@data-valmsg-for='Email']")
	protected WebElement lbl_EmailNull;
	
/*	@FindBy(xpath = "//*[@id='Password-error']")
	protected WebElement lbl_PasswordNull;*/
	
	@FindBy(xpath = "//*[@class='bs-example-bg-classes']")
	protected WebElement lbl_UpdateSuccess;
	
	@FindBy(className = "profile-usertitle-name")
	protected WebElement lbl_UserTitleName;
	
	@FindBy(name = "OldPassword")
	protected WebElement txt_OldPass;
	
	@FindBy(name = "NewPassword")
	protected WebElement txt_NewPassword;
	
	@FindBy(name = "ConfirmNewPassword")
	protected WebElement txt_ConfirmNewPassword;
	
	@FindBy(id = "proChangePass")
	protected WebElement lnk_ChangePassword;
	
	@FindBy(id = "OldPassword-error")
	protected WebElement lbl_oldPassError;
	
	@FindBy(id = "NewPassword-error")
	protected WebElement lbl_NewPassError;
	
	@FindBy(xpath = ".//input[@id='RememberMe']/following-sibling::span/a")
	protected WebElement hpl_forgotPass;
	
}
