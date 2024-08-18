package tests;

import pages.AlertsWindowsPage;
import pages.FramePage;
import pages.HomePage;
import pages.NestedPageFrame;
import helperMethods.PageMethods;
import org.testng.annotations.Test;
import shareData.SharedData;

public class FrameTest extends SharedData {
    @Test
    public void metodaTest() {
        PageMethods pageMethods=new PageMethods(getDriver());
        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToAlertMenu();
        AlertsWindowsPage alertsWindowsPage=new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToFramesPage();
        FramePage framePage=new FramePage(getDriver());
        framePage.interactWithBigFrame();
        framePage.interactWithSmallFrame();
        pageMethods.scrollPage(0, 350);
        framePage.navigateToNestedFrame();
        NestedPageFrame nestedPageFrame=new NestedPageFrame(getDriver());
        nestedPageFrame.interactWithChildFrame();
    }
    }

