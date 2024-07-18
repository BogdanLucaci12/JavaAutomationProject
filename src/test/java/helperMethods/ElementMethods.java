package helperMethods;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods (WebDriver driver){
        this.driver=driver;
    }
    //metoda generala pt interactiunea cu elemente
    public void waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void clickElement(WebElement element){
        waitForElementVisible(element);
        element.click();
    }

    public void sendKeys(String s, WebElement element){
        element.sendKeys(s);
    }
    public void sendKeysEnter(String s, WebElement element){
        element.sendKeys(s);
        element.sendKeys(Keys.ENTER);
    }
    public  void switchFrame(  String s){
        driver.switchTo().frame(s);
    }
    public void switchFrameWebElement(WebElement e){
        driver.switchTo().frame(e);
    }
    public  void  defaultFrame(){
        driver.switchTo().defaultContent();
    }

    public void selectByTextElement(WebElement monthOfBirthElement, String month){
        Select monthSelect=new Select(monthOfBirthElement);
        monthSelect.selectByVisibleText(month);
    }
    public void selectByValue(WebElement yearOfBirthElement, String year){
        Select monthSelect=new Select(yearOfBirthElement);
        monthSelect.selectByVisibleText(year);
    }
}
