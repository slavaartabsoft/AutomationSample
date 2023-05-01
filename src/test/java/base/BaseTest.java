package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utils.ConfigReader;


public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void baseSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    protected LoginPage openSauceDemo() {
        driver.get(ConfigReader.getUrl());
        return new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
