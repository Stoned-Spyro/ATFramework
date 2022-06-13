package UI;

import common.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.*;

import static common.Config.CLEAR_COOKIES;
import static common.Config.KEEP_BROWSER_OPEN;

public class BaseUITest {
    protected WebDriver driver = BrowserFactory.createDriver("chrome");
    protected BasePage basePage = new BasePage(driver);
    protected SeleniumEasyHomePage seleniumEasyHomePage = new SeleniumEasyHomePage(driver);
    protected JavaTutorialsPage javaTutorialsPage = new JavaTutorialsPage(driver);
    protected TopicListPage topicListPage = new TopicListPage(driver);
    protected TopicCommentPage topicCommentPage = new TopicCommentPage(driver);
    protected MavenTopicListPage mavenTopicListPage = new MavenTopicListPage(driver);

    @AfterTest
    public void clearCookies(){
        if(CLEAR_COOKIES){
            driver.manage().deleteAllCookies();
        }
    }
    @AfterSuite(alwaysRun = true)
    public void close(){
        if(KEEP_BROWSER_OPEN){
            driver.quit();
        }
    }
}
