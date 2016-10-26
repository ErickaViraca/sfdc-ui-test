package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This method represent to contact detail.
 */
public class ContactsDetail extends AbstractBasePage {

    @FindBy(id = "con2_ileinner")
    @CacheLookup
    private WebElement nameLabel;

    @FindBy(id = "con5_ileinner")
    @CacheLookup
    private WebElement titleLabel;

    @FindBy(id = "con6_ileinner")
    @CacheLookup
    private WebElement departmentLabel;

    @FindBy(xpath = "//input[@name='del']")
    @CacheLookup
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@name='edit']")
    @CacheLookup
    private WebElement editButton;

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String getNameLabel() {
        return getTopName().length == 3 ? getTopName()[1] : getTopName()[0];
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String getFirstNameCategoryLabel() {
        return getTopName()[0];
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String getLastNameLabel() {
        return getTopName().length == 3 ? getTopName()[2] : getTopName()[1];
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String[] getTopName() {
        return nameLabel.getText().split(" ");
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String getDepartmentLabel() {
        return departmentLabel.getText();
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public String getTitleLabel() {
        return titleLabel.getText();
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public MainApp deleteContact() {
        CommonActions.clickElement(deleteButton);
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public ContactForm clickEditContact() {
        CommonActions.clickElement(editButton);
        return new ContactForm();
    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public boolean isContactDisplayed(final String Contact) {
        WebElement contactContainer;
        try {
            contactContainer = driver.findElement(By.xpath("//span[contains(.,'" + Contact + "')]"));
        } catch (WebDriverException e) {
            return false;
        }
        return isElementPresent(contactContainer);

    }

    /**
     * This method gets name label
     *
     * @return a name label.
     */
    public boolean isElementPresent(final WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of contact edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();


        strategyMap.put("contactName", this::getNameLabel);
        strategyMap.put("firstNameCategory", this::getFirstNameCategoryLabel);
        strategyMap.put("lastName", this::getLastNameLabel);
        strategyMap.put("title", this::getTitleLabel);
        strategyMap.put("department", this::getDepartmentLabel);
        return strategyMap;
    }


}
