package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;
import timeouts.Timeouts;

public class HomePage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement shoppingCart;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage checkPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Timeouts.PAGE_LOAD_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        return this;
    }
}
