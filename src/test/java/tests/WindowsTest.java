package tests;

import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.WindowsPage;
import org.testng.annotations.Test;
import shareData.SharedData;

public class WindowsTest extends SharedData {
    @Test
    public void metodaTest(){
        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToAlertMenu();

        AlertsWindowsPage alertsWindows=new AlertsWindowsPage(getDriver());
        alertsWindows.navigateToBrowserWindows();

        WindowsPage windowsPage=new WindowsPage(getDriver());
        //interactionam cu newTab
        windowsPage.interactWithNewTab();

        //interactionam cu window button
        windowsPage.interactWithWindowButton();

        //interact with window message
        windowsPage.interactWithWindowMessage();
        getDriver().quit();
    }
}
