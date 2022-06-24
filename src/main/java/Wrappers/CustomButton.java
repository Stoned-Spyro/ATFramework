package Wrappers;

import org.openqa.selenium.WebElement;


public class CustomButton extends CustomElement{

    public CustomButton(WebElement webElement) {
        super(webElement);
    }

    public void click(){
        getWebElement().click();
    }

}
