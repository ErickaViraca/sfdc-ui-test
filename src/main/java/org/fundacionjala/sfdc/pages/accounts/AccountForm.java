package org.fundacionjala.sfdc.pages.accounts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * It is the account base page, abstract class.
 *
 * {@link FormBase}
 */
public class AccountForm extends FormBase {

    //account form fields
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTextbox;
    @FindBy(id = "acc23")
    @CacheLookup
    private WebElement accountSiteTextbox;
    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement accountPhoneTextbox;
    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement accountWebsiteTextbox;
    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement accountEmployeesTextbox;

    /**
     * {@link FormBase}
     */
    @Override
    public AccountDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new AccountDetail();
    }

    /**
     * {@link FormBase}
     */
    @Override
    public AccountDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new AccountDetail();
    }


    /**
     * This method set the account name in the text field.
     *
     * @param accountName String with the account name.
     * @return Return this class.
     */
    public AccountForm setAccountName(String accountName) {
        CommonActions.sendKeys(accountNameTextbox, accountName);
        return this;
    }

    /**
     * This method set the account site in the text field.
     *
     * @param accountSite String with the site account name.
     * @return Return this class.
     */
    public AccountForm setAccountSite(String accountSite) {
        CommonActions.sendKeys(accountSiteTextbox, accountSite);
        return this;
    }

    /**
     * This method set the account phone in the text field.
     *
     * @param accountPhone String with the site account name.
     * @return Return this class.
     */
    public AccountForm setAccountPhone(String accountPhone) {
        CommonActions.sendKeys(accountPhoneTextbox, accountPhone);
        return this;
    }

    /**
     * This method set the account website in the text field.
     *
     * @param accountWebsite String with the site account name.
     * @return Return this class.
     */
    public AccountForm setAccountWebsite(String accountWebsite) {
        CommonActions.sendKeys(accountWebsiteTextbox, accountWebsite);
        return this;
    }

    /**
     * This method set the account employees in the text field.
     *
     * @param accountEmployees String with the site account name.
     * @return Return this class.
     */
    public AccountForm setAccountEmployees(String accountEmployees) {
        CommonActions.sendKeys(accountEmployeesTextbox, accountEmployees);
        return this;
    }

    /**
     * Method that to permit set values to create a new AccountHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the account created.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("accountName", () -> setAccountName(String.valueOf(values.get("accountName"))));
        strategyMap.put("accountSite", () -> setAccountSite(String.valueOf(values.get("accountSite"))));
        strategyMap.put("accountPhone", () -> setAccountPhone(String.valueOf(values.get("accountPhone"))));
        strategyMap.put("accountWebsite", () -> setAccountWebsite(String.valueOf(values.get("accountWebsite"))));
        strategyMap.put("accountEmployees", () -> setAccountEmployees(String.valueOf(values.get("accountEmployees"))));
        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
