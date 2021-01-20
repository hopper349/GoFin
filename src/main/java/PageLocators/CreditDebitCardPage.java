package PageLocators;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditDebitCardPage extends TestBase {
    WebDriver driver;


    public CreditDebitCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[text()='Credit/Debit Card']")
    private WebElement CreditDebitCardText;

    @FindBy(xpath = "//input[@name='cardnumber']")
    private WebElement CardNumberField;

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    private WebElement ExpiryDateField;
    @FindBy(xpath = "//label[text()='CVV']/../input")
    private WebElement CVVField;

    @FindBy(xpath = "//div[@class='card-container']//input[@type='email']")
    private WebElement EmailField;

    @FindBy(xpath = "//label[text()='Phone number']/../input")
    private WebElement PhoneNumberField;

    @FindBy(xpath = "//span[text()='Pay Now']/../..")
    private WebElement PayNowBtn;

    //Below are the methods to return WebElements

    public WebElement getCreditDebitCardText(){
        Log.info("Searching for Credit/Debit Card Text Message");
        return CreditDebitCardText;
    }
    public WebElement getCardNumberField(){
        Log.info("Searching for Card Number Field");
        return CardNumberField;
    }
    public WebElement getExpiryDateField(){
        Log.info("Searching for Expiry Date Field");
        return ExpiryDateField;
    }
    public WebElement getCVVField(){
        Log.info("Searching for CVV Field");
        return CVVField;
    }
    public WebElement getEmailField()
    {
        Log.info("Searching for Email Field");
        return EmailField;
    }
    public WebElement getPhoneNumberField(){
        Log.info("Searching for Phone Number Field");
        return PhoneNumberField;
    }
    public WebElement getPayNowBtn()
    {
        Log.info("Searching for Pay Now Button");
        return PayNowBtn;
    }
}
