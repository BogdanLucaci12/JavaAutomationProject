package pages;

import loggerUtility.LoggerUtility;
import objectData.WebTableObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablePage extends BasePage{
    public WebTablePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "addNewRecordButton")
    private WebElement addElement;

    @FindBy(id = "firstName")
    private WebElement firstNameElement;
    @FindBy(id = "lastName")
    private WebElement lastNameElement;
    @FindBy(id = "userEmail")
    private WebElement userEmailElement;
    @FindBy(id = "age")
    private WebElement ageElement;
    @FindBy(id = "salary")
    private WebElement salaryElement;

    @FindBy(id = "department")
    private WebElement departmentElement;
    @FindBy(id = "submit")
    private WebElement submitElement;
    @FindBy(id = "edit-record-3")
    private WebElement editRecord4;
    @FindBy(id = "salary")
    private WebElement editSalaryRecord4Element;

    @FindBy(id = "delete-record-1")
    private WebElement deleteRecord1Element;

    public void addEntry(WebTableObject testData){
            elementMethods.clickElement(addElement);
        LoggerUtility.info("The user click on add element");
            elementMethods.sendKeys(testData.getFirstName(), firstNameElement);
        LoggerUtility.info("The user fill first name element");
            elementMethods.sendKeys(testData.getLastName(), lastNameElement);
        LoggerUtility.info("The user fill last name element");
            elementMethods.sendKeys(testData.getUserEmail(), userEmailElement);
        LoggerUtility.info("The user fill email element");
            elementMethods.sendKeys(testData.getAgeValue(), ageElement);
        LoggerUtility.info("The user fill age element");
        elementMethods.sendKeys(testData.getSalaryValue(), salaryElement);
        LoggerUtility.info("The user fill salary element");
        elementMethods.sendKeys(testData.getDepartmentValue(), departmentElement);
        LoggerUtility.info("The user fill department element");
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user click on submit element");

    }

    public void changeEntry(WebTableObject testData){
        elementMethods.clickElement(editRecord4);
        LoggerUtility.info("The user click edit element");
        editSalaryRecord4Element.clear();
        LoggerUtility.info("The user clear record element");
        elementMethods.sendKeys(testData.getEditRecord(), editSalaryRecord4Element);
        LoggerUtility.info("The user edit salary element");
        elementMethods.clickElement(submitElement);
        LoggerUtility.info("The user click submit element");

    }

    public void deleteRecord(){
        elementMethods.clickElement( deleteRecord1Element);

    }
}
