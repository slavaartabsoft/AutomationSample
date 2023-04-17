package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginStandardUser() {
        openSauceDemo()
                .login()
                .checkPageIsOpened();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
