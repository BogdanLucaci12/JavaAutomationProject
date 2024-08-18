package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementPage extends BasePage {
    public ElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "item-3")
    public WebElement webTable;

    public void navigateToWebTableSubMenu(){
        elementMethods.clickElement(webTable);
        LoggerUtility.info("The user navigate to web table submenu");
    }
}
