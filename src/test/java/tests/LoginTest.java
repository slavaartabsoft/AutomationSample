package tests;

import accounts.AccountBroker;
import accounts.AccountType;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import vocabulary.Texts;

public class LoginTest extends BaseTest {

    @Test
    public void loginStandardUser() {
        openSauceDemo()
                .login()
                .checkPageIsOpened();
    }

    @Test
    public void loginLockedOutUser() {
        openSauceDemo()
                .login(AccountBroker.getAccount(AccountType.LOCKED_OUT_USER), LoginPage.class)
                .checkPageIsOpened();
        String actualErrorText = new LoginPage(driver).getErrorElementText();
        String expectedErrorText = Texts.SORRY_THIS_USER_HAS_BEEN_LOCKED_OUT;
        Assert.assertEquals(actualErrorText, expectedErrorText,
                "Text should be " + expectedErrorText + " but found " + actualErrorText);
    }

}
