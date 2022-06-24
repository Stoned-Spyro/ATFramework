package pages.pageFactory;

import Wrappers.CustomButton;
import Wrappers.CustomDecorator;
import Wrappers.ImputElement;
import common.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.Config.SELENIUM_EASY_HOME_URL;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(new CustomDecorator(DriverFactory.getDriver()), this);
    }

    @FindBy(xpath = "//*[@id=\"edit-search-block-form--2\"]")
    private ImputElement searchField;

    @FindBy(xpath = "//*[@id=\"search-block-form\"]/div/div/div[1]/span/button")
    private CustomButton searchSubmitButton;


    public HomePage openWebPage(){
        DriverFactory.getDriver().get(SELENIUM_EASY_HOME_URL);
        return this;
    }

    public HomePage searchTopic(String searchValue){
        searchField.sendKeys(searchValue);
        searchSubmitButton.click();
        return this;
    }

}
