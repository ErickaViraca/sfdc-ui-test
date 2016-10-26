package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainApp extends AbstractBasePage {

    @FindBy(id = "userNavButton")
    @CacheLookup
    private WebElement userBtn;

    @FindBy(css = "#recentItems tr:first-child td a")
    private WebElement userInformationLink;

    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;

    public MainApp clickUserButton() {
        CommonActions.clickElement(userBtn);
        return this;
    }

    public void clickLogout() {
        CommonActions.clickElement(logoutBtn);
    }

    public TabBar goToTabBar() {
        return new TabBar();
    }

    public UserInformationPage clickUserInformationLink() {
        CommonActions.clickElement(userInformationLink);
        return new UserInformationPage();
    }

    public void closeMainApp() {
        driver.quit();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

}
