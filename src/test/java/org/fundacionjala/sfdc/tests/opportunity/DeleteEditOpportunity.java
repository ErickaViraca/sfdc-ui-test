package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;

import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;

import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;

/**
 * This class is a test to edit and delete of a opportunity.
 */
public class DeleteEditOpportunity {

    private static final String OPPORTUNITY_DATA_EDIT_PATH = "opportunity/EditOpportunityData.json";
    private TabBar tabBar;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private AccountHome accountsHome;
    private AccountDetail accountDetail;
    private MainApp mainApp;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to edit and delete a opportunity.
     */
    @BeforeMethod
    public void BeforeTest() {
        valuesMapJson = JsonMapper.getMapJson(CreateOpportunity.OPPORTUNITY_DATA_PATH);
        mainApp = new MainApp();

        tabBar = mainApp.goToTabBar();

        accountsHome = tabBar.clickOnAccountsHome();
        AccountForm accountForm = accountsHome.clickNewButton();
        accountDetail = accountForm
                .setAccountName(valuesMapJson.get(ACCOUNT_NAME.getValue()))
                .clickSaveButton();

        OpportunityHome opportunityHome = tabBar.clickOnOpportunitiesHome();
        opportunityForm = opportunityHome.clickNewButton();

        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();
    }

    /**
     * This a test to delete a opportunities
     */
    @Test
    public void DeleteOpportunity() {
        opportunityDetail.clickDeleteButton();
        Assert.assertFalse(opportunityDetail.isOpportunityDisplayed(valuesMapJson.get(OPPORTUNITY_NAME.getValue())));
    }

    /**
     * This is a test to edit a opportunities
     */
    @Test
    public void EditOpportunity() {
        opportunityForm = opportunityDetail.clickEditButton();
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);

        opportunityForm.fillTheForm(valuesMapEditJson);
        opportunityDetail = opportunityForm.clickSaveButton();
        AssertOpportunity.assertDetailValues(opportunityDetail, valuesMapEditJson);
    }

    /**
     * This is a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {
        tabBar = mainApp.goToTabBar();
        accountsHome = tabBar.clickOnAccountsHome();
        accountDetail = accountsHome.clickOnAccount(valuesMapJson.get(ACCOUNT_NAME.getValue()));
        mainApp = accountDetail.clickDeleteButton();

    }

}
