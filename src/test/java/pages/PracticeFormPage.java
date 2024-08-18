package pages;

import loggerUtility.LoggerUtility;
import objectData.PracticeFormObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PracticeFormPage extends BasePage{
    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameElement;

    @FindBy(id = "lastName")
    private WebElement lastNameElementPracticeForm;

    @FindBy(id = "userEmail")
    private WebElement userEmailElementPracticeForm;

    @FindBy(xpath = "//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> genderElement;

    @FindBy(id = "userNumber")
    private WebElement phoneElement;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dateOfBirthElement;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement monthOfBirthElement;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement yearOfBirthElement;

    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class, '--outside-month')) and @role='option']")
    private List<WebElement> dateOfBirthDays;
    @FindBy(id = "subjectsInput")
    private WebElement subjectElement;

    @FindBy(xpath = "//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']")
    private List<WebElement> hobbiesElement;

    @FindBy(id = "uploadPicture")
    private WebElement uploadElement;

    @FindBy(id = "currentAddress")
    private WebElement uploadTextareaElement;

    @FindBy(id = "react-select-3-input")
    private WebElement stateInputElement;

    @FindBy(id = "react-select-4-input")
    private WebElement cityInputElement;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButtonElement;

    @FindBy(xpath = "//table[@class=\"table table-dark table-striped table-bordered table-hover\"]/tbody/tr")
    private List<WebElement> tableElement;

    @FindBy(id = "closeLargeModal")
    private WebElement closeSubmitFormElement;

    public void fillEntireForm(PracticeFormObject testData){
        elementMethods.sendKeys(testData.getFirstNameValue(), firstNameElement);
        LoggerUtility.info("The user fill first name element");
        elementMethods.sendKeys(testData.getLastNameValue(), lastNameElementPracticeForm);
        LoggerUtility.info("The user fill last name element");
        pageMethods.scrollPage(0, 350);
        elementMethods.sendKeys(testData.getUserEmailValue(), userEmailElementPracticeForm);
        LoggerUtility.info("The user fill email element");
        switch (testData.getGenderValue()){
            case "Male":
                elementMethods.clickElement(genderElement.get(0));
                break;
            case "Female":
                elementMethods.clickElement(genderElement.get(1));
                break;
            case "Other":
                elementMethods.clickElement(genderElement.get(2));
                break;
        }
        LoggerUtility.info("The user fill gender element");
        elementMethods.sendKeys(testData.getPhoneValue(), phoneElement);
        LoggerUtility.info("The user fill phone element");
        elementMethods.clickElement(dateOfBirthElement);
        LoggerUtility.info("The user fill date of birth element");
        elementMethods.selectByTextElement(monthOfBirthElement, "September");
        LoggerUtility.info("The user fill month of birth element");
        elementMethods.selectByValue(yearOfBirthElement, "1990");
        LoggerUtility.info("The user fill year of birth element");
        for(Integer i=0;i<dateOfBirthDays.size();i++){
            if(dateOfBirthDays.get(i).getText().equals(testData.getDateOfBirthDaysValue())){
                elementMethods.clickElement(dateOfBirthDays.get(i));
                break;
            }
        }
        LoggerUtility.info("The user fill date of birth element");
        elementMethods.sendKeysEnter(testData.getSubjectValue(), subjectElement);
        LoggerUtility.info("The user fill subject element");
        List<String> hobbiesValues= Arrays.asList("Sports", "Reading", "Music");
        for(Integer i=0; i<hobbiesElement.size(); i++){
            String hobbieText=hobbiesElement.get(i).getText();
            if(hobbiesValues.contains(hobbieText)){
                JavascriptExecutor jsClick = (JavascriptExecutor)driver;
                jsClick.executeScript("arguments[0].click();",  hobbiesElement.get(i));
            }
        }
        LoggerUtility.info("The user fill hobbies element");
        File file= new File("src/test/resources/2024-04-27 (5).png");
        uploadElement.sendKeys(file.getAbsolutePath());
        LoggerUtility.info("The user fill file element");
        elementMethods.sendKeys(testData.getTextareaValue(), uploadTextareaElement);
        LoggerUtility.info("The user fill textarea element");
        elementMethods.sendKeysEnter(testData.getStateInputValue(), stateInputElement);
        LoggerUtility.info("The user fill state element");
        elementMethods.sendKeysEnter(testData.getCityInputValue(), cityInputElement);
        LoggerUtility.info("The user fill city element");
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(submitButtonElement);
        LoggerUtility.info("The user submit the form");
    }
  public void validateEntireForm(PracticeFormObject testData){
      pageMethods.scrollPage(0, 350);
      Assert.assertEquals(tableElement.get(0).getText(), "Student Name "+ testData.getFirstNameValue() + " " +testData.getLastNameValue());
      Assert.assertEquals(tableElement.get(1).getText(), "Student Email " + testData.getUserEmailValue() );
      Assert.assertEquals(tableElement.get(2).getText(), "Gender " + testData.getGenderValue() );
      Assert.assertEquals(tableElement.get(3).getText(), "Mobile " + testData.getPhoneValue() );
      Assert.assertEquals(tableElement.get(5).getText(), "Subjects " + testData.getSubjectValue() );
      String expectedHobbiesText="Hobbies " + String.join(", ", testData.getHobbiesValues());
      Assert.assertEquals(tableElement.get(6).getText(), expectedHobbiesText);
      Assert.assertEquals(tableElement.get(7).getText(), "Picture " + testData.getFile());
      Assert.assertEquals(tableElement.get(8).getText(), "Address " + testData.getTextareaValue());
      Assert.assertEquals(tableElement.get(9).getText(), "State and City " + testData.getStateInputValue() + " " + testData.getCityInputValue());
//      pageMethods.scrollPage(0, 450);
//      elementMethods.clickElement(closeSubmitFormElement);
  }
}
