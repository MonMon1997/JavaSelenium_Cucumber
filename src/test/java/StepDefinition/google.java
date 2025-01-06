package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class google {

    WebDriver driver = null;
    Logger logger;

    @Given("User Nav to Google Main Page")
    public void user_nav_to_google_main_page() throws IOException {

        logger = LogManager.getLogger("");

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\src\\test\\java\\config\\config.properties");
        properties.load(inputStream);
        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("Chrome", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("Edge", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        driver.navigate().to("https://www.google.com/");
    }

    @When("User Click TextArea")
    public void user_click_text_area() {
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.click();
    }

    @And("User Enter the {string}")
    public void userEnterThe (String arg0) {
        driver.findElement(By.name("q")).sendKeys(arg0);
    }

    @And("User Click Enter")
    public void user_click_enter() {
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }
    @Then("User Move to the new Search Page")
    public void user_move_to_the_new_search_page() {
        logger.info("Test Finish");
    }

    @Given("User Nav to Main Page")
    public void userNavToMainPage() {
        System.setProperty("Chrome", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @When("User Enter TextArea")
    public void userEnterTextArea() {
        driver.findElement(By.name("q"));
    }

    @And("User Enter TWICE")
    public void userEnterTWICE() {
        driver.findElement(By.name("q")).sendKeys("TWICE");
    }

    @Then("User Should See the Results")
    public void userShouldSeeTheResults() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }
}
