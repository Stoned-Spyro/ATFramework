package Wrappers;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

import java.lang.reflect.Field;

public class CustomDecorator extends DefaultFieldDecorator {

    public CustomDecorator(SearchContext factory) {
        super(new DefaultElementLocatorFactory(factory));
    }
    public Object decorate(ClassLoader loader, Field field){
        Class<?> decorableClass = decorableClass(field);

        if(decorableClass != null){
            ElementLocator locator = factory.createLocator(field);
            if(locator == null){
                return null;
            }
            return createElement(loader,locator,decorableClass);
        }
        return super.decorate(loader,field);
    }

    private Class<?> decorableClass(Field field){

        Class<?> clazz = field.getType();

        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e){
            return null;
        }

        return clazz;
    }
    protected <T> T createElement(ClassLoader loader, ElementLocator locator, Class<T> clazz){
        WebElement proxy = proxyForLocator(loader,locator);
        return createInstace(clazz,proxy);
    }

    private <T> T createInstace(Class<T> clazz, WebElement webElement){
        try {
            return (T) clazz.getConstructor(WebElement.class).newInstance(webElement);
        }catch (Exception e){
            throw new AssertionError("Web element can't be represented as" + clazz);
        }
    }

}
