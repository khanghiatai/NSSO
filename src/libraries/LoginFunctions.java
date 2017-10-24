package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import objects.LoginPage;
import support.CommonFunctions;

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
	}
}
