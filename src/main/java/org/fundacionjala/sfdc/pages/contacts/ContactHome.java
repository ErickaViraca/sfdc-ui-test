package org.fundacionjala.sfdc.pages.contacts;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class represents to contact pages.
 */
public class ContactHome extends AbstractBasePage {

    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    private WebElement newButton;

    /**
     * This method makes click in post link.
     *
     * @return {@link ContactForm}.
     */
    public ContactForm clickPostLnk() {
        CommonActions.clickElement(newButton);
        return new ContactForm();
    }

}
