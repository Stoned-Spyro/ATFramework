package UI;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static common.Config.SELENIUM_EASY_HOME_URL;

public class SearchWebTopicTest extends BaseUITest{

    @DataProvider
    private Object[][] SearchWebTopicDP(){
        return new Object[][]{
                {"web testing"}
        };
    }

    @Test(dataProvider = "SearchWebTopicDP")
    public void SearchWebTopic(String value){
        basePage.open(SELENIUM_EASY_HOME_URL);
        seleniumEasyHomePage.searchGuide(value);
        topicListPage.openTopic();
    }
}
