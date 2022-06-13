package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopicListPage extends BasePage{

    public TopicListPage(WebDriver driver){
        super(driver);
    }

    private final By link = By.xpath("/html/body/div[3]/div/section/ol/li[2]/h3/a");


    public TopicListPage openTopic(){
        driver.findElement(link).click();
        return this;
    }


}
