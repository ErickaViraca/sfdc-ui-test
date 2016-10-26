package org.fundacionjala.sfdc.pages.leads;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.HomeBase;

/**
 * This class holds leads home page elements and inherits from FormBasePage the basic button "new".
 */

public class LeadHome extends HomeBase {

    /**
     * {@link HomeBase}
     */
    @Override
    public LeadForm clickNewButton() {
        CommonActions.clickElement(newButton);
        return new LeadForm();
    }
    public boolean isLeadDisplayed(String lead) {
        try {
            String leadContainer = driver.findElement(By.linkText(lead)).getText();
            return true;
        } catch(WebDriverException e) {
            return false;
        }
    }
    @Override
    public AbstractBasePage clickCreateNewViewLink() {
        return null;
    }

    @Override
    public AbstractBasePage clickEditViewLink() {
        return null;
    }

}
