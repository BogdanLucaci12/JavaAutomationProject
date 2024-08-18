package pages;

import loggerUtility.LoggerUtility;
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
        LoggerUtility.info("The user navigate on Browser menu");

    }
    public void navigateToFramesPage(){
        elementMethods.clickElement(alertFrame);
        LoggerUtility.info("The user navigate on Frame page");

    }
    public void navigateToAlertsPage(){
        elementMethods.clickElement(alertMenu);
        LoggerUtility.info("The user navigate on Alerts menu");

    }
}
