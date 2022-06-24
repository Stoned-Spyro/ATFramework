package pages.pageFactory;

import Wrappers.CustomButton;
import Wrappers.CustomDecorator;
import common.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static common.Config.SELENIUM_EASY_HOME_URL;

public class ResultsPage {

    public ResultsPage() {
        PageFactory.initElements(new CustomDecorator(DriverFactory.getDriver()), this);
    }

    @FindBy(xpath = "/html/body/div[3]/div/section/ol/li[4]/h3/a")
    private CustomButton topicButton;

    public ResultsPage redirect(){
        topicButton.click();
        return this;
    }

    public ResultsPage openWebPage(){
        DriverFactory.getDriver().get(SELENIUM_EASY_HOME_URL);
        return this;
    }
}
