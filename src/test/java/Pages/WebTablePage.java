package Pages;

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

    public void clickAddElement(){
        elementMethods.clickElement(addElement);
    }
    public void sendKeysFirstName(String s){
        elementMethods.sendKeys(s, firstNameElement);
    }
    public void sendKeysLastName(String s){
        elementMethods.sendKeys(s, lastNameElement);
    }
    public void sendKeysEmail(String s){
        elementMethods.sendKeys(s, userEmailElement);
    }
    public void sendKeysAge(String s){
        elementMethods.sendKeys(s, ageElement);
    }
    public void sendKeysSalary(String s){
        elementMethods.sendKeys(s, salaryElement);
    }
    public void sendKeysDepartment(String s){
        elementMethods.sendKeys(s, departmentElement);
    }
    public void clickSubmit(){
        elementMethods.clickElement(submitElement);
    }
    public void editRecord(){
        elementMethods.clickElement(editRecord4);
    }
    public void editSalaryRecord(String s){
        editSalaryRecord4Element.clear();
        elementMethods.sendKeys(s, editSalaryRecord4Element);
    }
    public void deleteRecord(){
        elementMethods.clickElement( deleteRecord1Element);
    }
}
