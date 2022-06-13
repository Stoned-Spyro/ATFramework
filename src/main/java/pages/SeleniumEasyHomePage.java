package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumEasyHomePage extends BasePage{

    public SeleniumEasyHomePage(WebDriver driver){
        super(driver);
    }

    private final By currentOption = By.xpath("//*[@id=\"navbar-collapse\"]/nav/ul/li[2]/a");
    private final By currentPL = By.xpath("//*[@id=\"navbar-collapse\"]/nav/ul/li[2]/ul/li[1]/a");
    private final By searchField = By.xpath("//*[@id=\"edit-search-block-form--2\"]");
    private final By searchButtom = By.xpath("//*[@id=\"search-block-form\"]/div/div/div[1]/span/button");
    private final By mavenTopics = By.xpath("//*[@id=\"navbar-collapse\"]/nav/ul/li[4]/a");
    private final String searchingValue = "web testing";

    public SeleniumEasyHomePage openJavaGuide(){
        driver.findElement(currentOption).click();
        driver.findElement(currentPL).click();
        return this;
    }

    public SeleniumEasyHomePage openMavenTopic(){
        driver.findElement(mavenTopics).click();
        return this;
    }

    public SeleniumEasyHomePage searchGuide(){
        WebElement searchFieldElement = driver.findElement(searchField);
        searchFieldElement.sendKeys(searchingValue);
        driver.findElement(searchButtom).click();
        return this;
    }
}
