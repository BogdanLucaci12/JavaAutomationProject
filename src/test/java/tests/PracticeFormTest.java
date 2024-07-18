package tests;

import Pages.FormsPage;
import Pages.HomePage;
import Pages.PracticeFormPage;
import org.testng.annotations.Test;
import shareData.SharedData;

import java.sql.Driver;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest extends SharedData {

    @Test
    public void metodaTest() {

        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToFormsPage();

        FormsPage formsPage = new FormsPage(getDriver());
        formsPage.navigateToPracticeForm();

        String firstNameValue = "Bogdan";
        String lastNameValue = "Lucaci";
        String userEmailValue = "bogdan@gmail.com";
        String genderValue = "Female";
        String phoneValue = "0744771452";
        String dateOfBirthDaysValue = "23";
        String subjectValue = "Arts";
        String textareaValue = "dsdasdasd";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";
        String file="2024-04-27 (5).png";
        List<String> hobbiesValues= Arrays.asList("Sports", "Reading", "Music");
        PracticeFormPage practiceFormPage = new PracticeFormPage(getDriver());
        practiceFormPage.fillEntireForm(firstNameValue, lastNameValue, userEmailValue, genderValue,
                phoneValue, dateOfBirthDaysValue, subjectValue, textareaValue, stateInputValue, cityInputValue
        );
        practiceFormPage.validateEntireForm(firstNameValue, lastNameValue, userEmailValue, genderValue,
                phoneValue, subjectValue, hobbiesValues, file, textareaValue,stateInputValue, cityInputValue);
    }
}
