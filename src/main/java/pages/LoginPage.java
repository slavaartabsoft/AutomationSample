package pages;

import accounts.Account;
import accounts.AccountBroker;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import timeouts.Timeouts;


public class LoginPage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@data-test='username']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@data-test='login-button']")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorTextElement;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage enterUserName(String userName) {
        loginInput.sendKeys(userName);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        loginButton.click();
        return this;
    }

    //TODO add commentaries about how it works
    public HomePage login() {
        return login(AccountBroker.getStandardUser(), HomePage.class);
    }

    public <T extends BasePage> T login(Account account, Class<T> expectedPage) {
        enterUserName(account.getUsername());
        enterPassword(account.getPassword());
        clickLogin();
        return PageFactory.initElements(driver, expectedPage);
    }

    public LoginPage checkPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Timeouts.PAGE_LOAD_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public String getErrorElementText() {
       return errorTextElement.getText();
    }
}
