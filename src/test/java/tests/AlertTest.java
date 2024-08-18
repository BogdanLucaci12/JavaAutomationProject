package tests;

import pages.AlertsPage;
import pages.AlertsWindowsPage;
import pages.HomePage;
import org.testng.annotations.Test;
import shareData.SharedData;

public class AlertTest extends SharedData {
    @Test
    public void moetodaTest(){
   ;
        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToAlertMenu();
        AlertsWindowsPage alertsWindowsPage=new AlertsWindowsPage(getDriver());
        alertsWindowsPage.navigateToAlertsPage();
        //ineractionam cu o alerta1
        AlertsPage alertsPage=new AlertsPage(getDriver());
        alertsPage.interactAlertOK();
        //ineractionam cu o alerta3
        alertsPage.interactAlertConfirm();
        //ineractionam cu o alerta4
        alertsPage.interactPromtButtonAlert("Bogdan");
        //interactionam cu o alerta pentru care trebuie sa asteptam
        alertsPage.interactWithTimerAlert();
    }

}
