package Pages;

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
    }

    public void interactAlertConfirm(){
        elementMethods.clickElement(confirmButtonAlert);
        alertsMethods.dismisAlert();
    }

    public void interactPromtButtonAlert(String string){
        elementMethods.clickElement(promtButtonAlert);
        alertsMethods.fillAlert(string);
    }
    public void interactWithTimerAlert(){
        elementMethods.clickElement(timerAlertElement);
        alertsMethods.acceptAlert();
    }
}
