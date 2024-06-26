package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import helperMethods.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest {
    public WebDriver driver;
    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //definim un obiect de tipul windowMethod
        WindowMethods windowMethods=new WindowMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);
        PageMethods pageMethods=new PageMethods(driver);

        pageMethods.scrollPage(0, 350);

        WebElement alertFrameWindowsMenu=driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]/div/div/h5[contains(text(), \"Alerts, Frame & Windows\")]"));
        elementMethods.clickElement(alertFrameWindowsMenu);
        WebElement browserWindows=driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li/span[contains(text(), \"Browser Windows\")]"));
        elementMethods.clickElement(browserWindows);

        //interactionam cu newTab
        WebElement newTabButtonElement=driver.findElement(By.id("tabButton"));
        elementMethods.clickElement(newTabButtonElement);
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);


        //interactionam cu window button
        WebElement newWindow=driver.findElement(By.id("windowButton"));
        elementMethods.clickElement(newWindow);
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);


        //interact with window message
        WebElement newWindowMessage=driver.findElement(By.id("messageWindowButton"));
        elementMethods.clickElement(newWindowMessage);
        windowMethods.switchSpecificTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchSpecificTab(0);
        driver.quit();


    }
}
