package pages.pageFactory;

import common.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopicPage {

    @FindBy(xpath = "//*[@class=\"section-title\"]")
    private WebElement title;

    public TopicPage() {
            PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public boolean isOpen(){
        return title.isDisplayed();
    }

}
