package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormsPage extends BasePage {
    public FormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Practice Form']")
    private WebElement webPracticeForm;

    public void navigateToPracticeForm(){
        elementMethods.clickElement(webPracticeForm);
        LoggerUtility.info("The user navigate to Practice Form");
    }

}
