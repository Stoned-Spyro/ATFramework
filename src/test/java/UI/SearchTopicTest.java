package UI;

import org.testng.annotations.Test;


import static common.Config.SELENIUM_EASY_HOME_URL;

public class SearchTopicTest extends BaseUITest{
    @Test
    public void SearchTopic(){
        basePage.open(SELENIUM_EASY_HOME_URL);
        seleniumEasyHomePage.searchGuide();
        topicListPage.openTopic();
    }
}
