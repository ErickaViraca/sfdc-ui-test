package org.fundacionjala.sfdc.tests.campaign;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.pages.lookup.CampaignLookup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Random;

/**
 * Create a campaign using a builder and Json File.
 */
public class CreateCampaign {

    private CampaignsHome campaignsHome;
    private CampaignForm campaignForm;
    private CampaignLookup lookUpWindow;
    private CampaignDetail campaignDetail;
    private String campaignParent;
    private JsonMapper jsonMapper;
    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";
    private Map<String, String> valuesMapJson;

    /**
     * Setup the Test crating a Parent campaign for a test.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = jsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        campaignParent = "Parent" + new Random().nextInt(9999);
        campaignsHome = tabBar.clickCampaigns();
        campaignForm = campaignsHome
                .clickNewButton();
        campaignDetail = campaignForm
                .setCampaingNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();
        tabBar = campaignDetail.toTabBar();
        campaignsHome = tabBar.clickCampaigns();
    }

    /**
     * Create a campaign using  a Json file.
     */
    @Test()
    public void createCampaingWhithJason() {
        campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        lookUpWindow = campaignForm.clickLookUpIcon();
        campaignForm = lookUpWindow.selectCampaignWithNameByScope(campaignParent, CampaignLookup.ALL_CAMPAIGN);
        campaignDetail = campaignForm.clickSaveButton();
        AssertCampaign.assertDetailValues(campaignDetail, valuesMapJson);
    }

    /**
     * create a campaign using the Builder pattern.
     */
    @Test()
    public void createCampaign() {
        campaignsHome.clickNewButton();
        Campaigns campaigns = new Campaigns.ProductBuilder("builderTest")
                .setTypeDropDown("Email")
                .setStatusDropDown("In Progress")
                .setStartDate("10/25/2015")
                .setEndDate("10/27/2015")
                .setRevenue("1,000")
                .build();
        campaignDetail = campaigns.createCampaign();
        AssertCampaign.assertDetailValues(campaignDetail, campaigns.getValuesMap());
    }

    /**
     * Eliminate the campaign created.
     */
    @AfterMethod()
    public void tearDown() {
        campaignsHome = campaignDetail.clickDeleteButton();


    }
}
