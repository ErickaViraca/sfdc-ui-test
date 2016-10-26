package org.fundacionjala.sfdc.tests.contact;

import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactForm;
import org.fundacionjala.sfdc.pages.contacts.ContactHome;
import org.fundacionjala.sfdc.pages.contacts.ContactsDetail;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.contact.CreateContact.CONTACT_DATA_PATH;


/**
 * This method is a preconditions to edit and delete a contact.
 */
public class DeleteEditContact {

    private static final String CONTACT_DATA_EDIT_PATH = "contact/CreateContactData.json";
    private static final String COLON = ", ";
    private ContactsDetail contactsDetail;
    private ContactForm contactForm;
    private Map<String, String> valuesMapJson;

    /**
     * This method is a preconditions to edit and delete a contact.
     */
    @BeforeMethod
    public void login() {
        valuesMapJson = JsonMapper.getMapJson(CONTACT_DATA_PATH);
        final MainApp mainApp = new MainApp();
        TabBar tabBar = mainApp.goToTabBar();
        ContactHome contactsHome = tabBar.clickOnContactsHome();

        contactForm = contactsHome.clickPostLnk();
        contactForm.fillTheForm(valuesMapJson);
        contactsDetail = contactForm.clickSaveButton();
    }

    /**
     * This method is to edit a contact.
     */
    @Test
    public void EditContact() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CONTACT_DATA_EDIT_PATH);
        contactForm = contactsDetail.clickEditContact();
        contactForm.fillTheForm(valuesMapEditJson);
        contactsDetail = contactForm.clickSaveButton();
        new AssertContact().assertDetailValues(contactsDetail, valuesMapEditJson);
        contactsDetail.deleteContact();
    }

    /**
     * This method is to delete a contact.
     */
    @Test
    public void DeleteContact() {
        contactsDetail.deleteContact();
        Assert.assertFalse(contactsDetail.isContactDisplayed(valuesMapJson.get("lastName")
                .concat(COLON).concat(valuesMapJson.get("contactName"))));
    }

}