package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class is a test to create a opportunity
 */
public class CreateContact {


    static final String CONTACT_DATA_PATH = "contact/CreateContactData.json";
    private ContactHome contactsHome;
    private ContactsDetail contactsDetail;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to create a contact.
     */
    @BeforeMethod
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
    }

    /**
     * This a test to create a contact.
     */
    @Test
    public void createContact() {
        ContactForm contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapJson);
    }

    /**
     * This is a post conditions of a contact.
     */
    @AfterMethod
    public void afterTest() {
        contactsDetail.deleteContact();
    }

}