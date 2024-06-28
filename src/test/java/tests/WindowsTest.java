package tests;

import Pages.AlertsWindowsPage;
import Pages.HomePage;
import Pages.WindowsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrowserWindowsTest {
    public WebDriver driver;
    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();

        //definim un obiect de tipul windowMethod
        HomePage homePage=new HomePage(driver);
        homePage.navigateToAlertMenu();

        AlertsWindowsPage alertsWindows=new AlertsWindowsPage(driver);
        alertsWindows.navigateToBrowserWindows();

        WindowsPage windowsPage=new WindowsPage(driver);
        //interactionam cu newTab
        windowsPage.interactWithNewTab();

        //interactionam cu window button
        windowsPage.interactWithWindowButton();


        //interact with window message
        windowsPage.interactWithWindowMessage();

        driver.quit();
    }
}
