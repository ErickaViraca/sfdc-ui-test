package org.fundacionjala.sfdc.pages.opportunities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.AMOUNT;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.CURRENT_CLOSE_DATE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.DELIVERY_INSTALL_STATUS;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.NEXT_STEP;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.ORDER_NUMBER;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.PRIVATE_FLAG;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.STAGE;
import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.TYPE;


/**
 * This class represent to a form to create or edit a opportunity.
 */
public class OpportunityForm extends FormBase {

    @FindBy(id = "opp2")
    @CacheLookup
    private WebElement activeFlagCheckBox;

    @FindBy(id = "opp3")
    @CacheLookup
    private WebElement opportunityNameTextField;

    @FindBy(id = "opp4")
    @CacheLookup
    private WebElement accountNameTextField;

    @FindBy(xpath = ".//*[@id='opp4_lkwgt']/img")
    @CacheLookup
    private WebElement accountNameLookupIconBtn;

    @FindBy(id = "opp5")
    @CacheLookup
    private WebElement selectTypeCheckBox;

    @FindBy(id = "opp6")
    @CacheLookup
    private WebElement selectLeadSourceCheckBox;

    @FindBy(id = "opp7")
    @CacheLookup
    private WebElement amountTextField;

    @FindBy(id = "opp9")
    @CacheLookup
    private WebElement closeDateField;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    private WebElement todayLink;

    @FindBy(id = "opp10")
    @CacheLookup
    private WebElement nextStepTextField;

    @FindBy(id = "opp11")
    @CacheLookup
    private WebElement selectStageField;

    @FindBy(id = "opp12")
    @CacheLookup
    private WebElement probabilityTextBox;

    @FindBy(id = "opp17")
    @CacheLookup
    private WebElement primaryCampaignSourceTextBox;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    private WebElement primaryCampaignSourceLookupIconBtn;

    @FindBy(xpath = "//td[contains(.,'Order Number')]/following::input")
    @CacheLookup
    private WebElement orderNumberTextBox;

    @FindBy(xpath = "//td[contains(.,'Delivery')]/following::span/select")
    @CacheLookup
    private WebElement multiSelectDeliveryInstallationStatus;

    @FindBy(id = "opp14")
    @CacheLookup
    private WebElement descriptionTextArea;

    private OpportunityBuilder opportunityBuilder;
    private Map<String, String> valuesMap;

    /**
     * Constructor that call the parent constructor.
     */
    public OpportunityForm() {
        super();
    }

    /**
     * Constructor that initialize the values.
     * @param opportunityBuilder the builder class.
     */
    private OpportunityForm(final OpportunityBuilder opportunityBuilder) {
        valuesMap = new HashMap<>();
        this.opportunityBuilder = opportunityBuilder;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public OpportunityDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new OpportunityDetail();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public OpportunityDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new OpportunityDetail();
    }

    /**
     * This method checks in.
     *
     * @param flag Boolean with flag.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm checkPrivateFlag(final boolean flag) {
        if (!CommonActions.isSelected(activeFlagCheckBox) && flag) {
            CommonActions.clickElement(activeFlagCheckBox);
        }
        return this;
    }

    /**
     * This method sets a opportunity name.
     *
     * @param opportunityName is a boolean.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setOpportunityName(final String opportunityName) {
        CommonActions.sendKeys(opportunityNameTextField, opportunityName);
        return this;
    }

    /**
     * This method sets a account name.
     *
     * @param accountName is a string name.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAccountName(final String accountName) {
        CommonActions.sendKeys(accountNameTextField, accountName);
        return this;
    }

    /**
     * This method sets a type.
     *
     * @param type is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseTypeDdl(final String type) {
        Select selectBox = new Select(selectTypeCheckBox);
        selectBox.selectByVisibleText(type);

        return this;
    }

    /**
     * This method chooses leadSource.
     *
     * @param leadSource is a string type.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseLeadSourceDdl(final String leadSource) {
        Select selectBox = new Select(selectLeadSourceCheckBox);
        selectBox.selectByVisibleText(leadSource);
        return this;
    }

    /**
     * Thid method  sets amount.
     *
     * @param amount a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setAmount(final String amount) {
        CommonActions.sendKeys(amountTextField, amount);
        return this;
    }

    /**
     * This method  sets a close date.
     *
     * @param closeDate a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCloseDate(final String closeDate) {
        CommonActions.sendKeys(closeDateField, closeDate);
        return this;
    }

    /**
     * This method sets a close date by default.
     *
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setCurrentCloseDate() {
        closeDateField.clear();
        todayLink.click();
        return this;
    }

    /**
     * This method sets next step.
     *
     * @param nextStep is a string.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setNextStep(final String nextStep) {
        nextStepTextField.clear();
        nextStepTextField.sendKeys(nextStep);
        return this;
    }

    /**
     * This method selects a stage.
     *
     * @param stage is a string to select.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseStageDdl(final String stage) {
        Select selectBox = new Select(selectStageField);
        selectBox.selectByVisibleText(stage);
        return this;
    }

    /**
     * This method sets a probability to opportunity.
     *
     * @param probability a string to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setProbability(final String probability) {
        CommonActions.sendKeys(nextStepTextField, probability);
        return this;
    }

    /**
     * This method sets a probability to opportunity.
     *
     * @param primaryCampaignSource is a string value to set.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setPrimaryCampaignSource(final String primaryCampaignSource) {
        CommonActions.sendKeys(primaryCampaignSourceTextBox, primaryCampaignSource);
        return this;
    }

    /**
     * This method is to add information.
     *
     * @param orderNumber is a string to add.
     * @return {@link OpportunityForm}
     */
    public OpportunityForm setOrderNumber(final String orderNumber) {
        orderNumberTextBox.clear();
        orderNumberTextBox.sendKeys(orderNumber);
        return this;
    }


