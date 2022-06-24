package Wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public abstract class CustomElement {
    protected WebElement webElement;

    public CustomElement(WebElement webElement) {
        this.webElement = webElement;
    }

    public WebElement getWebElement(){
        return webElement;
    }
    public void setWebElement(){
        this.webElement=webElement;
    }
}
