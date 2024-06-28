package Pages;

import helperMethods.ElementMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindows {
    public WebDriver driver;
    public ElementMethods elementMethods;
    public AlertsWindows(WebDriver driver) {
        this.driver = driver;
        elementMethods=new ElementMethods(driver);
    }
    @FindBy(xpath = "//span[text()='Browser Windows']")
    public WebElement browserWindows;
    public void navigateToBrowserWindows(){
        elementMethods.clickElement(browserWindows);
    }
}
