package org.fundacionjala.sfdc.unittest.contact;


import org.fundacionjala.sfdc.pages.contacts.ContactsAbstractPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.TabBar;
import org.fundacionjala.sfdc.pages.contacts.ContactsProfile;
import org.fundacionjala.sfdc.pages.contacts.NewContactForm;
import org.fundacionjala.sfdc.pages.lookup.LookUpWindow;

/**
 * Created by Ruber Cuellar
 */
public class CreateContact {


    private ContactsAbstractPage contactsHome;
    private LookUpWindow lookUpWindow;
    private MainApp mainApp;
    private TabBar tabBar;
    private ContactsProfile contactsProfile;
    private NewContactForm newContactForm;
    private LoginPage loginPage;
    private String firstNameCategory = "Prof.";
    private String contactName = "Test122";
    private String lastName = "lastName22";
    private String title = "title22";
    private String department = "department22";

    @BeforeTest
    public void login() {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        contactsHome = tabBar.clickOnContactsHome();
    }

    @Test
    public void createChatterPostTest(){
        newContactForm = contactsHome.clickPostLnk();
        newContactForm.selectFirstNameCategory(firstNameCategory)
                .setContactNameField(contactName)
                .setLastName(lastName)
                .setTitle(title)
                .setDepartment(title);

        contactsProfile = newContactForm.clickSaveButton();

        String contactNameLabel = contactsProfile.getContactNameLabel();
        Assert.assertEquals(contactNameLabel, firstNameCategory + " " + contactName + " " + lastName);
        contactsProfile.getContactNameLabel();

    }

    @AfterMethod
    public void afterTest() {
        contactsProfile.deleteContact();

    }

}