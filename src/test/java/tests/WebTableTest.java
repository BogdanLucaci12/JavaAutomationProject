package tests;

import helperMethods.ElementMethods;
import helperMethods.PageMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.testng.annotations.Test;

public class WebTableTest {

    public WebDriver driver;

    @Test
    public void metodaTest(){
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
        // interactionam cu meniul/submeniul de pe site
        WebElement elementsMenu=driver.findElement(ByAll.xpath("//h5[text()='Elements']"));
        elementMethods.clickElement(elementsMenu);
        WebElement webTable=driver.findElement(By.id("item-3"));
        elementMethods.clickElement(webTable);
        //definim un element dupa id
        //Test 1: adaug un entry
        WebElement addElement=driver.findElement(By.id("addNewRecordButton"));
        elementMethods.clickElement(addElement);

        WebElement firstNameElement=driver.findElement(By.id("firstName"));
        elementMethods.sendKeys("Bogdan", firstNameElement);
        WebElement lastNameElemnt=driver.findElement(By.id("lastName"));
       elementMethods.sendKeys("Lucaci", lastNameElemnt);
        WebElement userEmailElement=driver.findElement(By.id("userEmail"));
        elementMethods.sendKeys("bogdan@gmail.com", userEmailElement);
        WebElement ageElement=driver.findElement(By.id("age"));
        elementMethods.sendKeys("15", ageElement);

        WebElement salaryElement=driver.findElement(By.id("salary"));
        elementMethods.sendKeys("15152", salaryElement);

        WebElement departmentElement=driver.findElement(By.id("department"));

        elementMethods.sendKeys("Criogenetic", departmentElement);
        WebElement submitElement=driver.findElement(By.id("submit"));
        elementMethods.clickElement(submitElement);
        //test 2: modific un entry existent
        WebElement editRecord4=driver.findElement(By.id("edit-record-4"));
        elementMethods.clickElement(editRecord4);

        WebElement editSalaryRecord4Element=driver.findElement(By.id("salary"));
        editSalaryRecord4Element.clear();
        elementMethods.sendKeys("4545", editSalaryRecord4Element);

        WebElement editsubmitElement=driver.findElement(By.id("submit"));
        elementMethods.clickElement(editsubmitElement);
        //Test 3: stergem primul record
        WebElement deleteRecord1Element=driver.findElement(By.id("delete-record-1"));
        elementMethods.clickElement(deleteRecord1Element);
    }
}
