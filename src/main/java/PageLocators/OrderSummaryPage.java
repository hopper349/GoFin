package PageLocators;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage extends TestBase {

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

    @FindBy(xpath = "//div[text()='Name']/following-sibling::div")
    private WebElement NameField;

    @FindBy(xpath = "//td[text()='Email']/following-sibling::div")
    private WebElement EmailField;

    @FindBy(xpath = "//td[text()='Phone number']/following-sibling::div")
    private WebElement PhoneNoField;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::div")
    private WebElement AddressField;

    @FindBy(xpath = "//span[text()='Continue']/../..")
    private WebElement ContinueBtn;

    @FindBy(xpath = "//iframe[@id='snap-midtrans']")
    private WebElement Frame;

    //Below are the methods to return WebElements

    public WebElement getFrame(){
        return Frame;
    }
    public WebElement getOrderSummaryText(){
        return OrderSummaryText;
    }
    public WebElement getAmountField(){
        return AmountField;
    }
    public WebElement getShippingDetailsTab(){
        return ShippingDetailsTab;
    }
    public WebElement getNameField(){
        return NameField;
    }
    public WebElement getEmailField(){
        return EmailField;
    }
    public WebElement getPhoneNoField(){
        return PhoneNoField;
    }
    public WebElement getAddressField(){
        return AddressField;
    }
    public WebElement getContinueBtn(){
        return ContinueBtn;
    }


}
