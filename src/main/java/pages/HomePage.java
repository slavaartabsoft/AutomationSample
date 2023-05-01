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

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement backpackAddToCartButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-bike-light']")
    private WebElement bikeLightAddToCartButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement boltTShirtAddToCartButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement fleeceJacketAddToCartButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart-sauce-labs-onesie']")
    private WebElement onesieAddToCartButton;

    @FindBy(xpath = "//button[@data-test='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement tShirtRedAddToCartButton;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement shoppingCartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage checkPageIsOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Timeouts.PAGE_LOAD_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        return this;
    }

    public HomePage addItemToCart(InventoryItem item) {
        WebElement addToCartButton = getInventoryItem(item);
        addToCartButton.click();
        return this;
    }

    public CartPage openCart() {
        shoppingCart.click();
        return new CartPage(driver);
    }

    private WebElement getInventoryItem(InventoryItem item) {
        switch (item) {
            case SAUCE_LABS_BACKPACK:
                return backpackAddToCartButton;
            case SAUCE_LABS_BIKE_LIGHT:
                return bikeLightAddToCartButton;
            case SAUCE_LABS_BOLT_T_SHIRT:
                return boltTShirtAddToCartButton;
            case SAUCE_LABS_FLEECE_JACKET:
                return fleeceJacketAddToCartButton;
            case SAUCE_LABS_ONESIE:
                return onesieAddToCartButton;
            case T_SHIRT_RED:
                return tShirtRedAddToCartButton;
            default:
                throw new IllegalArgumentException("Unknown item: " + item);
        }
    }

    public enum InventoryItem {
        SAUCE_LABS_BACKPACK,
        SAUCE_LABS_BIKE_LIGHT,
        SAUCE_LABS_BOLT_T_SHIRT,
        SAUCE_LABS_FLEECE_JACKET,
        SAUCE_LABS_ONESIE,
        T_SHIRT_RED;
    }
}
