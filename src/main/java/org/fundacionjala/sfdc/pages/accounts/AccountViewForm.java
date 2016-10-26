package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class AccountViewForm extends FormBase {
    @FindBy(id = "fname")
    @CacheLookup
    private WebElement viewNameText;

    @FindBy(id = "devname")
    @CacheLookup
    private WebElement viewUniqueNameText;

    @FindBy(id = "fcol1")
    @CacheLookup
    private WebElement filterAccountName;

    @FindBy(id = "fop1")
    @CacheLookup
    private WebElement filterAccountOption;

    @FindBy(id = "fval1")
    @CacheLookup
    private WebElement filterAccountValue;

    @FindBy(id = "fscope1")
    @CacheLookup
    private WebElement myAccountsRadioButton;

    @FindBy(id = "colselector_select_0")
    @CacheLookup
    private WebElement availableFields;

    @FindBy(id = "colselector_select_1")
    @CacheLookup
    private WebElement selectedFields;


    public AccountViewForm setViewNameText(String viewName) {
        viewNameText.sendKeys(viewName);
        return this;
    }

    public AccountViewForm setViewUniqueNameText(String uniqueName) {
        viewUniqueNameText.sendKeys(uniqueName);
        return this;
    }

    public AccountViewForm setMyAccounts() {
        myAccountsRadioButton.click();
        return this;
    }

    @Override
    public AbstractBasePage clickSaveButton() {
        return null;
    }

    @Override
    public AbstractBasePage clickSaveNewButton() {
        return null;
    }
}
