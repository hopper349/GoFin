package Utilities;

import Base.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestUtil extends Base {

    public static int PAGE_LOAD_TIMEOUT= 20;
    public static int IMPLICIT_WAIT= 20;


    public void ClearFieldAndProvideText(WebElement element, String textToBeEntered){
        element.clear();
        element.sendKeys(textToBeEntered);
    }
}
