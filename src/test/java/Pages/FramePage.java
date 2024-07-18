package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FramePage extends BasePage{

    public FramePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "sampleHeading")
    private WebElement iFrameTest1;

    @FindBy(id = "sampleHeading")
    private WebElement iFrameTest2;

    @FindBy(xpath = "//span[text()='Nested Frames']")
    private WebElement nestedFrame;


    public void interactWithBigFrame(){
        elementMethods.switchFrame("frame1");
        System.out.println(iFrameTest1);
        elementMethods.defaultFrame();
    }
    public void interactWithSmallFrame(){
        elementMethods.switchFrame("frame2");
        System.out.println(iFrameTest2);
        elementMethods.defaultFrame();
    }
    public void navigateToNestedFrame(){
        elementMethods.clickElement(nestedFrame);
    }

}
