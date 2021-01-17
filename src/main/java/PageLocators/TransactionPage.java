package PageLocators;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage extends Base {
    WebDriver driver;


    public TransactionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[text()='Issuing Bank']")
    private WebElement IssuingBankHeader;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement PasswordField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement OkBtn;


    //Below are the methods to return WebElements

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
