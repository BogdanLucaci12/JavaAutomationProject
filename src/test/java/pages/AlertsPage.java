package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    private WebElement alertButton;

    @FindBy(id = "confirmButton")
    private WebElement confirmButtonAlert;

    @FindBy(id = "promtButton")
    private WebElement promtButtonAlert;

    @FindBy(id = "timerAlertButton")
    private WebElement timerAlertElement;


    public void interactAlertOK(){
        elementMethods.clickElement(alertButton);
        alertsMethods.acceptAlert();
        LoggerUtility.info("The user interact with alert ok element");

    }

    public void interactAlertConfirm(){
        elementMethods.clickElement(confirmButtonAlert);
        alertsMethods.dismisAlert();
        LoggerUtility.info("The user interact with alert confirm element");
    }

    public void interactPromtButtonAlert(String string){
        elementMethods.clickElement(promtButtonAlert);
        alertsMethods.fillAlert(string);
        LoggerUtility.info("The user interact with promt button alert element");
    }
    public void interactWithTimerAlert(){
        elementMethods.clickElement(timerAlertElement);
        alertsMethods.acceptAlert();
        LoggerUtility.info("The user interact with timer alert element");
    }
}
