package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

/**
 * this class content all the Account data.
 */
public class AccountDetail extends DetailBase {

    // Account fields
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountName;
    @FindBy(id = "acc23_ileinner")
    @CacheLookup
    private WebElement accountSite;
    @FindBy(id = "acc10_ileinner")
    @CacheLookup
    private WebElement accountPhone;
    @FindBy(id = "acc12_ileinner")
    @CacheLookup
    private WebElement accountWebsite;
    @FindBy(id = "acc15_ileinner")
    @CacheLookup
    private WebElement accountEmployees;
    @FindBy(name = "delete")
    @CacheLookup
    protected WebElement deleteButton;

    /**
     * {@link DetailBase}
     */
    @Override
    public AccountForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new AccountForm();
    }

    /**
     * Deletes the account.
     *
     * @return a new MainApp
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return new MainApp();
    }

    /**
     * Returns the current Url.
     *
     * @return Url
     */
    public String getUrl(){
        return driver.getCurrentUrl();
    }

    /**
     * Returns the account name.
     *
     * @return String with account name
     */
    public String getAccountName() {
        return accountName.getText().substring(0,accountName.getText().indexOf("[")-1);
    }

    /**
     * Returns the account site.
     *
     * @return String with account site
     */
    public String getAccountSite() {
        return accountSite.getText();
    }

    /**
     * Returns the account phone.
     *
     * @return String with account phone
     */
    public String getAccountPhone() {
        return accountPhone.getText();
    }

    /**
     * Returns the account website.
     *
     * @return String with account website
     */
    public String getAccountWebsite() {
        return accountWebsite.getText();
    }

    /**
     * Returns the account employees.
     *
     * @return String with account employees
     */
    public String getAccountEmployees() {
        return accountEmployees.getText();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of opportunity edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();

        strategyMap.put("accountName", this::getAccountName);
        strategyMap.put("accountSite", this::getAccountSite);
        strategyMap.put("accountPhone", this::getAccountPhone);
        strategyMap.put("accountWebsite", this::getAccountWebsite);
        strategyMap.put("accountEmployees", this::getAccountEmployees);

        return strategyMap;
    }

    /**
     * This method verify that account is displayed.
     *
     * @param account String with account.
     * @return returns <code>true<code/> if account is displayed or <code>false<code/> if it is not .
     */
    public boolean isAccountDisplayed(String account) {
        WebElement contactContainer;
        try {
            contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + account + "')]"));
        } catch (WebDriverException e) {
            return false;
        }
        return isElementPresent(contactContainer);

    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

}