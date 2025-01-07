package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class google {

    WebDriver driver = null;
    Logger logger;

    @Before
    public void browserSetup() throws InterruptedException, IOException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--desktop-window-1080p");

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\src\\test\\java\\config\\config.properties");
        properties.load(inputStream);
        String browser = properties.getProperty("browser");

        if (browser.equalsIgnoreCase("Chrome")){
            System.setProperty("Chrome", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("Edge", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
    }

//    @After
//    public void teardown(){
//        System.out.println("I am TearDown");
//    }

    @BeforeStep
    public void before(){
        System.out.println("----Before----");
    }

    @AfterStep
    public void after(){
        System.out.println("----After----");
    }

    @Given("User Nav to Google Main Page")
    public void user_nav_to_google_main_page() throws IOException {

        logger = LogManager.getLogger(google.class);
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

    //Regression Test
    @Given("User Nav to Main Page")
    public void userNavToMainPage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--desktop-window-1080p");

        System.setProperty("Chrome", "C:\\Program Files\\Intellij\\IdeaProjects\\Web_Automation_3\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");

        logger = LogManager.getLogger(google.class);
    }

    @When("User Enter TextArea")
    public void userEnterTextArea() {
        google_POM text = new google_POM(driver);
        text.clicktext();
        logger.info("User Enter TextArea");
    }

    @And("User Enter TWICE")
    public void userEnterTWICE() {
        google_POM text = new google_POM(driver);
        text.searchtextname("TWICE");
        logger.info("User Enter TWICE");
    }

    @Then("User Should See the Results")
    public void userShouldSeeTheResults() {
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        logger.info("User Should See the Results");
    }
}
