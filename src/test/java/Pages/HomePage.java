package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h5[text()='Alerts, Frame & Windows']")
    private WebElement alertFrameWindowsMenu;

    @FindBy(xpath = "//h5[text()='Forms']")
    private WebElement forms;

    @FindBy(xpath = "//h5[text()='Elements']")
    private WebElement elementsMenu;


    public void navigateToAlertMenu(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(alertFrameWindowsMenu);
    }

    public void navigateToFormsPage(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(forms);
    }
    public void navigateToElementsPage(){
        pageMethods.scrollPage(0, 350);
        elementMethods.clickElement(elementsMenu);
    }
}
