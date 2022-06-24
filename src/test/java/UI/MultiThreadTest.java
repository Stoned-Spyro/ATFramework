package UI;

import common.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pageFactory.HomePage;
import pages.pageFactory.ResultsPage;
import pages.pageFactory.TopicPage;

public class MultiThreadTest {
    @DataProvider
    public static Object[][] browserDataProvider(){
        return new Object[][]{
               // {"chrome"},
                {"chrome"}
        };
    }

    @Test(dataProvider = "browserDataProvider")
    public static void searchTest(String browserName){
        DriverFactory.initDriver(browserName);
        System.out.println(browserName);
        HomePage homePage = new HomePage();
        ResultsPage resultsPage = new ResultsPage();
        TopicPage topicPage = new TopicPage();

        homePage
                .openWebPage()
                .searchTopic("performance testing");

        resultsPage.redirect();

        Assert.assertTrue(topicPage.isOpen());
    }


}
