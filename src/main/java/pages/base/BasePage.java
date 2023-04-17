package pages.base;

public abstract class BasePage {
    public abstract <T extends BasePage> T checkPageIsOpened();
}
