package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class AccountAbstractPage extends AbstractBasePage {


    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    private WebElement newButton;


    public NewAccountPage clickNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(newButton));
        newButton.click();
        return new NewAccountPage();
    }

    public AccountProfile clickOnAccount(String accountName) {

        return new AccountProfile();
    }
}
