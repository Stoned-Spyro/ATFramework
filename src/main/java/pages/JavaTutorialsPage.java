package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaTutorialsPage extends  BasePage{

    public JavaTutorialsPage(WebDriver driver){
        super(driver);
    }

    private final By ReadMoreButton = By.xpath("//*[@id=\"node-293\"]/footer/ul/li[1]/a");

    public JavaTutorialsPage ReadTopic(){
        driver.findElement(ReadMoreButton).click();
        return this;
    }
}
