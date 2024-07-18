package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsWindowsPage extends BasePage {
    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//span[text()='Browser Windows']")
    private WebElement browserWindows;

    @FindBy(xpath = "//span[text()='Frames']")
    private WebElement alertFrame;

    @FindBy(xpath = "//span[text()='Alerts']")
    private WebElement alertMenu;




    public void navigateToBrowserWindows(){
        elementMethods.clickElement(browserWindows);
    }
    public void navigateToFramesPage(){
        elementMethods.clickElement(alertFrame);
    }
    public void navigateToAlertsPage(){
        elementMethods.clickElement(alertMenu);
    }
}
