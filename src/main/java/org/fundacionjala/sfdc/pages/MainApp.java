package org.fundacionjala.sfdc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

public class MainApp extends AbstractBasePage{

    @FindBy(id = "userNavButton")
    @CacheLookup
    private WebElement userBtn;
    
    
    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;

    public MainApp clickUserButton(){
    	CommonActions.clickElement(userBtn);
    	return this;
    }
    
    public void clickLogout () {
    	CommonActions.clickElement(logoutBtn);
    }
    
   public TabBar goToTabBar() {
	   return new TabBar();
   }
   
   public void closeMainApp() {
   		driver.quit();      
   }
}