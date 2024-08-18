package tests;

import objectData.PracticeFormObject;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;
import org.testng.annotations.Test;
import shareData.SharedData;

import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {
        //pregatim datele de test specifice

        PracticeFormObject testData=new PracticeFormObject("src/test/resources/testData/PracticeFormData.json");


        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(testData);
        practiceFormPage.validateEntireForm(testData);
    }
}
