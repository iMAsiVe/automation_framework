import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {
	static FrameworkProperties frameworkProperties;
	static WebDriver driver;
	static HomePage homePage;
	static SignInPage signInPage;
	static CheckoutPage checkoutPage;

	@BeforeClass
	public static void initializeObjects() {
		frameworkProperties = new FrameworkProperties();
		DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
		driver = DriverSingleton.getDriver();
		homePage = new HomePage();
		signInPage = new SignInPage();
		checkoutPage = new CheckoutPage();
	}

	@Test
	public void test02TestingAuthentication() {
		driver.get(Constants.URL);
		homePage.clickSignIn();
		signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL),
				frameworkProperties.getProperty(Constants.PASSWORD));
		assertEquals(frameworkProperties.getProperty(Constants.USERNAME), homePage.getUserName());
	}

//	@Test
//	public void test01TestingAddingThingsToCart() {
//		driver.get(Constants.URL);
//		homePage.addFirstElementToCart();
//		homePage.addSecondElemenetToCart();
//		assertEquals(Constants.CART_QUANTITY_TEST, checkoutPage.getSummaryProductsString());
//	}
//
//	@Test
//	public void test03TestingFullBuyingProcess() {
//		driver.get(Constants.URL);
//		homePage.addFirstElementToCart();
//		homePage.addSecondElemenetToCart();
//		checkoutPage.gotToCheckOut();
//		checkoutPage.confirmAdress();
//		checkoutPage.confirmShipping();
//		checkoutPage.payByBankWire();
//		checkoutPage.confirmFinalOrder();
//		assertEquals(true, checkoutPage.checkFinalStatus());
//	}

	@AfterClass
	public static void closeObjects() {
		driver.close();
	}

}
