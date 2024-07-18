package tests;

import Pages.ElementPage;
import Pages.HomePage;
import Pages.WebTablePage;
import org.testng.annotations.Test;
import shareData.SharedData;

public class WebTableTest extends SharedData {

    @Test
    public void metodaTest(){
        HomePage homePage=new HomePage(getDriver());
        homePage.navigateToElementsPage();
        ElementPage elementPage=new ElementPage(getDriver());
        elementPage.navigateToWebTableSubMenu();
        WebTablePage webTablePage=new WebTablePage(getDriver());
        webTablePage.clickAddElement();
        webTablePage.sendKeysFirstName("lucaci");
        webTablePage.sendKeysLastName("bogdan");
        webTablePage.sendKeysEmail("sdsds@gmail.com");
        webTablePage.sendKeysAge("15");
        webTablePage.sendKeysSalary("1500");
        webTablePage.sendKeysDepartment("Crio");
        webTablePage.clickSubmit();
        webTablePage.editRecord();
        webTablePage.editSalaryRecord("25300");
        webTablePage.clickSubmit();
        webTablePage.deleteRecord();
    }
}
