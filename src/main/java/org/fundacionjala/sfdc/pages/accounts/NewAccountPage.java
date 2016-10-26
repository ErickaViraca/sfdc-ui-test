package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ivan on 30-06-15.
 */
public class NewAccountPage extends AbstractBasePage {

    //region Locators
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTextbox;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;
    //endregion

    public NewAccountPage setAccountName(String accountName) {
        accountNameTextbox.clear();
        accountNameTextbox.sendKeys(accountName);

        return this;
    }

    public AccountProfile pressSaveBtn() {
        saveBtn.click();

        return new AccountProfile();
    }
}
