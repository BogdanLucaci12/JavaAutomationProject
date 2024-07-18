package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NestedPageFrame extends BasePage {
    public NestedPageFrame(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame;

    @FindBy(xpath = "//p")
    private WebElement text;

    public void interactWithChildFrame(){
        elementMethods.switchFrame("frame1");
        elementMethods.switchFrameWebElement(childFrame);
        System.out.println(text.getText());
    }
}
