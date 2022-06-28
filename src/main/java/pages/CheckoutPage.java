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

public class CheckoutPage {
	private WebDriver driver;

	public CheckoutPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "head > title")
	private WebElement pageTitle;

	@FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
	private WebElement checkOutButtonSummary;

	@FindBy(css = "#center_column > form > p > button > span")
	private WebElement checkOutButtonConfirmAdress;

	@FindBy(id = "cgv")
	private WebElement confirmShippingCheckBox;

	@FindBy(css = "#form > p > button > span")
	private WebElement checkOutButtonConfirmShipping;

	@FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
	private WebElement payByBankWireOption;

	@FindBy(css = "#cart_navigation > button > span")
	private WebElement confirmOrder;

	@FindBy(css = "#center_column > div > p")
	private WebElement orderConfirmationMessage;

	@FindBy(id = "summary_products_quantity")
	private WebElement summaryProducts;

	public Boolean checkTitle(String title) {
		return pageTitle.getText().equals(title);
	}

	public void gotToCheckOut() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButtonSummary));
		checkOutButtonSummary.click();
	}

	public void confirmAdress() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButtonConfirmAdress));
		checkOutButtonConfirmAdress.click();
	}

	public void confirmShipping() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(checkOutButtonConfirmShipping));
		confirmShippingCheckBox.click();
		checkOutButtonConfirmShipping.click();
	}

	public void payByBankWire() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(payByBankWireOption));
		payByBankWireOption.click();
	}

	public void confirmFinalOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
		confirmOrder.click();
	}

	public Boolean checkFinalStatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
		wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
		return orderConfirmationMessage.getText().equals(Constants.COMPLETE_ORDER);
	}

	public String getSummaryProductsString() {
		return summaryProducts.getText();
	}
}