    /**
     * This method chooses install status.
     *
     * @param deleveryInstallationStatus a string to choose.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm chooseDeliveryInstallationStatusDdl(final String deleveryInstallationStatus) {
        Select selectBox = new Select(multiSelectDeliveryInstallationStatus);
        selectBox.selectByVisibleText(deleveryInstallationStatus);
        return this;
    }

    /**
     * This method sets a description.
     *
     * @param description a string to sets.
     * @return {@link OpportunityForm}.
     */
    public OpportunityForm setDescription(final String description) {
        CommonActions.sendKeys(descriptionTextArea, description);
        return this;
    }

    /**
     * This method makes click on account name.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.clickElement(accountNameLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method marks click on primary campaingn.
     *
     * @return {@link LookUpWindow}.
     */
    public LookUpWindow clickPrimaryCampaignSrcLookUpIcon() {
        CommonActions.clickElement(primaryCampaignSourceLookupIconBtn);
        return new LookUpWindow();
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with the Json or builder map values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new ContractHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(OPPORTUNITY_NAME.getValue(), () -> setOpportunityName(values.get(OPPORTUNITY_NAME.getValue())));
        strategyMap.put(TYPE.getValue(), () -> chooseTypeDdl(values.get(TYPE.getValue())));
        strategyMap.put(LEAD_SOURCE.getValue(), () -> chooseLeadSourceDdl(values.get(LEAD_SOURCE.getValue())));
        strategyMap.put(AMOUNT.getValue(), () -> setAmount(values.get(AMOUNT.getValue())));
        strategyMap.put(NEXT_STEP.getValue(), () -> setNextStep(values.get(NEXT_STEP.getValue())));
        strategyMap.put(STAGE.getValue(), () -> chooseStageDdl(values.get(STAGE.getValue())));
        strategyMap.put(ORDER_NUMBER.getValue(), () -> setOrderNumber(values.get(ORDER_NUMBER.getValue())));
        strategyMap.put(DELIVERY_INSTALL_STATUS.getValue(),
                () -> chooseDeliveryInstallationStatusDdl(values.get(DELIVERY_INSTALL_STATUS.getValue())));
        strategyMap.put(ACCOUNT_NAME.getValue(), () -> setAccountName(values.get(ACCOUNT_NAME.getValue())));
        strategyMap.put(CURRENT_CLOSE_DATE.getValue(), () -> setCloseDate(values.get(CURRENT_CLOSE_DATE.getValue())));
        strategyMap.put(PRIVATE_FLAG.getValue(),
                () -> checkPrivateFlag(Boolean.parseBoolean(values.get(PRIVATE_FLAG.getValue()))));

        return strategyMap;
    }

    /**
     * This method fill the form in opportunity form.
     *
     * @return {@link OpportunityDetail}.
     */
    public OpportunityDetail saveOpportunity() {
        valuesMap = opportunityBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method gets a map with values builded.
     *
     * @return a map.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * Inner class that manage the values to be built.
     */
    public static class OpportunityBuilder {

        private String accountName;
        private String type;
        private String amount;
        private String opportunityName;
        private String closeDate;
        private String stage;

        private Map<String, String> strategyMap;

        /**
         * This method gets a opportunity form.
         *
         * @return {@link OpportunityForm}.
         */
        public OpportunityForm build() {
            return new OpportunityForm(this);
        }

        /**
         * This method construct builds the steps required.
         *
         * @param opportunityName  a string value to set.
         * @param currentCloseDate a string value to set.
         * @param stage            a string value to set.
         */
        public OpportunityBuilder(final String opportunityName, final String currentCloseDate,
                                  final String stage) {
            strategyMap = new HashMap<>();
            strategyMap.put(OPPORTUNITY_NAME.getValue(), opportunityName);
            strategyMap.put(CURRENT_CLOSE_DATE.getValue(), currentCloseDate);
            strategyMap.put(STAGE.getValue(), stage);
            this.opportunityName = opportunityName;
            this.closeDate = currentCloseDate;
            this.stage = stage;
        }

        /**
         * This method sets account name in opportunity.
         *
         * @param accountName a string value to set
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setAccountName(final String accountName) {
            this.accountName = accountName;
            strategyMap.put(ACCOUNT_NAME.getValue(), accountName);
            return this;
        }

        /**
         * This method sets amount in opportunity.
         *
         * @param type a string value to set.
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setType(final String type) {
            this.type = type;
            strategyMap.put(TYPE.getValue(), type);
            return this;
        }

        /**
         * This method sets amount in opportunity.
         *
         * @param amount a string value to set.
         * @return {@link OpportunityBuilder}
         */
        public OpportunityBuilder setAmount(final String amount) {
            this.amount = amount;
            strategyMap.put(AMOUNT.getValue(), amount);
            return this;
        }

        /**
         * This method set the strategyMap product.
         *
         * @return a map with values set on "opportunity" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
