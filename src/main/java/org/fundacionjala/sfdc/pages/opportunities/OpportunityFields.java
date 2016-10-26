package org.fundacionjala.sfdc.pages.opportunities;

/**
 * This enum is the fields of a opportunity.
 */
public enum OpportunityFields {
    TYPE("type"),
    LEAD_SOURCE("leadSource"),
    AMOUNT("amount"),
    NEXT_STEP("nextStep"),
    STAGE("stage"),
    ORDER_NUMBER("orderNumber"),
    DELIVERY_INSTALL_STATUS("deliveryInstallStatus"),
    ACCOUNT_NAME("ACCOUNT_NAME"),
    CURRENT_CLOSE_DATE("currentCloseDate"),
    PRIVATE_FLAG("privateFlag"),
    OPPORTUNITY_NAME("opportunityName");

    public final String value;

    /**
     * This construct sets a string to the enums.
     *
     * @param value is a string of the enum.
     */
    OpportunityFields(final String value) {
        this.value = value;
    }

}
