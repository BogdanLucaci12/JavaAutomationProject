package tests;

import helperMethods.AlertsMethods;
import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class AlertTest {
    public WebDriver driver;
    @Test
    public void moetodaTest(){
        driver=new ChromeDriver();
        //accesam un anumit URL
        driver.get("https://demoqa.com/");

        //facem browser in mod maximizat
        driver.manage().window().maximize();

        //wait implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Definim un obiect de tip AlertMethods ca sa aoelam metodele din clasa AlertMEthods

        AlertsMethods alertsMethods=new AlertsMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);

        pageMethods.scrollPage(0, 350);
        WebElement alertFrameWindowsMenu=driver.findElement(By.xpath("//h5[text()= \"Alerts, Frame & Windows\"]"));
        elementMethods.clickElement(alertFrameWindowsMenu);

        WebElement alertMenu=driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li/span[contains(text(), \"Alerts\")]"));
        elementMethods.clickElement(alertMenu);
        //ineractionam cu o alerta1
        WebElement alertButton=driver.findElement(By.id("alertButton"));
        elementMethods.clickElement(alertButton);
       alertsMethods.acceptAlert();
        //ineractionam cu o alerta3
        WebElement confirmButtonAlert=driver.findElement(By.id("confirmButton"));
        elementMethods.clickElement(confirmButtonAlert);
        alertsMethods.dismisAlert();

        //ineractionam cu o alerta4
        WebElement promtButtonAlert=driver.findElement(By.id("promtButton"));
        elementMethods.clickElement(promtButtonAlert);
        alertsMethods.fillAlert("Bogdan");

        //interactionam cu o alerta pentru care trebuie sa asteptam
        WebElement timerAlertElement=driver.findElement(By.id("timerAlertButton"));
        elementMethods.clickElement(timerAlertElement);
        alertsMethods.acceptAlert();
    }

}
