package org.fundacionjala.sfdc.tests.contract;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.pages.products.ProductForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.fundacionjala.sfdc.pages.contracts.Contract.ACCOUNT_NAME;

/**
 * This class handle create a new contract.
 */
public class CreateContract {

    private static final String CONTRACT_DATA_PATH = "contract/CreateContractData.json";

    private static final String STATUS = "Draft";

    private static final String CONTRACT_START_DATE = "10/31/2016";

    private static final String CONTRACT_TERM_MONTHS = "1";

    private static final String DESCRIPTION_TEST = "description test";

    private ContractForm contractForm;

    private AccountForm accountForm;

    private Map<String, String> valuesMapJson;

    private ContractDetail contractDetail;

    private AccountDetail accountDetail;
    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CONTRACT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        final TabBar tabBar = mainApp.goToTabBar();
        Map<String, String> valuesMapAccount = new HashMap<>();
        valuesMapAccount.put("accountName", valuesMapJson.get(ACCOUNT_NAME.toString()));

        final AccountHome accountHome = tabBar.clickOnAccountsHome();
        accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapAccount);
        accountForm.clickSaveButton();

        final ContractHome contractHome = tabBar.clickOnContractHome();
        contractForm = contractHome.clickNewButton();
    }

    /**
     * This method that is created a new contract with json.
     */
    @Test
    public void createContractWithJson() {
        contractForm.fillTheForm(valuesMapJson);
        contractDetail = contractForm.clickSaveButton();
        AssertContract.assertDetailValues(contractDetail, valuesMapJson);
    }

    /**
     * This method that is created a new product.
     */
    @Test
    public void createContract() {
        contractForm = new ContractForm.ContractBuilder(valuesMapJson.get(ACCOUNT_NAME.toString()), STATUS, CONTRACT_START_DATE, CONTRACT_TERM_MONTHS)
                .build();
        contractDetail = contractForm.saveContract();
        AssertContract.assertDetailValues(contractDetail, contractForm.getValuesMap());
    }

    /**
     * This method is executed after scenario.
     */
    @AfterMethod
    public void tearDown() {
        contractDetail.clickDeleteButton();
        accountDetail.clickDeleteButton();
    }
}