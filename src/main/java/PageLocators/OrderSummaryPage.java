package PageLocators;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends Base {

    WebDriver driver;


    public OrderSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Order Summary']")
    private WebElement OrderSummaryText;

    @FindBy(xpath = "//span[text()='amount']/../../div[2]/span[@class='text-amount-amount']")
    private WebElement AmountField;

    @FindBy(xpath = "//span[text()='shipping details']/..")
    private WebElement ShippingDetailsTab;

}
