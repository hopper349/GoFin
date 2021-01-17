package PageLocators;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditDebitCardPage extends Base {
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
        return CreditDebitCardText;
    }
    public WebElement getCardNumberField(){
        return CardNumberField;
    }
    public WebElement getExpiryDateField(){
        return ExpiryDateField;
    }
    public WebElement getCVVField(){
        return CVVField;
    }
    public WebElement getEmailField(){
        return EmailField;
    }
    public WebElement getPhoneNumberField(){
        return PhoneNumberField;
    }
    public WebElement getPayNowBtn(){
        return PayNowBtn;
    }
}
