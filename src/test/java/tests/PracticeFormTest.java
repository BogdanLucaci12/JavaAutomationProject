package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class PracticeFormTest {
    public WebDriver driver;
    @Test
    public void metodaTest(){
        //deschidem un browser
        driver=new ChromeDriver();

        //accesam un anumit URL
        driver.get("https://demoqa.com/");

        //facem browser in mod maximiz
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;

        PageMethods pageMethods=new PageMethods(driver);
        ElementMethods elementMethods=new ElementMethods(driver);

        pageMethods.scrollPage(0, 350);
        // interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu=driver.findElement(By.xpath("//h5[text()='Forms']"));
        elementMethods.clickElement(elementsMenu);

        WebElement webPracticeForm=driver.findElement(By.xpath("//span[text()='Practice Form']"));
        elementMethods.clickElement(webPracticeForm);

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        String firstNameValue="Bogdan";
        elementMethods.sendKeys(firstNameValue, firstNameElement);

        WebElement lastNameElementPracticeForm=driver.findElement(By.id("lastName"));
        String lastNameValue="Lucaci";
        elementMethods.sendKeys(lastNameValue, lastNameElementPracticeForm);
        pageMethods.scrollPage(0, 350);

        WebElement userEmailElementPracticeForm=driver.findElement(By.id("userEmail"));
        String userEmailValue="bogdan@gmail.com";
        elementMethods.sendKeys(userEmailValue, userEmailElementPracticeForm);


        //definim o logica generala de a selecta un element dintr-o lista
        List<WebElement> genderElement=driver.findElements(By.xpath("//div[@id='genterWrapper']/div/div/label[@class='custom-control-label']"));
        String genderValue="Female";
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
        WebElement phoneElement=driver.findElement(By.id("userNumber"));
        String phoneValue="0744771452";
        elementMethods.sendKeys(phoneValue, phoneElement);

        WebElement dateOfBirthElement=driver.findElement(By.id("dateOfBirthInput"));
        elementMethods.clickElement(dateOfBirthElement);
        WebElement monthOfBirthElement=driver.findElement(By.className("react-datepicker__month-select"));
        Select monthSelect=new Select(monthOfBirthElement);
        monthSelect.selectByVisibleText("September");
        WebElement yearOfBirthElement=driver.findElement(By.className("react-datepicker__year-select"));
        Select yearSelect=new Select(yearOfBirthElement);
        yearSelect.selectByValue("2020");

        WebElement subjectElement=driver.findElement(By.id("subjectsInput"));
        String subjectValue="Arts";
        elementMethods.sendKeysEnter(subjectValue, subjectElement);


        List<WebElement> hobbiesElement=driver.findElements(By.xpath("//div[@id='hobbiesWrapper']/div/div/label[@class='custom-control-label']"));
        List<String> hobbiesValues= Arrays.asList("Sports", "Reading", "Music");
        for(Integer i=0; i<hobbiesElement.size(); i++){
            String hobbieText=hobbiesElement.get(i).getText();
            if(hobbiesValues.contains(hobbieText)){
                JavascriptExecutor jsClick = (JavascriptExecutor)driver;
                jsClick.executeScript("arguments[0].click();",  hobbiesElement.get(i));
            }
        }

        //Interactionam cu un fisier:
        WebElement uploadElement=driver.findElement(By.id("uploadPicture"));
        File file= new File("src/test/resources/2024-04-27 (5).png");
        uploadElement.sendKeys(file.getAbsolutePath());

        WebElement uploadTextareaElement=driver.findElement(By.id("currentAddress"));
        String textareaValue="dsdasdasd";
        elementMethods.sendKeys(textareaValue, uploadTextareaElement);

        WebElement stateInputElement=driver.findElement(By.id("react-select-3-input"));
        String stateInputValue="NCR";
        elementMethods.sendKeysEnter(stateInputValue, stateInputElement);

        WebElement cityInputElement=driver.findElement(By.id("react-select-4-input"));
        String cityInputValue="Delhi";
        elementMethods.sendKeysEnter(cityInputValue, cityInputElement);

        pageMethods.scrollPage(0, 350);

        WebElement submitButtonElement=driver.findElement(By.xpath("//button[@id='submit']"));
        elementMethods.clickElement(submitButtonElement);
      //  validam tabelul cu valorile introduse


        List<WebElement> tableElement=driver.findElements(By.xpath("//table[@class=\"table table-dark table-striped table-bordered table-hover\"]/tbody/tr"));
        Assert.assertEquals(tableElement.get(0).getText(), "Student Name "+ firstNameValue + " " +lastNameValue);
        Assert.assertEquals(tableElement.get(1).getText(), "Student Email " + userEmailValue );
        Assert.assertEquals(tableElement.get(2).getText(), "Gender " + genderValue );
        Assert.assertEquals(tableElement.get(3).getText(), "Mobile " + phoneValue );
        Assert.assertEquals(tableElement.get(5).getText(), "Subject " + subjectValue );
        String expectedHobbiesText="Hobbies" + String.join(", ", hobbiesValues);
        Assert.assertEquals(tableElement.get(6).getText(), expectedHobbiesText);
        Assert.assertEquals(tableElement.get(7).getText(), "Pictures" + file);
        Assert.assertEquals(tableElement.get(8).getText(), "Adress" + uploadTextareaElement);
        Assert.assertEquals(tableElement.get(9).getText(), "State and City " + stateInputValue + " " + cityInputValue);


        WebElement closeSubmitFormElement=driver.findElement(By.id("closeLargeModal"));
        elementMethods.clickElement(closeSubmitFormElement);
    }

}
