package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;


public class WebDriverManager {

    public static WebDriver setupChrome(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver setupOpera(){
        System.setProperty("webdriver.opera.driver", "drivers/operadriver.exe");
        WebDriver driver = new OperaDriver();
        return driver;
    }
}
