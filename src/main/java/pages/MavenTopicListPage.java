package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MavenTopicListPage extends BasePage{
    public MavenTopicListPage(WebDriver driver){
        super(driver);
    }

    private final By commentsButton = By.xpath("//*[@id=\"node-230\"]/footer/ul/li[2]/a");

    public MavenTopicListPage openTopicComments(){
        driver.findElement(commentsButton).click();
        return this;
    }
}
