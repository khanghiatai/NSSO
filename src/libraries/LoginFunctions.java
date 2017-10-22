package libraries;

import org.openqa.selenium.WebDriver;

import objects.LoginPage;

public class LoginFunctions extends LoginPage{

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
}
