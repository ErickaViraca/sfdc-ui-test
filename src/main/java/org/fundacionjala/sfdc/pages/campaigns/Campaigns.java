package org.fundacionjala.sfdc.pages.campaigns;

import java.util.HashMap;
import java.util.Map;

/**
 * The builder Pattern.
 */
public class Campaigns {

    private Campaigns.ProductBuilder productBuilder;

    private Map<String, String> valuesMap;

    /**
     * constructor.
     *
     * @param productBuilder Product Builder.
     */
    public Campaigns(final Campaigns.ProductBuilder productBuilder) {
        valuesMap = new HashMap<>();
        this.productBuilder = productBuilder;
    }

    /**
     * create  the campaign.
     *
     * @return campaign Form.
     */
    public CampaignDetail createCampaign() {
        CampaignForm campaignForm = new CampaignForm();
        valuesMap = productBuilder.getStrategyMap();
        campaignForm.fillTheForm(valuesMap);
        return campaignForm.clickSaveButton();
    }

    /**
     * get the value map.
     *
     * @return Map whit the values.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * builder Pattern.
     */
    public static class ProductBuilder {

        private String name;
        private String typeDropDown;
        private String statusDropDown;
        private String startDate;
        private String endDate;
        private String revenue;

        private Map<String, String> strategyMap;

        /**
         * build the campaign.
         *
         * @return Campaign.
         */
        public Campaigns build() {
            return new Campaigns(this);
        }

        /**
         * constructor.
         *
         * @param name String the name of the campaign.
         */
        public ProductBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put("campaignName", name);
            this.name = name;
        }

        /**
         * set the start date.
         *
         * @param startDate String whit the date.
         * @return campaign builder
         */
        public Campaigns.ProductBuilder setStartDate(final String startDate) {
            strategyMap.put("startDate", startDate);
            this.startDate = startDate;
            return this;
        }

        /**
         * set the  type drop down list.
         *
         * @param typeDropDown String whit the value.
         * @return campaign builder.
         */
        public Campaigns.ProductBuilder setTypeDropDown(final String typeDropDown) {
            strategyMap.put("typeDropDown", typeDropDown);
            this.typeDropDown = typeDropDown;
            return this;
        }

        /**
         * set the  status drop down list.
         *
         * @param statusDropDown String whit the value.
         * @return campaign builder.
         */
        public Campaigns.ProductBuilder setStatusDropDown(final String statusDropDown) {
            strategyMap.put("statusDropDown", statusDropDown);
            this.statusDropDown = statusDropDown;
            return this;
        }

        /**
         * set the revenau value.
         *
         * @param revenue String whit the value.
         * @return campaign builder.
         */
        public Campaigns.ProductBuilder setRevenue(final String revenue) {
            strategyMap.put("revenue", revenue);
            this.revenue = revenue;
            return this;
        }

        /**
         * set the end date.
         *
         * @param endDate String whi the date.
         * @return campaign builder.
         */
        public Campaigns.ProductBuilder setEndDate(final String endDate) {
            strategyMap.put("endDate", endDate);
            this.endDate = endDate;
            return this;
        }

        /**
         * get the strategy map.
         *
         * @return Map whit the values.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }


}
