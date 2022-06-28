import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {

	public static void main(String[] args) {
		FrameworkProperties frameworkProperties = new FrameworkProperties();
		DriverSingleton driverSingleton = DriverSingleton
				.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		WebDriver driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);

		HomePage homePage = new HomePage();
		homePage.addFirstElementToCart();
		homePage.addSecondElemenetToCart();

		CheckoutPage checkoutPage = new CheckoutPage();
		checkoutPage.gotToCheckOut();

		SignInPage signInPage = new SignInPage();
		signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL),
				frameworkProperties.getProperty(Constants.PASSWORD));

		checkoutPage.confirmAdress();
		checkoutPage.confirmShipping();
		checkoutPage.payByBankWire();
		checkoutPage.confirmFinalOrder();
		if (checkoutPage.checkFinalStatus())
			System.out.println("Test case completed!");
	}

}
