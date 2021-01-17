package PageLocators;

import Base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.naming.Name;

public class ShoppingCart extends Base {
    WebDriver driver;


    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='Midtrans Pillow']/following-sibling::td[2]")
    private WebElement AmountField;

    @FindBy(xpath = "//td[text()='Name']/following-sibling::td[1]")
    private WebElement NameField;

    @FindBy(xpath = "//td[text()='Email']/following-sibling::td[1]")
    private WebElement EmailField;

    @FindBy(xpath = "//td[text()='Phone no']/following-sibling::td[1]")
    private WebElement PhoneNoField;

    @FindBy(xpath = "//td[text()='City']/following-sibling::td[1]")
    private WebElement CityField;

    @FindBy(xpath = "//td[text()='Address']/following-sibling::td[1]")
    private WebElement AddressField;

    @FindBy(xpath = "//td[text()='Postal Code']/following-sibling::td[1]")
    private WebElement PostalCodeField;

    @FindBy(xpath = "//div[@class='cart-checkout' and text()='CHECKOUT']")
    private WebElement CheckoutBtn;

    //Below are the methods to return WebElements

    public WebElement getAmountField(){
        return AmountField;
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
    public WebElement getCityField(){
        return CityField;
    }
    public WebElement getAddressField(){
        return AddressField;
    }
    public WebElement getPostalCodeField(){
        return PostalCodeField;
    }
    public WebElement getCheckoutBtn(){
        return CheckoutBtn;
    }

}
