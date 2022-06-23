package common;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


import static constants.TimeoutConstants.IMPLICIT_WAIT;


public class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER_INSTANCE = new InheritableThreadLocal<>();

    public static void initDriver(String name){
        switch (name){
            case "chrome" -> {
                DRIVER_INSTANCE.set(WebDriverManager.setupChrome());
            }
            case "opera" -> {
                DRIVER_INSTANCE.set(WebDriverManager.setupOpera());
            }
            default -> throw new RuntimeException("invalid browser " + name);
        }
    }

    public static WebDriver getDriver(){
        if(DRIVER_INSTANCE.get()==null){
            System.out.println("created befault driver");
            DriverFactory.initDriver("chrome");
        }
        DRIVER_INSTANCE.get().manage().timeouts().implicitlyWait(IMPLICIT_WAIT,TimeUnit.SECONDS);
        return DRIVER_INSTANCE.get();
    }

}
