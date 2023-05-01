package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.base.BasePage;
import timeouts.Timeouts;

import java.util.List;

public class CartPage extends BasePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[text()='Your Cart']")
    private WebElement cartPageTitle;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> inventoryItemNames;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Override
    public CartPage checkPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Timeouts.PAGE_LOAD_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(cartPageTitle));
        return this;
    }

    public CartPage checkItemIsPresentInCart(CardItem item) {
        Assert.assertTrue(inventoryItemNames.size() > 0,
                "Inventory item names should contain elements");
        for (WebElement itemName : inventoryItemNames) {
            if (itemName.getText().equals(item.getName())) {
                return this;
            }
        }
        throw new AssertionError("No item with name " + item.getName() + " was found in the cart");
    }

    public enum CardItem {
        SAUCE_LABS_BACKPACK("Sauce Labs Backpack"),
        SAUCE_LABS_BIKE_LIGHT("Sauce Labs Bike Light"),
        SAUCE_LABS_BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt"),
        SAUCE_LABS_FLEECE_JACKET("Sauce Labs Fleece Jacket"),
        SAUCE_LABS_ONESIE("Sauce Labs Onesie"),
        T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)");

        private String name;

        CardItem(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
