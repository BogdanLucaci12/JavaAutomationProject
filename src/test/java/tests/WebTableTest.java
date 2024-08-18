package tests;

import objectData.WebTableObject;
import pages.ElementPage;
import pages.HomePage;
import pages.WebTablePage;
import org.testng.annotations.Test;
import shareData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest(){
        HomePage homePage=new HomePage(getDriver());
        WebTableObject testData=new WebTableObject("src/test/resources/testData/WebTableTest.json");
        homePage.navigateToElementsPage();
        ElementPage elementPage=new ElementPage(getDriver());
        elementPage.navigateToWebTableSubMenu();
        WebTablePage webTablePage=new WebTablePage(getDriver());
        webTablePage.addEntry(testData);
        webTablePage.changeEntry(testData);
        webTablePage.deleteRecord();
    }
}
