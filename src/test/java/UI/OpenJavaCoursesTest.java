package UI;

import org.testng.annotations.Test;

import static common.Config.SELENIUM_EASY_HOME_URL;

public class OpenJavaCoursesTest extends BaseUITest {

    @Test
    public void checkIsRedirectToJavaCourses(){
        basePage.open(SELENIUM_EASY_HOME_URL);
        seleniumEasyHomePage.openJavaGuide();
        javaTutorialsPage.ReadTopic();
    }

}
