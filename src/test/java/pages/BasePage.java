package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utilities.DriverSetup.getDriver;

public class BasePage {

    public void loadPage(String url){
        getDriver().get(url);
    }
    public String getURL(){
        return getDriver().getCurrentUrl();
    }
    public String getPageTitle(){
        return getDriver().getTitle();
    }
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }
    public List<WebElement> getMultipleElements(By locator){
        return getDriver().findElements(locator);
    }
    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }
    public String getElementTextUsingElement(WebElement element){return element.getText();}
    public String getCSSValue(By locator,String property){
        return getElement(locator).getCssValue(property);
    }
    public String getAttributeValue(By locator,String attribute){
        return getElement(locator).getAttribute(attribute);
    }
    

    public boolean displayState(By locator){
        return getElement(locator).isDisplayed();
    }
    public boolean elementDisplayState(WebElement element){
        return element.isDisplayed();
    }
    public boolean enableState(By locator){
        return getElement(locator).isEnabled();
    }
    public void writeOnElement(By locator,String text){
        getElement(locator).sendKeys(text);
    }

    public WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }



}
