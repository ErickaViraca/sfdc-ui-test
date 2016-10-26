package org.fundacionjala.sfdc.tests.campaign;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

/**
 * Update a campaign created.
 */
public class UpdateCampaign {

    private CampaignDetail campaignDetail;
    private CampaignForm campaignForm;
    private static final String CAMPAIGN_UPDATE_CAMPAIGN_DATA = "campaign/UpdateCampaignData.json";
    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";
    private CampaignsHome campaignsHome;
    private JsonMapper jsonMapper;

    /**
     * Setup the Campaign that will be updated.
     */
    @BeforeMethod()
    public void setup() {

        Map<String, String> valuesMapJson = jsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        campaignsHome = tabBar.clickCampaigns();
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
    }

    /**
     * Update a Campaign using a Json file.
     */
    @Test()
    public void updateCampaignWithJson() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CAMPAIGN_UPDATE_CAMPAIGN_DATA);
        campaignForm = campaignDetail.clickEditButton();
       campaignForm.fillTheForm(valuesMapEditJson);
       campaignDetail = campaignForm.clickSaveButton();
        AssertCampaign.assertDetailValues(campaignDetail, valuesMapEditJson);
   }

    /**
     * Update a Campaign using the Builder Pattern.
     */
    @Test()
    public void editProduct() {

       campaignForm=campaignDetail.clickEditButton();
        Campaigns campaigns= new Campaigns.ProductBuilder("UpdatedWhitBuilder")
                .setTypeDropDown("Direct Mail")
                .setStatusDropDown("Completed")
                .build();
        campaignDetail = campaigns.createCampaign();
       AssertCampaign.assertDetailValues(campaignDetail, campaigns.getValuesMap());
    }

    /**
     * Delete the campaign crated.
     */
    @AfterMethod()
    public void afterTest() {
        campaignsHome = campaignDetail.clickDeleteButton();
    }

}
