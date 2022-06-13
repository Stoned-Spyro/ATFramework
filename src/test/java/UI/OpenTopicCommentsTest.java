package UI;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.MavenTopicListPage;

import static common.Config.SELENIUM_EASY_HOME_URL;

public class OpenTopicCommentsTest extends BaseUITest {

    @Test
    public void ReadComments(){
        basePage.open(SELENIUM_EASY_HOME_URL);
        seleniumEasyHomePage.openMavenTopic();
        mavenTopicListPage.openTopicComments();
        topicCommentPage.CountComments();
    }
}
