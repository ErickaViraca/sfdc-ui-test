package org.fundacionjala.sfdc.pages.contracts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.sfdc.pages.contracts.Contract.*;

/**
 * This class represents of the contract detail.
 */
public class ContractDetail extends DetailBase {

    @FindBy(id = "ctrc2_ileinner")
    @CacheLookup
    private WebElement contractNumberLabel;

    @FindBy(id = "ctrc7_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    @FindBy(id = "ctrc16_ileinner")
    @CacheLookup
    private WebElement customerSignedByLabel;

    @FindBy(id = "CustomerSignedTitle_ileinner")
    @CacheLookup
    private WebElement customerSignedTitleLabel;

    @FindBy(id = "ctrc6_ileinner")
    @CacheLookup
    private WebElement customerSignedDateLabel;

    @FindBy(id = "ctrc17_ileinner")
    @CacheLookup
    private WebElement priceBookLabel;

    @FindBy(id = "ctrc15_ileinner")
    @CacheLookup
    private WebElement statusLabel;

    @FindBy(id = "ctrc5_ileinner")
    @CacheLookup
    private WebElement contractStartDateLabel;

    @FindBy(id = "ctrc14_ileinner")
    @CacheLookup
    private WebElement contractEndDateLabel;

    @FindBy(id = "ctrc40_ileinner")
    @CacheLookup
    private WebElement contractTermMonthsLabel;

    @FindBy(id = "ctrc13_ileinner")
    @CacheLookup
    private WebElement ownerExpirationNoticeLabel;

    @FindBy(id = "CompanySigned_ileinner")
    @CacheLookup
    private WebElement companySignedByLabel;

    @FindBy(id = "CompanySignedDate_ileinner")
    @CacheLookup
    private WebElement companySignedDateLabel;

    /**
     * {@inheritDoc}
     */
    @Override
    public ContractForm clickEditButton() {
        CommonActions.clickElement(editBtn);
        return new ContractForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractBasePage clickDeleteButton() {
        CommonActions.clickElement(deleteBtn);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        return new ContractHome();
    }

    /**
     * This method gets the account name.
     *
     * @return a string with account name text.
     */
    public String getAccountName() {
        return accountNameLabel.getText();
    }

    /**
     * This method gets the customer signed by.
     *
     * @return a string with the customer signed by text.
     */
    public String getCustomerSignedBy() {
        return customerSignedByLabel.getText();
    }

    /**
     * This method gets the customer signed title.
     *
     * @return a string with customer signed title text.
     */
    public String getCustomerSignedTitle() {
        return customerSignedTitleLabel.getText();
    }

    /**
     * This method gets the customer signed date.
     *
     * @return a string with customer signed date text.
     */
    public String getCustomerSignedDate() {
        return customerSignedDateLabel.getText();
    }

    /**
     * This method gets the price book.
     *
     * @return a string with price book text.
     */
    public String getPriceBook() {
        return priceBookLabel.getText();
    }

    /**
     * This method gets the STATUS.
     *
     * @return a string with STATUS text.
     */
    public String getStatus() {
        return statusLabel.getText();
    }

    /**
     * This method gets the contract start date.
     *
     * @return a string with contract start date text.
     */
    public String getContractStartDate() {
        return contractStartDateLabel.getText();
    }

    /**
     * This method gets the contract end date.
     *
     * @return a string with contract end date text.
     */
    public String getContractEndDate() {
        return contractEndDateLabel.getText();
    }

    /**
     * This method gets the contract term months.
     *
     * @return a string with contract term months text.
     */
    public String getContractTermMonths() {
        return contractTermMonthsLabel.getText();
    }

    /**
     * This method gets the owner expiration notice.
     *
     * @return a string with owner expiration notice text.
     */
    public String getOwnerExpirationNotice() {
        return ownerExpirationNoticeLabel.getText();
    }

    /**
     * This method gets the company signed by.
     *
     * @return a string with company signed by text.
     */
    public String getCompanySignedBy() {
        return companySignedByLabel.getText();
    }

    /**
     * This method gets the company signed date.
     *
     * @return a string with company signed date text.
     */
    public String getCompanySignedDate() {
        return companySignedDateLabel.getText();
    }

    /**
     * This method gets the contract number.
     *
     * @return a string with contract number text.
     */
    public String getContractNumber() {
        return contractNumberLabel.getText();
    }
    /**
     * This method that verifies if the contract is displayed.
     *
     * @param contractNumber string with contract number.
     * @return true if the contract with the number sent is displayed.
     */
    public boolean isContractDisplayed(String contractNumber) {
        try {
            driver.findElement(By.linkText(contractNumber)).getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }


    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of contract edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(ACCOUNT_NAME.toString(), this::getAccountName);
        strategyMap.put(CUSTOMER_SIGNED_BY.toString(), this::getCustomerSignedBy);
        strategyMap.put(CUSTOMER_SIGNED_TITLE.toString(), this::getCustomerSignedTitle);
        strategyMap.put(CUSTOMER_SIGNED_DATE.toString(), this::getCustomerSignedDate);
        strategyMap.put(PRICE_BOOK.toString(), this::getPriceBook);
        strategyMap.put(STATUS.toString(), this::getStatus);
        strategyMap.put(CONTRACT_START_DATE.toString(), this::getContractStartDate);
        strategyMap.put(CONTRACT_TERM_MONTHS.toString(), this::getContractTermMonths);
        strategyMap.put(OWNER_EXPIRATION_NOTICE.toString(), this::getOwnerExpirationNotice);
        strategyMap.put(COMPANY_SIGNED_BY.toString(), this::getCompanySignedBy);
        strategyMap.put(COMPANY_SIGNED_DATE.toString(), this::getCompanySignedDate);
        return strategyMap;
    }

}
