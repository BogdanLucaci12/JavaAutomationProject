package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WindowsPage extends BasePage{
    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "tabButton")
    private WebElement newTabButtonElement;

    @FindBy(id = "windowButton")
    private WebElement newWindow;

    @FindBy(id = "messageWindowButton")
    private WebElement newWindowMessage;



    public void interactWithNewTab(){
        elementMethods.clickElement(newTabButtonElement);
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }

    public void interactWithWindowButton(){
        elementMethods.clickElement(newWindow);
        LoggerUtility.info("The user interacts with Window button");
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switch to tab 1");
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
        LoggerUtility.info("The user switch to tab 0");

    }

    public void interactWithWindowMessage(){
        elementMethods.clickElement(newWindowMessage);
        LoggerUtility.info("The user interacts with New Window Message button");
        windowMethods.switchSpecificTab(1);
        LoggerUtility.info("The user switch to tab 1");
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
        LoggerUtility.info("The user switch to tab 0");

    }
}
