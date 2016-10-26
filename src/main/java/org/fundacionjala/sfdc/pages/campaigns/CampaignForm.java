package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is in charge to manage the elements of the page.
 */
public class CampaignForm extends FormBase {

    @FindBy(id = "cpn1")
    @CacheLookup
    private WebElement campaingNameField;

    @FindBy(id = "cpn16")
    @CacheLookup
    private WebElement activeCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    private WebElement typeDropdown;

    @FindBy(id = "cpn3")
    @CacheLookup
    private WebElement statusDropdown;

    @FindBy(id = "cpn5")
    @CacheLookup
    private WebElement startDateField;

    @FindBy(id = "cpn6")
    @CacheLookup
    private WebElement endDateField;

    @FindBy(id = "Parent")
    @CacheLookup
    private WebElement parentCampaing;

    @FindBy(id = "Parent_lkwgt")
    @CacheLookup
    private WebElement lookUpIcon;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveButton;

    @FindBy(css = "a[tabindex=\"5\"]")
    @CacheLookup
    private WebElement dateLink;

    @FindBy(className = "hotListElement")
    @CacheLookup
    private WebElement allCampaigns;

    @FindBy(id = "cpn8")
    @CacheLookup
    private WebElement revenueTextField;

    /**
     * set name of the campaign.
     *
     * @param text String whit the name.
     * @return return Campaign Form.
     */
    public CampaignForm setCampaingNameField(final String text) {
        CommonActions.sendKeys(campaingNameField, text);
        return this;
    }

    /**
     * set the check Box.
     *
     * @return Campaign Form.
     */
    public CampaignForm checkActiveCheckbox() {
        CommonActions.check(activeCheckbox);
        return this;
    }

    /**
     * set the Type drop down.
     *
     * @param item String whit the value.
     * @return Campaign Form.
     */
    public CampaignForm selectTypeDropdown(final String item) {
        CommonActions.selectItem(typeDropdown, item);
        return this;
    }

    /**
     * set the status drop down.
     *
     * @param item String whit the value.
     * @return Campaign Form.
     */
    public CampaignForm selectStatusDropdown(final String item) {
        CommonActions.selectItem(statusDropdown, item);
        return this;
    }

    /**
     * set the start date of the campaign.
     *
     * @param date String whit the date.
     * @return Campaign Form.
     */
    public CampaignForm setStartDateField(final String date) {
        CommonActions.sendKeys(startDateField, date);
        return this;
    }

    /**
     * set the end date of the campaign.
     *
     * @param endDate String whit the date.
     * @return Campaign Form.
     */
    private CampaignForm setEndDateField(final String endDate) {
        CommonActions.sendKeys(endDateField, endDate);
        CommonActions.clickElement(campaingNameField);
        return this;
    }

    /**
     * click on the look up icon.
     *
     * @return Campaign Form.
     */
    public CampaignLookup clickLookUpIcon() {
        CommonActions.clickElement(lookUpIcon);
        return new CampaignLookup();
    }

    /**
     * click on save button.
     *
     * @return Campaign Form.
     */
    @Override
    public CampaignDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new CampaignDetail();
    }

    /**
     * click save/new button.
     *
     * @return abstract page.
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        return null;
    }

    /**
     * find the campaign created.
     *
     * @param campaignUpdated String whit the name of the campaign.
     * @return Boolean
     */
    public boolean campaingUpdate(final String campaignUpdated) {
        List<WebElement> campaigns = allCampaigns.findElements(By.className("dataCell"));
        return campaigns.stream().filter(x -> x.equals(campaignUpdated)).findAny().isPresent();
    }

    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();
        strategyMap.put("campaignName", () -> setCampaingNameField(String.valueOf(values.get("campaignName"))));
        strategyMap.put("active", this::checkActiveCheckbox);
        strategyMap.put("typeDropDown", () -> selectTypeDropdown(String.valueOf(values.get("typeDropDown"))));
        strategyMap.put("statusDropDown", () -> selectStatusDropdown(String.valueOf(values.get("statusDropDown"))));
        strategyMap.put("startDate", () -> setStartDateField(String.valueOf(values.get("startDate"))));
        strategyMap.put("endDate", () -> setEndDateField(String.valueOf(values.get("endDate"))));
        strategyMap.put("revenue", () -> setRevenue(String.valueOf(values.get("revenue"))));
        return strategyMap;
    }

    /**
     * set the quantity.
     *
     * @param quantity String whit the quantity.
     */
    public void setRevenue(final String quantity) {
        CommonActions.clearTextField(revenueTextField);
        CommonActions.sendKeys(revenueTextField, quantity);
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate  Map
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }


}
