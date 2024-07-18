package Pages;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    public void fillEntireForm(String firstNameValue, String lastNameValue, String userEmailValue,
    String genderValue, String phoneValue, String dateOfBirthDaysValue, String subjectValue,
                                   String textareaValue, String stateInputValue, String cityInputValue
    ){
        elementMethods.sendKeys(firstNameValue, firstNameElement);
        elementMethods.sendKeys(lastNameValue, lastNameElementPracticeForm);
        pageMethods.scrollPage(0, 350);
        elementMethods.sendKeys(userEmailValue, userEmailElementPracticeForm);
        switch (genderValue){
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
        elementMethods.sendKeys(phoneValue, phoneElement);
        elementMethods.clickElement(dateOfBirthElement);
        elementMethods.selectByTextElement(monthOfBirthElement, "September");
        elementMethods.selectByValue(yearOfBirthElement, "1990");

        for(Integer i=0;i<dateOfBirthDays.size();i++){
            if(dateOfBirthDays.get(i).getText().equals(dateOfBirthDaysValue)){
                elementMethods.clickElement(dateOfBirthDays.get(i));
                break;
            }
        }
        elementMethods.sendKeysEnter(subjectValue, subjectElement);
        List<String> hobbiesValues= Arrays.asList("Sports", "Reading", "Music");
        for(Integer i=0; i<hobbiesElement.size(); i++){
            String hobbieText=hobbiesElement.get(i).getText();
            if(hobbiesValues.contains(hobbieText)){
                JavascriptExecutor jsClick = (JavascriptExecutor)driver;
                jsClick.executeScript("arguments[0].click();",  hobbiesElement.get(i));
            }
        }
        File file= new File("src/test/resources/2024-04-27 (5).png");
        uploadElement.sendKeys(file.getAbsolutePath());
        elementMethods.sendKeys(textareaValue, uploadTextareaElement);
        elementMethods.sendKeysEnter(stateInputValue, stateInputElement);
        elementMethods.sendKeysEnter(cityInputValue, cityInputElement);
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(submitButtonElement);
    }
  public void validateEntireForm(String firstNameValue, String lastNameValue,
  String userEmailValue, String genderValue, String phoneValue, String subjectValue, List<String> hobbiesValues, String file, String adressValue,
                                 String stateInputValue, String cityInputValue
  ){
      pageMethods.scrollPage(0, 350);
      Assert.assertEquals(tableElement.get(0).getText(), "Student Name "+ firstNameValue + " " +lastNameValue);
      Assert.assertEquals(tableElement.get(1).getText(), "Student Email " + userEmailValue );
      Assert.assertEquals(tableElement.get(2).getText(), "Gender " + genderValue );
      Assert.assertEquals(tableElement.get(3).getText(), "Mobile " + phoneValue );
      Assert.assertEquals(tableElement.get(5).getText(), "Subjects " + subjectValue );
      String expectedHobbiesText="Hobbies " + String.join(", ", hobbiesValues);
      Assert.assertEquals(tableElement.get(6).getText(), expectedHobbiesText);
      Assert.assertEquals(tableElement.get(7).getText(), "Picture " + file);
      Assert.assertEquals(tableElement.get(8).getText(), "Address " + adressValue);
      Assert.assertEquals(tableElement.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);
//      pageMethods.scrollPage(0, 450);
//      elementMethods.clickElement(closeSubmitFormElement);
  }
}
