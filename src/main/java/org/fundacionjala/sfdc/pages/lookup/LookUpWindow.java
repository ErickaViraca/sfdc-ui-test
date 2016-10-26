package org.fundacionjala.sfdc.pages.lookup;


import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class LookUpWindow extends ModalWindow {


    @FindBy(xpath = "//div[@class='pBody']/select")
    @CacheLookup
    WebElement SearchWithinDropdown;

    @FindBy(xpath = "//div[@class='pBody']/input[@type='text']")
    @CacheLookup
    WebElement SearchField;

    @FindBy(xpath = "//div[@class='pBody']/input[@class='btn' and @type='submit']")
    @CacheLookup
    WebElement GoButton;

    @FindBy(className = "dataRow even last first")
    @CacheLookup
    WebElement RowsContaine;


    @FindBy(id = "searchFrame")
    @CacheLookup
    WebElement SearchFrame;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    WebElement SearchResultFrame;
    //endregion

    public LookUpWindow selectSearchWithinDropdown(String item) {
        CommonActions.selectItem(SearchWithinDropdown, item);

        return this;
    }

    public LookUpWindow setSearchWithinField(String text) {
        CommonActions.sendKeys(SearchField, text);
        return this;
    }

    public LookUpWindow clickGoButton() {
        CommonActions.clickElement(GoButton);

        return this;
    }

    public CampaignForm clickResult(String text) {
        CommonActions.clickElement(RowsContaine.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();

        return new CampaignForm();
    }

    public OpportunityForm clickResultGotoNewOpportunityForm(String text) {
        CommonActions.clickElement(RowsContaine.findElement(By.xpath("//a[contains(.,'" + text + "')]")));
        driver.switchTo().defaultContent();

        return new OpportunityForm();
    }

    public LookUpWindow switchSearchFrame() {
        driver.switchTo().frame(SearchFrame);
        return this;
    }

    public LookUpWindow switchResultsFrame() {
        driver.switchTo().frame(SearchResultFrame);
        return this;
    }


}
