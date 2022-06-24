package Wrappers;

import org.openqa.selenium.WebElement;

public class ImputElement extends CustomElement{

    public ImputElement(WebElement webElement) {
        super(webElement);
    }

    public void sendKeys(String searchValue) {
        System.out.println("input:"+searchValue);
        getWebElement().sendKeys(searchValue);
    }
}
