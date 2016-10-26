package org.fundacionjala.sfdc.tests.account;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Created by erickaviraca on 10/24/2016.
 */
public class EditAccount {
    /**
     * This test is to edit  an account.
     */
    private AccountHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private AccountDetail accountDetail;
    private AccountForm accountForm;

    public static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    public static final String ACCOUNT_DATA_EDIT_PATH = "account/EditAccountData.json";
    private Map<String, String> valuesMapJson;
    private Map<String, String> valuesMapEditJson;

    @BeforeMethod
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickOnAccountsHome();
        accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(accountDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }

    @Test
    public void EditAccount() {
        accountForm = accountDetail.clickEditButton();
        valuesMapEditJson = JsonMapper.getMapJson(ACCOUNT_DATA_EDIT_PATH);
        accountForm.fillTheForm(valuesMapEditJson);
        accountDetail = accountForm.clickSaveButton();
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(accountDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapEditJson.get(value)));
    }


    @AfterMethod
    public void afterTest() {
        accountDetail.clickDeleteButton();
        mainApp.clickUserButton().clickLogout();
    }
}
