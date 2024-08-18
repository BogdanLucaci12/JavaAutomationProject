package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {
    public WebDriver driver;

    public WindowMethods(WebDriver driver){
        this.driver=driver;
    }
    //metode generale pentru interactiunea cu tab/window

    public void switchSpecificTab(Integer index){
        List<String> window=new ArrayList<>(driver.getWindowHandles());// gaseste cate tab-uri sunt deschise in momentul apelarii metodei
        //Ne mutam cu focusul pe un anumit tab
        driver.switchTo().window(window.get(index));
    }
    public void closeCurrentTab(){
        driver.close();
    }
}
