package org.fundacionjala.sfdc.tests.campaign;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertFalse;

/**
 * This class is in charge to Eliminate a campaign.
 */
public class DeleteCampaign {
    private CampaignDetail campaignDetail;
    private CampaignsHome campaignsHome;
    private Map<String, String> valuesMapJson;
    private JsonMapper jsonMapper;
    public static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";

    /**
     * Setup de test creating a campaign.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        campaignsHome = tabBar.clickCampaigns();
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
    }

    /**
     * Eliminate the campaign and do the test.
     */
    @Test()
    public void deleteCampaign() {
        campaignsHome = campaignDetail.clickDeleteButton();
        assertFalse(campaignsHome.existCampaign(valuesMapJson.get("campaignName")));
    }

}
