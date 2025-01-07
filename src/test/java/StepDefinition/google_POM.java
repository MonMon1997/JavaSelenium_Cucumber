package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class google_POM {

    protected final WebDriver driver;
    private By search_name = By.name("q");

    public google_POM(WebDriver driver){
        this.driver = driver;
    }

    public void searchtextname(String search){
        driver.findElement(search_name).sendKeys(search);
    }

    public void clicktext(){
        driver.findElement(search_name).click();
    }

}
