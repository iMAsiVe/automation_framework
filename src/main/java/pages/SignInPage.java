package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;
import utils.Constants;
import utils.Utils;

public class SignInPage {
	private WebDriver driver;

	public SignInPage() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	private WebElement emailField;

	@FindBy(id = "passwd")
	private WebElement password;

	@FindBy(id = "SubmitLogin")
	private WebElement signInButton;

	@FindBy(id = "email_create")
	private WebElement emailSignUpField;

	@FindBy(id = "SubmitCreate ")
	private WebElement signUpButton;

	public void logIn(String email, String passwd) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		emailField.sendKeys(email);
		password.sendKeys(Utils.decode64(passwd));
		signInButton.click();
	}

	public void signUp(String email) {
		emailSignUpField.sendKeys(email);
		signUpButton.click();
	}

}
