package PageLocators;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionStatusPage extends TestBase {

    WebDriver driver;

    public TransactionStatusPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[contains(@src,'https://app.sandbox.midtrans.co')]")
    private WebElement Frame;

    @FindBy(xpath = "//span[text()='Transaction failed']")
    private WebElement TransactionFailedMessage;

    @FindBy(xpath = "//span[text()='Use Another Payment Options']/../..")
    private WebElement UseAnotherPaymentOptionsBtn;


    public WebElement getFrame(){
        return Frame;
    }
    public WebElement getTransactionFailedMessage(){
        return TransactionFailedMessage;
    }
    public WebElement getUseAnotherPaymentOptionsBtn(){
        return UseAnotherPaymentOptionsBtn;
    }


}
