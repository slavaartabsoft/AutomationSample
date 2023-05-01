package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;

public class AddItemsToCartTest extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUp() {
        openSauceDemo()
                .login()
                .checkPageIsOpened();
        homePage = new HomePage(driver);
    }

    @Test
    public void addItemToCart() {
        homePage.addItemToCart(HomePage.InventoryItem.SAUCE_LABS_BOLT_T_SHIRT)
                .openCart()
                .checkItemIsPresentInCart(CartPage.CardItem.SAUCE_LABS_BOLT_T_SHIRT);
    }

}
