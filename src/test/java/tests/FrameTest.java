package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

public class FrameTest {
    public WebDriver driver;
    @Test
    public void metodaTest() {
        //deschidem un browser
        driver=new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com/");

        //facem browser in mod maximiz
        driver.manage().window().maximize();

        //Facem un scroll la pagina pentru vizibilitate

        PageMethods pageMethods=new PageMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);
        pageMethods.scrollPage(0, 350);

        WebElement alertFrameWindowsMenu=driver.findElement(By.xpath("//div[@class=\"card mt-4 top-card\"]/div/div/h5[contains(text(), \"Alerts, Frame & Windows\")]"));
        elementMethods.clickElement(alertFrameWindowsMenu);

        WebElement alertMenu=driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li/span[contains(text(), \"Frames\")]"));
        elementMethods.clickElement(alertMenu);
        //mutam focusul pe un iFrame
        elementMethods.switchFrame("frame1");
        //ne intoarcem cu focusul la frame-ul default. se foloseste iframe ca nu se fure diferite date de catre boti
        elementMethods.defaultFrame();
        elementMethods.switchFrame("frame2");
        WebElement iFrameTest2=driver.findElement(By.id("sampleHeading"));
        elementMethods.defaultFrame();
        //ne mutam pe nestedFrame
        pageMethods.scrollPage(0, 350);
        WebElement nestedFrame=driver.findElement(By.xpath("//div[@class='element-list collapse show']/ul/li/span[contains(text(), \"Nested Frames\")]"));
        elementMethods.clickElement(nestedFrame);
        //interactionam iframe in iframe
        pageMethods.scrollPage(0, 250);
        elementMethods.switchFrame("frame1");
        WebElement childFrame=driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
        elementMethods.switchFrameWebElement(childFrame);
        WebElement text=driver.findElement(By.xpath("//p"));
        System.out.println(text.getText());
    }
    }

