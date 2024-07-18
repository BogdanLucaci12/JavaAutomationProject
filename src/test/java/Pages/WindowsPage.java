package Pages;

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
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }

    public void interactWithWindowMessage(){
        elementMethods.clickElement(newWindowMessage);
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
    }
}
