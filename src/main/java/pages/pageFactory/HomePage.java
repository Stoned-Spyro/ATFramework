package pages.pageFactory;

import common.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.Config.SELENIUM_EASY_HOME_URL;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"edit-search-block-form--2\"]")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"search-block-form\"]/div/div/div[1]/span/button")
    private WebElement searchSubmitButton;


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
