package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TopicCommentPage extends BasePage {

    public TopicCommentPage(WebDriver driver){
        super(driver);
    }

    private final By comment = By.xpath("//*[@id=\"comments\"]/div");

    public TopicCommentPage CountComments(){
        int countComments = driver.findElements(comment).size();
        Assert.assertEquals(countComments, 7);
        return this;
    }
}
