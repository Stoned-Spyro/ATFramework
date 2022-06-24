package UI;

import common.DriverFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.pageFactory.HomePage;
import pages.pageFactory.ResultsPage;

public class MultiThreadTest {
    @DataProvider
    public static Object[][] browserDataProvider(){
        return new Object[][]{
                {"chrome"},
                {"chrome"}
        };
    }

    @Test(dataProvider = "browserDataProvider")
    public static void searchTest(String browserName){
        DriverFactory.initDriver(browserName);
        System.out.println(browserName);
        HomePage homePage = new HomePage();
        ResultsPage resultsPage = new ResultsPage();

        homePage
                .openWebPage()
                .searchTopic("performance testing");

        resultsPage.redirect();

    }


}
