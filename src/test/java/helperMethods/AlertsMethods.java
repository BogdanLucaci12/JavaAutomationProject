package helperMethods;

import lombok.AllArgsConstructor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@AllArgsConstructor
public class AlertsMethods {

    public WebDriver driver;


    //definim metode generale pentru interactiunea cu alerte

    public void waitForAlert(){
        WebDriverWait webDriverWait=new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }
    public void acceptAlert(){
        waitForAlert();
        Alert waitConfirm=driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.accept();
    }

    public void dismisAlert(){
        waitForAlert();
        Alert waitConfirm=driver.switchTo().alert();
        System.out.println(waitConfirm.getText());
        waitConfirm.dismiss();
    }

    public void fillAlert(String value){
        Alert alertPromt=driver.switchTo().alert();
        System.out.println(alertPromt.getText());
        alertPromt.sendKeys(value);
        alertPromt.accept();
    }
}
