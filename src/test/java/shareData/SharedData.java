package shareData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void prepareEnvironment(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The broswer is open with succes");
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if(!result.isSuccess()){
            LoggerUtility.error(result.getThrowable().getMessage());
        }
        LoggerUtility.info("The broswer is close with succes");
        driver.quit();
    }

}
