package org.fundacionjala.sfdc.pages.campaigns;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is in charge to manage the element of the page.
 */

public class CampaignDetail extends DetailBase {

    @FindBy(className = "pageDescription")
    @CacheLookup
    private WebElement campaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteButton;

    @FindBy(id = "cpn1_ileinner")
    @CacheLookup
    private WebElement campaignName;

    @FindBy(id = "cpn16_chkbox")
    @CacheLookup
    private WebElement checkStatus;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editButton;

    @FindBy(id = "cpn2_ileinner")
    @CacheLookup
    private WebElement typeText;

    @FindBy(id = "cpn3_ileinner")
    @CacheLookup
    private WebElement statusText;

    @FindBy(id = "cpn5_ileinner")
    @CacheLookup
    private WebElement startDate;

    @FindBy(id = "cpn6_ileinner")
    @CacheLookup
    private WebElement endDate;

    @FindBy(id = "cpn8_ileinner")
    @CacheLookup
    private WebElement revenueValue;

    /**
     * Gets the campaign label.
     *
     * @return String the name of the campaign.
     */
    public String getCampaingNameLabel() {
        return CommonActions.getText(campaingNameLabel);
    }

    /**
     * click on delete button.
     *
     * @return CampaignsHome.
     */
    public CampaignsHome clickDeleteButton() {
        CommonActions.clickElement(deleteButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return new CampaignsHome();
    }

    /**
     * get the current url.
     *
     * @return String whit the url.
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * click on the edit button.
     *
     * @return CampaignForm.
     */
    @Override
    public CampaignForm clickEditButton() {
        CommonActions.clickElement(editButton);
        return new CampaignForm();
    }

    /**
     * give us a tab bar class.
     *
     * @return TabBar class.
     */
    public TabBar toTabBar() {
        return new TabBar();
    }

    /**
     * Strategy use for the assertions.
     *
     * @return Map whit the values.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap();
        strategyMap.put("campaignName", this::getCampaignName);
        strategyMap.put("active", this::getCheckStatus);
        strategyMap.put("typeDropDown", this::getSelectedValue);
        strategyMap.put("statusDropDown", this::getSelectedStatus);
        strategyMap.put("startDate", this::getStartDate);
        strategyMap.put("endDate", this::getEndDate);
        strategyMap.put("revenue", this::getRevenauValue);
        return strategyMap;
    }

    /**
     * get revenue value.
     *
     * @return String whit the value.
     */
    private String getRevenauValue() {
        String quantity = revenueValue.getText();
        return quantity.replace(quantity.substring(0, 1), "");
    }

    /**
     * get the End date on the campaign.
     *
     * @return String whit the date.
     */
    private String getEndDate() {
        return endDate.getText();
    }

    /**
     * get the Start date on the campaign.
     *
     * @return String whit the date.
     */
    private String getStartDate() {
        return startDate.getText();
    }

    /**
     * Get the value of the status drop down list.
     *
     * @return String whit the value.
     */
    private String getSelectedStatus() {
        return statusText.getText();
    }

    /**
     * get the tipe of the campaign.
     *
     * @return String whi the type.
     */
    private String getSelectedValue() {
        return typeText.getText();
    }

    /**
     * get the estatus of the check box.
     *
     * @return String whit the status.
     */
    private String getCheckStatus() {
        return checkStatus.getAttribute("title");
    }

    /**
     * get the campaign name.
     *
     * @return String whit the name of the campaign.
     */
    public String getCampaignName() {
        String value = campaignName.getText();
        return value.substring(0, value.indexOf(" "));
    }
}
