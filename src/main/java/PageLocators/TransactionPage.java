package PageLocators;

import Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage extends TestBase {
    WebDriver driver;


    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//iframe[contains(@src,'https://api.sandbox.veritrans.co')]")
    private WebElement Frame;

    @FindBy(xpath = "//h1[text()='Issuing Bank']")
    private WebElement IssuingBankHeader;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement PasswordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement OkBtn;


    //Below are the methods to return WebElements

    public WebElement getFrame(){
        return Frame;
    }
    public WebElement getIssuingBankHeader(){
        return IssuingBankHeader;
    }
    public WebElement getPasswordField(){
        return PasswordField;
    }
    public WebElement getOkBtn(){
        return OkBtn;
    }
}
