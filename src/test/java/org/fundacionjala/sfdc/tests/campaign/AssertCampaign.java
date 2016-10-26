package org.fundacionjala.sfdc.tests.campaign;

import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.junit.Assert;

import java.util.Map;

/**
 * Created by AlvaroDaza on 10/25/2016.
 */
public class AssertCampaign {

    private AssertCampaign() {
    }

    static void assertDetailValues(CampaignDetail campaignDetail, Map<String, String> valuesMapJson) {
        valuesMapJson.keySet()
                .forEach(value -> Assert.assertEquals(campaignDetail.getStrategyAssertMap().get(value).getText(),
                        valuesMapJson.get(value)));
    }
}
